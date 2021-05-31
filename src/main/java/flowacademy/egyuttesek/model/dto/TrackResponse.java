package flowacademy.egyuttesek.model.dto;


import flowacademy.egyuttesek.model.Track;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrackResponse {

    private String id;
    private String trackName;
    private String bandName;
    private int trackLength;
    private int licencePrice;
    private String bandGenre;
    private String musicServiceName;


    public TrackResponse(String id, String trackName, String bandGenre) {
        this.id = id;
        this.trackName = trackName;
        this.bandName = bandGenre;
    }

    public static TrackResponse giveIdTrackNameBandName(Track track){
        return new TrackResponse(track.getId(), track.getName(),track.getAlbum().getBand().getName());
    }

    public TrackResponse(String id, String trackName, int trackLength, String bandGenre) {
        this.id = id;
        this.trackName = trackName;
        this.trackLength = trackLength;
        this.bandGenre = bandGenre;
    }

    public static TrackResponse giveIdTrackNameTrackLengthBandGenre(Track track){
        return new TrackResponse(track.getId(),track.getName(),track.getTrackLength(),track.getAlbum().getBand().getMusicGenre());
    }


    public TrackResponse(String id, String trackName, int trackLength, int licencePrice, String musicServiceName) {
        this.id = id;
        this.trackName = trackName;
        this.trackLength = trackLength;
        this.licencePrice = licencePrice;
        this.musicServiceName = musicServiceName;
    }

    public static TrackResponse giveIdTrackNameTrackLengthLicencePriceMusicServiceName(Track track){
        return new TrackResponse(track.getId(), track.getName(), track.getTrackLength(),track.getLicencePrice(),track.getMusicService().getName());
    }

    public TrackResponse(String id, String trackName) {
        this.id = id;
        this.trackName = trackName;
    }

    public static  TrackResponse giveIdTrackName(Track track){
        return new TrackResponse(track.getId(),track.getName());
    }
}
