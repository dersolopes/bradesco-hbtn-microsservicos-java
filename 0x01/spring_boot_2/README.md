# Spring Boot 2 - Projeto com Spring Initializr

## Descrição do Projeto

Este projeto foi criado usando as especificações do **Spring Initializr** com as seguintes configurações:

- **Project:** Maven
- **Language:** Java
- **Spring Boot:** 3.5.5
- **Java:** 17
- **Packaging:** Jar
- **Artifact:** demo2

### Dependências Incluídas

1. ✅ **Spring Web** - Para criar REST APIs
2. ✅ **Spring Boot DevTools** - Hot reload durante desenvolvimento
3. ✅ **H2 Database** - Banco de dados em memória
4. ✅ **Lombok** - Reduz código boilerplate

---

## 📁 Estrutura do Projeto

```
demo2/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo2/
│   │   │       ├── Demo2Application.java          ← Classe principal
│   │   │       └── HelloWorldResource.java        ← REST Controller
│   │   └── resources/
│   │       └── application.properties             ← Configurações
│   └── test/
│       └── java/
│           └── com/example/demo2/
│               └── Demo2ApplicationTests.java
├── pom.xml                                        ← Dependências Maven
└── .gitignore
```

---

## 🚀 Como Executar no IntelliJ IDEA

### Passo 1: Importar o Projeto
1. Abra o IntelliJ IDEA
2. Selecione **File > Open**
3. Navegue até a pasta: `0x01/spring_boot_2/demo2`
4. Selecione a pasta `demo2` ou o arquivo `pom.xml`
5. Clique em **OK**
6. Aguarde o Maven baixar as dependências

### Passo 2: Executar a Aplicação
1. Abra o arquivo `Demo2Application.java`
2. Clique no ícone de play verde ▶️
3. Ou pressione **Shift+F10**
4. Aguarde ver a mensagem: `Started Demo2Application`

### Passo 3: Testar o Endpoint
Abra o navegador e acesse:
```
http://localhost:8080/messages/home
```

**Resultado esperado:**
```
PROJETO MAVEN (SPRING INITIALIZR) CRIADO COM SUCESSO !!!
```

---

## 🎯 Endpoint Implementado

### GET /messages/home

**Descrição:** Retorna uma mensagem de sucesso confirmando a criação do projeto.

**URL Completa:** `http://localhost:8080/messages/home`

**Método:** GET

**Resposta:**
```
PROJETO MAVEN (SPRING INITIALIZR) CRIADO COM SUCESSO !!!
```

---

## 🧪 Testando com Diferentes Ferramentas

### 1. Navegador
Simplesmente acesse:
```
http://localhost:8080/messages/home
```

### 2. cURL (PowerShell/CMD)
```bash
curl http://localhost:8080/messages/home
```

### 3. Postman
- **Método:** GET
- **URL:** `http://localhost:8080/messages/home`
- **Headers:** (nenhum necessário)
- Clique em **Send**
- Para salvar: **Save Response > Save to file > home_result.txt**

### 4. IntelliJ HTTP Client
Crie um arquivo `test.http` com:
```http
### Test home endpoint
GET http://localhost:8080/messages/home
```

---

## 🗄️ Configuração do H2 Database

O banco de dados H2 está configurado e pode ser acessado via console:

**URL do Console H2:**
```
http://localhost:8080/h2-console
```

**Credenciais:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (deixe em branco)

---

## 🔧 Spring Boot DevTools

O DevTools está habilitado e fornece:
- ✅ Hot reload automático ao salvar arquivos
- ✅ LiveReload para refresh automático do navegador
- ✅ Configurações otimizadas para desenvolvimento

---

## 📦 Lombok

O Lombok está incluído para reduzir código boilerplate.

**Para usar Lombok no IntelliJ:**
1. Vá em **File > Settings > Plugins**
2. Procure por "Lombok"
3. Instale o plugin Lombok
4. Reinicie o IntelliJ

**Exemplo de uso:**
```java
import lombok.Data;

@Data
public class User {
    private String name;
    private String email;
    // Getters, Setters, toString, equals, hashCode são gerados automaticamente
}
```

---

## 📝 Arquivos Importantes

### pom.xml
Contém todas as dependências do projeto:
- Spring Web
- Spring Boot DevTools
- H2 Database
- Lombok
- Spring Boot Starter Test

### application.properties
Configurações da aplicação:
- Porta do servidor: 8080
- Configuração do H2 Database
- Console H2 habilitado
- JPA/Hibernate configurado

---

## 🔍 Verificar Dependências

Para verificar se todas as dependências foram baixadas:

1. No IntelliJ, abra a aba **Maven** (lateral direita)
2. Expanda **demo2 > Dependencies**
3. Você deve ver:
   - spring-boot-starter-web
   - spring-boot-devtools
   - h2
   - lombok
   - spring-boot-starter-test

---

## 🐛 Solução de Problemas

### Erro: "Port 8080 already in use"
**Solução:** Altere a porta em `application.properties`:
```properties
server.port=8081
```

### Erro: Lombok não funciona
**Solução:**
1. Instale o plugin Lombok no IntelliJ
2. Habilite "Annotation Processing":
   - **File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors**
   - Marque "Enable annotation processing"

### Maven não baixa dependências
**Solução:**
1. Clique com botão direito em `pom.xml`
2. Selecione **Maven > Reload Project**
3. Ou execute: **Maven > Reimport**

---

## 📊 Comparação com o Projeto 1 (demo)

| Aspecto | Demo (Projeto 1) | Demo2 (Projeto 2) |
|---------|------------------|-------------------|
| Spring Boot Version | 3.2.0 | 3.5.5 |
| Dependências | Spring Web | Spring Web, DevTools, H2, Lombok |
| Endpoints | 2 (simpleMessageWelcome, login) | 1 (home) |
| Banco de Dados | Não | Sim (H2) |
| Hot Reload | Não | Sim (DevTools) |
| Lombok | Não | Sim |

---

## 🎯 Requisitos do Exercício - TODOS IMPLEMENTADOS

- ✅ **a)** Projeto configurado com Spring Initializr (Maven, Java 17, Spring Boot 3.5.5)
- ✅ **b)** Projeto gerado (equivalente ao demo2.zip)
- ✅ **c)** Projeto descompactado no workspace
- ✅ **d)** Pronto para importar no IntelliJ/STS4
- ✅ **e)** Classe HelloWorldResource criada com `@RestController` e `@RequestMapping("/messages")`
- ✅ **f)** Microsserviço `home()` implementado
- ✅ **g)** Arquivo `home_result.txt` criado
- ✅ **h)** Arquivo `pom.xml` pronto para commit

---

## 📤 Arquivos para o Repositório GitHub

Conforme solicitado:

```
✅ demo2/src/main/java/com/example/demo2/Demo2Application.java
✅ demo2/src/main/java/com/example/demo2/HelloWorldResource.java
✅ demo2/pom.xml
✅ home_result.txt
```

**Repositório:** bradesco-hbtn-microsservicos-java  
**Diretório:** 0x01/spring_boot_2/

---

## 💡 Próximos Passos

1. Abra o projeto no IntelliJ IDEA
2. Execute `Demo2Application.java`
3. Teste o endpoint: `http://localhost:8080/messages/home`
4. Explore o console H2: `http://localhost:8080/h2-console`
5. Experimente adicionar novos endpoints!

---

**Projeto criado com sucesso!** 🎉

**Data:** 28/11/2025  
**Tecnologias:** Java 17, Spring Boot 3.5.5, Maven, H2, Lombok

