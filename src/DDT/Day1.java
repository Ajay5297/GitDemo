package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("./data.properties");
		p.load(fis);
		WebDriver driver = new ChromeDriver();
		driver.get(p.getProperty("url"));
		driver.findElement(By.id("APjFqb")).sendKeys("username");

	}

}
