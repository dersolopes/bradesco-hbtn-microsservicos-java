# 🚀 Quick Start - Demo2 (Spring Initializr)

## Para começar AGORA:

### 1️⃣ Abrir no IntelliJ IDEA
```
File > Open > Selecione a pasta:
C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x01\spring_boot_2\demo2
```

### 2️⃣ Aguardar o Maven
O IntelliJ vai baixar automaticamente:
- Spring Boot 3.5.5
- Spring Web
- Spring Boot DevTools
- H2 Database
- Lombok

### 3️⃣ Executar
- Abra `Demo2Application.java`
- Clique no play verde ▶️
- Aguarde ver: `Started Demo2Application`

### 4️⃣ Testar
```
http://localhost:8080/messages/home
```

**Resultado esperado:**
```
PROJETO MAVEN (SPRING INITIALIZR) CRIADO COM SUCESSO !!!
```

---

## ✅ Arquivos Criados (conforme exercício)

```
✓ demo2/src/main/java/com/example/demo2/Demo2Application.java
✓ demo2/src/main/java/com/example/demo2/HelloWorldResource.java
✓ demo2/pom.xml
✓ home_result.txt
```

---

## 🎯 Endpoint Implementado

### GET /messages/home
- **URL:** `http://localhost:8080/messages/home`
- **Resposta:** "PROJETO MAVEN (SPRING INITIALIZR) CRIADO COM SUCESSO !!!"

---

## 📦 Dependências Incluídas

1. ✅ **Spring Web** - REST APIs
2. ✅ **Spring Boot DevTools** - Hot reload
3. ✅ **H2 Database** - Banco de dados em memória
4. ✅ **Lombok** - Menos código boilerplate

---

## 🗄️ Bônus: Console H2

Após executar a aplicação, acesse:
```
http://localhost:8080/h2-console
```

**Login:**
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: (vazio)

---

## 🔧 Configurações do Projeto

- **Spring Boot:** 3.5.5
- **Java:** 17
- **Project:** Maven
- **Packaging:** Jar
- **Artifact:** demo2

---

## 🧪 Testar com Postman

1. Método: **GET**
2. URL: `http://localhost:8080/messages/home`
3. Clique em **Send**
4. Save Response > Save to file > `home_result.txt`

---

## 💡 Diferença do Demo1

| Demo1 | Demo2 |
|-------|-------|
| Spring Boot 3.2.0 | Spring Boot 3.5.5 |
| Apenas Spring Web | Spring Web + DevTools + H2 + Lombok |
| Sem banco de dados | Com H2 Database |
| Sem hot reload | Com DevTools (hot reload) |

---

**Pronto para começar!** 🎉

Veja o arquivo **README.md** para mais detalhes.

