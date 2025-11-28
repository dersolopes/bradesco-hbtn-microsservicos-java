# Spring Boot - Primeiro Microsserviço

## Configuração no IntelliJ IDEA

### Passo 1: Importar o Projeto
1. Abra o IntelliJ IDEA
2. Selecione **File > Open**
3. Navegue até a pasta `0x01/spring_boot_1/demo`
4. Selecione o arquivo `pom.xml` e clique em **Open**
5. Quando perguntado, selecione **Open as Project**
6. Aguarde o IntelliJ baixar as dependências do Maven

### Passo 2: Executar a Aplicação
1. Abra o arquivo `DemoApplication.java`
2. Clique com o botão direito no arquivo
3. Selecione **Run 'DemoApplication'**
4. Ou clique no ícone de play verde ao lado da classe `DemoApplication`

A aplicação será iniciada na porta 8080.

## Testando os Microsserviços

### 1. Testar simpleMessageWelcome

**Usando o navegador:**
```
http://localhost:8080/messages/simpleMessageWelcome
```

**Usando o Postman:**
- Método: GET
- URL: `http://localhost:8080/messages/simpleMessageWelcome`
- Resultado esperado: `BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!`

**Usando curl (no terminal):**
```bash
curl http://localhost:8080/messages/simpleMessageWelcome
```

### 2. Testar login

**Cenário 1: Usuário e senha válidos**
- URL: `http://localhost:8080/messages/login?user=admin&password=12345`
- Resultado esperado: `LOGIN EFETUADO COM SUCESSO !!!`

**Cenário 2: Usuário ou senha não informados**
- URL: `http://localhost:8080/messages/login`
- Resultado esperado: `USUÁRIO E SENHA NÃO INFORMADOS`

**Cenário 3: Usuário ou senha com mais de 15 caracteres**
- URL: `http://localhost:8080/messages/login?user=usuariomuitolongo&password=12345`
- Resultado esperado: `USUÁRIO E SENHA INVÁLIDOS`

**Usando o Postman:**
- Método: GET
- URL: `http://localhost:8080/messages/login`
- Params: 
  - user: admin
  - password: 12345

**Usando curl:**
```bash
# Teste 1: Sucesso
curl "http://localhost:8080/messages/login?user=admin&password=12345"

# Teste 2: Não informados
curl "http://localhost:8080/messages/login"

# Teste 3: Muito longo
curl "http://localhost:8080/messages/login?user=usuariomuitolongo&password=12345"
```

## Estrutura do Projeto

```
demo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── demo/
│       │               ├── DemoApplication.java
│       │               └── MessageResource.java
│       └── resources/
│           └── application.properties
└── pom.xml
```

## Arquivos de Resultado

Os arquivos `simpleMessageWelcome_result.txt` e `login_result.txt` contêm exemplos de respostas dos microsserviços.

## Observações

- Certifique-se de ter o Java 17 ou superior instalado
- Certifique-se de ter o Maven configurado no IntelliJ IDEA
- A porta padrão é 8080, certifique-se de que não há outro serviço usando esta porta

