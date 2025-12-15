# Guia Completo - Como Abrir e Executar no IntelliJ IDEA

## Pré-requisitos
- IntelliJ IDEA instalado (Community ou Ultimate)
- JDK 17 ou superior instalado
- Maven (geralmente já vem integrado com o IntelliJ)

## Passo a Passo Detalhado

### 1. Abrir o Projeto no IntelliJ IDEA

**Opção 1: Abrir pelo Menu**
1. Abra o IntelliJ IDEA
2. Clique em **File > Open** (ou **Ctrl+O**)
3. Navegue até a pasta: `C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x01\spring_boot_1\demo`
4. Selecione a pasta `demo` ou o arquivo `pom.xml`
5. Clique em **OK**
6. Se aparecer uma janela perguntando "Trust and Open Project", clique em **Trust Project**
7. Na janela que aparecer, selecione **Open as Project**

**Opção 2: Importar como Projeto Maven**
1. Abra o IntelliJ IDEA
2. Clique em **File > New > Project from Existing Sources**
3. Navegue até: `C:\Users\i098720\Cursos\Holberton\bradesco-hbtn-microsservicos-java\0x01\spring_boot_1\demo\pom.xml`
4. Selecione **Import project from external model > Maven**
5. Clique em **Finish**

### 2. Aguardar Download das Dependências

Após abrir o projeto:
1. O IntelliJ mostrará uma notificação no canto inferior direito
2. Aguarde o Maven baixar todas as dependências do Spring Boot
3. Você verá uma barra de progresso na parte inferior da tela
4. Isso pode levar alguns minutos na primeira vez

### 3. Configurar o JDK (se necessário)

Se o projeto mostrar erros de JDK:
1. Clique em **File > Project Structure** (ou **Ctrl+Alt+Shift+S**)
2. Em **Project**, verifique se o **SDK** está configurado para Java 17 ou superior
3. Se não estiver, clique em **Add SDK > Download JDK**
4. Selecione a versão 17 ou superior e faça o download
5. Clique em **Apply** e **OK**

### 4. Executar a Aplicação

**Método 1: Pelo Arquivo DemoApplication.java**
1. No painel esquerdo (Project), navegue até:
   ```
   demo > src > main > java > com.example.demo > DemoApplication
   ```
2. Clique com o botão direito em `DemoApplication.java`
3. Selecione **Run 'DemoApplication'**
4. Ou simplesmente clique no ícone de play verde (▶) que aparece ao lado da classe

**Método 2: Pelo Menu Run**
1. Clique em **Run > Run...**
2. Selecione **DemoApplication**

**Método 3: Usando Maven (no Terminal do IntelliJ)**
1. Clique em **View > Tool Windows > Terminal** (ou **Alt+F12**)
2. Digite:
   ```
   mvn spring-boot:run
   ```

### 5. Verificar se a Aplicação Iniciou

No console do IntelliJ (parte inferior da tela), você verá algo como:
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.0)

...
...
Tomcat started on port(s): 8080 (http) with context path ''
Started DemoApplication in X.XXX seconds
```

Se você ver a mensagem "Started DemoApplication", significa que está funcionando! ✅

### 6. Testar os Endpoints

#### Teste 1: simpleMessageWelcome

**No Navegador:**
```
http://localhost:8080/messages/simpleMessageWelcome
```

**No Postman:**
- Método: **GET**
- URL: `http://localhost:8080/messages/simpleMessageWelcome`
- Clique em **Send**
- Resultado esperado: `BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!`

**No Terminal (usando curl):**
```bash
curl http://localhost:8080/messages/simpleMessageWelcome
```

#### Teste 2: login (Cenário de Sucesso)

**No Navegador:**
```
http://localhost:8080/messages/login?user=admin&password=12345
```

**No Postman:**
- Método: **GET**
- URL: `http://localhost:8080/messages/login`
- Na aba **Params**, adicione:
  - Key: `user` | Value: `admin`
  - Key: `password` | Value: `12345`
