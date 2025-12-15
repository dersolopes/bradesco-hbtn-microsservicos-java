# Comandos para Testar a Song API

## Iniciar a Aplicação

```bash
mvn spring-boot:run
```

Ou use o arquivo run.bat:
```bash
run.bat
```

## Testes usando cURL

### 1. Teste de Boas-vindas
```bash
curl http://localhost:8080/api-song/welcome
```

**Resultado esperado:**
```
Bem-vindo ao serviço de músicas!
```

### 2. Listar todas as músicas
```bash
curl http://localhost:8080/api-song/allSongs
```

**Resultado esperado:**
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
  }
]
```

### 3. Buscar música por ID
```bash
curl http://localhost:8080/api-song/findSong/1
```

**Resultado esperado:**
```json
{
  "id": 1,
  "nome": "Bohemian Rhapsody",
  "artista": "Queen",
  "album": "A Night at the Opera",
  "anoLancamento": "1975"
}
```

### 4. Adicionar nova música
```bash
curl -X POST http://localhost:8080/api-song/addSong -H "Content-Type: application/json" -d "{\"id\":3,\"nome\":\"Stairway to Heaven\",\"artista\":\"Led Zeppelin\",\"album\":\"Led Zeppelin IV\",\"anoLancamento\":\"1971\"}"
```

**Resultado esperado:**
```json
{
  "id": 3,
  "nome": "Stairway to Heaven",
  "artista": "Led Zeppelin",
  "album": "Led Zeppelin IV",
  "anoLancamento": "1971"
}
```

### 5. Verificar que a música foi adicionada
```bash
curl http://localhost:8080/api-song/allSongs
```

**Resultado esperado:**
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
    "nome": "Stairway to Heaven",
    "artista": "Led Zeppelin",
    "album": "Led Zeppelin IV",
    "anoLancamento": "1971"
  }
]
```

### 6. Atualizar uma música
```bash
curl -X PUT http://localhost:8080/api-song/updateSong -H "Content-Type: application/json" -d "{\"id\":3,\"nome\":\"Stairway to Heaven - Remastered\",\"artista\":\"Led Zeppelin\",\"album\":\"Led Zeppelin IV (Remastered)\",\"anoLancamento\":\"2014\"}"
```

**Resultado esperado:**
```json
{
  "id": 3,
  "nome": "Stairway to Heaven - Remastered",
  "artista": "Led Zeppelin",
  "album": "Led Zeppelin IV (Remastered)",
  "anoLancamento": "2014"
}
```

### 7. Verificar a atualização
```bash
curl http://localhost:8080/api-song/findSong/3
```

**Resultado esperado:**
```json
{
  "id": 3,
  "nome": "Stairway to Heaven - Remastered",
  "artista": "Led Zeppelin",
  "album": "Led Zeppelin IV (Remastered)",
  "anoLancamento": "2014"
}
```

### 8. Remover uma música
```bash
curl -X DELETE http://localhost:8080/api-song/removeSong -H "Content-Type: application/json" -d "{\"id\":3}"
```

**Resultado esperado:** (sem retorno - código 200 OK)

### 9. Verificar que a música foi removida
```bash
curl http://localhost:8080/api-song/allSongs
```

**Resultado esperado:**
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
  }
]
```

### 10. Buscar música que não existe
```bash
curl http://localhost:8080/api-song/findSong/999
```

**Resultado esperado:**
```
null
```

## Testes usando Postman ou navegador

### Navegador (apenas GET)

1. **Boas-vindas:**
   ```
   http://localhost:8080/api-song/welcome
   ```

2. **Listar todas:**
   ```
   http://localhost:8080/api-song/allSongs
   ```

3. **Buscar por ID:**
   ```
   http://localhost:8080/api-song/findSong/1
   ```

### Postman

#### POST - Adicionar música
- **URL:** `http://localhost:8080/api-song/addSong`
- **Método:** POST
- **Headers:** `Content-Type: application/json`
- **Body (raw JSON):**
```json
{
  "id": 4,
  "nome": "Hotel California",
  "artista": "Eagles",
  "album": "Hotel California",
  "anoLancamento": "1976"
}
```

#### PUT - Atualizar música
- **URL:** `http://localhost:8080/api-song/updateSong`
- **Método:** PUT
- **Headers:** `Content-Type: application/json`
- **Body (raw JSON):**
```json
{
  "id": 1,
  "nome": "Bohemian Rhapsody",
  "artista": "Queen",
  "album": "A Night at the Opera - Deluxe Edition",
  "anoLancamento": "2011"
}
```

#### DELETE - Remover música
- **URL:** `http://localhost:8080/api-song/removeSong`
- **Método:** DELETE
- **Headers:** `Content-Type: application/json`
- **Body (raw JSON):**
```json
{
  "id": 4
}
```

## Verificar logs da aplicação

Os logs da aplicação mostrarão as requisições sendo processadas. Observe o console onde a aplicação está rodando.

## Parar a aplicação

Pressione `Ctrl + C` no terminal onde a aplicação está rodando.

