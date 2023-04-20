package br.edu.resolucaoproblemas2;

import java.io.FileReader;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {
    private WebDriver driver;
    private JSONObject testInput;
    private final static String URL_TEST = "https://gmlunardi.pro.br/moodlerp2/";
    private final static String DRIVER_PATH = "resource/msedgedriver.exe";
    private final static String JSON_PATH = "resource/testInput.json";

    @BeforeEach
    public void openBrowser() throws Exception {
        testInput = (JSONObject) new JSONParser().parse(new FileReader(JSON_PATH));
        System.setProperty("webdriver.edge.driver", DRIVER_PATH);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(URL_TEST);

        JSONObject data = (JSONObject) testInput.get("login");
        WebElement access =
                driver.findElement(By.xpath("//*[@id='usernavigation']/div[3]/div/span/a"));
        access.click();

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(data.get("username").toString());

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(data.get("password").toString());

        WebElement loginBtn = driver.findElement(By.id("loginbtn"));
        loginBtn.click();

        WebElement myCoursesNavBar =
                driver.findElement(By.linkText(data.get("myCoursesNavBar").toString()));
        myCoursesNavBar.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement myCourse = driver
                .findElement(By.xpath("//*[@id='course-info-container-8-3']/div/div/a/span[3]"));
        myCourse.click();

        WebElement setMode = driver.findElement(By.name("setmode"));
        if (!setMode.isSelected()) {
            setMode.click();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Adicionar")));

        WebElement colapseBtn;
        try {
            colapseBtn =
                    driver.findElement(By.cssSelector("#collapssesection7[aria-expanded='true']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                    colapseBtn);
        } catch (NoSuchElementException e) {
            colapseBtn =
                    driver.findElement(By.cssSelector("#collapssesection7[aria-expanded='false']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                    colapseBtn);
            colapseBtn.click();
        }

        WebElement addOption =
                driver.findElement(By.xpath("//*[@id=\'coursecontentcollapse8\']/button/span[2]"));
        addOption.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement quizOption =
                driver.findElement(By.linkText(data.get("quizOption").toString()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                quizOption);
        quizOption.click();
    }

    @AfterEach
    public void tearDownTest() throws Exception {
        driver.quit();
    }

}
