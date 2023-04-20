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


public class TestsForum{

    private WebDriver driver = new ChromeDriver();


    @Before
    public void setUp() throws IOException, CsvValidationException, InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\chromedriver.exe");
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/mod/forum/view.php?id=1784");
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
    public void criarForumGeral() throws InterruptedException, IOException, CsvValidationException{
        //try{
            String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
            CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
            String [] cell;

            while ((cell = reader.readNext()) != null) {
                for (int i=0; i<1; i++) {
                 
                    String nomeForum = cell[0];
                    String descricao = cell[1];
                

                    // Clicar no botão "Adicionar tópico de discussão"
                    WebElement modoEdicao = driver.findElement(By.xpath("//a[normalize-space()='Adicionar tópico de discussão']"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Adicionar uma atividade ou recurso" do tópico geral
                    WebElement adicionarRecurso = driver.findElement(By.xpath("(//span[@class='activity-add-text'][normalize-space()='Adicionar uma atividade ou recurso'])[1]"));
                    if(adicionarRecurso.isDisplayed()){
                        adicionarRecurso.click();
                    }
                    
                    Thread.sleep(2000);

                    // Clicar no recurso "Fórum"
                    WebElement recursoUrl = driver.findElement(By.xpath("//a[@title='Adicionar um novo Fórum']"));
                    recursoUrl.click();

                    // Preencher o campo "Nome do Fórum"
                    WebElement campoNome = driver.findElement(By.xpath("//input[@id='id_name']"));
                    campoNome.click();
                    Thread.sleep(2000);
                    campoNome.sendKeys(nomeForum);

                    // Preencher o campo "Descrição"
                    WebElement descricaoUm = driver.findElement(By.xpath("//div[@id='id_introeditoreditable']"));
                    descricaoUm.click();
                    Thread.sleep(2000);
                    descricaoUm.sendKeys(descricao);

                    // Clicar no botão "Exibir descrição na página do curso"
                    WebElement exibirDescricao = driver.findElement(By.xpath("//input[@id='id_showdescription']"));
                    exibirDescricao.click();
                    Thread.sleep(2000);

                    //Clicar tipo de Fórum - Fórum geral
                    WebElement tipoForum = driver.findElement(By.xpath("//select[@id='id_type']"));
                    tipoForum.click();
                    Thread.sleep(2000);
            
                    WebElement opcao2 = driver.findElement(By.xpath("//option[@value='general']"));
                    opcao2.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

                    String mensagem = cell [0];

                    Assert.assertTrue(driver.getPageSource().contains(mensagem));
                    
            }
        }
    //  } catch (Exception e) {
    //         System.out.println("Erro ao fazer ao o forúm");
    //  }

    }



@Test
    public void disponibilidadeDataDeEntrega() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Disponibilidade"
                    WebElement botao = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
                    botao.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Habilitar"
                    WebElement habilitar = driver.findElement(By.xpath("//input[@id='id_duedate_enabled']"));
                    habilitar.click();
                    Thread.sleep(2000);
                    

                    // Clicar no botão de "dia" 
                    WebElement dia = driver.findElement(By.xpath("//select[@id='id_duedate_day']"));
                    dia.click();
                    Thread.sleep(3000);
                    
                    WebElement opcao3 = driver.findElement(By.xpath("//option[@value='3']"));
                    opcao3.click();
                    Thread.sleep(3000);

                    // Clicar no botão de "mês" 
                    WebElement mes = driver.findElement(By.xpath("//select[@id='id_duedate_month']//option[@value='12'][normalize-space()='dezembro']"));
                    mes.click();
                    Thread.sleep(3000);
                    
                    WebElement opcao12 = driver.findElement(By.xpath("//option[@value='12']"));
                    opcao12.click();
                    Thread.sleep(3000);

                    // Clicar no botão de "ano" 
                    WebElement ano = driver.findElement(By.xpath("//select[@id='id_duedate_year']"));
                    ano.click();
                    Thread.sleep(3000);
                    
                    WebElement opcao2022 = driver.findElement(By.xpath("//option[@value='2022']"));
                    opcao2022.click();
                    Thread.sleep(3000);

                    // Clicar no botão de "horas" 
                    WebElement horas = driver.findElement(By.xpath("//select[@id='id_duedate_hour']"));
                    horas.click();
                    Thread.sleep(3000);
                    
                    WebElement opcao0 = driver.findElement(By.xpath("//option[@value='0']"));
                    opcao0.click();
                    Thread.sleep(3000);

                    // Clicar no botão de "minutos" 
                    WebElement minutos = driver.findElement(By.xpath("//select[@id='id_duedate_minute']"));
                    minutos.click();
                    Thread.sleep(3000);
                    
                    WebElement opcao00 = driver.findElement(By.xpath("//option[@value='0']"));
                    opcao00.click();
                    Thread.sleep(3000);
                    
                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }


@Test
    public void disponibilidadeDataLimite() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Disponibilidade"
                    WebElement botao = driver.findElement(By.xpath("//a[@id='collapseElement-1']"));
                    botao.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Habilitar"
                    WebElement habilitar = driver.findElement(By.xpath("//input[@id='id_cutoffdate_enabled']"));
                    habilitar.click();
                    Thread.sleep(2000);
                    

                    // Clicar no botão de "dia" 
                    WebElement bdia = driver.findElement(By.xpath("//select[@id='id_cutoffdate_day']"));
                    bdia.click();
                    Thread.sleep(2000);
                    
                    WebElement opcao4 = driver.findElement(By.xpath("//option[@value='4']"));
                    opcao4.click();
                    Thread.sleep(2000);

                    // Clicar no botão de "mês" 
                    WebElement bmes = driver.findElement(By.xpath("//select[@id='id_cutoffdate_month']"));
                    bmes.click();
                    Thread.sleep(2000);
                    
                    WebElement opcao12 = driver.findElement(By.xpath("//option[@value='12']"));
                    opcao12.click();
                    Thread.sleep(2000);

                    // Clicar no botão de "ano" 
                    WebElement ano = driver.findElement(By.xpath("//select[@id='id_cutoffdate_year']"));
                    ano.click();
                    Thread.sleep(2000);
                    
                    WebElement opcao2022 = driver.findElement(By.xpath("//option[@value='2022']"));
                    opcao2022.click();
                    Thread.sleep(2000);

                    // Clicar no botão de "horas" 
                    WebElement bhoras = driver.findElement(By.xpath("//select[@id='id_cutoffdate_hour']"));
                    bhoras.click();
                    Thread.sleep(2000);
                    
                    WebElement opcao3 = driver.findElement(By.xpath("//option[@value='3']"));
                    opcao3.click();
                    Thread.sleep(2000);

                    // Clicar no botão de "minutos" 
                    WebElement bminutos = driver.findElement(By.xpath("//select[@id='id_cutoffdate_minute']"));
                    bminutos.click();
                    Thread.sleep(2000);
                    
                    WebElement opcao59 = driver.findElement(By.xpath("//option[@value='59']"));
                    opcao59.click();
                    Thread.sleep(2000);
                    
                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }


@Test
    public void anexosEcontadorDepalavras() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Anexos e contador de palavras"
                    WebElement botaoAnexos = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
                    botaoAnexos.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Tamanho máximo do anexo"
                    WebElement tamanhoAnexo = driver.findElement(By.xpath("//select[@id='id_maxbytes']"));
                    tamanhoAnexo.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoT2 = driver.findElement(By.xpath("//option[@value='536870912']"));
                    opcaoT2.click();
                    Thread.sleep(3000);


