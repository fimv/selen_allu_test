package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.AutoTestException;
import util.PropertyManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static ChromeDriver chromeDriver;

    public BasePage() {
        initWebDriver();
        PageFactory.initElements(chromeDriver, this);
    }

    public ChromeDriver getChromeDriver() {
        return chromeDriver;
    }

    private void initWebDriver() {
        if (chromeDriver == null) {
        	//getInstance().
        	File chromeDriverFile = new File(PropertyManager.getInstance().getDriverPath());
            System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
            chromeDriver = new ChromeDriver();
        }
    }

    @Step("��������� �� �������� �� ������ {0}")
    public void goTo(String url) {
        chromeDriver.manage().window().maximize();
        chromeDriver.get(url);

    }

    @Step("��������� ���������� �� ����������� ������� �� ��������")
    public void checkElementOnPage(By by) {
        chromeDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(chromeDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        try {
            Assert.assertTrue("�������" + by + " ����������� �� ��������", chromeDriver.findElement(by).isDisplayed());
        } catch (StaleElementReferenceException e) {
            throw new AutoTestException("������ ������� �� ��� ������ �� ��������" + by);
        }
    }

    @Step("��������� ���������� �� ����������� ������� �� ��������")
    public void checkElementOnPage(WebElement webElement) {
        chromeDriver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(35, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(chromeDriver, 35);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            Assert.assertTrue("�������" + webElement + " ����������� �� ��������", webElement.isDisplayed());
        } catch (StaleElementReferenceException e) {
            throw new AutoTestException("������� �� ��������� �� �������� " + webElement);
        }
    }

    @Step("������ �������� �������� ")
    public String makeScreenShot() {
        File screenshot = ((TakesScreenshot) chromeDriver).
                getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/" + screenshot.getName();
        try {
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException e) {
            throw new AutoTestException("���������� ������� �������� ������");
        }
        return path;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] attachScreenShot(String path) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(path));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage, "png", baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }

    @Step("���������, ��� �������� ��� ������� �� ������������")
    public void checkIsInvisible(By by) {
        try {
            new WebDriverWait(getChromeDriver(), 10)
                    .until(ExpectedConditions.invisibilityOf(getChromeDriver().findElement(by)));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @After
    @Step("��������� �������")
    public void closeBrowser() {
        if (chromeDriver != null) {
            chromeDriver.close();
            chromeDriver.quit();
        } 
    }

    protected void closePreviousWindow() {
        ArrayList<String> tabs = new ArrayList<>(chromeDriver.getWindowHandles());
        chromeDriver.switchTo().window(tabs.get(0));
        chromeDriver.close();
        chromeDriver.switchTo().window(tabs.get(1));
    }

    public void waitFor(int sec) {
        getChromeDriver().manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (WebDriverException e) {
            JavascriptExecutor executor = (JavascriptExecutor) getChromeDriver();
            executor.executeScript("arguments[0].click()", element);
        }
    }
}