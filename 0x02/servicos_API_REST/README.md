# Song API - Serviços REST API

API REST para gerenciamento de músicas desenvolvida com Spring Boot.

## Descrição

Este projeto implementa uma API REST completa para gerenciamento de músicas sem persistência em banco de dados. Os dados são armazenados em memória através de uma lista.

## Estrutura do Projeto

### Classe Song (POJO)
- **id**: Integer
- **nome**: String
- **artista**: String
- **album**: String
- **anoLancamento**: String

Inclui getters/setters, construtores, hashCode, equals e toString.

### Classe SongRepository
Repository com anotação @Repository que gerencia a lista de músicas em memória.

Métodos:
- `getAllSongs()`: Retorna todas as músicas
- `getSongById(Integer id)`: Busca música por ID
- `addSong(Song s)`: Adiciona nova música
- `updateSong(Song s)`: Atualiza música existente
- `removeSong(Song s)`: Remove música

**Dados iniciais:**
1. id:1, música: "Bohemian Rhapsody", artista: "Queen", álbum: "A Night at the Opera", ano: "1975"
2. id:2, música: "Imagine", artista: "John Lennon", álbum: "Imagine", ano: "1971"

### Classe SongController
Controller com anotação @RestController que expõe os endpoints REST.

## Endpoints da API

Base URL: `/api-song`

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api-song/welcome` | Mensagem de boas-vindas |
| GET | `/api-song/allSongs` | Lista todas as músicas |
| GET | `/api-song/findSong/{id}` | Busca música por ID |
| POST | `/api-song/addSong` | Adiciona nova música |
| PUT | `/api-song/updateSong` | Atualiza música existente |
| DELETE | `/api-song/removeSong` | Remove música |

## Como Executar

### Pré-requisitos
- Java 8 ou superior
- Maven

### Compilar e Executar

```bash
# Compilar o projeto
mvn clean install

# Executar a aplicação
mvn spring-boot:run
```

Ou executar diretamente o JAR gerado:

```bash
java -jar target/SongApi-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em: `http://localhost:8080`

## Exemplos de Uso

### 1. Mensagem de Boas-vindas
```bash
curl http://localhost:8080/api-song/welcome
```

### 2. Listar todas as músicas
```bash
curl http://localhost:8080/api-song/allSongs
```

### 3. Buscar música por ID
```bash
curl http://localhost:8080/api-song/findSong/1
```

### 4. Adicionar nova música
```bash
curl -X POST http://localhost:8080/api-song/addSong \
  -H "Content-Type: application/json" \
  -d "{\"id\":3,\"nome\":\"Stairway to Heaven\",\"artista\":\"Led Zeppelin\",\"album\":\"Led Zeppelin IV\",\"anoLancamento\":\"1971\"}"
```

### 5. Atualizar música
```bash
curl -X PUT http://localhost:8080/api-song/updateSong \
  -H "Content-Type: application/json" \
  -d "{\"id\":1,\"nome\":\"Bohemian Rhapsody\",\"artista\":\"Queen\",\"album\":\"A Night at the Opera\",\"anoLancamento\":\"1975\"}"
```

### 6. Remover música
```bash
curl -X DELETE http://localhost:8080/api-song/removeSong \
  -H "Content-Type: application/json" \
  -d "{\"id\":3}"
```

## Tecnologias Utilizadas

- Spring Boot 2.7.18
- Spring Web
- Spring DevTools
- Maven
- Java 8

## Estrutura de Arquivos

```
servicos_API_REST/
├── com/example/demo/
│   ├── Song.java
│   ├── SongRepository.java
│   ├── SongController.java
│   └── SongApiApplication.java
├── src/
│   └── main/
│       ├── java/com/example/demo/
│       │   ├── Song.java
│       │   ├── SongRepository.java
│       │   ├── SongController.java
│       │   └── SongApiApplication.java
│       └── resources/
│           └── application.properties
└── pom.xml
```

## Arquivos Solicitados

Os seguintes arquivos foram criados conforme solicitado:
- `com/example/demo/SongApiApplication.java`
- `com/example/demo/SongController.java`
- `com/example/demo/SongRepository.java`
- `com/example/demo/Song.java`

