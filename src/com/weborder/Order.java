package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\SeleniumDependencies\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		1. Open browser
//		2. Go to url http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx (Links to an external site.)Links to an external site.
		driver.get(" http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

//		3. Login using username Tester and password test
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		Thread.sleep(2000);
		
// 		4. Click on Order link		
		driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();
		
//		5. Enter a random quantity between 1 and 100
		Random r = new Random();
		int random = r.nextInt(100-1) + 1;
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(random+"");
		
//		6. Enter Customer Name: John <middle_name> Smith. Instead of <middle_name> your code should enter a random string every time.		
		String str = "abcdefghijklmnopqrstuvwxyz";
		String name = "";
		for (int i = 0; i < 7; i++) {
			name += str.charAt( r.nextInt(str.length()));
		}
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("John" + " "+ name + " "+ "Smith");
		
//		7. Enter street: 123 Any st		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Any st");
		
//		8. Enter City: Anytown	
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Anytown");
		
//		9. Enter State: Virginia
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
		
//		10. Enter a random 5 digit number to the zip code field
		String zip = "";
		for (int i = 0; i < 5; i++) {
			zip += Integer.valueOf( r.nextInt( 10-1) + 1);
		}
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);
		
//		11. Select any card type. Every time your code should select a different type.
//		12. Enter any card number. If you selected Visa, card number should start with 4. 
//		If you selected Master, card number should start with 5. 
//		If you selected American Express, card number should start with 3. 
//		New card number should be auto generated every time you run the test. 
//		Card numbers should be 16 digits for Visa and Master, 15 for American Express.
		
		int visa = r.nextInt(3) + 1;
		switch (visa) {
		case 1:
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("4" + cardNumber());
			break;
		case 2:
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("5" + cardNumber());
			break;
		case 3:
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("3" + cardNumberAmericanExpress());
			break;
		}
		
//		13. Enter any valid expiration date 	
		Integer m = r.nextInt(13-1) + 1;
		String month = "";
		if(m < 10) {
			month  = "0" + m;
		}else {
			month = m + "";
		}
		int year = r.nextInt(23-18) + 18;
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys(month + "/" + year);
//		14. Click on Process		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
//		15. Verify than the page contains text New order has been successfully added.
		String expected = "New order has been successfully added.";
		if(driver.getPageSource().contains(expected)) {
			System.out.println("Order has been placed");
		}else {
			System.out.println("Oops! Something went wrong. Check your details carefully");
		}
	}

	public static String cardNumber() {
		String num = "";
		Random r = new Random();
		for (int i = 0; i < 15; i++) {
			num += r.nextInt(10-1) + 1;
		}
		return num;
	}
	public static String cardNumberAmericanExpress() {
		String num = "";
		Random r = new Random();
		for (int i = 0; i < 14; i++) {
			num += r.nextInt(10-1) + 1;
		}
		return num;
	}
}