                    // Clicar no botão "Número máximo de arquivos anexados"	 
                    WebElement mArquivos = driver.findElement(By.xpath("//select[@id='id_maxattachments']"));
                    mArquivos.click();
                    Thread.sleep(3000);
                    
                    WebElement opcaoM2 = driver.findElement(By.xpath("//option[@value='2']"));
                    opcaoM2.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Mostrar contagem de palavras" 
                    WebElement contagemPalavras = driver.findElement(By.xpath("//select[@id='id_displaywordcount']"));
                    contagemPalavras.click();
                    Thread.sleep(3000);
                    
                    WebElement opcaoC0 = driver.findElement(By.xpath("//option[@value='0']"));
                    opcaoC0.click();
                    Thread.sleep(3000);
                    
                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }


@Test
    public void anexosEcontadorDepalavrasNãoPermitir() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Anexos e contador de palavras"
                    WebElement botaoAnexos = driver.findElement(By.xpath("//a[@id='collapseElement-2']"));
                    botaoAnexos.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Tamanho máximo do anexo"
                    WebElement tamanhoAnexo = driver.findElement(By.xpath("//select[@id='id_maxbytes']"));
                    tamanhoAnexo.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoT1 = driver.findElement(By.xpath("//option[normalize-space()='Não é permitido enviar arquivos']"));
                    opcaoT1.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }

