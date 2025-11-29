# Acessando o Console H2 - Guia Completo

## 📋 Objetivo

Configurar uma base de dados no banco H2 e acessá-la pelo console H2 web.

---

## ⚠️ IMPORTANTE - Requisito de Java

**Spring Boot 3.4.0 requer Java 17!**

Se você estiver usando Java 8, precisa atualizar para Java 17:
- Download: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- Ou use OpenJDK 17: https://adoptium.net/

---

## 🚀 Passo a Passo

### Passo 1: Copiar Projeto Anterior

Faça uma cópia do projeto `criando_spring_boot_JPA`:
```bash
cp -r criando_spring_boot_JPA acessando_h2_console
cd acessando_h2_console
```

---

### Passo 2: Atualizar application.properties

Abra o arquivo `src/main/resources/application.properties` e **adicione** as seguintes configurações:

```properties
server.port=8090
server.servlet.context-path=/api-demo-jpa

spring.datasource.url=jdbc:h2:file:./bd/demobd
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=123456

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

#### Explicação das Configurações:

**Datasource:**
- `spring.datasource.url` - URL do banco H2 (arquivo em ./bd/demobd)
- `spring.datasource.driverClassName` - Driver JDBC do H2
- `spring.datasource.username` - Usuário: **sa**
- `spring.datasource.password` - Senha: **123456**

**H2 Console:**
- `spring.h2.console.enabled=true` - Habilita o console web do H2
- `spring.h2.console.path=/h2-console` - Caminho do console

**JPA:**
- `spring.jpa.database-platform` - Dialeto Hibernate para H2
- `spring.jpa.hibernate.ddl-auto=update` - Atualiza schema automaticamente

---

### Passo 3: Iniciar a Aplicação

```bash
mvn spring-boot:run
```

Ou execute a classe `DemoApplication.java` na IDE:
- **IntelliJ:** Run → Run 'DemoApplication'
- **Eclipse:** Run As → Java Application

---

### Passo 4: Acessar o Console H2

Abra o navegador e acesse:
```
http://localhost:8090/api-demo-jpa/h2-console/
```

Você verá uma tela de login do H2 Console:

![H2 Console Login](https://i.imgur.com/...)

---

### Passo 5: Configurar Conexão

Na tela de login do H2, preencha os campos:

| Campo | Valor |
|-------|-------|
| **Saved Settings** | Generic H2 (Embedded) |
| **Setting Name** | Generic H2 (Embedded) |
| **Driver Class** | org.h2.Driver |
| **JDBC URL** | `jdbc:h2:file:./bd/demobd` |
| **User Name** | `sa` |
| **Password** | `123456` |

**IMPORTANTE:** 
- O campo **JDBC URL** deve ter exatamente o valor de `spring.datasource.url`
- **User Name** deve ser `sa`
- **Password** deve ser `123456`

Após preencher, clique em **Connect**.

---

### Passo 6: Console H2 Conectado

Após a conexão, você verá a interface do H2 Console com 3 áreas principais:

```
┌─────────────────────────────────────────┐
│  1. DEMOBD.MV.DB (Sidebar esquerdo)     │  ← Informação 1
├─────────────────────────────────────────┤
│  2. jdbc:h2:file:./bd/demobd (Topo)     │  ← Informação 2
├─────────────────────────────────────────┤
│  3. SELECT * FROM ... (Área SQL)         │  ← Informação 3
└─────────────────────────────────────────┘
```

---

### Passo 7: Criar infosBD.txt

Crie um arquivo `infosBD.txt` com o conteúdo que aparece na sua tela:

**Exemplo de infosBD.txt:**
```
1. DEMOBD.MV.DB
2. jdbc:h2:file:./bd/demobd
3. SA
```

**Observação:** Os valores exatos dependem da sua tela. Transcreva conforme aparecem para você.

**Valores típicos:**
- **1.** Nome do banco de dados (geralmente `DEMOBD.MV.DB` ou similar)
- **2.** URL JDBC completa
- **3.** Nome do usuário (geralmente `SA`)

---

### Passo 8: Localizar Arquivo do Banco

O arquivo do banco de dados H2 é criado automaticamente na pasta `bd`:

```
acessando_h2_console/
└── bd/
    ├── demobd.mv.db          ← Arquivo do banco
    └── demobd.trace.db       (pode existir)
