# Criando e Configurando Spring Boot JPA

## 📋 Objetivo

Aprender como criar e configurar uma aplicação Spring Boot para criar uma API REST com banco de dados (Spring Boot JPA).

---

## 🚀 Passo a Passo Completo

### Passo 1: Acessar Spring Initializr

Acesse: https://start.spring.io/

### Passo 2: Configurar o Projeto

Preencha os seguintes parâmetros:

| Campo | Valor |
|-------|-------|
| **Project** | Maven Project |
| **Language** | Java |
| **Spring Boot** | 3.4.x |
| **Group** | com.techCamps |
| **Artifact** | demo |
| **Name** | demo |
| **Description** | Projeto Demo usando Spring Boot JPA |
| **Package name** | com.techCamps.demo |
| **Packaging** | jar |
| **Java** | 17 |

### Passo 3: Adicionar Dependências

Clique em "ADD DEPENDENCIES" e adicione:

- ✅ **Spring Boot DevTools** - Ferramentas de desenvolvimento
- ✅ **Lombok** - Reduz código boilerplate
- ✅ **Spring Web** - Para criar APIs REST
- ✅ **Spring Data JPA** - Para persistência de dados
- ✅ **H2 Database** - Banco de dados em memória

### Passo 4: Gerar o Projeto

1. Clique no botão **GENERATE**
2. Baixe o arquivo `demo.zip`
3. Descompacte em uma pasta de sua preferência

### Passo 5: Importar na IDE

Opções de IDE:
- **IntelliJ IDEA** (Recomendado)
- Eclipse
- Spring Tool Suite (STS)
- VS Code

**Como importar:**
1. Abra sua IDE
2. File → Open (ou Import → Existing Maven Project)
3. Selecione a pasta descompactada
4. Aguarde o Maven baixar as dependências

### Passo 6: Configurar application.properties

Modifique o arquivo `src/main/resources/application.properties`:

```properties
server.port=8090
server.servlet.context-path=/api-demo-jpa
```

**Explicação:**
- `server.port=8090` - Define a porta do servidor Tomcat
- `server.servlet.context-path=/api-demo-jpa` - Define o contexto da aplicação

### Passo 7: Executar a Aplicação

1. Localize a classe `DemoApplication.java`
2. Clique com botão direito
3. Selecione **Run As → Java Application**

Ou use Maven:
```bash
mvn spring-boot:run
```

### Passo 8: Testar a Aplicação

Acesse no navegador:
```
http://localhost:8090/api-demo-jpa
```

**Resultado Esperado:**

```
Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.

Thu Nov 28 22:00:00 BRT 2025
There was an unexpected error (type=Not Found, status=404).
```

✅ **Isso está correto!** A mensagem indica que a aplicação está rodando, mas ainda não tem nenhum endpoint definido.

---

## 📂 Estrutura do Projeto

```
criando_spring_boot_JPA/
├── com/techCamps/demo/
│   └── DemoApplication.java          ← Arquivo solicitado
├── src/
│   ├── main/
│   │   ├── java/com/techCamps/demo/
│   │   │   └── DemoApplication.java
│   │   └── resources/
│   │       └── application.properties  ← Arquivo solicitado
│   └── test/
│       └── java/com/techCamps/demo/
├── pom.xml                             ← Arquivo solicitado
└── README.md
```

---

## 📄 Arquivos Criados

### 1. DemoApplication.java

```java
package com.techCamps.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
```

**Explicação:**
- `@SpringBootApplication` - Combina 3 annotations:
  - `@Configuration` - Define como classe de configuração
  - `@EnableAutoConfiguration` - Habilita configuração automática
  - `@ComponentScan` - Escaneia componentes no pacote

### 2. application.properties

```properties
server.port=8090
server.servlet.context-path=/api-demo-jpa
```

**Explicação:**
- Define a porta customizada (8090 em vez de 8080)
- Define o prefixo de todas as URLs (/api-demo-jpa)

### 3. pom.xml

Principais dependências:

