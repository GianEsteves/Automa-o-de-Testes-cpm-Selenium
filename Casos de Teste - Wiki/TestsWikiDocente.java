import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.json.simple.*;
import org.json.simple.parser.*;


public class TestsWikiDocente{

    private WebDriver driver = new ChromeDriver();


    @Before
    public void setUp() throws IOException, InterruptedException, ParseException{
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8#section-0");
        driver.manage().window().maximize();

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));
        
        

        // Preencher o campo "Identificação do Usuário" com seu login
        WebElement identificacaoUsuario = driver.findElement(By.id("username"));
        identificacaoUsuario.click();
        identificacaoUsuario.sendKeys(obj.get("matricula").toString());

        //Preencher o campo "Senha" com sua senha
        WebElement senhaUsuario = driver.findElement(By.id("password"));
        senhaUsuario.click();
        senhaUsuario.sendKeys(obj.get("matricula").toString());
        
        // Clicar em acessar
        WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
        acessarBotao.click();
        Thread.sleep(2000);

        // Clicar no botão "Modo de edição"
        WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
        modoEdicao.click();
        Thread.sleep(4000);
        
    
    }


    @Test
    public void criarTopicoWiki() throws InterruptedException, IOException, ParseException{
                

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

        // Clicar no botão "Adicionar tópico"
        WebElement adicionaTopico = driver.findElement(By.xpath("//div[@id='coursecontentcollapse0']//a[@class='add-sections'][normalize-space()='Adicionar tópico']"));
        adicionaTopico.click();
        Thread.sleep(5000);

        // // Clicar no botão "Editar"
        // WebElement botaoEditar = driver.findElement(By.xpath("//div[@class='action-menu-trigger']//a[@id='action-menu-toggle-0']//i[@title='Editar']"));
        // botaoEditar.click();
        // Thread.sleep(5000);

        List<WebElement> listaModulos = driver.findElement(By.id("section-1")).findElement(By.className("course-section-header")).findElement(By.className("section_action_menu")).findElement(By.className("action-menu")).findElements(By.className("dropdown"));

        listaModulos = driver.findElement(By.id("section-1")).findElement(By.className("course-section-header")).findElement(By.className("section_action_menu")).findElement(By.className("action-menu")).findElements(By.className("dropdown"));
        Thread.sleep(4000);
        listaModulos.get(0).click();
        Thread.sleep(5000);

        for(WebElement elemento : listaModulos) {
            if(elemento.getText().contains("Editar")) {
                WebElement botaoEditar2 = elemento.findElements(By.className("dropdown-menu")).get(0).findElements(By.tagName("a")).get(0);
                Thread.sleep(5000);
                botaoEditar2.click();

            }
        }

        // Clicar no botão "Personalizado"
        WebElement botaoPersonalizado = driver.findElement(By.xpath("//input[@id='id_name_customize']"));
        botaoPersonalizado.click();
        Thread.sleep(2000);

        // Clicar no campo "Nome do tópico"                     Preencher o campo com "Wiki"
        WebElement nomeTopico = driver.findElement(By.xpath("//input[@id='id_name_value']"));
        nomeTopico.click();
        Thread.sleep(2000);
        nomeTopico.sendKeys(obj.get("nomeTopicoWiki").toString());

        // Clicar no botão "Salvar mudanças"
        WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton']"));
        salvarVoltar.click();
        Thread.sleep(2000);
                    
    }
    

@Test
    public void criarWikiColaborativa() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));


        // Clicar no botão "Adicionar uma atividade ou recurso"	do tópico Wiki
        WebElement adicionarAtividade = driver.findElement(By.xpath("//div[@id='coursecontentcollapse1']//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso']"));
        adicionarAtividade.click();
        Thread.sleep(3000);
        //    if(adicionarRecurso.isDisplayed()){
        //        adicionarRecurso.click();
        //    }

        // Clicar na atividade "Wiki"
        WebElement atividadeWiki = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo Wiki']"));
        atividadeWiki.click();
        Thread.sleep(5000);

        // Clicar no campo "Nome"							Preencher o campo com "" 
        WebElement nomeWiki = driver.findElement(By.xpath("//input[@id='id_name']"));
        nomeWiki.click();
        Thread.sleep(5000);
        nomeWiki.sendKeys(obj.get("campoNomeWiki").toString());

        
        // Clicar no campo "Descrição"							Preencher o campo com ""
        WebElement campoDescricao = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
        campoDescricao.click();
        Thread.sleep(5000);
        campoDescricao.clear();
        campoDescricao.sendKeys(obj.get("campoDescricaoWiki").toString());
        Thread.sleep(5000);


        // Clicar no botão "Exibir descrição na página do curso"
        WebElement botaoExibirDescricao = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
        botaoExibirDescricao.click();
        Thread.sleep(2000);

        // Clicar no botão "Modo Wiki"							
        WebElement botaoModoWiki = driver.findElement(By.xpath("//select[@id='id_wikimode']"));
        botaoModoWiki.click();
        Thread.sleep(5000);

        // Selecionar o tipo de Wiki "Colaborativa"
        WebElement botaoTColaborativa = driver.findElement(By.xpath("//option[@value='collaborative']"));
        botaoTColaborativa.click();
        Thread.sleep(5000);

        //Clicar no campo "Nome da primeira página"					Preencher o campo com "Teste"
        WebElement campoPrimeiraPag = driver.findElement(By.xpath("//input[@id='id_firstpagetitle']"));
        campoPrimeiraPag.click();
        Thread.sleep(2000);
        campoPrimeiraPag.sendKeys(obj.get("campoNomeWikiI").toString());

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar22 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar22.click();
        Thread.sleep(2000);

    }

   

