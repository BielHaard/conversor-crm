### 📋 indispensável

De que eu preciso para buildar essa aplicação?

```
Java 17
Springboot 3.X
Maven 3.X
Postgresql

```

### 🔧 Configuração

Deve ser configurado para o seu Schema e banco no application.properties
 - Como?

```
 # JDBC Postgresql.

application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver
```

### 🧙 Dados iniciais para o Mercado de Pulgas dos Mil Saberes

```sql

CREATE DATABASE wefin_db;

-- Moedas disponíveis no reino
INSERT INTO moeda (id, nome, simbolo) VALUES (1, 'Ouro Real', 'OR');
INSERT INTO moeda (id, nome, simbolo) VALUES (2, 'Tibar', 'TB');

-- Produto representativo das feiras de Wefin
INSERT INTO produto (id, nome, categoria) VALUES (1, 'Adaga Élfica', 'Armas Raras');

-- Taxa de câmbio válida para hoje
-- Conversão de Tibar para Ouro Real: 1 Tibar = 0.4 Ouro Real
INSERT INTO taxa_cambio (
    id, taxa, data, moeda_origem_id, moeda_destino_id, produto_id
) VALUES (
    1, 0.4, CURRENT_DATE, 2, 1, 1
);

-- Conversão de Ouro Real para Tibar: 1 Ouro Real = 2.5 Tibar
INSERT INTO taxa_cambio (
    id, taxa, data, moeda_origem_id, moeda_destino_id, produto_id
) VALUES (
    2, 2.5, CURRENT_DATE, 1, 2, 1
);
```

### 📄 Documentação da API

-- Para acessar a documentação da API
```
{URI}/ + swagger-ui/index.html
```

## 🛠️ Desenvolvido Com


* [Springboot](https://docs.spring.io/spring-framework/reference/index.html) - Framework
* [Maven](https://maven.apache.org/) - Dependencies Magnament


## 📌 Versão

[1.0.0]

## ✒️ Autor

* **Júlio Gabriel Garcia** - *Initial work* - [BielHaard]([https://github.com/BielHaard/)
* **Júlio Gabriel Garcia** - *Documentation* - [BielHaard](https://github.com/BielHaard/)


---
⌨️ by [Júlio Gabriel Garcia](https://github.com/BielHaard/) 😊
