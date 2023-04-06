
# Ideal Colors

Projeto referente a Challenge 2023 com empresa parceira PlusSoft. 
A API de Coloração Pessoal "Ideal Colors" fornece um conjunto de classes para ajudar os usuários a identificar as cores que melhor se adequam à sua aparência pessoal.

## Endpoints

- Coloração Pessoal
    - Obter detalhes da coloração pessoal a partir do id
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
    "idCartelaDeCores": 998,
    "tomDePele": "branca",
    "subtomDePele":"frio",
    "corDosOlhos":"castanho",
    "corDoCabelo":"loiro",
    "dataCadastro":"2023-03-06"
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | dados retornados com sucesso no corpo da resposta
| 400 | não foi encontrada coloracao pessoal com id informado




#### Lista todos os modelos de colorações pessoais cadastrados

```http
  GET /idealcolors/api/coloracoespessoais/listar/
```
**Exemplo do corpo de Response**

```js

[
  {
    "idColoracaoPessoal": 123,
    "idCartelaDeCores": 998,
    "tomDePele": "branca",
    "subtomDePele":"frio",
    "corDosOlhos":"castanho",
    "corDoCabelo":"loiro",
    "dataCadastro":"2023-03-06"
  },
  {
    "idColoracaoPessoal": 124,
    "idCartelaDeCores": 999,
    "tomDePele": "negra",
    "subtomDePele":"neutro",
    "corDosOlhos":"azul",
    "corDoCabelo":"castranho claro",
    "dataCadastro":"2023-03-06"
  },
  {
    "idColoracaoPessoal": 125,
    "idCartelaDeCores": 997,
    "tomDePele": "morena escura",
    "subtomDePele":"oliva",
    "corDosOlhos":"castanho escuro",
    "corDoCabelo":"loiro",
    "dataCadastro":"2023-03-06"
  },
  {
    "idColoracaoPessoal": 126,
    "idCartelaDeCores": 996,
    "tomDePele": "negra",
    "subtomDePele":"frio",
    "corDosOlhos":"verde",
    "corDoCabelo":"preto",
    "dataCadastro":"2023-03-06"
  }
]
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | dados retornados com sucesso no corpo da resposta
| 400 | não foi encontrada nenhuma coloracao pessoal cadastrada

#### Cadastra nova coloração pessoal a partir dos dados informados

```http
  POST /idealcolors/api/coloracaopessoal/cadastrar
```

| campo                 | tipo           | obrigatório | descrição                                                                     |
| --------------------- | -------------- | ----------- | ----------------------------------------------------------------------------- |
| idColoracaoPessoal                    | Long            | sim         | é o identificador unico de uma coloração pessoal                                       |
| idCartelaDeCores            | Long         | sim         | identificador estrangeiro que faz referencia a classe CartelaDeCores
| tomDePele               | String         | sim         | tom de pele relacionado a coloração pessoal cadastrada                                        |
| subtomDePele           | String           | sim         | subtom de pele relacionado a coloração pessoal cadastrada                                           |
| corDosOlhos            | String           | sim         | cor dos olhos relacionado a coloração pessoal cadastrada                                                     |
| corDoCabelo               | String           | sim         | cor do cabelo relacionado a coloração pessoal cadastrada                                                        |                                               |
| dataCadastro           | LocalDateTime        | sim         | data em que foi cadastrada a coloração pessoal                                                        |

**Exemplo do corpo de Request**

```js
  {
    "idColoracaoPessoal": 165,
    "idCartelaDeCores": 209,
    "tomDePele": "negra",
    "subtomDePele":"frio",
    "corDosOlhos":"castanho",
    "corDoCabelo":"preto",
    "dataCadastro":"2023-03-06"
  }
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | coloração pessoal cadastrada com sucesso
| 400 | erro na validação dos dados da requisição

#### Apaga coloração pessoal a partir do id informado

```http
  DELETE idealcolors/api/coloracaopessoal/apagar/{idColoracaoPessoal}
```

**Exemplo do corpo de Request**

```js
{
    "idColoracaoPessoal": 119,
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | coloração pessoal deletada com sucesso
| 400 | não foi encontrada coloração pessoal com id informado

#### Atualiza coloração pessoal a partir dos dados informados 

```http
  PUT idealcolors/api/coloracaopessoal/atualizar
```

**Exemplo do corpo de Request**

#### Alguns campos não podem ser alterados pelo usuário, como a dataCadastro e o idColoracaoPessoal.

```js
  {
    "idColoracaoPessoal": 165,
    "idCartelaDeCores": 209,
    "tomDePele": "negra",
    "subtomDePele":"frio",
    "corDosOlhos":"castanho",
    "corDoCabelo":"preto",
    "dataCadastro":"2023-03-06"
  }
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | coloração pessoal atualizada com sucesso
| 400 | não foi encontrada coloração pessoal com id informado

