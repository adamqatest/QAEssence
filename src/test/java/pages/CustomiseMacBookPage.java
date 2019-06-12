package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class CustomiseMacBookPage {
    WebDriver driver;

    public void scrollTo(WebElement moveableElement,String debugText) {
        // TODO - move to screen helper library, but ideally remove need for
        Actions actions = new Actions(driver);

        actions.moveToElement(moveableElement).click().perform();
        actions.moveToElement(moveableElement).click().perform();
    }

    public void scrollAndClick(WebElement moveableElement, WebElement clickableElement, String debugText) {
        // TODO - move to screen helper library, but ideally remove need for
        //System.out.println("In scroll and click for>"+ debugText+"<");
        scrollTo(moveableElement,debugText);
        //System.out.println("Click element for>"+ debugText+"<");
        clickableElement.click();
        //System.out.println("Out scroll and click for>"+ debugText+"<");
    }

    public CustomiseMacBookPage(WebDriver driver) {
        this.driver = driver;

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(processorInfoButton()));

        if (!processorInfoButton().isEnabled()) {
            throw new IllegalStateException("CustomiseMacBook Info not in expected state");
        }
    }

    public void dummyCheckClicking() {
        // Test moving to field below where want to click
        scrollAndClick(memory32GBButton(), processor23GhzButton(), "processor24GhzButton");
        scrollAndClick(memory32GBButton(), processor24GhzButton(), "processor24GhzButton");
        scrollAndClick(storage512GBButton(), memory16GBButton(), "memory16GBButton");
        scrollAndClick(graphicsProVega20Button(), memory32GBButton(), "memory32GBButton");
        scrollAndClick(storage512GBButton(), graphicsPro560XButton(), "graphicsPro560XButton");
        scrollAndClick(storage512GBButton(), graphicsProVega16Button(), "graphicsProVega16Button");
        scrollAndClick(storage4TBButton(), graphicsProVega20Button(), "graphicsProVega20Button");
        scrollAndClick(softwareNoFinalCutButton(), storage512GBButton(), "storage512GBButton");
        scrollAndClick(softwareNoFinalCutButton(), storage1TBButton(), "storage1TBButton");
        scrollAndClick(softwareNoFinalCutButton(), storage2TBButton(), "storage2TBButton");
        scrollAndClick(softwareNoLogicProButton(), storage4TBButton(), "storage4TBButton");
        scrollAndClick(whatsInBoxLabel(), softwareNoFinalCutButton(), "softwareNoFinalCutButton");
        scrollAndClick(whatsInBoxLabel(), softwareYesFinalCutButton(), "softwareYesFinalCutButton");
        scrollAndClick(whatsInBoxLabel(), softwareNoLogicProButton(), "softwareNoLogicProButton");
        scrollAndClick(whatsInBoxLabel(), softwareYesLogicProButton(), "softwareYesLogicProButton");
    }

    public WebElement processorInfoButton() {
        return driver.findElement(By.xpath("(//button[@data-ase-overlay='processor__dummy_z0wy-learn_more_content'])[1]"));
    }

    public WebElement processor23GhzButton() {
        return driver.findElement(By.xpath("//label[@for='processor__dummy_z0wy_065_c8gt_1']"));
    }
    public WebElement processor24GhzButton() {
        return driver.findElement(By.xpath("//label[@for='processor__dummy_z0wy_065_c803_2']"));
    }
    public WebElement memory16GBButton() {
        return driver.findElement(By.xpath("//label[@for='memory__dummy_z0wy_065_c808_1']"));
    }

    public WebElement memory32GBButton() {
        return driver.findElement(By.xpath("//label[@for='memory__dummy_z0wy_065_c809_2']"));
    }

    public WebElement graphicsPro560XButton() {
        return driver.findElement(By.xpath("//label[@for='graphics_dummy_z0wy_065_c805_1']"));
    }

    public WebElement graphicsProVega16Button() {
        return driver.findElement(By.xpath("//label[@for='graphics_dummy_z0wy_065_c806_2']"));
    }
    public WebElement graphicsProVega20Button() {
        return driver.findElement(By.xpath("//label[@for='graphics_dummy_z0wy_065_c807_3']"));
    }

    public WebElement storage512GBButton() {
        return driver.findElement(By.xpath("//label[@for='hard_drivesolid_state_drive__dummy_z0wy_065_c80f_1']"));
    }

    public WebElement storage1TBButton() {
        return driver.findElement(By.xpath("//label[@for='hard_drivesolid_state_drive__dummy_z0wy_065_c80h_2']"));
    }

    public WebElement storage2TBButton() {
        return driver.findElement(By.xpath("//label[@for='hard_drivesolid_state_drive__dummy_z0wy_065_c80j_3']"));
    }

    public WebElement storage4TBButton() {
        return driver.findElement(By.xpath("//label[@for='hard_drivesolid_state_drive__dummy_z0wy_065_c80m_4']"));
    }

    public WebElement softwareNoFinalCutButton() {
        return driver.findElement(By.xpath("//label[@for='sw_final_cut_pro_x_z0wy_065_c171_1']"));
    }

    public WebElement softwareYesFinalCutButton() {
        return driver.findElement(By.xpath("//label[@for='sw_final_cut_pro_x_z0wy_065_c29g_2']"));
    }

    public WebElement softwareNoLogicProButton() {
        return driver.findElement(By.xpath("//label[@for='sw_logic_pro_x_z0wy_065_c172_1']"));
    }

    public WebElement softwareYesLogicProButton() {
        return driver.findElement(By.xpath("//label[@for='sw_logic_pro_x_z0wy_065_c29h_2']"));
    }

    public WebElement whatsInBoxLabel() {
        return driver.findElement(By.xpath("//h2[@class='as-imagelist-title']"));
    }

    public WebElement addToBagButton() {
        return driver.findElement(By.xpath("//button[@name='add-to-cart']"));
    }

    public void customiseMemory(String memory) {
        scrollTo(whatsInBoxLabel(),"Ensure memory fields are visible");

        if (memory.contains("16")) {
            memory16GBButton().click();
        } else if (memory.contains("32")) {
            memory32GBButton().click();
        } else {
            throw new IllegalStateException("Unsupported value for memory>" + memory + "<");
        }
    }

    public void customiseGraphics(String graphics) {
        scrollTo(whatsInBoxLabel(),"Ensure graphics fields are visible");

        if (graphics.contains("560X")) {
            graphicsPro560XButton().click();
        } else if (graphics.contains("Vega 16")) {
            graphicsProVega16Button().click();
        } else if (graphics.contains("Vega 20")) {
            graphicsProVega20Button().click();
        } else {
            throw new IllegalStateException("Unsupported value for graphics>" + graphics + "<");
        }
    }

    public void customiseStorage(String storage) {
        scrollTo(whatsInBoxLabel(),"Ensure storage fields are visible");

        if (storage.contains("512")) {
            storage512GBButton().click();
        } else if (storage.contains("1TB")) {
            storage1TBButton().click();
        } else if (storage.contains("2TB")) {
            storage2TBButton().click();
        } else if (storage.contains("4TB")) {
            storage4TBButton().click();
        } else {
            throw new IllegalStateException("Unsupported value for storage>" + storage + "<");
        }
    }

    public void customiseSoftware(String software) {
        scrollTo(whatsInBoxLabel(),"Ensure software fields are visible");
        if (software.contains("Final Cut")) {
            softwareYesFinalCutButton().click();
        } else {
            softwareNoFinalCutButton().click();
        }

        if (software.contains("Logic Pro X")) {
            softwareYesLogicProButton().click();
        } else {
            softwareNoLogicProButton().click();
        }
    }
}


