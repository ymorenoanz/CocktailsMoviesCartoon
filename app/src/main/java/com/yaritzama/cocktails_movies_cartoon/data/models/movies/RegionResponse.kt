package com.yaritzama.cocktails_movies_cartoon.data.models.movies


import com.google.gson.annotations.SerializedName

data class RegionResponse(
    @SerializedName("dates")
    val dates: Dates?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<ResultMovie?>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)