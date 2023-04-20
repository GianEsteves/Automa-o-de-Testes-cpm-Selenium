package Teste.moodle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.linkText;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.apache.commons.lang3.math.Fraction;
import org.asynchttpclient.util.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


@DisplayName("Teste de adicionar arquivo no nivelm 01")
public class Drive {

    @Test
    @DisplayName("Adicionar arquivo no primeiro nivel ")

    public void adicionarArquivoN1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        WebElement usuario = driver.findElement(By.id("username"));
        usuario.click();
        usuario.sendKeys("2210100408");
        WebElement senha = driver.findElement(By.id("password"));
        senha.sendKeys("2210100408");
        WebElement botaoAcesso = driver.findElement(By.id("loginbtn"));
        botaoAcesso.click();

        //WebElement grupo = driver.findElement(By.className("aalink"));
        //grupo.click();

        WebElement modoProfessor = driver.findElement(By.className("custom-control-input"));
        modoProfessor.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("(//button[@data-action='open-chooser'])[2]")).click();
        
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Arquivo']")).click();

        // abre a aba para adicionar os arquivos 
        
        driver.findElement(By.xpath("//input[@id='id_name']")).click();
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Arquivo teste 01");
        
        //  adicina o titula 
        
        driver.findElement(By.xpath("//div[@id='id_introeditoreditable']")).click();
        driver.findElement(By.xpath("//div[@id='id_introeditoreditable']")).sendKeys("Uma descamação muito importante    ");
        driver.findElement(By.xpath("//label[normalize-space()='Exibir descrição na página do curso']")).click();
        
        // exibe a descricao 

        driver.findElement(By.xpath("//div[@class='dndupload-message']//div[@class='dndupload-arrow d-flex']")).click();
        driver.findElement(By.xpath("//input[@name='repo_upload_file']")).sendKeys("C:\\Users\\giann\\OneDrive\\Área de Trabalho\\unipampa\\RP2\\testeparateste.pdf");
        // adicona arquivo 

        driver.findElement(By.xpath("//button[normalize-space()='Enviar este arquivo']")).click();
        driver.findElement(By.xpath("//a[@href='#id_activitycompletionheadercontainer']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@id='id_completion']")));
        se.selectByValue("0");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();

        
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();
       
    }

    @Test
    @DisplayName("Adicionar arquivo no segundo nivel ")

    public void adicionarArquivoN2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        WebElement usuario = driver.findElement(By.id("username"));
        usuario.click();
        usuario.sendKeys("2210100408");
        WebElement senha = driver.findElement(By.id("password"));
        senha.sendKeys("2210100408");
        WebElement botaoAcesso = driver.findElement(By.id("loginbtn"));
        botaoAcesso.click();

        //WebElement grupo = driver.findElement(By.className("aalink"));
        //grupo.click();
        
        WebElement modoProfessor = driver.findElement(By.className("custom-control-input"));
        modoProfessor.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //driver.findElement(By.xpath("//span[@class='expandall text-nowrap']")).click();
        driver.findElement(By.xpath("(//button[@data-action='open-chooser'])[3]")).click();
        
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Arquivo']")).click();

        // abre a aba para adicionar os arquivos 
        
        driver.findElement(By.xpath("//input[@id='id_name']")).click();
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Arquivo teste 02");
        
        //  adicina o titula 
        
        driver.findElement(By.xpath("//div[@id='id_introeditoreditable']")).click();
        driver.findElement(By.xpath("//div[@id='id_introeditoreditable']")).sendKeys("Uma descamação muito linda   ");
        driver.findElement(By.xpath("//label[normalize-space()='Exibir descrição na página do curso']")).click();
        
        // exibe a descricao 

        driver.findElement(By.xpath("//div[@class='dndupload-message']//div[@class='dndupload-arrow d-flex']")).click();
        driver.findElement(By.xpath("//input[@name='repo_upload_file']")).sendKeys("C:\\Users\\giann\\OneDrive\\Área de Trabalho\\unipampa\\RP2\\testeparateste.pdf");
        driver.findElement(By.xpath("//button[normalize-space()='Enviar este arquivo']")).click();
        
        // adicona arquivo 
       
        driver.findElement(By.xpath("//a[@href='#id_activitycompletionheadercontainer']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@id='id_completion']")));
        se.selectByValue("0");

        // deixa sem entrega 
        //driver.findElement(By.xpath("null")).click();
        
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();

        // salva e volta ao curso
        driver.findElement(By.xpath("//body[1]/div[5]/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[2]/ul[1]/li[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("(//a[@role='menuitem'])[81]")).click();
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

    }
    @Test
    @DisplayName("Adicionar arquivo no terceiro nivel ")

    public void adicionarArquivoN3(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        WebElement usuario = driver.findElement(By.id("username"));
        usuario.click();
        usuario.sendKeys("2210100408");
        WebElement senha = driver.findElement(By.id("password"));
        senha.sendKeys("2210100408");
        WebElement botaoAcesso = driver.findElement(By.id("loginbtn"));
        botaoAcesso.click();

        //WebElement grupo = driver.findElement(By.className("aalink"));
        //grupo.click();
        
        WebElement modoProfessor = driver.findElement(By.className("custom-control-input"));
        modoProfessor.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("(//button[@data-action='open-chooser'])[4]")).click();
        
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Arquivo']")).click();

        // abre a aba para adicionar os arquivos 
        
        driver.findElement(By.xpath("//input[@id='id_name']")).click();
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Arquivo teste 03");
        
        //  adicina o titula 
        
        driver.findElement(By.xpath("//div[@id='id_introeditoreditable']")).click();
        driver.findElement(By.xpath("//div[@id='id_introeditoreditable']")).sendKeys("Uma descamação muito importante    ");
        driver.findElement(By.xpath("//label[normalize-space()='Exibir descrição na página do curso']")).click();
        
        // exibe a descricao 

        driver.findElement(By.xpath("//div[@class='dndupload-message']//div[@class='dndupload-arrow d-flex']")).click();
        driver.findElement(By.xpath("//input[@name='repo_upload_file']")).sendKeys("C:\\Users\\giann\\OneDrive\\Área de Trabalho\\unipampa\\RP2\\testeparateste.pdf");
        driver.findElement(By.xpath("//button[normalize-space()='Enviar este arquivo']")).click();
        
        // adicona arquivo 

        driver.findElement(By.xpath("//a[@href='#id_activitycompletionheadercontainer']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@id='id_completion']")));
        se.selectByValue("1");
        driver.findElement(By.xpath("//label[normalize-space()='Habilitar']")).click();
        driver.findElement(By.xpath("//select[@id='id_completionexpected_day']")).click();
        //driver.findElement(By.xpath("(//select[@id='id_completionexpected_day'])[13]")).click();
        Select dia = new Select(driver.findElement(By.xpath("(//select[@id='id_completionexpected_day'])[1]")));
        dia.selectByValue("13");
        Select mes = new Select(driver.findElement(By.xpath("(//select[@id='id_completionexpected_month'])[1]")));
        mes.selectByValue("12");
        Select ano = new Select(driver.findElement(By.xpath("(//select[@id='id_completionexpected_year'])[1]")));
        ano.selectByValue("2022");
        //driver.findElement(By.xpath("null")).sendKeys(null);
        // deixa sem entrega 

        //driver.findElement(By.xpath("null")).click();

        
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

    }
    @Test
    @DisplayName("Adicionar arquivo no quarto nivel ")
    
    public void adicionarArquivoN4(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        WebElement usuario = driver.findElement(By.id("username"));
        usuario.click();
        usuario.sendKeys("2210100408");
        WebElement senha = driver.findElement(By.id("password"));
        senha.sendKeys("2210100408");
        WebElement botaoAcesso = driver.findElement(By.id("loginbtn"));
        botaoAcesso.click();

        //WebElement grupo = driver.findElement(By.className("aalink"));
        //grupo.click();
        
        WebElement modoProfessor = driver.findElement(By.className("custom-control-input"));
        modoProfessor.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("(//button[@data-action='open-chooser'])[5]")).click();

        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Arquivo']")).click();

        // abre a aba para adicionar os arquivos 
        
        driver.findElement(By.xpath("//input[@id='id_name']")).click();
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Arquivo teste 04");
        
        //  adicina o titula 
        
        driver.findElement(By.xpath("//div[@id='id_introeditoreditable']")).click();
        driver.findElement(By.xpath("//div[@id='id_introeditoreditable']")).sendKeys("Uma descamação muito importante    ");
        driver.findElement(By.xpath("//label[normalize-space()='Exibir descrição na página do curso']")).click();
        
        // exibe a descricao 

        driver.findElement(By.xpath("//div[@class='dndupload-message']//div[@class='dndupload-arrow d-flex']")).click();
        driver.findElement(By.xpath("//input[@name='repo_upload_file']")).sendKeys("C:\\Users\\giann\\OneDrive\\Área de Trabalho\\unipampa\\RP2\\testeparateste.pdf");
        driver.findElement(By.xpath("//button[normalize-space()='Enviar este arquivo']")).click();
        // adicona arquivo 

        driver.findElement(By.xpath("//a[@href='#id_activitycompletionheadercontainer']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@id='id_completion']")));
        se.selectByValue("0");


        
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();

        
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

    }

    @Test
    @DisplayName(" Apagar arqiovo ")
    public void apagarArquivo(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        WebElement usuario = driver.findElement(By.id("username"));
        usuario.click();
        usuario.sendKeys("2210100408");
        WebElement senha = driver.findElement(By.id("password"));
        senha.sendKeys("2210100408");
        WebElement botaoAcesso = driver.findElement(By.id("loginbtn"));
        botaoAcesso.click();
        WebElement modoProfessor = driver.findElement(By.className("custom-control-input"));
        modoProfessor.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/div[2]/ul[1]/li[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[2]//div[2]//ul[1]//li[4]//div[1]//div[1]//div[2]//div[1]//div[1]//div[1]//div[1]//div[1]//a[6]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Sim']")).click();



        // driver.findElement(By.xpath("null")).click();
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();
    }

    @Test
    @DisplayName(" Arquivo maior que o permitido ")
    public void arquivoGrande(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        WebElement usuario = driver.findElement(By.id("username"));
        usuario.click();
        usuario.sendKeys("2210100408");
        WebElement senha = driver.findElement(By.id("password"));
        senha.sendKeys("2210100408");
        WebElement botaoAcesso = driver.findElement(By.id("loginbtn"));
        botaoAcesso.click();

        WebElement modoProfessor = driver.findElement(By.className("custom-control-input"));
        modoProfessor.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("(//button[@data-action='open-chooser'])[2]")).click();
        
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Arquivo']")).click();
        driver.findElement(By.xpath("//div[@class='dndupload-message']//div[@class='dndupload-arrow d-flex']")).click();
        driver.findElement(By.xpath("//input[@name='repo_upload_file']")).sendKeys("C:\\Users\\giann\\OneDrive\\Área de Trabalho\\unipampa\\RP2\\testeparateste.pdf");
        driver.findElement(By.xpath("//button[normalize-space()='Enviar este arquivo']")).click();
        driver.findElement(By.xpath("//h5[normalize-space()='Erro']")).click();
        assertEquals("Erro", "Erro");

        driver.close();
    }
}
