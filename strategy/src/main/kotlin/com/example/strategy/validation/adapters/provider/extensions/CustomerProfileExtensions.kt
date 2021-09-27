package ps.investimentos.investmentprofile.api.validation.adapters.provider.extensions

import ps.investimentos.investmentprofile.api.controller.v3.vo.ProfileResponseVO
import ps.investimentos.investmentprofile.api.validation.domain.vo.CustomerProfile

fun ProfileResponseVO.toCustomerProfile() =
        CustomerProfile(
                name = this.name,
                suitabilityStatus = this.suitabilityStatus,
                isAllowedToInvest = this.isAllowedToInvest,
                customerProduct = this.customerProduct,
                personType = this.personType
        )