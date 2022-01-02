package com.asynclabs.asyncsport.api.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Country (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("slug")
    @Expose
    var slug: String? = null,

    @SerializedName("icon")
    @Expose
    var icon: String? = null
    )

data class AthleteResponse (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("age")
    @Expose
    var age: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null,

    @SerializedName("club")
    @Expose
    var club: String? = null,

    @SerializedName("isCelebrity")
    @Expose
    var isCelebrity: Boolean? = null,

    @SerializedName("country")
    @Expose
    var country: Country? = null,

    @SerializedName("sport")
    @Expose
    var sport: Sport? = null
    )

data class Sport (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("slug")
    @Expose
    var slug: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("icon")
    @Expose
    var icon: String? = null
    )