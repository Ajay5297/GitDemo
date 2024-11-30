package WebDriver;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Link {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //System.out.println(driver.getPageSource());
        System.out.println(driver.getWindowHandle());
       System.out.println( driver.findElements(By.tagName("a")).size());
       
       WebElement footerdriver =  driver.findElement(By.id("gf-BIG"));
       System.out.println(footerdriver.findElements(By.tagName("a")).size());
       
       WebElement Block = footerdriver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul"));
       
      System.out.println( Block.findElements(By.tagName("a")).size());
      
      for(int i = 1; i<Block.findElements(By.tagName("a")).size(); i++)
      {
    	  String Ajay = Keys.chord(Keys.CONTROL,Keys.ENTER);
    	  Block.findElements(By.tagName("a")).get(i).sendKeys(Ajay);
    	  Thread.sleep(2000);
    	 
      }
      
      Set<String> Adress = driver.getWindowHandles();
      Iterator<String> it = Adress.iterator();
      
      while(it.hasNext())// if the next window is opened or not or present or not
      {
    	  driver.switchTo().window(it.next());
    	  System.out.println(driver.getTitle());
    	  Thread.sleep(2000);
      }
      
      
      
      
      
      
      
      
      /*for(int i=1; i<Block.findElements(By.tagName("a")).size(); i++)
      {
    	
    	  Block.findElements(By.tagName("a")).get(i).click();
    	  Thread.sleep(2000);
    	  driver.navigate().back();
    	
    	 
      }*/
      
      

	}

}
