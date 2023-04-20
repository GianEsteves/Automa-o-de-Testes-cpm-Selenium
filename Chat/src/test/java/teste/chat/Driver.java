package teste.chat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

@Displayname("Teste do Chat")
public class Driver {
    
    @Test
    @Displayname("Criar grupo")
    public void criarGrupo(){

        // inica e faz o lpgin 
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

        // vai ate as opiçoes 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//select[@name='jump']")).click();
        Select se1 = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        se1.selectByValue("/group/index.php?id=8");

        // cria o grupo 
        driver.findElement(By.xpath("//input[@name='act_showcreateorphangroupform']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Grupo do teste de automação ");
        driver.findElement(By.xpath("//select[@name='enablemessaging']")).click();
        Select se2 = new Select(driver.findElement(By.xpath("//select[@name='enablemessaging']")));
        se2.selectByValue("1");
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

         // deslogar 
         WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
         deslogar.click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
         WebElement sair = driver.findElement(By.className("dropdown-item"));
         sair.click();
         driver.close();
    }

    @Test
    @Displayname("")
    public void excluirGrupo(){

        
        // inica e faz o lpgin 
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

        // vai ate as opiçoes 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//select[@name='jump']")).click();
        Select se1 = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        se1.selectByValue("/group/index.php?id=8");

        // elclui 
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath("//option[@title='Grupo do teste de automação (1)']")).click();
        driver.findElement(By.xpath("//input[@name='act_deletegroup']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Sim']")).click();

        // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

    }

    @Test
    @Displayname("Adicionar imagem ")
    public void adicionarImagem(){
                // inica e faz o lpgin 
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

        // vai ate as opiçoes 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//select[@name='jump']")).click();
        Select se1 = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        se1.selectByValue("/group/index.php?id=8");

        // abri as configurações 
        driver.findElement(By.xpath("//div[@data-region='mainpage']")).click();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath("//option[@title='Grupo do teste de automação (1)']")).click();
        driver.findElement(By.xpath("//input[@name='act_showgroupsettingsform']")).click();

