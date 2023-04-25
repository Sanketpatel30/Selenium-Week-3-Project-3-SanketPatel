package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

public class MenTest extends Utility {

        String baseUrl = "https://magento.softwaretestingboard.com/";

        @Before
        public void setup() {
            openBrowser(baseUrl);
        }

        @Test
        public void verifyTheSortByPriceFilter() throws InterruptedException {

            Thread.sleep(1000);
            clickOnMouseHoverOnElement(By.xpath("//span[normalize-space()='Men']"));
            Thread.sleep(1000);
            clickOnMouseHoverOnElement(By.xpath("(//span[contains(text(),'Bottoms')])[2]"));
            Thread.sleep(1000);
            clickOnMouseHoverOnElement(By.xpath("(//span[contains(text(),'Pants')])[2]"));
            Thread.sleep(1000);
            clickOnMouseHoverOnElement(By.xpath("(//img[@alt='Cronus Yoga Pant '])[1]"));
            Thread.sleep(1000);
            clickOnMouseHoverOnElement(By.xpath("(//div[@id='option-label-size-143-item-175'])[1]"));
            Thread.sleep(1000);
            clickOnMouseHoverOnElement(By.xpath("//span[normalize-space()='Men']"));
            Thread.sleep(1000);
            clickOnMouseHoverOnElement(By.xpath("(//div[@id='option-label-color-93-item-49'])[1]"));
            Thread.sleep(1000);
            clickOnMouseHoverOnElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
            Thread.sleep(1000);
            clickOnMouseHoverOnElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
            Thread.sleep(5000);
            String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
            String actualText= getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
            verifyText("Expected text is not displayed", expectedText, actualText);

            clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
            expectedText = "Shopping Cart";
            actualText = getTextFromElement(By.xpath("//span[@class='base']"));
            verifyText("Expected message is not displayed", expectedText, actualText);

            expectedText = "Cronus Yoga Pant";
            actualText = getTextFromElement(By.xpath("//td[@class='col item']" +
                    "//strong[@class='product-item-name']"));
            verifyText("Expected message is not displayed", expectedText, actualText);

            expectedText = "32";
            actualText = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
            verifyText("Expected text is not displayed", expectedText, actualText);

            expectedText = "Black";
            actualText = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
            verifyText("Expected message is not displayed", expectedText, actualText);
        }
    @After
    public void tearDown() {
        closeBrowser();
    }
    }
