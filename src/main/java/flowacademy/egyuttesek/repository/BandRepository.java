package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface BandRepository extends JpaRepository<Band, String> {

    Optional<Band> findById(String id);

}
