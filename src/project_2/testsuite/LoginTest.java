package project_2.testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import project_2.browserfactory.BaseTest;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValidCredentials
 * * Enter “Admin” username
 * * Enter “admin123 password
 * * Click on ‘LOGIN’ button
 * * Verify the ‘Dashboard’ text is display
 */
public class LoginTest extends BaseTest {
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUpBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.name("username")).sendKeys("Admin");                                      //Enter username
        driver.findElement(By.name("password")).sendKeys("admin123");                                   //Enter password
        driver.findElement(By.xpath("//button[@type='submit']")).click();                             //Click on submit
        String expectedText = "Dashboard";
        String actualText = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
        //Comparing 2 strings
        Assert.assertEquals("User is not login successfully", expectedText, actualText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }

}
