import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencsv.CSVReader;


    
public class TestsURL{

    private WebDriver driver = new ChromeDriver();


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tales\\Downloads\\Chromedriver\\chromedriver.exe");
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/");
        driver.manage().window().maximize();
    } 


    @Test
    public void levelUm(){
        try{
            String CSV = "C:\\Users\\tales\\Downloads\\Marco2\\Marco2\\dados.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {
                 
                    String identificacao = cell[0];
                    String senha = cell[0];
                    String nome = cell[1];
                    String urlExternaum = cell [2];
                    String descricao = cell [3];

                    // está buscando o botão acessar
                    WebElement acessar = driver.findElement(By.xpath("//span[@class='login pl-2']//a[contains(text(),'Acessar')]"));
                    acessar.click();
                
                    
                    // Preencher o campo "Identificação do Usuário" com seu login
                    WebElement identificacaoUsuario = driver.findElement(By.id("username"));
                    identificacaoUsuario.click();
                    identificacaoUsuario.sendKeys(identificacao);

                    //Preencher o campo "Senha" com sua senha
                    WebElement senhaUsuario = driver.findElement(By.id("password"));
                    senhaUsuario.click();
                    senhaUsuario.sendKeys(senha);
                    
                    // Clicar em acessar
                    WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
                    acessarBotao.click();

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no item "Meus cursos"
                    WebElement meusCursos = driver.findElement(By.xpath("//a[contains(@role,'menuitem')][normalize-space()='Meus cursos']"));
                    meusCursos.click();
                    Thread.sleep(2000);

                    // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
                    WebElement cursos = driver.findElement(By.xpath("//div[@class='card-img dashboard-card-img']"));
                    cursos.click();
                    Thread.sleep(2000);
                                        
                    // Clicar no botão ">" do tópico "Level 1"
                    WebElement botaoLevelUm = driver.findElement(By.xpath("//a[@id='collapssesection1']//i[contains(@class,'icon fa fa-chevron-right fa-fw')]"));
                    botaoLevelUm.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Adicionar uma atividade ou recurso"
                    WebElement adicionarRecurso = driver.findElement(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[2]"));
                    if(adicionarRecurso.isDisplayed()){
                        adicionarRecurso.click();
                    }
                    
                    Thread.sleep(2000);

                    // Clicar no recurso "URL"
                    WebElement recursoUrl = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    recursoUrl.click();

                    // // Clicar no botão ">" Geral
                    // WebElement botaoGeral = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    // botaoGeral.click();

                    // Preencher o campo "Nome"
                    WebElement campoNome = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNome.click();
                    Thread.sleep(2000);
                    campoNome.sendKeys(nome);

                    // Preencher o campo "URL externa"
                    WebElement urlExterna = driver.findElement(By.xpath("//input[@id='id_externalurl']"));
                    urlExterna.click();
                    Thread.sleep(2000);
                    urlExterna.sendKeys(urlExternaum);

                    // Preencher o campo "Descrição"
                    WebElement descricaoUm = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
                    descricaoUm.click();
                    Thread.sleep(2000);
                    descricaoUm.sendKeys(descricao);

                    // Clicar no botão "Exibir descrição na página do curso"
                    WebElement exibirDescricao = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
                    exibirDescricao.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

                    String mensagem = cell [1];

                    Assert.assertTrue(driver.getPageSource().contains(mensagem));
                    
            }
        }
     } catch (Exception e) {
            System.out.println("Erro ao fazer ao URL");
     }

    }



    @Test
    public void levelDois(){
        try{
            String CSV = "C:\\Users\\tales\\Downloads\\Marco2\\Marco2\\dados.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {
                    
                    String identificacao = cell[0];
                    String senha = cell[0];
                    String nome = cell[4];
                    String urlExternaDois = cell [5];
                    String descricao = cell [6];
                    
                    //está buscando o botão acessar
                    WebElement acessar = driver.findElement(By.xpath("//span[@class='login pl-2']//a[contains(text(),'Acessar')]"));
                    acessar.click();
                
                    // Preencher o campo "Identificação do Usuário" com seu login
                    WebElement identificacaoUsuario = driver.findElement(By.id("username"));
                    identificacaoUsuario.click();
                    identificacaoUsuario.sendKeys(identificacao);

                    //Preencher o campo "Senha" com sua senha
                    WebElement senhaUsuario = driver.findElement(By.id("password"));
                    senhaUsuario.click();
                    senhaUsuario.sendKeys(senha);
                    
                    // Clicar em acessar
                    WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
                    acessarBotao.click();

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no item "Meus cursos"
                    WebElement meusCursos = driver.findElement(By.xpath("//a[contains(@role,'menuitem')][normalize-space()='Meus cursos']"));
                    meusCursos.click();
                    Thread.sleep(2000);

                    // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
                    WebElement cursos = driver.findElement(By.xpath("//div[@class='card-img dashboard-card-img']"));
                    cursos.click();
                    Thread.sleep(2000);

                    // Clicar no botão ">" do tópico "Level 2"
                    WebElement botaoLevelDois = driver.findElement(By.xpath("//a[@id='collapssesection2']//i[contains(@class,'icon fa fa-chevron-right fa-fw')]"));
                    botaoLevelDois.click();

                    // Clicar no botão "Adicionar uma atividade ou recurso"
                    // WebElement adicionarRecurso = driver.findElement(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[3]"));
                    // if(adicionarRecurso.isDisplayed()){
                    //     adicionarRecurso.click();
                    // }

                    WebDriverWait waitI = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement adicionarRecurso = waitI.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[3]")));
                    adicionarRecurso.click();
                    Thread.sleep(2000);
                    
                    // Clicar no recurso "URL"
                    WebElement recursoUrl = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    recursoUrl.click();

                    // // Clicar no botão ">" Geral
                    // WebElement botaoGeral = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    // botaoGeral.click();

                    // Preencher o campo "Nome"
                    WebElement campoNome = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNome.click();
                    Thread.sleep(2000);
                    campoNome.sendKeys(nome);

                    // Preencher o campo "URL externa"
                    WebElement urlExterna = driver.findElement(By.xpath("//input[@id='id_externalurl']"));
                    urlExterna.click();
                    Thread.sleep(2000);
                    urlExterna.sendKeys(urlExternaDois);

                    // Preencher o campo "Descrição"
                    WebElement descricaoDois = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
                    descricaoDois.click();
                    Thread.sleep(1000);
                    descricaoDois.sendKeys(descricao);

                    // Clicar no botão "Exibir descrição na página do curso"
                    WebElement exibirDescricao = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
                    exibirDescricao.click();   

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();

                    String mensagem = cell [4];


                    Assert.assertTrue(driver.getPageSource().contains(mensagem));

            }

        }
     } catch (Exception e) {
            System.out.println("Erro ao fazer ao URL");
     }

    }



    @Test
    public void levelTres(){
        try{
            String CSV = "C:\\Users\\tales\\Downloads\\Marco2\\Marco2\\dados.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {

                    String identificacao = cell[0];
                    String senha = cell[0];
                    String nome = cell[7];
                    String urlExternaTres = cell [2];

                    
                    //está buscando o botão acessar
                    WebElement acessar = driver.findElement(By.xpath("//span[@class='login pl-2']//a[contains(text(),'Acessar')]"));
                    acessar.click();
                    
                    // Preencher o campo "Identificação do Usuário" com seu login
                    WebElement identificacaoUsuario = driver.findElement(By.id("username"));
                    identificacaoUsuario.click();
                    identificacaoUsuario.sendKeys(identificacao);

                    //Preencher o campo "Senha" com sua senha
                    WebElement senhaUsuario = driver.findElement(By.id("password"));
                    senhaUsuario.click();
                    senhaUsuario.sendKeys(senha);
                    
                    // Clicar em acessar
                    WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
                    acessarBotao.click();

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no item "Meus cursos"
                    WebElement meusCursos = driver.findElement(By.xpath("//a[contains(@role,'menuitem')][normalize-space()='Meus cursos']"));
                    meusCursos.click();
                    Thread.sleep(2000);

                    // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
                    WebElement cursos = driver.findElement(By.xpath("//div[@class='card-img dashboard-card-img']"));
                    cursos.click();
                    Thread.sleep(2000);

                    // Clicar no botão ">" do tópico "Level 3"
                    WebElement botaoLevelTres = driver.findElement(By.xpath("//a[@id='collapssesection3']//i[contains(@class,'icon fa fa-chevron-right fa-fw')]"));
                    botaoLevelTres.click();

                    // // Clicar no botão "Adicionar uma atividade ou recurso"
                    // WebElement adicionarRecurso = driver.findElement(By.xpath("//div[@id='coursecontentcollapse1']//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso']"));
                    // adicionarRecurso.click();

                    WebDriverWait waitII = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement adicionarRecursoII = waitII.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[4]")));
                    adicionarRecursoII.click();
                    Thread.sleep(2000);

                    // Clicar no recurso "URL"
                    WebElement recursoUrl = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    recursoUrl.click();

                    // // Clicar no botão ">" Geral
                    // WebElement botaoGeral = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    // botaoGeral.click();

                    // Preencher o campo "Nome"
                    WebElement campoNome = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNome.click();
                    Thread.sleep(2000);
                    campoNome.sendKeys(nome);

                    // Preencher o campo "URL externa"
                    WebElement urlExterna = driver.findElement(By.xpath("//input[@id='id_externalurl']"));
                    urlExterna.click();
                    Thread.sleep(2000);
                    urlExterna.sendKeys(urlExternaTres);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();

                    String mensagem = cell [7];

                    Assert.assertTrue(driver.getPageSource().contains(mensagem));

            }

        }
     } catch (Exception e) {
            System.out.println("Erro ao fazer ao URL");
     }

    }


    @Test
    public void levelTresI(){
        try{
            String CSV = "C:\\Users\\tales\\Downloads\\Marco2\\Marco2\\dados.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {

                    String identificacao = cell[0];
                    String senha = cell[0];
                    String nome = cell [8];
                    String urlExternaIII = cell [9];

                    //está buscando o botão acessar
                    WebElement acessar = driver.findElement(By.xpath("//span[@class='login pl-2']//a[contains(text(),'Acessar')]"));
                    acessar.click();
                    
                    // Preencher o campo "Identificação do Usuário" com seu login
                    WebElement identificacaoUsuario = driver.findElement(By.id("username"));
                    identificacaoUsuario.click();
                    identificacaoUsuario.sendKeys(identificacao);

                    //Preencher o campo "Senha" com sua senha
                    WebElement senhaUsuario = driver.findElement(By.id("password"));
                    senhaUsuario.click();
                    senhaUsuario.sendKeys(senha);
                    
                    // Clicar em acessar
                    WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
                    acessarBotao.click();

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no item "Meus cursos"
                    WebElement meusCursos = driver.findElement(By.xpath("//a[contains(@role,'menuitem')][normalize-space()='Meus cursos']"));
                    meusCursos.click();
                    Thread.sleep(2000);

                    // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
                    WebElement cursos = driver.findElement(By.xpath("//div[@class='card-img dashboard-card-img']"));
                    cursos.click();
                    Thread.sleep(2000);

                    // Clicar no botão ">" do tópico "Level 3"
                    WebElement botaoLevelTres = driver.findElement(By.xpath("//a[@id='collapssesection3']//i[contains(@class,'icon fa fa-chevron-right fa-fw')]"));
                    botaoLevelTres.click();

                    // // Clicar no botão "Adicionar uma atividade ou recurso"
                    // WebElement adicionarRecurso = driver.findElement(By.xpath("//div[@id='coursecontentcollapse1']//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso']"));
                    // adicionarRecurso.click();

                    WebDriverWait waitII = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement adicionarRecursoII = waitII.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[4]")));
                    adicionarRecursoII.click();
                    Thread.sleep(2000);

                    // Clicar no recurso "URL"
                    WebElement recursoUrl = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    recursoUrl.click();

                    // // Clicar no botão ">" Geral
                    // WebElement botaoGeral = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    // botaoGeral.click();

                    // Preencher o campo "Nome"
                    WebElement campoNome = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNome.click();
                    Thread.sleep(2000);
                    campoNome.sendKeys(nome);

                    // Preencher o campo "URL externa"
                    WebElement urlExterna = driver.findElement(By.xpath("//input[@id='id_externalurl']"));
                    urlExterna.click();
                    Thread.sleep(2000);
                    urlExterna.sendKeys(urlExternaIII);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();

                    String mensagem = cell [8];

                    Assert.assertTrue(driver.getPageSource().contains(mensagem));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao fazer ao URL");
        }

    }

    @Test
    public void levelTresII(){
        try{
            String CSV = "C:\\Users\\tales\\Downloads\\Marco2\\Marco2\\dados.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {

                    String identificacao = cell[0];
                    String senha = cell[0];
                    String nome = cell [10];
                    String urlExternaIII = cell [11];

                    //está buscando o botão acessar
                    WebElement acessar = driver.findElement(By.xpath("//span[@class='login pl-2']//a[contains(text(),'Acessar')]"));
                    acessar.click();
                    
                    // Preencher o campo "Identificação do Usuário" com seu login
                    WebElement identificacaoUsuario = driver.findElement(By.id("username"));
                    identificacaoUsuario.click();
                    identificacaoUsuario.sendKeys(identificacao);

                    //Preencher o campo "Senha" com sua senha
                    WebElement senhaUsuario = driver.findElement(By.id("password"));
                    senhaUsuario.click();
                    senhaUsuario.sendKeys(senha);
                    
                    // Clicar em acessar
                    WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
                    acessarBotao.click();

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no item "Meus cursos"
                    WebElement meusCursos = driver.findElement(By.xpath("//a[contains(@role,'menuitem')][normalize-space()='Meus cursos']"));
                    meusCursos.click();
                    Thread.sleep(2000);

                    // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
                    WebElement cursos = driver.findElement(By.xpath("//div[@class='card-img dashboard-card-img']"));
                    cursos.click();
                    Thread.sleep(2000);

                    // Clicar no botão ">" do tópico "Level 3"
                    WebElement botaoLevelTres = driver.findElement(By.xpath("//a[@id='collapssesection3']//i[contains(@class,'icon fa fa-chevron-right fa-fw')]"));
                    botaoLevelTres.click();

                    // // Clicar no botão "Adicionar uma atividade ou recurso"
                    // WebElement adicionarRecurso = driver.findElement(By.xpath("//div[@id='coursecontentcollapse1']//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso']"));
                    // adicionarRecurso.click();

                    WebDriverWait waitII = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement adicionarRecursoII = waitII.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[4]")));
                    adicionarRecursoII.click();
                    Thread.sleep(2000);

                    // Clicar no recurso "URL"
                    WebElement recursoUrl = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    recursoUrl.click();

                    // // Clicar no botão ">" Geral
                    // WebElement botaoGeral = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    // botaoGeral.click();

                    // Preencher o campo "Nome"
                    WebElement campoNome = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNome.click();
                    Thread.sleep(2000);
                    campoNome.sendKeys(nome);

                    // Preencher o campo "URL externa"
                    WebElement urlExterna = driver.findElement(By.xpath("//input[@id='id_externalurl']"));
                    urlExterna.click();
                    Thread.sleep(2000);
                    urlExterna.sendKeys(urlExternaIII);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();

                    String mensagem = cell [10];

                    Assert.assertTrue(driver.getPageSource().contains(mensagem));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao fazer ao URL");
        }

    }

    @Test
    public void levelTresIII(){
        try{
            String CSV = "C:\\Users\\tales\\Downloads\\Marco2\\Marco2\\dados.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {

                    String identificacao = cell[0];
                    String senha = cell[0];
                    String nome = cell [12];
                    String urlExternaIV = cell [13];

                    //está buscando o botão acessar
                    WebElement acessar = driver.findElement(By.xpath("//span[@class='login pl-2']//a[contains(text(),'Acessar')]"));
                    acessar.click();
                    
                    // Preencher o campo "Identificação do Usuário" com seu login
                    WebElement identificacaoUsuario = driver.findElement(By.id("username"));
                    identificacaoUsuario.click();
                    identificacaoUsuario.sendKeys(identificacao);

                    //Preencher o campo "Senha" com sua senha
                    WebElement senhaUsuario = driver.findElement(By.id("password"));
                    senhaUsuario.click();
                    senhaUsuario.sendKeys(senha);
                    
                    // Clicar em acessar
                    WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
                    acessarBotao.click();

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no item "Meus cursos"
                    WebElement meusCursos = driver.findElement(By.xpath("//a[contains(@role,'menuitem')][normalize-space()='Meus cursos']"));
                    meusCursos.click();
                    Thread.sleep(2000);

                    // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
                    WebElement cursos = driver.findElement(By.xpath("//div[@class='card-img dashboard-card-img']"));
                    cursos.click();
                    Thread.sleep(2000);

                    // Clicar no botão ">" do tópico "Level 3"
                    WebElement botaoLevelTres = driver.findElement(By.xpath("//a[@id='collapssesection3']//i[contains(@class,'icon fa fa-chevron-right fa-fw')]"));
                    botaoLevelTres.click();

                    // // Clicar no botão "Adicionar uma atividade ou recurso"
                    // WebElement adicionarRecurso = driver.findElement(By.xpath("//div[@id='coursecontentcollapse1']//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso']"));
                    // adicionarRecurso.click();

                    WebDriverWait waitII = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement adicionarRecursoII = waitII.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[4]")));
                    adicionarRecursoII.click();
                    Thread.sleep(2000);

                    // Clicar no recurso "URL"
                    WebElement recursoUrl = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    recursoUrl.click();

                    // // Clicar no botão ">" Geral
                    // WebElement botaoGeral = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    // botaoGeral.click();

                    // Preencher o campo "Nome"
                    WebElement campoNome = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNome.click();
                    Thread.sleep(2000);
                    campoNome.sendKeys(nome);

                    // Preencher o campo "URL externa"
                    WebElement urlExterna = driver.findElement(By.xpath("//input[@id='id_externalurl']"));
                    urlExterna.click();
                    Thread.sleep(2000);
                    urlExterna.sendKeys(urlExternaIV);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();

                    String mensagem = cell [12];

                    Assert.assertTrue(driver.getPageSource().contains(mensagem));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao fazer ao URL");
        }
    }


    @Test
    public void levelQuatro(){
        try{
            String CSV = "C:\\Users\\tales\\Downloads\\Marco2\\Marco2\\dados.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {
                    
                    String identificacao = cell[0];
                    String senha = cell[0];
                    String nome = cell[14];
                    String urlExternaQuatro = cell [2];
                    String descricao = cell [15];
                    

                    //está buscando o botão acessar
                    WebElement acessar = driver.findElement(By.xpath("//span[@class='login pl-2']//a[contains(text(),'Acessar')]"));
                    acessar.click();
                    
                    // Preencher o campo "Identificação do Usuário" com seu login
                    WebElement identificacaoUsuario = driver.findElement(By.id("username"));
                    identificacaoUsuario.click();
                    identificacaoUsuario.sendKeys(identificacao);

                    //Preencher o campo "Senha" com sua senha
                    WebElement senhaUsuario = driver.findElement(By.id("password"));
                    senhaUsuario.click();
                    senhaUsuario.sendKeys(senha);
                    
                    // Clicar em acessar
                    WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
                    acessarBotao.click();

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no item "Meus cursos"
                    WebElement meusCursos = driver.findElement(By.xpath("//a[contains(@role,'menuitem')][normalize-space()='Meus cursos']"));
                    meusCursos.click();
                    Thread.sleep(2000);

                    // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
                    WebElement cursos = driver.findElement(By.xpath("//div[@class='card-img dashboard-card-img']"));
                    cursos.click();
                    Thread.sleep(2000);
                    
                    // Clicar no botão ">" do tópico "Level 4"
                    WebElement botaoLevelQuatro = driver.findElement(By.xpath("//a[@id='collapssesection4']//i[contains(@class,'icon fa fa-chevron-right fa-fw')]"));
                    botaoLevelQuatro.click();

                    // // Clicar no botão "Adicionar uma atividade ou recurso"
                    // WebElement adicionarRecurso = driver.findElement(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[5]"));
                    // adicionarRecurso.click();

                    WebDriverWait waitII = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement adicionarRecursoII = waitII.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[5]")));
                    adicionarRecursoII.click();
                    Thread.sleep(2000);

                    // Clicar no recurso "URL"
                    WebElement recursoUrl = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    recursoUrl.click();

                    // // Clicar no botão ">" Geral
                    // WebElement botaoGeral = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    // botaoGeral.click();

                    // Preencher o campo "Nome"
                    WebElement campoNome = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNome.click();
                    Thread.sleep(2000);
                    campoNome.sendKeys(nome);

                    // Preencher o campo "URL externa"
                    WebElement urlExterna = driver.findElement(By.xpath("//input[@id='id_externalurl']"));
                    urlExterna.click();
                    urlExterna.sendKeys(urlExternaQuatro);

                    // Preencher o campo "Descrição"
                    WebElement descricaoDois = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
                    descricaoDois.click();
                    descricaoDois.sendKeys(descricao);

                    // Clicar no botão "Exibir descrição na página do curso"
                    WebElement exibirDescricao = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
                    exibirDescricao.click();

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();

                    String mensagem = cell [14];

                    Assert.assertTrue(driver.getPageSource().contains(mensagem));

            }

        }
     } catch (Exception e) {
            System.out.println("Erro ao fazer ao URL");
     }

    }

    @Test
    public void levelQuatroI(){
        try{
            String CSV = "C:\\Users\\tales\\Downloads\\Marco2\\Marco2\\dados.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {
                    
                    String identificacao = cell[0];
                    String senha = cell[0];
                    String nomeII = cell[16];
                    String urlExternaII = cell [9];
                    String descricao = cell [15];

                    //está buscando o botão acessar
                    WebElement acessar = driver.findElement(By.xpath("//span[@class='login pl-2']//a[contains(text(),'Acessar')]"));
                    acessar.click();
                    
                    // Preencher o campo "Identificação do Usuário" com seu login
                    WebElement identificacaoUsuario = driver.findElement(By.id("username"));
                    identificacaoUsuario.click();
                    identificacaoUsuario.sendKeys(identificacao);

                    //Preencher o campo "Senha" com sua senha
                    WebElement senhaUsuario = driver.findElement(By.id("password"));
                    senhaUsuario.click();
                    senhaUsuario.sendKeys(senha);
                    
                    // Clicar em acessar
                    WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
                    acessarBotao.click();

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no item "Meus cursos"
                    WebElement meusCursos = driver.findElement(By.xpath("//a[contains(@role,'menuitem')][normalize-space()='Meus cursos']"));
                    meusCursos.click();
                    Thread.sleep(2000);

                    // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
                    WebElement cursos = driver.findElement(By.xpath("//div[@class='card-img dashboard-card-img']"));
                    cursos.click();
                    Thread.sleep(2000);
                   
                    // Clicar no botão ">" do tópico "Level 4"
                    WebElement botaoLevelQuatroII = driver.findElement(By.xpath("//a[@id='collapssesection4']//i[contains(@class,'icon fa fa-chevron-right fa-fw')]"));
                    botaoLevelQuatroII.click();

                    // // Clicar no botão "Adicionar uma atividade ou recurso"
                    // WebElement adicionarRecursoII = driver.findElement(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[5]"));
                    // adicionarRecursoII.click();

                    WebDriverWait waitII = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement adicionarRecursoII = waitII.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[5]")));
                    adicionarRecursoII.click();
                    Thread.sleep(2000);

                    // Clicar no recurso "URL"
                    WebElement recursoUrlII = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    recursoUrlII.click();

                    // // Clicar no botão ">" Geral
                    // WebElement botaoGeralII = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    // botaoGeralII.click();

                    // Preencher o campo "Nome"
                    WebElement campoNomeII = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNomeII.click();
                    Thread.sleep(2000);
                    campoNomeII.sendKeys(nomeII);

                    // Preencher o campo "URL externa"
                    WebElement urlExternII = driver.findElement(By.xpath("//input[@id='id_externalurl']"));
                    urlExternII.click();
                    Thread.sleep(2000);
                    urlExternII.sendKeys(urlExternaII);

                    // Preencher o campo "Descrição"
                    WebElement descricaoQuatroII = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
                    descricaoQuatroII.click();
                    Thread.sleep(2000);
                    descricaoQuatroII.sendKeys(descricao);

                    // Clicar no botão "Exibir descrição na página do curso"
                    WebElement exibirDescricao = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
                    exibirDescricao.click();

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltarII = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltarII.click();

                    String mensagem = cell [16];

                    Assert.assertTrue(driver.getPageSource().contains(mensagem));

                }
                }
            } catch (Exception e) {
                System.out.println("Erro ao fazer ao URL");
            }

        }

