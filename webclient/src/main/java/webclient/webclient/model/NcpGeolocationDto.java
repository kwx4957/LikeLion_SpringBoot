package webclient.webclient.model;

import lombok.Data;

@Data
public class NcpGeolocationDto {
    private Long returnCode;
    private String requestId;
    private GeolocatoinData geoLocation;

    public NcpGeolocationDto() {
    }

    public NcpGeolocationDto(Long returnCode, String requestId, GeolocatoinData geoLocation) {
        this.returnCode = returnCode;
        this.requestId = requestId;
        this.geoLocation = geoLocation;
    }


}
