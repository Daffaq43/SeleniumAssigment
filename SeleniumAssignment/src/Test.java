import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {
	
		//Website yang dipilih merupakan website " Myskill" 
		//Setup awal pada browser (google chrome) dan web yang digunakan
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://myskill.id/");
		
		// Proses menekan login pada website
		Thread.sleep(2000);
		WebElement login=driver.findElement(By.cssSelector("[href='/auth/login/?next=/']"));
		login.click();		
		
		// Proses memasukkan email yang salah pada website
		Thread.sleep(2000);
		WebElement username=driver.findElement(By.cssSelector("[name=\'email\']"));
		username.sendKeys("daffaqmemo@yahoo.com");
		
		// Memilih email dan menghapus email salah
		Thread.sleep(3000);
		Actions actions = new Actions (driver);
		actions.click(driver.findElement(By.cssSelector("[name=\'email\']")))
		.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL)
		.sendKeys(Keys.BACK_SPACE)
		.build()
		.perform();
		
		// Memasukkan email yang benar pada website
		Thread.sleep(2000);
		WebElement username1=driver.findElement(By.cssSelector("[name=\'email\']"));
		username1.sendKeys("daffaqmemo@gmail.com");
		
		// Memasukkan password 
		Thread.sleep(1000);
		WebElement password=driver.findElement(By.cssSelector("[name=\'password\']"));
		password.sendKeys("tesajadong");
		
		// Menekan icon (mata) untuk melihat password yang ditulis
		Thread.sleep(1500);
		WebElement clickSee=driver.findElement(By.cssSelector("[type=\'button\']"));
		clickSee.click();
		
		// Menekan button login untuk masuk kedalam website
		Thread.sleep(1500);
		WebElement login1=driver.findElement(By.cssSelector("[type=\'submit\']"));
		login1.click();

	}

}