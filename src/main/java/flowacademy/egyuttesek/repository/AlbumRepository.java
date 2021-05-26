package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlbumRepository extends JpaRepository<Album, UUID> {
}
