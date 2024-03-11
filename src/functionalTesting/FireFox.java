package functionalTesting;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class FireFox 
{
	public static void main (String [] args) throws Throwable
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://demo.dealsdray.com/mis/dashboard");
		driver.findElement(By.xpath("//input[@aria-invalid='false']")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[@class='MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-1usxxvf']")).click();
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root has-submenu compactNavItem css-46up3a']")).click();
		WebElement Order = driver.findElement(By.xpath("(//span[@class='sidenavHoverShow MuiBox-root css-i9zxpg'])[2]"));
		Order.click();
		driver.findElement(By.xpath("//button[@align='right']")).click();
		driver.findElement(By.xpath("//div[@class=\"MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall css-uodm64\"]")).click();
		
		
		Thread.sleep(3000);
		
		
		StringSelection path = new StringSelection("C:\\Users\\LENOVO\\Downloads\\demo-data.xlsx");
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(path,null);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
	
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class=\"MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root  css-6aomwy\"]")).click();
		Thread.sleep(3000);
		
		 
		driver.findElement(By.xpath("//button[@style=\"background-color: rgb(32, 108, 226);\"]")).click();
		Thread.sleep(2000);
		
		Alert alt =driver.switchTo().alert();
		 alt.accept();
		 
		Thread.sleep(2000);
		
		TakesScreenshot imgs = (TakesScreenshot)driver;
		File paths = new File("./Screenshot/fireFox.png");
		File img = imgs.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(img,paths); 
		Thread.sleep(3000);
		
		
		driver.quit();
		
				
	}



	}