@Test
    public void assinaturaEmonitoramento() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Assinatura e monitoramento"
                    WebElement botaoAssinatura = driver.findElement(By.xpath("//a[@id='collapseElement-3']"));
                    botaoAssinatura.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Modo de assinatura"
                    WebElement modoAssinatura = driver.findElement(By.xpath("//select[@id='id_forcesubscribe']"));
                    modoAssinatura.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoA0 = driver.findElement(By.xpath("//option[normalize-space()='Assinatura opcional']"));
                    opcaoA0.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Monitorar leitura"
                    WebElement monitorarLeitura = driver.findElement(By.xpath("//select[@id='id_trackingtype']"));
                    monitorarLeitura.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoL1 = driver.findElement(By.xpath("//option[normalize-space()='Opcional']"));
                    opcaoL1.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }

@Test
    public void bloqueioDeDiscussoesNaoBloquear() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Bloqueio de discussões"
                    WebElement naobloqD = driver.findElement(By.xpath("//a[@id='collapseElement-4']"));
                    naobloqD.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Bloquear discussões após período de inatividade"
                    WebElement naoBloquear = driver.findElement(By.xpath("//select[@id='id_lockdiscussionafter']"));
                    naoBloquear.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoN0 = driver.findElement(By.xpath("//option[normalize-space()='Não bloquear discussões']"));
                    opcaoN0.click();
                    Thread.sleep(3000);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }

@Test
    public void bloqueioDeDiscussoesBloquear() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Bloqueio de discussões"
                    WebElement bloqDiscussoes = driver.findElement(By.xpath("//a[@id='collapseElement-4']"));
                    bloqDiscussoes.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Bloquear discussões após período de inatividade"
                    WebElement tempoBloquear = driver.findElement(By.xpath("//select[@id='id_lockdiscussionafter']"));
                    tempoBloquear.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoBl1 = driver.findElement(By.xpath("//option[@value='86400']"));
                    opcaoBl1.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }

@Test
    public void limiteDeMensagenParaBloqueioN() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Limite de mensagens para bloqueio"
                    WebElement limiteM = driver.findElement(By.xpath("//a[@id='collapseElement-5']"));
                    limiteM.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Duração do bloqueio"
                    WebElement nBloquear = driver.findElement(By.xpath("//select[@id='id_blockperiod']"));
                    nBloquear.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoNao1 = driver.findElement(By.xpath("//option[normalize-space()='Não bloquear']"));
                    opcaoNao1.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }

@Test
    public void limiteDeMensagenParaBloqueio() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Limite de mensagens para bloqueio"
                    WebElement limiteMB = driver.findElement(By.xpath("//a[@id='collapseElement-5']"));
                    limiteMB.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Duração do bloqueio"
                    WebElement dBloquear = driver.findElement(By.xpath("//select[@id='id_blockperiod']"));
                    dBloquear.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoDb1 = driver.findElement(By.xpath("//option[@value='86400']"));
                    opcaoDb1.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }

/**
 * @throws InterruptedException
 * @throws IOException
 * @throws CsvValidationException
 */
@Test
    public void avaliacaoGlobalDoForumNenhum() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação global do fórum"
                    WebElement avaliacaoGlobal = driver.findElement(By.xpath("//a[@id='collapseElement-6']"));
                    avaliacaoGlobal.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Tipo" de nota
                    WebElement tipoNenhum = driver.findElement(By.xpath("//select[@id='id_grade_forum_modgrade_type']"));
                    tipoNenhum.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoTn1 = driver.findElement(By.xpath("//option[@value='none']"));
                    opcaoTn1.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }
 

/**
 * @throws InterruptedException
 * @throws IOException
 * @throws CsvValidationException
 */
