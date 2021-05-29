package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BandRepository extends JpaRepository<Band, String> {

    Band findByName(String name);

}
