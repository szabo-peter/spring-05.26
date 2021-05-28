package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TrackService {

    private final TrackRepository trackRepository;

    public Track createTrack(Track track){
        return trackRepository.save(
                Track.builder()
                        .id(UUID.randomUUID())
                        .name(track.getName())
                        .licencePrice(track.getLicencePrice())
                        .trackLength(track.getTrackLength())
                        .build()
        );
    }
}