@Test
public void levelQuatroII(){
        try{
            String CSV = "C:\\Users\\tales\\Downloads\\Marco2\\Marco2\\dados.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {
                    
                    String identificacao = cell[0];
                    String senha = cell[0];
                    String nomeIII = cell [17];
                    String urlExternaIII = cell [11];
                    String descricao = cell [15];
                    
                    //está buscando o botão acessar
                    WebElement acessar = driver.findElement(By.xpath("//span[@class='login pl-2']//a[contains(text(),'Acessar')]"));
                    acessar.click();
                    
                    // Preencher o campo "Identificação do Usuário" com seu login
                    WebElement identificacaoUsuario = driver.findElement(By.id("username"));
                    identificacaoUsuario.click();
                    identificacaoUsuario.sendKeys(identificacao);

                    //Preencher o campo "Senha" com sua senha
                    WebElement senhaUsuario = driver.findElement(By.id("password"));
                    senhaUsuario.click();
                    senhaUsuario.sendKeys(senha);
                    
                    // Clicar em acessar
                    WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
                    acessarBotao.click();

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no item "Meus cursos"
                    WebElement meusCursos = driver.findElement(By.xpath("//a[contains(@role,'menuitem')][normalize-space()='Meus cursos']"));
                    meusCursos.click();
                    Thread.sleep(2000);

                    // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
                    WebElement cursos = driver.findElement(By.xpath("//div[@class='card-img dashboard-card-img']"));
                    cursos.click();
                    Thread.sleep(2000);

                    // Clicar no botão ">" do tópico "Level 4"
                    WebElement botaoLevelQuatroIII = driver.findElement(By.xpath("//a[@id='collapssesection4']//i[contains(@class,'icon fa fa-chevron-right fa-fw')]"));
                    botaoLevelQuatroIII.click();

                    // // Clicar no botão "Adicionar uma atividade ou recurso"
                    // WebElement adicionarRecursoIII = driver.findElement(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[5]"));
                    // adicionarRecursoIII.click();

                    WebDriverWait waitII = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement adicionarRecursoII = waitII.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[5]")));
                    adicionarRecursoII.click();
                    Thread.sleep(2000);

                    // Clicar no recurso "URL"
                    WebElement recursoUrlIII = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    recursoUrlIII.click();

                    // // Clicar no botão ">" Geral
                    // WebElement botaoGeralIII = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    // botaoGeralIII.click();

                    // Preencher o campo "Nome"
                    WebElement campoNomeIII = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNomeIII.click();
                    Thread.sleep(2000);
                    campoNomeIII.sendKeys(nomeIII);

                    // Preencher o campo "URL externa"
                    WebElement urlExternIII = driver.findElement(By.xpath("//input[@id='id_externalurl']"));
                    urlExternIII.click();
                    Thread.sleep(2000);
                    urlExternIII.sendKeys(urlExternaIII);

                    // Preencher o campo "Descrição"
                    WebElement descricaoQuatroIII = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
                    descricaoQuatroIII.click();
                    Thread.sleep(2000);
                    descricaoQuatroIII.sendKeys(descricao);

                    // Clicar no botão "Exibir descrição na página do curso"
                    WebElement exibirDescricao = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
                    exibirDescricao.click();

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltarIII = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltarIII.click();

                    String mensagem = cell [17];

                    Assert.assertTrue(driver.getPageSource().contains(mensagem));

                }
            }
            } catch (Exception e) {
                System.out.println("Erro ao fazer ao URL");
            }

        }

