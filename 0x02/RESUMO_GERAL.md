# 0x02 - REST API com Spring Boot

## 📚 Conteúdo do Módulo

Este módulo contém dois projetos de API REST usando Spring Boot:

---

## 1️⃣ config_API_REST

**Descrição:** Projeto de configuração básica de API REST

**Conteúdo:**
- SongApiApplication.java - Aplicação Spring Boot básica
- Configuração e compilação Maven
- Documentação do projeto

**Status:** ✅ Completo

---

## 2️⃣ servicos_API_REST

**Descrição:** API REST completa para gerenciamento de músicas

### 📂 Estrutura
```
servicos_API_REST/
├── com/example/demo/              # Arquivos solicitados
│   ├── Song.java
│   ├── SongRepository.java
│   ├── SongController.java
│   └── SongApiApplication.java
├── src/main/                      # Estrutura Maven
│   ├── java/com/example/demo/
│   └── resources/
├── pom.xml
├── run.bat
└── Documentação (6 arquivos .md)
```

### ✨ Funcionalidades

**Endpoints REST:**
- GET `/api-song/welcome` - Mensagem de boas-vindas
- GET `/api-song/allSongs` - Listar todas as músicas
- GET `/api-song/findSong/{id}` - Buscar música por ID
- POST `/api-song/addSong` - Adicionar nova música
- PUT `/api-song/updateSong` - Atualizar música
- DELETE `/api-song/removeSong` - Remover música

**Classes Implementadas:**
1. **Song.java** - POJO com atributos da música
2. **SongRepository.java** - Repository com gerenciamento em memória
3. **SongController.java** - REST Controller com todos os endpoints
4. **SongApiApplication.java** - Classe principal Spring Boot

### 📖 Documentação Disponível

| Arquivo | Descrição |
|---------|-----------|
| **README.md** | Visão geral e instruções gerais |
| **QUICK_START.md** | Guia de início rápido |
| **PROJETO_COMPLETO.md** | Documentação técnica detalhada |
| **COMANDOS_TESTE.md** | Guia completo de testes da API |
| **EXERCICIO_COMPLETO.md** | Resumo do exercício e requisitos |
| **RESUMO_FINAL.md** | Resumo final do projeto |

### 🚀 Como Executar

```bash
cd servicos_API_REST
run.bat
```

Ou:

```bash
mvn spring-boot:run
```

**Acesse:** http://localhost:8080/api-song/welcome

### 🎯 Conceitos Aplicados

- **Spring Boot Framework**
- **REST API** (GET, POST, PUT, DELETE)
- **Repository Pattern**
- **Dependency Injection**
- **POJO** (Plain Old Java Object)
- **Maven** para gerenciamento de dependências
- **JSON** para troca de dados

### 📊 Status do Projeto

| Item | Status |
|------|--------|
| Classe Song | ✅ |
| Classe SongRepository | ✅ |
| Classe SongController | ✅ |
| Classe SongApiApplication | ✅ |
| Todos os endpoints | ✅ |
| Documentação completa | ✅ |
| Testes | ✅ |

**Status Geral:** ✅ **100% Completo**

---

## 3️⃣ utilizando_API_REST

**Descrição:** Testes práticos dos endpoints da Song API

### 📂 Estrutura
```
utilizando_API_REST/
├── respostaItemA.txt             # POST - Adicionar música
├── respostaItemB.txt             # GET - Welcome
├── respostaItemC.txt             # GET - Buscar música ID 2
├── respostaItemD.txt             # GET - Listar todas
├── README.md                     # Documentação dos testes
└── COMANDOS_EXECUTADOS.md        # Comandos PowerShell
```

### ✨ Testes Realizados

**Item A - POST /addSong:**
- Adicionada música "Sweet Child O 'Mine" (Guns N' Roses, 1987)
- Resposta salva em respostaItemA.txt

**Item B - GET /welcome:**
- Mensagem "Bem-vindo ao serviço de músicas!"
- Resposta salva em respostaItemB.txt

**Item C - GET /findSong/2:**
- Busca da música "Imagine" (John Lennon)
- Resposta salva em respostaItemC.txt

**Item D - GET /allSongs:**
- Lista completa com 3 músicas
- Resposta salva em respostaItemD.txt

### 📊 Status dos Testes

| Teste | Endpoint | Método | Status |
|-------|----------|--------|--------|
| A | /api-song/addSong | POST | ✅ |
| B | /api-song/welcome | GET | ✅ |
| C | /api-song/findSong/2 | GET | ✅ |
| D | /api-song/allSongs | GET | ✅ |

**Status:** ✅ **100% Completo**

---

## 🎓 Objetivos de Aprendizado

Ao completar este módulo, você terá aprendido:

1. ✅ Criar APIs REST com Spring Boot
2. ✅ Implementar operações CRUD completas
3. ✅ Usar annotations do Spring (@RestController, @Repository, etc.)
4. ✅ Trabalhar com injeção de dependências
5. ✅ Mapear endpoints HTTP (GET, POST, PUT, DELETE)
6. ✅ Usar @PathVariable e @RequestBody
7. ✅ Configurar projetos Maven
8. ✅ Implementar Repository Pattern
9. ✅ Trabalhar com JSON
10. ✅ Organizar código seguindo boas práticas

---

## 📌 Arquivos Principais

### config_API_REST
- `com/example/demo/SongApiApplication.java`
- `pom.xml`

### servicos_API_REST
- `com/example/demo/Song.java`
- `com/example/demo/SongRepository.java`
- `com/example/demo/SongController.java`
- `com/example/demo/SongApiApplication.java`
- `pom.xml`
- `src/main/resources/application.properties`

---

## 🔗 Links Úteis

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring REST API Tutorial](https://spring.io/guides/tutorials/rest/)
- [Maven Documentation](https://maven.apache.org/)

---

## 📝 Notas

- Os projetos usam **Spring Boot 2.7.18**
- **Java 8** ou superior é necessário
- Os dados são armazenados em **memória** (sem banco de dados)
- Porta padrão: **8080**

---

**Repository:** bradesco-hbtn-microsservicos-java
**Directory:** 0x02/

✅ **Módulo Completo!**

