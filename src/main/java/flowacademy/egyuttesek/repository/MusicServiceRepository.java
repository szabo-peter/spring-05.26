package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.MusicService;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MusicServiceRepository extends JpaRepository<MusicService, String> {
    MusicService findByName(String musicServiceName);
}
