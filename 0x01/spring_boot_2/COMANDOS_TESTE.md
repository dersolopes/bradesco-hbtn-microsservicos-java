# 🧪 Comandos de Teste - Demo2

## Testar o Endpoint /messages/home

### 1. Navegador
Simplesmente abra:
```
http://localhost:8080/messages/home
```

---

### 2. cURL (PowerShell)
```powershell
curl http://localhost:8080/messages/home
```

**Salvar em arquivo:**
```powershell
curl http://localhost:8080/messages/home -OutFile home_result.txt
```

---

### 3. cURL (CMD)
```cmd
curl http://localhost:8080/messages/home
```

**Salvar em arquivo:**
```cmd
curl http://localhost:8080/messages/home > home_result.txt
```

---

### 4. Postman

**Request:**
- Método: **GET**
- URL: `http://localhost:8080/messages/home`
- Headers: (nenhum necessário)

**Para salvar:**
1. Clique em **Send**
2. **Save Response**
3. **Save to a file**
4. Nome do arquivo: `home_result.txt`

---

### 5. IntelliJ HTTP Client

Crie um arquivo `requests.http`:

```http
### Test home endpoint
GET http://localhost:8080/messages/home
Accept: text/plain

###
```

Execute clicando no ícone verde ao lado da requisição.

---

## Testar o Console H2

### Acessar Console:
```
http://localhost:8080/h2-console
```

### Credenciais:
```
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (vazio)
```

### Queries de Teste:
```sql
-- Ver todas as tabelas
SHOW TABLES;

-- Criar uma tabela de teste
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255)
);

-- Inserir dados
INSERT INTO users (name, email) VALUES ('João', 'joao@email.com');
INSERT INTO users (name, email) VALUES ('Maria', 'maria@email.com');

-- Consultar dados
SELECT * FROM users;

-- Atualizar dados
UPDATE users SET name = 'João Silva' WHERE id = 1;

-- Deletar dados
DELETE FROM users WHERE id = 2;
```

---

## Verificar se a Aplicação está Rodando

### PowerShell:
```powershell
Test-NetConnection -ComputerName localhost -Port 8080
```

### CMD:
```cmd
netstat -an | findstr :8080
```

### cURL:
```bash
curl http://localhost:8080/messages/home
```

Se retornar a mensagem, está rodando! ✅

---

## Comandos Maven Úteis

### Executar via Maven:
```bash
cd demo2
mvn spring-boot:run
```

### Compilar:
```bash
mvn clean compile
```

### Executar testes:
```bash
mvn test
```

### Criar JAR:
```bash
mvn clean package
```

### Executar JAR gerado:
```bash
java -jar target/demo2-0.0.1-SNAPSHOT.jar
```

### Ver dependências:
```bash
mvn dependency:tree
```

### Limpar build:
```bash
mvn clean
```

---

## Script PowerShell - Teste Completo

Copie e cole no PowerShell para testar tudo:

```powershell
Write-Host "`n=== TESTANDO DEMO2 ===" -ForegroundColor Green

# Verificar se está rodando
Write-Host "`n1. Verificando porta 8080..." -ForegroundColor Yellow
$connection = Test-NetConnection -ComputerName localhost -Port 8080 -WarningAction SilentlyContinue
if ($connection.TcpTestSucceeded) {
    Write-Host "   ✅ Aplicação rodando na porta 8080" -ForegroundColor Green
} else {
    Write-Host "   ❌ Aplicação NÃO está rodando!" -ForegroundColor Red
    Write-Host "   Execute Demo2Application primeiro!" -ForegroundColor Yellow
    exit
}

# Testar endpoint /messages/home
Write-Host "`n2. Testando endpoint /messages/home..." -ForegroundColor Yellow
$response = curl http://localhost:8080/messages/home 2>$null
Write-Host "   Resposta: $response" -ForegroundColor Cyan

