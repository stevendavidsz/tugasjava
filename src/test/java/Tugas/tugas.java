package Tugas;

import TestCase.BaseTest;
import jdk.jfr.Description;
import junit.framework.Assert;
import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class tugas extends BaseTest {
    @Test(priority = 1)
    @Description("Assert Price")
    public void tugasJava() throws InterruptedException {
        //Tes dan assert harga smartphone samsung galaxy s6
        WebElement LaptopsCat = driver.get().findElement(By.xpath("//*[text()='Laptops']"));
        LaptopsCat.click();

        Thread.sleep(4000);

        WebElement laptop = driver.get().findElement(By.xpath("//a[normalize-space()='Sony vaio i5']"));
        laptop.click();

        Thread.sleep(4000);

        WebElement addTocart = driver.get().findElement(By.xpath("//a[normalize-space()='Add to cart']"));
        addTocart.click();

        // Handle alert
        Alert alert = explicitWait.get().until(ExpectedConditions.alertIsPresent());
        alert.accept();

        // Navigate to Cart
        WebElement cartLink = driver.get().findElement(By.xpath("//a[@id='cartur']"));
        cartLink.click();

        // Validate that the added laptop appears in the cart
        WebElement cartItem = explicitWait.get().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='cart_product']")));
        String itemNameInCart = cartItem.getText();
        String expectedItemName = LaptopsCat.getText();
        Assert.assertEquals(itemNameInCart, expectedItemName);

    }
}
