# Comandos Utilizados nos Testes da Song API

## 🚀 Iniciar a Aplicação

```bash
cd C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x02\servicos_API_REST
mvn spring-boot:run
```

---

## 📝 Comandos PowerShell Executados

### Item A: POST - Adicionar Música "Sweet Child O 'Mine"

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
    Out-File -FilePath "C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x02\utilizando_API_REST\respostaItemA.txt" -Encoding UTF8
```

**Resultado:** ✅ Música adicionada e resposta salva em `respostaItemA.txt`

---

### Item B: GET - Mensagem de Boas-vindas

```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api-song/welcome" `
    -Method GET | `
    Out-File -FilePath "C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x02\utilizando_API_REST\respostaItemB.txt" -Encoding UTF8
```

**Resultado:** ✅ Mensagem recebida e salva em `respostaItemB.txt`

---

### Item C: GET - Buscar Segunda Música (ID 2)

```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api-song/findSong/2" `
    -Method GET | ConvertTo-Json -Depth 10 | `
    Out-File -FilePath "C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x02\utilizando_API_REST\respostaItemC.txt" -Encoding UTF8
```

**Resultado:** ✅ Música "Imagine" encontrada e resposta salva em `respostaItemC.txt`

---

### Item D: GET - Listar Todas as Músicas

```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api-song/allSongs" `
    -Method GET | ConvertTo-Json -Depth 10 | `
    Out-File -FilePath "C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x02\utilizando_API_REST\respostaItemD.txt" -Encoding UTF8
```

**Resultado:** ✅ Lista com 3 músicas retornada e salva em `respostaItemD.txt`

---

## 🔧 Comandos Alternativos (cURL - Bash/Linux)

### Item A: POST

```bash
curl -X POST http://localhost:8080/api-song/addSong \
  -H "Content-Type: application/json" \
  -d '{"id":3,"nome":"Sweet Child O '"'"'Mine","artista":"Guns N'"'"' Roses","album":"Appetite for Destruction","anoLancamento":"1987"}' \
  -o respostaItemA.txt
```

### Item B: GET - Welcome

```bash
curl http://localhost:8080/api-song/welcome -o respostaItemB.txt
```

### Item C: GET - Find Song 2

```bash
curl http://localhost:8080/api-song/findSong/2 -o respostaItemC.txt
```

### Item D: GET - All Songs

```bash
curl http://localhost:8080/api-song/allSongs -o respostaItemD.txt
```

---

## 📋 Verificar Arquivos Criados

```powershell
# Listar arquivos
dir C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x02\utilizando_API_REST\*.txt

# Ver conteúdo
Get-Content respostaItemA.txt
Get-Content respostaItemB.txt
Get-Content respostaItemC.txt
Get-Content respostaItemD.txt
```

---

## 🧪 Testes Adicionais (Opcional)

### Atualizar Música

```powershell
$body = @{
    id=3;
    nome="Sweet Child O 'Mine - Remastered";
    artista="Guns N' Roses";
    album="Appetite for Destruction (Deluxe Edition)";
    anoLancamento="2018"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/api-song/updateSong" `
    -Method PUT `
    -Body $body `
    -ContentType "application/json"
```

### Remover Música

```powershell
$body = @{id=3} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/api-song/removeSong" `
    -Method DELETE `
    -Body $body `
    -ContentType "application/json"
```

---

## 📊 Status dos Testes

| Item | Comando | Status | Arquivo Gerado |
|------|---------|--------|----------------|
| A | POST addSong | ✅ | respostaItemA.txt |
| B | GET welcome | ✅ | respostaItemB.txt |
| C | GET findSong/2 | ✅ | respostaItemC.txt |
| D | GET allSongs | ✅ | respostaItemD.txt |

---

## 💡 Dicas

1. **Verificar se a aplicação está rodando:**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api-song/welcome"
```

2. **Verificar porta em uso:**
```powershell
netstat -ano | findstr :8080
```

3. **Parar a aplicação:**
Pressione `Ctrl + C` no terminal onde o Maven está executando

4. **Visualizar logs:**
Os logs aparecem no terminal onde você executou `mvn spring-boot:run`

---

## ✅ Resumo

Todos os comandos foram executados com sucesso e os 4 arquivos de resposta foram criados:

✅ respostaItemA.txt
✅ respostaItemB.txt
✅ respostaItemC.txt
✅ respostaItemD.txt

**Data:** 28/11/2025
**Status:** Completo