# Verificar se é a resposta esperada
$expected = "PROJETO MAVEN (SPRING INITIALIZR) CRIADO COM SUCESSO !!!"
if ($response -eq $expected) {
    Write-Host "   ✅ Resposta correta!" -ForegroundColor Green
} else {
    Write-Host "   ❌ Resposta diferente do esperado!" -ForegroundColor Red
}

# Salvar resultado
Write-Host "`n3. Salvando resultado em home_result.txt..." -ForegroundColor Yellow
curl http://localhost:8080/messages/home -OutFile home_result.txt 2>$null
Write-Host "   ✅ Arquivo salvo!" -ForegroundColor Green

Write-Host "`n=== TESTES CONCLUÍDOS ===" -ForegroundColor Green
Write-Host "`nAcesse também:" -ForegroundColor Cyan
Write-Host "  - Endpoint: http://localhost:8080/messages/home" -ForegroundColor White
Write-Host "  - Console H2: http://localhost:8080/h2-console" -ForegroundColor White
Write-Host ""
```

---

## Testar DevTools (Hot Reload)

### Passo a passo:

1. **Execute a aplicação**
   ```
   Demo2Application.java > Run
   ```

2. **Teste o endpoint:**
   ```
   http://localhost:8080/messages/home
   ```
   Resultado: `PROJETO MAVEN (SPRING INITIALIZR) CRIADO COM SUCESSO !!!`

3. **Edite HelloWorldResource.java:**
   ```java
   @GetMapping("/home")
   public String home() {
       return "MENSAGEM ALTERADA COM DEVTOOLS !!!";
   }
   ```

4. **Salve o arquivo (Ctrl+S)**

5. **Aguarde o DevTools reiniciar** (veja no console)

6. **Teste novamente:**
   ```
   http://localhost:8080/messages/home
   ```
   Resultado: `MENSAGEM ALTERADA COM DEVTOOLS !!!`

✅ **Hot reload funcionou!** Não precisou parar e reiniciar manualmente!

---

## Testar Lombok

### Criar uma classe de teste:

Crie `User.java` em `com.example.demo2`:

```java
package com.example.demo2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
}
```

### Usar no HelloWorldResource:

```java
@GetMapping("/user")
public User getUser() {
    return User.builder()
        .id(1L)
        .name("João Silva")
        .email("joao@email.com")
        .build();
}
```

### Testar:
```
http://localhost:8080/messages/user
```

**Resultado (JSON):**
```json
{
  "id": 1,
  "name": "João Silva",
  "email": "joao@email.com"
}
```

✅ **Lombok funcionou!** Criou getters, setters, builder, etc. automaticamente!

---

## Logs Úteis

### Ver logs no console:
- Quando a aplicação inicia
- Quando recebe requisições
- Quando o DevTools reinicia
- Queries SQL (se `spring.jpa.show-sql=true`)

### Adicionar logs personalizados:

Use Lombok `@Slf4j`:

```java
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/messages")
public class HelloWorldResource {

    @GetMapping("/home")
    public String home() {
        log.info("Endpoint /home foi chamado");
        return "PROJETO MAVEN (SPRING INITIALIZR) CRIADO COM SUCESSO !!!";
    }
}
```

Agora você verá no console quando o endpoint for chamado!

---

## Comandos Git

### Adicionar ao repositório:

```bash
cd C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java

git add 0x01/spring_boot_2/

git commit -m "Add spring_boot_2 - Demo2 com Spring Initializr"

git push origin main
```

### Verificar status:
```bash
git status
```

### Ver diferenças:
```bash
git diff
```

---

## Resumo - URLs Importantes

| Descrição | URL |
|-----------|-----|
| Endpoint home | `http://localhost:8080/messages/home` |
| Console H2 | `http://localhost:8080/h2-console` |
| Actuator (se habilitado) | `http://localhost:8080/actuator` |

---

**Todos os comandos prontos para uso!** 🧪

