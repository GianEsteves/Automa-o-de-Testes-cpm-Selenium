import java.io.FileReader;
import java.io.IOException;
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
import com.opencsv.exceptions.CsvValidationException;


public class TestsDiscussoes{

    private WebDriver driver = new ChromeDriver();


    @Before
    public void setUp() throws IOException, CsvValidationException, InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\chromedriver.exe");
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dados.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
             
                String identificacao = cell[0];
                String senha = cell[0];

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
        Thread.sleep(2000);
        
    } 
        }
    }

@Test
    public void criarDiscussoes() throws InterruptedException, IOException, CsvValidationException{
        
            String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {
                 
                    String assunto = cell[7];
                    String mensagem = cell[8];
                

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Adicionar tópico de discussão
                    WebElement adicionarDiscussao = driver.findElement(By.xpath("//a[normalize-space()='Adicionar tópico de discussão']"));
                    recursoUrl.click();

                    // Clicar no botão "Grupos visíveis"
                    WebElement campoNome = driver.findElement(By.xpath("//select[@id='single_select638534f971b8613']"));
                    campoNome.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoTodos3 = driver.findElement(By.xpath("//option[@value='0']"));
                    opcaoTodos3.click();
                    Thread.sleep(3000);

                    // Clicar no campo "Assunto"
                    WebElement campoAssunto = driver.findElement(By.xpath("//input[@id='id_subject']"));
                    campoAssunto.click();
                    Thread.sleep(2000);
                    campoAssunto.sendKeys(assunto);

                    // Clicar no campo "Mensagem"
                    WebElement campoMensagem = driver.findElement(By.xpath("//div[@id='id_messageeditable']"));
                    campoMensagem.click();
                    Thread.sleep(2000);
                    campoMensagem.sendKeys(mensagem);

                    //Clicar no botão "Enviar mensagem ao fórum"
                    WebElement botaoEnviarForum = driver.findElement(By.xpath("//input[@id='id_submitbutton']"));
                    botaoEnviarForum.click();
                    Thread.sleep(2000);
                }
            }

    }


@Test
    public void criarDiscussoesAssinar() throws InterruptedException, IOException, CsvValidationException{
        
            String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {
                 
                    String assunto = cell[7];
                    String mensagem = cell[8];
                

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Adicionar tópico de discussão
                    WebElement adicionarDiscussao = driver.findElement(By.xpath("//a[normalize-space()='Adicionar tópico de discussão']"));
                    recursoUrl.click();

                    // Clicar no botão "Grupos visíveis"
                    WebElement campoNome = driver.findElement(By.xpath("//select[@id='single_select638534f971b8613']"));
                    campoNome.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoTodos3 = driver.findElement(By.xpath("//option[@value='0']"));
                    opcaoTodos3.click();
                    Thread.sleep(3000);

                    // Clicar no campo "Assunto"
                    WebElement campoAssunto = driver.findElement(By.xpath("//input[@id='id_subject']"));
                    campoAssunto.click();
                    Thread.sleep(2000);
                    campoAssunto.sendKeys(assunto);

                    // Clicar no campo "Mensagem"
                    WebElement campoMensagem = driver.findElement(By.xpath("//div[@id='id_messageeditable']"));
                    campoMensagem.click();
                    Thread.sleep(2000);
                    campoMensagem.sendKeys(mensagem);

                    //Clicar no botão "Enviar mensagem ao fórum"
                    WebElement botaoEnviarForum = driver.findElement(By.xpath("//input[@id='id_submitbutton']"));
                    botaoEnviarForum.click();
                    Thread.sleep(2000);

                    //Clicar no botão "Assinar este fórum"
                    WebElement botaoAssinarForum = driver.findElement(By.xpath("//a[normalize-space()='Assinar este fórum']"));
                    botaoAssinarForum.click();
                    Thread.sleep(2000);
                }
            }
    }

@Test
    public void discussoesAvaliarUsuarios() throws InterruptedException, IOException, CsvValidationException{
        
            String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {
                 
                    
                    String notaAluno = cell[9];
                

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Avaliar usuários"
                    WebElement botaoAvaliarUsuario = driver.findElement(By.xpath("//button[normalize-space()='Avaliar usuários']"));
                    botaoAvaliarUsuario.click();

                    // Clicar no botão de "Buscar usuários"
                    WebElement botaoBuscarUruarios = driver.findElement(By.xpath("//i[@title='Mostrar pesquisa para o usuário']"));
                    botaoBuscarUruarios.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoBuscar3 = driver.findElement(By.xpath("//h5[normalize-space()='Gabriele Da Silva Agostini']"));
                    opcaoBuscar3.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Ver discussão"
                    WebElement botaoVerDiscussao = driver.findElement(By.xpath("//button[normalize-space()='Ver discussão']"));
                    botaoVerDiscussao.click();
                    Thread.sleep(2000);
                    
                    // Clicar no botão "x"
                    WebElement botaoX = driver.findElement(By.xpath("//button[@aria-label='Fechar']//span[@aria-hidden='true'][normalize-space()='×']"));
                    botaoX.click();
                    Thread.sleep(2000);
                    
                    //Clicar no campo "Nota"
                    WebElement campoNotaAluno = driver.findElement(By.xpath("//select[@id='core_grades-grade-12']"));
                    campoNotaAluno.click();
                    Thread.sleep(2000);
                    //campoNotaAluno.sendKeys(notaAluno);

                    //Selecionar a opção tem copetencia
                    WebElement opcaoTemComp = driver.findElement(By.xpath("//option[normalize-space()='Tem a competência']"));
                    opcaoTemComp.click();
                    Thread.sleep(2000);

                    //Clicar no botão "Sim, envie notificação ao estudante"
                    WebElement botaoEnviarNotifi = driver.findElement(By.xpath("//label[normalize-space()='Sim, envie notificação ao estudante']"));
                    botaoEnviarNotifi.click();
                    Thread.sleep(2000);

                    //Clicar no botão "Salvar"
                    WebElement botaoSalvar = driver.findElement(By.xpath("//button[normalize-space()='Salvar']"));
                    botaoSalvar.click();
                    Thread.sleep(2000);

                    //Clicar no botão "Fechar"
                    WebElement botaoFechar = driver.findElement(By.xpath("//button[normalize-space()='Fechar']"));
                    botaoFechar.click();
                    Thread.sleep(2000);
                    }
                }
            }
}




