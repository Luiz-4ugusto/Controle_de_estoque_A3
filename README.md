
# Controle de estoque - A3


Este sistema foi desenvolvido como parte da disciplina de Programação de Soluções Computacionais (PSC) da Universidade do Sul de Santa Catarina (UNISUL). O objetivo do projeto é criar uma aplicação colaborativa para o gerenciamento de controle de estoque, com interfaces gráficas e integração com banco de dados, além do uso de modelagem de software para garantir uma estrutura sólida, facilitando a manutenção, escalabilidade e eficiência no desenvolvimento da aplicação




## Descrição do projeto

Este projeto tem como objetivo o desenvolvimento de um sistema de controle de estoque, permitindo ao usuário realizar uma gestão mais eficiente dos produtos armazenados. O sistema oferece funcionalidades como cadastro e atualização de produtos, além da geração de relatórios, como lista de preços, balanço físico/financeiro e controle de itens que estão abaixo ou acima dos níveis ideais de estoque.
A aplicação foi desenvolvida utilizando a linguagem Java com Swing para a interface gráfica, MySQL como sistema de gerenciamento de banco de dados e o padrão DAO para a abstração da camada de dados, promovendo uma estrutura organizada e de fácil manutenção.
## Alunos

| Nome Completo               | Github                                                | RA                  |
| ----------------- | ---------------------------------------------------------- | --------------------------------- |
| Arthur Graciliano  Oliveira de Souza      | Arthurc0mH| 1072518568     |
| Gustavo de Espindola Martins       | ChocolateKest| 10724238393    |
| Igor Ragen Valau Martins       | IgorRagen | 1072513366  |
| Júlio Cesar de Souza Mauro       | JcMauro | 10724269838     |
| Luiz Augusto Pereira       | Luiz-4ugusto | 10725115943     |

## Requisitos Funcionais (RF)
RF01. O sistema deve permitir que o usuário cadastre categorias de produtos, informando: id, nome da categoria, embalagem e tamanho.

RF02. O sistema deve permitir que o usuário edite e exclua categorias previamente cadastradas.

RF03. O sistema deve permitir que o usuário cadastre novos produtos, informando: id, nome do produto, quantidade mínima e máxima permitida em estoque, quantidade atual em estoque e categoria.

RF04. O sistema deve permitir que o usuário edite e exclua produtos previamente cadastrados.

RF05. O sistema deve permitir que o usuário adicione e remova produtos ao estoque atual.

RF06. O sistema deve permitir que o usuário gere o seguinte relatório para lista de preços dos produtos

RF07. O sistema deve permitir que o usuário gere o seguinte relatório para o balanço fiscal

RF08. O sistema deve permitir que o usuário gere o seguinte relatório para produtos abaixo da quantidade mínima de estoque

RF09. O sistema deve permitir que o usuário gere o seguinte relatório para produtos acima da quantidade máxima de estoque

RF10. O sistema deve permitir que o usuário gere o seguinte relatório para quantidade de produtos agrupados por categoria

RF11. O sistema deve disponibilizar uma janela específica que exiba todos os produtos cuja quantidade em estoque esteja abaixo da quantidade mínima permitida.

RF12. O sistema deve disponibilizar uma janela específica que exiba todos os produtos cuja quantidade em estoque esteja acima da quantidade máxima permitida.

## Requisitos Não Funcionais (RNF)

RNF01. O sistema deve estar disponível para uso 24 horas por dia, 7 dias por semana (24/7), garantindo funcionamento contínuo.

RNF02. O sistema deve possuir uma interface intuitiva e de fácil utilização, facilitando o uso por usuários com diferentes níveis de experiência.

RNF03. O sistema deve responder aos comandos de forma rápida e eficaz, garantindo fluidez na navegação e uso das funcionalidades.

RNF04. O sistema deve garantir a integridade dos dados no banco, evitando perda ou corrupção de informações durante operações de leitura, escrita ou atualização.

RNF05. O sistema deve validar os dados inseridos pelo usuário e, caso algum valor inválido seja informado, exibir uma mensagem de erro clara explicando o motivo do erro

## Ferramentas

| Ferramentas          | Finalidade                                     |
| ------------------------------ | ---------------------------------------------- |
| **JDK 17**                      | Ambiente de desenvolvimento (Java 17)         |
| **MySQL Server 8.0**            | Banco de dados relacional                     |
| **MySQL Connector 8.3.0**| Comunicação entre Java e MySQL                |
| **Apache NetBeans 26**         | Ambiente de desenvolvimento (IDE)            |


## Banco de Dados

A pasta `database` contém os scripts de conexão e criação das tabelas utilizadas neste projeto.  Execute o script em seu servidor SQL local para criar a estrutura do banco de dados necessária ao funcionamento da aplicação.
nome da base: db_controledeestoque
usuário e senha do bd:
            String user = "root";
            String password = "070600@";


## Referências

 - [How to Create a Perfect README for Your GitHub Project](https://medium.com/@sumudithalanz/the-art-of-crafting-an-effective-readme-for-your-github-project-cf425a8b1580)
  - [readme.so](https://readme.so/pt/editor)
 - [Documentação para a criação do controle de estoque](https://mediacdns3.ulife.com.br/PAT/Upload/5688953/A3_roteiro_20250529201959.pdf)
 - [Implementando documentação através do NetBeans](https://www.devmedia.com.br/javadoc-implementando-documentacao-atraves-do-netbeans/2495)
  - [Requisitos funcionais e não funcionais](https://www.mestresdaweb.com.br/tecnologias/requisitos-funcionais-e-nao-funcionais-o-que-sao)
  - [How to link github to Netbeans projects](https://www.youtube.com/watch?v=UOIPS-ewFHg)
  - [Arquivo base disponibilizados pelo professor Osmar para a criação de interface gráfica.](https://mediacdns3.ulife.com.br/PAT/Upload/2985299/11_Interfaces_graficas_20250519185608.pdf)
  - [Arquivo base disponibilizados pelo professor Osmar para a criação de banco de dados.](https://mediacdns3.ulife.com.br/PAT/Upload/2985299/12_BD_mysql_workbench_20250512213257.pdf)
- [Arquivo base disponibilizados pelo professor Osmar para a criação e integração de banco de dados.](https://mediacdns3.ulife.com.br/PAT/Upload/2985299/13_BD_DAO_sem_control_20250512213305.pdf)

  





