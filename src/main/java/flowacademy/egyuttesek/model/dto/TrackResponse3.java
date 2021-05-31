package flowacademy.egyuttesek.model.dto;

import flowacademy.egyuttesek.model.Track;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrackResponse3 {

    private String id;
    private String trackName;
    private String bandGenre;


    public static TrackResponse3 giveIdTrackNameBandName(Track track) {
        return new TrackResponse3(track.getId(), track.getName(), track.getAlbum().getBand().getName());
    }



}
