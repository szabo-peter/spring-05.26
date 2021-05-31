package flowacademy.egyuttesek.controller;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.service.AlbumService;
import flowacademy.egyuttesek.service.BandService;
import flowacademy.egyuttesek.service.MusicServiceService;
import flowacademy.egyuttesek.service.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/fill/")
public class FillController {

    private final AlbumService albumService;

    private final BandService bandService;

    private final TrackService trackService;

    private final MusicServiceService musicServiceService;

    @PostMapping("album")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAlbum(@RequestBody Album album) {
       albumService.createAlbum(album);
    }

    @PostMapping("musicservice")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMusicService(@RequestBody MusicService musicService) {
         musicServiceService.createMusicService(musicService);
    }

    @PostMapping("band")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBand(@RequestBody Band band) {
        bandService.createBand(band);
    }

    @PostMapping("track")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrack(@RequestBody Track track) {
        trackService.createTrack(track);
    }

    @DeleteMapping("musicservice/track/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteATrackFromMusicService(@PathVariable String id){
        trackService.deleteATrackFromMusicService(id);
    }
}
