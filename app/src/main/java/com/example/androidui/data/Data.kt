package com.example.androidui.data

data class ImageList(
    val image : Int
)

data class SearchList(
    val search : String
)

data class Partners(
    val partnerImage : Int,
    val partnerName : String
)

data class Categories(
    val categoryImage : Int,
    val categoryName : String
)

data class TopRestaurants(
    val topRestaurantsImage : Int,
    val topRestaurantsName : String
)

data class BestRestaurants(
    val bestRestaurantsImage : Int,
    val bestRestaurantsName : String,
    val bestRestaurantsLocation : String
)

data class BestPartners(
    val bestPartnersImage : Int,
    val bestPartnersName : String,
    val bestPartnersLocation : String
)

data class AllRestaurants(
    val allRestaurantsImage : Int,
    val allRestaurantsName : String
)

data class SingleRestaurant(
    val singleRestaurantImage : Int,
    val singleRestaurantName : String,
    val singleRestaurantDesc : String
)

data class Orders(
    val orderIndex : Int,
    val orderItemName : String,
    val orderItemDesc : String,
    val orderItemCost : String

)
