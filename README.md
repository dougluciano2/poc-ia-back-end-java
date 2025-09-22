# Back-end Simulador de Sistema Legado (POC OpenJarvis)

![Status do Projeto](https://img.shields.io/badge/status-Finalizado-green)

## 📖 Sobre o Projeto

Este repositório contém o back-end de uma Prova de Conceito (POC) desenvolvido em Java com Spring Boot. Sua principal função **não é** expor uma API REST convencional, mas sim **simular um sistema legado**, atuando como a fonte de dados primária para um robô de automação.

A aplicação provisiona um banco de dados PostgreSQL contendo as Notas Fiscais que devem ser processadas pelo agente de IA do projeto OpenJarvis. Em resumo, este projeto é o "banco de dados de origem" que o robô precisa acessar para iniciar seu processo.

## 🎯 O Papel no Ecossistema OpenJarvis

Este back-end desempenha o papel de **fonte de dados (data source)** para a automação. O fluxo de trabalho da POC é o seguinte:

1.  Este ambiente é iniciado via Docker Compose, disponibilizando um banco de dados PostgreSQL com dados de Notas Fiscais.
2.  O robô da POC OpenJarvis se conecta diretamente a este banco de dados via **JDBC**.
3.  Ele realiza a leitura das NFs que precisam ser processadas.
4.  Com os dados em mãos, o robô inicia a interação com o front-end simulado para preencher as informações.

## 🚀 Tecnologias Utilizadas

-   **Java 21**: Versão mais recente da linguagem Java LTS até o desenvolvimento do projeto.
-   **Spring Boot 3.x**: Framework para criação da aplicação.
-   **PostgreSQL**: Sistema de gerenciamento de banco de dados relacional.
-   **Flyway**: Ferramenta para versionamento e migração do schema do banco de dados.
-   **Lombok**: Biblioteca para reduzir código boilerplate (getters, setters, etc.).
-   **Maven**: Ferramenta de gerenciamento de dependências e build.
-   **Docker Compose**: Orquestração do ambiente, incluindo a aplicação e o banco de dados.

## ⚙️ Ambiente e Execução com Docker Compose

A maneira mais simples e recomendada de executar este projeto é utilizando o Docker e o Docker Compose, que cuidam de toda a configuração do ambiente.

### Pré-requisitos
-   [Docker](https://www.docker.com/get-started/)
-   [Docker Compose](https://docs.docker.com/compose/install/)

### Instalação e Execução

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/dougluciano2/poc-ia-back-end-java.git](https://github.com/dougluciano2/poc-ia-back-end-java.git)
    ```

2.  **Navegue até o diretório do projeto:**
    ```bash
    cd poc-ia-back-end-java
    ```

3.  **Inicie o ambiente com Docker Compose:**
    ```bash
    docker-compose up --build -d
    ```

Este único comando irá:
-   Construir a imagem Docker da aplicação Java/Spring Boot.
-   Iniciar um container para o banco de dados PostgreSQL.
-   Iniciar o container da aplicação back-end.
-   O **Flyway** será executado automaticamente na inicialização da aplicação, criando as tabelas e populando os dados iniciais necessários para a POC.

Após a execução, o banco de dados estará acessível na porta padrão (`5432`) e pronto para ser consultado pelo robô via JDBC.
