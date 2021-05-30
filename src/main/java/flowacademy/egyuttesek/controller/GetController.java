package flowacademy.egyuttesek.controller;

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
    public List<String> getAllAlbum() {
        return albumService.findAll();
    }

    @GetMapping("band")
    public List<String> getAllBand() {
        return bandService.findAll();
    }

    @GetMapping("album/{band}")
    public List<String> getAlbumsByBand(@PathVariable String band) {
        return albumService.findByName(band);
    }

    @GetMapping("track/{album}")
    public List<String> getTracksByAlbum(@PathVariable String album) {
        return trackService.getTracksByAlbum(album);
    }

    @GetMapping("musicservice")
    public List<String> getAllMusicService() {
        return musicServiceService.findAll();
    }
}
