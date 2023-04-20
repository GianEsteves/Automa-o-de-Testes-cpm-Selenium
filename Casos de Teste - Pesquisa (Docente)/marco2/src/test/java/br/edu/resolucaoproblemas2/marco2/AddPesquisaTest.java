package br.edu.resolucaoproblemas2.marco2;

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

class AddPesquisaTest {
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
		WebElement access = driver.findElement(By.xpath("//*[@id='usernavigation']/div[3]/div/span/a"));
		access.click();

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(data.get("password").toString());

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();

		WebElement myCoursesNavBar = driver.findElement(By.linkText(data.get("myCoursesNavBar").toString()));
		myCoursesNavBar.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement myCourse = driver.findElement(By.xpath("//*[@id='course-info-container-8-3']/div/div/a/span[3]"));
		myCourse.click();

		WebElement setMode = driver.findElement(By.name("setmode"));
		if (!setMode.isSelected()) {
			setMode.click();
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Adicionar")));

		WebElement colapseBtn;
		try {
			colapseBtn = driver.findElement(By.cssSelector("#collapssesection7[aria-expanded='true']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", colapseBtn);
		} catch (NoSuchElementException e) {
			colapseBtn = driver.findElement(By.cssSelector("#collapssesection7[aria-expanded='false']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", colapseBtn);
			colapseBtn.click();
		}

		WebElement addOption = driver.findElement(By.xpath("//*[@id=\'coursecontentcollapse8\']/button/span[2]"));
		addOption.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement researchOption = driver.findElement(By.linkText(data.get("researchOption").toString()));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", researchOption);
		researchOption.click();
	}

	@AfterEach
	public void tearDownTest() throws Exception {
		driver.quit();
	}

	@Test
	void addPesquisa001() {
		// Cria pesquisa com nome
		JSONObject data = (JSONObject) testInput.get("addPesquisa001");

		WebElement researchName = driver.findElement(By.id("id_name"));
		researchName.sendKeys(data.get("researchName").toString());

		WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
		saveAndShowBtn.click();

		WebElement actualResearchName = driver
				.findElement(By.xpath("//*[@id=\'page-header\']/div/div[2]/div[1]/div/div[2]/h1"));

		assertEquals(data.get("researchName").toString(), actualResearchName.getText());
	}

	@Test
	void addPesquisa002() {
		// Cria pesquisa sem nome
		WebElement researchName = driver.findElement(By.id("id_name"));
		researchName.click();

		WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
		saveAndShowBtn.click();

		WebElement alertError = driver.findElement(By.id("id_error_name"));

		assertTrue(alertError.isDisplayed());
	}

	@Test
	void addPesquisa003() {
		// A caixa de texto "Descrição" não expande
		JSONObject data = (JSONObject) testInput.get("addPesquisa003");

		WebElement taskName = driver.findElement(By.id("id_name"));
		taskName.click();

		WebElement description = driver.findElement(By.id("id_introeditoreditable"));
		description.click();
		description.sendKeys(data.get("description").toString());

		WebElement alertError = driver.findElement(By.id("id_error_name"));
		boolean errorIsDisplayed = ((JavascriptExecutor) driver).executeScript(
				"var element = arguments[0]; " + "var rect = element.getBoundingClientRect(); " + "return ( "
						+ "rect.top >= 0 && " + "rect.left >= 0 && "
						+ "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) && "
						+ "rect.right <= (window.innerWidth || document.documentElement.clientWidth) " + ");",
				alertError) == Boolean.TRUE;

		assertTrue(errorIsDisplayed);
	}

	@Test
	void addPesquisa004() {
		// Permissão de respostas com data antiga
		JSONObject data = (JSONObject) testInput.get("addPesquisa004");

		WebElement researchName = driver.findElement(By.id("id_name"));
		researchName.sendKeys(data.get("researchName").toString());

		WebElement disponibilityOptions = driver.findElement(By.id("collapseElement-1"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", disponibilityOptions);
		disponibilityOptions.click();

		WebElement timeOpen = driver.findElement(By.id("id_timeopen_enabled"));
		if (!timeOpen.isSelected()) {
			timeOpen.click();
		}

		WebElement timeOpenYear = driver.findElement(By.id("id_timeopen_year"));
		timeOpenYear.sendKeys(data.get("timeOpenYear").toString());

		WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
		saveAndShowBtn.click();

		WebElement alertError = driver.findElement(By.id("id_error_timeopen"));

		assertTrue(alertError.isDisplayed());
	}

	@Test
	void addPesquisa005() {
		// Data limite de respostas com data antiga
		JSONObject data = (JSONObject) testInput.get("addPesquisa005");

		WebElement researchName = driver.findElement(By.id("id_name"));
		researchName.sendKeys(data.get("researchName").toString());

		WebElement disponibilityOptions = driver.findElement(By.id("collapseElement-1"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", disponibilityOptions);
		disponibilityOptions.click();

		WebElement timeClose = driver.findElement(By.id("id_timeclose_enabled"));
		if (!timeClose.isSelected()) {
			timeClose.click();
		}

		WebElement timeCloseYear = driver.findElement(By.id("id_timeclose_year"));
		timeCloseYear.sendKeys(data.get("timeCloseYear").toString());

		WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
		saveAndShowBtn.click();

		WebElement alertError = driver.findElement(By.id("id_error_timeclose"));

		assertTrue(alertError.isDisplayed());
	}
	
	@Test
	void addPesquisa006() {
		// Permissão de respostas com data futura e data limite com data antiga
		JSONObject data = (JSONObject) testInput.get("addPesquisa006");

		WebElement researchName = driver.findElement(By.id("id_name"));
		researchName.sendKeys(data.get("researchName").toString());

		WebElement disponibilityOptions = driver.findElement(By.id("collapseElement-1"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", disponibilityOptions);
		disponibilityOptions.click();

		WebElement timeOpen = driver.findElement(By.id("id_timeopen_enabled"));
		if (!timeOpen.isSelected()) {
			timeOpen.click();
		}

		WebElement timeOpenYear = driver.findElement(By.id("id_timeopen_year"));
		timeOpenYear.sendKeys(data.get("timeOpenYear").toString());
		
		WebElement timeClose = driver.findElement(By.id("id_timeclose_enabled"));
		if (!timeClose.isSelected()) {
			timeClose.click();
		}

		WebElement timeCloseYear = driver.findElement(By.id("id_timeclose_year"));
		timeCloseYear.sendKeys(data.get("timeCloseYear").toString());

		WebElement saveAndShowBtn = driver.findElement(By.id("id_submitbutton"));
		saveAndShowBtn.click();

		WebElement alertError = driver.findElement(By.id("id_error_timeclose"));
		
		assertTrue(alertError.isDisplayed());
	}
}
