package Relativelocaters;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class hightandwidth {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> adress = driver.getWindowHandles();
		Iterator<String> name = adress.iterator();
		String parent = name.next();
		String child = name.next();
		
		driver.switchTo().window(child);
		driver.get("https://courses.rahulshettyacademy.com/courses/");
		String na =driver.findElements(By.cssSelector("[role='heading']")).get(1).getText();
		driver.switchTo().window(parent);
		WebElement we = driver.findElement(By.cssSelector("[name='name']"));
		
		we.sendKeys(na);
		File ss = we.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File ("Logo.png"));
		
		System.out.println(we.getRect().getDimension().getHeight());
		System.out.println(we.getRect().getDimension().getWidth());
		

	}

}
