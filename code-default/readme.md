# Padrão de código Reneg

### Java

> O padrão de nome de variaveis e objetos deve seguir o 
>  padrão Java feito pela Comunidade hoje.   

### API

> APIs expostas no MBI (externas) deve seguir o modelo **snake_case**    

```json
[
    {
        "cpf_cnpj": "35357659869",
        "numero_contrato": "652652616552",
        "codigo_produto": 45685,
        "valor": 999.99
    }
]
```

> APIs internas deve seguir o modelo **camelCase**    

```json
[
    {
        "cpfCnpj": "35357659869",
        "numeroContrato": "652652616552",
        "codigoProduto": 45685,
        "valor": 999.99
    }
]
```

### Arquitetura de Código

    src/
     |------ main/
                  |------- java/
                             |------- br.com.itau.padraocodigo
                                                      |------- Application.java
                                                      |------- config
                                                      |------- integration
                                                      |------- contratos
                                                                   |------- controllers
                                                                   |------- mappers
                                                                   |------- dominios
                                                                   |------- facade
     |------ test/

### Trabalhando com Threads

### Dicas 

Devemos sempre pensar em um código mais Coeso e menos acoplados seguindos os principios de SOLID e Desing Patterns.

### Microservices

Existem vários padrões para a construção de Microservices, como Descoberta de Serviço, Centralização de Configuração, API Gateway, Banco de Dados segregados e outros. Os [12 fatores](https://12factor.net/pt_br/) aborta alguns desses padrões.    

Código de Exemplo: https://gitlab.com

Ref.:
