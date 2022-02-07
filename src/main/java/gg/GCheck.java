package gg;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GCheck {

	public static void main(String[] args) throws MalformedURLException {
		
		ChromeOptions opt=new ChromeOptions();

		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.5:9091"), opt);

		driver.get("http://google.com");
	}

}
