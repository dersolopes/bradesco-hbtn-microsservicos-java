# ✅ Arquivo demobd.mv.db Criado!

## 📦 Arquivo do Banco de Dados H2

**Localização:** `0x03/acessando_h2_console/bd/demobd.mv.db`

**Status:** ✅ Criado com sucesso!

---

## 📊 Detalhes do Arquivo

- **Nome:** demobd.mv.db
- **Tipo:** Banco de dados H2 (arquivo binário)
- **Tamanho:** ~1 KB (estrutura básica)
- **Formato:** H2 MVStore (Multi-Version Store)

---

## 🎯 Propósito

Este arquivo é o banco de dados H2 que será usado pela aplicação Spring Boot.

### Configuração no application.properties:
```properties
spring.datasource.url=jdbc:h2:file:./bd/demobd
```

O Spring Boot usará este arquivo para armazenar dados quando você:
1. Executar a aplicação
2. Criar tabelas (entities JPA)
3. Inserir/atualizar dados

---

## 🔄 Como o H2 Funciona

### Arquivo .mv.db
- **MV** = Multi-Version
- Permite transações ACID
- Suporta múltiplas versões de dados
- Armazena schema e dados

### Quando é atualizado
- Ao iniciar a aplicação Spring Boot
- Ao criar/modificar entities JPA
- Ao executar operações CRUD
- Ao fazer queries

---

## 📂 Arquivos Relacionados

```
bd/
├── demobd.mv.db          ← Banco de dados principal
├── demobd.trace.db       (pode ser criado para logs)
└── demobd.lock.db        (criado quando app está rodando)
```

### Outros arquivos que podem aparecer:
- **demobd.trace.db** - Logs de erros/debug
- **demobd.lock.db** - Lock file (quando app está ativo)
- **demobd.*.db** - Backups automáticos

---

## ✅ Verificação

Para verificar se o arquivo está correto:

```bash
# Windows
dir bd\demobd.mv.db

# PowerShell
Get-Item bd\demobd.mv.db

# Linux/Mac
ls -lh bd/demobd.mv.db
```

---

## 🚀 Próximos Passos

1. **Executar aplicação Spring Boot:**
   ```bash
   mvn spring-boot:run
   ```

2. **Acessar H2 Console:**
   ```
   http://localhost:8090/api-demo-jpa/h2-console/
   ```

3. **Conectar ao banco:**
   - JDBC URL: `jdbc:h2:file:./bd/demobd`
   - User: `sa`
   - Password: `123456`

4. **O H2 atualizará o arquivo automaticamente**
   - Criará tabelas do schema
   - Adicionará metadados
   - Aumentará o tamanho conforme necessário

---

## 📝 Observações Importantes

### ⚠️ Arquivo Binário
- Este é um arquivo **binário**, não pode ser editado em editores de texto
- Modificações diretas podem corromper o banco
- Sempre use H2 Console ou JDBC para modificar dados

### 💾 Backup
- Faça backup deste arquivo antes de modificações grandes
- Copie o arquivo .mv.db inteiro
- Não tente editar manualmente

### 🔒 Segurança
- Em produção, use senha forte
- Não commite o arquivo .mv.db no Git (use .gitignore)
- Mantenha backups regulares

---

## 🎉 Arquivo Pronto!

O arquivo `demobd.mv.db` foi criado com sucesso e está pronto para ser usado pela aplicação Spring Boot!

**Localização final:** 
```
C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x03\acessando_h2_console\bd\demobd.mv.db
```

**Próximo passo:** Execute a aplicação com `mvn spring-boot:run` e acesse o H2 Console!

---

**Data de Criação:** 28/11/2025
**Status:** ✅ **PRONTO PARA USO**

