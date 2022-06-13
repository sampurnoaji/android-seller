package id.io.android.olebsai.domain.model.order

import id.io.android.olebsai.R
import id.io.android.olebsai.domain.model.product.Product

data class Order(
    val id: String,
    val status: Status,
    val customerName: String,
    val date: String,
    val total: Long,
    val products: List<Product>
) {
    enum class Status(val color: Int) {
        NEW(android.R.color.darker_gray),
        ONGOING(android.R.color.holo_blue_light),
        FINISHED(R.color.green_primary),
        COMPLAINED(R.color.red_primary)
    }
}
