package flowacademy.egyuttesek.model.dto;


import flowacademy.egyuttesek.model.Track;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrackResponse {

    private String id;
    private String trackName;
//    private String bandName;
//    private int trackLength;
//    private int licencePrice;
//    private String bandGenre;
//    private String musicServiceName;


    public static TrackResponse giveIdTrackName(Track track) {
        return new TrackResponse(track.getId(), track.getName());
    }
}
