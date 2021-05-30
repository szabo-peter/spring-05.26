package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.model.Track;
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

    public String createTrack(Track track) {
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
        return track.getName() + " - " + id;
    }

    public List<String> getTracksByAlbum(String name) {
        List<Track> tracks = trackRepository.findByAlbumNameContaining(name);

        return tracks.stream().map(track -> track.getId() + ";" + track.getName() + ";" + track.getTrackLength()+";"+track.getAlbum().getBand().getMusicGenre()).collect(Collectors.toList());
    }

    public List<String> getATrackFromAlbum(String id) {
        Optional<Track> findTrack = trackRepository.findById(id);

        return findTrack.stream().map(track -> track.getId() + ";" + track.getName()
                + ";" + track.getTrackLength() + ";" + track.getLicencePrice() + ";" +
                track.getMusicService().getName()).collect(Collectors.toList());
    }

    public List<String> getTracksByLengthAndGenre(int length, String genre) {
        Optional<Track> findTrack = trackRepository.findByTrackLengthAndAlbumBandMusicGenreContaining(length, genre);
        return findTrack.stream().map(track -> track.getId() + ";" + track.getName()).collect(Collectors.toList());
    }

    public void deleteATrackFromMusicService(String id) {
        Track wantToDel = trackRepository.findById(id).stream().collect(Collectors.toList()).get(0);
        trackRepository.delete(wantToDel);
    }
}
