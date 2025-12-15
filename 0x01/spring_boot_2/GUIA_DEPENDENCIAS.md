# 📚 Guia de Dependências - Demo2

## Todas as Dependências do Projeto

Este projeto foi criado com as especificações do **Spring Initializr** e inclui 4 dependências principais além do core do Spring Boot.

---

## 1. 🌐 Spring Web

### O que é?
Starter para construir aplicações web, incluindo REST APIs, usando Spring MVC. Usa Apache Tomcat como servidor embutido.

### No pom.xml:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### Principais recursos:
- ✅ Spring MVC para criar REST APIs
- ✅ Tomcat embutido (não precisa instalar servidor)
- ✅ JSON mapping automático (Jackson)
- ✅ Annotations: `@RestController`, `@GetMapping`, `@PostMapping`, etc.

### Exemplo de uso:
```java
@RestController
@RequestMapping("/api")
public class MyController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
```

---

## 2. 🔄 Spring Boot DevTools

### O que é?
Ferramentas de desenvolvimento que melhoram a experiência do desenvolvedor com recursos como hot reload.

### No pom.xml:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

### Principais recursos:
- ✅ **Automatic Restart** - Reinicia a aplicação quando você altera código
- ✅ **LiveReload** - Atualiza o navegador automaticamente
- ✅ **Configurações otimizadas** - Cache desabilitado em desenvolvimento
- ✅ **Remote Debug** - Debug de aplicações remotas

### Como funciona:
1. Você edita um arquivo Java
2. Salva o arquivo (Ctrl+S)
3. O DevTools detecta a mudança
4. Reinicia apenas as classes necessárias (muito rápido!)
5. Sua aplicação está atualizada em segundos

### Configurações no IntelliJ:
Para ativar o hot reload completo:
1. **File > Settings > Build, Execution, Deployment > Compiler**
2. Marque "Build project automatically"
3. **File > Settings > Advanced Settings**
4. Marque "Allow auto-make to start even if developed application is currently running"

---

## 3. 🗄️ H2 Database

### O que é?
Banco de dados relacional em memória, escrito em Java. Perfeito para desenvolvimento e testes.

### No pom.xml:
```xml
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

### Principais recursos:
- ✅ **In-memory** - Dados em memória (rápido)
- ✅ **Console Web** - Interface gráfica via browser
- ✅ **SQL completo** - Suporta SQL padrão
- ✅ **Zero configuração** - Funciona out-of-the-box
- ✅ **Compatível com JPA** - Funciona com Hibernate

### Acessar o Console H2:
```
http://localhost:8080/h2-console
```

**Credenciais (configuradas em application.properties):**
```
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (vazio)
```

### Exemplo de uso com JPA:
```java
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    
    // getters e setters
}
```

### Configuração no application.properties:
```properties
# H2 Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 4. 🎯 Lombok

### O que é?
Biblioteca Java que reduz código boilerplate através de annotations. Gera automaticamente getters, setters, construtores, etc.

### No pom.xml:
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

### Principais annotations:

#### @Data
Gera getters, setters, toString, equals, e hashCode:
```java
@Data
public class User {
    private String name;
    private String email;
    // Lombok gera automaticamente:
    // - getName(), setName()
    // - getEmail(), setEmail()
    // - toString()
    // - equals() e hashCode()
}
```

#### @Getter / @Setter
Gera apenas getters ou setters:
```java
@Getter
@Setter
public class Product {
    private String name;
    private Double price;
}
```

#### @NoArgsConstructor / @AllArgsConstructor
Gera construtores:
```java
@NoArgsConstructor  // Construtor vazio
@AllArgsConstructor // Construtor com todos os campos
public class Order {
    private Long id;
    private String product;
}
```

#### @Builder
Implementa o padrão Builder:
```java
@Builder
public class Person {
    private String name;
    private Integer age;
    private String email;
}

// Usar:
Person person = Person.builder()
    .name("João")
    .age(30)
    .email("joao@email.com")
    .build();
```

#### @Slf4j
Adiciona um logger:
```java
@Slf4j
@RestController
public class MyController {
    @GetMapping("/test")
    public String test() {
        log.info("Endpoint /test foi chamado");
        log.error("Erro exemplo");
        return "OK";
    }
}
```

### Configurar Lombok no IntelliJ:

1. **Instalar Plugin:**
   - File > Settings > Plugins
   - Busque "Lombok"
   - Clique em "Install"
   - Reinicie o IntelliJ

2. **Habilitar Annotation Processing:**
   - File > Settings
   - Build, Execution, Deployment > Compiler > Annotation Processors
   - Marque "Enable annotation processing"
   - Apply > OK

### Exemplo Completo com Lombok:
```java
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String phone;
}
```

**Sem Lombok, esse código teria ~100 linhas!**  
**Com Lombok, apenas ~20 linhas!** 🎉

---

## 5. 🧪 Spring Boot Starter Test

### O que é?
Starter para testes, incluindo JUnit, Mockito, AssertJ, etc.

### No pom.xml:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

### Inclui:
- JUnit 5 (framework de testes)
- Mockito (mocks)
- AssertJ (assertions fluentes)
- Hamcrest (matchers)
- Spring Test & Spring Boot Test

### Exemplo de teste:
```java
@SpringBootTest
class Demo2ApplicationTests {

    @Test
    void contextLoads() {
        // Testa se o contexto Spring carrega corretamente
    }
}
```

---

## 📊 Resumo das Dependências

| Dependência | Versão | Propósito | Scope |
|-------------|--------|-----------|-------|
| spring-boot-starter-web | 3.5.5 | REST APIs | compile |
| spring-boot-devtools | 3.5.5 | Hot reload | runtime |
| h2 | latest | Banco de dados | runtime |
| lombok | latest | Reduzir boilerplate | compile |
| spring-boot-starter-test | 3.5.5 | Testes | test |

---

## 🔍 Verificar Dependências no IntelliJ

1. Abra a aba **Maven** (lateral direita)
2. Expanda **demo2 > Dependencies**
3. Você verá todas as dependências e suas sub-dependências

Ou execute no terminal:
```bash
mvn dependency:tree
```

---

## 💡 Quando Usar Cada Dependência

### Spring Web
✅ Sempre que precisar criar REST APIs  
✅ Aplicações web com Spring MVC  
✅ Microserviços

### DevTools
✅ Durante desenvolvimento (não em produção)  
✅ Quando precisa de feedback rápido  
✅ Para melhorar produtividade

### H2 Database
✅ Testes e desenvolvimento  
✅ Protótipos rápidos  
✅ Quando não quer configurar banco real  
⚠️ **NÃO** usar em produção (dados em memória são perdidos)

### Lombok
✅ Em qualquer projeto Java  
✅ Para reduzir código boilerplate  
✅ Melhorar legibilidade do código  
⚠️ Toda equipe precisa ter o plugin instalado

---

## 🎯 Próximos Passos

1. Explore cada dependência criando exemplos
2. Experimente as annotations do Lombok
3. Crie uma entidade JPA e salve no H2
4. Use o DevTools e veja o hot reload em ação
5. Escreva testes unitários

---

**Todas as dependências estão prontas para uso!** 🚀