@Test
    public void criarWikiColaborativaNExibir() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));


        // Clicar no botão "Adicionar uma atividade ou recurso"	do tópico Wiki
        WebElement adicionarAtividade1 = driver.findElement(By.xpath("//div[@id='coursecontentcollapse1']//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso']"));
        adicionarAtividade1.click();
        Thread.sleep(5000);
        //    if(adicionarRecurso.isDisplayed()){
        //        adicionarRecurso.click();
        //    }

        // Clicar na atividade "Wiki"
        WebElement atividadeWiki1 = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo Wiki']"));
        atividadeWiki1.click();
        Thread.sleep(3000);

        // Clicar no campo "Nome"							Preencher o campo com "" 
        WebElement nomeWiki1 = driver.findElement(By.xpath("//input[@id='id_name']"));
        nomeWiki1.click();
        Thread.sleep(3000);
        nomeWiki1.sendKeys(obj.get("campoNomeWiki").toString());
        Thread.sleep(3000);
        
        // Clicar no campo "Descrição"							Preencher o campo com ""
        WebElement campoDescricao1 = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
        campoDescricao1.click();
        Thread.sleep(5000);
        campoDescricao1.clear();
        campoDescricao1.sendKeys(obj.get("campoDescricaoWiki").toString());
        Thread.sleep(5000);


        // // Clicar no botão  "Não Exibir descrição na página do curso"
        // WebElement botaoNExibirDescricao1 = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
        // botaoNExibirDescricao1.click();
        // Thread.sleep(2000);

        // Clicar no botão "Modo Wiki"							
        WebElement botaoModoWiki1 = driver.findElement(By.xpath("//select[@id='id_wikimode']"));
        botaoModoWiki1.click();
        Thread.sleep(5000);

        // Selecionar o tipo de Wiki "Colaborativa"
        WebElement botaoTipoColaborativa1 = driver.findElement(By.xpath("//option[@value='collaborative']"));
        botaoTipoColaborativa1.click();
        Thread.sleep(5000);

        //Clicar no campo "Nome da primeira página"					Preencher o campo com "Teste"
        WebElement campoPrimeiraPag1 = driver.findElement(By.xpath("//input[@id='id_firstpagetitle']"));
        campoPrimeiraPag1.click();
        Thread.sleep(3000);
        campoPrimeiraPag1.sendKeys(obj.get("campoNomeWikiI").toString());

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar1 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar1.click();
        Thread.sleep(2000);

    }


@Test
    public void criarWikiIndividual() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));


        // Clicar no botão "Adicionar uma atividade ou recurso"	do tópico Wiki
        WebElement adicionarAtividade2 = driver.findElement(By.xpath("//div[@id='coursecontentcollapse1']//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso']"));
        adicionarAtividade2.click();
        Thread.sleep(3000);
        //    if(adicionarRecurso.isDisplayed()){
        //        adicionarRecurso.click();
        //    }

        // Clicar na atividade "Wiki"
        WebElement atividadeWiki2 = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo Wiki']"));
        atividadeWiki2.click();
        Thread.sleep(3000);

        // Clicar no campo "Nome"							Preencher o campo com "" 
        WebElement nomeWiki2 = driver.findElement(By.xpath("//input[@id='id_name']"));
        nomeWiki2.click();
        Thread.sleep(2000);
        nomeWiki2.sendKeys(obj.get("campoNomeWikiI").toString());

        
        // Clicar no campo "Descrição"							Preencher o campo com ""
        WebElement campoDescricao = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
        campoDescricao.click();
        Thread.sleep(5000);
        campoDescricao.clear();
        campoDescricao.sendKeys(obj.get("campoDescricaoWiki").toString());
        Thread.sleep(5000);

        // Clicar no botão  "Exibir descrição na página do curso"
        WebElement botaoExibirDescricao2 = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
        botaoExibirDescricao2.click();
        Thread.sleep(2000);

        // Clicar no botão "Modo Wiki"							
        WebElement botaoModoWiki2 = driver.findElement(By.xpath("//select[@id='id_wikimode']"));
        botaoModoWiki2.click();
        Thread.sleep(2000);

        // Selecionar o tipo de Wiki "Individual"
        WebElement botaoTipoIndividual = driver.findElement(By.xpath("//option[@value='individual']"));
        botaoTipoIndividual.click();
        Thread.sleep(2000);

        //Clicar no campo "Nome da primeira página"					Preencher o campo com ""
        WebElement campoPrimeiraPag2 = driver.findElement(By.xpath("//input[@id='id_firstpagetitle']"));
        campoPrimeiraPag2.click();
        Thread.sleep(2000);
        campoPrimeiraPag2.sendKeys(obj.get("campoNomeWikiI").toString());

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar2 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar2.click();
        Thread.sleep(2000);

    }



@Test
    public void criarWikiIndividualNExibir() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));


        // Clicar no botão "Adicionar uma atividade ou recurso"	do tópico Wiki
        WebElement adicionarAtividade3 = driver.findElement(By.xpath("//div[@id='coursecontentcollapse1']//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso']"));
        adicionarAtividade3.click();
        Thread.sleep(3000);
        //    if(adicionarRecurso.isDisplayed()){
        //        adicionarRecurso.click();
        //    }

        // Clicar na atividade "Wiki"
        WebElement atividadeWiki3 = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo Wiki']"));
        atividadeWiki3.click();
        Thread.sleep(3000);

        // Clicar no campo "Nome"							Preencher o campo com "" 
        WebElement nomeWiki3 = driver.findElement(By.xpath("//input[@id='id_name']"));
        nomeWiki3.click();
        Thread.sleep(2000);
        nomeWiki3.sendKeys(obj.get("campoNomeWikiI").toString());

        
        // Clicar no campo "Descrição"							Preencher o campo com ""
        WebElement campoDescricao = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
        campoDescricao.click();
        Thread.sleep(5000);
        campoDescricao.clear();
        campoDescricao.sendKeys(obj.get("campoDescricaoWiki").toString());
        Thread.sleep(5000);

        // // Clicar no botão  "Não Exibir descrição na página do curso"
        // WebElement botaoNExibirDescricao3 = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
        // botaoNExibirDescricao3.click();
        // Thread.sleep(2000);

        // Clicar no botão "Modo Wiki"							
        WebElement botaoModoWiki3 = driver.findElement(By.xpath("//select[@id='id_wikimode']"));
        botaoModoWiki3.click();
        Thread.sleep(2000);

        // Selecionar o tipo de Wiki "Individual"
        WebElement botaoTipoIndividual3 = driver.findElement(By.xpath("//option[@value='individual']"));
        botaoTipoIndividual3.click();
        Thread.sleep(2000);

        //Clicar no campo "Nome da primeira página"					Preencher o campo com ""
        WebElement campoPrimeiraPag3 = driver.findElement(By.xpath("//input[@id='id_firstpagetitle']"));
        campoPrimeiraPag3.click();
        Thread.sleep(2000);
        campoPrimeiraPag3.sendKeys(obj.get("campoNomeWikiI").toString());

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar3 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar3.click();
        Thread.sleep(2000);

    }


