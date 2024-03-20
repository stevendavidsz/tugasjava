package TestCase;

import jdk.jfr.Description;
import junit.framework.Assert;
import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
public class GetProduct extends BaseTest {
    @Test(priority = 1)
    @Description("Assert Price")
    public void getPrice() {
        //Tes dan assert harga smartphone samsung galaxy s6
        WebElement phonesCat = driver.get().findElement(By.xpath("//div[@id='contcont']//a[2]"));
        phonesCat.click();

        WebElement samsung = driver.get().findElement(By.xpath("//a[normalize-space()='Samsung galaxy s6']"));
        samsung.click();

        //Assert price
        WebElement price = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='price-container']")));
        Assert.assertTrue("Price does not match expected value", price.getText().contains("$360"));
    }

    @Test(priority = 2)
    @Description("Test Description: Sign Up functionality check.")
    public void testSignUp() {
        driver.get().findElement(By.xpath("//a[.='Sign up']")).click();
        explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));

        driver.get().findElement(By.id("sign-username")).sendKeys("Fuy");
        driver.get().findElement(By.id("sign-password")).sendKeys("hohoho123");
        driver.get().findElement(By.xpath("//button[.='Sign up']")).click();

        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        Assert.assertTrue("Alert message was not as expected: " + alertMessage, alertMessage.equals("Sign up successful.") || alertMessage.equals("This user already exist."));
        alert.accept();
    }
}