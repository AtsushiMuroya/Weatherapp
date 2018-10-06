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

    @SerializedName("main")
    @Expose
    private List<Main> main;

    public List<Main> getMain() {
        return main;
    }
    public void setMain(List<Main> main) {
        this.main = main;
    }

    @SerializedName("clouds")
    @Expose
    private List<Clouds> clouds;

    public List<Clouds> getClouds() {
        return clouds;
    }
    public void setClouds(List<Clouds> clouds) {
        this.clouds = clouds;
    }

    @SerializedName("dtTxt")
    @Expose
    private String deTxt;

    public String getDeTxt() {
        return deTxt;
    }
    public void setDeTxt(String deTxt) {
        this.deTxt= deTxt;
    }
}