@Test
    public void formatoPadrãoHTMLForçarFormato() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


       
        //Clicar no botão ">" de "Formato"
        WebElement bFormato = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
        bFormato.click();
        Thread.sleep(2000);

        
        // Clicar no botão "Formato padrão"						
        WebElement bFormatoPadrao = driver.findElement(By.xpath("//select[@id='id_defaultformat']"));
        bFormatoPadrao.click();
        Thread.sleep(3000);

        // Selecionar o formato "HTML"
        WebElement formatoHTML = driver.findElement(By.xpath("//option[@value='html']"));
        formatoHTML.click();
        Thread.sleep(2000);
       
        
        // Clicar no botão "Forçar formato"					
        WebElement forcarFormato = driver.findElement(By.xpath("//input[@id='id_forceformat']"));
        forcarFormato.click();
        Thread.sleep(2000);
        

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar4 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar4.click();
        Thread.sleep(2000);

    }


@Test
    public void formatoPadrãoHTMLNForçarFormato() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


       
        //Clicar no botão ">" de "Formato"
        WebElement bFormato1 = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
        bFormato1.click();
        Thread.sleep(2000);

        
        // Clicar no botão "Formato padrão"						
        WebElement bFormatoPadrao1 = driver.findElement(By.xpath("//select[@id='id_defaultformat']"));
        bFormatoPadrao1.click();
        Thread.sleep(3000);

        // Selecionar o formato "HTML"
        WebElement formatoHTML1 = driver.findElement(By.xpath("//option[@value='html']"));
        formatoHTML1.click();
        Thread.sleep(2000);
       
        
        // Clicar no botão "Forçar formato"					
        WebElement nForcarFormato = driver.findElement(By.xpath("//input[@id='id_forceformat']"));
        nForcarFormato.click();
        Thread.sleep(2000);
        

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar5 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar5.click();
        Thread.sleep(2000);

    }


@Test
    public void formatoPadrãoCreoleForçarFormato() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


       
        //Clicar no botão ">" de "Formato"
        WebElement bFormato2 = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
        bFormato2.click();
        Thread.sleep(2000);

        
        // Clicar no botão "Formato padrão"						
        WebElement bFormatoPadrao2 = driver.findElement(By.xpath("//select[@id='id_defaultformat']"));
        bFormatoPadrao2.click();
        Thread.sleep(3000);

        // Selecionar o formato "Creole"
        WebElement formatoCreole = driver.findElement(By.xpath("//option[@value='creole']"));
        formatoCreole.click();
        Thread.sleep(2000);
       
        
        // Clicar no botão "Forçar formato"					
        WebElement forcarFormato2 = driver.findElement(By.xpath("//input[@id='id_forceformat']"));
       forcarFormato2.click();
        Thread.sleep(2000);
        

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar23 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar23.click();
        Thread.sleep(2000);

    }

@Test
    public void formatoPadrãoCreoleNForçarFormato() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


       
        //Clicar no botão ">" de "Formato"
        WebElement bFormato3 = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
        bFormato3.click();
        Thread.sleep(2000);

        
        // Clicar no botão "Formato padrão"						
        WebElement bFormatoPadrao3 = driver.findElement(By.xpath("//select[@id='id_defaultformat']"));
        bFormatoPadrao3.click();
        Thread.sleep(3000);

        // Selecionar o formato "Creole"
        WebElement formatoCreole3 = driver.findElement(By.xpath("//option[@value='creole']"));
        formatoCreole3.click();
        Thread.sleep(2000);
       
        
        // Clicar no botão "Forçar formato"					
        WebElement forcarFormato3 = driver.findElement(By.xpath("//input[@id='id_forceformat']"));
       forcarFormato3.click();
        Thread.sleep(2000);
        

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar6 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar6.click();
        Thread.sleep(2000);

    }

@Test
    public void formatoPadrãoNWikiForçarFormato() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


       
        //Clicar no botão ">" de "Formato"
        WebElement bFormato4 = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
        bFormato4.click();
        Thread.sleep(2000);

        
        // Clicar no botão "Formato padrão"						
        WebElement bFormatoPadrao4 = driver.findElement(By.xpath("//select[@id='id_defaultformat']"));
        bFormatoPadrao4.click();
        Thread.sleep(3000);

        // Selecionar o formato "NWiki"
        WebElement formatoNWiki = driver.findElement(By.xpath("//option[@value='nwiki']"));
        formatoNWiki.click();
        Thread.sleep(2000);
       
        
        // Clicar no botão "Forçar formato"					
        WebElement forcarFormato4 = driver.findElement(By.xpath("//input[@id='id_forceformat']"));
       forcarFormato4.click();
        Thread.sleep(2000);
        

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar7 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar7.click();
        Thread.sleep(2000);

    }

    @Test
    public void formatoPadrãoNWikiNForçarFormato() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


       
        //Clicar no botão ">" de "Formato"
        WebElement bFormato5 = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
        bFormato5.click();
        Thread.sleep(2000);

        
        // Clicar no botão "Formato padrão"						
        WebElement bFormatoPadrao5 = driver.findElement(By.xpath("//select[@id='id_defaultformat']"));
        bFormatoPadrao5.click();
        Thread.sleep(3000);

        // Selecionar o formato "NWiki"
        WebElement formatoNWiki5 = driver.findElement(By.xpath("//option[@value='nwiki']"));
        formatoNWiki5.click();
        Thread.sleep(2000);
       
        
        // Clicar no botão "Forçar formato"					
        WebElement forcarFormato5 = driver.findElement(By.xpath("//input[@id='id_forceformat']"));
       forcarFormato5.click();
        Thread.sleep(2000);
        

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar8 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar8.click();
        Thread.sleep(2000);

    }


