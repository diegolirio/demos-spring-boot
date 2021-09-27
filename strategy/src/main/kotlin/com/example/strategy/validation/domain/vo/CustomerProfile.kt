package ps.investimentos.investmentprofile.api.validation.domain.vo

import ps.investimentos.investmentprofile.api.controller.vo.CustomerProductInvestmentVO
import ps.investimentos.investmentprofile.api.domain.enums.PersonType
import ps.investimentos.investmentprofile.api.domain.enums.SuitabilityProfileType

data class CustomerProfile(
    val name: String? = null,
    val suitabilityStatus: SuitabilityProfileType,
    val isAllowedToInvest: Boolean,
    val customerProduct: CustomerProductInvestmentVO,
    val personType: PersonType? = null
)