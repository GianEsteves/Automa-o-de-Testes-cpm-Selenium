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


public class TestsWikiDiscente{

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
        Thread.sleep(2000);

        //Preencher o campo "Senha" com sua senha
        WebElement senhaUsuario = driver.findElement(By.id("password"));
        senhaUsuario.click();
        senhaUsuario.sendKeys(obj.get("matricula").toString());
        Thread.sleep(2000);

        // Clicar em acessar
        WebElement  acessarBotao = driver.findElement(By.id("loginbtn"));
        acessarBotao.click();
        Thread.sleep(2000);

        // Clicar no item "Meus cursos"
        WebElement  itemMeuCurso = driver.findElement(By.xpath("//a[@role='menuitem'][normalize-space()='Meus cursos']"));
        itemMeuCurso.click();
        Thread.sleep(3000);

        // Clicar no curso "Introdução a Algoritmos e Progamação com Jogos Digitais"
        WebElement  cursoIntroducao = driver.findElement(By.xpath("//span[@class='multiline']"));
        cursoIntroducao.click();
        Thread.sleep(3000);

        // Clicar no botão ">" do tópico "Wiki"
        WebElement  topicoWiki = driver.findElement(By.xpath("//a[@aria-label='Wiki']"));
        topicoWiki.click();
        Thread.sleep(2000);
        
        // Clicar na wiki "Jogos e algoritmos colaborativos"
        WebElement  wikiJogos = driver.findElement(By.xpath("(//a[@class=' conditionalhidden aalink stretched-link'])[3]"));
        wikiJogos.click();
        Thread.sleep(2000);
    
    }


    @Test
    public void editarWikiModoColaborativo() throws InterruptedException, IOException, ParseException{
                

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

        //driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");

        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar.click();
        Thread.sleep(5000);

        // Selecionar a opção "Editar"
        WebElement opcaoEditar = driver.findElement(By.xpath("//option[@value='/mod/wiki/edit.php?pageid=71']"));
        opcaoEditar.click();
        Thread.sleep(5000);

        // Clicar no campo "Formato HTML"						Preencher com ""
        WebElement campoFormato = driver.findElement(By.xpath("//div[@role='textbox']"));
        campoFormato.click();
        Thread.sleep(2000);
        campoFormato.sendKeys(obj.get("formatoHTML").toString());

        // Clicar no botão "Pré visualizar"
        WebElement botaoEditar = driver.findElement(By.xpath("//input[@value='Pré visualizar']"));
        botaoEditar.click();
        Thread.sleep(5000);

        // Clicar no botão "Salvar mudanças"
        WebElement salvar = driver.findElement(By.xpath("//input[@value='Salvar']"));
        salvar.click();
        Thread.sleep(2000);
                    
    }
    

@Test
    public void wikiEditarTag() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar1 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar1.click();
        Thread.sleep(3000);
        
        // Selecionar "Editar"
        WebElement opcaoEditar1 = driver.findElement(By.xpath("//option[@value='/mod/wiki/edit.php?pageid=71']"));
        opcaoEditar1.click();
        Thread.sleep(5000);

        //Clicar no campo "Tag"								Preencher com "XP"
        WebElement campoTag = driver.findElement(By.xpath("//input[@placeholder='Inserir tags...']"));
        campoTag.click();
        Thread.sleep(5000);
        campoTag.sendKeys(obj.get("campoTags").toString());
        Thread.sleep(2000);
        campoTag.sendKeys(Keys.ENTER);

        // Clicar no botão "Salvar"
        WebElement salvar1 = driver.findElement(By.xpath("//input[@value='Salvar']"));
        salvar1.click();
        Thread.sleep(2000);

    }

   

