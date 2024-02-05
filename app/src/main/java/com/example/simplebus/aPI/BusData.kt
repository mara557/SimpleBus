package com.example.simplebus.aPI

import com.google.gson.annotations.SerializedName

data class BusData(
    @SerializedName("id")
    val id: Int,
    @SerializedName("operatorName")
    val operatorName: String,
    @SerializedName("noc")
    val noc: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("comment")
    val comment: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("lines")
    val lines: List<String>,
    @SerializedName("firstStartDate")
    val firstStartDate: String,
    @SerializedName("firstEndDate")
    val firstEndDate: String,
    @SerializedName("lastEndDate")
    val lastEndDate: String,
    @SerializedName("admin_areas")
    val adminAreas: List<AdminArea>,
    @SerializedName("localities")
    val localities: List<Locality>
)

data class AdminArea(
    @SerializedName("atco_code")
    val atcoCode: String,
    @SerializedName("name")
    val name: String
)

data class Locality(
    @SerializedName("gazetteer_id")
    val gazetteerId: String,
    @SerializedName("name")
    val name: String
)
