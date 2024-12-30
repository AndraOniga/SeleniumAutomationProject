package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class InteractionsRecursive {
    public WebDriver driver;

    @Test
    public void openInteractions() {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");
        //browserul trebuie maximizat, pt vizibilitate
        driver.manage().window().maximize();
        List<WebElement> listElement = driver.findElements(By.xpath("//div[@id='demo-tabpane-list']//div[@class='list-group-item list-group-item-action']"));
        for(int i = 0; i< listElement.size()-1; i++){
           WebElement listValues = listElement.get(i);
           System.out.println("Number of elements is " + listValues.getText());
        }

    }
}