@Test
    public void wikiComentarios() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar2 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar2.click();
        Thread.sleep(5000);
        
        // Selecionar a opção "Comentários"
        WebElement opcaoComentario = driver.findElement(By.xpath("//option[@value='/mod/wiki/comments.php?pageid=71']"));
        opcaoComentario.click();
        Thread.sleep(3000);

        // Clicar no botão "Adicionar comentário"							
        WebElement adicionarComentario = driver.findElement(By.xpath("//a[normalize-space()='Adicionar comentário']"));
        adicionarComentario.click();
        Thread.sleep(3000);
        
        // Clicar no campo "Comentário"							Preencher com "TESTE2"
        WebElement campoComentario = driver.findElement(By.xpath("//div[@role='textbox']"));
        campoComentario.click();
        Thread.sleep(5000);
        campoComentario.sendKeys(obj.get("campoComentarios").toString());
        Thread.sleep(5000);

        // Clicar no botão "Salvar mudanças"
        WebElement salvarMudancas2 = driver.findElement(By.xpath("//input[@name='submitbutton']"));
        salvarMudancas2.click();
        Thread.sleep(2000);

    }


@Test
    public void wikiEditarComentario() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/comments.php?pageid=71");


        // Clicar no botão "Editar"
        WebElement botaoEditar2 = driver.findElement(By.xpath("(//i[@title='Editar'])[1]"));
        botaoEditar2.click();
        Thread.sleep(3000);

        // Clicar no campo "Comentário"							Alterar para  ""
        WebElement campoComentario1 = driver.findElement(By.xpath("(//div[@role='textbox'])[1]"));
        campoComentario1.click();
        Thread.sleep(2000);
        campoComentario1.clear();
        Thread.sleep(2000);
        campoComentario1.sendKeys(obj.get("editarComentario").toString());

        // Clicar no botão "Salvar mudanças"
        WebElement salvarMudancas3 = driver.findElement(By.xpath("(//input[@name='submitbutton'])[1]"));
        salvarMudancas3.click();
        Thread.sleep(2000);

    }

@Test
    public void wikiExcluirComentario() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/comments.php?pageid=71");


        // Clicar no botão "Excluir"
        WebElement botaoExcluir2 = driver.findElement(By.xpath("(//i[@title='Excluir'])[1]"));
        botaoExcluir2.click();
        Thread.sleep(3000);


        // Clicar no botão "Continuar"
        WebElement salvarMudancas3 = driver.findElement(By.xpath("//button[normalize-space()='Continuar']"));
        salvarMudancas3.click();
        Thread.sleep(2000);

    }


@Test
    public void wikiHistorico() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar3 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar3.click();
        Thread.sleep(3000);


        // Selecionar a opção "Histórico"
        WebElement opcaoHistorico = driver.findElement(By.xpath("//option[@value='/mod/wiki/history.php?pageid=71']"));
        opcaoHistorico.click();
        Thread.sleep(3000);

        // Clicar na versão "1"
        WebElement versao1 = driver.findElement(By.xpath("//tr[@class='wiki_histnewdate lastrow']//input[@name='compare']"));
        versao1.click();
        Thread.sleep(3000);

        // Clicar na versão "2"
        WebElement versao2 = driver.findElement(By.xpath("//tr[@class='wiki_histnewdate']//input[@name='comparewith']"));
        versao2.click();
        Thread.sleep(3000);

        // Clicar no botão "Comparar Selecionadas"
        WebElement compararSelecionadas = driver.findElement(By.xpath("//input[@value='Comparar selecionados']"));
        compararSelecionadas.click();
        Thread.sleep(3000);

        // Clicar no botão "Voltar"
        WebElement voltar = driver.findElement(By.xpath("//a[normalize-space()='Voltar']"));
        voltar.click();
        Thread.sleep(2000);

    }



