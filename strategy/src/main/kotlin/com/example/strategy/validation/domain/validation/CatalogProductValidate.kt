package ps.investimentos.investmentprofile.api.validation.domain.validation

import ps.investimentos.investmentprofile.api.domain.enums.CatalogTypeEnum
import ps.investimentos.investmentprofile.api.validation.domain.vo.CustomerProfile
import ps.investimentos.investmentprofile.api.validation.domain.vo.Validation

interface CatalogProductValidate {

    fun getStrategy(): CatalogTypeEnum

    fun isValid(customerProfile: CustomerProfile): Validation
}