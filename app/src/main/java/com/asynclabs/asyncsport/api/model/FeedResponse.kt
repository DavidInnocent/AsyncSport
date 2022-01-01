package com.asynclabs.asyncsport.api


import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


data class Athlete (
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

data class Author (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
    )

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

data class FeedResponse (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null,

    @SerializedName("createdBefore")
    @Expose
    var createdBefore: String? = null,

    @SerializedName("author")
    @Expose
    var author: Author? = null,

    @SerializedName("sportGroup")
    @Expose
    var sportGroup: SportGroup? = null,

    @SerializedName("video")
    @Expose
    var video: Video? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("athlete")
    @Expose
    var athlete: Athlete? = null,

    @SerializedName("bookmarked")
    @Expose
    var bookmarked: Boolean? = null,

    @SerializedName("views")
    @Expose
    var views: String? = null
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

data class SportGroup (
    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
)

data class Video (
    @SerializedName("handler")
    @Expose
    var handler: String? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("poster")
    @Expose
    var poster: String? = null,

    @SerializedName("type")
    @Expose
    var type: String? = null,

    @SerializedName("length")
    @Expose
    var length: Int? = null
)