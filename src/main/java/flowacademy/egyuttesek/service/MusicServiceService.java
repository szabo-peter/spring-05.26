package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.model.dto.MusicServiceResponse;
import flowacademy.egyuttesek.model.dto.TrackResponse;
import flowacademy.egyuttesek.repository.MusicServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MusicServiceService {

    private final MusicServiceRepository musicServiceRepository;

    public void createMusicService(MusicService musicService) {

        musicServiceRepository.save(
                MusicService.builder()
                        .id(UUID.randomUUID().toString())
                        .name(musicService.getName())
                        .build()
        );
    }

    public List<MusicServiceResponse> findAll() {
        List<MusicService> musicServices = musicServiceRepository.findAll();

        return musicServices.stream().map(MusicServiceResponse::giveIdName).collect(Collectors.toList());
    }

    public List<TrackResponse> getTracksFromMusicService(String id) {
        List<Track> tracks = musicServiceRepository.getById(id).getTrackList();

        return tracks.stream().map(TrackResponse::giveIdTrackNameBandName).collect(Collectors.toList());
    }
}