        // adicionar    
        driver.findElement(By.xpath("//input[@name='imagefilechoose']")).click();
        //driver.findElement(By.id("yui_3_17_2_1_1669301531420_1464")).click();
        //driver.findElement(By.xpath("//input[@name='repo_upload_file']")).click();
        driver.findElement(By.xpath("//input[@name='repo_upload_file']")).sendKeys("C:\\Users\\giann\\OneDrive\\Área de Trabalho\\unipampa\\RP2");
        driver.findElement(By.xpath("//button[normalize-space()='Enviar este arquivo']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

    }

    @Test
    @Displayname("Alterar omagem")
    public void alterarImagem(){
                  // inica e faz o lpgin 
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

        // vai ate as opiçoes 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//select[@name='jump']")).click();
        Select se1 = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        se1.selectByValue("/group/index.php?id=8");

        // abri as configurações 
        driver.findElement(By.xpath("//div[@data-region='mainpage']")).click();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath("//option[@title='Grupo do teste de automação (1)']")).click();
        driver.findElement(By.xpath("//input[@name='act_showgroupsettingsform']")).click();

        // alterar 
        driver.findElement(By.xpath("//input[@name='imagefilechoose']")).click();
        driver.findElement(By.xpath("//div[@role='tab']//a[@class='nav-link active']")).click();
        driver.findElement(By.xpath("//input[@name='repo_upload_file']")).sendKeys("C:\\Users\\giann\\OneDrive\\Área de Trabalho\\unipampa\\RP2");
        driver.findElement(By.xpath("//button[normalize-space()='Enviar este arquivo']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();
    }

    @Test
    @Displayname("Excluir imagem")
    public void excluirImagem(){
                        // inica e faz o lpgin 
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

        // vai ate as opiçoes 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//select[@name='jump']")).click();
        Select se1 = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        se1.selectByValue("/group/index.php?id=8");

        // abri as configurações 
        driver.findElement(By.xpath("//div[@data-region='mainpage']")).click();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath("//option[@title='Grupo do teste de automação (1)']")).click();
        driver.findElement(By.xpath("//input[@name='act_showgroupsettingsform']")).click();

        // excluir 
        driver.findElement(By.xpath("//label[normalize-space()='Excluir']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

    }

    @Test
    @Displayname("Aletera titulo ")
    public void alterarTitulo(){
            // inica e faz o lpgin 
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

                // vai ate as opiçoes 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//select[@name='jump']")).click();
        Select se1 = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        se1.selectByValue("/group/index.php?id=8");

        // abri as configurações 
        driver.findElement(By.xpath("//div[@data-region='mainpage']")).click();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath("//option[@title='Grupo do teste de automação (1)']")).click();
        driver.findElement(By.xpath("//input[@name='act_showgroupsettingsform']")).click();
        
        // alterar o titulo 
        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Grupo do teste de automação renomeando (1) ");
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

                // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

    }

    @Test
    @Displayname("Adicionar participante ")
    public void adcionarParticipante(){
                    // inica e faz o lpgin 
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

                // vai ate as opiçoes 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//select[@name='jump']")).click();
        Select se1 = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        se1.selectByValue("/group/index.php?id=8");

        driver.findElement(By.xpath("//div[@data-region='mainpage']")).click();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath("//option[@title='Grupo do teste de automação (1)']")).click();

        // adiconar participante 
        driver.findElement(By.xpath("//input[@name='act_showaddmembersform']")).click();
        driver.findElement(By.xpath("//option[@value='46']")).click();
        driver.findElement(By.xpath("//input[@title='Adicionar']")).click();
        driver.findElement(By.xpath("//input[@name='cancel']")).click();

        // testar 
        driver.findElement(By.xpath("//a[@class='nav-link popover-region-toggle position-relative icon-no-margin']")).click();
        driver.findElement(By.xpath("//div[@data-region='view-overview-group-messages']//i[@class='icon fa fa-caret-right fa-fw ']")).click();
        driver.findElement(By.xpath("//div[@data-region='content-container']//a[@role='button']//div//div//strong[contains(text(),'Grupo do teste de automação')]")).click();
        driver.findElement(By.xpath("//button[@aria-label='Menu de ações de conversa']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Informação do Grupo']")).click();
        String textoElement = driver.findElement(By.xpath("//h6[normalize-space()='UALQUER RAMOS TOLEDO']")).getText();
        assertEquals("UALQUER RAMOS TOLEDO", textoElement);
        
        // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

    }

    @Test
    @Displayname("Remover participante ")
    public void removerParticipante(){
                            // inica e faz o lpgin 
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

                // vai ate as opiçoes 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//select[@name='jump']")).click();
        Select se1 = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        se1.selectByValue("/group/index.php?id=8");

        driver.findElement(By.xpath("//div[@data-region='mainpage']")).click();
        //////////////////////////////////////////////////////////////////////////////////////////////////////////
        driver.findElement(By.xpath("//option[@title='Grupo do teste de automação (2)']")).click();

        // adiconar participante 
        driver.findElement(By.xpath("//input[@name='act_showaddmembersform']")).click();
        driver.findElement(By.xpath("//option[@value='46']")).click();
        driver.findElement(By.xpath("//input[@title='Remover']")).click();
        driver.findElement(By.xpath("//input[@name='cancel']")).click();

        // testar 
        driver.findElement(By.xpath("//div[@data-region='popover-region-messages']//a[@role='button']")).click();
        driver.findElement(By.xpath("//body/div/div[@role='region']/div[@role='region']/div[@data-region='body-container']/div[@data-region='view-overview']/div/div[@data-region='view-overview-group-messages']/div[@data-region='toggle']/button[@data-toggle='collapse']/span[1]/i[1]")).click();
        driver.findElement(By.xpath("//div[@data-region='content-container']//a[@role='button']//div//div//strong[contains(text(),'Grupo do teste de automação')]")).click();
        //driver.findElement(By.xpath("//button[@aria-label='Menu de ações de conversa']")).click();
        //driver.findElement(By.xpath("//a[normalize-space()='Informação do Grupo']")).click();
        String textoElement1 = driver.findElement(By.xpath("//small[normalize-space()='1 participantes']")).getText();
        assertEquals("1 participantes", textoElement1);
        
        // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

    }

    @Test
    @Displayname (" Criar grupo sem mandar mesagem")
    public void criarGrupo2(){
        // inica e faz o lpgin 
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

        // vai ate as opiçoes 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//select[@name='jump']")).click();
        Select se1 = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        se1.selectByValue("/group/index.php?id=8");

        // cria o grupo 
        driver.findElement(By.xpath("//input[@name='act_showcreateorphangroupform']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Grupo do teste de automação 34 ");
        driver.findElement(By.xpath("//select[@name='enablemessaging']")).click();
        Select se2 = new Select(driver.findElement(By.xpath("//select[@name='enablemessaging']")));
        se2.selectByValue("0");
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        // o grupo é criado mas nao aárece na area dos grupos 


         // deslogar 
         WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
         deslogar.click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
         WebElement sair = driver.findElement(By.className("dropdown-item"));
         sair.click();
         driver.close();
    }

    @Test
    @Displayname(" Adicionar grupo aos favoritos  ")
    public void Favoritar(){
         // inica e faz o lpgin 
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
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // adiconar aos favoritos 
        driver.findElement(By.xpath("//div[@data-region='popover-region-messages']//a[@role='button']")).click();
        driver.findElement(By.xpath("//div[@data-region='view-overview-group-messages']//button[@data-toggle='collapse']")).click();
        driver.findElement(By.xpath("//div[@data-region='content-container']//a[@role='button']//div//div//strong[contains(text(),'Grupo do teste de automação')]")).click();
        driver.findElement(By.xpath("//button[@aria-label='Menu de ações de conversa']//i[@aria-hidden='true']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Favoritar conversa']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Voltar para Visão geral das mensagens']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Favoritos']")).click();

        // verifica 
        driver.findElement(By.xpath("//div[@data-region='content-container']//a[@role='button']//div//div//strong[contains(text(),'Grupo do teste de automação')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String texto2 = driver.findElement(By.xpath("//a[@data-action='view-group-info']//div//div//strong[contains(text(),'Grupo do teste de automação')]")).getText();
        assertEquals("Grupo do teste de automação", texto2);

        // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

        
    }

    @Test
    @Displayname (" Remover do favaritos ")
    public void desfavoritar(){
                 // inica e faz o lpgin 
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
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // remover aos favoritos 
        driver.findElement(By.xpath("//div[@data-region='popover-region-messages']//a[@role='button']")).click();
        driver.findElement(By.xpath("//div[@data-region='view-overview-favourites']//button[@data-toggle='collapse']")).click();
        driver.findElement(By.xpath("//div[@data-region='content-container']//a[@role='button']//div//div//strong[contains(text(),'Grupo do teste de automação')]")).click();
        driver.findElement(By.xpath("//button[@aria-label='Menu de ações de conversa']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Remover estrela da conversa']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Voltar para Visão geral das mensagens']//div[1]//span[1]//i[1]")).click();
        driver.findElement(By.xpath("//div[@data-region='view-overview-group-messages']//button[@data-toggle='collapse']")).click();
        driver.findElement(By.xpath("//div[@data-region='content-container']//a[@role='button']//div//div//strong[contains(text(),'Grupo do teste de automação')]")).click();

        // verifica 
        //driver.findElement(By.xpath("//div[@data-region='content-container']//a[@role='button']//div//div//strong[contains(text(),'Grupo do teste de automação')]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String texto2 = driver.findElement(By.xpath("//a[@data-action='view-group-info']//div//div//strong[contains(text(),'Grupo do teste de automação')]")).getText();
        assertEquals("Grupo do teste de automação", texto2);

        // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();
    }

    @Test
    @Displayname (" Enviar mesagem")
    public void enviarMensagem(){
                         // inica e faz o lpgin 
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // emviar mensagem 
        driver.findElement(By.xpath("//div[@data-region='popover-region-messages']//a[@role='button']")).click();
        driver.findElement(By.xpath("//div[@data-region='view-overview-group-messages']//button[@data-toggle='collapse']")).click();
        driver.findElement(By.xpath("//strong[normalize-space()='Grupo do teste de automação']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Escrever uma mensagem...']")).sendKeys("Salve");
        driver.findElement(By.xpath("//button[@aria-label='Enviar mensagem']")).click();

         // deslogar
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();

         
        //driver.findElement(By.xpath("null")).click();
        driver.findElement(By.xpath("//input[@placeholder='Identificação de usuário']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Identificação de usuário']")).sendKeys("2110103008");
        driver.findElement(By.xpath("//input[@placeholder='Senha']")).sendKeys("2110103008");
        driver.findElement(By.xpath("//button[normalize-space()='Acessar']")).click();




        driver.findElement(By.xpath("//div[@data-region='popover-region-messages']//a[@role='button']")).click();
        driver.findElement(By.xpath("//div[@data-region='view-overview-group-messages']//button[@data-toggle='collapse']")).click();
        driver.findElement(By.xpath("//div[@data-region='content-container']//a[@role='button']//div//div//strong[contains(text(),'Grupo do teste de automação')]")).click();
        String mensagem = driver.findElement(By.xpath("//div[@dir='auto']")).getText();
        AssertEquals.assertEquals("Salve", mensagem);

        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.quit();

    }

    @Test
    @Displayname("Senha do grupo")
    public void  senha(){
        // inica e faz o lpgin 
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
        

        // vai ate as opiçoes 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//select[@name='jump']")).click();
        Select se1 = new Select(driver.findElement(By.xpath("//select[@name='jump']")));
        se1.selectByValue("/group/index.php?id=8");

        // cria o grupo 
        driver.findElement(By.xpath("//input[@name='act_showcreateorphangroupform']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Grupo do teste de automação com senha ");
        driver.findElement(By.xpath("//select[@name='enablemessaging']")).click();
        driver.findElement(By.xpath("//a[@data-passwordunmask='edit']")).sendKeys("#As2210100408");
        Select se2 = new Select(driver.findElement(By.xpath("//select[@name='enablemessaging']")));
        se2.selectByValue("0");
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();
    }

    @Test
    @Displayname("mudo")
    public void  mudo(){
        // inica e faz o lpgin 
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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[@data-region='popover-region-messages']//a[@role='button']")).click();
        driver.findElement(By.xpath("//div[@data-region='view-overview-group-messages']//button[@data-toggle='collapse']")).click();
        driver.findElement(By.xpath("//strong[normalize-space()='Grupo do teste de automação']")).click();
        driver.findElement(By.xpath("//button[@aria-label='Menu de ações de conversa']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudo']")).click();

                // deslogar 
        WebElement deslogar = driver.findElement(By.id("user-menu-toggle"));
        deslogar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //WebElement sair = driver.findElement(By.xpath("//*[@className='dropdown']/div[3]/div/span/a"));
        WebElement sair = driver.findElement(By.className("dropdown-item"));
        sair.click();
        driver.close();

    }

    @Test
    @Displayname("Enviar Solicitação")
    public void enviarSolicitacao(){
        // inica e faz o lpgin 
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//tbody/tr[6]/th[1]/a[1]")).click();
        driver.findElement(By.xpath("//a[@class='ajax-contact-button btn']")).click();

        // deslogar
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.findElement(By.xpath("//div[@data-region='usermenu']//div//span")).click();

         
        //driver.findElement(By.xpath("null")).click();
        driver.findElement(By.xpath("//input[@placeholder='Identificação de usuário']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Identificação de usuário']")).sendKeys("2110103008");
        driver.findElement(By.xpath("//input[@placeholder='Senha']")).sendKeys("2110103008");
        driver.findElement(By.xpath("//button[normalize-space()='Acessar']")).click();


        driver.findElement(By.xpath("//a[@class='nav-link popover-region-toggle position-relative icon-no-margin']")).click();
        driver.findElement(By.xpath("//a[@data-route='view-contacts']")).click();
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();
        driver.findElement(By.xpath("//p[normalize-space()='Gostaria de entrar em contato com você']"));
        String texto = driver.findElement(By.xpath("//button[@data-action='accept-contact-request']")).getText();
        AssertEquals.assertEquals("Aceitar e adicionar aos contatos", texto);
        driver.findElement(By.xpath("//p[normalize-space()='Gostaria de entrar em contato com você']")).click();
        driver.findElement(By.xpath("//button[@data-action='accept-contact-request']")).click();

        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.quit();
   
    }
    
    @Test
    @Displayname("Recusar Solicitação")
    public void recusarSolicitacao(){
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//tbody/tr[6]/th[1]/a[1]")).click();
        driver.findElement(By.xpath("//a[@class='ajax-contact-button btn']")).click();

        // deslogar
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.findElement(By.xpath("//div[@data-region='usermenu']//div//span")).click();

         
        //driver.findElement(By.xpath("null")).click();
        driver.findElement(By.xpath("//input[@placeholder='Identificação de usuário']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Identificação de usuário']")).sendKeys("2110103008");
        driver.findElement(By.xpath("//input[@placeholder='Senha']")).sendKeys("2110103008");
        driver.findElement(By.xpath("//button[normalize-space()='Acessar']")).click();


        driver.findElement(By.xpath("//a[@class='nav-link popover-region-toggle position-relative icon-no-margin']")).click();
        driver.findElement(By.xpath("//a[@data-route='view-contacts']")).click();
        driver.findElement(By.xpath("//a[@class='nav-link']")).click();
        driver.findElement(By.xpath("//p[normalize-space()='Gostaria de entrar em contato com você']"));
        String texto = driver.findElement(By.xpath("//button[@data-action='accept-contact-request']")).getText();
        AssertEquals.assertEquals("Aceitar e adicionar aos contatos", texto);
        driver.findElement(By.xpath("//p[normalize-space()='Gostaria de entrar em contato com você']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Recusar']")).click();

        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.quit();
    }

    @Test
    @Displayname("Excluir Contato")
    public void excluirContato(){
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//tbody/tr[6]/th[1]/a[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Excluir dos contatos')]")).click();

       
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.quit();

    }

    @Test
    @Displayname(" Enviar mesagem no privado ")
    public void mensagemPrivado(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        WebElement usuario = driver.findElement(By.id("username"));
        usuario.click();
        usuario.sendKeys("2110103008");
        WebElement senha = driver.findElement(By.id("password"));
        senha.sendKeys("2110103008");
        WebElement botaoAcesso = driver.findElement(By.id("loginbtn"));
        botaoAcesso.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // enviar mesagem 
        driver.findElement(By.xpath("//a[normalize-space()='Participantes']")).click();
        driver.findElement(By.xpath("//tbody/tr[3]/th[1]/a[1]")).click();
        driver.findElement(By.xpath("//a[@id='message-user-button']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Escrever uma mensagem...']")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Escrever uma mensagem...']")).sendKeys("Teste");
        driver.findElement(By.xpath("//button[@aria-label='Enviar mensagem']")).click();
        
        // deslogar 
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.findElement(By.xpath("//div[@data-region='usermenu']//div//span")).click();


        // logar 
        driver.findElement(By.xpath("//input[@placeholder='Identificação de usuário']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Identificação de usuário']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@placeholder='Senha']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[normalize-space()='Acessar']")).click();
        
        // verificar 
        driver.findElement(By.xpath("//div[@data-region='popover-region-messages']//a[@role='button']")).click();
        driver.findElement(By.xpath("//strong[normalize-space()='UALQUER RAMOS TOLEDO']")).click();
        String mensagem = driver.findElement(By.xpath("//p[contains(text(),'Teste')]")).getText();
        AssertEquals.assertEquals("Teste", mensagem);


        // deslogar 
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.close();
        
    }

    @Test
    @Displayname("Excluir mesagem do ´rivado ")
    public void excluirMensagemPV(){
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // escluir 
        driver.findElement(By.xpath("//a[@class='nav-link popover-region-toggle position-relative icon-no-margin']")).click();
        driver.findElement(By.xpath("//div[@data-region='view-overview-messages']//button[@data-toggle='collapse']")).click();
        driver.findElement(By.xpath("//body//div//div[contains(@data-region,'view-overview')]//div[contains(@data-region,'content-container')]//div//div//div//span[1]//i[1]")).click();
        driver.findElement(By.xpath("//button[@id='conversation-actions-menu-button']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Apagar conversa']")).click();
        driver.findElement(By.xpath("//button[contains(@data-action,'confirm-delete-conversation')]")).click();

        // deslogar 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@aria-label='Menu do usuário']")).click();
        driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Sair']")).click();
        driver.quit();
    }

}
