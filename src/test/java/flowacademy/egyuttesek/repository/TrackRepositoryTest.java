package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.Track;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class TrackRepositoryTest {
    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testTrackSave() {
        trackRepository.save(Track.builder().name("Emese")
                .id(UUID.randomUUID().toString())
                .build());

        Track track = entityManager.createQuery("select t from Track t where t.name=?0", Track.class)
                .setMaxResults(1)
                .setParameter(0, "Emese")
                .getSingleResult();

        assertNotNull(track);
    }
}