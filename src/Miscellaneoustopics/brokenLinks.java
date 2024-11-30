package Miscellaneoustopics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import graphql.Assert;

public class brokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//broken link
		// one way is to open and check the url is working or not
		// get all urls present in the page by using selenium
		// java methods call the url and gets your status code
		//if the status code >400 
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a = new SoftAssert();
		
		
		for(WebElement link:links)
		{
			String url = link.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int res = conn.getResponseCode();
			System.out.println(res);
			a.assertTrue(res<400, "The link is broken"+link.getText()+res);
//			if(res>400)
//			{
//				System.out.println("The link is broken"+link.getText()+res);
//				Assert.assertTrue(false);
//				
//			}
			
			
		}
		a.assertAll();
		
		//String link = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");
		//String links = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
		
//		HttpURLConnection conn = (HttpURLConnection)new URL(link).openConnection();
//		conn.setRequestMethod("HEAD");
//		conn.connect();
//		int res = conn.getResponseCode();
//		System.out.println(res);

		
		


	}

}
