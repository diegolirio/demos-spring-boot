package ps.investimentos.investmentprofile.api.validation.domain.validation

import org.springframework.stereotype.Component
import ps.investimentos.investmentprofile.api.domain.enums.CatalogTypeEnum

@Component
class ProductValidationStrategy(
    private val strategies: List<CatalogProductValidate>
) {

    operator fun get(catalogType: CatalogTypeEnum): CatalogProductValidate {
        return strategies.stream()
                .filter { validate: CatalogProductValidate -> catalogType == validate.getStrategy() }
                .findFirst()
                .orElseThrow { IllegalStateException("catalogType nao definido: $catalogType") }
    }
}