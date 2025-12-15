# Quick Start - Song API

## 🚀 Iniciar Rapidamente

### 1️⃣ Executar a Aplicação

```bash
cd C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x02\servicos_API_REST
mvn spring-boot:run
```

Ou simplesmente:
```bash
run.bat
```

### 2️⃣ Testar Endpoints

**Abra o navegador:**
```
http://localhost:8080/api-song/welcome
http://localhost:8080/api-song/allSongs
http://localhost:8080/api-song/findSong/1
```

### 3️⃣ Testar com cURL

```bash
# Listar todas
curl http://localhost:8080/api-song/allSongs

# Buscar por ID
curl http://localhost:8080/api-song/findSong/1

# Adicionar música
curl -X POST http://localhost:8080/api-song/addSong -H "Content-Type: application/json" -d "{\"id\":3,\"nome\":\"Hotel California\",\"artista\":\"Eagles\",\"album\":\"Hotel California\",\"anoLancamento\":\"1976\"}"

# Atualizar música
curl -X PUT http://localhost:8080/api-song/updateSong -H "Content-Type: application/json" -d "{\"id\":3,\"nome\":\"Hotel California - Remastered\",\"artista\":\"Eagles\",\"album\":\"Hotel California Deluxe\",\"anoLancamento\":\"2013\"}"

# Remover música
curl -X DELETE http://localhost:8080/api-song/removeSong -H "Content-Type: application/json" -d "{\"id\":3}"
```

## 📋 Resumo dos Endpoints

| Método | URL | Descrição |
|--------|-----|-----------|
| GET | `/api-song/welcome` | Mensagem de boas-vindas |
| GET | `/api-song/allSongs` | Lista todas as músicas |
| GET | `/api-song/findSong/{id}` | Busca por ID |
| POST | `/api-song/addSong` | Adiciona música |
| PUT | `/api-song/updateSong` | Atualiza música |
| DELETE | `/api-song/removeSong` | Remove música |

## 📦 Estrutura de Dados (JSON)

```json
{
  "id": 1,
  "nome": "Bohemian Rhapsody",
  "artista": "Queen",
  "album": "A Night at the Opera",
  "anoLancamento": "1975"
}
```

## ✅ Dados Iniciais

A aplicação inicia com 2 músicas:
1. **Bohemian Rhapsody** (Queen, 1975)
2. **Imagine** (John Lennon, 1971)

## 🛠️ Comandos Úteis

```bash
# Compilar
mvn clean install

# Executar
mvn spring-boot:run

# Compilar sem testes
mvn clean install -DskipTests

# Executar JAR
java -jar target/SongApi-0.0.1-SNAPSHOT.jar
```

## 📚 Documentação Completa

- **README.md** - Visão geral e instruções
- **PROJETO_COMPLETO.md** - Documentação detalhada
- **COMANDOS_TESTE.md** - Guia completo de testes

## 🎯 Arquivos Principais

```
com/example/demo/
├── Song.java              # POJO
├── SongRepository.java    # Repository
├── SongController.java    # REST Controller
└── SongApiApplication.java # Main
```

## 💡 Dicas

- Use **Postman** para testar endpoints POST, PUT e DELETE
- Porta padrão: **8080**
- Formato: **JSON**
- As músicas ficam apenas em **memória** (não há banco de dados)
- Ao reiniciar, volta aos dados iniciais

## ❓ Problemas Comuns

**Porta 8080 ocupada?**
```properties
# Altere em src/main/resources/application.properties
server.port=8081
```

**Maven não encontrado?**
```bash
# Instale o Maven ou use o wrapper:
mvnw spring-boot:run
```

## 🎉 Pronto!

Sua API REST está funcionando! Acesse:
```
http://localhost:8080/api-song/welcome
```

