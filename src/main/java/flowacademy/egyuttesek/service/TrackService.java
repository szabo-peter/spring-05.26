package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.model.dto.TrackResponse;
import flowacademy.egyuttesek.repository.AlbumRepository;
import flowacademy.egyuttesek.repository.MusicServiceRepository;
import flowacademy.egyuttesek.repository.TrackRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrackService {

    private final TrackRepository trackRepository;
    private final MusicServiceRepository musicServiceRepository;
    private final AlbumRepository albumRepository;

    public void createTrack(Track track) {
        String musicServiceName = track.getMusicService().getName();
        MusicService musicService = musicServiceRepository.findByName(musicServiceName);
        String albumId = track.getAlbum().getId();
        Album album = albumRepository.getById(albumId);

        trackRepository.save(
                Track.builder()
                        .id(UUID.randomUUID().toString())
                        .name(track.getName())
                        .licencePrice(track.getLicencePrice())
                        .trackLength(track.getTrackLength())
                        .musicService(musicService)
                        .album(album)
                        .build()
        );
    }

    public List<TrackResponse> getTracksByAlbum(String name) {
        List<Track> tracks = trackRepository.findByAlbumNameContaining(name);

        return tracks.stream().map(TrackResponse::giveIdTrackNameTrackLengthBandGenre).collect(Collectors.toList());

    }

    public List<TrackResponse> getATrackFromAlbum(String id) {
        Optional<Track> findTrack = trackRepository.findById(id);

        return findTrack.stream().map(TrackResponse::giveIdTrackNameTrackLengthLicencePriceMusicServiceName).collect(Collectors.toList());

    }

    public List<TrackResponse> getTracksByLengthAndGenre(int length, String genre) {
        Optional<Track> findTrack = trackRepository.findByTrackLengthAndAlbumBandMusicGenreContaining(length, genre);
        return findTrack.stream().map(TrackResponse::giveIdTrackName).collect(Collectors.toList());
    }


    public void deleteATrackFromMusicService(String id) {
        Track wantToDel = trackRepository.findById(id).orElse(null);
        assert wantToDel != null;
        trackRepository.delete(wantToDel);
    }
}