- Clique em **Send**
- Resultado esperado: `LOGIN EFETUADO COM SUCESSO !!!`

#### Teste 3: login (Sem parâmetros)

**No Navegador:**
```
http://localhost:8080/messages/login
```
Resultado esperado: `USUÁRIO E SENHA NÃO INFORMADOS`

#### Teste 4: login (Parâmetros muito longos)

**No Navegador:**
```
http://localhost:8080/messages/login?user=usuariomuitolongodemais&password=12345
```
Resultado esperado: `USUÁRIO E SENHA INVÁLIDOS`

### 7. Salvar Respostas no Postman

Para salvar as respostas como solicitado no exercício:

1. Faça a requisição no Postman
2. Clique em **Save Response**
3. Selecione **Save to a file**
4. Para o primeiro endpoint, salve como: `simpleMessageWelcome_result.txt`
5. Para o segundo endpoint (com sucesso), salve como: `login_result.txt`

### 8. Parar a Aplicação

Para parar a aplicação no IntelliJ:
- Clique no botão vermelho de stop (■) no painel Run
- Ou pressione **Ctrl+F2**

## Estrutura de Arquivos Criada

```
0x01/spring_boot_1/
├── demo/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── example/
│   │       │           └── demo/
│   │       │               ├── DemoApplication.java       ← Classe principal
│   │       │               └── MessageResource.java       ← Controller com endpoints
│   │       └── resources/
│   │           └── application.properties                 ← Configurações
│   ├── pom.xml                                            ← Dependências Maven
│   └── .gitignore
├── simpleMessageWelcome_result.txt                        ← Resultado esperado 1
├── login_result.txt                                       ← Resultado esperado 2
└── README.md

```

## Explicação do Código

### DemoApplication.java
- Classe principal do Spring Boot
- `@SpringBootApplication`: Anotação que habilita auto-configuração do Spring
- `main()`: Método que inicia a aplicação

### MessageResource.java
- `@RestController`: Define que é um controller REST
- `@RequestMapping("/messages")`: Define o path base como `/messages`
- `@GetMapping`: Define endpoints HTTP GET
- `@RequestParam`: Recebe parâmetros da URL

### Regras de Negócio do Endpoint login:
1. Se `user` ou `password` estiverem vazios/nulos → "USUÁRIO E SENHA NÃO INFORMADOS"
2. Se `user` ou `password` tiverem mais de 15 caracteres → "USUÁRIO E SENHA INVÁLIDOS"
3. Caso contrário → "LOGIN EFETUADO COM SUCESSO !!!"

## Possíveis Problemas e Soluções

### Erro: "Port 8080 is already in use"
**Solução:** Algum programa está usando a porta 8080.
- Feche outros servidores que possam estar rodando
- Ou altere a porta em `application.properties`: `server.port=8081`

### Erro: "Cannot resolve symbol 'SpringApplication'"
**Solução:** Maven não baixou as dependências.
- Clique com botão direito no `pom.xml`
- Selecione **Maven > Reload Project**

### Erro: "Release version 17 not supported"
**Solução:** JDK não está configurado corretamente.
- Vá em **File > Project Structure > Project**
- Configure o SDK para Java 17 ou superior

## Dicas

1. **Atalhos úteis no IntelliJ:**
   - `Shift+F10`: Run
   - `Ctrl+F2`: Stop
   - `Shift+Shift`: Search Everywhere
   - `Ctrl+N`: Find Class

2. **Para ver logs detalhados:**
   - Verifique o painel **Run** na parte inferior do IntelliJ

3. **Hot Reload (Opcional):**
   - Adicione a dependência `spring-boot-devtools` para recarregar automaticamente ao fazer mudanças

## Conclusão

Agora você tem um projeto Spring Boot completo funcionando no IntelliJ IDEA! 🎉

Todos os arquivos necessários foram criados conforme o exercício solicitado.

