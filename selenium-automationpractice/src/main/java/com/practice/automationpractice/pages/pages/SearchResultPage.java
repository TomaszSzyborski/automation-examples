package com.practice.automationpractice.pages.pages;

import com.practice.automationpractice.utils.enums.Order;
import com.practice.automationpractice.utils.enums.SearchOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class SearchResultPage extends BasePage {

    @FindBy(css = "#center_column")
    private WebElement searchResultGrid;

    @FindBy(css = "#selectProductSort")
    private WebElement selectSortMethodDropdown;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isAt() {
        assertThat(searchResultGrid.isDisplayed())
                .isTrue();

        assertThat(
            driver.findElement(cssSelector("span.navigation_page")).isDisplayed()
        ).as("Search navigation")
                .isTrue();
    }


    /*
     * This is to indicate possibility of method chaining
     * while using page object pattern
     */
    public SearchResultPage sortBy(SearchOption searchOption, Order order){
        new Select(selectSortMethodDropdown).selectByValue(searchOption.toString() + ":" + order.toString());
        return this;
    }

    public SearchResultPage numberOfListedItemsShouldBe(int number) {
        assertThat(searchResultGrid.findElements(cssSelector("div.product-container")))
                .as("Number of products displayed")
                .size()
                .isEqualTo(number);

        return this;
    }

    public SearchResultPage numberOfDiscountedItemsShouldBe(int number) {
        String css = "div.product-container .right-block .content_price .price-percent-reduction";
        assertThat(searchResultGrid.findElements(cssSelector(css)))
                .as("Number of discounted displayed")
                .size()
                .isEqualTo(number);
        return this;
    }

    public SearchResultPage nameOfTheProductWithIndexShouldBe(int index, String productName) {
        assertThat(searchResultGrid.findElements(cssSelector("div.product-container .product-name"))
                .get(index).getAttribute("title"))
                .as("Name of product at index " + index)
                .isEqualToNormalizingWhitespace(productName);
        return this;
    }

    public SearchResultPage putProductInTheBasket(int index){
        WebElement product = driver.findElement(xpath("//div[@class='product-container'][" + index + "]"));
        new Actions(driver).moveToElement(product).perform();
        WebElement addToCartButton = driver.findElement(xpath("//*[@class='ajax_add_to_cart_button'][" + index + "]"));
        wait.until(ExpectedConditions.visibilityOf(addToCartButton)).click();
        return this;
    }
}
