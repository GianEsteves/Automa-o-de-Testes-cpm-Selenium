package br.edu.resolucaoproblemas2.marco2;

import java.util.List;
import java.io.FileReader;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class AddTrfTest {
    private WebDriver driver;
    private JSONObject testInput;
    private final static String URL_TEST = "https://gmlunardi.pro.br/moodlerp2/";
    private final static String DRIVER_PATH = "resource/msedgedriver.exe";

    @BeforeEach
    public void openBrowser() throws Exception {
        testInput = (JSONObject) new JSONParser().parse(new FileReader("resource/testInput.json"));
        System.setProperty("webdriver.edge.driver", DRIVER_PATH);
        JSONObject data = (JSONObject) testInput.get("login");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(URL_TEST);

        WebElement access =
                driver.findElement(By.xpath("//*[@id='usernavigation']/div[3]/div/span/a"));
        access.click();

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(data.get("username").toString());

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(data.get("password").toString());

        WebElement loginBtn = driver.findElement(By.id("loginbtn"));
        loginBtn.click();

        WebElement myCoursesNavBar = driver
                .findElement(By.linkText(data.get("myCoursesNavBar").toString()));
        myCoursesNavBar.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement myCourse =
                driver.findElement(
                        By.xpath("//*[@id='course-info-container-8-3']/div/div/a/span[3]"));
        myCourse.click();

        WebElement setmode = driver.findElement(By.name("setmode"));
        if (!setmode.isSelected()) {
            setmode.click();
        }

        WebElement colapseBtn =
                driver.findElement(By.xpath("//*[@id='coursecontentcollapse5']/button/span[1]/i"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                colapseBtn);
        if (!colapseBtn.isSelected()) {
            colapseBtn.click();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement taskOption = driver.findElement(By.linkText(data.get("taskOption").toString()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                taskOption);
        taskOption.click();
    }

    @AfterEach
    public void tearDownTest() throws Exception {
        driver.quit();
    }

    @Test
    public void addTrf001() {
        // Tarefa somente com nome
        JSONObject data = (JSONObject) testInput.get("addTrf001");

        WebElement taskName = driver.findElement(By.id("id_name"));
        taskName.sendKeys(data.get("taskName").toString());

        WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
        saveAndShowBtn.click();

        WebElement actualTaskName = driver
                .findElement(By.xpath("//*[@id='page-header']/div/div[2]/div[1]/div/div[2]/h1"));

        assertEquals(data.get("taskName").toString(), actualTaskName.getText());
    }

    @Test
    public void addTrf002() {
        // Tarefa com nome e descrição
        JSONObject data = (JSONObject) testInput.get("addTrf002");

        WebElement taskName = driver.findElement(By.id("id_name"));
        taskName.sendKeys(data.get("taskName").toString());

        WebElement taskDescription = driver.findElement(By.id("id_introeditoreditable"));
        taskDescription.sendKeys(data.get("description").toString());

        WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
        saveAndShowBtn.click();

        WebElement actualDescription = driver
                .findElement(By.xpath(
                        "/html/body/div[5]/div[5]/div/div[3]/div/section/div[1]/div[2]/div/div/p"));

        assertEquals(data.get("description").toString(), actualDescription.getText());
    }

    @Test
    public void addTrf003() {
        // Tarefa com nome e descrições
        JSONObject data = (JSONObject) testInput.get("addTrf003");

        WebElement taskName = driver.findElement(By.id("id_name"));
        taskName.sendKeys(data.get("taskName").toString());

        WebElement taskDescription = driver.findElement(By.id("id_introeditoreditable"));
        taskDescription.sendKeys(data.get("description").toString());

        WebElement taskDescriptionActivity = driver.findElement(By.id("id_activityeditoreditable"));
        taskDescriptionActivity.sendKeys(data.get("activity").toString());

        WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
        saveAndShowBtn.click();

        WebElement userMenu = driver.findElement(By.id("user-menu-toggle"));
        userMenu.click();

        WebElement changeRole =
                driver.findElement(By.partialLinkText(data.get("changeRole").toString()));
        changeRole.click();

        WebElement studentRole = driver.findElement(By.xpath(
                "/html/body/div[5]/div[5]/div/div[3]/div/section/div/div[3]/div/form/button"));
        studentRole.click();

        WebElement sendActivity = driver.findElement(By.xpath(
                "/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[1]/div/div/div/form/button"));
        sendActivity.click();
        
        WebElement actualDescriptionActivity = driver
                .findElement(By.xpath(
                        "/html/body/div[3]/div[4]/div/div[2]/div/section/div[1]/div[2]/div/div[2]/p"));
        String actualDescriptionActivityText = actualDescriptionActivity.getText();

        assertEquals(data.get("activity").toString(), actualDescriptionActivityText);
    }

    @Test
    public void addTrf004() {
        // Tarefa sem nome
        WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
        saveAndShowBtn.click();

        WebElement alertError = driver.findElement(By.id("id_error_name"));

        assertTrue(alertError.isDisplayed());
    }

    @Test
    public void addTrf005() {
        // A caixa de texto "Descrição" não expande
        JSONObject data = (JSONObject) testInput.get("addTrf005");

        WebElement taskName = driver.findElement(By.id("id_name"));
        taskName.click();

        WebElement description = driver.findElement(By.id("id_introeditoreditable"));
        description.click();
        description.sendKeys(data.get("description").toString());

        WebElement alertError = driver.findElement(By.id("id_error_name"));
        boolean errorIsDisplayed = ((JavascriptExecutor) driver).executeScript(
                "var element = arguments[0]; " +
                        "var rect = element.getBoundingClientRect(); " +
                        "return ( " +
                        "rect.top >= 0 && " +
                        "rect.left >= 0 && " +
                        "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && "
                        +
                        "rect.right <= (window.innerWidth || document.documentElement.clientWidth) "
                        +
                        ");",
                alertError) == Boolean.TRUE;

        assertTrue(errorIsDisplayed);
    }

    @Test
    public void addTrf006() {
        // A caixa de texto "Descrição da atividade" não expande
        JSONObject data = (JSONObject) testInput.get("addTrf006");

        WebElement taskName = driver.findElement(By.id("id_name"));
        taskName.click();

        WebElement description = driver.findElement(By.id("id_activityeditoreditable"));
        description.click();
        description.sendKeys(data.get("description").toString());

        WebElement alertError = driver.findElement(By.id("id_error_name"));
        boolean errorIsDisplayed = ((JavascriptExecutor) driver).executeScript(
                "var element = arguments[0]; " +
                        "var rect = element.getBoundingClientRect(); " +
                        "return ( " +
                        "rect.top >= 0 && " +
                        "rect.left >= 0 && " +
                        "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && "
                        +
                        "rect.right <= (window.innerWidth || document.documentElement.clientWidth) "
                        +
                        ");",
                alertError) == Boolean.TRUE;

        assertTrue(errorIsDisplayed);
    }

    @Test
    public void addTrf007() {
        // Permissão de envio com data antiga
        JSONObject data = (JSONObject) testInput.get("addTrf007");

        WebElement taskName = driver.findElement(By.id("id_name"));
        taskName.sendKeys(data.get("taskName").toString());

        WebElement allowSubmissions = driver.findElement(By.id("id_allowsubmissionsfromdate_year"));
        allowSubmissions.click();
        allowSubmissions.sendKeys(data.get("year").toString());

        WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
        saveAndShowBtn.click();

        WebElement alertError = driver.findElement(By.id("allowsubmissionsfromdate"));

        assertFalse(alertError.isDisplayed());
    }

    @Test
    public void addTrf008() {
        // Data de entrega com data antiga
        JSONObject data = (JSONObject) testInput.get("addTrf008");

        WebElement taskName = driver.findElement(By.id("id_name"));
        taskName.sendKeys(data.get("taskName").toString());

        WebElement deliverDate = driver.findElement(By.id("id_duedate_year"));
        deliverDate.click();
        deliverDate.sendKeys(data.get("year").toString());

        WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
        saveAndShowBtn.click();

        WebElement alertError = driver.findElement(By.id("id_error_duedate"));

        assertTrue(alertError.isDisplayed());
    }

    @Test
    public void addTrf009() {
        // Data limite de envio com data antiga
        JSONObject data = (JSONObject) testInput.get("addTrf009");

        WebElement taskName = driver.findElement(By.id("id_name"));
        taskName.sendKeys(data.get("taskName").toString());

        WebElement selectBox = driver.findElement(By.id("id_cutoffdate_enabled"));
        if (!selectBox.isSelected()) {
            selectBox.click();
        }

        WebElement deliverDate = driver.findElement(By.id("id_cutoffdate_year"));
        deliverDate.click();
        deliverDate.sendKeys(data.get("year").toString());

        WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
        saveAndShowBtn.click();

        WebElement alertError = driver.findElement(By.id("id_error_cutoffdate"));

        assertTrue(alertError.isDisplayed());
    }

    @Test
    public void addTrf010() {
        // Lembrete de avaliação com data antiga
        JSONObject data = (JSONObject) testInput.get("addTrf010");

        WebElement taskName = driver.findElement(By.id("id_name"));
        taskName.sendKeys(data.get("taskName").toString());

        WebElement deliverDate = driver.findElement(By.id("id_gradingduedate_year"));
        deliverDate.click();
        deliverDate.sendKeys(data.get("year").toString());

        WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
        saveAndShowBtn.click();

        WebElement alertError = driver.findElement(By.id("id_error_gradingduedate"));

        assertTrue(alertError.isDisplayed());
    }

    @Test
    public void addTrf011() {
        // Tarefa sem envio
        JSONObject data = (JSONObject) testInput.get("addTrf011");

        WebElement taskName = driver.findElement(By.id("id_name"));
        taskName.sendKeys(data.get("taskName").toString());

        WebElement sendTextSelectBox =
                driver.findElement(By.id("id_assignsubmission_onlinetext_enabled"));
        if (sendTextSelectBox.isSelected()) {
            sendTextSelectBox.click();
        }

        WebElement sendFileSelectBox =
                driver.findElement(By.id("id_assignsubmission_file_enabled"));
        if (sendFileSelectBox.isSelected()) {
            sendFileSelectBox.click();
        }

        WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
        saveAndShowBtn.click();

        WebElement userMenu = driver.findElement(By.id("user-menu-toggle"));
        userMenu.click();

        WebElement changeRole =
                driver.findElement(By.partialLinkText(data.get("changeRole").toString()));
        changeRole.click();

        WebElement studentRole = driver.findElement(By.xpath(
                "/html/body/div[5]/div[5]/div/div[3]/div/section/div/div[3]/div/form/button"));
        studentRole.click();

        WebElement status = driver.findElement(By.xpath(
                "/html/body/div[3]/div[4]/div/div[2]/div/section/div[2]/div[2]/div/div/table/tbody/tr[1]/td"));
        String taskStatus = status.getText();

        assertEquals(data.get("taskStatus").toString(), taskStatus);
    }
}
