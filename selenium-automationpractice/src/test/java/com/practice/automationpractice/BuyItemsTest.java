package com.practice.automationpractice;

import com.practice.automationpractice.pages.pages.MyAccountPage;
import com.practice.automationpractice.pages.pages.ProductAddedToCartModal;
import com.practice.automationpractice.pages.pages.SearchResultPage;
import com.practice.automationpractice.pages.pages.accountCreation.AccountCreationPage;
import com.practice.automationpractice.pages.pages.cart.CartFlowCollectionPages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.practice.automationpractice.utils.enums.Order.DESC;
import static com.practice.automationpractice.utils.enums.PaymentOptions.BY_BANK;
import static com.practice.automationpractice.utils.enums.SearchOption.PRICE;

public class BuyItemsTest extends BaseTest {

    private AccountCreationPage accountCreationPage;
    private MyAccountPage myAccountPage;
    private SearchResultPage searchResultPage;
    private ProductAddedToCartModal productAddedToCartModal;
    private CartFlowCollectionPages cartFlowCollectionPages;

    /*
     * Usually setup creating new user is done by API calls
     * to minimize usage of time consuming  UI steps
     * */
    @BeforeMethod
    public void loginSetUp() {
        accountCreationPage = new AccountCreationPage(driver);
        myAccountPage = new MyAccountPage(driver);
        searchResultPage = new SearchResultPage(driver);
        productAddedToCartModal = new ProductAddedToCartModal(driver);
        cartFlowCollectionPages = new CartFlowCollectionPages(driver);

        homePage.goToLoginPage();
        loginPage.createAnAccountWithEmail(client.getEmail());
        accountCreationPage.fillPersonalInformation(client);
        accountCreationPage.fillAddressInformation(client);
        accountCreationPage.submitRegistrationForm();
        myAccountPage.isAt();
    }

    @Test
    @Parameters({"Search term", "Product name", "Product list size", "Discounted product list size", "Product index"})
    public void buyItemsTest(String searchTerm,
                             String productName,
                             int productListSize,
                             int discountedProductListSize,
                             int productIndex) {
        homePage.openHomePage();
        homePage.searchFor(searchTerm);
        searchResultPage.isAt();
        searchResultPage
                .sortBy(PRICE, DESC)
                .numberOfListedItemsShouldBe(productListSize)
                .numberOfDiscountedItemsShouldBe(discountedProductListSize)
                .nameOfTheProductWithIndexShouldBe(productIndex, productName)
                .putProductInTheBasket(productIndex);

        productAddedToCartModal
                .checkModalMessage()
                .addedProductShouldHaveName(productName)
                .proceedToCheckout();

        cartFlowCollectionPages.cartSummaryPage.isAt();
        cartFlowCollectionPages.cartSummaryPage.proceedToCheckout();
        cartFlowCollectionPages.cartAddressPage.isAt();
        cartFlowCollectionPages.cartAddressPage.proceedToCheckout();
        cartFlowCollectionPages.cartShippingPage.isAt();
        cartFlowCollectionPages.cartShippingPage.agreeToShippingTerms();
        cartFlowCollectionPages.cartShippingPage.proceedToCheckout();
        cartFlowCollectionPages.cartPaymentPage.isAt();
        cartFlowCollectionPages.cartPaymentPage.payBy(BY_BANK);
        cartFlowCollectionPages.orderConfirmationPage.confirmOrder();
        cartFlowCollectionPages.confirmationCheckPage.checkIfOrderConfirmed();
    }

}
