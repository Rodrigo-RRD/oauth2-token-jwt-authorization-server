# API Authorization Server com Spring Security 6, OAuth2 e JWT
Este projeto implementa um Authorization Server que gera tokens de autenticação JWT utilizando o OAuth2 como protocolo de autorização. 
Ele foi desenvolvido com o Spring Ecosystem, aproveitando as vantagens de Spring Security 6, Hibernate, JPA, e recursos modernos do Java, como Stream API e Lambda Expressions.

# Autenticação OAuth2
Gerenciamento de autenticação com suporte a fluxos padrão.

Geração de Tokens JWT: Tokens de acesso criados e validados de forma segura.

Gerenciamento de Recursos Protegidos: Recursos acessíveis somente para usuários autenticados.

Integração com Banco de Dados: Persistência dos dados de usuários e permissões.

## Configuração de Segurança Principal

```properties
# Security
algafood.jwt.keystore.jks-location=base64:[CHAVE]
algafood.jwt.keystore.password=
algafood.jwt.keystore.keypair-alias=

algafood.auth.provider-url=http://127.0.0.1:8081

# OAUTH2
spring.security.oauth2.resourceserver.opaquetoken.introspection-uri=
spring.security.oauth2.resourceserver.opaquetoken.client-id=
spring.security.oauth2.resourceserver.opaquetoken.client-secret=
spring.security.oauth2.resourceserver.jwt.jwk-set-uri=
```
## Tecnologias Utilizadas
### Spring Boot 3:
Estrutura base do projeto, facilitando a criação de aplicações Java robustas e escaláveis.

### Spring Security 6: 
Gerenciamento de autenticação e autorização com suporte nativo ao OAuth2 e JWT.

### Spring Authorization Server: 
Implementação de Authorization Server para o protocolo OAuth2.

### Hibernate e JPA: 
Soluções ORM para mapear e gerenciar a persistência de dados no banco de dados.

### MySQL: 
Banco de dados relacional utilizado para armazenamento de informações.

### Stream API e Lambda Expressions: 
Abordagem funcional para manipulação de coleções e fluxos de dados em Java.

## Configuração do Projeto:
```xml
<dependencies>
    <!-- Spring Security para autenticação e autorização -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- Spring Authorization Server -->
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-oauth2-authorization-server</artifactId>
        <version>${springauthserver.version}</version>
    </dependency>

    <!-- Resource Server para validação de tokens -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
    </dependency>

    <!-- Starter Web para criar endpoints REST -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Hibernate e JPA -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- Conector MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.28</version>
    </dependency>

    <!-- Lombok para reduzir código boilerplate -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Spring DevTools para desenvolvimento mais rápido -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    </dependency>

    <!-- Spring Security Test para testes de segurança -->
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```
