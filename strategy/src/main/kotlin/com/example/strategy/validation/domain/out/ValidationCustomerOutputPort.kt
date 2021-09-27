package ps.investimentos.investmentprofile.api.validation.domain.out

import ps.investimentos.investmentprofile.api.domain.enums.CatalogTypeEnum
import ps.investimentos.investmentprofile.api.validation.domain.vo.CustomerProfile
import ps.investimentos.investmentprofile.api.validation.domain.vo.Validation

interface GetCustomerProfileOutputPort {

    fun get(customerId: String, catalogProduct: CatalogTypeEnum): CustomerProfile

}