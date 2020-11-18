package com.example.digital.turbine.assigment.rest.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "ads", strict = false)
class Ads @JvmOverloads constructor(

    @field: ElementList(inline = true)
    var listOfAds: List<Ad>? = null,

    @field: Element(name = "responseTime", required = false)
    var responseTime: String? = "",

    @field:Element(name = "totalCampaignsRequested", required = false)
    var totalCampaignsRequested: Int = 0,

    @field:Element(name = "version", required = false)
    var version: String = ""
)

@Root(name = "ad", strict = false)
class Ad @JvmOverloads constructor(
    @field: Element(name = "appId", required = false)
    var appId: String? = "",

    @field: Element(name = "averageRatingImageURL", required = false)
    var averageRatingImageURL: String? = "",

    @field: Element(name = "bidRate", required = false)
    var bidRate: String? = "",

    @field: Element(name = "billingTypeId", required = false)
    var billingTypeId: Int = 0,

    @field: Element(name = "callToAction", required = false)
    var callToAction: String? = "",

    @field: Element(name = "campaignDisplayOrder", required = false)
    var campaignDisplayOrder: Int = 0,

    @field: Element(name = "campaignId", required = false)
    var campaignId: Int = 0,

    @field: Element(name = "campaignTypeId", required = false)
    var campaignTypeId: Int = 0,

    @field: Element(name = "categoryName", required = false)
    var categoryName: String? = "",

    @field: Element(name = "clickProxyURL", required = false)
    var clickProxyURL: String? = "",

    @field: Element(name = "creativeId", required = false)
    var creativeId: Int = 0,

    @field: Element(name = "externalMetadata", required = false)
    var externalMetadata: String? = "",

    @field: Element(name = "homeScreen", required = false)
    var homeScreen: Boolean = false,

    @field: Element(name = "impressionTrackingURL", required = false)
    var impressionTrackingURL: String? = "",

    @field: Element(name = "isRandomPick", required = false)
    var isRandomPick: Boolean = false,

    @field: Element(name = "numberOfRatings", required = false)
    var numberOfRatings: String? = "",

    @field: Element(name = "productDescription", required = false)
    var productDescription: String? = "",

    @field: Element(name = "productId", required = false)
    var productId: Int = 0,

    @field: Element(name = "productName", required = false)
    var productName: String? = "",

    @field: Element(name = "productThumbnail", required = false)
    var productThumbnail: String? = "",

    @field: Element(name = "rating", required = false)
    var rating: Double = 0.0,

    @field: Element(name = "numberOfDownloads", required = false)
    var numberOfDownloads: String? = "",

    @field: Element(name = "tstiEligible", required = false)
    var tstiEligible: Boolean = false,

    @field: Element(name = "stiEnabled", required = false)
    var stiEnabled: Boolean = false,

    @field: Element(name = "postInstallActions", required = false)
    var postInstallActions: String? = ""
)