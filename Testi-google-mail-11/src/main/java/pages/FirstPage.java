package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class FirstPage extends BasePage {
	
	
	/**
     * определение локатора меню пользователя
     */  
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement firstloginBtn;    
       
    
    
    //@Step("Находим и нажимаем кнопку Войти на первой странице g-mail")
    public void clickFirstLoginBtn() {
    checkElementOnPage(firstloginBtn);
    //Assert.assertTrue("Не найдена кнопка Войти", firstloginBtn.isDisplayed());
    firstloginBtn.click(); 
    } 

}
