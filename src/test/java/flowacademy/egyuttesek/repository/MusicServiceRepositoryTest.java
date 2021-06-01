package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.MusicService;
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
class MusicServiceRepositoryTest {
    @Autowired
    private MusicServiceRepository musicServiceRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testMusicServiceSave() {
        musicServiceRepository.save(MusicService.builder().name("Spotify")
                .id(UUID.randomUUID().toString())
                .build());

        MusicService musicService = entityManager.createQuery("select m from MusicService m where m.name=?0", MusicService.class)
                .setMaxResults(1)
                .setParameter(0, "Spotify")
                .getSingleResult();

        assertNotNull(musicService);
    }
}