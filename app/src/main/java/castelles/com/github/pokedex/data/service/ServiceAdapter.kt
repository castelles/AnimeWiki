package castelles.com.github.pokedex.data.service

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.math.BigDecimal

object BigDecimalAdapter {
    @FromJson
    fun fromJson(value: Double) = BigDecimal(value)

    @ToJson
    fun toJson(value: BigDecimal) = value.toDouble()
}