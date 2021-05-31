package flowacademy.egyuttesek.controller;

import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.model.dto.MusicServiceResponse;
import flowacademy.egyuttesek.model.dto.TrackResponse3;
import flowacademy.egyuttesek.service.MusicServiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/musicservice")
public class MusicServiceController {

    private final MusicServiceService musicServiceService;

    @GetMapping("")
    public List<MusicServiceResponse> getAllMusicService() {
        return musicServiceService.findAll();
    }

    @GetMapping("/{id}")
    public List<TrackResponse3> getTracksFromMusicService(@PathVariable String id) {
        return musicServiceService.getTracksFromMusicService(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMusicService(@RequestBody MusicService musicService) {
        musicServiceService.createMusicService(musicService);
    }
}
