package flowacademy.egyuttesek.controller;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.repository.AlbumRepository;
import flowacademy.egyuttesek.repository.BandRepository;
import flowacademy.egyuttesek.repository.MusicServiceRepository;
import flowacademy.egyuttesek.repository.TrackRepository;
import flowacademy.egyuttesek.service.AlbumService;
import flowacademy.egyuttesek.service.BandService;
import flowacademy.egyuttesek.service.MusicServiceService;
import flowacademy.egyuttesek.service.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/query/")
public class GetController {

    private final AlbumService albumService;

    private final BandService bandService;

    private final TrackService trackService;

    private final MusicServiceService musicServiceService;

    @GetMapping("album")
    public Map<String, String> getAllAlbum() {
        return albumService.findAll();
    }

    @GetMapping("band")
    public Map<String, String> getAllBand() {
        return bandService.findAll();
    }

    @GetMapping("album/{band}")
    public List<Album> getAlbumsByBand(@PathVariable String band) {
        return albumService.findByName(band);
    }

    @GetMapping("musicservice")
    public List<MusicService> getAllMusicService(){
        return musicServiceService.findAll();
    }
}