```

---

## 📂 Arquivos Solicitados

Os seguintes arquivos devem ser entregues:

### 1. infosBD.txt
**Localização:** `0x03/acessando_h2_console/`

**Conteúdo:** As 3 informações visíveis no H2 Console

**Exemplo:**
```
1. DEMOBD.MV.DB
2. jdbc:h2:file:./bd/demobd
3. SA
```

### 2. application.properties
**Localização:** `0x03/acessando_h2_console/`

**Conteúdo:** Todas as configurações do H2

### 3. demobd.mv.db
**Localização:** `0x03/acessando_h2_console/bd/`

**Descrição:** Arquivo do banco de dados H2

---

## 🔍 O Que Cada Informação Significa

### Informação 1: Nome do Banco
- Aparece na **sidebar esquerda**
- Geralmente: `DEMOBD.MV.DB`
- É o nome do schema/banco

### Informação 2: URL JDBC
- Aparece no **topo da página** (após conectar)
- Exemplo: `jdbc:h2:file:./bd/demobd`
- É a conexão ativa

### Informação 3: Usuário
- Aparece na **área de status** ou **topo**
- Geralmente: `SA` (maiúsculo)
- É o usuário conectado

---

## 🧪 Testando o Banco de Dados

Após conectar ao H2 Console, você pode executar SQLs:

```sql
-- Ver todas as tabelas
SHOW TABLES;

-- Criar uma tabela de teste
CREATE TABLE TESTE (
    ID INT PRIMARY KEY,
    NOME VARCHAR(100)
);

-- Inserir dados
INSERT INTO TESTE VALUES (1, 'Teste Spring Boot');

-- Consultar
SELECT * FROM TESTE;
```

---

## 📊 Estrutura de Diretórios

```
acessando_h2_console/
├── bd/
│   └── demobd.mv.db                    ✅ Arquivo solicitado
├── src/
│   └── main/
│       ├── java/com/techCamps/demo/
│       │   └── DemoApplication.java
│       └── resources/
│           └── application.properties  ✅ Arquivo solicitado
├── infosBD.txt                         ✅ Arquivo solicitado
├── pom.xml
└── README.md
```

---

## ⚙️ Configurações Detalhadas

### spring.datasource.url
```
jdbc:h2:file:./bd/demobd
```
- `jdbc:h2` - Protocolo JDBC do H2
- `file:` - Banco em arquivo (não memória)
- `./bd/demobd` - Caminho do arquivo (pasta bd, arquivo demobd)

### spring.h2.console.enabled
```
true
```
- Habilita o console web do H2
- Permite acessar via navegador
- **Cuidado:** Desabilite em produção!

### spring.jpa.hibernate.ddl-auto
```
update
```
- `create` - Cria schema do zero (apaga dados)
- `update` - Atualiza schema preservando dados
- `validate` - Apenas valida
- `none` - Não faz nada

---

## 🚨 Troubleshooting

### Erro: "Database not found"
**Solução:** A aplicação criará o banco na primeira execução. Execute a aplicação primeiro.

### Erro: "Wrong user or password"
**Solução:** Verifique se está usando:
- User: `sa`
- Password: `123456`

### Console H2 não abre
**Solução:** Verifique se:
1. Aplicação está rodando
2. URL está correta: `http://localhost:8090/api-demo-jpa/h2-console/`
3. `spring.h2.console.enabled=true` está no properties

### Porta 8090 ocupada
**Solução:** Mude a porta em application.properties:
```properties
server.port=8091
```

### Erro: "class file has wrong version 61.0"
**Solução:** Você está usando Java 8, mas precisa de Java 17!
- Baixe e instale Java 17
- Configure `JAVA_HOME`
- Reinicie a IDE

---

## 💡 Dicas

1. **Backup do Banco:** Copie o arquivo `demobd.mv.db` regularmente
2. **Console em Prod:** **NUNCA** habilite em produção
3. **Senha Forte:** Em projetos reais, use senhas fortes
4. **Arquivo vs Memória:** 
   - `jdbc:h2:file:./bd/demobd` - Persistente
   - `jdbc:h2:mem:testdb` - Em memória (reseta ao reiniciar)

---

## 📚 Recursos Adicionais

- [H2 Database Documentation](http://www.h2database.com/)
- [Spring Boot JPA](https://spring.io/guides/gs/accessing-data-jpa/)
- [Hibernate Configuration](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html)

---

**Repository:** bradesco-hbtn-microsservicos-java
**Directory:** 0x03/acessando_h2_console
**Files:** 
- infosBD.txt
- application.properties
- demobd.mv.db

**Status:** ✅ Configuração completa para acesso ao H2 Console!

