package tests;

import io.qameta.allure.Description;
import org.junit.Test;
import java.io.IOException;


	public class WebTest extends LoginSteps{	  

    @Test
    @Description("Тест для проверки почты gmail через selenium")
    public void open() throws IOException {                    
        
        openPageRedirectAndCheck("http://www.google.com/intl/ru/gmail/about/");
        //openPageRedirectAndCheck(PropertyManager.getProperty("webdriver.url"));       
        openLoginPageRedirectAndCheck("fyour@gmail.com");
        openPasswordPageRedirectAndCheck("your passw");        
        WriteLetter("sent@email", "Simbirsoft Тестовое задание");
       }   
    
}
	
	
	
	