@Test
    public void avaliacaoGlobalDoForumEscala() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
             
                String notaAprovacao = cell[3];
                

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação global do fórum"
                    WebElement avaliacaoGlobalE = driver.findElement(By.xpath("//a[@id='collapseElement-6']"));
                    avaliacaoGlobalE.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Tipo" de nota Escala de competência padrão
                    WebElement tipoEscala = driver.findElement(By.xpath("//select[@id='id_grade_forum_modgrade_scale']"));
                    tipoEscala.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoTec2 = driver.findElement(By.xpath("//option[@value='2']"));
                    opcaoTec2.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Método de avaliação"
                    WebElement metodoAvaliacaoE = driver.findElement(By.xpath("//select[@id='id_advancedgradingmethod_forum']"));
                    metodoAvaliacaoE.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoMa1 = driver.findElement(By.xpath("//option[normalize-space()='Método simples de avaliação']"));
                    opcaoMa1.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Nota para aprovação"	
                    WebElement notAprovacao = driver.findElement(By.xpath("//input[@id='id_gradepass_forum']"));
                    notAprovacao.click();
                    Thread.sleep(2000);
                    notAprovacao.sendKeys(notaAprovacao);
                    

                    // Clicar no botão "Configuração padrão para "Notificar os estudantes"	
                    WebElement notificarEst = driver.findElement(By.xpath("//select[@id='id_sendstudentnotifications_forum']"));
                    notificarEst.click();
                    Thread.sleep(2000);
                     
                    WebElement opcaoNe1 = driver.findElement(By.xpath("//option[@value='1']"));
                    opcaoNe1.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }


@Test
    public void avaliacaoGlobalDoForumPontos() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                String notaMaxima = cell [2];
                String notaAprov = cell[3];
                

                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação global do fórum"
                    WebElement avaliacaoGlobalP = driver.findElement(By.xpath("//a[@id='collapseElement-6']"));
                    avaliacaoGlobalP.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Tipo" de nota Pontos
                    WebElement tipoPonto = driver.findElement(By.xpath("//select[@id='id_grade_forum_modgrade_type']"));
                    tipoPonto.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoTP3 = driver.findElement(By.xpath("//option[@value='point']"));
                    opcaoTP3.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Nota máxima"	
                    WebElement notMaxima = driver.findElement(By.xpath("//input[@id='id_grade_forum_modgrade_point']"));
                    notMaxima.click();
                    Thread.sleep(2000);
                    notMaxima.sendKeys(notaMaxima);

                    // Clicar no botão "Método de avaliação"
                    WebElement metodoAvaliacaoP = driver.findElement(By.xpath("//select[@id='id_advancedgradingmethod_forum']"));
                    metodoAvaliacaoP.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoMap1 = driver.findElement(By.xpath("//option[normalize-space()='Método simples de avaliação']"));
                    opcaoMap1.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Nota para aprovação"	
                    WebElement notAprovacaop = driver.findElement(By.xpath("//input[@id='id_gradepass_forum']"));
                    notAprovacaop.click();
                    Thread.sleep(2000);
                    notAprovacaop.sendKeys(notaAprov);
                    

                    // Clicar no botão "Configuração padrão para "Notificar os estudantes"	
                    WebElement notificarEst = driver.findElement(By.xpath("//select[@id='id_sendstudentnotifications_forum']"));
                    notificarEst.click();
                    Thread.sleep(2000);
                     
                    WebElement opcaoNe1 = driver.findElement(By.xpath("//option[@value='1']"));
                    opcaoNe1.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                   Thread.sleep(2000);
            }
        }
    }

@Test
    public void avaliacaoNenhum() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaoNen = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
                    avaliacaoNen.click();
                    Thread.sleep(2000);

                    // Clicar no botão "tipo agregado"
                    WebElement tipoAgN = driver.findElement(By.xpath("//select[@id='id_assessed']"));
                    tipoAgN.click();
                    Thread.sleep(2000);
                    
                    WebElement opcaoAgN0 = driver.findElement(By.xpath("//option[normalize-space()='Nenhuma avaliação']"));
                    opcaoAgN0.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);

    }

/**
 * @throws InterruptedException
 * @throws IOException
 * @throws CsvValidationException
 */
@Test
    public void avaliacaoMediadasAvaliaçõesEscala() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String notAprova = cell[3];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaoE = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
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
                    
                    WebElement opcaoMAE1 = driver.findElement(By.xpath("//option[@value='scale']"));
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
                    notaAprova.sendKeys(notAprova);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }

