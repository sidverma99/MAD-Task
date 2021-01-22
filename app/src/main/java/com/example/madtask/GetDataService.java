package com.example.madtask;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GetDataService {
    @Headers("user-key: 597d686f98342f8f80205bc13d4475fb")
    @GET("api/v2.1/locations")
    Call<CityDetails> getLocation(@Query("query") String query,@Query("lat") Double latitude,@Query("lon") Double longitude,@Query("count") Integer count);

    @Headers("user-key: 597d686f98342f8f80205bc13d4475fb")
    @GET("api/v2.1/search")
    Call<RestaurantResponse> getRestaurant(@Query("entity_id") Integer entity_id,@Query("entity_type") String entity_type,@Query("q") String q,@Query("start") Integer start,@Query("count") Integer count,@Query("lat") Double lat,@Query("lon") Double lon,@Query("radius") Double radius,@Query("cuisines") String cuisines,@Query("establishment_type") String establishment_type,@Query("collection_id") String collection_id,@Query("category") String category,@Query("sort") String sort,@Query("order") String order);
}
