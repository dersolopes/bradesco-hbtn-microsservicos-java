# Correções nos Arquivos de Resposta

## 🔧 Problemas Identificados e Corrigidos

### Problema 1: BOM (Byte Order Mark)
**Erro:** Arquivo começava com `﻿` (UTF-8 BOM)
**Correção:** Removido o BOM, arquivos agora começam diretamente com o conteúdo

### Problema 2: Unicode Escape Sequences
**Erro:** Apóstrofos eram convertidos para `\u0027`
- `"Sweet Child O \u0027Mine"` ❌
- `"Guns N\u0027 Roses"` ❌

**Correção:** Apóstrofos normais usados
- `"Sweet Child O 'Mine"` ✅
- `"Guns N' Roses"` ✅

### Problema 3: Espaçamento Extra no JSON
**Erro:** Espaços extras após os dois pontos
- `"nome":  "Sweet..."` ❌ (dois espaços)

**Correção:** Espaçamento padrão JSON
- `"nome": "Sweet..."` ✅ (um espaço)

### Problema 4: Formato do respostaItemD.txt
**Erro:** PowerShell adicionava metadados `{"value": [...], "Count": 3}`

**Correção:** Array JSON puro `[...]`

---

## ✅ Arquivos Corrigidos

### respostaItemA.txt
```json
{
    "id": 3,
    "nome": "Sweet Child O 'Mine",
    "artista": "Guns N' Roses",
    "album": "Appetite for Destruction",
    "anoLancamento": "1987"
}
```

### respostaItemB.txt
```
Bem-vindo ao serviço de músicas!
```

### respostaItemC.txt
```json
{
    "id": 2,
    "nome": "Imagine",
    "artista": "John Lennon",
    "album": "Imagine",
    "anoLancamento": "1971"
}
```

### respostaItemD.txt
```json
[
    {
        "id": 1,
        "nome": "Bohemian Rhapsody",
        "artista": "Queen",
        "album": "A Night at the Opera",
        "anoLancamento": "1975"
    },
    {
        "id": 2,
        "nome": "Imagine",
        "artista": "John Lennon",
        "album": "Imagine",
        "anoLancamento": "1971"
    },
    {
        "id": 3,
        "nome": "Sweet Child O 'Mine",
        "artista": "Guns N' Roses",
        "album": "Appetite for Destruction",
        "anoLancamento": "1987"
    }
]
```

---

## 🎯 Validação

Todos os arquivos agora:
- ✅ Sem BOM (UTF-8 puro)
- ✅ Apóstrofos normais (não escapados)
- ✅ Espaçamento JSON padrão
- ✅ Formato correto (JSON válido ou texto simples)
- ✅ Encoding correto

---

## 📝 Como os Arquivos Foram Gerados Corretamente

Para evitar esses problemas no futuro, os arquivos devem ser salvos diretamente do JSON retornado pela API, sem usar `ConvertTo-Json` do PowerShell.

### Comando Correto (cURL - Bash/WSL)
```bash
# Item A
curl -X POST http://localhost:8080/api-song/addSong \
  -H "Content-Type: application/json" \
  -d '{"id":3,"nome":"Sweet Child O '"'"'Mine","artista":"Guns N'"'"' Roses","album":"Appetite for Destruction","anoLancamento":"1987"}' \
  > respostaItemA.txt

# Item B
curl http://localhost:8080/api-song/welcome > respostaItemB.txt

# Item C
curl http://localhost:8080/api-song/findSong/2 > respostaItemC.txt

# Item D
curl http://localhost:8080/api-song/allSongs > respostaItemD.txt
```

---

**Status:** ✅ Todos os arquivos corrigidos e prontos para validação!

