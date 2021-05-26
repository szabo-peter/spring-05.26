package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.MusicService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MusicServiceRepository extends JpaRepository<MusicService, UUID> {
}
