package Tests;

import net.bytebuddy.asm.Advice;
import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.lang.model.util.Elements;
import java.io.File;
import java.util.HashMap;
import java.util.List;

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

        WebElement maleGenderElement = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleGenderElement = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherGenderElement = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String genderValue = "Female";

        if (maleGenderElement.getText().equals(genderValue)){
            maleGenderElement.click();
        }else if (femaleGenderElement.getText().equals(genderValue)){
            femaleGenderElement.click();
        }else if (otherGenderElement.getText().equals(genderValue)){
            otherGenderElement.click();
        }

        WebElement subjectElement = driver.findElement(By.id("subjectsInput"));
        String subjectValue = "Social Studies";
        subjectElement.sendKeys(subjectValue);
        subjectElement.sendKeys(Keys.ENTER);

        WebElement stateElement = driver.findElement(By.id("react-select-3-input"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", stateElement);
        stateElement.sendKeys("NCR");
        stateElement.sendKeys(Keys.ENTER);

        WebElement cityElement = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();", cityElement);
        cityElement.sendKeys("Delhi");
        cityElement.sendKeys(Keys.ENTER);

        WebElement submitButtonElement = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click();", submitButtonElement);


        HashMap<String, String> validateForm = new HashMap<>();
        validateForm.put("Student Name", firstNameValue + " " + lastNameValue);
        validateForm.put("Student Email", emailValue);
        validateForm.put("Gender", genderValue );
        validateForm.put("Mobile", mobileNumberValue);
        validateForm.put("Date of Birth", "31 December,2024");
        validateForm.put("Subjects", subjectValue );
        validateForm.put("Hobbies", "");
        validateForm.put("Picture", uploadPicture.getName());
        validateForm.put("Address", "");
        validateForm.put("State and City", "NCR Delhi");

        List<WebElement> actualFormTable = driver.findElements(By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr"));
        for(WebElement rowElement : actualFormTable){
            List <WebElement> columns = rowElement.findElements(By.xpath("td"));
            String label = columns.get(0).getText();
            String values = columns.get(1).getText() ;

            Assert.assertEquals(values, validateForm.get(label), "Validating failed at  " + label);

        }


    }
}
