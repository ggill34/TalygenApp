package utils;

//import com.browserstack.local.Local;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Drivers {

	public RemoteWebDriver driver;
	public static final String path = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadedFiles\\";

	public RemoteWebDriver getWebDriver(String browser) throws MalformedURLException {
		
		if (browser.equals("firefox")) {
		System.out.println("FireFoxDriver was started successfully.");
		//commented the code for driver options need to used DesiredCapabilities
//			String downloadFilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadedFiles\\";
//			String firefoxDownloadDir = System.getProperty("user.dir") + "\\geckodriver.exe";
//			FirefoxOptions options = new FirefoxOptions();
//			FirefoxProfile profile = new FirefoxProfile();
//			profile.setPreference("browser.download.folderList", 2); // Use for the default download directory the last Set the last directory used for saving a file from the "What should (browser) do with this file?" dialog.															// folder specified for a download
//			profile.setPreference("browser.download.dir", downloadFilepath); 
//			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
//					"application/pdf, application/octet-stream, application/x-winzip, application/x-pdf, application/x-gzip, application/zip"); //list of MIME types to save to disk without asking what to use to open the file
//			profile.setPreference("browser.helperApps.neverAsk.openFile",
//					"application/pdf, application/octet-stream, application/x-winzip, application/x-pdf, application/x-gzip, application/zip");
//			options.setProfile(profile);

			// System.setProperty("webdriver.gecko.driver", firefoxDownloadDir);
			// driver = new FirefoxDriver(options);
			// driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName("firefox");
			URL url = new URL("http://localhost:4444");
			driver = new RemoteWebDriver(url, dc);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		} else if (browser.equals("chrome")) {
		System.out.println("ChromeDriver was started successfully.");
		//commented the code for driver options need to used DesiredCapabilities
		
//			String downloadFilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadedFiles\\";
//			String chromeDownloadDir = System.getProperty("user.dir") + "\\chromedriver.exe";
//
//			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
//			chromePrefs.put("profile.default_content_settings.popups", 0);
//			chromePrefs.put("download.default_directory", downloadFilepath);
//			chromePrefs.put("download.prompt_for_download", false);
//			chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);
//
//			ChromeOptions optionss = new ChromeOptions();
//			optionss.setExperimentalOption("prefs", chromePrefs);
//			optionss.addArguments("--disable-extensions");

			// System.setProperty("webdriver.chrome.driver", chromeDownloadDir); driver =
			// new ChromeDriver(options); driver.manage().timeouts().implicitlyWait(1,
			// TimeUnit.SECONDS);

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName("chrome");
			URL url = new URL("http://localhost:4444");
			driver = new RemoteWebDriver(url, dc);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
//		} else if (browser.equals("edge")) {
//			
//			String downloadFilepath = System.getProperty("user.dir") + "\\src\\main\\resources\\downloadedFiles\\";
//			String edgeDownloadDir = System.getProperty("user.dir") + "\\msedgedriver.exe";
//
//			HashMap<String, Object> edgePrefs = new HashMap<String, Object>();
//			edgePrefs.put("profile.default_content_settings.popups", 0);
//			edgePrefs.put("download.default_directory", downloadFilepath);
//			edgePrefs.put("download.prompt_for_download", false);
//			edgePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);
//				
//			DesiredCapabilities dc = new DesiredCapabilities();
//			dc.setBrowserName("edge");
//			URL url = new URL("http://localhost:4444/ui");
//			RemoteWebDriver driver = new RemoteWebDriver(url, dc);
//			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    	}

		return driver;
	}
}

