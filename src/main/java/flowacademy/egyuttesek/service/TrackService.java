package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.repository.AlbumRepository;
import flowacademy.egyuttesek.repository.MusicServiceRepository;
import flowacademy.egyuttesek.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class TrackService {

    private final TrackRepository trackRepository;
    private final MusicServiceRepository musicServiceRepository;
    private final AlbumRepository albumRepository;

    public String createTrack(Track track){
        String musicServiceName = track.getMusicService().getName();
        MusicService musicService = musicServiceRepository.findByName(musicServiceName);
        String albumId = track.getAlbum().getId();
        Album album = albumRepository.getById(albumId);
        String id;
        trackRepository.save(
                Track.builder()
                        .id(id = UUID.randomUUID().toString())
                        .name(track.getName())
                        .licencePrice(track.getLicencePrice())
                        .trackLength(track.getTrackLength())
                        .musicService(musicService)
                        .album(album)
                        .build()
        );
        return track.getName()+ " - "+ id;
    }
}