@Test
public void configuracoesComunsDeModulosMostrar() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


    //Clicar no botão ">" de "Configurações comuns de módulos"
    WebElement bConfigComum = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    bConfigComum.click();
    Thread.sleep(2000);

    // Clicar no botão "Disponibilidade" 	
    WebElement botaoDispM = driver.findElement(By.xpath("//select[@id='id_visible']"));
    botaoDispM.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Mostrar na página do curso"
    WebElement opcaoMostrar = driver.findElement(By.xpath("//option[normalize-space()='Mostrar na página do curso']"));
    opcaoMostrar.click();
    Thread.sleep(3000);

    // Clicar no botão "Número de identificação do módulo"      Preencher com o número de identificação "3123"
    WebElement numeroIdentModulo = driver.findElement(By.xpath("//input[@id='id_cmidnumber']"));
    numeroIdentModulo.click();
    Thread.sleep(3000);
    numeroIdentModulo.sendKeys(obj.get("numeroIdentificacaoW").toString());

    // Clicar no botão "Forçar idioma"
    WebElement nForcarIdioma = driver.findElement(By.xpath("//select[@id='id_lang']"));
    nForcarIdioma.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Não forçar"
    WebElement opcaoNfi1 = driver.findElement(By.xpath("//option[normalize-space()='Não forçar']"));
    opcaoNfi1.click();
    Thread.sleep(3000);

    // Clicar no botão "Agrupamento"
    WebElement agrupamento = driver.findElement(By.xpath("//select[@id='id_lang']"));
    agrupamento.click();
    Thread.sleep(2000);

    //Selecionar a opção "Nenhum"
    WebElement opcaoNfi1A = driver.findElement(By.xpath("//option[normalize-space()='Nenhum']"));
    opcaoNfi1A.click();
    Thread.sleep(3000);


    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar9 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar9.click();
    Thread.sleep(2000);
            
}

@Test
public void configuracoesComunsDeModulosMostrarFIdioma() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


    //Clicar no botão ">" de "Configurações comuns de módulos"
    WebElement bConfigComum1 = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    bConfigComum1.click();
    Thread.sleep(2000);

    // Clicar no botão "Disponibilidade" 	
    WebElement botaoDispM1 = driver.findElement(By.xpath("//select[@id='id_visible']"));
    botaoDispM1.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Mostrar na página do curso"
    WebElement opcaoMostrar1 = driver.findElement(By.xpath("//option[normalize-space()='Mostrar na página do curso']"));
    opcaoMostrar1.click();
    Thread.sleep(3000);

    // Clicar no botão "Número de identificação do módulo"      Preencher com o número de identificação "3123"
    WebElement numeroIdentModulo1 = driver.findElement(By.xpath("//input[@id='id_cmidnumber']"));
    numeroIdentModulo1.click();
    Thread.sleep(3000);
    numeroIdentModulo1.clear();
    numeroIdentModulo1.sendKeys(obj.get("numeroIdentificacaoW").toString());
    Thread.sleep(3000);

    // Clicar no botão "Forçar idioma"
    WebElement forcarIdioma1 = driver.findElement(By.xpath("//select[@id='id_lang']"));
    forcarIdioma1.click();
    Thread.sleep(2000);
    
    //Selecionar o idioma "Português - Brasil"
    WebElement opcaoFI1 = driver.findElement(By.xpath("//option[@value='pt_br']"));
    opcaoFI1.click();
    Thread.sleep(3000);

    // Clicar no botão "Agrupamento"
    WebElement agrupamento1 = driver.findElement(By.xpath("//select[@id='id_lang']"));
    agrupamento1.click();
    Thread.sleep(2000);

    //Selecionar a opção "Nenhum"
    WebElement opcaoNfi1A1 = driver.findElement(By.xpath("//option[normalize-space()='Nenhum']"));
    opcaoNfi1A1.click();
    Thread.sleep(3000);


    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar10 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar10.click();
    Thread.sleep(2000);
            
}


@Test
public void configuracoesComunsDeModulosOcultar() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");



    //Clicar no botão ">" de "Configurações comuns de módulos"
    WebElement bConfigComum2 = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    bConfigComum2.click();
    Thread.sleep(2000);

    // Clicar no botão "Disponibilidade" 	
    WebElement botaoDispM2 = driver.findElement(By.xpath("//select[@id='id_visible']"));
    botaoDispM2.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Ocultar dos estudantes"
    WebElement opcaoOcultar = driver.findElement(By.xpath("//option[normalize-space()='Ocultar dos estudantes']"));
    opcaoOcultar.click();
    Thread.sleep(3000);

    // Clicar no botão "Número de identificação do módulo"      Preencher com o número de identificação "3123"
    WebElement numeroIdentModulo2 = driver.findElement(By.xpath("//input[@id='id_cmidnumber']"));
    numeroIdentModulo2.click();
    Thread.sleep(3000);
    numeroIdentModulo2.clear();
    numeroIdentModulo2.sendKeys(obj.get("numeroIdentificacaoW").toString());
    Thread.sleep(3000);

    // Clicar no botão "Forçar idioma"
    WebElement nForcarIdioma2 = driver.findElement(By.xpath("//select[@id='id_lang']"));
    nForcarIdioma2.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Não forçar"
    WebElement opcaoNfi2 = driver.findElement(By.xpath("//option[normalize-space()='Não forçar']"));
    opcaoNfi2.click();
    Thread.sleep(3000);

    // Clicar no botão "Agrupamento"
    WebElement agrupamento2 = driver.findElement(By.xpath("//select[@id='id_lang']"));
    agrupamento2.click();
    Thread.sleep(2000);

    //Selecionar a opção "Nenhum"
    WebElement opcaoNfi1A2 = driver.findElement(By.xpath("//option[normalize-space()='Nenhum']"));
    opcaoNfi1A2.click();
    Thread.sleep(3000);


    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar11 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar11.click();
    Thread.sleep(2000);
            
}

