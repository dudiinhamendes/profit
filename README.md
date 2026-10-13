# 🏋️‍♂️ Projeto Academia ProFit

Projeto de Desenvolvimento de sistema Web colaborativo da disciplina de Laboratório.

## Tecnologias Utilizadas
- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- H2 Database
- Maven

## Pré-Requisitos
Para executar o projeto, é necessário ter instalado:

- Java JDK
- Git
- IDE Eclipse (utilizada pela equipe)

## Como executar o projeto
### 1. Clonar o repositório
Abra o terminal e execute:

git clone https://github.com/dudiinhamendes/profit

Depois, entre na pasta do projeto:

cd profit

### 2. Executar o projeto
É possível executar o projeto diretamente pela IDE, iniciando a classe principal da aplicação Spring Boot.

### 3. Acesso ao Banco H2
O console do banco de dados pode ser acessado em:

http://localhost:8080/h2-console

- JDBC URL: jdbc:h2:mem:profit
- User Name: sa
- Password:

As demais informações de conexão estão no arquivo: 

src/main/resources/application.properties

A aplicação utiliza um banco H2 em memória. Portanto, os dados cadastrados durante a execução da aplicação são perdidos quando ela é encerrada.

### 4. Acessar a aplicação
Após iniciar o projeto, as funcionalidades podem ser acessadas pelas seguintes rotas:

Console do H2: http://localhost:8080/h2-console

## Estrutura do Projeto
A aplicação segue uma organização baseada em camadas.

Principais Camadas:

- Model: representa as entidades utilizadas pela aplicação.
- Repository: responsável pelo acesso aos dados através do Spring Data JPA.
- Service: concentra as regras e serviços da aplicação.
- Controller: recebe as requisições e direciona o fluxo da aplicação.
- Templates: contém as páginas HTML/CSS utilizadas pelo Thymeleaf.

## Observações

Para realizar alterações no projeto, crie uma nova branch antes de modificar os arquivos.

Após concluir as alterações, faça o commit e envie a branch para o GitHub para que ela possa ser revisada antes do merge na branch principal.
