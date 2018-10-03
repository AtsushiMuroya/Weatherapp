package sorajirocom.android.wetherapi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherGsonResponse {
    @SerializedName("weather")
    @Expose
    private List<Weather> weather;

    public List<Weather> getWeather() {
        return weather;
    }
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