@Test
public void restringirAcessoConclusaoAtividade() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcesso = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    restringirAcesso.click();
    Thread.sleep(2000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestri = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestri.click();
    Thread.sleep(2000);
    
    //Irá mostrar as opções de "Adicionar restrição"
    WebElement opcaoConclusao = driver.findElement(By.xpath("//button[@id='availability_addrestriction_completion']"));
    opcaoConclusao.click();
    Thread.sleep(6000);

    // Clicar no botão "Escolher"
    WebElement botaoEscolher = driver.findElement(By.xpath("//select[@title='Atividade ou recurso']"));
    botaoEscolher.click();
    Thread.sleep(3000);
    
    //Selecionar a "Level 3"
    WebElement opcaoEscolher3 = driver.findElement(By.xpath("//option[@value='1444']"));
    opcaoEscolher3.click();
    Thread.sleep(3000);

    // Clicar no botão "Requer estado concluido"
    WebElement botaoRequer = driver.findElement(By.xpath("//select[@title='Requer estado concluído']"));
    botaoRequer.click();
    Thread.sleep(2000);

    //Selecionar "Deve ser marcada como concluida"
    WebElement opcaoDMC = driver.findElement(By.xpath("//option[normalize-space()='deve ser marcada como concluída']"));
    opcaoDMC.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar12 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar12.click();
    Thread.sleep(2000);

}

