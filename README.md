# Autenticação de Usuário
Este projeto fornece uma solução de autenticação de usuário baseada na arquitetura limpa e no desenvolvimento guiado por testes (TDD). É possivel criar e autenticar (login) um usuário. Tecnologias utilizadas são Java, Maven e JUnit.

## Tecnologias Utilizadas
- Java 11
- Maven
- JUnit

## Estrutura do Projeto
O projeto segue a arquitetura limpa, com as seguintes camadas:

- Main: contém as classes de aplicação que servem como intermediárias entre o domínio e as interfaces de usuário.
- Shared: contém arquivos que são utilizados por mais de uma camada.
- Interface: contém as interfaces de usuário, como controllers, views, etc.
- Infra: contém as classes de infraestrutura, como acesso a banco de dados, recursos externos, etc.
- Application: contém regra de negócio da aplicação e classes de dominio.
    - Domain: contém as classes de domínio.

## Funcionalidades
- Criação de usuário: O usuário pode se registrar fornecendo seu nome de usuário e senha. As informações são validadas e a senha hasheada, em seguida as informações são armazenadas.
- Autenticação de usuário: O usuário pode se autenticar fornecendo seu nome de usuário e senha. A autenticação é realizada comparando as informações fornecidas com as informações armazenadas no banco de dados e retornando um token JWT.
