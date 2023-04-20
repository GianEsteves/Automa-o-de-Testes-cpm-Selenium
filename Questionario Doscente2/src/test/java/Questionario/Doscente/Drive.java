package Questionario.Doscente;

import java.time.Duration;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//    Questionário na perspectiva do docente (Calculado, Cálculo simples, múltipla escolha calculada, respostas embutidas, 
//   selecionar as palavras que faltam). Testar a avaliação como docente também.



@DisplayName(" Questionario Docente ")
public class Drive {

    @Test
    @DisplayName(" 01 Titulo obrigatorio ")
    //o titulo é obrgatorio 
    public void tituloObrigatorio(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();

        // abre o questionario 
        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();

        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // adicona descricao 
        driver.findElement(By.xpath("//body//div//div[contains(@data-region,'mainpage')]//div//div//div[3]//div[2]//div[1]//div[1]//div[1]//div[3]//div[1]")).sendKeys("Descrição obrigatório [[1]]  ");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();
        String erro = driver.findElement(By.xpath("//div[contains(@data-fieldtype,'text')]//div[contains(@class,'form-control-feedback invalid-feedback')][normalize-space()='- Inserir um valor.']")).getText();
        AssertEquals.assertEquals(" - Inserir um valor.",erro);
        driver.quit();
        excluirQuestionarioJaExistente();

    }

    @Test
    @DisplayName(" 02 Descrção obrigatorio ")
    // a descrição éobtigatorio
    public void descricaoObrigatorio(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();   
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();  
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 
        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();

        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // adicona titulo 
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Titulo obrigatório  ");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();
        String erro = driver.findElement(By.xpath("//div[@id='id_error_questiontext']")).getText();
        AssertEquals.assertEquals(" - Inserir um valor.",erro);
        driver.quit();
        excluirQuestionarioJaExistente();
        
    }

    @Test
    @DisplayName(" 03  Selecione a palavra que falta ")
    // nao deixar espaço na descriçao para colocar a respostav 
    public void semEspaçoParaResposta(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
                // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        // adicona titulo
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Titulo obrigatório  ");

        // descricao sem espaço para a resposta 
        driver.findElement(By.xpath("//body//div//div[contains(@data-region,'mainpage')]//div//div//div[3]//div[2]//div[1]//div[1]//div[1]//div[3]//div[1]")).sendKeys("Descrição obrigatório  ");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();
        String erro = driver.findElement(By.xpath("//div[@id='id_error_questiontext']")).getText();
        AssertEquals.assertEquals("O texto da questão deve conter espaços reservados, como [[1]] para mostrar onde devem ir as palavras que faltam.",erro);
        driver.quit();
        excluirQuestionarioJaExistente();

    }

