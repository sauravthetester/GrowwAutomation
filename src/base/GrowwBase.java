package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class GrowwBase {
	public static String OSType = null;
	public static String configFile = System.getProperty("user.dir")+"/src/config/config.properties";
	public static Properties prop;
	
	public static WebDriver driver;
	
	public GrowwBase()
	{
		try 
        {
            prop = new Properties();
            FileInputStream file = new FileInputStream(configFile);
            prop.load(file);
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
	}
	public void initialize()
    {
		ChromeOptions chromeOptions = new ChromeOptions();
    	WebDriverManager.chromedriver().setup();
    	driver = new ChromeDriver(chromeOptions);
    	
    	driver.get("https://groww.in/");

    	driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    	
    	
    }

	public void cleanUp() 
	{
		
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{
			String child_window=I1.next();
	
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		
	}

}
