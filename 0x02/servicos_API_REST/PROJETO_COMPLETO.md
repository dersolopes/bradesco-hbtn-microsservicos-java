# Song API - Projeto Completo

## Visão Geral

Este projeto implementa uma **API REST completa** para gerenciamento de músicas usando **Spring Boot**. A aplicação não utiliza camada de persistência (banco de dados), armazenando as informações em memória através de uma lista gerenciada pelo Repository pattern.

---

## Estrutura do Projeto

```
servicos_API_REST/
├── com/example/demo/           # Arquivos Java (cópia para referência)
│   ├── Song.java
│   ├── SongApiApplication.java
│   ├── SongController.java
│   └── SongRepository.java
├── src/
│   └── main/
│       ├── java/com/example/demo/
│       │   ├── Song.java               # Classe POJO
│       │   ├── SongApiApplication.java # Classe principal
│       │   ├── SongController.java     # REST Controller
│       │   └── SongRepository.java     # Repository
│       └── resources/
│           └── application.properties  # Configurações
├── pom.xml                     # Configuração Maven
├── run.bat                     # Script para executar
├── README.md                   # Documentação
└── COMANDOS_TESTE.md          # Guia de testes
```

---

## Classes Implementadas

### 1. Song.java - Classe POJO

**Atributos:**
- `Integer id` - Identificador único da música
- `String nome` - Nome da música
- `String artista` - Nome do artista
- `String album` - Nome do álbum
- `String anoLancamento` - Ano de lançamento

**Métodos:**
- Construtor padrão (sem parâmetros)
- Construtor com todos os atributos
- Getters e Setters para todos os atributos
- `hashCode()` - Geração de hash baseado em todos os atributos
- `equals(Object obj)` - Comparação de objetos
- `toString()` - Representação textual do objeto

**Características:**
- Utiliza `java.util.Objects` para implementação de `hashCode()` e `equals()`
- Todos os atributos são privados (encapsulamento)
- Segue as convenções JavaBeans

---

### 2. SongRepository.java - Repository Pattern

**Anotação:** `@Repository`

**Atributos:**
- `List<Song> list` - Lista que armazena as músicas em memória

**Construtor:**
```java
public SongRepository() {
    // Adiciona 2 músicas iniciais
    list.add(new Song(1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"));
    list.add(new Song(2, "Imagine", "John Lennon", "Imagine", "1971"));
}
```

**Métodos:**

1. **`getAllSongs()`**
   - Retorna: `List<Song>`
   - Descrição: Retorna todas as músicas da lista

2. **`getSongById(Integer id)`**
   - Parâmetro: `Integer id` - ID da música
   - Retorna: `Song` ou `null` se não encontrada
   - Descrição: Busca uma música pelo ID

3. **`addSong(Song s)`**
   - Parâmetro: `Song s` - Música a ser adicionada
   - Retorna: `void`
   - Descrição: Adiciona uma nova música à lista

4. **`updateSong(Song s)`**
   - Parâmetro: `Song s` - Música com dados atualizados
   - Retorna: `void`
   - Descrição: Atualiza uma música existente baseado no ID

5. **`removeSong(Song s)`**
   - Parâmetro: `Song s` - Música a ser removida
   - Retorna: `void`
   - Descrição: Remove uma música da lista baseado no ID

---

### 3. SongController.java - REST Controller

**Anotações:** 
- `@RestController` - Define a classe como um controlador REST
- `@RequestMapping("/api-song")` - Define o prefixo base para todos os endpoints

**Dependência:**
```java
@Autowired
private SongRepository songRepository;
```

**Endpoints Implementados:**

#### 1. Mensagem de Boas-vindas
```java
@GetMapping("/welcome")
public String mensagemBoasVindas()
```
- **URL:** `/api-song/welcome`
- **Método HTTP:** GET
- **Retorno:** String com mensagem "Bem-vindo ao serviço de músicas!"

#### 2. Listar Todas as Músicas
```java
@GetMapping(path = "/allSongs")
public List<Song> getAllSongs()
```
- **URL:** `/api-song/allSongs`
- **Método HTTP:** GET
- **Retorno:** Lista JSON com todas as músicas

#### 3. Buscar Música por ID
```java
@GetMapping(path = "/findSong/{id}")
public Song findSongById(@PathVariable Integer id)
```
- **URL:** `/api-song/findSong/{id}`
- **Método HTTP:** GET
- **Parâmetro:** `id` (path variable)
- **Retorno:** Objeto JSON da música ou null

#### 4. Adicionar Nova Música
```java
@PostMapping(path = "/addSong", consumes = "application/json", produces = "application/json")
public Song addSong(@RequestBody Song song)
```
- **URL:** `/api-song/addSong`
- **Método HTTP:** POST
- **Content-Type:** application/json
- **Body:** JSON com dados da música
- **Retorno:** Objeto JSON da música adicionada

#### 5. Atualizar Música
```java
@PutMapping(path = "/updateSong", consumes = "application/json", produces = "application/json")
public Song updadeSong(@RequestBody Song song)
```
- **URL:** `/api-song/updateSong`
- **Método HTTP:** PUT
- **Content-Type:** application/json
- **Body:** JSON com dados atualizados da música
- **Retorno:** Objeto JSON da música atualizada

