package org.test;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;

public class Forum {
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
    //Testando caminho feliz => respondendo um fórum, ou seja, adicionando um tópico de discussão
    @Test
    public void responderForum(){
        JSONObject data = (JSONObject) objeto.get("forum");
        this.auxiliar.mudarPapel(driver,"Estudante");
        this.auxiliar.responderForum(driver,data.get("assunto").toString(),data.get("mensagem").toString());

        String notificacao = driver.findElement(By.xpath("//span[@id='user-notifications']/div")).getText();
        System.out.println(notificacao);
        boolean esperado = notificacao.contains(data.get("notificacaoEnvio").toString());
        Assertions.assertTrue(esperado,"Ao responder um tópico(adicionar um tópico de discussão), espera-se uma mensagem de sucesso");
    }

    @Test
    public void responderTopico(){
        JSONObject data = (JSONObject) objeto.get("forum");
        this.auxiliar.mudarPapel(driver,"Estudante");
        //responde um topico de discussao
        this.auxiliar.responderTopico(driver,data.get("resposta").toString());

        //pegar o horário de agora
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
//        LocalDateTime agora = LocalDateTime.now();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        String quando = driver.findElement(By.xpath("//header[@id='post-header-368-638d1eda48abc638d1eda3401f6']/div[2]/div/time")).getText();
//
//        Assertions.assertTrue(quando.contains(dtf.format(agora)));

    }

    @Test
    public void excluirRespostaTopico(){
        this.auxiliar.mudarPapel(driver,"Estudante");
        //verifica se há resposta no tópico
        //boolean temRespostaTopico = this.auxiliar.verificarQuantidadeComentarios(driver) > 0;

        this.auxiliar.excluirRespostaTopico(driver);
        //verifica se houve uma mensagem de confirmação para a exlcusão da resposta
        String alert = driver.findElement(By.xpath("//span[@id='user-notifications']/div")).getText();
        Assertions.assertTrue(alert.contains("Post excluído"));
    }

    //O forum "Avisos" é restringido para pessoas que sejam do grupo "teste de automação". Como meu usuário não é,
    // o elemento avisos é nulo.
    @Test
    public void restricaoAcessoGrupo(){
       this.auxiliar.mudarPapel(driver,"Estudante");
        WebElement avisos = driver.findElement(By.xpath("//div/div[2]/div[2]/a"));
       try{
           avisos.click();
       }catch (NoSuchElementException e ){
           Assertions.assertNull(avisos);
       }
    }

    //É necessário ter pelo menos duas respostas em um tópico de discussão
    @Test
    public void filtroRespostaMaisAntiga(){
        JSONObject data = (JSONObject) objeto.get("forum");
        this.auxiliar.mudarPapel(driver,"Estudante");
        this.auxiliar.respostaMaisAntiga(driver,data.get("respostaRecente").toString());
        WebElement primeiraResposta = driver.findElement(By.xpath("//div[2]/article/div/div/header/div[2]/div/time"));
        String dataPrimeiraResposta = primeiraResposta.getAttribute("dateTime");
        WebElement segundaResposta = driver.findElement(By.xpath("//article[2]/div/div/header/div[2]/div/time"));
        String dataSegundaResposta = segundaResposta.getAttribute("datetime");
        LocalDate date1 = LocalDate.parse(dataPrimeiraResposta.substring(0,10));
        LocalDate date2 = LocalDate.parse(dataSegundaResposta.substring(0,10));

        //Se a data que está sendo comparada for anterior à data passada como argumento, um valor menor que zero será retornado
        int verify = date1.compareTo(date2);
        boolean verifyBoolean = true;
        if(verify < 0){
            Assertions.assertTrue(verifyBoolean);
        }else{
            verifyBoolean = false;
            Assertions.assertTrue(verifyBoolean);
        }

    }
    @Test
    public void filtroPorGrupo(){
        JSONObject data = (JSONObject) objeto.get("forum");
        this.auxiliar.mudarPapel(driver,"Estudante");
        this.auxiliar.gruposVisiveis(driver,data.get("nomeGrupo").toString());

        String grupoEncontrado = driver.findElement(By.xpath("//td[2]/a")).getText();

        Assertions.assertEquals(grupoEncontrado,data.get("nomeGrupo").toString());
    }

    //tentar responder uma discussão de um grupo que não faz parte
    @Test
    public void naoParticipanteGrupo(){
        JSONObject data = (JSONObject) objeto.get("forum");
        this.auxiliar.mudarPapel(driver,"Estudante");
        try {
            this.auxiliar.responderTopico(driver,data.get("resposta").toString());
        }catch (NoSuchElementException e ){
            Assertions.assertNull(null,"É possível comentar no forum apenas pessoas que participam de um determinado grupo");
        }

    }
    @AfterEach
    public void tearDownTest() throws Exception {
        driver.quit();
    }
}
