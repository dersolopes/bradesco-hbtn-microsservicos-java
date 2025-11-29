# Utilizando a API REST - Song API

## 📝 Descrição

Este diretório contém os resultados dos testes realizados nos endpoints da **Song API**, conforme solicitado no exercício.

---

## ✅ Testes Realizados

### Item A: Adicionar Nova Música (POST)

**Endpoint:** `POST http://localhost:8080/api-song/addSong`

**Dados Enviados:**
```json
{
    "id": 3,
    "nome": "Sweet Child O 'Mine",
    "artista": "Guns N' Roses",
    "album": "Appetite for Destruction",
    "anoLancamento": "1987"
}
```

**Arquivo de Resposta:** `respostaItemA.txt`

**Comando PowerShell:**
```powershell
$body = @{
    id=3;
    nome="Sweet Child O 'Mine";
    artista="Guns N' Roses";
    album="Appetite for Destruction";
    anoLancamento="1987"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/api-song/addSong" `
    -Method POST `
    -Body $body `
    -ContentType "application/json" | ConvertTo-Json -Depth 10 | `
    Out-File -FilePath "respostaItemA.txt" -Encoding UTF8
```

**Status:** ✅ Música adicionada com sucesso

---

### Item B: Mensagem de Boas-vindas (GET)

**Endpoint:** `GET http://localhost:8080/api-song/welcome`

**Arquivo de Resposta:** `respostaItemB.txt`

**Comando PowerShell:**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api-song/welcome" `
    -Method GET | `
    Out-File -FilePath "respostaItemB.txt" -Encoding UTF8
```

**Resposta Esperada:** "Bem-vindo ao serviço de músicas!"

**Status:** ✅ Mensagem recebida com sucesso

---

### Item C: Buscar Segunda Música (GET)

**Endpoint:** `GET http://localhost:8080/api-song/findSong/2`

**Arquivo de Resposta:** `respostaItemC.txt`

**Comando PowerShell:**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api-song/findSong/2" `
    -Method GET | ConvertTo-Json -Depth 10 | `
    Out-File -FilePath "respostaItemC.txt" -Encoding UTF8
```

**Música Retornada:** 
- ID: 2
- Nome: "Imagine"
- Artista: "John Lennon"
- Álbum: "Imagine"
- Ano: "1971"

**Status:** ✅ Música encontrada com sucesso

---

### Item D: Listar Todas as Músicas (GET)

**Endpoint:** `GET http://localhost:8080/api-song/allSongs`

**Arquivo de Resposta:** `respostaItemD.txt`

**Comando PowerShell:**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api-song/allSongs" `
    -Method GET | ConvertTo-Json -Depth 10 | `
    Out-File -FilePath "respostaItemD.txt" -Encoding UTF8
```

**Músicas Retornadas:**
1. Bohemian Rhapsody - Queen (1975)
2. Imagine - John Lennon (1971)
3. Sweet Child O 'Mine - Guns N' Roses (1987) ← **Adicionada no Item A**

**Status:** ✅ Lista completa retornada (3 músicas)

---

## 📂 Arquivos Gerados

| Arquivo | Descrição | Status |
|---------|-----------|--------|
| **respostaItemA.txt** | Resposta do POST (adicionar música) | ✅ |
| **respostaItemB.txt** | Resposta do GET /welcome | ✅ |
| **respostaItemC.txt** | Resposta do GET /findSong/2 | ✅ |
| **respostaItemD.txt** | Resposta do GET /allSongs | ✅ |

---

## 🚀 Como Executar os Testes

### 1. Iniciar a Aplicação

No diretório `0x02/servicos_API_REST`:

```bash
mvn spring-boot:run
```

Ou:

```bash
run.bat
```

### 2. Aguardar a Inicialização

Aguarde até ver a mensagem:
```
Started SongApiApplication in X.XXX seconds
```

### 3. Executar os Comandos

Use os comandos PowerShell listados acima ou utilize o **Postman**.

---

## 🧪 Testando com Postman

### Item A: POST - Adicionar Música

1. **Method:** POST
2. **URL:** `http://localhost:8080/api-song/addSong`
3. **Headers:**
   - Content-Type: application/json
4. **Body (raw JSON):**
```json
{
    "id": 3,
    "nome": "Sweet Child O 'Mine",
    "artista": "Guns N' Roses",
    "album": "Appetite for Destruction",
    "anoLancamento": "1987"
}
```

### Item B: GET - Welcome

1. **Method:** GET
2. **URL:** `http://localhost:8080/api-song/welcome`

### Item C: GET - Buscar Música ID 2

1. **Method:** GET
2. **URL:** `http://localhost:8080/api-song/findSong/2`

### Item D: GET - Listar Todas

1. **Method:** GET
2. **URL:** `http://localhost:8080/api-song/allSongs`

---

## 📊 Resumo dos Resultados

### ✅ Todos os Testes Executados com Sucesso!

| Teste | Endpoint | Método | Status | Arquivo |
|-------|----------|--------|--------|---------|
| A | /api-song/addSong | POST | ✅ 200 OK | respostaItemA.txt |
| B | /api-song/welcome | GET | ✅ 200 OK | respostaItemB.txt |
| C | /api-song/findSong/2 | GET | ✅ 200 OK | respostaItemC.txt |
| D | /api-song/allSongs | GET | ✅ 200 OK | respostaItemD.txt |

---

## 🎯 Validações Realizadas

### ✅ Item A - Adicionar Música
- Música "Sweet Child O 'Mine" foi adicionada com sucesso
- ID 3 foi atribuído corretamente
- Todos os campos foram salvos corretamente

### ✅ Item B - Mensagem de Boas-vindas
- Endpoint /welcome retornou a mensagem esperada
- "Bem-vindo ao serviço de músicas!"

### ✅ Item C - Buscar Segunda Música
- Música "Imagine" (ID 2) foi encontrada
- Todos os dados retornados corretamente:
  - Artista: John Lennon
  - Álbum: Imagine
  - Ano: 1971

### ✅ Item D - Listar Todas as Músicas
- Retornou 3 músicas no total:
  1. Bohemian Rhapsody (inicial)
  2. Imagine (inicial)
  3. Sweet Child O 'Mine (adicionada no Item A)
- Ordem preservada
- Todos os campos completos

---

## 💡 Observações

1. **Porta da Aplicação:** 8080 (configurada em application.properties)
2. **Formato de Dados:** JSON
3. **Encoding:** UTF-8
4. **PowerShell:** Comandos testados no Windows PowerShell
5. **Persistência:** Dados em memória (reiniciar a aplicação apaga as músicas adicionadas)

---

## 🎉 Conclusão

Todos os **4 endpoints** foram testados com sucesso e as respostas foram salvas nos arquivos correspondentes:

✅ **respostaItemA.txt** - POST addSong
✅ **respostaItemB.txt** - GET welcome
✅ **respostaItemC.txt** - GET findSong/2
✅ **respostaItemD.txt** - GET allSongs

A API REST está **funcionando perfeitamente** e todos os requisitos foram atendidos!

---

**Repository:** bradesco-hbtn-microsservicos-java
**Directory:** 0x02/utilizando_API_REST
**Files:** respostaItemA.txt, respostaItemB.txt, respostaItemC.txt, respostaItemD.txt

**Data dos Testes:** 28/11/2025
**Status:** ✅ **COMPLETO**