@Test
    public void avaliacaoMediadasAvaliaçõesPontos() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {

                    String noMax = cell [2];
                    String notApr = cell[3];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaoP = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
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
                    campoNoMax.sendKeys(noMax);
                    
                    WebElement opcaoCE2 = driver.findElement(By.xpath("//option[@value='2']"));
                    opcaoCE2.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Nota para aprovação"
                    WebElement noAprova = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
                    noAprova.click();
                    Thread.sleep(2000);
                    noAprova.sendKeys(notApr);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }

@Test
    public void avaliacaoContagemEscala() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String notA = cell[3];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaoCe = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
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
                    notPA.sendKeys(notA);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }

@Test
    public void avaliacaoContagemPontos() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {

                    String notMaxi = cell [2];
                    String ntApr = cell[3];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaoCp = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
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
                    campNoMax.sendKeys(notMaxi);
                    
                    WebElement opcaoCE2 = driver.findElement(By.xpath("//option[@value='2']"));
                    opcaoCE2.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Nota para aprovação"
                    WebElement nA = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
                    nA.click();
                    Thread.sleep(2000);
                    nA.sendKeys(ntApr);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }

@Test
    public void avaliacaoMaximaEscala() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String notpA = cell[3];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaoMe = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
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
                    notPAp.sendKeys(notpA);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }

@Test
    public void avaliacaoMaximaPontos() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {

                    String nM = cell [2];
                    String notopA = cell[3];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaoMp = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
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
                    campNoM.sendKeys(nM);
                    
                    WebElement opcaoAm2 = driver.findElement(By.xpath("//option[@value='2']"));
                    opcaoAm2.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Nota para aprovação"
                    WebElement nAp = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
                    nAp.click();
                    Thread.sleep(2000);
                    nAp.sendKeys(notopA);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }

@Test
    public void avaliacaoMimimaEscala() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String notpAprovac = cell[3];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaoMIe = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
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
                    notPAmp.sendKeys(notpAprovac);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }
    
@Test
    public void avaliacaoMinimaPontos() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {

                    String ntMaxm = cell [2];
                    String notaparaAp = cell[3];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaoMiP = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
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
                    campNoMi.sendKeys(ntMaxm);
                    
                    WebElement opcaoAmi2 = driver.findElement(By.xpath("//option[@value='2']"));
                    opcaoAmi2.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Nota para aprovação"
                    WebElement nApr = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
                    nApr.click();
                    Thread.sleep(2000);
                    nApr.sendKeys(notaparaAp);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }
    
    
@Test
    public void avaliacaoSomaEscala() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String notpAprovacs = cell[3];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaoSe = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
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
                    notPAmpS.sendKeys(notpAprovacs);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }
    
@Test
    public void avaliacaoSomaPontos() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {

                    String notMaxms = cell [2];
                    String notaparaAps = cell[3];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Avaliação"
                    WebElement avaliacaosP = driver.findElement(By.xpath("//a[@id='collapseElement-7']"));
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
                    campNoSp.sendKeys(notMaxms);
                    
                    WebElement opcaoAsp2 = driver.findElement(By.xpath("//option[@value='2']"));
                    opcaoAsp2.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Nota para aprovação"
                    WebElement nottApro = driver.findElement(By.xpath("//input[@id='id_gradepass']"));
                    nottApro.click();
                    Thread.sleep(2000);
                    nottApro.sendKeys(notaparaAps);


                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }

@Test
    public void configuracoesComunsDeModulosMostrar() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String numeroIdent = cell[4];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Configurações comuns de módulos"
                    WebElement configComum = driver.findElement(By.xpath("//a[@id='collapseElement-8']"));
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
                    numeroIdentModulo.sendKeys(numeroIdent);

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
        }
    }

@Test
    public void configuracoesComunsDeModulosOcultar() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String numeroIdentific = cell[4];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Configurações comuns de módulos"
                    WebElement configComumM = driver.findElement(By.xpath("//a[@id='collapseElement-8']"));
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
                    campnumIdentModulo.sendKeys(numeroIdentific);

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
        }
    }

