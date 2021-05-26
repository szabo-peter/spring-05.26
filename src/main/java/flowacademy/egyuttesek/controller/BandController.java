package flowacademy.egyuttesek.controller;

import flowacademy.egyuttesek.repository.AlbumRepository;
import flowacademy.egyuttesek.repository.BandRepository;
import flowacademy.egyuttesek.repository.MusicServiceRepository;
import flowacademy.egyuttesek.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class BandController {

    private final AlbumRepository albumRepository;

    private final BandRepository bandRepository;

    private  final TrackRepository trackRepository;

    private  final MusicServiceRepository musicServiceRepository;
}
