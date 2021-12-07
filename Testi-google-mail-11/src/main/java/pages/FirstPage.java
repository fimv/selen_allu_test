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
     * ����������� �������� ���� ������������
     */  
    @FindBy(xpath = "//*[contains(text(), '�����')]/..")
    private WebElement firstloginBtn;    
       
    
    
    //@Step("������� � �������� ������ ����� �� ������ �������� g-mail")
    public void clickFirstLoginBtn() {
    checkElementOnPage(firstloginBtn);
    //Assert.assertTrue("�� ������� ������ �����", firstloginBtn.isDisplayed());
    firstloginBtn.click(); 
    } 

}
