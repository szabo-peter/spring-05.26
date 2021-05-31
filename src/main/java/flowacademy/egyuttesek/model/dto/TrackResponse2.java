package flowacademy.egyuttesek.model.dto;

import flowacademy.egyuttesek.model.Track;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrackResponse2 {

    private String id;
    private String trackName;
    private int trackLength;
    private int licencePrice;
    private String musicServiceName;


    public static TrackResponse2 giveIdTrackNameTrackLengthLicencePriceMusicServiceName(Track track) {
        return new TrackResponse2(track.getId(), track.getName(), track.getTrackLength(), track.getLicencePrice(), track.getMusicService().getName());
    }
}

