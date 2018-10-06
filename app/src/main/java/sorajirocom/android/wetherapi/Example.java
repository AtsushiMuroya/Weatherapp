package sorajirocom.android.wetherapi;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {
    @SerializedName("list")
    @Expose
    private List<ListResponse> listResponse = null;

    public List<ListResponse> getListResponse() {
        return listResponse;
    }

    public void setListResponse(List<ListResponse> listResponse) {
        this.listResponse = listResponse;
    }

}
