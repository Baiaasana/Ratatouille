package com.example.designsystem.utils

import android.content.Context
import com.example.designsystem.R

enum class Category(val value: Int, val toServer: String) {
    ELECTRONICS(value = R.string.Electronics, toServer = "Electronics"),
    CLOTHING_SHOES_ACCESSORIES(value = R.string.ClothingShoesAccessories, toServer = "Clothing, Shoes & Accessories"),
    SPORTING_GOODS(value = R.string.SportingGoods, toServer = "Sporting Goods"),
    TOYS_HOBBIES(value = R.string.ToysHobbies, toServer = "Toys & Hobbies"),
    HOME_GARDEN(value = R.string.HomeGarden, toServer = "Home & Garden"),
    JEWELRY_WATCHES(value = R.string.JewelryWatches, toServer = "Jewelry & Watches"),
    HEALTH_BEAUTY(value = R.string.HealthBeauty, toServer = "Health & Beauty"),
    BUSINESS_INDUSTRIAL(value = R.string.BusinessIndustrial, toServer = "Business & Industrial"),
    BABY_ESSENTIALS(value = R.string.BabyEssentials, toServer = "Baby Essentials"),
    PET_SUPPLIES(value = R.string.PetSupplies, toServer = "Pet Supplies"),
    BOOKS_MOVIES_MUSIC(value = R.string.BooksMoviesMusic, toServer = "Books, Movies & Music"),
    COLLECTIBLES_ART(value = R.string.CollectiblesArt, toServer = "Collectibles & Art"),
    VEHICLE_PARTS_ACCESSORIES(value = R.string.VehiclePartsAccessories, toServer = "Vehicle Parts & Accessories"),
    MUSICAL_INSTRUMENTS_GEAR(value = R.string.MusicalInstrumentsGear, toServer = "Musical Instruments & Gear"),
    MAJOR_APPLIANCES(value = R.string.MajorAppliances, toServer = "Major Appliances"),
    CAMPING_HIKING(value = R.string.CampingHiking, toServer = "Camping & Hiking"),
    AUTOMOTIVE(value = R.string.Automotive, toServer = "Automotive"),
    REAL_ESTATE(value = R.string.RealEstate, toServer = "Real Estate"),
    FURNITURE(value = R.string.Furniture, toServer = "Furniture"),
    FOOD_BEVERAGES(value = R.string.FoodBeverages, toServer = "Food & Beverages"),
    OFFICE_SUPPLIES(value = R.string.OfficeSupplies, toServer = "Office Supplies"),
    SURVEILLANCE_SECURITY(value = R.string.SurveillanceSecurity, toServer = "Surveillance & Security"),
    BICYCLES_ACCESSORIES(value = R.string.BicyclesAccessories, toServer = "Bicycles & Accessories"),
    VIDEO_GAMES_CONSOLES(value = R.string.VideoGamesConsoles, toServer = "Video Games & Consoles"),
    CRAFTS(value = R.string.Crafts, toServer = "Crafts"),
    ANTIQUES(value = R.string.Antiques, toServer = "Antiques"),
    FISHING_BOATING(value = R.string.FishingBoating, toServer = "Fishing & Boating"),
    OTHER(value = R.string.Other, toServer = "Other")
}


fun getToServerFromResourceCategory(context: Context, resourceString: String): String {
    val matchingEnum = Category.values().find { context.getString(it.value) == resourceString }
    return matchingEnum?.toServer.toString()
}

fun getValueFromToServerCategory(toServer: String): Int? {
    val matchingEnum = Category.values().find { it.toServer == toServer }
    return matchingEnum?.value
}