import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.json.simple.*;
import org.json.simple.parser.*;


public class TestsGlossario{

    private WebDriver driver = new ChromeDriver();


    @Before
    public void setUp() throws IOException, InterruptedException, ParseException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tales\\OneDrive\\Documentos\\RP-II\\marco02-grupo03\\Marco2\\Chromedriver\\chromedriver.exe");
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8#section-0");
        driver.manage().window().maximize();

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));
        
        

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

    // @Test 
    // public void excluirDPS() throws FileNotFoundException, IOException, ParseException, InterruptedException{
    //     System.setProperty("webdriver.chrome.driver", "C:\\Users\\tales\\OneDrive\\Documentos\\RP-II\\marco02-grupo03\\Marco2\\Chromedriver\\chromedriver.exe");
    //     driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/forum/view.php?id=1784");
    //     driver.manage().window().maximize();

    //     JSONObject obj = new JSONObject();
    //     JSONParser parser = new JSONParser();
    //     obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));
        
        

    //     // Preencher o campo "Identificação do Usuário" com seu login
    //     WebElement identificacaoUsuario = driver.findElement(By.id("username"));
    //     identificacaoUsuario.click();
    //     identificacaoUsuario.sendKeys(obj.get("matricula").toString());

    //     //Preencher o campo "Senha" com sua senha
    //     WebElement senhaUsuario = driver.findElement(By.id("password"));
    //     senhaUsuario.click();
    //     senhaUsuario.sendKeys(obj.get("matricula").toString());
        
    //     // Clicar em acessar
    //     WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
    //     acessarBotao.click();
    //     Thread.sleep(2000);

    //     // Clicar no botão "Modo de edição"
    //     WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    //     modoEdicao.click();
    //     Thread.sleep(4000);
    // }

    @Test
    public void criarTopicoGlossario() throws InterruptedException, IOException, ParseException{
                

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

        // Clicar no botão "Adicionar tópico"
        WebElement adicionaTopico = driver.findElement(By.xpath("//div[@id='coursecontentcollapse0']//a[@class='add-sections'][normalize-space()='Adicionar tópico']"));
        adicionaTopico.click();
        Thread.sleep(2000);

        // Clicar no botão "Editar"
        WebElement botaoEditar = driver.findElement(By.xpath("//a[@id='action-menu-toggle-0']//i[@title='Editar']"));
        botaoEditar.click();
        Thread.sleep(2000);

        // Selecionar a opção "Editar tópico"
        WebElement editarTopico = driver.findElement(By.xpath("//div[@id='action-menu-0-menu']//span[@id='actionmenuaction-1']"));
        editarTopico.click();

        // Clicar no botão "Personalizado"
        WebElement botaoPersonalizado = driver.findElement(By.xpath("//input[@id='id_name_customize']"));
        botaoPersonalizado.click();
        Thread.sleep(2000);

        // Clicar no campo "Nome do tópico"
        WebElement nomeTopico = driver.findElement(By.xpath("//input[@id='id_name_value']"));
        nomeTopico.click();
        Thread.sleep(2000);
        nomeTopico.sendKeys(obj.get("campoNome").toString());

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton']"));
        salvarVoltar.click();
        Thread.sleep(2000);
                    
    }
    

    @Test
    public void criarGlossarioPrincipal() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));


        // Clicar no botão "Adicionar uma atividade ou recurso"	do tópico Glossário
        WebElement adicionarRecursoG = driver.findElement(By.xpath("//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso']"));
        adicionarRecursoG.click();
        Thread.sleep(3000);
        //    if(adicionarRecurso.isDisplayed()){
        //        adicionarRecurso.click();
        //    }

        // Clicar no recurso "Glossário"
        WebElement recursoGlossario = driver.findElement(By.xpath("//div[@id='all-6']//a[@title='Adicionar um novo Glossário']"));
        recursoGlossario.click();
        Thread.sleep(3000);

        // Clicar no campo "Nome"							Preencher o campo com "Lista de definições" 
        WebElement nomeGlossario = driver.findElement(By.xpath("//input[@id='id_name']"));
        nomeGlossario.click();
        Thread.sleep(2000);
        nomeGlossario.sendKeys(obj.get("campoNomeG").toString());

        
        // Clicar no campo "Descrição"							Preencher o campo com "um glossário ..."
        WebElement campoDescricao = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
        campoDescricao.click();
        Thread.sleep(2000);
        campoDescricao.sendKeys(obj.get("campoDescricao").toString());

        // Clicar no botão "Exibir descrição na página do curso"
        WebElement botaoExibirDescricao = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
        botaoExibirDescricao.click();
        Thread.sleep(2000);

        // Clicar no botão "Tipo de glossário"
        WebElement botaoTipoGlossario = driver.findElement(By.xpath("//input[@id='id_name_customize']"));
        botaoTipoGlossario.click();
        Thread.sleep(2000);

        // Selecionar o tipo de glossário "Principal"
        WebElement botaoTipoPrincipal = driver.findElement(By.xpath("//input[@id='id_name_customize']"));
        botaoTipoPrincipal.click();
        Thread.sleep(2000);

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar.click();
        Thread.sleep(2000);

    }

    @Test
    public void criarGlossarioPrincipalNExibirDescricao() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));


        // Clicar no botão "Adicionar uma atividade ou recurso"	do tópico Glossário
        WebElement adicionarRecurso = driver.findElement(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[1]"));
        adicionarRecurso.click();
        // if(adicionarRecurso.isDisplayed()){
        //     adicionarRecurso.click();
        // }
        Thread.sleep(2000);

        // Clicar no recurso "Glossário"
        WebElement recursoGlossario = driver.findElement(By.xpath("//a[@title='Adicionar um novo Glossário']"));
        recursoGlossario.click();
        
        // Clicar no campo "Nome"							Preencher o campo com "Lista de definições" 
        WebElement nomeGlossario = driver.findElement(By.xpath("//input[@id='id_name']"));
        nomeGlossario.click();
        Thread.sleep(2000);
        nomeGlossario.sendKeys(obj.get("campoNomeG").toString());

        // Clicar no botão "Tipo de glossário"
        WebElement botaoTipoGlossario = driver.findElement(By.xpath("//input[@id='id_name_customize']"));
        botaoTipoGlossario.click();
        Thread.sleep(2000);

        // Selecionar o tipo de glossário "Principal"
        WebElement botaoTipoPrincipal = driver.findElement(By.xpath("//input[@id='id_name_customize']"));
        botaoTipoPrincipal.click();
        Thread.sleep(2000);

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar.click();
        Thread.sleep(2000);

    }

    @Test
    public void criarGlossarioSecundario() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));
            

        // Clicar no botão "Adicionar uma atividade ou recurso"	do tópico Glossário
        WebElement adicionarRecurso = driver.findElement(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[2]"));
        adicionarRecurso.click();
        // if(adicionarRecurso.isDisplayed()){
        //     adicionarRecurso.click();
        // }
        
        Thread.sleep(2000);

        // Clicar no recurso "Glossário"
        WebElement recursoGlossario = driver.findElement(By.xpath("//a[@title='Adicionar um novo Glossário']"));
        recursoGlossario.click();
        
        // Clicar no campo "Nome"							Preencher o campo com "Lista de definições" 
        WebElement nomeGlossario = driver.findElement(By.xpath("//input[@id='id_name']"));
        nomeGlossario.click();
        Thread.sleep(2000);
        nomeGlossario.sendKeys(obj.get("campoNomeG").toString());

        // Clicar no campo "Descrição"							Preencher o campo com "um glossário ..."
        WebElement campoDescricao = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
        campoDescricao.click();
        Thread.sleep(2000);
        campoDescricao.sendKeys(obj.get("campoDescricao").toString());

        // Clicar no botão "Exibir descrição na página do curso"
        WebElement botaoExibirDescricao = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
        botaoExibirDescricao.click();
        Thread.sleep(2000);

        // // Clicar no botão "Tipo de glossário"
        // WebElement botaoTipoGlossario = driver.findElement(By.xpath("//input[@id='id_name_customize']"));
        // botaoTipoGlossario.click();
        // Thread.sleep(2000);

        // // Selecionar o tipo de glossário "Secundário"
        // WebElement botaoTipoPrincipal = driver.findElement(By.xpath("//input[@id='id_name_customize']"));
        // botaoTipoPrincipal.click();
        // Thread.sleep(2000);

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar.click();
        Thread.sleep(2000);

    }

