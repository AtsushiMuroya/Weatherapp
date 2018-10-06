package sorajirocom.android.wetherapi;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FivedaysActivity extends AppCompatActivity {
    ListView listView;
    double lat;
    double lon;

    ItemAdapter itemAdapter;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fivedays);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(itemAdapter);
        itemAdapter = new ItemAdapter(this,0,new ArrayList<Item>());
        listView.setAdapter(itemAdapter);




        Intent intent = getIntent();
        lat = intent.getDoubleExtra("Lat",0);
        lon = intent.getDoubleExtra("Lon",0);

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

                    for (int i = 0; i < 38; i = i + 3 ){
                        String tenki = response.body().getListResponse().get(i).getWeather().get(0).getMain();
                        int clouds = response.body().getListResponse().get(i).getClouds().getAll();
                        String ntime = response.body().getListResponse().get(i).getDtTxt();
                        String icon = response.body().getListResponse().get(i).getWeather().get(0).getIcon();
                        Item item = new Item(tenki,ntime,clouds,icon);
                        itemAdapter.add(item);
                        itemAdapter.notifyDataSetChanged();
                    }
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
}
