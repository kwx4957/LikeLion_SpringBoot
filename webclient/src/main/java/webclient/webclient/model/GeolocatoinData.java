package webclient.webclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeolocatoinData {
    private String kr;
    private Long code;
    private String r1;
    private String r2;
    private String r3;
    private Double lat;
    @JsonProperty("long")
    private Double longitude;
    private String net;

    public GeolocatoinData() {
    }

    public GeolocatoinData(String kr, Long code, String r1, String r2, String r3, Double lat, Double longitude, String net) {
        this.kr = kr;
        this.code = code;
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.lat = lat;
        this.longitude = longitude;
        this.net = net;
    }
}
