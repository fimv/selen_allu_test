package tests;

import io.qameta.allure.Step;
import pages.PasswordPage;
import pages.FirstPage;
import pages.InboxPage;
import pages.LoginPage;


public class LoginSteps {

   @Step("Открываем страницу gmail и переходим на страницу логина")
   public void openPageRedirectAndCheck(String goTo) {
   FirstPage page = new FirstPage();
   page.goTo(goTo); 
   page.clickFirstLoginBtn();  }
   
   @Step("Открываем страницу ввода логина и переходим на страницу ввода пароля")
    public void openLoginPageRedirectAndCheck(String login) {
    LoginPage page = new LoginPage();
    page.inputLoginByKey(login);     
    }
   
   @Step("Открываем страницу ввода пароля и переходим на страницу почтового ящика (profile)")
   public void openPasswordPageRedirectAndCheck(String password) {
   PasswordPage page = new PasswordPage();
   page.inputPasswd(password);
   page.clickPaswordBtn();  }
    
   
   @Step("Считаем количество элементов Тема письма и выход ")
   public void WriteLetter(String whoom, String topic) {
   InboxPage page = new InboxPage();
   page.findLetters(topic);
   page.clickWriteLetterBtn();   
   page.TopicWriteLetterBtn(whoom, topic);
   page.clickOutBtn();  
   }
                      
}
    
   
