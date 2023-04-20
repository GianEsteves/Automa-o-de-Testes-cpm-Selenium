package org.test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v105.dom.DOM;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Auxiliar {

    //Métodos auxiliares para teste de envio de atividade(discente)
    public boolean arquivoTipoTexto(WebDriver driver) {
        WebElement tarefa = driver.findElement(By.xpath("//li[4]/div/div/div/div/div/div[2]/div[2]/a"));
        tarefa.click();
        WebElement addAtividade = driver.findElement(By.xpath("//button[contains(.,'Adicionar envio')]"));
        addAtividade.click();
        try {
            WebElement texto = driver.findElement(By.id("id_onlinetext_editoreditable"));
            texto.click();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    // se existir o botão de "Adicionar Envio" retorna true
    public boolean addEnvio(WebDriver driver) {
        WebElement tarefa = driver.findElement(By.xpath("//li[4]/div/div/div/div/div/div[2]/div[2]/a"));
        tarefa.click();
        try {
            WebElement addAtividade = driver.findElement(By.xpath("//button[contains(.,'Adicionar envio')]"));
            addAtividade.click();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void envioAtividade(WebDriver driver) {
        WebElement tarefa = driver.findElement(By.xpath("//li[4]/div/div/div/div/div/div[2]/div[2]/a"));
        tarefa.click();
        WebElement addAtividade = driver.findElement(By.xpath("//button[contains(.,'Adicionar envio')]"));
        addAtividade.click();
        WebElement arrastarAtividade = driver.findElement(By.xpath("//div[4]/div/div[2]/div/div"));
        arrastarAtividade.click();
        WebElement escolherArquivo = driver.findElement(By.xpath("//p[contains(.,'Relatorio II - marco 02 (1).pdf')]"));
        escolherArquivo.click();
        WebElement arquivoEscolhido = driver.findElement(By.xpath("//button[contains(.,'Selecione este arquivo')]"));
        arquivoEscolhido.click();

        try {
            WebElement salvar = driver.findElement(By.name("submitbutton"));
            salvar.click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.name("submitbutton")));

        }

    }

    public void mudarPapel(WebDriver driver, String papel) {
        WebElement user = driver.findElement(By.id("user-menu-toggle"));
        user.click();
        WebElement mudarPapel = driver.findElement(By.xpath("//a[contains(text(),'Mudar papel para...')]"));
        mudarPapel.click();
        if (papel.equals("Estudante")) {
            WebElement aluno = driver.findElement(By.xpath("//div[3]/div/form/button"));
            aluno.click();
        }

    }

    public void ativarModoEdicao(WebDriver driver) {
        WebElement menuOn = driver.findElement(By.className("custom-control-input"));
        menuOn.click();
    }

    public void configCriarAtividade(WebDriver driver, String limite) {
        WebElement configuracoes = driver.findElement(By.xpath("//a[@id='action-menu-toggle-9']/i"));
        configuracoes.click();
        WebElement editConf = driver.findElement(By.xpath("//div[@id='action-menu-9-menu']/a/span"));
        editConf.click();
        WebElement habilitarLimitePalavras = driver.findElement(By.xpath("//input[@id='id_assignsubmission_onlinetext_wordlimit_enabled']"));
        habilitarLimitePalavras.click();
        WebElement limitePalavras = driver.findElement(By.xpath("//input[@id='id_assignsubmission_onlinetext_wordlimit']"));
        limitePalavras.click();
        limitePalavras.sendKeys(limite);
        WebElement salvar = driver.findElement(By.xpath("//div[4]/div[2]/fieldset/div/div/span/input"));
        salvar.click();
    }

    // clica em marcar como feito. A tarefa passa a estar concluida
    public void concluirTarefa(WebDriver driver) {
        WebElement concluido = driver.findElement(By.xpath("//li[4]/div/div/div/div[2]/div/div/button"));
        if (concluido.getText().equals("Marcar como feito")) {
            concluido.click();
        }
    }

    //Métodos auxiliares para testes de correção de atividade(perspectiva docente)
    public boolean haNota(WebDriver driver) {
        String verifyText = driver.findElement(By.xpath("//div[3]/div/div/div[2]")).getText();
        boolean verify = true;
        if (verifyText.equals("Não há notas")) {
            verify = false;
        }
        return verify;
    }

    //Envia nota da atividade
    public void avaliarAtividade(WebDriver driver, String pontuacao) {
        WebElement atividade = driver.findElement(By.xpath("//li[5]/div/div/div/div/div/div[2]/div[2]/a"));
        atividade.click();
        WebElement nota = driver.findElement(By.xpath("//section[@id='region-main']/div[2]/div/div/div[2]/a"));
        nota.click();
        WebElement input = driver.findElement(By.xpath("//input[@id='id_grade']"));
        input.click();
        input.sendKeys(pontuacao);
        WebElement salvar = driver.findElement(By.name("savechanges"));
        salvar.click();
        WebElement voltar = driver.findElement(By.xpath("//a[contains(text(),'Tarefa: Entrega Final - Escrita de Algoritmo')]"));
        voltar.click();
    }

    public void inserirComentario(WebDriver driver, String texto) {
        WebElement atividade = driver.findElement(By.xpath("//li[5]/div/div/div/div/div/div[2]/div[2]/a"));
        atividade.click();
        WebElement nota = driver.findElement(By.xpath("//section[@id='region-main']/div[2]/div/div/div[2]/a"));
        nota.click();

        WebElement comentario = driver.findElement(By.xpath("//div/div[6]/div"));
        comentario.click();


        WebElement inserir = driver.findElement(By.xpath("//textarea"));
        inserir.click();
        inserir.sendKeys(texto);
        WebElement salvar = driver.findElement(By.xpath("//a[contains(text(),'Salvar comentário')]"));
        salvar.click();

    }

    // Forum
    public void responderForum(WebDriver driver, String assunto, String mensagem) {
        // forum plagio de trabalhos
        WebElement forum = driver.findElement(By.xpath("//li[3]/div/div/div/div/div/div[2]/div[2]/a"));
        forum.click();
        WebElement adicionarTopico = driver.findElement(By.linkText("Adicionar tópico de discussão"));
        adicionarTopico.click();
        WebElement assuntoInput = driver.findElement(By.name("subject"));
        assuntoInput.click();
        assuntoInput.sendKeys(assunto);
        WebElement mensagemInput = driver.findElement(By.xpath("//div/div/div/div[3]/div"));
        mensagemInput.click();
        mensagemInput.sendKeys(mensagem);
        WebElement enviar = driver.findElement(By.name("submitbutton"));
        enviar.click();
    }

    public void responderTopico(WebDriver driver, String resposta) throws NoSuchElementException {
        WebElement forum = driver.findElement(By.xpath("//li[3]/div/div/div/div/div/div[2]/div[2]/a"));
        forum.click();
        WebElement topico = driver.findElement(By.xpath("//a[contains(text(),'Lorem ipsum dolor sit amet')]"));
        topico.click();
        WebElement responder = driver.findElement(By.linkText("Responder"));
        responder.click();
        WebElement respostaInput = driver.findElement(By.xpath("//textarea[@name='post']"));
        respostaInput.click();
        respostaInput.sendKeys(resposta);
        WebElement enviar = driver.findElement(By.xpath("//span[contains(.,'Enviar mensagem ao fórum')]"));
        enviar.click();
    }

    public int verificarQuantidadeComentarios(WebDriver driver) {
        WebElement forum = driver.findElement(By.xpath("//li[3]/div/div/div/div/div/div[2]/div[2]/a"));
        forum.click();
        String quantidadeComentarios = driver.findElement(By.xpath("//td[5]")).getText();
        int quantidadeNumerica = Integer.parseInt(quantidadeComentarios);
        return quantidadeNumerica;
    }

    public void excluirRespostaTopico(WebDriver driver) {
        WebElement forum = driver.findElement(By.xpath("//li[3]/div/div/div/div/div/div[2]/div[2]/a"));
        forum.click();
        WebElement topico = driver.findElement(By.xpath("//a[contains(text(),'Lorem ipsum dolor sit amet')]"));
        topico.click();
        WebElement excluir = driver.findElement(By.linkText("Excluir"));
        excluir.click();
        WebElement continuar = driver.findElement(By.xpath("//div[2]/form/button"));
        continuar.click();
    }

    public void dataLimitePostarForum(WebDriver driver) {
        WebElement forum = driver.findElement(By.xpath("//li[3]/div/div/div/div/div/div[2]/div[2]/a"));
        forum.click();
        WebElement config = driver.findElement(By.linkText("Configurações"));
        config.click();
        WebElement conclusaoAtividade = driver.findElement(By.linkText("Conclusão de atividade"));
        conclusaoAtividade.click();
        WebElement dia = driver.findElement(By.name("completionexpected[day]"));
        System.out.println(dia);

    }

    public void respostaMaisAntiga(WebDriver driver, String resposta){
        WebElement forum = driver.findElement(By.xpath("//li[3]/div/div/div/div/div/div[2]/div[2]/a"));
        forum.click();
        WebElement topico = driver.findElement(By.xpath("//a[contains(text(),'Lorem ipsum dolor sit amet')]"));
        topico.click();
        WebElement selecionar = driver.findElement(By.xpath("//select"));
        selecionar.click();
        selecionar.sendKeys(resposta);
        selecionar.click();
    }

    public void gruposVisiveis(WebDriver driver, String nomeGrupo){
        WebElement forum = driver.findElement(By.xpath("//li[3]/div/div/div/div/div/div[2]/div[2]/a"));
        forum.click();
        WebElement filtro = driver.findElement(By.name("group"));
        filtro.sendKeys(nomeGrupo);
    }

}