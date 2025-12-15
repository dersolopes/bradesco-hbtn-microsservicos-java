# Como Instalar Java 17

## ⚠️ Requisito Importante

Spring Boot 3.4.0 requer **Java 17 ou superior**!

Se você receber o erro:
```
class file has wrong version 61.0, should be 52.0
```

Isso significa que você está usando Java 8 e precisa atualizar para Java 17.

---

## 📥 Download do Java 17

### Opção 1: Oracle JDK 17 (Recomendado)

1. Acesse: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
2. Baixe o instalador para Windows (x64 Installer)
3. Execute o instalador
4. Siga as instruções do instalador

### Opção 2: OpenJDK 17 (Gratuito e Open Source)

1. Acesse: https://adoptium.net/
2. Selecione:
   - Version: 17 - LTS
   - Operating System: Windows
   - Architecture: x64
3. Clique em Download
4. Execute o instalador

---

## ⚙️ Configurar JAVA_HOME

### Windows

1. Após instalar, anote o caminho de instalação (ex: `C:\Program Files\Java\jdk-17`)

2. Configure a variável de ambiente:
   - Pressione `Win + R`
   - Digite `sysdm.cpl` e pressione Enter
   - Vá para aba "Avançado"
   - Clique em "Variáveis de Ambiente"
   - Em "Variáveis do Sistema", clique em "Novo"
   - Nome: `JAVA_HOME`
   - Valor: `C:\Program Files\Java\jdk-17` (seu caminho)
   - Clique OK

3. Atualize o PATH:
   - Na mesma janela, encontre a variável `Path`
   - Clique em "Editar"
   - Clique em "Novo"
   - Adicione: `%JAVA_HOME%\bin`
   - Clique OK em todas as janelas

4. Verifique a instalação:
   ```cmd
   java -version
   ```
   
   Deve mostrar:
   ```
   java version "17.x.x"
   ```

---

## 🔧 Configurar IDE

### IntelliJ IDEA

1. File → Project Structure (Ctrl+Alt+Shift+S)
2. Project Settings → Project
3. SDK: Selecione Java 17
4. Language level: 17
5. Apply → OK

### Eclipse

1. Window → Preferences
2. Java → Installed JREs
3. Add → Standard VM
4. JRE home: Navegue até pasta do Java 17
5. Apply → OK
6. Marque o checkbox do Java 17
7. Apply and Close

### VS Code

1. Instale Extension Pack for Java
2. Abra settings (Ctrl+,)
3. Procure por "java.configuration.runtimes"
4. Edit in settings.json
5. Adicione:
```json
"java.configuration.runtimes": [
    {
        "name": "JavaSE-17",
        "path": "C:\\Program Files\\Java\\jdk-17"
    }
]
```

---

## 🧪 Testar Instalação

1. Abra um novo terminal (CMD ou PowerShell)
2. Execute:
```cmd
java -version
javac -version
```

3. Ambos devem mostrar versão 17.x.x

---

## 🚀 Executar o Projeto

Após instalar Java 17:

1. Feche e reabra sua IDE
2. Navegue até o projeto
```bash
cd C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x03\acessando_h2_console
```

3. Execute:
```bash
mvn clean install
mvn spring-boot:run
```

4. Se tudo estiver correto, a aplicação iniciará e criará o arquivo `bd/demobd.mv.db`

5. Acesse o H2 Console:
```
http://localhost:8090/api-demo-jpa/h2-console/
```

---

## ❓ Troubleshooting

### Erro: 'java' não é reconhecido
**Solução:** Reinicie o terminal ou computador após configurar JAVA_HOME

### Múltiplas versões do Java
**Solução:** Use JAVA_HOME para apontar para Java 17

### Maven ainda usa Java 8
**Solução:** 
1. Verifique `JAVA_HOME`
2. Execute `mvn -version` para ver qual Java o Maven está usando
3. Reinicie a IDE

### IntelliJ não encontra Java 17
**Solução:** 
1. File → Project Structure
2. SDKs → Add SDK → Download JDK
3. Vendor: Oracle OpenJDK
4. Version: 17

---

## 📚 Links Úteis

- [Oracle JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Adoptium OpenJDK](https://adoptium.net/)
- [Spring Boot System Requirements](https://docs.spring.io/spring-boot/system-requirements.html)

---

**Após instalar Java 17, volte ao README.md para continuar o exercício!**

