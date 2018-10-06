package sorajirocom.android.wetherapi;

public class Item {
    String tenki;
    String ntime;
    int clouds;
    String icon;


//    public Item(){
//
//    }
    public Item(String tenki, String ntime, int clouds,String icon){
        this.tenki = tenki;
        this.ntime = ntime;
        this.clouds = clouds;
        this.icon = icon;
    }
    public String getTenki(){
        return tenki;
    }
    public void setTenki(String tenki){
        this.tenki = tenki;
    }
    public String getNtime(){
        return ntime;
    }
    public void setNtime(String ntime){
        this.ntime = ntime;
    }
    public int getClouds(){
        return clouds;
    }
    public void setClouds(int clouds){
        this.clouds = clouds;
    }
    public String getIcon(){
        return icon;
    }
    public void setIcon(String icon){
        this.icon = icon;
    }

}
