package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TrackRepository extends JpaRepository<Track, String> {
    List<Track> findByAlbumNameContaining(String name);
}
