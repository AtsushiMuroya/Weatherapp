package sorajirocom.android.wetherapi;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApiService {
    @GET("/data/2.5/weather")
    Call<WeatherGsonResponse> getData(@Query("q") String place, @Query ("appid") String key);
}


