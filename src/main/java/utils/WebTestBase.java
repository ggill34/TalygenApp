package utils;

import java.net.MalformedURLException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentTest;

public class WebTestBase extends Drivers {

	public RemoteWebDriver driver;
	public ExtentTest test;
	public static Logger logger;
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

//	@AfterSuite(alwaysRun = true)
//	public void close() {
//		closeReport();
//	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setup() throws MalformedURLException {
		String url = prop.getProperty("url");
		String browser = prop.getProperty("browser");

		// if (browser.equalsIgnoreCase("firefox")) {
		// driver = new FirefoxDriver();
		// } else if (browser.equalsIgnoreCase("chrome")) {
		// driver1 = new ChromeDriver();
		// } else if (browser.equalsIgnoreCase("edge")) {
		// driver2 = new EdgeDriver();
		// }
		System.out.println(url);
		driver = new Drivers().getWebDriver(browser);
		driver.get("https://app.talygen.com");
		driver.manage().window().maximize();
	}

//    @BeforeMethod()
//    public void beforeMethod(Method method) {
//        logger = Logger.getLogger(method.getDeclaringClass().getSimpleName() + "-" + method.getName());
//        test = getTest(method.getDeclaringClass().getSimpleName() + "-" + method.getName(), method.getName());
//        System.out.println("Method Name - "+method.getDeclaringClass().getSimpleName() + "-" + method.getName());
//    }

//    @AfterMethod(alwaysRun = true)
//    public void reportWrapUp(ITestResult result, Method method) {
//
//        if (!result.isSuccess()) {
//
//            String imagePath = System.getProperty("user.dir") + "\\reports\\" + method.getName()+"_"+ new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//            // generate screenshot as a file object
//            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            try {
//                // copy file object to designated location
//                FileUtils.copyFile(scrFile, new File(imagePath + ".png"));
//                System.out.println(imagePath + ".png");
//                logger.info("Method - "+method.getName()+" failed , see the screenshot - "+imagePath + ".png");
//            } catch (Exception e) {
//                Assert.fail("Error while taking screenshot - " + e);
//            }
//        }
//        closeTest(test);
//    }

	@AfterClass(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}

}
