package sorajirocom.android.wetherapi;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {
    @GET("/data/2.5/find")
    Call<List<WeatherGsonResponse>> getData(@Query("lat") double lat,@Query("lon") double lon, @Query("cnt") int cnt,@Query ("APPID") String key);
}


