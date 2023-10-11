package pages;

import baseFiles.CommonUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.ConfigUtil;

import java.io.IOException;
import java.util.List;

public class BrowserStackLoginPage extends CommonUtil {
    List<WebElement> lstOnLoginPage;
    public final By btnSignIn = By.xpath("//a[@id='signin']");
    public final By btnLogin = By.id("login-btn");
    public final By txtErrorMsg = By.xpath("//h3[text()='Your account has been locked.']");
    public final By lstElements = By.className("css-tlfecz-indicatorContainer");

    public void iAmOnBrowserStackHomePage() throws IOException, InterruptedException {
        driver.get(ConfigUtil.getPropertyValue("browserStack_url"));
        Thread.sleep(1000);
    }

    public void iClickOnSignInButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnSignIn))).click();
        //Thread.sleep(1000);
    }

    public void iSelectUsername() throws IOException {
        lstOnLoginPage = driver.findElements(lstElements);
        lstOnLoginPage.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),'" + ConfigUtil.getPropertyValue("userName") + "')]")))).click();
    }

    public void iSelectPassword() throws IOException {
        lstOnLoginPage.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),'" + ConfigUtil.getPropertyValue("password") + "')]")))).click();
    }

    public void iClickOnLoginButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnLogin))).click();
        //Thread.sleep(1000);
    }

    public void iVerifySuccessfullyLoggedInWithUsername() throws IOException {
        Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[contains(text(),'" + ConfigUtil.getPropertyValue("userName") + "')]")))).isDisplayed());
    }

    public void iSelectInvalidUsername() throws IOException {
        lstOnLoginPage = driver.findElements(lstElements);
        lstOnLoginPage.get(0).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),'" + ConfigUtil.getPropertyValue("invalidUsername") + "')]")))).click();
    }

    public void iSelectInvalidPassword() throws IOException {
        lstOnLoginPage.get(1).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),'" + ConfigUtil.getPropertyValue("invalidPassword") + "')]")))).click();
    }

    public String getActualErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(txtErrorMsg))).getText();
    }
}
