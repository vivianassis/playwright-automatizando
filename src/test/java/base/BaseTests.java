package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTests {
    protected Browser browser;
    protected Page page;

    @BeforeEach
    public void setUp() {
        //inicializando o playwright
        Playwright playwright = Playwright.create();
        //inicializando o brownser, com configurações
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(40)
        );
        //inicializando uma página no brownser, com endereço e específica
        page = browser.newPage();
        page.navigate("https://www.saucedemo.com/");
    }

    @AfterEach
    public void turnDown() {
        browser.close();
    }
}
