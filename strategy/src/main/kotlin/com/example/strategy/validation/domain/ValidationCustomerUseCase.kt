package ps.investimentos.investmentprofile.api.validation.domain


import org.springframework.stereotype.Component
import ps.investimentos.investmentprofile.api.domain.enums.CatalogTypeEnum
import ps.investimentos.investmentprofile.api.validation.domain.`in`.ValidationCustomerInputPort
import ps.investimentos.investmentprofile.api.validation.domain.out.GetCustomerProfileOutputPort
import ps.investimentos.investmentprofile.api.validation.domain.validation.ProductValidationStrategy
import ps.investimentos.investmentprofile.api.validation.domain.vo.Validation

@Component
class ValidationCustomerUseCase(
    private val getCustomerProfileOutputPort: GetCustomerProfileOutputPort,
    private val strategy: ProductValidationStrategy
) : ValidationCustomerInputPort {

    override fun execute(customerId: String, catalogProduct: CatalogTypeEnum): Validation {
        val customerProfile = getCustomerProfileOutputPort.get(customerId, catalogProduct)
        return strategy[catalogProduct].isValid(customerProfile)
    }
}