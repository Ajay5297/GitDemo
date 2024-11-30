package Relativelocaters;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiplewidnow {

	public static void main(String[] args) {
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
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(na);

	}

}
