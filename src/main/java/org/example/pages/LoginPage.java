package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.sun.net.httpserver.Authenticator;

public class LoginPage {
    private final Page page;
    private final Locator user;
    private final Locator password;
    private final Locator button;

    //construtor
    public LoginPage(Page page){
         this.page = page;
         this.user = page.locator("#user-name");
        this.password = page.locator("[name=password]");
         this.button = page.getByText("LOGIN");
        //this.user = page.getByPlaceholder("Username");
        // — getBy usa mais métodos de localização, e locator usa o DOM
        // — pode usar os dois, no POM ele indica a designação dos elementos no construtor
    }

    //métodos da página
    public void setUser(String usuario) {
        user.fill(usuario);
    }
    public void setPassword(String senha){
        password.fill(senha);
    }
    public void click_Button(){
        button.click();
    }


    //logins
    public HomePage success_login(){
        setUser("standard_user");
        setPassword("secret_sauce");
        click_Button();
        return new HomePage(page);
    }

    public ProblemHomePage problem_login(){
        setUser("problem_user");
        setPassword("secret_sauce");
        click_Button();
        return new ProblemHomePage(page);
    }

    public void lock_login(){
        setUser("locked_out_user");
        setPassword("secret_sauce");
        click_Button();
    }
}
