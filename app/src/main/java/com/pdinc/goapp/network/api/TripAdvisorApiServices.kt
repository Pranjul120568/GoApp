package com.pdinc.goapp.network.api

import androidx.lifecycle.LiveData
import retrofit2.http.GET
import retrofit2.http.Query

interface TripAdvisorApiServices{

    @GET("locations/search?sort=relevance")
    fun getLocationIdFromLocationSearch(
        @Query("query") query: String,
        @Query("currency") currency: String
    ) : LiveData<ApiResponse<LocationSearchResponse>>
    @GET("hotels/list")
    fun getHotelsListFromLocationId(
        @Query("location_id") location_id: Int,
        @Query("checkin") check_in_date: String,
        @Query("adults") number_of_adults: Int,
        @Query("rooms") number_of_rooms: Int,
        @Query("nights") number_of_nights: Int,
        @Query("pricesmax") max_price: Int,
        @Query("hotel_class") hotel_class: Float,
        @Query("amenities") amenityInput: String
    )
            : LiveData<ApiResponse<HotelResponse>>
    @GET("hotels/get-details")
    fun getHotelDetailsListFromLocationId(
        @Query("location_id") location_id: Int)
            : LiveData<ApiResponse<HotelDetailsResponse>>

}