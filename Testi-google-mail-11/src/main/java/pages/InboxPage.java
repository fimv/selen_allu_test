package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasePage{
       
	String topicCount;	
      
    /**
     * определение локатора кнопки "Написать письмо"
     */
    @FindBy(xpath = "//*[@id=\":9x\"]/div/div")
    private WebElement WriteLetterBtn;		
    
    /**
     * определение локатора поля Кому
     */
    @FindBy(xpath = "//*[@id=\":gq\"]")
    private WebElement WhoomField;	
    
    /**
     * определение локатора поля Тема письма
     */
    @FindBy(xpath = "//*[@id=\":g8\"] ")
    private WebElement TopicField;	
    
    /**
     * определение локатора поля Текст письма
     */
    @FindBy(xpath = "//*[@id=\":he\"]")
    private WebElement TextField;	
    
    /**
     * определение локатора поля кнопки Отправить
     */
    //   //*[@id=":fv"]     Отправить
    @FindBy(xpath = "//*[contains(text(), 'Отправить')]/..")
    private WebElement SendBtn;
    
    /**
     * определение локатора поля кнопки Выйти
     */
    //   //*[@id="gb_71"]      Выйти
    @FindBy(xpath = "//*[contains(text(), 'Выйти')]/..")
    private WebElement OutBtn;
   
    
       
    /**
     * метод для поиска всех элементов
     * @return 
     */
    @Step("Подсчитываем количество писем с темой {0}")  
    public String findLetters(String topic) {
    	ChromeDriver driver = getChromeDriver();    	   	
    	int xpathCount = driver.findElements(By.xpath("//*[contains(text(), 'Simbirsoft Тестовое задание')]")).size();  	
    	String topicCount = String.valueOf(xpathCount);
    	return topicCount;        
    	}
    
    
    /**
     * метод для осуществления нажатия кнопки Написать письмо
     */
    @Step("Нажимаем на кнопку Написать письмо")
    public void clickWriteLetterBtn() {
    	checkElementOnPage(WriteLetterBtn);
    	WriteLetterBtn.click(); 
    	} 
    
    
    /**
     * метод для ввода реквизитов письма
     */
    @Step("Вводим реквизиты письма: кому, тема, текст письма {0}, {1}, {2} и нажимаем кнопку Отправить")
    public void TopicWriteLetterBtn(String whoom, String topic) {
    	checkElementOnPage(WhoomField);
    	checkElementOnPage(TopicField);
    	checkElementOnPage(TextField);
        WhoomField.sendKeys(whoom);
        TopicField.sendKeys(topic);
        TextField.sendKeys(topicCount);  
    	
    	SendBtn.click(); 
    	} 
    
    
    /**
     * метод для нажатия кнопки Выйти
     */
    @Step("Нажимаем на кнопку Написать письмо")
    public void clickOutBtn() {
    	checkElementOnPage(WriteLetterBtn);
    	OutBtn.click(); 
    	} 
    
    }