    @Test
    @DisplayName(" 04 Questão de seleção de palavras que faltam  ")
    // responder com a opção correta 
    public void responderCorretamente(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        // adicona titulo e descricao 
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão de seleção de palavras que faltam responder corretamente   ");
        driver.findElement(By.xpath("//body//div//div[contains(@data-region,'mainpage')]//div//div//div[3]//div[2]//div[1]//div[1]//div[1]//div[3]//div[1]")).sendKeys("Em [[4]] foi lançado o primeiro sistema operacional Windows   ");

        // adicona as respostas 
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[2]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("20 de novembro de 1995");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[5]")).sendKeys("20 de novembro de 1995");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[6]")).sendKeys("30 de fevereiro de 1997");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[7]")).sendKeys("20 de novembro de 1985");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[8]")).sendKeys("25 de novembro de 1997");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[9]")).sendKeys("20 de novembro de 2022");
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        // responder 
        driver.findElement(By.xpath("//a[normalize-space()='Introdução a Algoritmos e Programação com Jogos']")).click();
        driver.findElement(By.xpath("//div[contains(@data-activityname,'nome')]//a[contains(@class,'aalink stretched-link')]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Select se = new Select(driver.findElement(By.xpath("//p[@dir='ltr']//span//select")));
        se.selectByValue("4");
        driver.findElement(By.xpath("//input[@id='mod_quiz-next-nav']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();
        String acerto = driver.findElement(By.xpath("//div[@class='specificfeedback']")).getText();
        AssertEquals.assertEquals("Sua resposta está correta.", acerto);
        driver.quit();
        excluirQuestionarioJaExistente();

    }

    @Test
    @DisplayName(" 05 Questão de seleção de palavras que faltam  ")
    // respomder com a opção errada 
    public void responderErrado(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();   
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        // adicona titulo e descricao 
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão de seleção de palavras que faltam responder corretamente   ");
        driver.findElement(By.xpath("//body//div//div[contains(@data-region,'mainpage')]//div//div//div[3]//div[2]//div[1]//div[1]//div[1]//div[3]//div[1]")).sendKeys("Em [[4]] foi lançado o primeiro sistema operacional Windows   ");

        // adicona as respostas 
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[2]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("20 de novembro de 1995");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[5]")).sendKeys("20 de novembro de 1995");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[6]")).sendKeys("30 de fevereiro de 1997");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[7]")).sendKeys("20 de novembro de 1985");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[8]")).sendKeys("25 de novembro de 1997");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[9]")).sendKeys("20 de novembro de 2022");
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        // responder 
        driver.findElement(By.xpath("//a[normalize-space()='Introdução a Algoritmos e Programação com Jogos']")).click();
        driver.findElement(By.xpath("//div[contains(@data-activityname,'nome')]//a[contains(@class,'aalink stretched-link')]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Select se = new Select(driver.findElement(By.xpath("//p[@dir='ltr']//span//select")));
        se.selectByValue("3");
        driver.findElement(By.xpath("//input[@id='mod_quiz-next-nav']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();
        String erro = driver.findElement(By.xpath("//div[@class='specificfeedback']")).getText();
        AssertEquals.assertEquals("Sua resposta está incorreta.", erro);
        driver.quit();
        excluirQuestionarioJaExistente();

    }

    @Test
    @DisplayName(" 06 excluir pergunta sem resposta  ")
    // excluia  a pergunta sem resposta pq com resposta nao da 
    public void ExcluirPerguntaSemResposta(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();
        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        // adicona titulo e descricao 
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão de seleção de palavras que faltam responder corretamente   ");
        driver.findElement(By.xpath("//body//div//div[contains(@data-region,'mainpage')]//div//div//div[3]//div[2]//div[1]//div[1]//div[1]//div[3]//div[1]")).sendKeys("Em [[4]] foi lançado o primeiro sistema operacional Windows   ");

        // adicona as respostas 
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[2]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("20 de novembro de 1995");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[5]")).sendKeys("20 de novembro de 1995");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[6]")).sendKeys("30 de fevereiro de 1997");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[7]")).sendKeys("20 de novembro de 1985");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[8]")).sendKeys("25 de novembro de 1997");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[9]")).sendKeys("20 de novembro de 2022");
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.findElement(By.xpath("//i[@title='Excluir']")).click();
        driver.findElement(By.xpath("//input[@value='Sim']")).click();
        driver.quit();
        excluirQuestionarioJaExistente();

    }

    @Test
    @DisplayName(" 07 excluir questionario criando um novo  ")
    // auto explicativo 
    public void excluirQuestionarioCriandoUmNovo(){
                // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[@data-activityname='nome']//a[@role='button']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu menu dropdown-menu-right show']//span[@class='menu-action-text'][normalize-space()='Excluir']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Sim']")).click();
        driver.quit();

    }

    @Test
    @DisplayName(" 08 excluir questionario ja existente  ")
    // auto explicativo 
    public void excluirQuestionarioJaExistente(){
                // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//div[@data-activityname='nome']//a[@role='button']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu menu dropdown-menu-right show']//span[@class='menu-action-text'][normalize-space()='Excluir']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Sim']")).click();
        driver.quit();

    }

    @Test
    @DisplayName(" 05 Questão de seleção de palavras que faltam  ")
    // respomder com a opção errada com as opçoes embaralhadas 
    public void responderErradoEmbaralhando(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        // adicona titulo e descricao 
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão de seleção de palavras que faltam responder corretamente   ");
        driver.findElement(By.xpath("//body//div//div[contains(@data-region,'mainpage')]//div//div//div[3]//div[2]//div[1]//div[1]//div[1]//div[3]//div[1]")).sendKeys("Em [[4]] foi lançado o primeiro sistema operacional Windows   ");

        // adicona as respostas 
        driver.findElement(By.xpath("//input[@id='id_shuffleanswers']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[2]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("20 de novembro de 1995");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[5]")).sendKeys("20 de novembro de 1995");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[6]")).sendKeys("30 de fevereiro de 1997");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[7]")).sendKeys("20 de novembro de 1985");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[8]")).sendKeys("25 de novembro de 1997");
        driver.findElement(By.xpath("(//input[contains(@type,'text')])[9]")).sendKeys("20 de novembro de 2022");
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        // responder 
        driver.findElement(By.xpath("//a[normalize-space()='Introdução a Algoritmos e Programação com Jogos']")).click();
        driver.findElement(By.xpath("//div[contains(@data-activityname,'nome')]//a[contains(@class,'aalink stretched-link')]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Select se = new Select(driver.findElement(By.xpath("//p[@dir='ltr']//span//select")));
        se.selectByValue("3");
        driver.findElement(By.xpath("//input[@id='mod_quiz-next-nav']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();
        String erro = driver.findElement(By.xpath("//div[@class='specificfeedback']")).getText();
        AssertEquals.assertEquals("Sua resposta está incorreta.", erro);
        driver.quit();
        excluirQuestionarioJaExistente();

    }

    @Test
    @DisplayName(" Multipla escolha caulculada   ")
    // nao adiconar resposta 
    public void mecSemResposta(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculatedmulti']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // nome e descrição
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão 01");
        driver.findElement(By.xpath("//div[@id='id_questiontexteditable']")).sendKeys("Em que ano foi lançado o priemiro sistema opracional windonws");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // verificar se apareceu o erro por nao ter alternativa 
        String erro = driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[2]/form[1]/fieldset[2]/div[2]/div[1]/div[2]/div[1]")).getText();
        AssertEquals.assertEquals("Uma das opções deve ser 100% para que seja", erro);
        String erro1 = driver.findElement(By.xpath("//div[normalize-space()='Este tipo de questão requer pelo menos 2 opções']")).getText();
        AssertEquals.assertEquals("Este tipo de questão requer pelo menos 2 opções", erro1);



        driver.quit();

        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" Multipla escolha caulculada   ")
    // adcionar resposta mas sem nota 
    public void mecCriarRepostaSemNota(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculatedmulti']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // nome e descrião
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão 01");
        driver.findElement(By.xpath("//div[@id='id_questiontexteditable']")).sendKeys("Em que ano foi lançado o priemiro sistema opracional windonws");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        //
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("20 de zezembro de 1985");
        driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("30 de fevereiro de 1985");
        driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("20 de novembro de 1985");
        driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("um tempo atras");
        driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("29 de novembro de 1997");

        String erro = driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[2]/form[1]/fieldset[2]/div[2]/div[1]/div[2]/div[1]")).getText();
        AssertEquals.assertEquals("Uma das opções deve ser 100% para que seja", erro);
        driver.quit();
        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" Multipla escolha caulculada   ")
    // adcionar resposta com nota
    public void mecCriarRepostaComNota(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculatedmulti']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // nome e descrião
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão 01");
        driver.findElement(By.xpath("//div[@id='id_questiontexteditable']")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?  ");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // atibitu as respostas
        driver.findElement(By.xpath("//label[normalize-space()='Misturar as opções?']")).click();
        driver.findElement(By.xpath("//input[@id='id_addanswers']")).click();
        driver.findElement(By.xpath("//body//div//div[@data-region='mainpage']//div//div//div//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{z {t} * {w}}");
        Select se = new Select(driver.findElement(By.xpath("(//select)[5]")));
        se.selectByValue("1.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[4]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {t} * {w}}");
        Select se1 = new Select(driver.findElement(By.xpath("//div[10]//div[2]//fieldset[1]//div[1]//div[2]//span[1]//select[1]")));
        se1.selectByValue("0.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[7]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {x} * {w}}");
        Select se2 = new Select(driver.findElement(By.xpath("(//select)[11]")));
        se2.selectByValue("0.5");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();
        

        // Salvar
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.findElement(By.xpath("//input[@name='addbutton']")).click();
        driver.findElement(By.xpath("//input[@name='savechanges']")).click();

        driver.quit();
        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" Multipla escolha caulculada   ")
    // responder corretamente
    public void mecCriarRepostaCorreta(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculatedmulti']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // nome e descrião
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão 01");
        driver.findElement(By.xpath("//div[@id='id_questiontexteditable']")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?  ");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // atibitu as respostas
        driver.findElement(By.xpath("//label[normalize-space()='Misturar as opções?']")).click();
        driver.findElement(By.xpath("//input[@id='id_addanswers']")).click();
        driver.findElement(By.xpath("//body//div//div[@data-region='mainpage']//div//div//div//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{z {t} * {w}}");
        Select se = new Select(driver.findElement(By.xpath("(//select)[5]")));
        se.selectByValue("1.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[4]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {t} * {w}}");
        Select se1 = new Select(driver.findElement(By.xpath("//div[10]//div[2]//fieldset[1]//div[1]//div[2]//span[1]//select[1]")));
        se1.selectByValue("0.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[7]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {x} * {w}}");
        Select se2 = new Select(driver.findElement(By.xpath("(//select)[11]")));
        se2.selectByValue("0.5");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();
        

        // Salvar
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.findElement(By.xpath("//input[@name='addbutton']")).click();
        driver.findElement(By.xpath("//input[@name='savechanges']")).click();

        // Responder
        driver.findElement(By.xpath("//a[normalize-space()='Questionário']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@class='answer']//div[1]//input[1]")).click();
        driver.findElement(By.xpath("//input[@name='next']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();

        // Verificar 
        String erro = driver.findElement(By.xpath("//div[@class='specificfeedback']")).getText();
        AssertEquals.assertEquals("Sua resposta está correta.", erro);
        driver.quit();
        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" Multipla escolha caulculada   ")
    // resposta errada 
    public void mecCriarRepostaErrada(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculatedmulti']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // nome e descrião
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão 01");
        driver.findElement(By.xpath("//div[@id='id_questiontexteditable']")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?  ");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // atibitu as respostas
        driver.findElement(By.xpath("//label[normalize-space()='Misturar as opções?']")).click();
        driver.findElement(By.xpath("//input[@id='id_addanswers']")).click();
        driver.findElement(By.xpath("//body//div//div[@data-region='mainpage']//div//div//div//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{z {t} * {w}}");
        Select se = new Select(driver.findElement(By.xpath("(//select)[5]")));
        se.selectByValue("1.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[4]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {t} * {w}}");
        Select se1 = new Select(driver.findElement(By.xpath("//div[10]//div[2]//fieldset[1]//div[1]//div[2]//span[1]//select[1]")));
        se1.selectByValue("0.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[7]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {x} * {w}}");
        Select se2 = new Select(driver.findElement(By.xpath("(//select)[11]")));
        se2.selectByValue("0.5");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();
        

        // Salvar
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.findElement(By.xpath("//input[@name='addbutton']")).click();
        driver.findElement(By.xpath("//input[@name='savechanges']")).click();

        // Responder
        driver.findElement(By.xpath("//a[normalize-space()='Questionário']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//body//div//div[@role='main']//div//div//div//div//div//div//div[2]//input[1]")).click();
        driver.findElement(By.xpath("//input[@name='next']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();

        // Verificar 
        String erro = driver.findElement(By.xpath("//div[normalize-space()='Sua resposta está incorreta.']")).getText();
        AssertEquals.assertEquals("Sua resposta está incorreta.", erro);
        driver.quit();
        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" Multipla escolha caulculada   ")
    // resposta errada 
    public void mecCriarRepostaParcial(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculatedmulti']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // nome e descrião
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão 01");
        driver.findElement(By.xpath("//div[@id='id_questiontexteditable']")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?  ");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // atibitu as respostas
        driver.findElement(By.xpath("//label[normalize-space()='Misturar as opções?']")).click();
        driver.findElement(By.xpath("//input[@id='id_addanswers']")).click();
        driver.findElement(By.xpath("//body//div//div[@data-region='mainpage']//div//div//div//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{z {t} * {w}}");
        Select se = new Select(driver.findElement(By.xpath("(//select)[5]")));
        se.selectByValue("1.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[4]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {t} * {w}}");
        Select se1 = new Select(driver.findElement(By.xpath("//div[10]//div[2]//fieldset[1]//div[1]//div[2]//span[1]//select[1]")));
        se1.selectByValue("0.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[7]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {x} * {w}}");
        Select se2 = new Select(driver.findElement(By.xpath("(//select)[11]")));
        se2.selectByValue("0.5");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();
        

        // Salvar
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.findElement(By.xpath("//input[@name='addbutton']")).click();
        driver.findElement(By.xpath("//input[@name='savechanges']")).click();

        // Responder
        driver.findElement(By.xpath("//a[normalize-space()='Questionário']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@name='next']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();

        // Verificar 
        String erro = driver.findElement(By.xpath("//div[normalize-space()='Sua resposta está parcialmente correta.']")).getText();
        AssertEquals.assertEquals("Sua resposta está parcialmente correta.", erro);
        driver.quit();
        excluirQuestionarioJaExistente();

    }

    @Test
    @DisplayName(" Multipla escolha caulculada   ")
    // resposta embaralhada  
    public void mecCriarRepostaEmbaralhada(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculatedmulti']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // nome e descrião
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão 01");
        driver.findElement(By.xpath("//div[@id='id_questiontexteditable']")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?  ");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // atibitu as respostas
        //driver.findElement(By.xpath("//label[normalize-space()='Misturar as opções?']")).click();
        driver.findElement(By.xpath("//input[@id='id_addanswers']")).click();
        driver.findElement(By.xpath("//body//div//div[@data-region='mainpage']//div//div//div//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{z {t} * {w}}");
        Select se = new Select(driver.findElement(By.xpath("(//select)[5]")));
        se.selectByValue("1.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[4]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {t} * {w}}");
        Select se1 = new Select(driver.findElement(By.xpath("//div[10]//div[2]//fieldset[1]//div[1]//div[2]//span[1]//select[1]")));
        se1.selectByValue("0.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[7]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {x} * {w}}");
        Select se2 = new Select(driver.findElement(By.xpath("(//select)[11]")));
        se2.selectByValue("0.5");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();
        

        // Salvar
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.findElement(By.xpath("//input[@name='addbutton']")).click();
        driver.findElement(By.xpath("//input[@name='savechanges']")).click();

        // Responder
        driver.findElement(By.xpath("//a[normalize-space()='Questionário']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@name='next']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();

        // Verificar 
        String erro = driver.findElement(By.xpath("//div[normalize-space()='Sua resposta está parcialmente correta.']")).getText();
        AssertEquals.assertEquals("Sua resposta está parcialmente correta.", erro);
        driver.quit();
        excluirQuestionarioJaExistente();
    }
    
    @Test
    @DisplayName(" Multipla escolha caulculada   ")
    // resposta unica 
    // ERRO permite masi de uma resposta 
    public void mecCriarRepostaUnica(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculatedmulti']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // nome e descrião
        driver.findElement(By.xpath("//input[@id='id_name']")).sendKeys("Questão 01");
        driver.findElement(By.xpath("//div[@id='id_questiontexteditable']")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?  ");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();

        // atibitu as respostas
        driver.findElement(By.xpath("//label[normalize-space()='Misturar as opções?']")).click();
        driver.findElement(By.xpath("//input[@id='id_addanswers']")).click();
        driver.findElement(By.xpath("//body//div//div[@data-region='mainpage']//div//div//div//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{z {t} * {w}}");
        Select se = new Select(driver.findElement(By.xpath("(//select)[5]")));
        se.selectByValue("1.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[4]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {t} * {w}}");
        Select se1 = new Select(driver.findElement(By.xpath("//div[10]//div[2]//fieldset[1]//div[1]//div[2]//span[1]//select[1]")));
        se1.selectByValue("0.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[7]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{s {x} * {w}}");
        Select se2 = new Select(driver.findElement(By.xpath("(//select)[11]")));
        se2.selectByValue("0.5");
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();
        

        // Salvar
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.findElement(By.xpath("//input[@name='addbutton']")).click();
        driver.findElement(By.xpath("//input[@name='savechanges']")).click();

        // mudar para aluno 
        driver.findElement(By.xpath("//a[normalize-space()='Questionário']")).click();
        driver.findElement(By.xpath("//a[@id='user-menu-toggle']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Mudar papel para...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Estudante']")).click();



        // Responder
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//body//div//div[@role='main']//div//div//div//div//div//div//div[2]//input[1]")).click();
        driver.findElement(By.xpath("//input[@name='next']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//div[@class='submitbtns']//a[@class='mod_quiz-next-nav'][normalize-space()='Terminar revisão']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//div[@class='answer']//div[1]//input[1]")).click();
        driver.findElement(By.xpath("//input[@name='next']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//div[@class='submitbtns']//a[@class='mod_quiz-next-nav'][normalize-space()='Terminar revisão']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//body//div//div[@role='main']//div//div//div//div//div//div//div[2]//input[1]")).click();
        driver.findElement(By.xpath("//input[@name='next']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//div[@class='submitbtns']//a[@class='mod_quiz-next-nav'][normalize-space()='Terminar revisão']")).click();

        driver.quit();
        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" 01 Titulo obrigatorio ")
    //o titulo é obrgatorio e se for grande nao quebra a linha o que vai empedir de apagar ou alterar 
    // ERRO
    public void tituloObrigatorioGrande(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.quit();
    }

    @Test
    @DisplayName(" Calculo ")
    // verificar a sintese da resposta 
    public void CalculoSintese(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();  
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculated']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        //adicionar titulo
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//body[1]/div[5]/div[5]/div[1]/div[3]/div[1]/section[1]/div[2]/form[1]/fieldset[1]/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{t} * {w}}");
        
        // salvar
        driver.findElement(By.xpath("//input[contains(@value,'Salvar mudanças')]")).click();
        String erro = driver.findElement(By.xpath("//body")).getText();
        AssertEquals.assertEquals("Sintaxe de fórmula ilegal iniciada com '}'", erro);
        driver.quit();
        excluirQuestionarioJaExistente();
        //driver.findElement(By.xpath("//input[@value='Próxima página']")).click();
        //driver.findElement(By.xpath("//input[@value='Adicionar']")).click();
        //driver.findElement(By.xpath("//input[@value='Salvar mudanças']")).click();
    }

    @Test
    @DisplayName(" Calculo ")
    // normal mesmo 
    public void Calculo(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[7]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculated']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        //adicionar titulo
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//body[1]/div[5]/div[5]/div[1]/div[3]/div[1]/section[1]/div[2]/form[1]/fieldset[1]/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{l}*{w}");
        Select se = new Select(driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[1]//div[2]//fieldset[1]//div[1]//div[2]//span[1]//select[1]")));
        se.selectByValue("1.0");


        // salvar
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.findElement(By.xpath("//input[@value='Próxima página']")).click();
        driver.findElement(By.xpath("//input[@value='Adicionar']")).click();
        driver.findElement(By.xpath("//input[@value='Salvar mudanças']")).click();
        driver.quit();
        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" Calculo ")
    // responder com numero 
    public void CalculoRN(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[7]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculated']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        //adicionar titulo
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//body[1]/div[5]/div[5]/div[1]/div[3]/div[1]/section[1]/div[2]/form[1]/fieldset[1]/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{l}*{w}");
        Select se = new Select(driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[1]//div[2]//fieldset[1]//div[1]//div[2]//span[1]//select[1]")));
        se.selectByValue("1.0");


        // salvar
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.findElement(By.xpath("//input[@value='Próxima página']")).click();
        driver.findElement(By.xpath("//input[@value='Adicionar']")).click();
        driver.findElement(By.xpath("//input[@value='Salvar mudanças']")).click();

        // responder 
        driver.findElement(By.xpath("//a[normalize-space()='Questionário']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@class='form-control d-inline']")).sendKeys("15,48");
        driver.findElement(By.xpath("//input[@value='Finalizar tentativa ...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();

        driver.quit();
        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" Calculo ")
    // responder com letra 
    // ERRO 
    public void CalculoRL(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculated']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        
        //adicionar titulo
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//body[1]/div[5]/div[5]/div[1]/div[3]/div[1]/section[1]/div[2]/form[1]/fieldset[1]/div[2]/div[5]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{l}*{w}");
        Select se = new Select(driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[1]//div[2]//fieldset[1]//div[1]//div[2]//span[1]//select[1]")));
        se.selectByValue("1.0");


        // salvar
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.findElement(By.xpath("//input[@value='Próxima página']")).click();
        driver.findElement(By.xpath("//input[@value='Adicionar']")).click();
        driver.findElement(By.xpath("//input[@value='Salvar mudanças']")).click();

        // responder 
        driver.findElement(By.xpath("//a[normalize-space()='Questionário']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//input[@class='form-control d-inline']")).sendKeys("NAO E PARA ACEITAR");
        driver.findElement(By.xpath("//input[@value='Finalizar tentativa ...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();

        driver.quit();
        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" Adicionando uma questão de cálculo simples ")
    // responder com letra 
    // ERRO 
    public void AQCS(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[7]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_calculatedsimple']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // titulo 
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[1]//div[2]//div[3]//div[2]//div[1]//div[1]//div[1]//div[3]//div[1]")).sendKeys("Qual é a área de um retângulo de comprimento {l} e largura {w}?");
        Select se = new Select(driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[1]//div[2]//fieldset[1]//div[1]//div[2]//span[1]//select[1]")));
        se.selectByValue("1.0");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[2]//div[2]//div[1]//div[2]//fieldset[1]//div[1]//div[1]//span[1]//input[1]")).sendKeys("{l}*{w}" );
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();
        driver.quit();
        excluirQuestionarioCriandoUmNovo();

    }

    @Test
    @DisplayName(" Editando uma questão de resposta incorporada (cloze) ")
    // Responder certo 
    public void EQRICC(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_multianswer']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // criar questao
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[1]//div[2]//div[3]//div[2]//div[1]//div[1]//div[1]//div[3]//div[1]")).sendKeys("Selecione as frutas{:MULTIRESPONSE:=Limão~Maça~Abacaxi~=Tomate~Framboesa~=Laranja}");
        driver.findElement(By.xpath("//input[contains(@name,'submitbutton')]")).click();
        
        // exibir 
        driver.findElement(By.xpath("//a[normalize-space()='Questionário']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // alternativas corretas 
        driver.findElement(By.xpath("//div[@class='answer']//div[1]//input[1]")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[4]//input[1]")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[6]//input[1]")).click();
        driver.findElement(By.xpath("//input[@value='Finalizar tentativa ...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();
        String nota = driver.findElement(By.xpath("//div[@class='outcome']//div[contains(text(),'Atingiu 1,00 de 1,00')]")).getText();
        AssertEquals.assertEquals("Atingiu 1,00 de 1,00", nota);
        driver.quit();
        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" Editando uma questão de resposta incorporada (cloze) ")
    // Responder Errado 
    // ERRO
    public void EQRICE(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_multianswer']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // criar questao
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[1]//div[2]//div[3]//div[2]//div[1]//div[1]//div[1]//div[3]//div[1]")).sendKeys("Selecione as frutas{:MULTIRESPONSE:=Limão~Maça~Abacaxi~=Tomate~Framboesa~=Laranja}");
        driver.findElement(By.xpath("//input[contains(@name,'submitbutton')]")).click();
        
        // exibir 
        driver.findElement(By.xpath("//a[normalize-space()='Questionário']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // alternativas corretas 
        driver.findElement(By.xpath("//div[@class='content']//div[2]//input[1]")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[3]//input[1]")).click();
        driver.findElement(By.xpath("//div[@class='drawers drag-container show-drawer-right']//div[5]//input[1]")).click();
        driver.findElement(By.xpath("//input[@value='Finalizar tentativa ...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();
        String nota = driver.findElement(By.xpath("//div[normalize-space()='Atingiu -1,00 de 1,00']")).getText();
        AssertEquals.assertEquals("Atingiu -1,00 de 1,00", nota);
        driver.quit();
        excluirQuestionarioJaExistente();
    }

    @Test
    @DisplayName(" Editando uma questão de resposta incorporada (cloze) ")
    // Responder Marcando todas 
    // ERRO 
    public void EQRICT(){
        // inica e faz o lpgin 
        WebDriver driver = new ChromeDriver();
        driver.get("https://gmlunardi.pro.br/moodlerp2/course/view.php?id=8");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        // login 
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("2210100408");
        driver.findElement(By.xpath("//button[@id='loginbtn']")).click();

        driver.findElement(By.xpath("//form[@class='d-flex align-items-center editmode-switch-form']")).click();
        driver.findElement(By.xpath("//body/div[@class='d-print-block']/div[5]/div[1]/div[3]/div[1]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[5]/div[2]/button[1]")).click();
        driver.findElement(By.xpath("//div[@class='tab-pane active ']//a[@title='Adicionar um novo Questionário']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//input[@value='Salvar e voltar ao curso']")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[1]//div[1]//div[1]//ul[1]//li[5]//div[2]//ul[1]//li[5]//div[1]//div[1]//div[1]//div[1]//div[1]//div[2]//div[2]//span[1]//a[1]")).click();
        // abre o questionario 

        driver.findElement(By.xpath("//a[normalize-space()='Adicionar questão']")).click();
        driver.findElement(By.xpath("//a[@aria-label='Adicionar']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='uma nova questão']")).click();
        
        // tipo de questao 
        driver.findElement(By.xpath("//label[@for='item_qtype_gapselect']")).click();
        driver.findElement(By.xpath("//label[@for='item_qtype_multianswer']")).click();
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();

        // criar questao
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("nome");
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//fieldset[1]//div[2]//div[3]//div[2]//div[1]//div[1]//div[1]//div[3]//div[1]")).sendKeys("Selecione as frutas{:MULTIRESPONSE:=Limão~Maça~Abacaxi~=Tomate~Framboesa~=Laranja}");
        driver.findElement(By.xpath("//input[contains(@name,'submitbutton')]")).click();
        
        // exibir 
        driver.findElement(By.xpath("//a[normalize-space()='Questionário']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // alternativas corretas 
        driver.findElement(By.xpath("//div[@class='answer']//div[1]//input[1]")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[4]//input[1]")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[6]//input[1]")).click();
        driver.findElement(By.xpath("//div[@class='content']//div[2]//input[1]")).click();
        driver.findElement(By.xpath("//div[1]//div[3]//div[1]//section[1]//div[2]//form[1]//div[1]//div[1]//div[2]//div[1]//div[1]//div[3]//input[1]")).click();
        driver.findElement(By.xpath("//div[@class='drawers drag-container show-drawer-right']//div[5]//input[1]")).click();
        driver.findElement(By.xpath("//input[@value='Finalizar tentativa ...']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Enviar tudo e terminar']")).click();
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Enviar tudo e terminar']")).click();
        String nota = driver.findElement(By.xpath("//div[@class='outcome']//div[contains(text(),'Atingiu 0,00 de 1,00')]")).getText();
        AssertEquals.assertEquals("Atingiu 0,00 de 1,00", nota);
        driver.quit();
        excluirQuestionarioJaExistente();
    }

}

// driver.findElement(By.xpath("null")).click();
// Qual é a área de um retângulo de comprimento {l} e largura {w}?
// {z {t} * {w}}
// {l}*{w}
// Selecione as frutas{:MULTIRESPONSE:=Limão~Maça~Abacaxi~=Tomate~Framboesa~=Laranja}