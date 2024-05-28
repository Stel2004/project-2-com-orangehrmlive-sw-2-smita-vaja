package project_2_browserfactory.testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import project_2_browserfactory.BaseTest;

public class ForgotPasswordTest extends BaseTest {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUpBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();       //Click on forget password link
        String expectedText = "Reset Password";
        String actualText = driver.findElement(By.xpath("//h6[text()='Reset Password']")).getText();       //Getting actual text
        Assert.assertEquals("User not navigated to forget password page.", expectedText, actualText);        //Comparing 2 strings
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
