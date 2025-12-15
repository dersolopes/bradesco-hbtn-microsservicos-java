# Exercício: Serviços API REST - Song API

## 📝 Descrição do Exercício

Criar uma API REST para gerenciamento de músicas usando Spring Boot, sem camada de persistência (dados em memória).

---

## ✅ Requisitos Implementados

### 1. Endpoints da API

✅ **GET** `/api-song/allSongs` - Lista todas as músicas
✅ **GET** `/api-song/findSong/{id}` - Busca música por ID
✅ **POST** `/api-song/addSong` - Adiciona nova música
✅ **PUT** `/api-song/updateSong` - Atualiza música existente
✅ **DELETE** `/api-song/removeSong` - Remove música

### 2. Classe Song (POJO)

✅ Atributos:
- `Integer id`
- `String nome`
- `String artista`
- `String album`
- `String anoLancamento`

✅ Métodos:
- Construtor padrão
- Construtor com todos os atributos
- Getters e Setters
- `hashCode()`
- `equals(Object obj)`
- `toString()`

### 3. Classe SongRepository

✅ Anotação: `@Repository`
✅ Atributo: `List<Song> list = new ArrayList<Song>()`

✅ Métodos implementados:
- `getAllSongs()` - Retorna a lista completa
- `getSongById(Integer id)` - Busca por ID
- `addSong(Song s)` - Adiciona música
- `updateSong(Song s)` - Atualiza música
- `removeSong(Song s)` - Remove música

✅ Construtor inicializa com 2 músicas:
1. id:1, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975"
2. id:2, "Imagine", "John Lennon", "Imagine", "1971"

### 4. Classe SongController

✅ Anotações: `@RestController` e `@RequestMapping("/api-song")`
✅ Injeção de dependência: `@Autowired SongRepository`

✅ Métodos implementados:
- `mensagemBoasVindas()` - Retorna "Bem-vindo ao serviço de músicas!"
- `getAllSongs()` - Lista todas
- `findSongById(@PathVariable Integer id)` - Busca por ID
- `addSong(@RequestBody Song song)` - Adiciona
- `updadeSong(@RequestBody Song song)` - Atualiza
- `deleteSongById(@RequestBody Song song)` - Remove

### 5. Classe SongApiApplication

✅ Anotação: `@SpringBootApplication`
✅ Método `main()` para iniciar a aplicação

---

## 📂 Arquivos Criados

### Arquivos Solicitados (no diretório `com/example/demo/`):

✅ `SongApiApplication.java`
✅ `SongController.java`
✅ `SongRepository.java`
✅ `Song.java`

### Estrutura Completa Maven:

```
servicos_API_REST/
├── com/example/demo/              # ✅ Arquivos solicitados
│   ├── Song.java
│   ├── SongApiApplication.java
│   ├── SongController.java
│   └── SongRepository.java
├── src/main/                      # Estrutura Maven
│   ├── java/com/example/demo/
│   │   ├── Song.java
│   │   ├── SongApiApplication.java
│   │   ├── SongController.java
│   │   └── SongRepository.java
│   └── resources/
│       └── application.properties
├── pom.xml
├── run.bat
├── README.md
├── QUICK_START.md
├── PROJETO_COMPLETO.md
└── COMANDOS_TESTE.md
```

---

## 🚀 Como Executar

### Método 1: Maven
```bash
cd C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x02\servicos_API_REST
mvn spring-boot:run
```

### Método 2: Script Batch
```bash
run.bat
```

### Método 3: JAR Compilado
```bash
mvn clean install
java -jar target/SongApi-0.0.1-SNAPSHOT.jar
```

**Aplicação disponível em:** `http://localhost:8080`

---

## 🧪 Testes Realizados

### Teste 1: Welcome
```bash
curl http://localhost:8080/api-song/welcome
# Resultado: "Bem-vindo ao serviço de músicas!"
```

### Teste 2: Listar Todas
```bash
curl http://localhost:8080/api-song/allSongs
# Resultado: JSON com 2 músicas iniciais
```

### Teste 3: Buscar por ID
```bash
curl http://localhost:8080/api-song/findSong/1
# Resultado: JSON da música "Bohemian Rhapsody"
```

### Teste 4: Adicionar
```bash
curl -X POST http://localhost:8080/api-song/addSong \
  -H "Content-Type: application/json" \
  -d '{"id":3,"nome":"Hotel California","artista":"Eagles","album":"Hotel California","anoLancamento":"1976"}'
# Resultado: JSON da música adicionada
```

### Teste 5: Atualizar
```bash
curl -X PUT http://localhost:8080/api-song/updateSong \
  -H "Content-Type: application/json" \
  -d '{"id":3,"nome":"Hotel California - Live","artista":"Eagles","album":"Hell Freezes Over","anoLancamento":"1994"}'
# Resultado: JSON da música atualizada
```

