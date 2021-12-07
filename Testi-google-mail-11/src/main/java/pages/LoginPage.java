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

public class LoginPage extends BasePage {
       /**
     * определение локатора поля ввода логина
     */	 
    @FindBy(xpath = "//*[contains(@id, 'identifierId')]")    
    private WebElement loginField;    
        
    /**
     * определение локатора кнопки входа в аккаунт
     */  
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    //@FindBy(xpath = "//*[contains(text(), 'Далее')]/..")
    private WebElement loginBtn;

	private String login;
    
    /**
     * метод для ввода логина
     */
    @Step("Находим input для ввода логина и вводим логин")    
    public void inputLogin(String login) {
    	//Assert.assertTrue("Не найден input для ввода логина", loginField.isDisplayed());
    	checkElementOnPage(loginField);
        loginField.sendKeys(login); }
    
    
    @Step("Находим input для ввода логина и вводим логин")    
    public void inputLoginByKey(String login) {
    	//Assert.assertTrue("Не найден input для ввода логина", loginField.isDisplayed());
    	checkElementOnPage(loginField);
    	String login2 = login.concat("\t\t\n");
    	int len = login2.length();
    	//char[] loginChar=new char[l];
    	
    	char loginChar2;
    	for(int i =0; i < len; i++) {
    		loginChar2 = login2.charAt(i);
    		String charStr = String.valueOf(loginChar2);    	   		
            loginField.sendKeys(charStr);
            waitFor(i*5);            
    	}
    	waitFor(12);   
    	//loginField.sendKeys("\n");    	
    }
        
    
    
    
    /**
     * метод для осуществления нажатия кнопки далее для перехода на страницу ввода пароля
     */
    @Step("Находим и нажимаем кнопку Далее на странице ввода логина")  
    public void clickLoginBtn() {
    	//Assert.assertTrue("Не найден input для ввода логина", loginBtn.isDisplayed());
    	waitFor(5); 
    	checkElementOnPage(loginBtn);
    	loginBtn.click(); } 
    }
