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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/fill/")
public class FillController {

    private final AlbumService albumService;

    private final BandService bandService;

    private final TrackService trackService;

    private final MusicServiceService musicServiceService;

    @PostMapping("album")
    public String createAlbum(@RequestBody Album album){
        return albumService.addAlbum(album);
    }

    @PostMapping("musicservice")
    public String createMusicService(@RequestBody MusicService musicService) {
        return musicServiceService.createMusicService(musicService);
    }
    @PostMapping("band")
    public String createBand(@RequestBody Band band) {
        return bandService.createBand(band);
    }

    @PostMapping("letrehoz/track")
    public String createTrack(@RequestBody Track track) {
        return trackService.createTrack(track);
    }
}
