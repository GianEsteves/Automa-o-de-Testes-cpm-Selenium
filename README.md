# Resolução de Problemas 2
## Marco 2 - Teste Funcional

### 1. OBJETIVOS
Projetar, executar e analisar um projeto teste funcional em uma aplicação Web. Executar
processos de teste de software para desenvolver os artefatos de testes para um software
em ambiente real, mantendo esses artefatos gerados sob controle de versões. Fortalecer a
ideia de trabalho colaborativo. Desenvolver aspectos comportamentais de responsabilidade
e ética no ambiente de trabalho.

### 2. PROJETO E ESCOPO
Os Ambientes Virtuais de Aprendizagem (AVAs) permitem criar um canal de comunicação
virtual entre estudantes e professores de uma determinada disciplina. O Moodle (Modular
Object-Oriented Dynamic Learning Environment - Ambiente de Aprendizagem Dinâmico
Modular Orientado a Objeto) é uma plataforma de aprendizagem online que permite aos
professores compartilharem conteúdos com os estudantes, criem tarefas e testes,
possibilitem o aprendizado colaborativo com fóruns e chats, entre outras funcionalidades.
Esses ambientes cresceram majoritariamente nos últimos tempos, devido à sua praticidade
e também uma necessidade de ensino durante o período de pandemia da COVID-19.
Contudo, o primeiro contato com estas plataformas pode ser um pouco conturbado e
confuso, devido à falta de experiência dos usuários finais (neste caso, estudantes que
ingressaram no curso e não tinham contato com o ambiente previamente), ou até mesmo a
arquitetura e defeitos presentes nas mesmas. Muitas vezes, os AVAs são projetados para
atender as necessidades dos estudantes, mas não são avaliados. A forma que podemos
minimizar e/ ou mitigar os problemas de interação que estes AVAs apresentam é por meio
de testes de software. Assim, você e sua equipe foram contratados para realizar a
terceirização do teste funcional do AVA Moodle, a qual será usada por docentes e
estudantes de uma instituição chamada INSIGHTS Lab.

### 3. FORMAÇÃO DOS TIMES
Os grupos foram organizados aleatoriamente de acordo com a ferramenta, em sala de aula
e na presença de todos os estudantes. O prazo para essa definição foi terça-feira,
08/11/2022.

### 4. OPERACIONALIZAÇÃO
Com o objetivo de garantir a alta qualidade de seus produtos de software, o grupo
educacional INSIGHTS Lab nos contratou para avaliar a qualidade do produto AVA
MOODLE, a fim de identificar os erros e limitações da ferramenta educacional.
Vocês devem implementar os testes funcionais para testar a ferramenta Moodle versão 4.1
beta (acessível no link da seção anterior), explorando, adequadamente, as técnicas, os
critérios e os dados de testes conforme o estado da arte e da prática em teste funcional.
As equipes podem explorar ferramentas ou plugins de teste funcional para auxiliar na
execução da atividade. Devem executar todas as etapas do processo de teste funcional de
software desde o planejamento, projeto, execução até a análise dos resultados.
Os requisitos de software da ferramenta serão distribuídos entre os grupos pelos
docentes. Lembrando que cada funcionalidade deverá ser testada tanto pelo ponto de vista
dos professores quanto dos discentes, exceto quando for avisado pelos professores.
Como premissa, todos os projetos deverão usar Selenium Web Driver a fim de gerar os
scripts de testes funcionais na ferramenta Web. Além disso, os dados de entrada deverão
ser, dinamicamente, parametrizados, podendo usar desde JSON, CSV ou XML.

Uma atividade é um nome geral para um grupo de funcionalidades em um curso Moodle.
Geralmente uma atividade é algo que o estudante irá fazer que interage com outros
estudantes e/ou com o professor. Existem tipos diferentes de atividades no Moodle padrão
que podem ser encontradas quando o modo de edição está habilitado e clicamos no link
"Adicionar atividade ou recurso". Para se ter acesso a tudo isso, você devem primeiro
acessar o sistema, logo os primeiros testes serão nas seguintes funcionalidades:

<ul>
<li> Login (Efetuar login no curso);
<li> Criar descrições dos tópicos e customizar o tópico de acordo com o curso
(perspectiva docente) e criar rótulos;
<li> Adicionar um arquivo em cada tópico criado (perspectiva docente);
<li> Adicionar uma URL em cada tópico criado sobre o assunto do curso (perspectiva
docente);
<li> Adicionar uma pasta com vários arquivos em cada tópico criado sobre o assunto do
curso (perspectiva docente).
</ul>

Após realizar os testes iniciais, vocês deverão testar requisitos/atividades a seguinte lista de requisitos:

<ul>
<li> Tarefa: Permite que professores dêem notas e comentários em arquivos ou textos
enviados e tarefas realizadas online ou offline;
<li> Chat: Permite que os participantes tenham conversações síncronas em tempo real;
<li> Mensagens: Permite que os participantes enviem mensagens assíncronas entre si;
<li> Pesquisa: Para criar e conduzir pesquisas para coletar opinião, satisfação,
impressão, feedback etc;
<li> Fórum: Permite que os participantes tenham conversas assíncronas;
<li> Wiki: Uma coleção de páginas web que qualquer um pode criar, editar e acompanhar
o histórico;
<li> Glossário: Permite que os participantes mantenham uma lista de definições, como
um dicionário.
</ul>

### 5. FORMATO DO TRABALHO
A entrega do trabalho será formada por:
<ul>
 <li>Projeto de teste com o código-fontes dos testes funcionais desenvolvidos;
    <ul>
    <li>Criar uma pasta chamada “Marco2” no repositório de cada grupo para submissão dos arquivos deste projeto.
    </ul>
 <li>Relatório técnico com a especificação e resultados dos testes funcionais realizados.
    <ul>
    <li>Formato: Template SBC.
    <li>O relatório técnico pode conter as seguintes etapas (recomendado):
    </ul>
        <ul>
        <li>Introdução
        <li>Contexto/Ambiente
        <li>Planejamento do Teste
        <li>Projeto dos Casos de Teste
        <li>Execução do Teste
        <li>Análise dos Resultados
        <li>Conclusão e lições aprendidas
        <li>Referências
        </ul>
<li>Apresentação do Marco 02.
 </ul>

### 6. ENTREGA
O relatório técnico final deverá ser publicado no Moodle via <b>“Tarefa: Submissão Marco II:
Relatório do Teste Funcional”.</b> Apenas uma submissão do relatório técnico por grupo. O
formato do relatório técnico deve ser, exclusivamente, em <b>.PDF.</b>
O trabalho deverá ser constantemente atualizado na Wiki do projeto no repositório GitLab.
O projeto com os códigos-fontes do projeto de teste deve ser submetido no repositório do
ambiente GitLab da Unipampa para o grupo formado organizado em uma pasta chamada
Marco2. Além disso, vale ressaltar que <b>todos os erros identificados devem ser reportados na ferramenta Mantis e o gerenciamento do projeto de teste deve ser
realizado na ferramenta Testlink.</b>

Além da atualização do documento de teste, cada grupo deverá preparar uma apresentação
para expor suas ideias a respeito do tema escolhido, resumindo os principais pontos do
trabalho desenvolvido. Todos os integrantes do grupo devem participar da apresentação. O
tempo máximo da apresentação é 15 minutos (10 min explanação + 5 min de perguntas).

<b>Observação importante:</b> Para cada dia de atraso na entrega do trabalho, será descontado
um ponto (-1,0) por dia de atraso, a contar do primeiro minuto após o prazo estipulado pelos
docentes.

<b>Data da entrega: 09/01/2022</b>

<b>Data das apresentações: 10/01/2022</b>