@Test
    public void restringirAcessoConclusaoAtividade() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Restringir acesso"
                    WebElement avaliacaoNen = driver.findElement(By.xpath("//a[@id='collapseElement-9']"));
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
    public void restringirAcessoDataDe() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Restringir acesso"
                    WebElement restringirAcesso = driver.findElement(By.xpath("//a[@id='collapseElement-9']"));
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
    public void restringirAcessoDataAte() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Restringir acesso"
                    WebElement restringirAcess = driver.findElement(By.xpath("//a[@id='collapseElement-9']"));
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
    public void restringirAcessoNota() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String notaMinimap = cell[3];
                    String notaMaximap = cell[2];


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Restringir acesso"
                    WebElement restringirAcessN = driver.findElement(By.xpath("//a[@id='collapseElement-9']"));
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
                    campDeves.sendKeys(notaMinimap);

                    // Clicar no botão "Deve ser <"
                    WebElement botaoDeveS = driver.findElement(By.xpath("//input[@name='max']"));
                    botaoDeveS.click();
                    Thread.sleep(2000);

                    // Clicar no campo "Deve ser <"	
                    WebElement campoDeveSer = driver.findElement(By.xpath("//input[@id='yui_3_17_2_1_1669638217209_2541']"));
                    campoDeveSer.click();
                    Thread.sleep(2000);
                    campoDeveSer.sendKeys(notaMaximap );

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }

@Test
    public void restringirAcessoGrupo() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Restringir acesso"
                    WebElement restringirAcessg = driver.findElement(By.xpath("//a[@id='collapseElement-9']"));
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
    public void restringirAcessoPerfilUsuario() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String valorComparacao = cell[6];
                


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Restringir acesso"
                    WebElement restringirAcessN = driver.findElement(By.xpath("//a[@id='collapseElement-9']"));
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
                    campoValorCopm.sendKeys(valorComparacao);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }

@Test
    public void conclusaoAtividadeNaoIndicar() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Conclusão de atividade"
                    WebElement conclusaoAtividad = driver.findElement(By.xpath("//a[@id='collapseElement-10']"));
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
    public void conclusaoAtividadeEstudantes() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Conclusão de atividade"
                    WebElement conclusaoAtividad = driver.findElement(By.xpath("//a[@id='collapseElement-10']"));
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
    public void conclusaoAtividadeSatisfeitas() throws InterruptedException, IOException, CsvValidationException{

            
            driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Conclusão de atividade"
                    WebElement conclusaoAtividadS = driver.findElement(By.xpath("//a[@id='collapseElement-10']"));
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
    public void tags() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String tag = cell[5];
                


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Tags"
                    WebElement botaotag = driver.findElement(By.xpath("//a[@id='collapseElement-11']"));
                    botaotag.click();
                    Thread.sleep(2000);

                    // Clicar em no campo "Inserir tags"
                    WebElement campoTag = driver.findElement(By.xpath("//input[@id='form_autocomplete_input-1669638217343']"));
                    campoTag.click();
                    Thread.sleep(2000);
                    campoTag.sendKeys(tag);

                    WebElement opcaoTag = driver.findElement(By.xpath("//button[@id='availability_addrestriction_profile']"));
                    opcaoTag.click();
                    Thread.sleep(3000);

                    // Clicar no botão "Salvar e voltar"
                    WebElement salvarVoltar = driver.findElement(By.xpath("//input[@id='id_submitbutton2']"));
                    salvarVoltar.click();
                    Thread.sleep(2000);
            }
        }
    }

@Test
    public void compentencias() throws InterruptedException, IOException, CsvValidationException{

        String CSV = "C:\\Users\\Pichau\\OneDrive\\Área de Trabalho\\Marco2\\dadosForum.csv";
        CSVReader reader = new CSVReader(new FileReader(CSV, StandardCharsets.ISO_8859_1));
        String [] cell;
        driver.navigate().to("https://gmlunardi.pro.br/moodlerp2/course/modedit.php?update=1784&return=0&sr=0");

        while ((cell = reader.readNext()) != null) {
            for (int i=0; i<1; i++) {
                
                    String competencia = cell[7];
                


                    // Clicar no botão "Modo de edição"
                    WebElement modoEdicao = driver.findElement(By.className("editmode-switch-form"));
                    modoEdicao.click();
                    Thread.sleep(2000);

                    //Clicar no botão ">" de "Competências"
                    WebElement botaoCompetencia = driver.findElement(By.xpath("//a[@id='collapseElement-12']"));
                    botaoCompetencia.click();
                    Thread.sleep(2000);

                    // Clicar no botão "Competências do curso"
                    WebElement campoCompetencia = driver.findElement(By.xpath("//input[@id='form_autocomplete_input-1669638217344']"));
                    campoCompetencia.click();
                    Thread.sleep(2000);
                    campoCompetencia.sendKeys(competencia);

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
        }
    }
}