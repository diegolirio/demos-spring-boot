package ps.investimentos.investmentprofile.api.validation.adapters.entrypoint

import io.swagger.annotations.Api
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ps.investimentos.investmentprofile.api.domain.enums.CatalogTypeEnum
import ps.investimentos.investmentprofile.api.validation.domain.`in`.ValidationCustomerInputPort
import ps.investimentos.investmentprofile.api.validation.domain.vo.Validation
import uol.pagseguro.aspect.log.LogInfo

@RestController
@Api(tags = ["Customer Validation API"])
class CustomerValidationEntrypoint(
        private val validationCustomerInputPort: ValidationCustomerInputPort
) {

    @LogInfo(logParameters = true)
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Sucesso"),
        ApiResponse(code = 500, message = "Falha interna desconhecida")
    ])
    @GetMapping("/customer/{customerId}/validation/{catalogProduct}")
    fun validation(
            @PathVariable("customerId") customerId: String,
            @PathVariable("catalogProduct") catalogProduct: CatalogTypeEnum
    ): Validation {
        return validationCustomerInputPort.execute(customerId, catalogProduct)
    }
}