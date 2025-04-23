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