### Teste 6: Remover
```bash
curl -X DELETE http://localhost:8080/api-song/removeSong \
  -H "Content-Type: application/json" \
  -d '{"id":3}'
# Resultado: Status 200 OK
```

---

## 🎯 Conceitos Aplicados

### Spring Boot Annotations
- `@SpringBootApplication` - Aplicação Spring Boot
- `@RestController` - Controlador REST
- `@Repository` - Componente de repositório
- `@Autowired` - Injeção de dependência
- `@RequestMapping` - Mapear requisições
- `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` - Verbos HTTP
- `@PathVariable` - Variável de caminho
- `@RequestBody` - Corpo da requisição JSON

### REST API
- **GET** - Buscar/Listar recursos
- **POST** - Criar novo recurso
- **PUT** - Atualizar recurso
- **DELETE** - Remover recurso

### Design Patterns
- **Repository Pattern** - Abstração de acesso a dados
- **Dependency Injection** - Injeção de dependências
- **POJO** - Plain Old Java Object

### Java
- Encapsulamento (private + getters/setters)
- Construtores (padrão e com parâmetros)
- Override de métodos (equals, hashCode, toString)
- Generics (List<Song>)
- Lambda expressions (removeIf)

---

## 📊 Resultados

### ✅ Funcionalidades Implementadas

| Funcionalidade | Status | Observações |
|----------------|--------|-------------|
| Classe Song | ✅ | POJO completo com todos os métodos |
| Classe SongRepository | ✅ | Repository com dados iniciais |
| Classe SongController | ✅ | Todos os endpoints REST |
| Classe SongApiApplication | ✅ | Classe principal Spring Boot |
| Endpoint Welcome | ✅ | GET /api-song/welcome |
| Endpoint AllSongs | ✅ | GET /api-song/allSongs |
| Endpoint FindSong | ✅ | GET /api-song/findSong/{id} |
| Endpoint AddSong | ✅ | POST /api-song/addSong |
| Endpoint UpdateSong | ✅ | PUT /api-song/updateSong |
| Endpoint RemoveSong | ✅ | DELETE /api-song/removeSong |
| Configuração Maven | ✅ | pom.xml completo |
| Application Properties | ✅ | Porta 8080 configurada |

### 📄 Documentação Criada

- ✅ **README.md** - Documentação principal
- ✅ **QUICK_START.md** - Guia rápido de início
- ✅ **PROJETO_COMPLETO.md** - Documentação detalhada
- ✅ **COMANDOS_TESTE.md** - Guia de testes
- ✅ **EXERCICIO_COMPLETO.md** - Este arquivo
- ✅ **run.bat** - Script de execução

---

## 💡 Destaques da Implementação

### 1. Código Limpo e Organizado
- Seguindo convenções Java
- Métodos bem nomeados
- Separação de responsabilidades

### 2. Uso Correto de Annotations
- Todas as annotations Spring Boot aplicadas corretamente
- Injeção de dependência com @Autowired
- Mapeamento REST completo

### 3. Implementação Completa do CRUD
- Create (POST)
- Read (GET)
- Update (PUT)
- Delete (DELETE)

### 4. Dados Iniciais
- Repositório inicializa com 2 músicas
- Facilita testes imediatos

### 5. Documentação Abrangente
- Múltiplos arquivos de documentação
- Exemplos de uso
- Guias de teste

---

## 🎓 Aprendizados

Este exercício demonstra:

1. **Criação de API REST** com Spring Boot
2. **Repository Pattern** para gerenciamento de dados
3. **Dependency Injection** com Spring
4. **HTTP Methods** e suas aplicações
5. **JSON** como formato de troca de dados
6. **Annotations** do Spring Framework
7. **POJO** e boas práticas Java
8. **Maven** para gerenciamento de dependências

---

## 📌 Localização dos Arquivos Solicitados

**Diretório:** `0x02/servicos_API_REST`

**Arquivos conforme solicitado:**
```
com/example/demo/SongApiApplication.java    ✅
com/example/demo/SongController.java        ✅
com/example/demo/SongRepository.java        ✅
com/example/demo/Song.java                  ✅
```

**Repository:** `bradesco-hbtn-microsservicos-java`

---

## ✨ Conclusão

Projeto **completamente implementado** e **testado**! 

A API REST de músicas está funcionando perfeitamente, com todos os endpoints CRUD, documentação completa e pronta para uso.

### 🎉 Próximos Passos

1. Executar: `run.bat`
2. Testar endpoints no navegador ou Postman
3. Consultar documentação para mais detalhes

**Exercício concluído com sucesso! ✅**