#### 6. Remover Música
```java
@DeleteMapping(path = "/removeSong", consumes = "application/json", produces = "application/json")
public void deleteSongById(@RequestBody Song song)
```
- **URL:** `/api-song/removeSong`
- **Método HTTP:** DELETE
- **Content-Type:** application/json
- **Body:** JSON com dados da música a remover
- **Retorno:** void (status 200 OK)

---

### 4. SongApiApplication.java - Classe Principal

**Anotação:** `@SpringBootApplication`

```java
@SpringBootApplication
public class SongApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SongApiApplication.class, args);
    }
}
```

**Função:**
- Ponto de entrada da aplicação
- Inicializa o contexto Spring Boot
- Ativa a configuração automática
- Inicia o servidor web embutido (Tomcat)

---

## Configurações

### pom.xml

**Dependências principais:**
- `spring-boot-starter-web` - Para criar APIs REST
- `spring-boot-devtools` - Ferramentas de desenvolvimento
- `spring-boot-starter-test` - Para testes

**Versões:**
- Spring Boot: 2.7.18
- Java: 1.8

### application.properties

```properties
server.port=8080
```

Configura a aplicação para rodar na porta 8080.

---

## Como Executar

### Opção 1: Usando Maven
```bash
mvn spring-boot:run
```

### Opção 2: Compilar e executar JAR
```bash
mvn clean install
java -jar target/SongApi-0.0.1-SNAPSHOT.jar
```

### Opção 3: Script batch (Windows)
```bash
run.bat
```

**Aplicação disponível em:** `http://localhost:8080`

---

## Dados Iniciais

Ao iniciar a aplicação, 2 músicas são carregadas automaticamente:

1. **Bohemian Rhapsody**
   - ID: 1
   - Artista: Queen
   - Álbum: A Night at the Opera
   - Ano: 1975

2. **Imagine**
   - ID: 2
   - Artista: John Lennon
   - Álbum: Imagine
   - Ano: 1971

---

## Exemplos de Uso

### Exemplo 1: Listar todas as músicas

**Requisição:**
```bash
curl http://localhost:8080/api-song/allSongs
```

**Resposta:**
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

### Exemplo 2: Adicionar nova música

**Requisição:**
```bash
curl -X POST http://localhost:8080/api-song/addSong \
  -H "Content-Type: application/json" \
  -d '{
    "id": 3,
    "nome": "Stairway to Heaven",
    "artista": "Led Zeppelin",
    "album": "Led Zeppelin IV",
    "anoLancamento": "1971"
  }'
```

**Resposta:**
```json
{
  "id": 3,
  "nome": "Stairway to Heaven",
  "artista": "Led Zeppelin",
  "album": "Led Zeppelin IV",
  "anoLancamento": "1971"
}
```

---

## Conceitos Aplicados

### 1. REST (Representational State Transfer)
- Arquitetura baseada em HTTP
- Operações CRUD usando verbos HTTP (GET, POST, PUT, DELETE)
- Recursos identificados por URIs
- Formato JSON para troca de dados

### 2. Spring Boot Annotations

| Anotação | Descrição |
|----------|-----------|
| `@SpringBootApplication` | Marca a classe principal |
| `@RestController` | Define um controlador REST |
| `@Repository` | Define um componente de acesso a dados |
| `@Autowired` | Injeção de dependência automática |
| `@RequestMapping` | Mapeia requisições HTTP |
| `@GetMapping` | Atalho para GET requests |
| `@PostMapping` | Atalho para POST requests |
| `@PutMapping` | Atalho para PUT requests |
| `@DeleteMapping` | Atalho para DELETE requests |
| `@PathVariable` | Extrai variável do path |
| `@RequestBody` | Converte JSON para objeto Java |

### 3. Design Patterns
- **Repository Pattern**: Abstração da camada de acesso a dados
- **Dependency Injection**: Injeção automática de dependências
- **POJO (Plain Old Java Object)**: Objeto Java simples sem dependências

### 4. HTTP Status Codes
- 200 OK - Requisição bem-sucedida
- 404 Not Found - Recurso não encontrado
- 500 Internal Server Error - Erro no servidor

---

## Melhorias Futuras (Opcional)

1. **Validação de Dados**
   - Adicionar `@Valid` e Bean Validation
   - Verificar campos obrigatórios

2. **Tratamento de Exceções**
   - Criar `@ControllerAdvice` para tratamento global
   - Retornar mensagens de erro personalizadas

3. **Paginação**
   - Implementar paginação na listagem de músicas

4. **Persistência**
   - Integrar com banco de dados (JPA/Hibernate)
   - MySQL, PostgreSQL ou H2

5. **Documentação da API**
   - Adicionar Swagger/OpenAPI

6. **Testes**
   - Testes unitários com JUnit
   - Testes de integração com MockMvc

---

## Arquivos Necessários (Conforme Solicitado)

✅ `com/example/demo/SongApiApplication.java`
✅ `com/example/demo/SongController.java`
✅ `com/example/demo/SongRepository.java`
✅ `com/example/demo/Song.java`

---

## Tecnologias e Ferramentas

- **Framework:** Spring Boot 2.7.18
- **Linguagem:** Java 8
- **Build Tool:** Maven
- **Server:** Tomcat (embutido)
- **Formato de Dados:** JSON
- **Arquitetura:** REST API

---

## Conclusão

Este projeto demonstra a implementação de uma API REST completa usando Spring Boot, aplicando conceitos modernos de desenvolvimento web, padrões de design e boas práticas de programação Java. A API oferece todas as operações CRUD básicas para gerenciamento de músicas de forma simples e eficiente.

