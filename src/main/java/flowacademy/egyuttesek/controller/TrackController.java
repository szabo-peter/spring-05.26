package flowacademy.egyuttesek.controller;

import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.model.dto.TrackResponse;
import flowacademy.egyuttesek.model.dto.TrackResponse2;
import flowacademy.egyuttesek.service.TrackService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/track")
public class TrackController {

    private final TrackService trackService;

    @GetMapping("/{albumname}")
    public List<TrackResponse> getTracksByAlbum(@PathVariable String albumname) {
        return trackService.getTracksByAlbum(albumname);
    }

    @GetMapping("id/{id}")
    public List<TrackResponse2> getATrackById(@PathVariable String id) {
        return trackService.getATrackById(id);
    }

    @GetMapping("")
    public List<TrackResponse> getTracksByLengthAndGenre(
            @RequestParam("length") String length,
            @RequestParam("genre") String genre) {

        return trackService.getTracksByLengthAndGenre(Integer.parseInt(length), genre);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTrack(@RequestBody Track track) {
        trackService.createTrack(track);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteATrackFromMusicService(@PathVariable String id) {
        trackService.deleteATrackFromMusicService(id);
    }

}
