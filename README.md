
# Ideal Colors

Projeto referente a Challenge 2023 com empresa parceira PlusSoft. 
A API de Coloração Pessoal "Ideal Color" fornece um conjunto de classes para ajudar os usuários a identificar as cores que melhor se adequam à sua aparência pessoal através da colorimetria pessoal.
A colorimetria pessoal é um método que visa determinar as cores que mais favorecem a aparência de uma pessoa, levando em consideração as características individuais, como tom de pele, cabelo e olhos. O objetivo é encontrar as cores que realçam a beleza natural e equilibram o visual, criando uma aparência mais atraente e harmoniosa. Para isso, são utilizados testes que avaliam a tonalidade, intensidade e temperatura das cores em relação às características da pessoa. Com base nos resultados, é possível identificar quais cores favorecem a aparência, evitando a escolha de peças que possam desvalorizar a beleza natural. Conhecer a colorimetria pessoal pode ajudar a economizar tempo e dinheiro na hora de escolher roupas, acessórios e maquiagem, além de aumentar a autoestima e confiança ao criar um visual mais equilibrado e harmônico.
Nossa solução oferece um recurso de reconhecimento de tonalidade que pode ajudar os usuários a identificar as cores que melhor combinam com seu tom de pele. Isso pode ser usado para escolher roupas, maquiagem e acessórios que valorizem a aparência do usuário e tornem sua escolha mais assertiva.
Além disso, de modo que reduza o desperdício de recursos naturais, evitando a compra de roupas e acessórios que acabam descartados devido não impactar o visual como esperado.


## Arquitetura do Projeto

Está no arquivo "arquitetura.jpeg"

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
| 400 | não foi encontrada cartela de cores com id informado## Endpoints

- Produto
    - Obter detalhes do produto a partir do id
    - Listar todos os produtos cadastrados
    - Cadastrar novo produto
    - Apagar produto
    - Atualizar produto

    

#### Obtém produto a partir do id informado

```http
  GET /idealcolors/api/produto/{id}
```
**Exemplo do corpo de Response**

```js
{
    "idProduto": 333,
    "idCartelaDeCores": 998,
    "descricaoProduto": "Camisa Feminina Alongada Verde Pool by Riachuelo",
    "categoria": "vestuario",
    "marca":"Riachuelo",
    "preco":119.90,
    "qtdDisponivel":203,
    "dataCadastro":"2023-03-06"
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | dados retornados com sucesso no corpo da resposta
| 400 | não foi encontrado produto com id informado


#### Cadastra novo produto a partir dos dados informados

```http
  POST /idealcolors/api/produto/cadastrar
```

| campo                 | tipo           | obrigatório | descrição                                                                     |
| --------------------- | -------------- | ----------- | ----------------------------------------------------------------------------- |
| idProduto                    | Long            | sim         | é o identificador unico de um produto                                       |
| idCartelaDeCores            | Long         | não         | identificador estrangeiro que faz referencia a classe CartelaDeCores
| descricaoProduto               | String         | sim         | descricao do produto                                       |
| categoria           | String           | sim         | categoria que se encontra o produto cadastrado                                           |
| marca            | String           | sim         | marca do produto cadastrado                                                     |
| preco               | Double           | sim         | valor em reais do produto cadastrado                                                        |        
qtdDisponivel               | Long           | sim         | quantidade do produto disponível em estoque
| dataCadastro           | LocalDateTime        | sim         | data em que foi cadastrado o produto                                   

**Exemplo do corpo de Request**

```js
    {
        "idProduto": 333,
        "idCartelaDeCores": 998,
        "descricaoProduto": "Camisa Feminina Alongada Verde Pool by Riachuelo",
        "categoria": "vestuario",
        "marca":"Riachuelo",
        "preco":119.90,
        "qtdDisponivel":203,
        "dataCadastro":"2023-03-06"
    },
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | produto cadastrado com sucesso
| 400 | erro na validação dos dados da requisição

#### Apaga produto a partir do id informado

```http
  DELETE idealcolors/api/produto/apagar/{idProduto}
```

**Exemplo do corpo de Request**

```js
{
    "idProduto": 333,
}
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | produto deletado com sucesso
| 400 | não foi encontrado produto com id informado

#### Atualiza produto a partir dos dados informados 

```http
  PUT idealcolors/api/produto/atualizar
```

**Exemplo do corpo de Request**

#### Alguns campos não podem ser alterados pelo usuário, como a dataCadastro e o idProduto.

```js
    {
        "idProduto": 333,
        "idCartelaDeCores": 998,
        "descricaoProduto": "Camisa Feminina Alongada Verde Pool by Riachuelo",
        "categoria": "vestuario",
        "marca":"Riachuelo",
        "preco":119.90,
        "qtdDisponivel":202,
        "dataCadastro":"2023-03-06"
    },
```

**Código de Resposta**
| código | descrição
|-|-
| 200 | produto atualizado com sucesso
| 400 | não foi encontrado produto com id informado

