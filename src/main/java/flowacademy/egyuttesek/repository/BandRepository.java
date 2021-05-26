package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Band;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BandRepository extends JpaRepository<Band, UUID> {


}
