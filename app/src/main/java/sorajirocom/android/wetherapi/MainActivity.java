package sorajirocom.android.wetherapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView textView;
//    TextView latText;
//    TextView lonText;
    TextView timeText;
    double lat;
    double lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
//        latText = (TextView)findViewById(R.id.textView2);
//        lonText = (TextView)findViewById(R.id.textView3);
        timeText = (TextView)findViewById(R.id.timeText);

        Intent intent = getIntent();
        lat = intent.getDoubleExtra("Lat",0);
        lon = intent.getDoubleExtra("Lon",0);
//        latText.setText(Double.toString(lat));
//        lonText.setText(Double.toString(lon));

        //Apiの使用
        //lat="+lat+"&lon="+lon+"&cnt=1&APPID=05ef9e0937cc2befa00b875b2100a4dd
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherApiService weatherApiservice = retrofit.create(WeatherApiService.class);
        Call<Example> call = weatherApiservice.getData(lat,lon,"05ef9e0937cc2befa00b875b2100a4dd");
        try {
            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    if(response.body() != null){
                        //ListResponse weather = response.body().getListResponse().get(0).getWeather();
                        String tenki = response.body().getListResponse().get(0).getWeather().get(0).getMain();
                        int clouds = response.body().getListResponse().get(0).getClouds().getAll();
                        String time = response.body().getListResponse().get(0).getDtTxt();
                        Log.d("Weather",time);
                        timeText.setText(time);
                        //Toast.makeText(MainActivity.this, title, Toast.LENGTH_SHORT).show();
                        textView.setText(tenki);
                    }


                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {
                    Log.d("Weather", "error");
                }

            });
        } catch (Exception e) {
            Log.d("Weather", "レスポンスエラー");
        }
    }
    public void fivedays(View v){
        Intent intent = new Intent(this,FivedaysActivity.class);
        intent.putExtra("Lat",lat);
        intent.putExtra("Lon",lon);
        startActivity(intent);
    }
}