@Test
public void criarGlossarioSecundarioNExibirDescricao() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));
        

    // Clicar no botão "Adicionar uma atividade ou recurso"	do tópico Glossário
    WebElement adicionarRecurso = driver.findElement(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[2]"));
    adicionarRecurso.click();
    // if(adicionarRecurso.isDisplayed()){
    //     adicionarRecurso.click();
    // }
    
    Thread.sleep(2000);

    // Clicar no recurso "Glossário"
    WebElement recursoGlossario = driver.findElement(By.xpath("//a[@title='Adicionar um novo Glossário']"));
    recursoGlossario.click();
    
    // Clicar no campo "Nome"							Preencher o campo com "Lista de definições" 
    WebElement nomeGlossario = driver.findElement(By.xpath("//input[@id='id_name']"));
    nomeGlossario.click();
    Thread.sleep(2000);
    nomeGlossario.sendKeys(obj.get("campoNomeG").toString());

    // // Clicar no botão "Tipo de glossário"
    // WebElement botaoTipoGlossario = driver.findElement(By.xpath("//input[@id='id_name_customize']"));
    // botaoTipoGlossario.click();
    // Thread.sleep(2000);

    // // Selecionar o tipo de glossário "Secundário"
    // WebElement botaoTipoPrincipal = driver.findElement(By.xpath("//input[@id='id_name_customize']"));
    // botaoTipoPrincipal.click();
    // Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void itensSomenteAprovacaoImediataPermitida() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "itens"
    WebElement botaoItens = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
    botaoItens.click();
    Thread.sleep(2000);

    // Clicar no botão "Aprovação imediata de novos itens"			
    WebElement botaoAprovacaoItens = driver.findElement(By.xpath("//select[@id='id_defaultapproval']"));
    botaoAprovacaoItens.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim = driver.findElement(By.xpath("//select[@id='id_defaultapproval']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim.click();
    Thread.sleep(2000);

    // Clicar no botão "Sempre permitir edição"				
    WebElement botaoSemprePermitir = driver.findElement(By.xpath("//select[@id='id_editalways']"));
    botaoSemprePermitir.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao = driver.findElement(By.xpath("//select[@name='editalways']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Permitir itens duplicados"				
    WebElement botaoPermitirDuplicados = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']"));
    botaoPermitirDuplicados.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao1 = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao1.click();
    Thread.sleep(2000);

    // Clicar no botão "Permitir comentários"				
    WebElement botaoPermitirComentarios = driver.findElement(By.xpath("//select[@id='id_allowcomments']"));
    botaoPermitirComentarios.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Não"
    WebElement opcaoNao2 = driver.findElement(By.xpath("//select[@id='id_allowcomments']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao2.click();
    Thread.sleep(2000);

    //Clicar no botão "Fazer o link automático dos itens"			
    WebElement botaoFazerLink = driver.findElement(By.xpath("//select[@id='id_usedynalink']"));
    botaoFazerLink.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao3 = driver.findElement(By.xpath("//select[@id='id_usedynalink']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao3.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test                                                   
public void itensSomentePermitirEdicaoPermitida() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");
            
    //Clicar no botão ">" de "itens"
    WebElement botaoItens = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
    botaoItens.click();
    Thread.sleep(2000);

    // Clicar no botão "Aprovação imediata de novos itens"			
    WebElement botaoAprovacaoItens = driver.findElement(By.xpath("//select[@id='id_defaultapproval']"));
    botaoAprovacaoItens.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao4 = driver.findElement(By.xpath("//select[@id='id_defaultapproval']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao4.click();
    Thread.sleep(2000);

    // Clicar no botão "Sempre permitir edição"				
    WebElement botaoSemprePermitir = driver.findElement(By.xpath("//select[@id='id_editalways']"));
    botaoSemprePermitir.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim1 = driver.findElement(By.xpath("//select[@name='editalways']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim1.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Permitir itens duplicados"				
    WebElement botaoPermitirDuplicados = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']"));
    botaoPermitirDuplicados.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao5 = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao5.click();
    Thread.sleep(2000);

    // Clicar no botão "Permitir comentários"				
    WebElement botaoPermitirComentarios = driver.findElement(By.xpath("//select[@id='id_allowcomments']"));
    botaoPermitirComentarios.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Não"
    WebElement opcaoNao6 = driver.findElement(By.xpath("//select[@id='id_allowcomments']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao6.click();
    Thread.sleep(2000);

    //Clicar no botão "Fazer o link automático dos itens"			
    WebElement botaoFazerLink = driver.findElement(By.xpath("//select[@id='id_usedynalink']"));
    botaoFazerLink.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao7 = driver.findElement(By.xpath("//select[@id='id_usedynalink']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao7.click();
    Thread.sleep(2000);
    
    // // Clicar no botão "Salvar e voltar"
    // WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    // salvarVoltar.click();
    // Thread.sleep(2000);

}


@Test
public void itensSomentePermitirDuplicados() throws InterruptedException, IOException{  

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "itens"
    WebElement botaoItens = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
    botaoItens.click();
    Thread.sleep(2000);

    // Clicar no botão "Aprovação imediata de novos itens"			
    WebElement botaoAprovacaoItens = driver.findElement(By.xpath("//select[@id='id_defaultapproval']"));
    botaoAprovacaoItens.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao8 = driver.findElement(By.xpath("//select[@id='id_defaultapproval']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao8.click();
    Thread.sleep(2000);

    // Clicar no botão "Sempre permitir edição"				
    WebElement botaoSemprePermitir = driver.findElement(By.xpath("//select[@id='id_editalways']"));
    botaoSemprePermitir.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao9 = driver.findElement(By.xpath("//select[@id='id_editalways']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao9.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Permitir itens duplicados"				
    WebElement botaoPermitirDuplicados = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']"));
    botaoPermitirDuplicados.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim2 = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim2.click();
    Thread.sleep(2000);

    // Clicar no botão "Permitir comentários"				
    WebElement botaoPermitirComentarios = driver.findElement(By.xpath("//select[@id='id_allowcomments']"));
    botaoPermitirComentarios.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Não"
    WebElement opcaoNao10 = driver.findElement(By.xpath("//select[@id='id_allowcomments']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao10.click();
    Thread.sleep(2000);

    //Clicar no botão "Fazer o link automático dos itens"			
    WebElement botaoFazerLink = driver.findElement(By.xpath("//select[@id='id_usedynalink']"));
    botaoFazerLink.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao11 = driver.findElement(By.xpath("//select[@id='id_usedynalink']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao11.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
    public void itensSomentePermitirComentarios() throws InterruptedException, IOException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

        // Clicar no botão ">" de "itens"
        WebElement botaoItens = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
        botaoItens.click();
        Thread.sleep(2000);

        // Clicar no botão "Aprovação imediata de novos itens"
        WebElement botaoAprovacaoItens = driver.findElement(By.xpath("//select[@id='id_defaultapproval']"));
        botaoAprovacaoItens.click();
        Thread.sleep(2000);

        // Selecionar a opção "Não"
        WebElement opcaoNao13 = driver.findElement(By.xpath("//select[@id='id_defaultapproval']//option[@value='0'][normalize-space()='Não']"));
        opcaoNao13.click();
        Thread.sleep(2000);

        // Clicar no botão "Sempre permitir edição"
        WebElement botaoSemprePermitir = driver.findElement(By.xpath("//select[@id='id_editalways']"));
        botaoSemprePermitir.click();
        Thread.sleep(2000);

        // Selecionar a opção "Não"
        WebElement opcaoNao14 = driver.findElement(By.xpath("//select[@id='id_editalways']//option[@value='0'][normalize-space()='Não']"));
        opcaoNao14.click();
        Thread.sleep(2000);

        // Clicar no botão "Permitir itens duplicados"
        WebElement botaoPermitirDuplicados = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']"));
        botaoPermitirDuplicados.click();
        Thread.sleep(2000);

        // Selecionar a opção "Não"
        WebElement opcaoNao15 = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']//option[@value='0'][normalize-space()='Não']"));
        opcaoNao15.click();
        Thread.sleep(2000);

        // Clicar no botão "Permitir comentários"
        WebElement botaoPermitirComentarios = driver.findElement(By.xpath("//select[@id='id_allowcomments']"));
        botaoPermitirComentarios.click();
        // Thread.sleep(2000);

        // Selecionar a opção "Sim"
        WebElement opcaoSim3 = driver.findElement(By.xpath("//select[@id='id_allowcomments']//option[@value='1'][normalize-space()='Sim']"));
        opcaoSim3.click();
        Thread.sleep(2000);

        // Clicar no botão "Fazer o link automático dos itens"
        WebElement botaoFazerLink = driver.findElement(By.xpath("//select[@id='id_usedynalink']"));
        botaoFazerLink.click();
        Thread.sleep(2000);

        // Selecionar a opção "Não"
        WebElement opcaoNao16 = driver.findElement(By.xpath("//select[@id='id_usedynalink']//option[@value='0'][normalize-space()='Não']"));
        opcaoNao16.click();
        Thread.sleep(2000);

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar.click();
        Thread.sleep(2000);

    }

@Test
public void itensSomenteLinksAutomaticos() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão ">" de "itens"
    WebElement botaoItens = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
    botaoItens.click();
    Thread.sleep(2000);

    // Clicar no botão "Aprovação imediata de novos itens"
    WebElement botaoAprovacaoItens = driver.findElement(By.xpath("//select[@id='id_defaultapproval']"));
    botaoAprovacaoItens.click();
    Thread.sleep(2000);

    // Selecionar a opção "Não"
    WebElement opcaoNao17 = driver.findElement(By.xpath("//select[@id='id_defaultapproval']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao17.click();
    Thread.sleep(2000);

    // Clicar no botão "Sempre permitir edição"
    WebElement botaoSemprePermitir = driver.findElement(By.xpath("//select[@id='id_editalways']"));
    botaoSemprePermitir.click();
    Thread.sleep(2000);

    // Selecionar a opção "Não"
    WebElement opcaoNao18 = driver.findElement(By.xpath("//select[@id='id_editalways']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao18.click();
    Thread.sleep(2000);

    // Clicar no botão "Permitir itens duplicados"
    WebElement botaoPermitirDuplicados = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']"));
    botaoPermitirDuplicados.click();
    Thread.sleep(2000);

    // Selecionar a opção "Não"
    WebElement opcaoNao19 = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao19.click();
    Thread.sleep(2000);

    // Clicar no botão "Permitir comentários"
    WebElement botaoPermitirComentarios = driver.findElement(By.xpath("//select[@id='id_allowcomments']"));
    botaoPermitirComentarios.click();
    Thread.sleep(2000);

    // Selecionar a opção "Não"
    WebElement opcaoNao20 = driver.findElement(By.xpath("//select[@id='id_allowcomments']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao20.click();
    Thread.sleep(2000);

    // Clicar no botão "Fazer o link automático dos itens"
    WebElement botaoFazerLink = driver.findElement(By.xpath("//select[@id='id_usedynalink']"));
    botaoFazerLink.click();
    Thread.sleep(2000);

    // Selecionar a opção "Sim"
    WebElement opcaoSim4 = driver.findElement(By.xpath("//select[@id='id_usedynalink']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim4.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void itensTodasOpcoesPermitidas() throws InterruptedException, IOException{ 
    
    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "itens"
    WebElement botaoItens = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
    botaoItens.click();
    Thread.sleep(2000);

    // Clicar no botão "Aprovação imediata de novos itens"			
    WebElement botaoAprovacaoItens = driver.findElement(By.xpath("//select[@id='id_defaultapproval']"));
    botaoAprovacaoItens.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim5 = driver.findElement(By.xpath("//select[@id='id_defaultapproval']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim5.click();
    Thread.sleep(2000);

    // Clicar no botão "Sempre permitir edição"				
    WebElement botaoSemprePermitir = driver.findElement(By.xpath("//select[@id='id_editalways']"));
    botaoSemprePermitir.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim6 = driver.findElement(By.xpath("//select[@id='id_editalways']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim6.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Permitir itens duplicados"				
    WebElement botaoPermitirDuplicados = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']"));
    botaoPermitirDuplicados.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim7 = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim7.click();
    Thread.sleep(2000);

    // Clicar no botão "Permitir comentários"				
    WebElement botaoPermitirComentarios = driver.findElement(By.xpath("//select[@id='id_allowcomments']"));
    botaoPermitirComentarios.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim8 = driver.findElement(By.xpath("//select[@id='id_allowcomments']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim8.click();
    Thread.sleep(2000);

    //Clicar no botão "Fazer o link automático dos itens"			
    WebElement botaoFazerLink = driver.findElement(By.xpath("//select[@id='id_usedynalink']"));
    botaoFazerLink.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim9 = driver.findElement(By.xpath("//select[@id='id_usedynalink']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim9.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void itensTodasOpcoesNegadas() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "itens"
    WebElement botaoItens = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
    botaoItens.click();
    Thread.sleep(2000);

    // Clicar no botão "Aprovação imediata de novos itens"			
    WebElement botaoAprovacaoItens = driver.findElement(By.xpath("//select[@id='id_defaultapproval']"));
    botaoAprovacaoItens.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao21 = driver.findElement(By.xpath("//select[@id='id_defaultapproval']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao21.click();
    Thread.sleep(2000);

    // Clicar no botão "Sempre permitir edição"				
    WebElement botaoSemprePermitir = driver.findElement(By.xpath("//select[@id='id_editalways']"));
    botaoSemprePermitir.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao22 = driver.findElement(By.xpath("//select[@id='id_editalways']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao22.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Permitir itens duplicados"				
    WebElement botaoPermitirDuplicados = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']"));
    botaoPermitirDuplicados.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao23 = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao23.click();
    Thread.sleep(2000);

    // Clicar no botão "Permitir comentários"				
    WebElement botaoPermitirComentarios = driver.findElement(By.xpath("//select[@id='id_allowcomments']"));
    botaoPermitirComentarios.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Não"
    WebElement opcaoNao24 = driver.findElement(By.xpath("//select[@id='id_allowcomments']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao24.click();
    Thread.sleep(2000);

    //Clicar no botão "Fazer o link automático dos itens"			
    WebElement botaoFazerLink = driver.findElement(By.xpath("//select[@id='id_usedynalink']"));
    botaoFazerLink.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao25 = driver.findElement(By.xpath("//select[@id='id_usedynalink']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao25.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void itensConfiguracaoDocente() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "itens"
    WebElement botaoItens = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
    botaoItens.click();
    Thread.sleep(2000);

    // Clicar no botão "Aprovação imediata de novos itens"			
    WebElement botaoAprovacaoItens = driver.findElement(By.xpath("//select[@id='id_defaultapproval']"));
    botaoAprovacaoItens.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim10 = driver.findElement(By.xpath("//select[@id='id_defaultapproval']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim10.click();
    Thread.sleep(2000);

    // Clicar no botão "Sempre permitir edição"				
    WebElement botaoSemprePermitir = driver.findElement(By.xpath("//select[@id='id_editalways']"));
    botaoSemprePermitir.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao26 = driver.findElement(By.xpath("//select[@id='id_editalways']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao26.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Permitir itens duplicados"				
    WebElement botaoPermitirDuplicados = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']"));
    botaoPermitirDuplicados.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao27 = driver.findElement(By.xpath("//select[@id='id_allowduplicatedentries']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao27.click();
    Thread.sleep(2000);

    // Clicar no botão "Permitir comentários"				
    WebElement botaoPermitirComentarios = driver.findElement(By.xpath("//select[@id='id_allowcomments']"));
    botaoPermitirComentarios.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Não"
    WebElement opcaoNao28 = driver.findElement(By.xpath("//select[@id='id_allowcomments']//option[@value='0'][normalize-space()='Não']"));
    opcaoNao28.click();
    Thread.sleep(2000);

    //Clicar no botão "Fazer o link automático dos itens"			
    WebElement botaoFazerLink = driver.findElement(By.xpath("//select[@id='id_usedynalink']"));
    botaoFazerLink.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim11 = driver.findElement(By.xpath("//select[@id='id_usedynalink']//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim11.click();
    Thread.sleep(2000);
    
    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}



@Test
public void aparenciaFormatoVisualizacaoCompletocAutor() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato da exibição de aprovação"						
    WebElement botaoFormatoExibicao = driver.findElement(By.xpath("//select[@id='id_approvaldisplayformat']"));
    botaoFormatoExibicao.click();
    Thread.sleep(2000);

    //Selecionar a opção "Padrão para o mesmo formato de exibição"
    WebElement opcaoPadraoMFormato = driver.findElement(By.xpath("//option[@value='default']"));
    opcaoPadraoMFormato.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP = driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP.click();
    Thread.sleep(2000);
    campoNumeroItensP.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim12 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim12.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim13 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim13.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim14 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim14.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim15 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim15.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaFormatoVisualizacaoCompletosAutor() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao1 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao1.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo sem autor"
    WebElement opcaoCompletosAutor = driver.findElement(By.xpath("//option[@value='fullwithoutauthor'][normalize-space()='Completo sem autor']"));
    opcaoCompletosAutor.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato da exibição de aprovação"						
    WebElement botaoFormatoExibicao1 = driver.findElement(By.xpath("//select[@id='id_approvaldisplayformat']"));
    botaoFormatoExibicao1.click();
    Thread.sleep(2000);

    //Selecionar a opção "Padrão para o mesmo formato de exibição"
    WebElement opcaoPadraoMFormato1 = driver.findElement(By.xpath("//option[@value='default']"));
    opcaoPadraoMFormato1.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP1 = driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP1.click();
    Thread.sleep(2000);
    campoNumeroItensP1.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks1 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks1.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim16 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim16.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos1 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos1.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim17 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim17.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial1 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial1.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim18 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim18.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar1 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar1.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim19 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim19.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void aparenciaFormatoVisualizacaContinuoSAutor() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao2 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao2.click();
    Thread.sleep(2000);

    //Selecionar a opção "Contínuo sem autor"
    WebElement opcaoContinuosAutor = driver.findElement(By.xpath("//option[@value='continuous'][normalize-space()='Contínuo sem autor']"));
    opcaoContinuosAutor.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato da exibição de aprovação"						
    WebElement botaoFormatoExibicao2 = driver.findElement(By.xpath("//select[@id='id_approvaldisplayformat']"));
    botaoFormatoExibicao2.click();
    Thread.sleep(2000);

    //Selecionar a opção "Padrão para o mesmo formato de exibição"
    WebElement opcaoPadraoMFormato2 = driver.findElement(By.xpath("//option[@value='default']"));
    opcaoPadraoMFormato2.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP2 = driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP2.click();
    Thread.sleep(2000);
    campoNumeroItensP2.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks2 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks2.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim20 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim20.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos2 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos2.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim21 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim21.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial2 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial2.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim22 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim22.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar2 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar2.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim23 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim23.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
 public void aparenciaFormatoVisualizacaEnciclopedia() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao3 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao3.click();
    Thread.sleep(2000);

    //Selecionar a opção "Enciclopédia"
    WebElement opcaoEnciclopedia = driver.findElement(By.xpath("//option[@value='encyclopedia'][normalize-space()='Enciclopédia']"));
    opcaoEnciclopedia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato da exibição de aprovação"						
    WebElement botaoFormatoExibicao3 = driver.findElement(By.xpath("//select[@id='id_approvaldisplayformat']"));
    botaoFormatoExibicao3.click();
    Thread.sleep(2000);

    //Selecionar a opção "Padrão para o mesmo formato de exibição"
    WebElement opcaoPadraoMFormato3 = driver.findElement(By.xpath("//option[@value='default']"));
    opcaoPadraoMFormato3.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP3 = driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP3.click();
    Thread.sleep(2000);
    campoNumeroItensP3.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks3 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks3.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim24 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim24.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos3 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos3.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim25 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim25.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial3 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial3.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim26 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim26.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar3 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar3.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim27 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim27.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaFormatoVisualizacaFAQ() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao4 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao4.click();
    Thread.sleep(2000);

    //Selecionar a opção "FAQ"
    WebElement opcaoFAQ = driver.findElement(By.xpath("//option[@value='faq'][normalize-space()='FAQ']"));
    opcaoFAQ.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato da exibição de aprovação"						
    WebElement botaoFormatoExibicao4 = driver.findElement(By.xpath("//select[@id='id_approvaldisplayformat']"));
    botaoFormatoExibicao4.click();
    Thread.sleep(2000);

    //Selecionar a opção "Padrão para o mesmo formato de exibição"
    WebElement opcaoPadraoMFormato4 = driver.findElement(By.xpath("//option[@value='default']"));
    opcaoPadraoMFormato4.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP4 = driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP4.click();
    Thread.sleep(2000);
    campoNumeroItensP4.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks4 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks4.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim28 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim28.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos4 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos4.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim29 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim29.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial4 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial4.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim30 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim30.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar4 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar4.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim31 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim31.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaFormatoVisualizacaListadeItens() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao5 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao5.click();
    Thread.sleep(2000);

    //Selecionar a opção "Lista de itens"
    WebElement opcaoListaDItens = driver.findElement(By.xpath("//option[@value='entrylist'][normalize-space()='Lista de itens']"));
    opcaoListaDItens.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato da exibição de aprovação"						
    WebElement botaoFormatoExibicao5 = driver.findElement(By.xpath("//select[@id='id_approvaldisplayformat']"));
    botaoFormatoExibicao5.click();
    Thread.sleep(2000);

    //Selecionar a opção "Padrão para o mesmo formato de exibição"
    WebElement opcaoPadraoMFormato5 = driver.findElement(By.xpath("//option[@value='default']"));
    opcaoPadraoMFormato5.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP5 = driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP5.click();
    Thread.sleep(2000);
    campoNumeroItensP5.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks5 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks5.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim32 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim32.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos5 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos5.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim33 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim33.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial5 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial5.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim34 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim34.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar5 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar5.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim35 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim35.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}




@Test
public void aparenciaFormatoVisualizacaSimples() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao6 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao6.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato da exibição de aprovação"						
    WebElement botaoFormatoExibicao6 = driver.findElement(By.xpath("//select[@id='id_approvaldisplayformat']"));
    botaoFormatoExibicao6.click();
    Thread.sleep(2000);

    //Selecionar a opção "Padrão para o mesmo formato de exibição"
    WebElement opcaoPadraoMFormato6 = driver.findElement(By.xpath("//option[@value='default']"));
    opcaoPadraoMFormato6.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP6 = driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP6.click();
    Thread.sleep(2000);
    campoNumeroItensP6.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks6 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks6.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim36 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim36.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos6 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos6.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim37 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim37.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial6 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial6.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim38 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim38.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar6 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar6.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim39 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim39.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaFormatoExibicaoPadrao() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao7 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao7.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor7 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor7.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato da exibição de aprovação"						
    WebElement botaoFormatoExibicao7 = driver.findElement(By.xpath("//select[@id='id_approvaldisplayformat']"));
    botaoFormatoExibicao7.click();
    Thread.sleep(2000);

    //Selecionar a opção "Padrão para o mesmo formato de exibição"
    WebElement opcaoPadraoMFormato7 = driver.findElement(By.xpath("//option[@value='default']"));
    opcaoPadraoMFormato7.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP7= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP7.click();
    Thread.sleep(2000);
    campoNumeroItensP7.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks7 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks7.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim40 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim40.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos7 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos7.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim41 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim41.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial7 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial7.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim42 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim42.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar7 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar7.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim43 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim43.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaFormatoExibicaoCompletocAutor() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao8 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao8.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor8 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor8.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoCompletocAutor8 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoCompletocAutor8.click();
    Thread.sleep(2000);

    //Selecionar a opção "Padrão para o mesmo formato de exibição"
    WebElement opcaoPadraoMFormato8 = driver.findElement(By.xpath("//option[@value='default']"));
    opcaoPadraoMFormato8.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP8= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP8.click();
    Thread.sleep(2000);
    campoNumeroItensP8.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks8 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks8.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim44 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim44.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos8 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos8.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim45 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim45.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial8 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial8.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim46 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim46.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar8 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar8.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim47 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim47.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void aparenciaFormatoExibicaoCompletoSAutor() throws InterruptedException, IOException, ParseException{

    
    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao9 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao9.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor9 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor9.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao9 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao9.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo sem autor"
    WebElement opcaoCompletoSAutor9 = driver.findElement(By.xpath("//option[@value='fullwithoutauthor'][normalize-space()='Completo sem autor']"));
    opcaoCompletoSAutor9.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP9= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP9.click();
    Thread.sleep(2000);
    campoNumeroItensP9.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks9 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks9.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim48 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim48.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos9 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos9.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim49 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim49.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial9 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial9.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim50 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim50.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar9 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar9.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim51 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim51.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void aparenciaFormatoExibicaoContinuoSAutor() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao10 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao10.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor10 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor10.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao10 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao10.click();
    Thread.sleep(2000);

    //Selecionar a opção "Contínuo sem autor"
    WebElement opcaoContinuoSAutor10 = driver.findElement(By.xpath("//option[@value='continuous'][normalize-space()='Contínuo sem autor']"));
    opcaoContinuoSAutor10.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP10= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP10.click();
    Thread.sleep(2000);
    campoNumeroItensP10.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks10 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks10.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim52 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim52.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos10 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos10.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim53 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim53.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial10 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial10.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim54 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim54.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar10 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar10.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim55 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim55.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaFormatoExibicaoEnciclopedia() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao11 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao11.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor11 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor11.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao11 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao11.click();
    Thread.sleep(2000);

    //Selecionar a opção "Enciclopédia"
    WebElement opcaoEnciclopedia11 = driver.findElement(By.xpath("//option[@value='encyclopedia'][normalize-space()='Enciclopédia']"));
    opcaoEnciclopedia11.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP11= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP11.click();
    Thread.sleep(2000);
    campoNumeroItensP11.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks11 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks11.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim56 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim56.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos11 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos11.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim57 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim57.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial11 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial11.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim58 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim58.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar11 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar11.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim59 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim59.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaFormatoExibicaoFAQ() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao12 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao12.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor12 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor12.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao12 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao12.click();
    Thread.sleep(2000);

    //Selecionar a opção "FAQ"
    WebElement opcaoFAQ12 = driver.findElement(By.xpath("//option[@value='faq'][normalize-space()='FAQ']"));
    opcaoFAQ12.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP12= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP12.click();
    Thread.sleep(2000);
    campoNumeroItensP12.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks12 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks12.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim60 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim60.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos12 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos12.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim61 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim61.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial12 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial12.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim62 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim62.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar12 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar12.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim63 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim63.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void aparenciaFormatoExibicaoListaDItens() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao13 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao13.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor13 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor13.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao13 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao13.click();
    Thread.sleep(2000);

    //Selecionar a opção "Lista de itens"
    WebElement opcaoListaDItens13 = driver.findElement(By.xpath("//option[@value='entrylist'][normalize-space()='Lista de itens']"));
    opcaoListaDItens13.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP13= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP13.click();
    Thread.sleep(2000);
    campoNumeroItensP13.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks13 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks13.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim64 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim64.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos13 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos13.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim65 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim65.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial13 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial13.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim66 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim66.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar13 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar13.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim67 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim67.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaFormatoExibicaoSimples() throws InterruptedException, IOException, ParseException{
    
    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao14 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao14.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor14 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor14.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao14 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao14.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario14 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario14.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP14= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP14.click();
    Thread.sleep(2000);
    campoNumeroItensP14.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks14 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks14.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim68 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim68.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos14 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos14.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim69 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim69.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial14 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial14.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim70 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim70.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar14 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar14.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim71 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim71.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaNumeroItensMostradosNaPagina0() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao15 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao15.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor15 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor15.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao15 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao15.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario15 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario15.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "0"		
    WebElement campoNumeroItensP15= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP15.click();
    Thread.sleep(2000);
    campoNumeroItensP15.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks15 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks15.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim72 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim72.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos15 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos15.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim73 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim73.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial15 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial15.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim74 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim74.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar15 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar15.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim75 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim75.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaNumeroItensMostradosNaPagina10() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao16 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao16.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor16 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor16.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao16 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao16.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario16 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario16.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP16= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP16.click();
    Thread.sleep(2000);
    campoNumeroItensP16.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks16 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks16.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim76 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim76.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos16 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos16.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim77 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim77.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial16 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial16.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim78 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim78.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar16 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar16.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim79 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim79.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
 public void aparenciaMostarAlfabetoEmLinks() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao17 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao17.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor17 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor17.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao17 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao17.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario17 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario17.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP17= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP17.click();
    Thread.sleep(2000);
    campoNumeroItensP17.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks17 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks17.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim80 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim80.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos17 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos17.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim81 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim81.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial17 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial17.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim82 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim82.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar17 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar17.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim83 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim83.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaNaoMostarAlfabetoEmLinks() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao18 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao18.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor18 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor18.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao18 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao18.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario18 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario18.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP18= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP18.click();
    Thread.sleep(2000);
    campoNumeroItensP18.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoNMostrarAlfabLinks18 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoNMostrarAlfabLinks18.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Não"
    WebElement opcaoNão80 = driver.findElement(By.xpath("//option[@value='0'][normalize-space()='Não']"));
    opcaoNão80.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos18 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos18.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim84 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim84.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial18 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial18.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim85 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim85.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar18 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar18.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim86 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim86.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}



@Test
public void aparenciaMostarLinksTodos() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");
            
    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao19 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao19.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor19 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor19.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao19 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao19.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario19 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario19.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP19= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP19.click();
    Thread.sleep(2000);
    campoNumeroItensP19.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks19 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks19.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim87 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim87.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos19 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos19.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim88 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim88.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial19 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial19.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim89 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim89.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar19 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar19.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim90 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim90.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void aparenciaNaoMostarLinksTodos() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao20 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao20.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor20 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor20.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao20 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao20.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario20 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario20.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP20= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP20.click();
    Thread.sleep(2000);
    campoNumeroItensP20.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks20 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks20.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim90 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim90.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos20 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos20.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao91 = driver.findElement(By.xpath("//option[@value='0'][normalize-space()='Não']"));
    opcaoNao91.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial20 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial20.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim91 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim91.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar20 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar20.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim92 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim92.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaMostarLinksEspecial() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao21 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao21.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor21 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor21.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao21 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao21.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario21 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario21.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP21= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP21.click();
    Thread.sleep(2000);
    campoNumeroItensP21.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks21 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks21.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim93 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim93.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos21 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos21.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim94 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim94.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial21 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial21.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim95 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim95.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar21 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar21.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim96 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim96.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void aparenciaNaoMostarLinksEspecial() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao22 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao22.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor22 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor22.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao22 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao22.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario22 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario22.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP22= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP22.click();
    Thread.sleep(2000);
    campoNumeroItensP22.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks22 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks22.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim97 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim97.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos22 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos22.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim98 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim98.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial22 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial22.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao99 = driver.findElement(By.xpath("//option[@value='0'][normalize-space()='Não']"));
    opcaoNao99.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar22 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar22.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim99 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim99.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void aparenciaPermitirVisualizarImpressao() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao23 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao23.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor23 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor23.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao23 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao23.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario23 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario23.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP23= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP23.click();
    Thread.sleep(2000);
    campoNumeroItensP23.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks23 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks23.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim100 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim100.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos23 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos23.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim101 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim101.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial23 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial23.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim102 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim102.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar23 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar23.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim103 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim103.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void aparenciaNaoPermitirVisualizarImpressao() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    //Clicar no botão ">" de "Aparência"
    WebElement botaoAparencia = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
    botaoAparencia.click();
    Thread.sleep(2000);

    // Clicar no botão "Formato de visualização"					
    WebElement botaoFormatoVisualizacao24 = driver.findElement(By.xpath("//select[@id='id_displayformat']"));
    botaoFormatoVisualizacao24.click();
    Thread.sleep(2000);

    //Selecionar a opção "Completo com autor"
    WebElement opcaoCompletocAutor24 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    opcaoCompletocAutor24.click();
    Thread.sleep(2000);

    // Clicar no botão "Completo com autor"						
    WebElement botaoFormatoExibicao24 = driver.findElement(By.xpath("//option[@value='fullwithauthor'][normalize-space()='Completo com autor']"));
    botaoFormatoExibicao24.click();
    Thread.sleep(2000);

    //Selecionar a opção "Simples, estilo dicionário"
    WebElement opcaoSimplesEDicionario24 = driver.findElement(By.xpath("//option[@value='dictionary'][normalize-space()='Simples, estilo dicionário']"));
    opcaoSimplesEDicionario24.click();
    Thread.sleep(2000);
    
    //Clicar no campo "Número de itens mostrados em cada página"		Preencher o campo com "10"		
    WebElement campoNumeroItensP24= driver.findElement(By.xpath("//input[@id='id_entbypage']"));
    campoNumeroItensP24.click();
    Thread.sleep(2000);
    campoNumeroItensP24.sendKeys(obj.get("numeroMaximo").toString());
    Thread.sleep(2000);

    // Clicar no botão "Mostrar alfabeto em links"				
    WebElement botaoMostrarAlfabLinks24 = driver.findElement(By.xpath("//select[@id='id_showalphabet']"));
    botaoMostrarAlfabLinks24.click();
    Thread.sleep(2000);
    
    //Selecionar a opção "Sim"
    WebElement opcaoSim104 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim104.click();
    Thread.sleep(2000);

    //Clicar no botão "Mostrar o link 'TODOS'"					
    WebElement botaoMostrarLinkTodos24 = driver.findElement(By.xpath("//select[@id='id_showall']"));
    botaoMostrarLinkTodos24.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim105 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim105.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Mostrar o link 'Especial'"					
    WebElement botaoMostrarLinkEspecial24 = driver.findElement(By.xpath("//select[@id='id_showspecial']"));
    botaoMostrarLinkEspecial24.click();
    Thread.sleep(2000);

    //Selecionar a opção "Sim"
    WebElement opcaoSim106 = driver.findElement(By.xpath("//option[@value='1'][normalize-space()='Sim']"));
    opcaoSim106.click();
    Thread.sleep(2000);
    
    //Clicar no botão "Permitir visualizar impressão"					
    WebElement botaoPermitirVisualizar24 = driver.findElement(By.xpath("//select[@id='id_allowprintview']"));
    botaoPermitirVisualizar24.click();
    Thread.sleep(2000);

    //Selecionar a opção "Não"
    WebElement opcaoNao107 = driver.findElement(By.xpath("//option[@value='0'][normalize-space()='Não']"));
    opcaoNao107.click();
    Thread.sleep(2000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void avaliacaoNenhum() throws InterruptedException, IOException{

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoNen = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoNen.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado"
    WebElement tipoAgN = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgN.click();
    Thread.sleep(2000);
    
    //Selecionar "Nenhuma avaliação"
    WebElement opcaoAgN0 = driver.findElement(By.xpath("//option[normalize-space()='Nenhuma avaliação']"));
    opcaoAgN0.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void avaliacaoMediadasAvaliaçõesEscala() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoE = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoE.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Média das avaliações"
    WebElement tipoAgM = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgM.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgM1 = driver.findElement(By.xpath("//option[normalize-space()='Média das avaliações']"));
    opcaoAgM1.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Escala"
    WebElement tipoMAE = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoMAE.click();
    Thread.sleep(2000);
    
    WebElement opcaoMAE1 = driver.findElement(By.xpath("//option[normalize-space()='Escala de competência padrão']"));
    opcaoMAE1.click();
    Thread.sleep(3000);

    // Clicar no botão "Escala"
    WebElement campoEscala = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_scale']"));
    campoEscala.click();
    Thread.sleep(2000);
    
    WebElement opcaoCE2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoCE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Permitir avaliações apenas para os itens com datas neste intervalo:"
    WebElement permitirItens = driver.findElement(By.xpath("//input[@id='id_ratingtime']"));
    permitirItens.click();
    Thread.sleep(2000);

    // Clicar no botão "Nota para aprovação"
    WebElement notaAprova = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    notaAprova.click();
    Thread.sleep(2000);
    notaAprova.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}  
    

@Test
public void avaliacaoMediadasAvaliaçõesEscala2() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");
          
    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoE1 = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoE1.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Média das avaliações"
    WebElement tipoAgM1 = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgM1.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgM300 = driver.findElement(By.xpath("//option[normalize-space()='Média das avaliações']"));
    opcaoAgM300.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Escala"
    WebElement tipoMAE = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoMAE.click();
    Thread.sleep(2000);
    
    WebElement opcaoMAE1 = driver.findElement(By.xpath("//option[@value='scale']"));
    opcaoMAE1.click();
    Thread.sleep(3000);

    // Clicar no botão "Escala"
    WebElement campoEscala = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_scale']"));
    campoEscala.click();
    Thread.sleep(2000);
    
    WebElement opcaoCE2 = driver.findElement(By.xpath("//option[normalize-space()='Formas de saber: conectada e destacada']"));
    opcaoCE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Permitir avaliações apenas para os itens com datas neste intervalo:"
    WebElement permitirItens = driver.findElement(By.xpath("//input[@id='id_ratingtime']"));
    permitirItens.click();
    Thread.sleep(2000);

    // Clicar no botão "Nota para aprovação"
    WebElement notaAprova = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    notaAprova.click();
    Thread.sleep(2000);
    notaAprova.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}     
    

@Test
public void avaliacaoMediadasAvaliaçõesPontos() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");  


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoP = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoP.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Média das avaliações"
    WebElement tipoAgM = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgM.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgM1 = driver.findElement(By.xpath("//option[normalize-space()='Média das avaliações']"));
    opcaoAgM1.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Pontos"
    WebElement tipoMAP = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoMAP.click();
    Thread.sleep(2000);
    
    WebElement opcaoMAP3 = driver.findElement(By.xpath("//option[@value='point']"));
    opcaoMAP3.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota máxima"	
    WebElement campoNoMax = driver.findElement(By.xpath("//input[@id='id_scale_modgrade_point']"));
    campoNoMax.click();
    Thread.sleep(2000);
    campoNoMax.sendKeys(obj.get("numeroMaximo").toString());
    
    WebElement opcaoCE2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoCE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement noAprova = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    noAprova.click();
    Thread.sleep(2000);
    noAprova.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void avaliacaoContagemEscala() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoCe = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoCe.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Contagem de Avaliações"
    WebElement tipoAgC = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgC.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgC2 = driver.findElement(By.xpath("//option[normalize-space()='Contagem das avaliações']"));
    opcaoAgC2.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Escala"
    WebElement tipoMAE2 = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoMAE2.click();
    Thread.sleep(2000);
    
    WebElement opcaoMAE2 = driver.findElement(By.xpath("//option[@value='scale']"));
    opcaoMAE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Escala"
    WebElement campoCEscala = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_scale']"));
    campoCEscala.click();
    Thread.sleep(2000);
    
    WebElement opcaoCE2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoCE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement notPA = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    notPA.click();
    Thread.sleep(2000);
    notPA.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void avaliacaoContagemEscala2() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoCe = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoCe.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Contagem de Avaliações"
    WebElement tipoAgC = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgC.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgC2 = driver.findElement(By.xpath("//option[normalize-space()='Contagem das avaliações']"));
    opcaoAgC2.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Escala"
    WebElement tipoMAE2 = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoMAE2.click();
    Thread.sleep(2000);
    
    WebElement opcaoMAE2 = driver.findElement(By.xpath("//option[normalize-space()='Formas de saber: conectada e destacada']"));
    opcaoMAE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Escala"
    WebElement campoCEscala = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_scale']"));
    campoCEscala.click();
    Thread.sleep(2000);
    
    WebElement opcaoCE2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoCE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement notPA = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    notPA.click();
    Thread.sleep(2000);
    notPA.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
            
}


@Test
public void avaliacaoContagemPontos() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoCp = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoCp.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Contagem de avaliações"
    WebElement tipoAgCa = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgCa.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgCa2 = driver.findElement(By.xpath("//option[normalize-space()='Contagem das avaliações']"));
    opcaoAgCa2.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Pontos"
    WebElement tipoCp = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoCp.click();
    Thread.sleep(2000);
    
    WebElement opcaoCp2 = driver.findElement(By.xpath("//option[@value='point']"));
    opcaoCp2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota máxima"	
    WebElement campNoMax = driver.findElement(By.xpath("//input[@id='id_scale_modgrade_point']"));
    campNoMax.click();
    Thread.sleep(2000);
    campNoMax.sendKeys(obj.get("numeroMaximo").toString());
    
    WebElement opcaoCE2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoCE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement nA = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    nA.click();
    Thread.sleep(2000);
    nA.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
          
}


@Test
public void avaliacaoMaximaEscala() throws InterruptedException, IOException, ParseException{
                
    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoMe = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoMe.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Avaliação Maxima"
    WebElement tipoAgAm = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgAm.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgA3 = driver.findElement(By.xpath("//option[normalize-space()='Avaliação máxima']"));
    opcaoAgA3.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Escala"
    WebElement tipoAmE3 = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoAmE3.click();
    Thread.sleep(2000);
    
    WebElement opcaoAmE3 = driver.findElement(By.xpath("//option[@value='scale']"));
    opcaoAmE3.click();
    Thread.sleep(3000);

    // Clicar no botão "Escala"
    WebElement campoMEscala = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_scale']"));
    campoMEscala.click();
    Thread.sleep(2000);
    
    WebElement opcaoME2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoME2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement notPAp = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    notPAp.click();
    Thread.sleep(2000);
    notPAp.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
              
}


@Test
public void avaliacaoMaximaEscala2() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoMe = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoMe.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Avaliação Maxima"
    WebElement tipoAgAm = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgAm.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgA3 = driver.findElement(By.xpath("//option[normalize-space()='Avaliação máxima']"));
    opcaoAgA3.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Escala"
    WebElement tipoAmE3 = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoAmE3.click();
    Thread.sleep(2000);
    
    WebElement opcaoAmE3 = driver.findElement(By.xpath("//option[@value='scale']"));
    opcaoAmE3.click();
    Thread.sleep(3000);

    // Clicar no botão "Escala"
    WebElement campoMEscala = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_scale']"));
    campoMEscala.click();
    Thread.sleep(2000);
    
    WebElement opcaoME2 = driver.findElement(By.xpath("//option[normalize-space()='Formas de saber: conectada e destacada']"));
    opcaoME2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement notPAp = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    notPAp.click();
    Thread.sleep(2000);
    notPAp.sendKeys(obj.get("notaAprovacao").toString());


    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
           
}


@Test
public void avaliacaoMaximaPontos() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoMp = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoMp.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Avaliação maxima"
    WebElement tipoAgaM = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgaM.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgaM3 = driver.findElement(By.xpath("//option[normalize-space()='Avaliação máxima']"));
    opcaoAgaM3.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Pontos"
    WebElement tipoMp = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoMp.click();
    Thread.sleep(2000);
    
    WebElement opcaoaM2 = driver.findElement(By.xpath("//option[@value='point']"));
    opcaoaM2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota máxima"	
    WebElement campNoM = driver.findElement(By.xpath("//input[@id='id_scale_modgrade_point']"));
    campNoM.click();
    Thread.sleep(2000);
    campNoM.sendKeys(obj.get("numeroMaximo").toString());
    
    WebElement opcaoAm2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoAm2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement nAp = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    nAp.click();
    Thread.sleep(2000);
    nAp.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
        
}

@Test
public void avaliacaoMimimaEscala() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoMIe = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoMIe.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Avaliação Mimina"
    WebElement tipoAgAmi = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgAmi.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgAm4 = driver.findElement(By.xpath("//option[normalize-space()='Avaliação mínima']"));
    opcaoAgAm4.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Escala"
    WebElement tipoAmiE3 = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoAmiE3.click();
    Thread.sleep(2000);
    
    WebElement opcaoAmE3 = driver.findElement(By.xpath("//option[@value='scale']"));
    opcaoAmE3.click();
    Thread.sleep(3000);

    // Clicar no botão "Escala"
    WebElement campoMiEscala = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_scale']"));
    campoMiEscala.click();
    Thread.sleep(2000);
    
    WebElement opcaoMiE2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoMiE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement notPAmp = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    notPAmp.click();
    Thread.sleep(2000);
    notPAmp.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
           
}

@Test
public void avaliacaoMimimaEscala2() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoMIe = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoMIe.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Avaliação Mimina"
    WebElement tipoAgAmi = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgAmi.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgAm4 = driver.findElement(By.xpath("//option[normalize-space()='Avaliação mínima']"));
    opcaoAgAm4.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Escala"
    WebElement tipoAmiE3 = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoAmiE3.click();
    Thread.sleep(2000);
    
    WebElement opcaoAmE3 = driver.findElement(By.xpath("//option[@value='scale']"));
    opcaoAmE3.click();
    Thread.sleep(3000);

    // Clicar no botão "Escala"
    WebElement campoMiEscala = driver.findElement(By.xpath("//option[normalize-space()='Formas de saber: conectada e destacada']"));
    campoMiEscala.click();
    Thread.sleep(2000);
    
    WebElement opcaoMiE2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoMiE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement notPAmp = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    notPAmp.click();
    Thread.sleep(2000);
    notPAmp.sendKeys(obj.get("notaAprovacao").toString());


    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
            
        
}

@Test
public void avaliacaoMinimaPontos() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoMiP = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoMiP.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Avaliação minima"
    WebElement tipoAgaMi = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgaMi.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgaMi3 = driver.findElement(By.xpath("//option[normalize-space()='Avaliação mínima']"));
    opcaoAgaMi3.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Pontos"
    WebElement tipoMip = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoMip.click();
    Thread.sleep(2000);
    
    WebElement opcaoaMi2 = driver.findElement(By.xpath("//option[@value='point']"));
    opcaoaMi2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota máxima"	
    WebElement campNoMi = driver.findElement(By.xpath("//input[@id='id_scale_modgrade_point']"));
    campNoMi.click();
    Thread.sleep(2000);
    campNoMi.sendKeys(obj.get("numeroMaximo").toString());
    
    WebElement opcaoAmi2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoAmi2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement nApr = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    nApr.click();
    Thread.sleep(2000);
    nApr.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
        
}
    
    
@Test
public void avaliacaoSomaEscala() throws InterruptedException, IOException, ParseException{
        
    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoSe = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoSe.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Soma das Avaliações"
    WebElement tipoAgAse = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgAse.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgAse5 = driver.findElement(By.xpath("//option[normalize-space()='Soma das avaliações']"));
    opcaoAgAse5.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Escala"
    WebElement tipoAsE3 = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoAsE3.click();
    Thread.sleep(2000);
    
    WebElement opcaoAsE3 = driver.findElement(By.xpath("//option[@value='scale']"));
    opcaoAsE3.click();
    Thread.sleep(3000);

    // Clicar no botão "Escala"
    WebElement campoSEscala = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_scale']"));
    campoSEscala.click();
    Thread.sleep(2000);
    
    WebElement opcaoSE2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoSE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement notPAmpS = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    notPAmpS.click();
    Thread.sleep(2000);
    notPAmpS.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
        
}


@Test
public void avaliacaoSomaEscala2() throws InterruptedException, IOException, ParseException{

     JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaoSe = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaoSe.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Soma das Avaliações"
    WebElement tipoAgAse = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgAse.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgAse5 = driver.findElement(By.xpath("//option[normalize-space()='Soma das avaliações']"));
    opcaoAgAse5.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Escala"
    WebElement tipoAsE3 = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tipoAsE3.click();
    Thread.sleep(2000);
    
    WebElement opcaoAsE3 = driver.findElement(By.xpath("//option[@value='scale']"));
    opcaoAsE3.click();
    Thread.sleep(3000);

    // Clicar no botão "Escala"
    WebElement campoSEscala = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_scale']"));
    campoSEscala.click();
    Thread.sleep(2000);
    
    WebElement opcaoSE2 = driver.findElement(By.xpath("//option[normalize-space()='Formas de saber: conectada e destacada']"));
    opcaoSE2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement notPAmpS = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    notPAmpS.click();
    Thread.sleep(2000);
    notPAmpS.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
            
}

    
@Test
public void avaliacaoSomaPontos() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Avaliação"
    WebElement avaliacaosP = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
    avaliacaosP.click();
    Thread.sleep(2000);

    // Clicar no botão "tipo agregado - Avaliação minima"
    WebElement tipoAgasi = driver.findElement(By.xpath("//select[@id='id_assessed']"));
    tipoAgasi.click();
    Thread.sleep(2000);
    
    WebElement opcaoAgasP5 = driver.findElement(By.xpath("//option[normalize-space()='Soma das avaliações']"));
    opcaoAgasP5.click();
    Thread.sleep(3000);

    // Clicar no botão "Tipo - Pontos"
    WebElement tiposp = driver.findElement(By.xpath("//select[@id='id_scale_modgrade_type']"));
    tiposp.click();
    Thread.sleep(2000);
    
    WebElement opcaoaSP2 = driver.findElement(By.xpath("//option[@value='point']"));
    opcaoaSP2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota máxima"	
    WebElement campNoSp = driver.findElement(By.xpath("//input[@id='id_scale_modgrade_point']"));
    campNoSp.click();
    Thread.sleep(2000);
    campNoSp.sendKeys(obj.get("numeroMaximo").toString());
    
    WebElement opcaoAsp2 = driver.findElement(By.xpath("//option[@value='2']"));
    opcaoAsp2.click();
    Thread.sleep(3000);

    // Clicar no botão "Nota para aprovação"
    WebElement nottApro = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
    nottApro.click();
    Thread.sleep(2000);
    nottApro.sendKeys(obj.get("notaAprovacao").toString());


    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
            
        
}

@Test
public void configuracoesComunsDeModulosMostrar() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Configurações comuns de módulos"
    WebElement configComum = driver.findElement(By.xpath("//a[@id='collapseElement-4']"));
    configComum.click();
    Thread.sleep(2000);

    // Clicar no botão "Disponibilidade" Mostrar	
    WebElement botaoDisp = driver.findElement(By.xpath("//select[@id='id_visible']"));
    botaoDisp.click();
    Thread.sleep(2000);
    
    WebElement opcaoMostrar1 = driver.findElement(By.xpath("//option[normalize-space()='Mostrar na página do curso']"));
    opcaoMostrar1.click();
    Thread.sleep(3000);

    // Clicar no botão "Número de identificação do módulo"
    WebElement numeroIdentModulo = driver.findElement(By.xpath("//input[@id='id_cmidnumber']"));
    numeroIdentModulo.click();
    Thread.sleep(2000);
    numeroIdentModulo.sendKeys(obj.get("numeroIdentificacao").toString());

    // Clicar no botão "Forçar idioma"
    WebElement forcarIdioma = driver.findElement(By.xpath("//select[@id='id_lang']"));
    forcarIdioma.click();
    Thread.sleep(2000);
    
    WebElement opcaoNfi1 = driver.findElement(By.xpath("//option[normalize-space()='Não forçar']"));
    opcaoNfi1.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
            
}

@Test
public void configuracoesComunsDeModulosOcultar() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Configurações comuns de módulos"
    WebElement configComumM = driver.findElement(By.xpath("//a[@id='collapseElement-4']"));
    configComumM.click();
    Thread.sleep(2000);

    // Clicar no botão "Disponibilidade" Ocultar	
    WebElement botaoDispO = driver.findElement(By.xpath("//select[@id='id_visible']"));
    botaoDispO.click();
    Thread.sleep(2000);
    
    WebElement opcaoOcultar0 = driver.findElement(By.xpath("//option[normalize-space()='Ocultar dos estudantes']"));
    opcaoOcultar0.click();
    Thread.sleep(3000);

    // Clicar no botão "Número de identificação do módulo"
    WebElement campnumIdentModulo = driver.findElement(By.xpath("//input[@id='id_cmidnumber']"));
    campnumIdentModulo.click();
    Thread.sleep(2000);
    campnumIdentModulo.sendKeys(obj.get("numeroIdentificacao").toString());

    // Clicar no botão "Forçar idioma"
    WebElement bForcarIdioma = driver.findElement(By.xpath("//select[@id='id_lang']"));
    bForcarIdioma.click();
    Thread.sleep(2000);
    
    WebElement opcaoNofi1 = driver.findElement(By.xpath("//option[normalize-space()='Não forçar']"));
    opcaoNofi1.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
            
        
}

@Test
public void restringirAcessoConclusaoAtividade() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Restringir acesso"
    WebElement avaliacaoNen = driver.findElement(By.xpath("//a[@id='collapseElement-5']"));
    avaliacaoNen.click();
    Thread.sleep(2000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestri = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestri.click();
    Thread.sleep(2000);
    
    WebElement opcaoConclusao = driver.findElement(By.xpath("//button[@id='availability_addrestriction_completion']"));
    opcaoConclusao.click();
    Thread.sleep(3000);

    // Clicar no botão "Escolher"
    WebElement botaoEscolher = driver.findElement(By.xpath("//select[@id='yui_3_17_2_1_1669638217209_1875']"));
    botaoEscolher.click();
    Thread.sleep(2000);
    
    WebElement opcaoEscolher3 = driver.findElement(By.xpath("//option[@value='1622']"));
    opcaoEscolher3.click();
    Thread.sleep(3000);

    // Clicar no botão "Requer estado concluido"
    WebElement botaoRequer = driver.findElement(By.xpath("//select[@id='yui_3_17_2_1_1669638217209_1903']"));
    botaoRequer.click();
    Thread.sleep(2000);
    
    WebElement opcaoRC1 = driver.findElement(By.xpath("//option[normalize-space()='deve ser marcada como concluída']"));
    opcaoRC1.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void restringirAcessoDataDe() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcesso = driver.findElement(By.xpath("//a[@id='collapseElement-5']"));
    restringirAcesso.click();
    Thread.sleep(2000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestri = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestri.click();
    Thread.sleep(2000);
    
    WebElement opcaoData = driver.findElement(By.xpath("//button[@id='availability_addrestriction_date']"));
    opcaoData.click();
    Thread.sleep(3000);

    // Clicar no botão de "dia" 
    WebElement dia26 = driver.findElement(By.xpath("(//select[@name='x[day]'])[1]"));
    dia26.click();
    Thread.sleep(3000);
    
    WebElement opcao26 = driver.findElement(By.xpath("//select[@name='x//option[@value='26'][normalize-space()='26']"));
    opcao26.click();
    Thread.sleep(3000);

    // Clicar no botão de "mês" 
    WebElement mes11 = driver.findElement(By.xpath("(//select[@name='x[month]'])[1]"));
    mes11.click();
    Thread.sleep(3000);
    
    WebElement opcao11 = driver.findElement(By.xpath("//option[@selected='selected'][normalize-space()='novembro']"));
    opcao11.click();
    Thread.sleep(3000);

    // Clicar no botão de "ano" 
    WebElement ano22 = driver.findElement(By.xpath("(//select[@name='x[year]'])[1]"));
    ano22.click();
    Thread.sleep(3000);
    
    WebElement opcaod2022 = driver.findElement(By.xpath("//option[@selected='selected'][normalize-space()='2022']"));
    opcaod2022.click();
    Thread.sleep(3000);

    // Clicar no botão de "horas" 
    WebElement bhoras = driver.findElement(By.xpath("(//select[@name='x[hour]'])[1]"));
    bhoras.click();
    Thread.sleep(3000);
    
    WebElement opcaob0 = driver.findElement(By.xpath("//select[@name='x//option[@value='0'][normalize-space()='00']"));
    opcaob0.click();
    Thread.sleep(3000);

    // Clicar no botão de "minutos" 
    WebElement bminutos = driver.findElement(By.xpath("(//select[@name='x[minute]'])[1]"));
    bminutos.click();
    Thread.sleep(3000);
    
    WebElement opcaob00 = driver.findElement(By.xpath("//select[@name='x//option[@value='0'][normalize-space()='00']"));
    opcaob00.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void restringirAcessoDataAte() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcess = driver.findElement(By.xpath("//a[@id='collapseElement-5']"));
    restringirAcess.click();
    Thread.sleep(2000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestri = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestri.click();
    Thread.sleep(2000);
    
    WebElement opcaoData = driver.findElement(By.xpath("//button[@id='availability_addrestriction_date']"));
    opcaoData.click();
    Thread.sleep(3000);

    // Clicar no botão "De"
    WebElement botaoAdRestriAte = driver.findElement(By.xpath("//select[@id='yui_3_17_2_1_1669638217209_2145']"));
    botaoAdRestriAte.click();
    Thread.sleep(2000);
    
    WebElement opcaoAte = driver.findElement(By.xpath("//option[@value='<']"));
    opcaoAte.click();
    Thread.sleep(3000);

    // Clicar no botão de "dia" 
    WebElement bdia3 = driver.findElement(By.xpath("(//select[@name='x[day]'])[1]"));
    bdia3.click();
    Thread.sleep(3000);
    
    WebElement opcaoAte3 = driver.findElement(By.xpath("//option[@value='3']"));
    opcaoAte3.click();
    Thread.sleep(3000);

    // Clicar no botão de "mês" 
    WebElement bmes12 = driver.findElement(By.xpath("(//select[@name='x[month]'])[1]"));
    bmes12.click();
    Thread.sleep(3000);
    
    WebElement opcaoAte12 = driver.findElement(By.xpath("//select[@name='x//option[@value='12'][normalize-space()='dezembro']"));
    opcaoAte12.click();
    Thread.sleep(3000);

    // Clicar no botão de "ano" 
    WebElement ano22 = driver.findElement(By.xpath("(//select[@name='x[year]'])[1]"));
    ano22.click();
    Thread.sleep(3000);
    
    WebElement opcaod2022 = driver.findElement(By.xpath("//option[@selected='selected'][normalize-space()='2022']"));
    opcaod2022.click();
    Thread.sleep(3000);

    // Clicar no botão de "horas" 
    WebElement bhoras = driver.findElement(By.xpath("(//select[@name='x[hour]'])[1]"));
    bhoras.click();
    Thread.sleep(3000);
    
    WebElement opcaob0 = driver.findElement(By.xpath("//select[@name='x//option[@value='0'][normalize-space()='00']"));
    opcaob0.click();
    Thread.sleep(3000);

    // Clicar no botão de "minutos" 
    WebElement bminutos = driver.findElement(By.xpath("(//select[@name='x[minute]'])[1]"));
    bminutos.click();
    Thread.sleep(3000);
    
    WebElement opcaob00 = driver.findElement(By.xpath("//select[@name='x//option[@value='0'][normalize-space()='00']"));
    opcaob00.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void restringirAcessoNota() throws InterruptedException, IOException, ParseException{

    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcessN = driver.findElement(By.xpath("//a[@id='collapseElement-5']"));
    restringirAcessN.click();
    Thread.sleep(2000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestrin = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestrin.click();
    Thread.sleep(2000);
    
    WebElement opcaoNota = driver.findElement(By.xpath("//button[@id='availability_addrestriction_grade']"));
    opcaoNota.click();
    Thread.sleep(3000);

    // Clicar no botão "Escolher"
    WebElement bescolherFinal = driver.findElement(By.xpath("//select[@id='yui_3_17_2_1_1669638217209_2452']"));
    bescolherFinal.click();
    Thread.sleep(2000);
    
    WebElement opcaoAN99 = driver.findElement(By.xpath("//option[@value='99']"));
    opcaoAN99.click();
    Thread.sleep(3000);

    // Clicar no botão "Dever ser >"
    WebElement botaoDeve = driver.findElement(By.xpath("//input[@id='yui_3_17_2_1_1669638217209_2461']"));
    botaoDeve.click();
    Thread.sleep(2000);

    // Clicar no campo "Dever ser >"
    WebElement campDeves = driver.findElement(By.xpath("//input[@id='yui_3_17_2_1_1669638217209_2470']"));
    campDeves.click();
    Thread.sleep(2000);
    campDeves.sendKeys(obj.get("notaAprovacao").toString());

    // Clicar no botão "Deve ser <"
    WebElement botaoDeveS = driver.findElement(By.xpath("//input[@name='max']"));
    botaoDeveS.click();
    Thread.sleep(2000);

    // Clicar no campo "Deve ser <"	
    WebElement campoDeveSer = driver.findElement(By.xpath("//input[@id='yui_3_17_2_1_1669638217209_2541']"));
    campoDeveSer.click();
    Thread.sleep(2000);
    campoDeveSer.sendKeys(obj.get("numeroMaximo").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

@Test
public void restringirAcessoGrupo() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcessg = driver.findElement(By.xpath("//a[@id='collapseElement-5']"));
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
    WebElement botaoAdRestriescolher = driver.findElement(By.xpath("//select[@id='yui_3_17_2_1_1669638217209_2775']"));
    botaoAdRestriescolher.click();
    Thread.sleep(2000);
    
    WebElement opcaoEuMesmo2 = driver.findElement(By.xpath("//option[normalize-space()='Eu mesmo']"));
    opcaoEuMesmo2.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void restringirAcessoPerfilUsuario() throws InterruptedException, IOException, ParseException{

                
    JSONObject obj = new JSONObject();
    JSONParser parser = new JSONParser();
    obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Restringir acesso"
    WebElement restringirAcessN = driver.findElement(By.xpath("//a[@id='collapseElement-5']"));
    restringirAcessN.click();
    Thread.sleep(2000);

    // Clicar no botão de "Adicionar restrição"
    WebElement botaoAdRestrin = driver.findElement(By.xpath("//button[normalize-space()='Adicionar restrição...']"));
    botaoAdRestrin.click();
    Thread.sleep(2000);
    
    WebElement opcaoPerfilU = driver.findElement(By.xpath("//button[@id='availability_addrestriction_profile']"));
    opcaoPerfilU.click();
    Thread.sleep(3000);

    // Clicar no botão "Escolher"
    WebElement bescolherNumId = driver.findElement(By.xpath("//select[@id='yui_3_17_2_1_1669638217209_3216']"));
    bescolherNumId.click();
    Thread.sleep(2000);
    
    WebElement opcaoNumId8 = driver.findElement(By.xpath("//option[@value='sf_idnumber']"));
    opcaoNumId8.click();
    Thread.sleep(3000);

    //  Clicar no botão "Método de comparação"
    WebElement botaoMetodoC = driver.findElement(By.xpath("//select[@title='Método de comparação']"));
    botaoMetodoC.click();
    Thread.sleep(2000);

    WebElement opcaoEigual = driver.findElement(By.xpath("//option[@value='isequalto']"));
    opcaoEigual.click();
    Thread.sleep(3000);

    // Clicar no campo "Valor a comparar"
    WebElement campoValorCopm = driver.findElement(By.xpath("//input[@id='yui_3_17_2_1_1669638217209_3295']"));
    campoValorCopm.click();
    Thread.sleep(2000);
    campoValorCopm.sendKeys(obj.get("suaMatricula").toString());

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);
        
}

@Test
public void conclusaoAtividadeNaoIndicar() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Conclusão de atividade"
    WebElement conclusaoAtividad = driver.findElement(By.xpath("//a[@id='collapseElement-6']"));
    conclusaoAtividad.click();
    Thread.sleep(2000);

    // Clicar no botão "Acompanhamento de conclusão"
    WebElement botaoAcompanhamentoC = driver.findElement(By.xpath("//select[@id='id_completion']"));
    botaoAcompanhamentoC.click();
    Thread.sleep(2000);
    
    WebElement opcaoNaoIndicar = driver.findElement(By.xpath("//option[normalize-space()='Não indicar a conclusão de atividade']"));
    opcaoNaoIndicar.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void conclusaoAtividadeEstudantes() throws InterruptedException, IOException{

    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Conclusão de atividade"
    WebElement conclusaoAtividad = driver.findElement(By.xpath("//a[@id='collapseElement-6']"));
    conclusaoAtividad.click();
    Thread.sleep(2000);

    // Clicar no botão "Acompanhamento de conclusão"
    WebElement botaoAcompanhamentoCE = driver.findElement(By.xpath("//select[@id='id_completion']"));
    botaoAcompanhamentoCE.click();
    Thread.sleep(2000);
    
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
    
    WebElement opcaodia3 = driver.findElement(By.xpath("//option[@value='3']"));
    opcaodia3.click();
    Thread.sleep(3000);

    // Clicar no botão de "mês" 
    WebElement bmesE = driver.findElement(By.xpath("//select[@id='id_completionexpected_month']"));
    bmesE.click();
    Thread.sleep(3000);
    
    WebElement opcaomes12 = driver.findElement(By.xpath("//option[@value='12']"));
    opcaomes12.click();
    Thread.sleep(3000);

    // Clicar no botão de "ano" 
    WebElement banoE = driver.findElement(By.xpath("//select[@id='id_completionexpected_year']"));
    banoE.click();
    Thread.sleep(3000);
    
    WebElement opcaoanoE2022 = driver.findElement(By.xpath("//option[@value='2022']"));
    opcaoanoE2022.click();
    Thread.sleep(3000);

    // Clicar no botão de "horas" 
    WebElement bhorasE = driver.findElement(By.xpath("//select[@id='id_completionexpected_hour']"));
    bhorasE.click();
    Thread.sleep(3000);
    
    WebElement opcaohoraE0 = driver.findElement(By.xpath("//option[@value='0']"));
    opcaohoraE0.click();
    Thread.sleep(3000);

    // Clicar no botão de "minutos" 
    WebElement bminutos0 = driver.findElement(By.xpath("//select[@id='id_completionexpected_minute']"));
    bminutos0.click();
    Thread.sleep(3000);
    
    WebElement opcaominut00 = driver.findElement(By.xpath("//option[@value='0']"));
    opcaominut00.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}


@Test
public void conclusaoAtividadeSatisfeitas() throws InterruptedException, IOException{


    driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");      


    // Clicar no botão "Modo de edição"
    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
    modoEdicao.click();
    Thread.sleep(2000);

    //Clicar no botão ">" de "Conclusão de atividade"
    WebElement conclusaoAtividadS = driver.findElement(By.xpath("//a[@id='collapseElement-6']"));
    conclusaoAtividadS.click();
    Thread.sleep(2000);

    // Clicar no botão "Acompanhamento de conclusão"
    WebElement botaoAcompanhamentoCS = driver.findElement(By.xpath("//select[@id='id_completion']"));
    botaoAcompanhamentoCS.click();
    Thread.sleep(2000);
    
    WebElement opcaocompS1 = driver.findElement(By.xpath("//option[contains(text(),'Mostrar atividade como concluída quando as condiçõ')]"));
    opcaocompS1.click();
    Thread.sleep(3000);

    // Clicar no botão "Requer visualização"	
    WebElement botaoRequerVisu = driver.findElement(By.xpath("//input[@id='id_completionview']"));
    botaoRequerVisu.click();
    Thread.sleep(2000);

    // Clicar no botão "Requer nota"
    WebElement botaoRequerNota = driver.findElement(By.xpath("//select[@id='id_completiongradeitemnumber']"));
    botaoRequerNota.click();
    Thread.sleep(2000);
    
    WebElement opcaoNObr1 = driver.findElement(By.xpath("//option[normalize-space()='Nota não obrigatória']"));
    opcaoNObr1.click();
    Thread.sleep(3000);

    // Clicar no botão "Requer mensagens"
    WebElement botaoRequerMensag = driver.findElement(By.xpath("//input[@id='id_completionpostsenabled']"));
    botaoRequerMensag.click();
    Thread.sleep(2000);

    // Clicar no botão "Requer discussões"
    WebElement botaoRequerDiscuss = driver.findElement(By.xpath("//input[@id='id_completiondiscussionsenabled']"));
    botaoRequerDiscuss.click();
    Thread.sleep(2000);

    // Clicar no botão "Habilitar"
    WebElement bhabilitarS = driver.findElement(By.xpath("//input[@id='id_completionexpected_enabled']"));
    bhabilitarS.click();
    Thread.sleep(2000);
    
    // Clicar no botão de "dia" 
    WebElement bdiaS = driver.findElement(By.xpath("//select[@id='id_completionexpected_day']"));
    bdiaS.click();
    Thread.sleep(3000);
    
    WebElement opcaodiaS3 = driver.findElement(By.xpath("//option[@value='3']"));
    opcaodiaS3.click();
    Thread.sleep(3000);

    // Clicar no botão de "mês" 
    WebElement bmesS = driver.findElement(By.xpath("//select[@id='id_completionexpected_month']"));
    bmesS.click();
    Thread.sleep(3000);
    
    WebElement opcaomesS12 = driver.findElement(By.xpath("//option[@value='12']"));
    opcaomesS12.click();
    Thread.sleep(3000);

    // Clicar no botão de "ano" 
    WebElement banoS = driver.findElement(By.xpath("//select[@id='id_completionexpected_year']"));
    banoS.click();
    Thread.sleep(3000);
    
    WebElement opcaoanoS2022 = driver.findElement(By.xpath("//option[@value='2022']"));
    opcaoanoS2022.click();
    Thread.sleep(3000);

    // Clicar no botão de "horas" 
    WebElement bhorasS = driver.findElement(By.xpath("//select[@id='id_completionexpected_hour']"));
    bhorasS.click();
    Thread.sleep(3000);
    
    WebElement opcaohoraS0 = driver.findElement(By.xpath("//option[@value='0']"));
    opcaohoraS0.click();
    Thread.sleep(3000);

    // Clicar no botão de "minutos" 
    WebElement bminutosS0 = driver.findElement(By.xpath("//select[@id='id_completionexpected_minute']"));
    bminutosS0.click();
    Thread.sleep(3000);
    
    WebElement opcaominutS00 = driver.findElement(By.xpath("//option[@value='0']"));
    opcaominutS00.click();
    Thread.sleep(3000);

    // Clicar no botão "Salvar e voltar"
    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
    salvarVoltar.click();
    Thread.sleep(2000);

}

    @Test
    public void tags() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));
    
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");


        // Clicar no botão "Modo de edição"
        WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
        modoEdicao.click();
        Thread.sleep(2000);

        //Clicar no botão ">" de "Tags"
        WebElement botaotag = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
        botaotag.click();
        Thread.sleep(2000);

        // Clicar em no campo "Inserir tags"
        WebElement campoTag = driver.findElement(By.xpath("//input[@id='form_autocomplete_input-1669638217343']"));
        campoTag.click();
        Thread.sleep(2000);
        campoTag.sendKeys(obj.get("tags").toString());

        WebElement opcaoTag = driver.findElement(By.xpath("//button[@id='availability_addrestriction_profile']"));
        opcaoTag.click();
        Thread.sleep(3000);

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar.click();
        Thread.sleep(2000);

    }


    @Test
    public void compentencias() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\tales\\OneDrive\\Área de Trabalho\\Marco2\\dadosJ.json"));
    
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=3178&return=1");

        // Clicar no botão "Modo de edição"
        WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
        modoEdicao.click();
        Thread.sleep(2000);

        //Clicar no botão ">" de "Competências"
        WebElement botaoCompetencia = driver.findElement(By.xpath("//a[@id='collapseElement-8']"));
        botaoCompetencia.click();
        Thread.sleep(2000);

        // Clicar no botão "Competências do curso"
        WebElement campoCompetencia = driver.findElement(By.xpath("//input[@id='form_autocomplete_input-1669638217344']"));
        campoCompetencia.click();
        Thread.sleep(2000);
        campoCompetencia.sendKeys(obj.get("campoNome").toString());

        // Clicar no botão "Após conclusão da atividade:"
        WebElement botaoAposCon = driver.findElement(By.xpath("//select[@id='id_competency_rule']"));
        botaoAposCon.click();
        Thread.sleep(2000);

        WebElement opcaoAnexarE = driver.findElement(By.xpath("//option[normalize-space()='Anexar evidência']"));
        opcaoAnexarE.click();
        Thread.sleep(3000);

        // Clicar no botão "Salvar e voltar"
        WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
        salvarVoltar.click();
        Thread.sleep(2000);

    }

    @Test
    public void excluirGlossarioPrincipal() throws InterruptedException, IOException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        
        //clicar no botão "Editar" de Glossário
        WebElement editarGlossário = driver.findElement(By.xpath("//div[@data-activityname='Glossário']//i[@title='Editar']"));
        editarGlossário.click();
        Thread.sleep(3000);
        // Clicar na opção "Exluir"
        WebElement opcaoExcluir = driver.findElement(By.xpath("(//span[contains (@class, 'menu-action-text')][normalize-space()='Excluir'])[6]"));
        opcaoExcluir.click();
        Thread.sleep(2000);
        //Clicar no botão "Sim"
        WebElement opcaosim = driver.findElement(By.xpath("//button[normalize-space()='Sim']"));
        opcaosim.click();
        Thread.sleep(3000);
    }
        
}
