# Ideal Color

Projeto referente a Challenge 2023 com empresa parceira PlusSoft.
A API de Coloração Pessoal "Ideal Color" fornece um conjunto de classes para ajudar os usuários a identificar as cores que melhor se adequam à sua aparência pessoal.

## Endpoints

- Coloração Pessoal
  - Ver detalhes da coloração pessoal a partir do id
  - Listar todas as colorações pessoais cadastradas
  - Cadastrar nova coloração pessoal
  - Apagar coloração pessoal
  - Atualizar coloração pessoal cadastrada

#### Obtém modelo de coloração pessoal a partir do id informado

```http
  GET /idealcolors/api/coloracaopessoal/{id}
```

**Exemplo do corpo de Response**

```js
{
    "idColoracaoPessoal": 123,
    "tomDePele": "branca",
    "subtomDePele":"frio",
    "corDosOlhos":"castanho",
    "corDoCabelo":"loiro",
    "idCartelaDeCores": 998
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | dados retornados com sucesso no corpo da resposta
| 400 | não foi encontrada coloracao pessoal com id informado

#### Obtém todos os modelos de colorações pessoais cadastrados

```http
  GET /idealcolors/api/listar/coloracoespessoais
```

**Exemplo do corpo de Response**

```js
[
  {
    idColoracaoPessoal: 123,
    tomDePele: "branca",
    subtomDePele: "frio",
    corDosOlhos: "castanho",
    corDoCabelo: "loiro",
    idCartelaDeCores: 998,
  },
  {
    idColoracaoPessoal: 124,
    tomDePele: "negra",
    subtomDePele: "neutro",
    corDosOlhos: "azul",
    corDoCabelo: "castranho claro",
    idCartelaDeCores: 999,
  },
  {
    idColoracaoPessoal: 125,
    tomDePele: "morena escura",
    subtomDePele: "oliva",
    corDosOlhos: "castanho escuro",
    corDoCabelo: "loiro",
    idCartelaDeCores: 997,
  },
  {
    idColoracaoPessoal: 126,
    tomDePele: "negra",
    subtomDePele: "frio",
    corDosOlhos: "verde",
    corDoCabelo: "preto",
    idCartelaDeCores: 996,
  },
];
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | dados retornados com sucesso no corpo da resposta
| 400 | não foi encontrada nenhuma coloracao pessoal cadastrada
