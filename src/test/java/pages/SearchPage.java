package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchPage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(searchField()));

        if (!searchField().isEnabled()) {
            throw new IllegalStateException("Search page not in expected state");
        }

        if (resultsFoundLabel().getText().contains("\n0 results found") ) {
            throw new IllegalStateException("No results found");
        }
    }


    public WebElement searchField() {
        return driver.findElement(By.id("site-search-mixedresults-query"));
    }

    public WebElement resultsFoundLabel() {
        return driver.findElement(By.className("as-search-results-value"));
    }
    public WebElement buyFirstResultButton() {
        return driver.findElement(By.xpath("(//a[@class='as-links-name more'][@data-relatedlink='1'])[2]"));
    }
    public WebElement bag() {
        return driver.findElement(By.id("ac-gn-bag"));
    }

    public void buyFirstResult(){
        this.buyFirstResultButton().click();
    }
}

