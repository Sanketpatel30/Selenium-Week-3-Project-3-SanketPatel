package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        Thread.sleep(1000);
        clickOnMouseHoverOnElement(By.xpath("//span[normalize-space()='Gear']"));
        Thread.sleep(1000);
        clickOnMouseHoverOnElement(By.xpath("//span[normalize-space()='Bags']"));
        Thread.sleep(1000);
        clickOnMouseHoverOnElement(By.xpath("(//img[@alt='Overnight Duffle'])[1]"));

        Thread.sleep(5000);
        String expectedText = "Overnight Duffle";
        String actualText= getTextFromElement(By.xpath("//span[@class='base']"));
        verifyText("Expected text is not displayed", expectedText, actualText);

        sendTextToElement(By.xpath("//input[@id='qty']"), "3");

        clickOnElement(By.xpath("//span[normalize-space()='Add to Cart']"));

        Thread.sleep(5000);
        expectedText = "You added Overnight Duffle to your shopping cart.";
        actualText= getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        verifyText("Expected text is not displayed", expectedText, actualText);

        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        Thread.sleep(5000);
        expectedText = "Overnight Duffle";
        actualText= getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        verifyText("Expected text is not displayed", expectedText, actualText);

        expectedText = "$135.00";
        actualText= getTextFromElement(By.xpath("//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']"));
        verifyText("Expected text is not displayed", expectedText, actualText);

        sendTextToElement(By.xpath("(//input[@class='input-text qty'])[1]"), "5");

        clickOnElement(By.xpath("(//span[normalize-space()='Update Shopping Cart'])[1]"));

        expectedText = "$225.00";
        actualText= getTextFromElement(By.xpath("(//span[@class='price'][normalize-space()='$225.00'])[3]"));
        verifyText("Expected text is not displayed", expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

