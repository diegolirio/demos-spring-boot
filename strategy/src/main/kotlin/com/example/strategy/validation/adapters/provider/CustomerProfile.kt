package ps.investimentos.investmentprofile.api.validation.adapters.provider

import org.springframework.stereotype.Component
import ps.investimentos.investmentprofile.api.domain.enums.CatalogTypeEnum
import ps.investimentos.investmentprofile.api.domain.services.v2.RegistryInformationService
import ps.investimentos.investmentprofile.api.validation.adapters.provider.extensions.toCustomerProfile
import ps.investimentos.investmentprofile.api.validation.domain.out.GetCustomerProfileOutputPort
import ps.investimentos.investmentprofile.api.validation.domain.vo.CustomerProfile

@Component
class CustomerProfile(
        private val registryInformationService: RegistryInformationService
) : GetCustomerProfileOutputPort {

    override fun get(customerId: String, catalogProduct: CatalogTypeEnum): CustomerProfile {
        return registryInformationService.getProfile(
                customerId,
                catalogProduct
        ).toCustomerProfile()
    }

}