@Test
    public void wikiMapaListaPaginas() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar4 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar4.click();
        Thread.sleep(3000);

        // Selecionar a opção "Mapa"
        WebElement opacaoMapaLista = driver.findElement(By.xpath("//option[@value='/mod/wiki/map.php?pageid=71']"));
        opacaoMapaLista.click();
        Thread.sleep(3000);

        // Clicar no botão "Menu de mapas"
        WebElement botaoMenuMapa = driver.findElement(By.xpath("(//select[@name='option'])[1]"));
        botaoMenuMapa.click();
        Thread.sleep(3000);
 
        // Selecionar a opção "Lista de páginas"
        WebElement opcaoListaPagina = driver.findElement(By.xpath("//option[@value='5']"));
        opcaoListaPagina.click();
        Thread.sleep(3000);

        // Clicar no botão " Jogos e algoritmos"
        WebElement jogosAlgoritmos = driver.findElement(By.xpath("//td[@class='cell c0 lastcol']//a[contains(text(),'Jogos e algoritmos')]"));
        jogosAlgoritmos.click();
        Thread.sleep(2000);

    }

@Test
    public void wikiMapaContribuicoes() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar5 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar5.click();
        Thread.sleep(3000);

        // Selecionar a opção "Mapa"
        WebElement opacaoMapaContribuicoes = driver.findElement(By.xpath("//option[@value='/mod/wiki/map.php?pageid=71']"));
        opacaoMapaContribuicoes.click();
        Thread.sleep(3000);

        // Clicar no botão "Menu de mapas"
        WebElement botaoMenuMapa1 = driver.findElement(By.xpath("(//select[@name='option'])[1]"));
        botaoMenuMapa1.click();
        Thread.sleep(3000);
 
        // Selecionar a opção "Contribuições"
        WebElement opcaoContribuicoes = driver.findElement(By.xpath("//option[@value='1']"));
        opcaoContribuicoes.click();
        Thread.sleep(3000);

        // Clicar no botão " Jogos e algoritmos"
        WebElement jogosAlgoritmos1 = driver.findElement(By.xpath("//td[@class='cell c0 lastcol']//a[contains(text(),'Jogos e algoritmos')]"));
        jogosAlgoritmos1.click();
        Thread.sleep(2000);

    }

    @Test
    public void wikiMapaLinks() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar6 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar6.click();
        Thread.sleep(3000);

        // Selecionar a opção "Mapa"
        WebElement opacaoMapaLinks = driver.findElement(By.xpath("//option[@value='/mod/wiki/map.php?pageid=71']"));
        opacaoMapaLinks.click();
        Thread.sleep(3000);

        // Clicar no botão "Menu de mapas"
        WebElement botaoMenuMapa2 = driver.findElement(By.xpath("(//select[@name='option'])[1]"));
        botaoMenuMapa2.click();
        Thread.sleep(3000);
 
        // Selecionar a opção "Links"
        WebElement opcaoLinks = driver.findElement(By.xpath("//option[@value='2']"));
        opcaoLinks.click();
        Thread.sleep(3000);

    }

@Test
    public void wikiMapaPaginasOrfas() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar7 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar7.click();
        Thread.sleep(3000);

        // Selecionar a opção "Mapa"
        WebElement opacaoMapaPaginasO = driver.findElement(By.xpath("//option[@value='/mod/wiki/map.php?pageid=71']"));
        opacaoMapaPaginasO.click();
        Thread.sleep(3000);

        // Clicar no botão "Menu de mapas"
        WebElement botaoMenuMapa3 = driver.findElement(By.xpath("(//select[@name='option'])[1]"));
        botaoMenuMapa3.click();
        Thread.sleep(3000);
 
        // Selecionar a opção "Páginas orfãs"
        WebElement opcaoPaginasOrfas = driver.findElement(By.xpath("//option[@value='3']"));
        opcaoPaginasOrfas.click();
        Thread.sleep(3000);

    }


