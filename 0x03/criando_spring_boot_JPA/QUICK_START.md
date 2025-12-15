# Quick Start - Spring Boot JPA

## 🚀 Início Rápido

### 1️⃣ Configuração do Spring Initializr

Acesse: **https://start.spring.io/**

**Configurações:**
```
Project: Maven Project
Language: Java
Spring Boot: 3.4.x
Group: com.techCamps
Artifact: demo
Name: demo
Description: Projeto Demo usando Spring Boot JPA
Package: com.techCamps.demo
Packaging: jar
Java: 17
```

**Dependências:**
- Spring Boot DevTools
- Lombok
- Spring Web
- Spring Data JPA
- H2 Database

**Botão:** GENERATE → Baixar demo.zip

---

### 2️⃣ Descompactar e Importar

```bash
# Descompactar
unzip demo.zip

# Importar na IDE
File → Open → Selecionar pasta demo
```

---

### 3️⃣ Configurar application.properties

**Arquivo:** `src/main/resources/application.properties`

```properties
server.port=8090
server.servlet.context-path=/api-demo-jpa
```

---

### 4️⃣ Executar

**Na IDE:**
```
DemoApplication.java → Run As → Java Application
```

**Ou Maven:**
```bash
mvn spring-boot:run
```

---

### 5️⃣ Testar

**URL:** http://localhost:8090/api-demo-jpa

**Resultado esperado:**
```
Whitelabel Error Page
This application has no explicit mapping for /error
```

✅ **Aplicação funcionando!** (ainda sem endpoints)

---

## 📂 Arquivos Principais

```
├── com/techCamps/demo/
│   └── DemoApplication.java          ✅
├── src/main/resources/
│   └── application.properties        ✅
└── pom.xml                            ✅
```

---

## 🎯 Dependências no pom.xml

```xml
<!-- Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- H2 -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
</dependency>

<!-- DevTools -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

---

## ✅ Checklist

- [ ] Spring Initializr configurado
- [ ] Dependências adicionadas
- [ ] Projeto baixado (demo.zip)
- [ ] Projeto importado na IDE
- [ ] application.properties modificado
- [ ] Porta: 8090
- [ ] Context-path: /api-demo-jpa
- [ ] Aplicação executada
- [ ] URL testada
- [ ] "Whitelabel Error Page" exibida

---

## 🔧 Comandos

```bash
# Compilar
mvn clean install

# Executar
mvn spring-boot:run

# Empacotar
mvn package

# Executar JAR
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

---

## 📍 URLs

| URL | Descrição |
|-----|-----------|
| http://localhost:8090/api-demo-jpa | Aplicação |
| https://start.spring.io/ | Spring Initializr |

---

**Status:** ✅ Pronto para começar!

