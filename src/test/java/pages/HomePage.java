package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(searchButton()));
        if (!searchButton().isEnabled()) {
            throw new IllegalStateException("HomePage not in expected state");
        }
    }

    public WebElement searchButton() {
        return driver.findElement(By.id("ac-gn-link-search"));
    }

    public WebElement searchField() {
        return driver.findElement(By.id("ac-gn-searchform-input"));
    }

    public WebElement searchSubmitButton() {
        return driver.findElement(By.id("ac-gn-searchform-submit"));
    }

    public WebElement home() {
        return driver.findElement(By.id("ac-gn-firstfocus"));
    }

    public WebElement bag() {
        return driver.findElement(By.id("ac-gn-bag"));
    }

    public WebElement checkout() {
        return driver.findElement(By.xpath("//a[@class='ac-gn-bagview-nav-link ac-gn-bagview-nav-link-bag']"));
    }

    public void order(String productName){
        this.searchButton().click();
        this.searchField().click();
        this.searchField().sendKeys(productName);
        this.searchField().sendKeys(Keys.ENTER);
    }

    public void goHome(){
        this.home().click();
    }

    public void goCheckout() {
        this.bag().click();
        this.checkout().click();
    }
}