@Test
public void levelQuatroIII(){
        try{
            String CSV = "C:\\Users\\tales\\Downloads\\Marco2\\Marco2\\dados.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {
                  
                    String identificacao = cell[0];
                    String senha = cell[0];
                    String nomeIIII = cell [18];
                    String urlExternaIIII = cell [13];
                    String descricao = cell [15];
                    
                    //está buscando o botão acessar
                    WebElement acessar = driver.findElement(By.xpath("//span[@class='login pl-2']//a[contains(text(),'Acessar')]"));
                    acessar.click();
                    
                    // Preencher o campo "Identificação do Usuário" com seu login
                    WebElement identificacaoUsuario = driver.findElement(By.id("username"));
                    identificacaoUsuario.click();
                    identificacaoUsuario.sendKeys(identificacao);

                    //Preencher o campo "Senha" com sua senha
                    WebElement senhaUsuario = driver.findElement(By.id("password"));
                    senhaUsuario.click();
                    senhaUsuario.sendKeys(senha);
                    
                    // Clicar em acessar
                    WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
                    acessarBotao.click();

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no item "Meus cursos"
                    WebElement meusCursos = driver.findElement(By.xpath("//a[contains(@role,'menuitem')][normalize-space()='Meus cursos']"));
                    meusCursos.click();
                    Thread.sleep(2000);

                    // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
                    WebElement cursos = driver.findElement(By.xpath("//div[@class='card-img dashboard-card-img']"));
                    cursos.click();
                    Thread.sleep(2000);

                    // Clicar no botão ">" do tópico "Level 4"
                    WebElement botaoLevelQuatroIIII = driver.findElement(By.xpath("//a[@id='collapssesection4']//i[contains(@class,'icon fa fa-chevron-right fa-fw')]"));
                    botaoLevelQuatroIIII.click();

                    // // Clicar no botão "Adicionar uma atividade ou recurso"
                    // WebElement adicionarRecursoIIII = driver.findElement(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[5]"));
                    // adicionarRecursoIIII.click();

                    WebDriverWait waitII = new WebDriverWait(driver, Duration.ofSeconds(10));
                    WebElement adicionarRecursoII = waitII.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[5]")));
                    adicionarRecursoII.click();
                    Thread.sleep(2000);

                    // Clicar no recurso "URL"
                    WebElement recursoUrlIIII = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    recursoUrlIIII.click();

                    // // Clicar no botão ">" Geral
                    // WebElement botaoGeralIIII = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo URL']"));
                    // botaoGeralIIII.click();

                    // Preencher o campo "Nome"
                    WebElement campoNomeIIII = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNomeIIII.click();
                    Thread.sleep(2000);
                    campoNomeIIII.sendKeys(nomeIIII);

                    // Preencher o campo "URL externa"
                    WebElement urlExternIIII = driver.findElement(By.xpath("//input[@id='id_externalurl']"));
                    urlExternIIII.click();
                    urlExternIIII.sendKeys(urlExternaIIII);

                    // Preencher o campo "Descrição"
                    WebElement descricaoQuatroIIII = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
                    descricaoQuatroIIII.click();
                    Thread.sleep(2000);
                    descricaoQuatroIIII.sendKeys(descricao);

                    // Clicar no botão "Exibir descrição na página do curso"
                    WebElement exibirDescricao = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
                    exibirDescricao.click();

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltarIIII = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltarIIII.click();

                    String mensagem = cell [18];

                    Assert.assertTrue(driver.getPageSource().contains(mensagem));

                }
            }
            } catch (Exception e) {
                System.out.println("Erro ao fazer ao URL");
            }

        }

}