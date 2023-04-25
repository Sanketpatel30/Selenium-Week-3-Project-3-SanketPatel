package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {

        Thread.sleep(1000);
        clickOnMouseHoverOnElement(By.xpath("(//span[normalize-space()='Women'])[1]"));
        Thread.sleep(1000);
        clickOnMouseHoverOnElement(By.xpath("(//span[contains(text(),'Tops')])[1]"));
        Thread.sleep(2000);
        clickOnMouseHoverOnElement(By.xpath("(//span[contains(text(),'Jackets')])[1]"));
        List<WebElement> productsBeforeSorting = driver.findElements(By.xpath("//strong[@class = " +
                "'product name product-item-name']"));
        List<String> expectedProductsNames = new ArrayList<>();

        for (WebElement element : productsBeforeSorting) {
            expectedProductsNames.add(element.getText());
        }

        Thread.sleep(1000);
        clickOnMouseHoverOnElement(By.xpath("(//select[@id='sorter'])[1]"));
        Thread.sleep(1000);
        selectByVisibleText(By.xpath("(//select[@id='sorter'])[1]"), "Product Name");

        List<WebElement> productsAfterSorting = driver.findElements(By.xpath("//strong[@class = " +
                "'product name product-item-name']"));
        List<String> actualProductsNames1 = new ArrayList<>();

        for (WebElement element1 : productsAfterSorting) {
            actualProductsNames1.add(element1.getText());
        }

        expectedProductsNames.sort(String.CASE_INSENSITIVE_ORDER);

        verifyText("Products are not sorted to alphabetical order",
                expectedProductsNames.toString(), actualProductsNames1.toString());

    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {

        Thread.sleep(1000);
        clickOnMouseHoverOnElement(By.xpath("(//span[normalize-space()='Women'])[1]"));
        Thread.sleep(1000);
        clickOnMouseHoverOnElement(By.cssSelector("(//#ui-id-9"));
        Thread.sleep(2000);
        clickOnMouseHoverOnElement(By.xpath("(//span[contains(text(),'Jackets')])[1]"));

        List<WebElement> priceBeforeSorting = driver.findElements(By.xpath("//span[@class='price']" +
                "/parent::span[@class = 'price-wrapper ']"));
        List<Double> expectedPrice = new ArrayList<>();

        for (WebElement element : priceBeforeSorting) {
            expectedPrice.add(Double.valueOf(element.getText().replace("$", "")));
        }

        Thread.sleep(1000);
        clickOnMouseHoverOnElement(By.xpath("(//select[@id='sorter'])[1]"));
        Thread.sleep(1000);
        selectByVisibleText(By.xpath("(//select[@id='sorter'])[1]"), "Price");

        List<WebElement> priceAfterSorting = driver.findElements(By.xpath("//span[@class='price']" +
                "/parent::span[@class = 'price-wrapper ']"));
        List<Double> actualPrice = new ArrayList<>();

        for (WebElement element : priceAfterSorting) {

            actualPrice.add(Double.parseDouble(element.getText().replace("$", "")));
        }

        Collections.sort(expectedPrice);

        Assert.assertEquals("Prices are not displayed as per sorting order", expectedPrice, actualPrice);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}