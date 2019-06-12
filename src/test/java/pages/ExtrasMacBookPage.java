package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExtrasMacBookPage {
    WebDriver driver;

    public ExtrasMacBookPage(WebDriver driver) {
        this.driver = driver;

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(appleCareButton()));

        if (!appleCareButton().isEnabled()) {
            throw new IllegalStateException("ExtrasMacBook page not in expected state");
        }
    }

    public WebElement appleCareButton() {
        return driver.findElement(By.xpath("//button[@aria-describedby='applecare15GridGroupPlus_async_labelledby']"));
    }

    public WebElement adapterUSBCtoBButton() {
        return driver.findElement(By.xpath("//button[@aria-describedby='usbCtousbGridGroup_async_labelledby']"));
    }

    public WebElement adapterUSBCDigitalButton() {
        return driver.findElement(By.xpath("//button[@aria-describedby='usbCtodigitalmultiportGridGroup_async_labelledby']"));
    }

    public void orderExtra(String extraItem) {
        if (extraItem.contains("USB-C to USB Adapter")) {
            adapterUSBCtoBButton().click();
        } else {
            throw new IllegalStateException("Unsupported extra Item>" + extraItem + "<");
        }
    }
}

