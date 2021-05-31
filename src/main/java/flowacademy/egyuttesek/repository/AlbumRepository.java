package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, String> {

    List<Album> findByBandId(String id);
}
