package contracts.usuario

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request{
        method POST()
        url("/v1/usuarios")
        headers { contentType(applicationJson()) }
        body('''
             {
                "nome": "Diego Lirio",
                "idade": 32,
                "altura":  1.77,
                "peso": 80.5,
                "email": "test@gmail.com",
            }
        ''')
    }
    response {
        status 200
        headers { contentType(applicationJson()) }
        body([
                "id": value(test(anyNumber())),
                "nome": value(test(anyNonBlankString())),
                "email": value(test(anyEmail())),
                "idade": value(test(anyNumber())),
                "altura": value(test(anyNumber())),
                "peso": value(test(anyNumber())),
                "imc": value(test(anyNumber())),
                "classification": value(test(anyNonBlankString()))
        ])

    }
}
