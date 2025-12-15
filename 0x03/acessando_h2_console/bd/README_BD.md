# Arquivo do Banco de Dados H2

Este arquivo `demobd.mv.db` será criado automaticamente quando você executar a aplicação Spring Boot pela primeira vez.

## Como o arquivo é criado:

1. Execute a aplicação: `mvn spring-boot:run`
2. O Spring Boot lerá a configuração `spring.datasource.url=jdbc:h2:file:./bd/demobd`
3. O H2 criará automaticamente o arquivo `demobd.mv.db` nesta pasta

## Observação:

**IMPORTANTE:** Você precisa ter Java 17 instalado para executar o Spring Boot 3.4.0!

Se estiver usando Java 8, faça o download do Java 17:
- Oracle JDK 17: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- OpenJDK 17: https://adoptium.net/

Após instalar Java 17:
1. Configure JAVA_HOME
2. Reinicie sua IDE
3. Execute `mvn spring-boot:run`
4. O arquivo `demobd.mv.db` será criado automaticamente

