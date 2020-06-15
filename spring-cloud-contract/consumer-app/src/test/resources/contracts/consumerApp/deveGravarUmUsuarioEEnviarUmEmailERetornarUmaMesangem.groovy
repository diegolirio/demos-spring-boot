package contracts.consumerApp

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request{
        method GET()
        url("/v1")
        headers { contentType(applicationJson()) }
    }
    response {
        status 200
        headers { contentType(applicationJson()) }
        body(
                message: value(test(anyNonBlankString()))
            )
    }
}