@Test
    public void wikiMapaIndicePaginas() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar8 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar8.click();
        Thread.sleep(3000);

        // Selecionar a opção "Mapa"
        WebElement opacaoMapaIndicePaginas = driver.findElement(By.xpath("//option[@value='/mod/wiki/map.php?pageid=71']"));
        opacaoMapaIndicePaginas.click();
        Thread.sleep(3000);

        // Clicar no botão "Menu de mapas"
        WebElement botaoMenuMapa4 = driver.findElement(By.xpath("(//select[@name='option'])[1]"));
        botaoMenuMapa4.click();
        Thread.sleep(3000);
 
        // Selecionar a opção "Índice das páginas"
        WebElement opcaoIndicePaginas = driver.findElement(By.xpath("//option[@value='4']"));
        opcaoIndicePaginas.click();
        Thread.sleep(3000);

    }

 @Test
    public void wikiMapaPaginasAtualizadas() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar9 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar9.click();
        Thread.sleep(3000);

        // Selecionar a opção "Mapa"
        WebElement opacaoMapaPaginasAtualizadas = driver.findElement(By.xpath("//option[@value='/mod/wiki/map.php?pageid=71']"));
        opacaoMapaPaginasAtualizadas.click();
        Thread.sleep(3000);

        // Clicar no botão "Menu de mapas"
        WebElement botaoMenuMapa5 = driver.findElement(By.xpath("(//select[@name='option'])[1]"));
        botaoMenuMapa5.click();
        Thread.sleep(3000);
 
        // Selecionar a opção "Páginas atualizadas"
        WebElement opcaoPaginasAtualizadas = driver.findElement(By.xpath("//option[@value='6']"));
        opcaoPaginasAtualizadas.click();
        Thread.sleep(3000);

    }


@Test
    public void wikiArquivos() throws InterruptedException, IOException, ParseException{

        JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();
        obj = (JSONObject) parser.parse(new FileReader("C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2 ATUALIZADASSO\\dadosJ.json"));

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar10 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar10.click();
        Thread.sleep(3000);

        // Selecionar a opção "Arquivos"
        WebElement opacaoArquivos = driver.findElement(By.xpath("//option[@value='/mod/wiki/files.php?pageid=71']"));
        opacaoArquivos.click();
        Thread.sleep(3000);

        // Clicar no botão "Editar arquivos wiki"
        WebElement botaoEditarArquivos = driver.findElement(By.xpath("(//button[normalize-space()='Editar arquivos wiki'])[1]"));
        botaoEditarArquivos.click();
        Thread.sleep(3000);
 
        // Clicar no botão "Arquivos"
        WebElement botaoArquivos= driver.findElement(By.xpath("//div[@class='dndupload-message']//i[@class='fa fa-arrow-circle-o-down fa-3x m-auto']"));
        botaoArquivos.click();
        Thread.sleep(3000);

        // Clicar na botão "Escolher arquivo" 
        WebElement escolherArquivo = driver.findElement(By.xpath("(//input[@name='repo_upload_file'])[1]"));
        escolherArquivo.sendKeys(obj.get("filePath").toString());
        Thread.sleep(4000);

        // Clicar no botão de "Enviar este arquivo"
        WebElement botaoEnviarArquivo = driver.findElement(By.xpath("//button[normalize-space()='Enviar este arquivo']"));
        botaoEnviarArquivo.click();
        Thread.sleep(3000);

        // Clicar no botão "Salvar Mudanças"
        WebElement salvarMudancas6 = driver.findElement(By.xpath("//input[@name='submitbutton']"));
        salvarMudancas6.click();
        Thread.sleep(2000);

    }


@Test
    public void wikiAdministracaoRemoverPaginas() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=71");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar11 = driver.findElement(By.xpath("//select[@name='jump']"));
        botaoVisualizar11.click();
        Thread.sleep(3000);

        // Selecionar a opção "Administração"
        WebElement opacaoAdministracao = driver.findElement(By.xpath("//option[@value='/mod/wiki/admin.php?pageid=71']"));
        opacaoAdministracao.click();
        Thread.sleep(3000);

        // Clicar no botão "Menu administrativo"	
        WebElement botaoMenuAdministrativo = driver.findElement(By.xpath("(//select[@name='option'])[1]"));
        botaoMenuAdministrativo.click();
        Thread.sleep(3000);
        
        // Selecionar a opção "Remover páginas"
        WebElement opcaoRemoverPag = driver.findElement(By.xpath("(//option[@value='1'])[1]"));
        opcaoRemoverPag.click();
        Thread.sleep(3000);

        // Clicar no botão "Listar todos"
        WebElement botaoListarTodos = driver.findElement(By.xpath("(//input[@value='Listar todos'])[1]"));
        botaoListarTodos.click();
        Thread.sleep(3000);
 
        // Clicar no botão "Excluir página"
        WebElement botaoExcluirPagina = driver.findElement(By.xpath("(//i[@title='Excluir'])[1]"));
        botaoExcluirPagina.click();
        Thread.sleep(3000);

       
    }

@Test
    public void wikiAdministracaoExcluirPaginasVersoes() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=96");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar12 = driver.findElement(By.xpath("(//select[@name='jump'])[1]"));
        botaoVisualizar12.click();
        Thread.sleep(3000);

        // Selecionar a opção "Administração"
        WebElement opacaoAdministracao2 = driver.findElement(By.xpath("//option[@value='/mod/wiki/admin.php?pageid=96']"));
        opacaoAdministracao2.click();
        Thread.sleep(3000);

        // Clicar no botão "Menu administrativo"	
        WebElement botaoMenuAdministrativo2 = driver.findElement(By.xpath("(//select[@name='option'])[1]"));
        botaoMenuAdministrativo2.click();
        Thread.sleep(3000);
        
        // Selecionar a opção "Excluir páginas de versões"
        WebElement opcaoExcluirPagV = driver.findElement(By.xpath("(//option[@value='2'])[1]"));
        opcaoExcluirPagV.click();
        Thread.sleep(3000);

        // Clicar na versão "1"
        WebElement selecionarV1 = driver.findElement(By.xpath("(//input[@name='fromversion'])[2]"));
        selecionarV1.click();
        Thread.sleep(3000);

        // Clicar no botão "Excluir páginas de versões"
        WebElement opcaoExcluirPaginasVer = driver.findElement(By.xpath("//input[@value='Excluir páginas de versões']"));
        opcaoExcluirPaginasVer.click();
        Thread.sleep(3000);
 

       
    }

@Test
    public void wikiAdministracaoRestaurarVersoes() throws InterruptedException, IOException, ParseException{

        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/wiki/view.php?pageid=96");


        // Clicar no botão "Visualizar"
        WebElement botaoVisualizar13 = driver.findElement(By.xpath("(//select[@name='jump'])[1]"));
        botaoVisualizar13.click();
        Thread.sleep(3000);

        // Selecionar a opção "Administração"
        WebElement opacaoAdministracao3 = driver.findElement(By.xpath("//option[@value='/mod/wiki/admin.php?pageid=71']"));
        opacaoAdministracao3.click();
        Thread.sleep(3000);

        // Clicar no botão "Menu administrativo"	
        WebElement botaoMenuAdministrativo3 = driver.findElement(By.xpath("(//select[@name='option'])[1]"));
        botaoMenuAdministrativo3.click();
        Thread.sleep(3000);
        
        // Selecionar a opção "Excluir páginas de versões"
        WebElement opcaoExcluirPagV2 = driver.findElement(By.xpath("(//option[@value='2'])[1]"));
        opcaoExcluirPagV2.click();
        Thread.sleep(3000);

        // Clicar na versão "1"
        WebElement selecionarV1 = driver.findElement(By.xpath("(//a[normalize-space()='1'])[1]"));
        selecionarV1.click();
        Thread.sleep(3000);

        // Clicar no botão "Restaurar esta versão"
        WebElement opcaoRestaurarVer = driver.findElement(By.xpath("//a[normalize-space()='(Restaurar esta versão)']"));
        opcaoRestaurarVer.click();
        Thread.sleep(3000);
 
        // Clicar no botão "Sim"	
        WebElement opcaoSIM300 = driver.findElement(By.xpath("//input[@value='Excluir páginas de versões']"));
        opcaoSIM300.click();
        Thread.sleep(3000);
 
       
    }
}