import base.BaseTests;

import org.example.pages.LoginPage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTests extends BaseTests {

    @Test
    public void deve_Logar_Com_Sucesso(){
        LoginPage login = new LoginPage(page);
        login.success_login();

        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void deve_Chegar_A_Pagina_De_Login_Errada(){
        LoginPage login = new LoginPage(page);
        login.problem_login();

        //assert quanto às imagens
        String src_imagem = page.locator("#item_4_img_link>img")
                .getAttribute("src").toLowerCase();
        String src_imagem2 = page.locator("#item_5_img_link>img")
                .getAttribute("src").toLowerCase();

        //Não tem no Playwright o método de comparação que eu queria, usei o do Junit dessa vez
        Assertions.assertEquals(src_imagem, src_imagem2);
    }

    @Test
    public void login_Bloqueado_Exibe_Mensagem(){
        LoginPage login = new LoginPage(page);
        login.lock_login();

        //asserts quanto à exibição e mensagem
        assertThat(page.getByText("Epic sadface: Sorry, this user has been locked out.")).isVisible();

        assertThat(page.locator("[data-test=error]"))
                .containsText("Epic sadface: Sorry, this user has been locked out.");
    }
}
