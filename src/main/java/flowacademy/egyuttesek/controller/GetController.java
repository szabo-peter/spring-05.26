package flowacademy.egyuttesek.controller;

import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.model.dto.AlbumResponse;
import flowacademy.egyuttesek.model.dto.BandResponse;
import flowacademy.egyuttesek.model.dto.MusicServiceResponse;
import flowacademy.egyuttesek.model.dto.TrackResponse;
import flowacademy.egyuttesek.service.AlbumService;
import flowacademy.egyuttesek.service.BandService;
import flowacademy.egyuttesek.service.MusicServiceService;
import flowacademy.egyuttesek.service.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/query/")
public class GetController {

    private final AlbumService albumService;

    private final BandService bandService;

    private final TrackService trackService;

    private final MusicServiceService musicServiceService;

    @GetMapping("album")
    public List<AlbumResponse> getAllAlbum() {
        return albumService.findAll();
    }

    @GetMapping("band")
    public List<BandResponse> getAllBand() {
        return bandService.findAll();
    }

    @GetMapping("album/{band}")
    public List<AlbumResponse> getAlbumsByBand(@PathVariable String band) {
        return albumService.findByName(band);
    }

    @GetMapping("track/{album}")
    public List<TrackResponse> getTracksByAlbum(@PathVariable String album) {
        return trackService.getTracksByAlbum(album);
    }

    @GetMapping("musicservice")
    public List<MusicServiceResponse> getAllMusicService() {
        return musicServiceService.findAll();
    }

    @GetMapping("musicservice/{id}")
    public List<TrackResponse> getTracksFromMusicService(@PathVariable String id) {
        return musicServiceService.getTracksFromMusicService(id);
    }

    @GetMapping("track/album/{id}")
    public List<TrackResponse> getATrackFromAlbum(@PathVariable String id){
        return trackService.getATrackFromAlbum(id);
    }

    @GetMapping("/track")
    public List<TrackResponse> getTracksByLengthAndGenre(
                        @RequestParam("length") String length,
                        @RequestParam("genre") String genre) {

        return trackService.getTracksByLengthAndGenre(Integer.parseInt(length),genre);
    }
}
