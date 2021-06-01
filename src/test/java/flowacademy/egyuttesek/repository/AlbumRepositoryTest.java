package flowacademy.egyuttesek.repository;

import flowacademy.egyuttesek.model.Album;
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
class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testAlbumSave() {
        albumRepository.save(Album.builder().name("Best of 20 év")
                .id(UUID.randomUUID().toString())
                .build());

        Album album = entityManager.createQuery("select a from Album a where a.name=?0", Album.class)
                .setMaxResults(1)
                .setParameter(0, "Best of 20 év")
                .getSingleResult();

        assertNotNull(album);
    }

}