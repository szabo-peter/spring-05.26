package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TrackRepository extends JpaRepository<Track, UUID> {
}
