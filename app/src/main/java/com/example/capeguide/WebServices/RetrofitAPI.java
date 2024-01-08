//Deep Programming (2021) Near Me | Firebase, Google Map, Place & Direction API's | Intro & Setup Project Android Java source code (Version 1.0) [Source code]. https://www.youtube.com/watch?v=dfTzz5AhBNQ&list=PLpQFhyCcxiCqDFYQabluYIYsNSsCFMNFk&index=1
package com.example.capeguide.WebServices;

import com.example.capeguide.Model.DirectionPlaceModel.DirectionResponseModel;
import com.example.capeguide.Model.GooglePlaceModel.GoogleResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RetrofitAPI {

    @GET
    Call<GoogleResponseModel> getNearByPlaces(@Url String url);

    @GET
    Call<DirectionResponseModel> getDirection(@Url String url);
}
