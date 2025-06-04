# Transações API

API REST para gerenciamento de usuários, contas e transações bancárias.

## Endpoints principais

- **Usuários:** `/api/usuarios`
- **Contas:** `/api/contas`
- **Transações:** `/api/transacoes`
- **Transferência:** `/api/transacoes/transferencia`

---

## Exemplo de criação de usuários

**Usuário 1**
```json
{
  "nome": "João Silva",
  "email": "joao.silva@email.com"
}
```

**Usuário 2**
```json
{
  "nome": "Maria Souza",
  "email": "maria.souza@email.com"
}
```

---

## Exemplo de criação de contas

**Conta do usuário 1**
```json
{
  "numero": "12345-1",
  "saldo": 1000.00,
  "usuario": {
    "id": 1
  }
}
```

**Conta do usuário 2**
```json
{
  "numero": "12345-2",
  "saldo": 500.00,
  "usuario": {
    "id": 2
  }
}
```

---

## Exemplo de transferência de saldo

Para transferir todo o saldo do usuário 1 para o usuário 2, faça uma requisição POST:

```
POST /api/transacoes/transferencia?contaOrigemId=1&contaDestinoId=2&valor=1000.00&descricao=Transferência total
```

### Exemplo de resposta (JSON retornado):

```json
{
  "id": 10,
  "contaOrigem": {
    "id": 1,
    "numero": "12345-1",
    "saldo": 0.00,
    "usuario": {
      "id": 1,
      "nome": "João Silva",
      "email": "joao.silva@email.com"
    }
  },
  "contaDestino": {
    "id": 2,
    "numero": "12345-2",
    "saldo": 1500.00,
    "usuario": {
      "id": 2,
      "nome": "Maria Souza",
      "email": "maria.souza@email.com"
    }
  },
  "valor": 1000.00,
  "tipoTransacao": "TRANSFERENCIA",
  "descricao": "Transferência total",
  "dataTransacao": "2025-06-04T10:00:00"
}
```
