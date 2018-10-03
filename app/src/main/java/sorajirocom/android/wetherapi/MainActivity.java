package sorajirocom.android.wetherapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        //QiitaApiの使用
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApiService weatherApiservice = retrofit.create(WeatherApiService.class);
        Call<WeatherGsonResponse> call = weatherApiservice.getData("London","05ef9e0937cc2befa00b875b2100a4dd");
        try {
            call.enqueue(new Callback<WeatherGsonResponse>() {
                @Override
                public void onResponse(Call<WeatherGsonResponse> call, Response<WeatherGsonResponse> response) {
                    if(response.body() != null){
                        String title = response.body().getWeather().get(0).getMain();
                        Log.d("Weather",title);
                    }


                }

                @Override
                public void onFailure(Call<WeatherGsonResponse> call, Throwable t) {
                    Log.d("Weather", "error");
                }

            });
        } catch (Exception e) {
            Log.d("Weather", "レスポンスエラー");
        }
    }
}
