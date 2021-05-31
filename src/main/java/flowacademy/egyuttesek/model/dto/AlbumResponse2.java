package flowacademy.egyuttesek.model.dto;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Track;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AlbumResponse2 {
    private String id;
    private String name;
    private Date releaseDate;
    private int trackLengthSum;

    public static AlbumResponse2 giveIdNameDateTrackLengthSum(Album album) {
        int trackLength = album.getTrackList().stream().map(Track::getTrackLength).reduce(0, Integer::sum);
        return new AlbumResponse2(album.getId(), album.getName(), album.getReleaseDate(), trackLength);
    }
}
