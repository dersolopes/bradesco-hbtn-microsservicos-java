# 🚀 Quick Start - Início Rápido

## Para começar AGORA:

### 1️⃣ Abrir no IntelliJ IDEA
```
File > Open > Selecione a pasta:
C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x01\spring_boot_1\demo
```

### 2️⃣ Aguardar o Maven baixar as dependências
Veja a barra de progresso na parte inferior do IntelliJ.

### 3️⃣ Executar
- Abra `DemoApplication.java`
- Clique no ícone verde de play ▶️
- Aguarde ver a mensagem: `Started DemoApplication`

### 4️⃣ Testar no navegador
```
http://localhost:8080/messages/simpleMessageWelcome
http://localhost:8080/messages/login?user=admin&password=12345
```

## ✅ Arquivos Criados (conforme exercício)

```
✓ demo/src/main/java/com/example/demo/DemoApplication.java
✓ demo/src/main/java/com/example/demo/MessageResource.java
✓ simpleMessageWelcome_result.txt
✓ login_result.txt
```

## 📚 Mais Informações

Veja o arquivo `GUIA_INTELLIJ.md` para instruções detalhadas.

## 🎯 Endpoints Implementados

### 1. simpleMessageWelcome
- **URL:** GET `/messages/simpleMessageWelcome`
- **Resposta:** "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!"

### 2. login
- **URL:** GET `/messages/login?user={user}&password={password}`
- **Regras:**
  - Sem parâmetros → "USUÁRIO E SENHA NÃO INFORMADOS"
  - Mais de 15 caracteres → "USUÁRIO E SENHA INVÁLIDOS"  
  - Válido → "LOGIN EFETUADO COM SUCESSO !!!"

## 🔧 Tecnologias Usadas
- Java 17
- Spring Boot 3.2.0
- Spring Web
- Maven

---

**Pronto para começar!** 🎉

