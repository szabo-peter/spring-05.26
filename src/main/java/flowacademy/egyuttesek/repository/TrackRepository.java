package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface TrackRepository extends JpaRepository<Track, String> {
    List<Track> findByAlbumNameContaining(String name);

    Optional<Track> findById(String id);

    Optional<Track> findByTrackLengthAndAlbumBandMusicGenreContaining(int trackLength, String musicGenre);


}
