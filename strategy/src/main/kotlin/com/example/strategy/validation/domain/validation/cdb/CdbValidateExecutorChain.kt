package ps.investimentos.investmentprofile.api.validation.domain.validation.cdb

import org.springframework.stereotype.Component
import ps.investimentos.investmentprofile.api.domain.enums.CatalogTypeEnum
import ps.investimentos.investmentprofile.api.validation.domain.validation.CatalogProductValidate
import ps.investimentos.investmentprofile.api.validation.domain.vo.CustomerProfile
import ps.investimentos.investmentprofile.api.validation.domain.vo.Validation

@Component
class CdbValidateExecutorChain : CatalogProductValidate {

    override fun getStrategy() = CatalogTypeEnum.FIXED_INCOME

    override fun isValid(customerProfile: CustomerProfile): Validation {
        return Validation(
                result = true,
                message = "Cliente é valido para investir em CDB!!!",
                code = "0001"
        )
    }
}