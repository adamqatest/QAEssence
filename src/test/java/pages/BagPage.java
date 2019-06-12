package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class BagPage {
    WebDriver driver;

    public BagPage(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(this.driver, 5)
                .until(ExpectedConditions.elementToBeClickable(checkoutButton()));
        if (!checkoutButton().isEnabled()) {
            throw new IllegalStateException("BagPage not in expected state");
        }
    }

    public WebElement yourTotalLabel() {
        return driver.findElement(By.xpath("//div[@data-autom='bagrs-summary-totallabel']"));
    }

    public WebElement yourTotalValue() {
        return driver.findElement(By.xpath("//div[@data-autom='bagrs-summary-totalvalue']"));
    }

    public WebElement yourVATValue() {
        return driver.findElement(By.xpath("//div[@class='rs-tax-section']"));
    }

    public WebElement checkoutButton() {
        return driver.findElement(By.xpath("//button[@data-autom='bag-checkout-button']"));
    }

    public String getTotal() {
        //Return as £xxxxxx.yy (ccy symbol but no thousand separator)
        String total;

        total = yourTotalValue().getText();
        total = total.replace(",","");

        return total;
    }

    public String getVAT() {
        //Return as £xxxxxx.yy (ccy symbol but no thousand separator)
        String vat;

        vat = yourVATValue().getText();
        vat = vat.substring(vat.lastIndexOf(' ')+1);
        vat = vat.replace(",","");

        return vat;
    }

}

