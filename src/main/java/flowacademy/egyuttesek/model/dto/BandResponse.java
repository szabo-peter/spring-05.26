package flowacademy.egyuttesek.model.dto;

import flowacademy.egyuttesek.model.Band;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BandResponse {

    private String id;
    private String name;

    public static BandResponse create(Band band){
        return new BandResponse(band.getId(), band.getName());
    }
}