@Test
public void restringirAcessoDataDe() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");

    
    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcesso1 = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    restringirAcesso1.click();
    Thread.sleep(3000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestri1 = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestri1.click();
    Thread.sleep(3000);
    
    //Clicar no botão "Data"
    WebElement opcaoData3 = driver.findElement(By.xpath("//button[@id='availability_addrestriction_date']"));
    opcaoData3.click();
    Thread.sleep(5000);

    //Clicar no botão "Data"
    WebElement opcaoData31 = driver.findElement(By.xpath("//select[@name='direction']"));
    opcaoData31.click();
    Thread.sleep(5000);

    // Selecionar a opção "De"
    WebElement deDia = driver.findElement(By.xpath("//option[@value='>=']"));
    deDia.click();
    Thread.sleep(3000);

    // Clicar no botão de "dia 3" 
    WebElement dia3 = driver.findElement(By.xpath("(//select[@name='x[day]'])[1]"));
    dia3.click();
    Thread.sleep(3000);
    
    //Selecionar o dia  7
    WebElement opcao7 = driver.findElement(By.xpath("//option[@value='7']"));
    opcao7.click();
    Thread.sleep(3000);

    // Clicar no botão de "mês" 
    WebElement mes12 = driver.findElement(By.xpath("(//select[@name='x[month]'])[1]"));
    mes12.click();
    Thread.sleep(5000);
    
    //Selecionar o mês 12
    WebElement opcao12 = driver.findElement(By.xpath("//option[normalize-space()='dezembro']"));
    opcao12.click();
    Thread.sleep(5000);

    // Clicar no botão de "ano" 
    WebElement ano22 = driver.findElement(By.xpath("(//select[@name='x[year]'])[1]"));
    ano22.click();
    Thread.sleep(5000);
    
    //Selecionar o ano 2022
    WebElement opcao2022 = driver.findElement(By.xpath("//option[@value='2022']"));
    opcao2022.click();
    Thread.sleep(5000);

    // Clicar no botão de "horas" 
    WebElement bhoras0 = driver.findElement(By.xpath("(//select[@name='x[hour]'])[1]"));
    bhoras0.click();
    Thread.sleep(5000);
    
    //Selecionar a hora 00
    WebElement opcaob0 = driver.findElement(By.xpath("//option[@value='0'][normalize-space()='00']"));
    opcaob0.click();
    Thread.sleep(5000);

    // Clicar no botão de "minutos" 
    WebElement bminutos0 = driver.findElement(By.xpath("(//select[@name='x[minute]'])[1]"));
    bminutos0.click();
    Thread.sleep(5000);
    
    //Selecionar o minuto 00	
    WebElement opcaob00 = driver.findElement(By.xpath("//option[@value='0'][normalize-space()='00']"));
    opcaob00.click();
    Thread.sleep(5000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar13 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar13.click();
    Thread.sleep(3000);

}

@Test
public void restringirAcessoDataAte() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcesso2 = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    restringirAcesso2.click();
    Thread.sleep(2000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestri2 = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestri2.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Data"
    WebElement opcaoData3 = driver.findElement(By.xpath("//button[@id='availability_addrestriction_date']"));
    opcaoData3.click();
    Thread.sleep(3000);

    // Clicar no botão "De"
    WebElement botaoAdRestriAte = driver.findElement(By.xpath("//select[@data-initial-value='>=']"));
    botaoAdRestriAte.click();
    Thread.sleep(2000);
    

    //Selecionar a opão "Até"
    WebElement opcaoAte = driver.findElement(By.xpath("//select[@data-initial-value='>=']//option[@value='<'][normalize-space()='até']"));
    opcaoAte.click();
    Thread.sleep(3000);

    // Clicar no botão de "dia" 
    WebElement bdia3 = driver.findElement(By.xpath("(//select[@name='x[day]'])[2]"));
    bdia3.click();
    Thread.sleep(3000);
    
    //Selecionar o dia 3
    WebElement opcaoAte3 = driver.findElement(By.xpath("(//option[contains(@value,'3')][normalize-space()='3'])[2]"));
    opcaoAte3.click();
    Thread.sleep(3000);

    // Clicar no botão de "mês" 
    WebElement bmes1 = driver.findElement(By.xpath("(//select[@name='x[month]'])[2]"));
    bmes1.click();
    Thread.sleep(3000);
    
    //Selecionar o mês 1
    WebElement opcaoAte1 = driver.findElement(By.xpath("(//option[contains(@value,'1')][normalize-space()='janeiro'])[2]"));
    opcaoAte1.click();
    Thread.sleep(3000);

    // Clicar no botão de "ano" 
    WebElement ano23 = driver.findElement(By.xpath("(//select[@name='x[year]'])[2]"));
    ano23.click();
    Thread.sleep(3000);
    
    //Selecionar o ano 2023
    WebElement opcaod2023 = driver.findElement(By.xpath("(//option[contains(@value,'2023')][normalize-space()='2023'])[2]"));
    opcaod2023.click();
    Thread.sleep(3000);

    // Clicar no botão de "horas" 
    WebElement bhoras = driver.findElement(By.xpath("(//select[@name='x[hour]'])[2]"));
    bhoras.click();
    Thread.sleep(3000);
    
    //Selecionar a hora 03
    WebElement opcaob03 = driver.findElement(By.xpath("(//option[contains(@value,'3')][normalize-space()='03'])[2]"));
    opcaob03.click();
    Thread.sleep(3000);

    // Clicar no botão de "minutos" 
    WebElement bminutos = driver.findElement(By.xpath("(//select[@name='x[minute]'])[2]"));
    bminutos.click();
    Thread.sleep(3000);

    //Selecionar o minuto 55
    WebElement opcaob59 = driver.findElement(By.xpath("(//option[contains(@value,'55')][normalize-space()='55'])[2]"));
    opcaob59.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar14 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar14.click();
    Thread.sleep(2000);

}


@Test
public void restringirAcessoNota() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcesso3 = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    restringirAcesso3.click();
    Thread.sleep(2000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestrin = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestrin.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Nota"
    WebElement opcaoNota = driver.findElement(By.xpath("//button[@id='availability_addrestriction_grade']"));
    opcaoNota.click();
    Thread.sleep(3000);

    // Clicar no botão "Escolher"
    WebElement bescolher = driver.findElement(By.xpath("(//select[@name='id'])[1]"));
    bescolher.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Entrega Final - Escrita de Algoritmo"
    WebElement opcaoLevel3 = driver.findElement(By.xpath("//option[@value='354']"));
    opcaoLevel3.click();
    Thread.sleep(3000);

    // Clicar no botão "Dever ser >"
    WebElement botaoDeve = driver.findElement(By.xpath("(//input[@name='min'])[1]"));
    botaoDeve.click();
    Thread.sleep(2000);

    // Clicar no campo "Dever ser >"    Preencher com a nota 6
    WebElement campDeves = driver.findElement(By.xpath("//input[@title='Porcentagem mínima da nota (incluso)']"));
    campDeves.click();
    Thread.sleep(2000);
    campDeves.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Deve ser <"
    WebElement botaoDeveS = driver.findElement(By.xpath("//input[@name='max']"));
    botaoDeveS.click();
    Thread.sleep(2000);

    // Clicar no campo "Deve ser <"	Preencher com a nota 10
    WebElement campoDeveSer = driver.findElement(By.xpath("//input[@title='Porcentagem máxima da nota (excluso)']"));
    campoDeveSer.click();
    Thread.sleep(2000);
    campoDeveSer.sendKeys(obj.get("numeroMaximo").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar15 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar15.click();
    Thread.sleep(2000);

}

@Test
public void restringirAcessoGrupo() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");

    
    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcessg = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    restringirAcessg.click();
    Thread.sleep(2000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestrig = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestrig.click();
    Thread.sleep(2000);
    
    WebElement opcaoGrupo = driver.findElement(By.xpath("//button[@id='availability_addrestriction_group']"));
    opcaoGrupo.click();
    Thread.sleep(3000);

    // Clicar no botão "Escolher"
    WebElement botaoAdRestriescolher = driver.findElement(By.xpath("(//select[@data-initial-value='choose'])[1]"));
    botaoAdRestriescolher.click();
    Thread.sleep(2000);
    
    //Selecionar "Grupo do teste de automação"
    WebElement opcaoTesteAutomacao = driver.findElement(By.xpath("//option[@value='68']"));
    opcaoTesteAutomacao.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar16 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar16.click();
    Thread.sleep(2000);

}


@Test
public void restringirAcessoPerfilUsuario() throws InterruptedException, IOException, ParseException{

                
    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcessN = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    restringirAcessN.click();
    Thread.sleep(2000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestrin = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestrin.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Perfil do usuário"
    WebElement opcaoPerfilU = driver.findElement(By.xpath("//button[@id='availability_addrestriction_profile']"));
    opcaoPerfilU.click();
    Thread.sleep(3000);

    // Clicar no botão "Escolher"
    WebElement bescolherNumId = driver.findElement(By.xpath("(//select[@name='field'])[1]"));
    bescolherNumId.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Número de identificação"
    WebElement opcaoNumId8 = driver.findElement(By.xpath("(//option[@value='sf_idnumber'])[1]"));
    opcaoNumId8.click();
    Thread.sleep(3000);

    //  Clicar no botão "Método de comparação"
    WebElement botaoMetodoC = driver.findElement(By.xpath("//select[@title='Método de comparação']"));
    botaoMetodoC.click();
    Thread.sleep(2000);

    //Selecionar a opção "é igual a"
    WebElement opcaoEigual = driver.findElement(By.xpath("(//option[@value='isequalto'])[1]"));
    opcaoEigual.click();
    Thread.sleep(3000);

    // Clicar no campo "Valor a comparar"       Prencher com "Sua Matrícula"
    WebElement campoValorCopm = driver.findElement(By.xpath("(//input[@title='Valor para comparar contra'])[1]"));
    campoValorCopm.click();
    Thread.sleep(2000);
    campoValorCopm.sendKeys(obj.get("suaMatricula").toString());
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar17 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar17.click();
    Thread.sleep(2000);
        
}

@Test
public void naoRestringirAcesso() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");

    
    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcesso5 = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    restringirAcesso5.click();
    Thread.sleep(2000);

    // Clicar no botão "X" da restrição selecionada
    WebElement excluirRestricao = driver.findElement(By.xpath("(//img[@alt='Excluir'])[4]"));
    excluirRestricao.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar18 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar18.click();
    Thread.sleep(2000);

}



@Test
public void conclusaoAtividadeNaoIndicar() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");

    //Clicar no botão ">" de "Conclusão de atividade"
    WebElement conclusaoAtividad = driver.findElement(By.xpath("//a[@id='collapseElement-4']"));
    conclusaoAtividad.click();
    Thread.sleep(2000);

    // Clicar no botão "Acompanhamento de conclusão"
    WebElement botaoAcompanhamentoC = driver.findElement(By.xpath("//select[@id='id_completion']"));
    botaoAcompanhamentoC.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Não indicar a conclusão de atividade"
    WebElement opcaoNaoIndicar = driver.findElement(By.xpath("//option[normalize-space()='Não indicar a conclusão de atividade']"));
    opcaoNaoIndicar.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar19 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar19.click();
    Thread.sleep(2000);

}


@Test
public void conclusaoAtividadeEstudantes() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");

    //Clicar no botão ">" de "Conclusão de atividade"
    WebElement conclusaoAtividad = driver.findElement(By.xpath("//a[@id='collapseElement-4']"));
    conclusaoAtividad.click();
    Thread.sleep(2000);

    // Clicar no botão "Acompanhamento de conclusão"
    WebElement botaoAcompanhamentoCE = driver.findElement(By.xpath("//select[@id='id_completion']"));
    botaoAcompanhamentoCE.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Os estudantes podem marcar manualmente a atividade como concluida"
    WebElement opcaoEstudantes1 = driver.findElement(By.xpath("//option[contains(text(),'Os estudantes podem marcar manualmente a atividade')]"));
    opcaoEstudantes1.click();
    Thread.sleep(3000);

    // Clicar no botão "Habilitar"
    WebElement bhabilitarE = driver.findElement(By.xpath("//input[@id='id_completionexpected_enabled']"));
    bhabilitarE.click();
    Thread.sleep(2000);
    
    // Clicar no botão de "dia" 
    WebElement bdiaE = driver.findElement(By.xpath("//select[@id='id_completionexpected_day']"));
    bdiaE.click();
    Thread.sleep(3000);
    
    //Selecionar o dia 3
    WebElement opcaodia03 = driver.findElement(By.xpath("//option[@value='3']"));
    opcaodia03.click();
    Thread.sleep(3000);

    // Clicar no botão de "mês" 
    WebElement bmesE = driver.findElement(By.xpath("//select[@id='id_completionexpected_month']"));
    bmesE.click();
    Thread.sleep(3000);
    
    //Selecionar o mês 1
    WebElement opcaomes01 = driver.findElement(By.xpath("//option[normalize-space()='janeiro']"));
    opcaomes01.click();
    Thread.sleep(3000);

    // Clicar no botão de "ano" 
    WebElement banoE = driver.findElement(By.xpath("//select[@id='id_completionexpected_year']"));
    banoE.click();
    Thread.sleep(3000);
    
    //Selecionar o ano 2023
    WebElement opcaoanoE2023 = driver.findElement(By.xpath("//option[@value='2023']"));
    opcaoanoE2023.click();
    Thread.sleep(3000);

    // Clicar no botão de "horas" 
    WebElement bhorasE = driver.findElement(By.xpath("//select[@id='id_completionexpected_hour']"));
    bhorasE.click();
    Thread.sleep(3000);
    
    //Selecionar a hora 03
    WebElement opcaohoraE03 = driver.findElement(By.xpath("//option[@value='3'][normalize-space()='03']"));
    opcaohoraE03.click();
    Thread.sleep(3000);

    // Clicar no botão de "minutos" 
    WebElement bminutos59 = driver.findElement(By.xpath("//select[@id='id_completionexpected_minute']"));
    bminutos59.click();
    Thread.sleep(3000);
    
    //Selecionar o minuto 59
    WebElement opcaominut59 = driver.findElement(By.xpath("//option[@value='59']"));
    opcaominut59.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar20 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar20.click();
    Thread.sleep(2000);

}


