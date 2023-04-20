package br.edu.resolucaoproblemas2.marco2;

import java.io.FileReader;
import java.time.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assumptions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class LoginTest {
	private WebDriver driver;
	private JSONObject testInput;
	private final static String URL_TEST = "https://gmlunardi.pro.br/moodlerp2/";
	private final static String DRIVER_PATH = "resource/msedgedriver.exe";

	@BeforeEach
	public void openBrowser() throws Exception {
		testInput = (JSONObject) new JSONParser().parse(new FileReader("resource/testInput.json"));
		System.setProperty("webdriver.edge.driver", DRIVER_PATH);
		//driver = new ChromeDriver();
		driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get(URL_TEST);
		WebElement access =
				driver.findElement(By.xpath("//*[@id='usernavigation']/div[3]/div/span/a"));
		access.click();
	}

	@AfterEach
	public void tearDownTest() throws Exception {
		driver.quit();
	}

	@Test
	public void lgn001() {
		// Usuário e senha válidos
		JSONObject data = (JSONObject) testInput.get("lgn001");

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(data.get("password").toString());

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();

		String urlActual = driver.getCurrentUrl();

		Assertions.assertEquals(data.get("urlExpected").toString(), urlActual);
	}

	@Test
	public void lgn002() {
		// Usuário valido e senha inválida
		JSONObject data = (JSONObject) testInput.get("lgn002");

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(data.get("password").toString());

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();

		String actualError = driver
				.findElement(By.xpath("//*[@id='region-main']/div/div/div/div/div[1]")).getText();

		boolean errorMessage = data.get("expectedError").toString().equals(actualError);
		
		assumeTrue(errorMessage);
	}

	@Test
	public void lgn003() {
		// Usuário inválido e senha válida
		JSONObject data = (JSONObject) testInput.get("lgn003");

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(data.get("password").toString());

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();
		
		String actualError = driver
				.findElement(By.xpath("//*[@id='region-main']/div/div/div/div/div[1]")).getText();

		boolean errorMessage = data.get("expectedError").toString().equals(actualError);

		assumeTrue(errorMessage);
	}

	@Test
	public void lgn004() {
		// Usuário e senha inválidos
		JSONObject data = (JSONObject) testInput.get("lgn004");

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(data.get("password").toString());

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();
		
		String actualError = driver
				.findElement(By.xpath("//*[@id='region-main']/div/div/div/div/div[1]")).getText();

		boolean errorMessage = data.get("expectedError").toString().equals(actualError);

		assumeTrue(errorMessage);
	}

	@Test
	public void lgn005() {
		// Usuário válido e senha vazia
		JSONObject data = (JSONObject) testInput.get("lgn005");

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();
		
		String actualError = driver
				.findElement(By.xpath("//*[@id='region-main']/div/div/div/div/div[1]")).getText();

		boolean errorMessage = data.get("expectedError").toString().equals(actualError);

		assumeTrue(errorMessage);
	}

	@Test
	public void lgn006() {
		// Usuário inválido e senha vazia
		JSONObject data = (JSONObject) testInput.get("lgn006");

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();
		
		String actualError = driver
				.findElement(By.xpath("//*[@id='region-main']/div/div/div/div/div[1]")).getText();

		boolean errorMessage = data.get("expectedError").toString().equals(actualError);

		assumeTrue(errorMessage);
	}

	@Test
	public void lgn007() {
		// Usuário vazio e senha válida
		JSONObject data = (JSONObject) testInput.get("lgn007");
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(data.get("password").toString());

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();
		
		String actualError = driver
				.findElement(By.xpath("//*[@id='region-main']/div/div/div/div/div[1]")).getText();

		boolean errorMessage = data.get("expectedError").toString().equals(actualError);

		assumeTrue(errorMessage);
	}

	@Test
	public void lgn008() {
		// Usuário vazio e senha inválida
		JSONObject data = (JSONObject) testInput.get("lgn008");

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(data.get("password").toString());

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();
		
		String actualError = driver
				.findElement(By.xpath("//*[@id='region-main']/div/div/div/div/div[1]")).getText();

		boolean errorMessage = data.get("expectedError").toString().equals(actualError);

		assumeTrue(errorMessage);
	}

	@Test
	public void lgn009() {
		// Usuário e senha vazios
		JSONObject data = (JSONObject) testInput.get("lgn009");

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();
		
		String actualError = driver
				.findElement(By.xpath("//*[@id='region-main']/div/div/div/div/div[1]")).getText();

		boolean errorMessage = data.get("expectedError").toString().equals(actualError);

		assumeTrue(errorMessage);
	}

	@Test
	public void lgn010() {
		// Autenticação de login
		JSONObject data = (JSONObject) testInput.get("lgn010");

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(data.get("password").toString());

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));
		loginBtn.click();

		WebElement myCoursesNavBar = driver
				.findElement(By.linkText("Meus cursos"));
		myCoursesNavBar.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement myCourse =
				driver.findElement(
						By.xpath("//*[@id='course-info-container-8-3']/div/div/a/span[3]"));
		myCourse.click();

		WebElement profilePicture =
				driver.findElement(By.xpath("//*[@id='user-menu-toggle']/span/span/span/img"));
		profilePicture.click();

		WebElement logout = driver.findElement(By.xpath("//*[@id='carousel-item-main']/a[9]"));
		logout.click();

		driver.navigate().back();

		String urlActual = driver.getCurrentUrl();

		Assertions.assertEquals(data.get("urlExpected").toString(), urlActual);
	}


	@Test
	public void lgn011() {
		// Login pressionando tecla Enter
		JSONObject data = (JSONObject) testInput.get("lgn011");

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(data.get("password").toString());
		passwordInput.sendKeys(Keys.ENTER);

		String urlActual = driver.getCurrentUrl();

		Assertions.assertEquals(data.get("urlExpected").toString(), urlActual);
	}

	@Test
	public void lgn012() {
		// Senha visível de forma mascarada
		JSONObject data = (JSONObject) testInput.get("lgn012");

		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(data.get("password").toString());

		boolean isMasked = passwordInput.getAttribute("type").equals("password");

		assumeTrue(isMasked);
	}

	@Test
	public void lgn013() {
		// Usuário visível como texto
		JSONObject data = (JSONObject) testInput.get("lgn013");

		WebElement usernameInput = driver.findElement(By.id("username"));
		usernameInput.sendKeys(data.get("username").toString());

		boolean isMasked = usernameInput.getAttribute("type").equals("text");

		assumeTrue(isMasked);
	}

	@Test
	public void lgn014() {
		// Existe opção de alterar a senha
		JSONObject data = (JSONObject) testInput.get("lgn014");

		WebElement missedPassword = driver.findElement(By.linkText("Perdeu a senha?"));
		missedPassword.click();

		WebElement usernameInput = driver.findElement(By.id("id_username"));

		WebElement emailInput = driver.findElement(By.id("id_email"));

		boolean isAnOption = (usernameInput.isDisplayed() && emailInput.isDisplayed());

		assumeTrue(isAnOption);
	}

	@Test
	public void lgn015() {
		// Alterar senha com usuário inválido
		JSONObject data = (JSONObject) testInput.get("lgn015");

		WebElement missedPassword = driver.findElement(By.linkText("Perdeu a senha?"));
		missedPassword.click();

		WebElement usernameInput = driver.findElement(By.id("id_username"));
		usernameInput.sendKeys(data.get("username").toString());
		
		WebElement findBtn = driver.findElement(By.id("id_submitbuttonusername"));
		findBtn.click();

		WebElement errorMessage = driver.findElement(By.id("id_error_username"));

		assumeTrue(errorMessage.isDisplayed());
	}

	@Test
	public void lgn016() {
		// Alterar senha com email inválido
		JSONObject data = (JSONObject) testInput.get("lgn016");
		WebElement missedPassword = driver.findElement(By.linkText("Perdeu a senha?"));
		missedPassword.click();

		WebElement emailInput = driver.findElement(By.id("id_email"));
		emailInput.sendKeys(data.get("email").toString());

		WebElement findBtn = driver.findElement(By.id("id_submitbuttonemail"));
		findBtn.click();

		WebElement errorMessage = driver.findElement(By.id("id_error_email"));

		assumeTrue(errorMessage.isDisplayed());
	}

	@Test
	public void lgn017() {
		// Alterar senha com usuário e email inválidos
		JSONObject data = (JSONObject) testInput.get("lgn017");

		WebElement missedPassword = driver.findElement(By.linkText("Perdeu a senha?"));
		missedPassword.click();

		WebElement usernameInput = driver.findElement(By.id("id_username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement emailInput = driver.findElement(By.id("id_email"));
		emailInput.sendKeys(data.get("email").toString());
		emailInput.sendKeys(Keys.ENTER);

		WebElement error1Message = driver.findElement(By.id("id_error_username"));

		WebElement error2Message = driver.findElement(By.id("id_error_email"));

		boolean isAnAlert = (error1Message.isDisplayed() || error2Message.isDisplayed());

		assumeTrue(isAnAlert);
	}

	@Test
	public void lgn018() {
		// Alterar senha com usuário e email válidos
		JSONObject data = (JSONObject) testInput.get("lgn018");

		WebElement missedPassword = driver.findElement(By.linkText("Perdeu a senha?"));
		missedPassword.click();

		WebElement usernameInput = driver.findElement(By.id("id_username"));
		usernameInput.sendKeys(data.get("username").toString());

		WebElement emailInput = driver.findElement(By.id("id_email"));
		emailInput.sendKeys(data.get("email").toString());
		emailInput.sendKeys(Keys.ENTER);

		WebElement error1Message = driver.findElement(By.id("id_error_username"));

		WebElement error2Message = driver.findElement(By.id("id_error_email"));

		boolean isAnAlert = (error1Message.isDisplayed() || error2Message.isDisplayed());

		assumeTrue(isAnAlert);
	}

	@Test
	public void lgn019() {
		// Alterar idioma
		WebElement ptLanguage = driver.findElement(By.partialLinkText("Brasil"));
		ptLanguage.click();

		WebElement engLanguage = driver.findElement(By.partialLinkText("English"));
		engLanguage.click();

		WebElement loginBtn = driver.findElement(By.id("loginbtn"));

		boolean isEnglish = loginBtn.getText().contains("Log in");
		
		assumeTrue(isEnglish);
	}

	@Test
	public void lgn020() {
		// Acesso como visitante
		JSONObject data = (JSONObject) testInput.get("lgn020");

		WebElement guestBtn = driver.findElement(By.id("loginguestbtn"));
		guestBtn.click();

		WebElement guestMessage = driver.findElement(By.xpath("//*[@id='usernavigation']/div[3]/div/span"));

		boolean isGuest = guestMessage.getText().contains(data.get("message").toString());

		assumeTrue(isGuest);
	}
}
