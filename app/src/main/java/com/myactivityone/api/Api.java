package com.myactivityone.api;

import com.myactivityone.model.GiphyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jk on 8/14/2018.
 */

public interface Api {

    @GET("search")
    Call<GiphyResponse> getTopRatedMovies(@Query("q") String searchname, @Query("api_key") String apikey);


}
