package org.test;


import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.function.Supplier;

import javax.xml.xpath.XPath;
public class CorrecaoAtividade {

    private static final String URL = "https://gmlunardi.pro.br/moodlerp2/login/index.php";
    private JSONObject objeto;
    private WebDriver driver = new ChromeDriver();

    Auxiliar auxiliar = new Auxiliar();

    @BeforeEach
    public void loginSystem() throws Exception{

        try {
            JSONParser jsonParser = new JSONParser();
            FileReader arquivo = new FileReader("C:\\Users\\d00ne\\IdeaProjects\\MoodleAutomationTest\\src\\main\\java\\org\\data\\file.json");
            Object objetoJson =  jsonParser.parse(arquivo);

            objeto = new JSONObject(objetoJson.toString());

            JSONObject data = (JSONObject) objeto.get("login");
            driver.get(URL);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
            username.sendKeys(data.get("usuario").toString());
            WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
            password.sendKeys(data.get("senha").toString());
            WebElement button = driver.findElement(By.xpath("//*[@id=\"loginbtn\"]"));
            button.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://gmlunardi.pro.br/moodlerp2/my/courses.php");
            WebElement course = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/section/div/aside/section/div/div/div[1]/div[2]/div/div/div[1]/div/div/div/div[1]/div/div"));
            course.click();
            WebElement courseName = driver.findElement(By.xpath("//div[@id='course-info-container-8-3']/div/div/a/span[3]"));
            courseName.click();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    //Veriifica se todos matriculados enviaram a atividade
    @Test
    public void todosEnviaramTeste(){
        WebElement atividade = driver.findElement(By.xpath("//li[5]/div/div/div/div/div/div[2]/div[2]/a"));
        atividade.click();
        String participantes = driver.findElement(By.xpath("//tr[2]/td")).getText();
        String enviado = driver.findElement(By.xpath("//tr[3]/td")).getText();
        Assertions.assertEquals(participantes,enviado,"Se todos matriculados enviaram a atividade a resposta é verdadeira");
    }

    //Verifica se o professor já deu nota na atividade(avaliou a atividade)
    @Test
    public void atividadeJaAvaliada(){
        WebElement atividade = driver.findElement(By.xpath("//li[5]/div/div/div/div/div/div[2]/div[2]/a"));
        atividade.click();
        WebElement nota = driver.findElement(By.xpath("//section[@id='region-main']/div[2]/div/div/div[2]/a"));
        nota.click();
        String inputText = driver.findElement(By.xpath("//input[@id='id_grade']")).getAttribute("value");

        boolean inputPreenchido = !(inputText.isEmpty());
        Assertions.assertTrue(inputPreenchido, "Atividade já foi avaliada");
    }

    //Este teste precisa que não hajam notas atribuídas
    @Test
    public void notaValida(){
        //Insere nota da atividade
        JSONObject data = (JSONObject) objeto.get("correcaoAtividade");
        auxiliar.avaliarAtividade(this.driver,data.get("nota").toString());

        //compara se a nota inserido é válida
        WebElement nota = driver.findElement(By.xpath("//section[@id='region-main']/div[2]/div/div/div[2]/a"));
        nota.click();
        String input = driver.findElement(By.xpath("//input[@id='id_grade']")).getAttribute("value");
        boolean valorMaximo = Float.parseFloat(input.substring(0,1)) <= 100;
        boolean positiva = Float.parseFloat(input.substring(0,1)) >= 0;
        Assertions.assertTrue(valorMaximo && positiva, "Notas válidas estão entre 0 e 100.");
    }

    @Test
    public void comentarioUltrapassaLimite(){
        JSONObject data = (JSONObject) objeto.get("correcaoAtividade");
        //forçar inserção
        try{
            auxiliar.inserirComentario((this.driver),data.get("comentario").toString());
        }catch (Exception e){
            WebElement comentario = driver.findElement(By.xpath("//div/div[6]/div"));
            comentario.click();
            WebElement inserir = driver.findElement(By.xpath("//textarea"));
            inserir.click();
            inserir.sendKeys(data.get("comentario").toString());
            WebElement salvar = driver.findElement(By.xpath("//a[contains(text(),'Salvar comentário')]"));
            salvar.click();
        }
        int qtdeCaracteresComentario = data.get("comentario").toString().length();
        int qtdeDeveriaSerPermitida = Integer.parseInt(data.get("qtdeCaracteresMaxima").toString());
        Assertions.assertTrue(qtdeCaracteresComentario > qtdeDeveriaSerPermitida);

    }
    @AfterEach
    public void tearDownTest() throws Exception {
        driver.quit();
    }
}
