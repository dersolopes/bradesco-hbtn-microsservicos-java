# Guia Passo a Passo - Spring Boot JPA

## 📋 Índice
1. [Acessar Spring Initializr](#passo-1-acessar-spring-initializr)
2. [Configurar Projeto](#passo-2-configurar-projeto)
3. [Adicionar Dependências](#passo-3-adicionar-dependências)
4. [Gerar e Baixar](#passo-4-gerar-e-baixar)
5. [Descompactar](#passo-5-descompactar)
6. [Importar na IDE](#passo-6-importar-na-ide)
7. [Configurar application.properties](#passo-7-configurar-applicationproperties)
8. [Executar Aplicação](#passo-8-executar-aplicação)
9. [Testar](#passo-9-testar)

---

## Passo 1: Acessar Spring Initializr

1. Abra seu navegador
2. Acesse: **https://start.spring.io/**
3. A página do Spring Initializr será exibida

![Spring Initializr](https://start.spring.io/)

---

## Passo 2: Configurar Projeto

Preencha os campos na ordem:

### Project
- Selecione: **Maven Project**
- ✅ Maven é a ferramenta de build mais usada

### Language
- Selecione: **Java**

### Spring Boot
- Selecione: **3.4.0** (ou versão 3.4.x mais recente)
- ⚠️ Use versão 3.4.x conforme solicitado

### Project Metadata

#### Group
- Digite: **com.techCamps**
- 📝 Identificador único da organização

#### Artifact
- Digite: **demo**
- 📝 Nome do projeto

#### Name
- Digite: **demo**
- 📝 Nome da aplicação

#### Description
- Digite: **Projeto Demo usando Spring Boot JPA**

#### Package name
- Automático: **com.techCamps.demo**
- ✅ Gerado automaticamente a partir de Group + Artifact

#### Packaging
- Selecione: **Jar**
- 📦 JAR para aplicações standalone

#### Java
- Selecione: **17**
- ☕ Java 17 LTS (Long Term Support)

---

## Passo 3: Adicionar Dependências

Clique no botão **"ADD DEPENDENCIES..."** (Ctrl+B)

Procure e adicione as seguintes dependências:

### 1. Spring Boot DevTools
- **Buscar:** "devtools"
- **Função:** Hot reload durante desenvolvimento
- **Categoria:** Developer Tools

### 2. Lombok
- **Buscar:** "lombok"
- **Função:** Reduz código boilerplate
- **Categoria:** Developer Tools

### 3. Spring Web
- **Buscar:** "web"
- **Função:** Criar APIs REST
- **Categoria:** Web

### 4. Spring Data JPA
- **Buscar:** "jpa"
- **Função:** Persistência com JPA/Hibernate
- **Categoria:** SQL

### 5. H2 Database
- **Buscar:** "h2"
- **Função:** Banco de dados em memória
- **Categoria:** SQL

**Lista final de dependências:**
- ✅ Spring Boot DevTools
- ✅ Lombok
- ✅ Spring Web
- ✅ Spring Data JPA
- ✅ H2 Database

---

## Passo 4: Gerar e Baixar

1. Revise todas as configurações
2. Clique no botão **"GENERATE"** (Ctrl+Enter)
3. O arquivo **demo.zip** será baixado

---

## Passo 5: Descompactar

### Windows
1. Localize o arquivo **demo.zip** na pasta Downloads
2. Clique com botão direito → **Extrair tudo...**
3. Escolha um local (ex: C:\workspace\)
4. Clique em **Extrair**

### Linux/Mac
```bash
unzip ~/Downloads/demo.zip -d ~/workspace/
```

### Estrutura Esperada
```
demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/techCamps/demo/
│   │   │       └── DemoApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── .gitignore
```

---

## Passo 6: Importar na IDE

### IntelliJ IDEA (Recomendado)
1. Abra IntelliJ IDEA
2. **File** → **Open**
3. Navegue até a pasta **demo**
4. Selecione a pasta e clique **OK**
5. Aguarde o IntelliJ importar o projeto Maven
6. Aguarde baixar as dependências (barra de progresso no rodapé)

### Eclipse / STS
1. Abra Eclipse
2. **File** → **Import**
3. **Maven** → **Existing Maven Projects**
4. **Next**
5. **Browse** → Selecione a pasta **demo**
6. **Finish**
7. Aguarde o Maven baixar dependências

### VS Code
1. Abra VS Code
2. **File** → **Open Folder**
3. Selecione a pasta **demo**
4. Instale extensões recomendadas:
   - Java Extension Pack
   - Spring Boot Extension Pack

---

## Passo 7: Configurar application.properties

1. Navegue até: **src/main/resources/application.properties**
2. Abra o arquivo (estará vazio)
3. Adicione as seguintes configurações:

```properties
server.port=8090
server.servlet.context-path=/api-demo-jpa
```

4. Salve o arquivo (Ctrl+S)

### Explicação das Configurações

#### server.port=8090
- Define a porta do servidor Tomcat
- Padrão seria 8080
- Usamos 8090 conforme solicitado

#### server.servlet.context-path=/api-demo-jpa
- Define o prefixo de todas as URLs
- Exemplo: /api-demo-jpa/users
- Ajuda a organizar múltiplas APIs

---

## Passo 8: Executar Aplicação

### Opção 1: Pela IDE (Mais Fácil)

#### IntelliJ IDEA
1. Abra **DemoApplication.java**
2. Clique na seta verde ao lado da classe
3. Selecione **Run 'DemoApplication'**

#### Eclipse
1. Abra **DemoApplication.java**
2. Clique com botão direito
3. **Run As** → **Java Application**

### Opção 2: Maven (Linha de Comando)

```bash
# Navegar até a pasta do projeto
cd C:\workspace\demo

# Executar
mvn spring-boot:run
```

### Opção 3: Script Batch (Windows)

```bash
run.bat
```

### Logs de Inicialização

Você verá algo assim:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.0)

2025-11-28T22:30:00.000 INFO  --- [main] c.t.demo.DemoApplication : Starting DemoApplication...
2025-11-28T22:30:01.000 INFO  --- [main] o.s.b.w.embedded.tomcat.TomcatWebServer : Tomcat initialized with port 8090 (http)
2025-11-28T22:30:02.000 INFO  --- [main] o.s.b.w.embedded.tomcat.TomcatWebServer : Tomcat started on port 8090 (http) with context path '/api-demo-jpa'
2025-11-28T22:30:02.000 INFO  --- [main] c.t.demo.DemoApplication : Started DemoApplication in 2.5 seconds
```

✅ **Procure por:** "Started DemoApplication"

---

## Passo 9: Testar

### 1. Abrir Navegador
- Chrome, Firefox, Edge, etc.

### 2. Acessar URL
```
http://localhost:8090/api-demo-jpa
```

### 3. Resultado Esperado

Você verá uma página com:

```
Whitelabel Error Page

This application has no explicit mapping for /error, so you are seeing this as a fallback.

Thu Nov 28 22:30:00 BRT 2025
There was an unexpected error (type=Not Found, status=404).
```

### ✅ Isso está CORRETO!

**Por quê?**
- A aplicação está rodando perfeitamente
- Ainda não criamos nenhum endpoint (controller)
- A mensagem de erro é esperada neste momento
- O servidor está escutando na porta 8090
- O contexto /api-demo-jpa está configurado

---

## 🎉 Parabéns!

Você concluiu com sucesso:

- ✅ Criação do projeto via Spring Initializr
- ✅ Adição de todas as dependências
- ✅ Importação na IDE
- ✅ Configuração do application.properties
- ✅ Execução da aplicação
- ✅ Validação via navegador

---

## 📂 Arquivos Solicitados

Os seguintes arquivos foram criados e estão prontos para entrega:

### 1. DemoApplication.java
**Localização:** `com/techCamps/demo/DemoApplication.java`

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

### 2. application.properties
**Localização:** `application.properties`

```properties
server.port=8090
server.servlet.context-path=/api-demo-jpa
```

### 3. pom.xml
**Localização:** `pom.xml`

Contém todas as dependências:
- Spring Boot 3.4.0
- Spring Web
- Spring Data JPA
- H2 Database
- Lombok
- DevTools

---

## 🔧 Próximos Passos

Agora que a aplicação base está configurada, você pode:

1. **Criar Entities** - Modelar entidades JPA
2. **Criar Repositories** - Acesso a dados
3. **Criar Services** - Lógica de negócio
4. **Criar Controllers** - Endpoints REST
5. **Habilitar H2 Console** - Visualizar banco de dados
6. **Adicionar validações** - Bean Validation

---

## ❓ Troubleshooting

### Porta 8090 ocupada
**Erro:** Port 8090 is already in use

**Solução:** Altere a porta em application.properties
```properties
server.port=8091
```

### Dependências não baixadas
**Sintoma:** Erros de importação

**Solução:**
```bash
mvn clean install -U
```

### Lombok não funciona
**Sintoma:** Erros em @Data, @Getter, etc.

**Solução:** Instale o plugin Lombok na IDE

### Java 17 não encontrado
**Erro:** Could not find Java 17

**Solução:** 
1. Baixe Java 17 JDK
2. Configure JAVA_HOME
3. Configure IDE para usar Java 17

---

**Repository:** bradesco-hbtn-microsservicos-java
**Directory:** 0x03/criando_spring_boot_JPA
**Files:** com/techCamps/demo/DemoApplication.java, application.properties, pom.xml

**Status:** ✅ **Projeto Configurado com Sucesso!**

