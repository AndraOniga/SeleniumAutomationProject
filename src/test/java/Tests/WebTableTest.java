package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void openBrowser() {

        driver = new ChromeDriver();

        driver.get("https://demoqa.com/");

        //browserul trebuie maximizat, pt vizibilitate
        driver.manage().window().maximize();


        //declaram un element
        WebElement ElementsButton = driver.findElement(By.xpath("//h5[text()='Elements']"));
        ElementsButton.click();

        WebElement WebTablesButton = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        WebTablesButton.click();

        WebElement AddNewRecordButton = driver.findElement(By.id("addNewRecordButton"));
        AddNewRecordButton.click();

        WebElement FirstNameField = driver.findElement(By.id("firstName"));
        String firstNameValue = "AndraTest";
        FirstNameField.sendKeys(firstNameValue);

        WebElement LastNameField = driver.findElement(By.id("lastName"));
        String lastNameValue = "LastTest";
       LastNameField.sendKeys(lastNameValue);

        WebElement EmailField = driver.findElement(By.id("userEmail"));
        String emailValue = "andra@test.com";
        EmailField.sendKeys(emailValue);

        WebElement AgeField = driver.findElement(By.id("age"));
        String ageValue = "33";
        AgeField.sendKeys(ageValue);

        WebElement SalaryField = driver.findElement(By.id("salary"));
        String salaryValue = "15000";
        SalaryField.sendKeys(salaryValue);

        WebElement DepartmentField = driver.findElement(By.id("department"));
        String departmentValue = "testing";
        DepartmentField.sendKeys(departmentValue);

        WebElement SubmitButton = driver.findElement(By.id("submit"));
        SubmitButton.click();


    }

}