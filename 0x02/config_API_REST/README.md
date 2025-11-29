# Song API - Projeto Spring Boot

## Descrição
Este é um projeto Spring Boot configurado para criar uma API REST de músicas (Song API).

## Tecnologias Utilizadas
- Spring Boot 2.7.18
- Spring Web
- Spring Boot DevTools
- Java 1.8
- Maven

## Estrutura do Projeto
```
config_API_REST/
├── pom.xml
├── com/
│   └── example/
│       └── demo/
│           └── SongApiApplication.java
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── example/
        │           └── demo/
        │               └── SongApiApplication.java
        └── resources/
            └── application.properties
```

## Configurações da Aplicação
- **Porta:** 8081
- **Context Path:** /api-song

Estas configurações estão definidas no arquivo `src/main/resources/application.properties`:
```properties
server.port=8081
server.servlet.context-path=/api-song
```

## Como Executar

### Opção 1: Usando Maven
```bash
mvn spring-boot:run
```

### Opção 2: Usando o JAR compilado
Primeiro compile o projeto:
```bash
mvn clean install
```

Depois execute o JAR:
```bash
java -jar target/SongApi-0.0.1-SNAPSHOT.jar
```

## Testando a Aplicação
Após iniciar a aplicação, acesse no navegador:
```
http://localhost:8081/api-song/
```

Você deverá ver a mensagem:
```
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.
```

Esta mensagem é esperada pois ainda não há nenhum endpoint/microsserviço definido na aplicação.

## Dependências do Projeto
As seguintes dependências foram adicionadas no `pom.xml`:
- **spring-boot-starter-web**: Para criar aplicações web e APIs REST
- **spring-boot-devtools**: Para facilitar o desenvolvimento com hot reload
- **spring-boot-starter-test**: Para testes (scope: test)

