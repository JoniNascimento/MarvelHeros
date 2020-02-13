package br.com.joni.marvelheros.Api;

import br.com.joni.marvelheros.Model.ReturnData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HerosServices {


    @GET("v1/public/characters")
    Call<ReturnData> getHeros(@Query("ts") String ts,
                              @Query("apikey") String apiKey,
                              @Query("hash") String hash);


}
