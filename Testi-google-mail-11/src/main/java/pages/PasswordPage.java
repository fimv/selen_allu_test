package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage extends BasePage{
       
    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//*[contains(text(), 'Введите пароль')]/..")
    //@FindBy(xpath = "//*[//*[@id=\"password\"]/div[1]/div/div[1]/input]")
    private WebElement passwdField;
    
    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginPaswordBtn;
   
    
       
    /**
     * метод для ввода пароля
     */
    @Step("Находим элемент input для ввода пароля и печатаем пароль")  
    public void inputPasswd(String passwd) {
    	checkElementOnPage(passwdField);
    	passwdField.sendKeys(passwd); 
         
    }
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    @Step("Находим и нажимаем кнопку Войти на странице ввода пароля")
    public void clickPaswordBtn() {
    	loginPaswordBtn.click();
    } 
}