## Endpoints

- Cartela de Cores
    - Obter detalhes da cartela de cores a partir do id
    - Listar todas as cartelas de cores cadastradas
    - Cadastrar nova cartela de cores
    - Apagar cartela de cores
    - Atualizar cartela de cores cadastrada


#### Obtém modelo de cartela de cores a partir do id informado

```http
  GET /idealcolors/api/carteladecores/{id}
```
**Exemplo do corpo de Response**

```js
{
    "idCartelaDeCores": 123,
    "idColoracaoPessoal": 998,
    "idProduto": 233,
    "coresCartela": [
        "azul",
        "amarelo",
        "roxo",
        "cinza",
        "preto",
        "branco"
    ],
    "dataCadastro":"2023-03-06"
}
```
**Código de Resposta**
| código | descrição
|-|-
| 200 | dados retornados com sucesso no corpo da resposta
| 400 | não foi encontrada cartela de cores com id informado

#### Lista todas as cartela de cores cadastradas

```http
  GET /idealcolors/api/cartelasdecores/listar/
```
**Exemplo do corpo de Response**

```js

[
    {
        "idCartelaDeCores": 123,
        "idColoracaoPessoal": 998,
        "idProduto": 233,
        "coresCartela": [
            "azul",
            "amarelo",
            "roxo",
            "cinza",
            "preto",
            "branco"
        ],
        "dataCadastro":"2023-03-06"
    },
    {
        "idCartelaDeCores": 124,
        "idColoracaoPessoal": 997,
        "idProduto": 237,
        "coresCartela": [
            "verde",
            "vermelho",
            "roxo",
            "cinza",
            "chumbo",
            "branco"
        ],
        "dataCadastro":"2023-03-06"
    },
    {
        "idCartelaDeCores": 125,
        "idColoracaoPessoal": 995,
        "idProduto": 235,
        "coresCartela": [
            "azul",
            "amarelo",
            "roxo",
            "cinza",
            "laranja",
            "branco"
        ],
        "dataCadastro":"2023-03-06"
    },
    {
        "idCartelaDeCores": 126,
        "idColoracaoPessoal": 948,
        "idProduto": 243,
        "coresCartela": [
            "lilas",
            "amarelo",
            "roxo",
            "cinza",
            "preto",
            "marrom"
        ],
        "dataCadastro":"2023-03-06"
    }
]
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | dados retornados com sucesso no corpo da resposta
| 400 | não foi encontrada nenhuma cartela de cores cadastrada

#### Cadastra nova cartela de cores a partir dos dados informados

```http
  POST /idealcolors/api/carteladecores/cadastrar
```

| campo                 | tipo           | obrigatório | descrição                                                                     |
| --------------------- | -------------- | ----------- | ----------------------------------------------------------------------------- |
| idCartelaDeCores                    | Long            | sim         | identificador unico de uma cartela de cores                                       |
| idColoracaoPessoal            | Long         | não         | identificador estrangeiro que faz referencia a classe ColoracaoPessoal
| idProduto               | Long         | não         | identificador estrangeiro que faz referencia a classe Produto                                        |
| coresCartela           | List<String>           | sim         | cores que pertencem a cartela de cores cadastrada
| dataCadastro           | LocalDateTime        | sim         | data em que foi cadastrada a coloração pessoal                                                        |

**Exemplo do corpo de Request**

```js
    {
        "idCartelaDeCores": 123,
        "idColoracaoPessoal": 998,
        "idProduto": 233,
        "coresCartela": [
            "azul",
            "amarelo",
            "roxo",
            "cinza",
            "preto",
            "branco"
        ],
        "dataCadastro":"2023-03-06"
    },
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | cartela de cores cadastrada com sucesso
| 400 | erro na validação dos dados da requisição

#### Apaga cartela de cores a partir do id informado

```http
  DELETE idealcolors/api/carteladecores/apagar/{idCartelaDeCores}
```

**Exemplo do corpo de Request**

```js
{
    "idCartelaDeCores": 119,
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | cartela de cores deletada com sucesso
| 400 | não foi encontrada cartela de cores com id informado

#### Atualiza cartela de cores a partir dos dados informados 

```http
  PUT idealcolors/api/carteladecores/atualizar
```

**Exemplo do corpo de Request**

#### Alguns campos não podem ser alterados pelo usuário, como a dataCadastro, idCartelaDeCores, idColoracaoPessoal, idProduto.

```js
    {
        "idCartelaDeCores": 123,
        "idColoracaoPessoal": 998,
        "idProduto": 233,
        "coresCartela": [
            "azul",
            "amarelo",
            "roxo",
            "cinza",
            "preto",
            "branco"
        ],
        "dataCadastro":"2023-03-06"
    },
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | cartela de cores atualizada com sucesso
| 400 | não foi encontrada cartela de cores com id informado
