# 🧪 Comandos para Testar os Endpoints

## Usando cURL (PowerShell ou CMD)

### 1. simpleMessageWelcome
```bash
curl http://localhost:8080/messages/simpleMessageWelcome
```

**Resultado esperado:**
```
BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!
```

---

### 2. login - Cenário 1: Sucesso
```bash
curl "http://localhost:8080/messages/login?user=admin&password=12345"
```

**Resultado esperado:**
```
LOGIN EFETUADO COM SUCESSO !!!
```

---

### 3. login - Cenário 2: Sem parâmetros
```bash
curl http://localhost:8080/messages/login
```

**Resultado esperado:**
```
USUÁRIO E SENHA NÃO INFORMADOS
```

---

### 4. login - Cenário 3: User vazio
```bash
curl "http://localhost:8080/messages/login?user=&password=12345"
```

**Resultado esperado:**
```
USUÁRIO E SENHA NÃO INFORMADOS
```

---

### 5. login - Cenário 4: Password vazio
```bash
curl "http://localhost:8080/messages/login?user=admin&password="
```

**Resultado esperado:**
```
USUÁRIO E SENHA NÃO INFORMADOS
```

---

### 6. login - Cenário 5: User muito longo (> 15 caracteres)
```bash
curl "http://localhost:8080/messages/login?user=usuariomuitolongodemais&password=12345"
```

**Resultado esperado:**
```
USUÁRIO E SENHA INVÁLIDOS
```

---

### 7. login - Cenário 6: Password muito longo (> 15 caracteres)
```bash
curl "http://localhost:8080/messages/login?user=admin&password=senhamuitolongademais"
```

**Resultado esperado:**
```
USUÁRIO E SENHA INVÁLIDOS
```

---

## URLs para o Navegador

### simpleMessageWelcome
```
http://localhost:8080/messages/simpleMessageWelcome
```

### login - Sucesso
```
http://localhost:8080/messages/login?user=admin&password=12345
```

### login - Sem parâmetros
```
http://localhost:8080/messages/login
```

### login - User muito longo
```
http://localhost:8080/messages/login?user=usuariomuitolongodemais&password=12345
```

---

## Configuração do Postman

### Collection: Demo Microservices

#### Request 1: Simple Message Welcome
- **Nome:** Simple Message Welcome
- **Método:** GET
- **URL:** `http://localhost:8080/messages/simpleMessageWelcome`
- **Headers:** (nenhum necessário)
- **Params:** (nenhum)

#### Request 2: Login Success
- **Nome:** Login Success
- **Método:** GET
- **URL:** `http://localhost:8080/messages/login`
- **Params:**
  - Key: `user` | Value: `admin`
  - Key: `password` | Value: `12345`

#### Request 3: Login No Params
- **Nome:** Login No Params
- **Método:** GET
- **URL:** `http://localhost:8080/messages/login`
- **Params:** (nenhum)

#### Request 4: Login Invalid Length
- **Nome:** Login Invalid Length
- **Método:** GET
- **URL:** `http://localhost:8080/messages/login`
- **Params:**
  - Key: `user` | Value: `usuariomuitolongodemais`
  - Key: `password` | Value: `12345`

---

## Teste Completo via PowerShell

Copie e cole este script completo no PowerShell para testar todos os cenários:

```powershell
Write-Host "`n=== TESTANDO ENDPOINTS ===" -ForegroundColor Green

Write-Host "`n1. simpleMessageWelcome" -ForegroundColor Yellow
curl http://localhost:8080/messages/simpleMessageWelcome

Write-Host "`n`n2. login - Sucesso" -ForegroundColor Yellow
curl "http://localhost:8080/messages/login?user=admin&password=12345"

Write-Host "`n`n3. login - Sem parâmetros" -ForegroundColor Yellow
curl http://localhost:8080/messages/login

Write-Host "`n`n4. login - User muito longo" -ForegroundColor Yellow
curl "http://localhost:8080/messages/login?user=usuariomuitolongodemais&password=12345"

Write-Host "`n`n5. login - Password muito longo" -ForegroundColor Yellow
curl "http://localhost:8080/messages/login?user=admin&password=senhamuitolongademais"

Write-Host "`n`n=== TESTES CONCLUÍDOS ===" -ForegroundColor Green
```

---

## Verificar se a aplicação está rodando

### PowerShell
```powershell
Test-NetConnection -ComputerName localhost -Port 8080
```

### CMD
```cmd
netstat -an | findstr :8080
```

### cURL
```bash
curl http://localhost:8080/actuator/health
```
(Nota: este endpoint só funciona se o Spring Boot Actuator estiver habilitado)

---

## Salvar respostas em arquivos

### PowerShell
```powershell
# Salvar simpleMessageWelcome
curl http://localhost:8080/messages/simpleMessageWelcome -OutFile simpleMessageWelcome_result.txt

# Salvar login (sucesso)
curl "http://localhost:8080/messages/login?user=admin&password=12345" -OutFile login_result.txt
```

### CMD
```cmd
REM Salvar simpleMessageWelcome
curl http://localhost:8080/messages/simpleMessageWelcome > simpleMessageWelcome_result.txt

REM Salvar login (sucesso)
curl "http://localhost:8080/messages/login?user=admin&password=12345" > login_result.txt
```

---

**Dica:** Mantenha este arquivo aberto enquanto testa os endpoints! 📋

