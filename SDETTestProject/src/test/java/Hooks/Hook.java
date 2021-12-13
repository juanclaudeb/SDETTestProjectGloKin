package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Hook {

    private static WebDriver driver;

    @Before
    public void setup() {
        var projectDir = System.getProperty("user.dir");

        System.out.println("Setup initiated");
        System.setProperty("webdriver.chrome.driver", projectDir + "/src/main/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        //options.addArguments("--headless");
        //options.addArguments("--no-sandbox");

        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        driver.close();
        driver.quit();
    }

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        return driver;
    }
}
