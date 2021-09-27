package ps.investimentos.investmentprofile.api.validation.domain.`in`

import ps.investimentos.investmentprofile.api.domain.enums.CatalogTypeEnum
import ps.investimentos.investmentprofile.api.validation.domain.vo.Validation

interface ValidationCustomerInputPort {

    fun execute(customerId: String, catalogProduct: CatalogTypeEnum): Validation

}