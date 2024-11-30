package Dropdown;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.By;


public class ClaenderUI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String month = "6";
		String date = " 15";
		String Year = "2027";
		
		String[] expectedlist = {month,date,Year};
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.xpath("//a[text()='Top Deals']")).click();
		Set<String> ajay = driver.getWindowHandles();
		Iterator<String> Adress = ajay.iterator();
		String Parent = Adress.next();
		String Child = Adress.next();
		driver.switchTo().window(Child);
		//Thread.sleep(4000);
		
		driver.findElement(By.cssSelector("div[class='react-date-picker__inputGroup']")).click();
		driver.findElement(By.xpath("//div[@class='react-calendar__navigation']/button[3]")).click();
		driver.findElement(By.xpath("//div[@class='react-calendar__navigation']/button[3]")).click();
		driver.findElement(By.xpath("//button[text()='"+Year+"']")).click();
		
		driver.findElements(By.cssSelector("div[class='react-calendar__year-view__months'] button")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='15']")).click();
		//System.out.println(driver.findElements(By.cssSelector("div[class='react-date-picker__inputGroup']")).getText());
		
		List<WebElement> list = driver.findElements(By.cssSelector("input[autocomplete='off']"));
		for(int i = 0; i<list.size();i++)
		{
			System.out.println(list.get(i).getAttribute("value"));
			//Thread.sleep(2000);
			Assert.assertEquals(list.get(i).getAttribute("value"),expectedlist[i]);
		}
		//driver.close();
		//Assert.assertEquals(driver.findElements(By.cssSelector("div[class='react-date-picker__inputGroup']")), "06/15/27");
		

		
		
		
		
	}

}
