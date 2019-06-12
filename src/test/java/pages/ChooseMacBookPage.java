package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class ChooseMacBookPage {
    WebDriver driver;

    public ChooseMacBookPage(WebDriver driver) {
        this.driver = driver;

        //TODO - Replace sleep with better way to resolve stale element reference: element is not attached to the page document
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }

        new WebDriverWait(this.driver, 5)
                .until(ExpectedConditions.elementToBeClickable(screen15InchButton()));

        if (!screen15InchButton().isEnabled()) {
            throw new IllegalStateException("ChooseMacBookPage not in expected state");
        }
    }


    public WebElement screen13InchButton() {
        return driver.findElement(By.xpath("//button[@data-toggle-key='13inch']]"));
    }

    public WebElement screen15InchButton() {
        return driver.findElement(By.xpath("//button[@data-toggle-key='15inch']"));
    }

    public WebElement colour26SilverRadio() {
        return driver.findElement(By.xpath("//li[@data-ase-materializer='acc_MV922B/A']"));
    }

    public WebElement colour26SpaceGreyRadio() {
        return driver.findElement(By.xpath("//li[@data-ase-materializer='acc_MV902B/A']"));
    }

    public WebElement colour23SilverRadio() {
        return driver.findElement(By.xpath("//li[@data-ase-materializer='acc_MV932B/A']"));
    }

    public WebElement colour23SpaceGreyRadio() {
        return driver.findElement(By.xpath("//li[@data-ase-materializer='acc_MV912B/A']"));
    }

    public WebElement select26SilverButton() {
        return driver.findElement(By.xpath("//form[@data-part-number='MV922B/A']//button[@name='proceed']"));
    }

    public WebElement select26SpaceGreyButton() {
        return driver.findElement(By.xpath("//form[@data-part-number='MV902B/A']//button[@name='proceed']"));
    }

    public WebElement select23SilverButton() {
        return driver.findElement(By.xpath("//form[@data-part-number='MV932B/A']//button[@name='proceed']"));
    }

    public WebElement select23SpaceGreyButton() {
        return driver.findElement(By.xpath("//form[@data-part-number='MV912B/A']//button[@name='proceed']"));
    }

    public WebElement resultsFoundLabel() {
        return driver.findElement(By.className("as-search-results-value"));
    }

    public WebElement buyFirstResult() {
        return driver.findElement(By.linkText("Buy"));
    }

    public WebElement bag() {
        return driver.findElement(By.id("ac-gn-bag"));
    }


    public void chooseSize(String sizeOfMachine) {
        if (sizeOfMachine.contains("13")) {
            screen13InchButton().click();
        } else if (sizeOfMachine.contains("15")) {
            screen15InchButton().click();
        } else {
            throw new IllegalStateException("Unknown Machine Size>" + sizeOfMachine + "<");
        }
    }

    public void chooseSpeedAndFinish(String processor, String colour) {
        if (processor.contains("2.3")) {
            if (colour.equalsIgnoreCase("Silver")) {
                colour23SilverRadio().click();
            } else if (colour.equalsIgnoreCase("Space Grey")) {
                colour23SpaceGreyRadio().click();
            } else {
                throw new IllegalStateException("Unsupported Colour for 2.3 processor>" + colour + "<");
            }
        } else if (processor.contains("2.6")) {
            if (colour.equalsIgnoreCase("Silver")) {
                colour26SilverRadio().click();
            } else if (colour.equalsIgnoreCase("Space Grey")) {
                colour26SpaceGreyRadio().click();
            } else {
                throw new IllegalStateException("Unsupported Colour for 2.6 processor>" + colour + "<");
            }
        } else {
            throw new IllegalStateException("Unsupported Processor>" + processor + "<");
        }
    }

    public void selectModel(String processor, String colour) {
        if (processor.contains("2.3")) {
            if (colour.equalsIgnoreCase("Silver")) {
                select23SilverButton().click();
            } else if (colour.equalsIgnoreCase("Space Grey")) {
                select23SpaceGreyButton().click();
            } else {
                throw new IllegalStateException("Unsupported Colour for 2.3 processor>" + colour + "<");
            }
        } else if (processor.contains("2.6")) {
            if (colour.equalsIgnoreCase("Silver")) {
                select26SilverButton().click();
            } else if (colour.equalsIgnoreCase("Space Grey")) {
                select26SpaceGreyButton().click();
            } else {
                throw new IllegalStateException("Unsupported Colour for 2.6 processor>" + colour + "<");
            }
        } else {
            throw new IllegalStateException("Unsupported Processor>" + processor + "<");
        }
    }
}