```xml
<!-- Spring Data JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- Spring Web (REST API) -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- H2 Database -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- DevTools -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

---

## 🎯 Dependências Explicadas

### 1. Spring Boot DevTools
- **Função:** Hot reload automático
- **Uso:** Reinicia a aplicação automaticamente ao salvar arquivos
- **Produção:** Desabilitado automaticamente

### 2. Lombok
- **Função:** Reduz código boilerplate
- **Uso:** Gera automaticamente getters, setters, construtores, etc.
- **Annotations:** `@Data`, `@Getter`, `@Setter`, `@NoArgsConstructor`, etc.

### 3. Spring Web
- **Função:** Criar APIs REST
- **Inclui:** Spring MVC, Tomcat, Jackson (JSON)
- **Uso:** Controllers, REST endpoints

### 4. Spring Data JPA
- **Função:** Persistência de dados
- **Inclui:** Hibernate, Spring Data Commons
- **Uso:** Repositories, Entities, Queries

### 5. H2 Database
- **Função:** Banco de dados em memória
- **Uso:** Desenvolvimento e testes
- **Console:** http://localhost:8090/api-demo-jpa/h2-console

---

## ✅ Validação

### Checklist
- [x] Projeto criado via Spring Initializr
- [x] Todas as dependências adicionadas
- [x] application.properties configurado
- [x] Porta: 8090
- [x] Context-path: /api-demo-jpa
- [x] DemoApplication.java criado
- [x] Aplicação executa sem erros
- [x] URL acessível com "Whitelabel Error Page"

### Logs Esperados ao Iniciar

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.0)

...
Tomcat started on port 8090 (http) with context path '/api-demo-jpa'
Started DemoApplication in X.XXX seconds (process running for X.XXX)
```

---

## 🔧 Comandos Úteis

### Compilar o Projeto
```bash
mvn clean install
```

### Executar a Aplicação
```bash
mvn spring-boot:run
```

### Executar Testes
```bash
mvn test
```

### Gerar JAR
```bash
mvn package
```

### Executar JAR
```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

---

## 🌐 URLs Importantes

| URL | Descrição |
|-----|-----------|
| http://localhost:8090/api-demo-jpa | Raiz da aplicação |
| http://localhost:8090/api-demo-jpa/h2-console | Console H2 (se habilitado) |
| http://localhost:8090/api-demo-jpa/actuator | Actuator (se adicionado) |

---

## 📚 Próximos Passos

Após configurar o projeto básico, você pode:

1. **Criar Entities** - Classes JPA que representam tabelas
2. **Criar Repositories** - Interfaces para acesso aos dados
3. **Criar Services** - Lógica de negócio
4. **Criar Controllers** - Endpoints REST
5. **Adicionar Validações** - Bean Validation
6. **Configurar H2 Console** - Para visualizar dados
7. **Adicionar Swagger** - Documentação da API

---

## 🎓 Conceitos Importantes

### Spring Boot
Framework que simplifica o desenvolvimento de aplicações Spring.

### JPA (Java Persistence API)
Especificação Java para mapeamento objeto-relacional (ORM).

### Hibernate
Implementação mais popular do JPA.

### H2
Banco de dados relacional em memória, ideal para desenvolvimento.

### Maven
Ferramenta de gerenciamento de dependências e build.

---

## 💡 Dicas

1. **Use DevTools** - Aproveite o hot reload
2. **Lombok é seu amigo** - Economize linhas de código
3. **H2 Console** - Útil para debug
4. **Logs** - Preste atenção nas mensagens de inicialização
5. **Porta ocupada?** - Mude em application.properties

---

## ❓ Troubleshooting

### Porta 8090 já em uso
```properties
server.port=8091
```

### Dependências não baixadas
```bash
mvn clean install -U
```

### Lombok não funciona
Instale o plugin Lombok na IDE.

### Erro ao iniciar
Verifique se Java 17 está instalado:
```bash
java -version
```

---

**Repository:** bradesco-hbtn-microsservicos-java
**Directory:** 0x03/criando_spring_boot_JPA
**Files:** 
- com/techCamps/demo/DemoApplication.java
- application.properties
- pom.xml

**Status:** ✅ **Projeto Criado e Configurado com Sucesso!**