@Test
public void conclusaoAtividadeSatisfeitas() throws InterruptedException, IOException{


    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");     


    //Clicar no botão ">" de "Conclusão de atividade"
    WebElement conclusaoAtividadS = driver.findElement(By.xpath("//a[@id='collapseElement-4']"));
    conclusaoAtividadS.click();
    Thread.sleep(2000);

    // Clicar no botão "Acompanhamento de conclusão"
    WebElement botaoAcompanhamentoCS = driver.findElement(By.xpath("//select[@id='id_completion']"));
    botaoAcompanhamentoCS.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Mostrar atividade como concluída quando as condições forem satisfeitas"
    WebElement opcaocompS1 = driver.findElement(By.xpath("//option[contains(text(),'Mostrar atividade como concluída quando as condiçõ')]"));
    opcaocompS1.click();
    Thread.sleep(3000);

    // Clicar no botão "Requer visualização"	
    WebElement botaoRequerVisu = driver.findElement(By.xpath("//input[@id='id_completionview']"));
    botaoRequerVisu.click();
    Thread.sleep(2000);

    // Clicar no botão "Habilitar"
    WebElement bhabilitarS = driver.findElement(By.xpath("//input[@id='id_completionexpected_enabled']"));
    bhabilitarS.click();
    Thread.sleep(3000);
    bhabilitarS.click();
    Thread.sleep(3000);

    // Clicar no botão de "dia" 
    WebElement bdiaS = driver.findElement(By.xpath("//select[@id='id_completionexpected_day']"));
    bdiaS.click();
    Thread.sleep(3000);
    
    //Selecionar o dia 3
    WebElement opcaodiaS3 = driver.findElement(By.xpath("//option[@value='3']"));
    opcaodiaS3.click();
    Thread.sleep(3000);

    // Clicar no botão de "mês" 
    WebElement bmesS = driver.findElement(By.xpath("//select[@id='id_completionexpected_month']"));
    bmesS.click();
    Thread.sleep(3000);
    
    //Selecionar o mês 1
    WebElement opcaomesS1 = driver.findElement(By.xpath("//option[normalize-space()='janeiro']"));
    opcaomesS1.click();
    Thread.sleep(3000);

    // Clicar no botão de "ano" 
    WebElement banoS = driver.findElement(By.xpath("//select[@id='id_completionexpected_year']"));
    banoS.click();
    Thread.sleep(3000);
    
    //Selecionar o ano 2023
    WebElement opcaoanoS2023 = driver.findElement(By.xpath("//option[@value='2023']"));
    opcaoanoS2023.click();
    Thread.sleep(3000);

    // Clicar no botão de "horas" 
    WebElement bhorasS = driver.findElement(By.xpath("//select[@id='id_completionexpected_hour']"));
    bhorasS.click();
    Thread.sleep(3000);
    
    //Selecionar a hora 03
    WebElement opcaohoraS0 = driver.findElement(By.xpath("//option[@value='3'][normalize-space()='03']"));
    opcaohoraS0.click();
    Thread.sleep(3000);

    // Clicar no botão de "minutos" 
    WebElement bminutosS0 = driver.findElement(By.xpath("//select[@id='id_completionexpected_minute']"));
    bminutosS0.click();
    Thread.sleep(3000);
    
    //Selecionar o minuto 55	
    WebElement opcaominutS59 = driver.findElement(By.xpath("//option[@value='55']"));
    opcaominutS59.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar21 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar21.click();
    Thread.sleep(2000);

}

    @Test
    public void tags() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");

        //Clicar no botão ">" de "Tags"
        WebElement botaotag = driver.findElement(By.xpath("//a[@id='collapseElement-5']"));
        botaotag.click();
        Thread.sleep(2000);

        // Clicar em no campo "Inserir tags"    Preencher com a tag "Games"
        WebElement campoTag = driver.findElement(By.xpath("(//input[@placeholder='Inserir tags...'])[1]"));
        campoTag.click();
        Thread.sleep(2000);
        campoTag.sendKeys(obj.get("tagsW").toString());

        WebElement opcaoTag = driver.findElement(By.xpath("(//input[@placeholder='Inserir tags...'])[1]"));
        opcaoTag.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar24 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar24.click();
        Thread.sleep(2000);

    }


    @Test
    public void compentencias() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3926&return=0&sr=0");


        //Clicar no botão ">" de "Competências"
        WebElement botaoCompetencia = driver.findElement(By.xpath("//a[@id='collapseElement-6']"));
        botaoCompetencia.click();
        Thread.sleep(2000);

        // Clicar no botão "Competências do curso"      Preencher o "Level 3"
        WebElement campoCompetencia = driver.findElement(By.xpath("(//input[@placeholder='Buscar'])[1]"));
        campoCompetencia.click();
        Thread.sleep(2000);
        campoCompetencia.sendKeys(obj.get("campoNomeCompetencia").toString());
        campoCompetencia.sendKeys(Keys.ENTER);

        // Clicar no botão "Após conclusão da atividade:"
        WebElement botaoAposCon = driver.findElement(By.xpath("(//select[@name='competency_rule'])[1]"));
        botaoAposCon.click();
        Thread.sleep(2000);

        //Selecionar "Anexar evidência"
        WebElement opcaoAnexarE = driver.findElement(By.xpath("(//option[normalize-space()='Anexar evidência'])[1]"));
        opcaoAnexarE.click();
        Thread.sleep(3000);

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar25 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar25.click();
        Thread.sleep(2000);

    }

