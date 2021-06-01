package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
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
class BandRepositoryTest {
    @Autowired
    private BandRepository bandRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testBandSave() {
        bandRepository.save(Band.builder().name("Kispál és a borz")
                .id(UUID.randomUUID().toString())
                .build());

        Band band = entityManager.createQuery("select b from Band b where b.name=?0", Band.class)
                .setMaxResults(1)
                .setParameter(0, "Kispál és a borz")
                .getSingleResult();

        assertNotNull(band);
    }

}