package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {

    public WebDriver driver;

    @Test
    public void openBrowser() {

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/");

        //browserul trebuie maximizat, pt vizibilitate
        driver.manage().window().maximize();

        WebElement formElement = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formElement.click();

        WebElement practiceForm =driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceForm.click();

        WebElement firstNameElement = driver.findElement(By.id("firstName"));
        String firstNameValue = "AndraTest";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.id("lastName"));
        String lastNameValue= "who";
        lastNameElement.sendKeys(lastNameValue);

        WebElement emailElement = driver.findElement(By.id("userEmail"));
        String emailValue = "andra@test.com";
        emailElement.sendKeys(emailValue);

        WebElement mobileNumberElement = driver.findElement(By.cssSelector("input[placeholder='Mobile Number']"));
        String mobileNumberValue = "0745128547";
        mobileNumberElement.sendKeys(mobileNumberValue);

        WebElement uploadPictureElement = driver.findElement(By.id("uploadPicture"));
        File uploadPicture = new File("src/test/resources/uploadPictureElement.png");
        uploadPictureElement.sendKeys(uploadPicture.getAbsolutePath());

    }
}