@Test
public void excluirWiki() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8#section-1");

    //Clicar no botão "Editar" de Wiki		
    WebElement editarWiki = driver.findElement(By.xpath("//a[@id='action-menu-toggle-8']//i[@title='Editar']"));
    editarWiki.click();
    Thread.sleep(3000);

    // Clicar na opção "Exluir"
    WebElement opcaoExcluir = driver.findElement(By.xpath("(//span[contains(@class,'menu-action-text')][normalize-space()='Excluir'])[6]"));
    opcaoExcluir.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Sim"
    WebElement opcaoSim = driver.findElement(By.xpath("//button[normalize-space()='Sim']"));
    opcaoSim.click();
    Thread.sleep(3000);

}

@Test
public void editarWiki() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8#section-1");

    //Clicar no botão "Editar" de Wiki		
    WebElement editarWiki = driver.findElement(By.xpath("//a[@id='action-menu-toggle-6']//i[@title='Editar']"));
    editarWiki.click();
    Thread.sleep(3000);

    // Clicar na opção "Editar configurações"
    WebElement opcaoEditarC = driver.findElement(By.xpath("(//span[@class='menu-action-text'][normalize-space()='Editar configurações'])[4]"));
    opcaoEditarC.click();
    Thread.sleep(3000);
    
    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar26 = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar26.click();
    Thread.sleep(3000);

}

        
}