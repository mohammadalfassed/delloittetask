package com.mohammad.delloittetask.core.network.exceptions

import com.squareup.moshi.Json

data class HttpErrorBodyModel(

    @Json(name = "status")
    val status: String? = null,

    @Json(name = "fault")
    val fault: Fault? = null,
)

data class Fault(

    @Json(name = "faultstring")
    val faultString: String? = null,

    )