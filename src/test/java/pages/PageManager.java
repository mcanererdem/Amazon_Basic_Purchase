package pages;

public class PageManager {
    private static PageManager instance;
    private HomePage homePage;
    private ListPage listPage;
    private CartPage cartPage;
    private LoginPage loginPage;

    private PageManager() {}

    public static PageManager getInstance() {
        if (instance == null) {
            instance = new PageManager();
        }
        return instance;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public ListPage getListPage() {
        if (listPage == null) {
            listPage = new ListPage();
        }
        return listPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

}
