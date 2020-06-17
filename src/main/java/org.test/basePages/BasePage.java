package org.test.basePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By selector) {
        return driver.findElement(selector);
    }

    public List<WebElement> getElements(By selector) {
        return driver.findElements(selector);
    }

    public WebElement waitForElementVisible(By selector) {
        return new WebDriverWait(driver, 20L).until(ExpectedConditions.visibilityOfElementLocated(selector)); //explicit wait
    }

    public WebElement waitForElementClickable(By selector) {
        return new WebDriverWait(driver, 20L).until(ExpectedConditions.elementToBeClickable(selector)); //explicit wait
    }

    public WebDriverWait waitBeforeAction(){
        return new WebDriverWait(driver, 50L);
    }

    public void selectFromTheList (By selector, String param){
        WebElement selectElem = driver.findElement(selector);
        Select select = new Select(selectElem);
        select.selectByVisibleText(param);
    }

    public String pathToFile (String fileName){
        try{
            InputStream inputStream = BasePage.class.getClassLoader().getResourceAsStream(fileName);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);

            String[] name = fileName.split("\\.");
            File file = File.createTempFile(name[0], name[1]);
            OutputStream outStream = new FileOutputStream(file);
            outStream.write(buffer);
            return file.getPath();
        }catch (IOException exception){
            System.out.println("File not found");
        }
        return null;
    }

}