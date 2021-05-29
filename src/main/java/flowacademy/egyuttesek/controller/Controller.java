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
@RequestMapping("/api/v1/")
public class Controller {

    private final AlbumService albumService;

    private final BandService bandService;

    private final TrackService trackService;

    private final MusicServiceService musicServiceService;

    @GetMapping("query/album")
    public Map<String, String> getAllAlbum() {
        return albumService.findAll();
    }

    @GetMapping("query/band")
    public List<Band> getAllBand() {
        return bandService.findAll();
    }

    @GetMapping("query/album/{band}")
    public List<Album> getAlbumsByBand(@PathVariable String band) {
        return albumService.findByName(band);
    }



    @PostMapping("letrehoz/album")
    public Album createAlbum(@RequestBody Album album) {
        return albumService.addAlbum(album);
    }

    @PostMapping("letrehoz/musicservice")
    public MusicService createMusicService(@RequestBody MusicService musicService) {
        return musicServiceService.createMusicService(musicService);
    }
    @PostMapping("letrehoz/band")
    public Band createBand(@RequestBody Band band) {
        return bandService.createBand(band);
    }

    @PostMapping("letrehoz/track")
    public Track createTrack(@RequestBody Track track) {
        return trackService.createTrack(track);
    }
}
