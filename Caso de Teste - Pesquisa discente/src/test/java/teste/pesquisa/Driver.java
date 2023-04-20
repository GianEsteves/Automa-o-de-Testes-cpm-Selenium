package teste.pesquisa;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@Displayname(" Pesquisa Discenet ")
public class Driver {

    @Test
    @Displayname("Responder o questionario 01 ")
    // responder o questionario com todas as opcoes preenchidas
    public void envioQuestionario(){

        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        // criar Pesquisa de avalhação 

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        //driver.findElement(By.xpath("//span[@class='expandall text-nowrap']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'tab-pane active')]//a[contains(@title,'Adicionar um novo Pesquisa de avaliação')]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Teste 01");
        Select se = new Select(driver.findElement(By.xpath("//select[@id='id_template']")));
        se.selectByValue("4");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
  
        // mudar para aluno 
        driver.findElement(By.xpath("//a[@id='user-menu-toggle']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();
        // abre questionario 
        driver.findElement(By.xpath("//div[contains(@class,'modtype_survey position-relative align-self-start')]//a[contains(@class,'aalink stretched-link')]")).click();
        // responder todas as questoes 
        driver.findElement(By.xpath("//label[@for='q45_1']")).click();
        driver.findElement(By.xpath("//label[@for='q46_1']")).click();
        driver.findElement(By.xpath("//label[@for='q47_2']")).click();
        driver.findElement(By.xpath("//label[@for='q48_3']")).click();
        driver.findElement(By.xpath("//label[@for='q49_4']")).click();
        driver.findElement(By.xpath("//label[@for='q50_5']")).click();
        driver.findElement(By.xpath("//label[@for='q51_1']")).click();
        driver.findElement(By.xpath("//label[@for='q52_2']")).click();
        driver.findElement(By.xpath("//label[@for='q53_3']")).click();
        driver.findElement(By.xpath("//label[@for='q54_4']")).click();
        driver.findElement(By.xpath("//label[@for='q55_5']")).click();
        driver.findElement(By.xpath("//label[@for='q56_1']")).click();
        driver.findElement(By.xpath("//label[@for='q57_2']")).click();
        driver.findElement(By.xpath("//label[@for='q58_3']")).click();
        driver.findElement(By.xpath("//label[@for='q59_4']")).click();
        driver.findElement(By.xpath("//label[@for='q60_5']")).click();
        driver.findElement(By.xpath("//label[@for='q61_1']")).click();
        driver.findElement(By.xpath("//label[@for='q62_2']")).click();
        driver.findElement(By.xpath("//label[@for='q63_3']")).click();
        driver.findElement(By.xpath("//label[@for='q64_4']")).click();
        driver.findElement(By.xpath("//input[@value='Enviar']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // deslogar
        driver.findElement(By.xpath("//a[@id='user-menu-toggle']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.quit();
        
    }

    @Test
    @Displayname(" Responder questionario incompleto 02")
    // responder o questionario com algumas reposta em branco 
    public void envioQuestionarioIncompleto(){
                // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        // criar Pesquisa de avalhação 

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        //driver.findElement(By.xpath("//span[@class='expandall text-nowrap']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'tab-pane active')]//a[contains(@title,'Adicionar um novo Pesquisa de avaliação')]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Teste 02");
        Select se = new Select(driver.findElement(By.xpath("//select[@id='id_template']")));
        se.selectByValue("4");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
  
        // mudar para aluno 
        driver.findElement(By.xpath("//a[@id='user-menu-toggle']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();
        // abre questionario 
        driver.findElement(By.xpath("//div[contains(@class,'modtype_survey position-relative align-self-start')]//a[contains(@class,'aalink stretched-link')]")).click();
        // responder todas as questoes 
        driver.findElement(By.xpath("//label[@for='q45_1']")).click();
        //driver.findElement(By.xpath("//label[@for='q46_1']")).click();
        driver.findElement(By.xpath("//label[@for='q47_2']")).click();
        driver.findElement(By.xpath("//label[@for='q48_3']")).click();
        //driver.findElement(By.xpath("//label[@for='q49_4']")).click();
        driver.findElement(By.xpath("//label[@for='q50_5']")).click();
        driver.findElement(By.xpath("//label[@for='q51_1']")).click();
        //driver.findElement(By.xpath("//label[@for='q52_2']")).click();
        driver.findElement(By.xpath("//label[@for='q53_3']")).click();
        driver.findElement(By.xpath("//label[@for='q54_4']")).click();
        //driver.findElement(By.xpath("//label[@for='q55_5']")).click();
        driver.findElement(By.xpath("//label[@for='q56_1']")).click();
        driver.findElement(By.xpath("//label[@for='q57_2']")).click();
        //driver.findElement(By.xpath("//label[@for='q58_3']")).click();
        driver.findElement(By.xpath("//label[@for='q59_4']")).click();
        driver.findElement(By.xpath("//label[@for='q60_5']")).click();
        //driver.findElement(By.xpath("//label[@for='q61_1']")).click();
        driver.findElement(By.xpath("//label[@for='q62_2']")).click();
        driver.findElement(By.xpath("//label[@for='q63_3']")).click();
        //driver.findElement(By.xpath("//label[@for='q64_4']")).click();
        driver.findElement(By.xpath("//input[@value='Enviar']")).click();
        String texto = driver.findElement(By.xpath("//h5[@class='modal-title']")).getText();
        AssertEquals.assertEquals("Aceitar e adicionar aos contatos", texto);

        
        // deslogar
        driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();
        driver.findElement(By.xpath("//a[@id='user-menu-toggle']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.quit();
    }

    @Test
    @Displayname(" Responder questionario por partes 03")
    // erro
    // reponder algumas sair e responder o resto depois 
    public void envioQeustionarioPorPartes(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        // criar Pesquisa de avalhação 

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        //driver.findElement(By.xpath("//span[@class='expandall text-nowrap']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'tab-pane active')]//a[contains(@title,'Adicionar um novo Pesquisa de avaliação')]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Teste 03");
        Select se = new Select(driver.findElement(By.xpath("//select[@id='id_template']")));
        se.selectByValue("4");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
  
        // mudar para aluno 
        driver.findElement(By.xpath("//a[@id='user-menu-toggle']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();
        // abre questionario 
        driver.findElement(By.xpath("//div[contains(@class,'modtype_survey position-relative align-self-start')]//a[contains(@class,'aalink stretched-link')]")).click();
        // responder todas as questoes 
        driver.findElement(By.xpath("//label[@for='q45_1']")).click();
        driver.findElement(By.xpath("//label[@for='q46_1']")).click();
        driver.findElement(By.xpath("//label[@for='q47_2']")).click();
        driver.findElement(By.xpath("//label[@for='q48_3']")).click();
        driver.findElement(By.xpath("//label[@for='q49_4']")).click();
        driver.findElement(By.xpath("//label[@for='q50_5']")).click();
        driver.findElement(By.xpath("//label[@for='q51_1']")).click();
        driver.findElement(By.xpath("//label[@for='q52_2']")).click();
        driver.findElement(By.xpath("//label[@for='q53_3']")).click();
        driver.findElement(By.xpath("//label[@for='q54_4']")).click();
        driver.findElement(By.xpath("//label[@for='q55_5']")).click();
        driver.findElement(By.xpath("//label[@for='q56_1']")).click();
        driver.findElement(By.xpath("//label[@for='q57_2']")).click();
        driver.findElement(By.xpath("//label[@for='q58_3']")).click();
        driver.findElement(By.xpath("//label[@for='q59_4']")).click();
        driver.findElement(By.xpath("//label[@for='q60_5']")).click();
        driver.findElement(By.xpath("//label[@for='q61_1']")).click();
        driver.findElement(By.xpath("//a[@title='Introdução a Algoritmos e Programação com Jogos Digitais']")).click();

        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[3]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//a[1]")).click();
        driver.findElement(By.xpath("//label[@for='q62_2']")).click();
        driver.findElement(By.xpath("//label[@for='q63_3']")).click();
        driver.findElement(By.xpath("//label[@for='q64_4']")).click();
        driver.findElement(By.xpath("//input[@value='Enviar']")).click();
        
        // deslogar
        driver.findElement(By.xpath("//button[@class='btn btn-secondary']")).click();
        driver.findElement(By.xpath("//a[@id='user-menu-toggle']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.quit();

    }
    
    @Test
    @Displayname(" Responder questionario feito ")
    // criei o questionario e ele ja veio como comcluido 
    public void responderQuestionarioComcluido(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        // criar Pesquisa de avalhação 

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        //driver.findElement(By.xpath("//span[@class='expandall text-nowrap']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'tab-pane active')]//a[contains(@title,'Adicionar um novo Pesquisa de avaliação')]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Teste 04");
        Select se = new Select(driver.findElement(By.xpath("//select[@id='id_template']")));
        se.selectByValue("4");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
  
        // mudar para aluno 
        driver.findElement(By.xpath("//a[@id='user-menu-toggle']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();

        // ABRIR QUESTIONARIO 
        driver.findElement(By.xpath("//li[3]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//a[1]")).click();
        String texto = driver.findElement(By.xpath("//button[normalize-space()='Concluído']")).getText();
        AssertEquals.assertEquals("Concluído", texto);

        // deslogar
        driver.findElement(By.xpath("//a[@id='user-menu-toggle']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.quit();



    }

    @Test
    @Displayname(" resposta De Texto Curto ")
    // tem dois casos aqui 
    // 1 i casi em si
    // 2 o caso em que ele ja abre a atividade como concluida 
    public void respostaDeTextoCurto(){
                // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        // criar pesquisa de retorno
        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div/div[contains(@data-region,'mainpage')]/div/div/div/section[contains(@aria-label,'Conteúdo')]/div[contains(@role,'main')]/div/div/ul[contains(@data-for,'course_sectionlist')]/li[3]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//body[1]/div[7]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[16]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("respostaDeTextoCurto");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // criar questao 
        driver.findElement(By.xpath("//a[normalize-space()='Editar questões']")).click();
        driver.findElement(By.xpath("//select[@name='typ']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@name='typ']")));
        se.selectByValue("textfield");

        //  criar a pergunta 
        driver.findElement(By.xpath("//label[@for='id_required']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Qeustao 01 teste");
        driver.findElement(By.xpath("//input[@name='save_item']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Voltar']")).click();
        
        // mudar para estudante 
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Página inicial']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Introdução a Algoritmos e Programação com Jogos Di')]")).click();
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();
        driver.findElement(By.xpath("//div[contains(@data-activityname,'respostaDeTextoCurto')]//a[contains(@class,'aalink stretched-link')]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//input[@class='form-control ']")).sendKeys("Resposta da pergunta");
        driver.findElement(By.xpath("//input[@name='savevalues']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
                // deslogar
        driver.quit();

    }

    @Test
    @Displayname(" rotulo ")
    // nao lembro 
        public void rotulo(){
                // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        // criar pesquisa de retorno
        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div/div[contains(@data-region,'mainpage')]/div/div/div/section[contains(@aria-label,'Conteúdo')]/div[contains(@role,'main')]/div/div/ul[contains(@data-for,'course_sectionlist')]/li[3]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//body[1]/div[7]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[16]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("rotulo");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // criar questao 
        driver.findElement(By.xpath("//a[normalize-space()='Editar questões']")).click();
        driver.findElement(By.xpath("//select[@name='typ']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@name='typ']")));
        se.selectByValue("label");

        //  criar a pergunta 
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto Texto");
        driver.findElement(By.xpath("//input[@name='save_item']")).click();
        
        // mudar para estudante 
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Página inicial']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Introdução a Algoritmos e Programação com Jogos Di')]")).click();
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();

        // abre para resposta
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[3]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//a[1]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        driver.findElement(By.xpath("//input[@name='savevalues']")).click();
        
        // deslogar
        driver.quit();

    }

    @Test
    @Displayname(" resposat com numero  ")
    // so aceita numero 
        public void repostaNumerica(){
                // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        // criar pesquisa de retorno
        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div/div[contains(@data-region,'mainpage')]/div/div/div/section[contains(@aria-label,'Conteúdo')]/div[contains(@role,'main')]/div/div/ul[contains(@data-for,'course_sectionlist')]/li[3]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//body[1]/div[7]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[16]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("rotulo");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // criar questao 
        driver.findElement(By.xpath("//a[normalize-space()='Editar questões']")).click();
        driver.findElement(By.xpath("//select[@name='typ']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@name='typ']")));
        se.selectByValue("numeric");

        //  criar a pergunta 
        driver.findElement(By.xpath("//input[@name='save_item']")).click();
        
        // mudar para estudante 
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Página inicial']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Introdução a Algoritmos e Programação com Jogos Di')]")).click();
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();

        // abre para resposta
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[3]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//a[1]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        //resposta
        driver.findElement(By.xpath("//input[@class='form-control ']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name='savevalues']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        // deslogar
        driver.quit();

    }

    @Test
    @Displayname(" resposta com numero reposta com letra ")
    // coloca uma letra mas so é aceito numero 
        public void repostaNumericaLetra(){
                // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        // criar pesquisa de retorno
        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div/div[contains(@data-region,'mainpage')]/div/div/div/section[contains(@aria-label,'Conteúdo')]/div[contains(@role,'main')]/div/div/ul[contains(@data-for,'course_sectionlist')]/li[3]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//body[1]/div[7]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[16]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("rotulo");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // criar questao 
        driver.findElement(By.xpath("//a[normalize-space()='Editar questões']")).click();
        driver.findElement(By.xpath("//select[@name='typ']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@name='typ']")));
        se.selectByValue("numeric");

        //  criar a pergunta 
        driver.findElement(By.xpath("//input[@name='save_item']")).click();
        
        // mudar para estudante 
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Página inicial']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Introdução a Algoritmos e Programação com Jogos Di')]")).click();
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();

        // abre para resposta
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[3]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//a[1]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        //resposta
        driver.findElement(By.xpath("//input[@class='form-control ']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@name='savevalues']")).click();
        String erro = driver.findElement(By.xpath("//input[@class='form-control ']")).getText();
        AssertEquals.assertEquals("Valor numérico inválido", erro);

        // deslogar
        driver.quit();

    }
    @Test
    @Displayname(" Múltiplas escolhas (rateadas)")
    // coloca uma letra mas so é aceito numero 
        public void MúltiplasEscolhasRateadas(){
                // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        // criar pesquisa de retorno
        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div/div[contains(@data-region,'mainpage')]/div/div/div/section[contains(@aria-label,'Conteúdo')]/div[contains(@role,'main')]/div/div/ul[contains(@data-for,'course_sectionlist')]/li[3]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//body[1]/div[7]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[16]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("rotulo");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // criar questao 
        driver.findElement(By.xpath("//a[normalize-space()='Editar questões']")).click();
        driver.findElement(By.xpath("//select[@name='typ']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@name='typ']")));
        se.selectByValue("multichoicerated");

        //  criar a pergunta 
        driver.findElement(By.xpath("//input[@name='save_item']")).click();
        
        // mudar para estudante 
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Página inicial']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Introdução a Algoritmos e Programação com Jogos Di')]")).click();
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();

        // abre para resposta
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[3]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//a[1]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        //resposta
        //driver.findElement(By.xpath("//input[@name='save_item']")).click();
        driver.findElement(By.xpath("//input[@name='savevalues']")).click();

        // deslogar
        driver.quit();

    }

    @Test
    @Displayname(" Múltiplas escolhas")
    // coloca uma letra mas so é aceito numero 
        public void MúltiplasEscolhas(){
                // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        // criar pesquisa de retorno
        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div/div[contains(@data-region,'mainpage')]/div/div/div/section[contains(@aria-label,'Conteúdo')]/div[contains(@role,'main')]/div/div/ul[contains(@data-for,'course_sectionlist')]/li[3]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//body[1]/div[7]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[16]/div[1]/a[1]")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("rotulo");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // criar questao 
        driver.findElement(By.xpath("//a[normalize-space()='Editar questões']")).click();
        driver.findElement(By.xpath("//select[@name='typ']")).click();
        Select se = new Select(driver.findElement(By.xpath("//select[@name='typ']")));
        se.selectByValue("multichoice");

        //  criar a pergunta 
        driver.findElement(By.xpath("//input[@name='save_item']")).click();
        
        // mudar para estudante 
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Página inicial']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Introdução a Algoritmos e Programação com Jogos Di')]")).click();
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();

        // abre para resposta
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[3]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//a[1]")).click();
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        //resposta
        //driver.findElement(By.xpath("//input[@name='save_item']")).click();
        driver.findElement(By.xpath("//input[@name='savevalues']")).click();

        // deslogar
        driver.quit();

    }
    
    @Test
    @Displayname(" Responder questionario incompleto 02")
    public void excliur(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().minimize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//div[@data-activityname='rotulo']//a[@role='button']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu menu dropdown-menu-right show']//span[@class='menu-action-text'][normalize-space()='Excluir']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Sim']")).click();
        driver.quit();

    }

}

