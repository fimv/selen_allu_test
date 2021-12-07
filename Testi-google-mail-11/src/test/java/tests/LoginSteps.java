package tests;

import io.qameta.allure.Step;
import pages.PasswordPage;
import pages.FirstPage;
import pages.InboxPage;
import pages.LoginPage;


public class LoginSteps {

   @Step("��������� �������� gmail � ��������� �� �������� ������")
   public void openPageRedirectAndCheck(String goTo) {
   FirstPage page = new FirstPage();
   page.goTo(goTo); 
   page.clickFirstLoginBtn();  }
   
   @Step("��������� �������� ����� ������ � ��������� �� �������� ����� ������")
    public void openLoginPageRedirectAndCheck(String login) {
    LoginPage page = new LoginPage();
    page.inputLoginByKey(login);     
    }
   
   @Step("��������� �������� ����� ������ � ��������� �� �������� ��������� ����� (profile)")
   public void openPasswordPageRedirectAndCheck(String password) {
   PasswordPage page = new PasswordPage();
   page.inputPasswd(password);
   page.clickPaswordBtn();  }
    
   
   @Step("������� ���������� ��������� ���� ������ � ����� ")
   public void WriteLetter(String whoom, String topic) {
   InboxPage page = new InboxPage();
   page.findLetters(topic);
   page.clickWriteLetterBtn();   
   page.TopicWriteLetterBtn(whoom, topic);
   page.clickOutBtn();  
   }
                      
}
    
   
