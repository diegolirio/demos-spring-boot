package ps.investimentos.investmentprofile.api.validation.domain.vo

data class Validation(
    var result: Boolean? = true,
    var imageUrl: String? = null,
    var message: String? = null,
    var code: String? = null
)