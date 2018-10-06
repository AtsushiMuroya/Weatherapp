package sorajirocom.android.wetherapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView latText;
    TextView lonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        latText = (TextView)findViewById(R.id.textView2);
        lonText = (TextView)findViewById(R.id.textView3);

        Intent intent = getIntent();
        double lat = intent.getDoubleExtra("Lat",0);
        double lon = intent.getDoubleExtra("Lon",0);
        latText.setText(Double.toString(lat));
        lonText.setText(Double.toString(lon));

        //Apiの使用
        //lat="+lat+"&lon="+lon+"&cnt=1&APPID=05ef9e0937cc2befa00b875b2100a4dd
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApiService weatherApiservice = retrofit.create(WeatherApiService.class);
        Call<List<WeatherGsonResponse>> call = weatherApiservice.getData(lat,lon,14,"05ef9e0937cc2befa00b875b2100a4dd");
        try {
            call.enqueue(new Callback<List<WeatherGsonResponse>>() {
                @Override
                public void onResponse(Call<List<WeatherGsonResponse>> call, Response<List<WeatherGsonResponse>> response) {
                    if(response.body() != null){
                        String weather = response.body().get(0).getWeather();
                        Log.d("Weather",weather);
                        //Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                        textView.setText("今日の天気は"+ weather);
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
    public void fivedays(View v){
        Intent intent = new Intent(this,FivedaysActivity.class);
        startActivity(intent);
    }
}
