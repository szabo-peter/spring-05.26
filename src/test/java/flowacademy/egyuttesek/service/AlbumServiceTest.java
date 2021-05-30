package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.repository.AlbumRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class AlbumServiceTest {
    @InjectMocks
    AlbumService albumService;

    @Mock
    AlbumRepository albumRepository;

    @Test
    public void findAllAlbumTest() {
        List<Album> albumList = List.of(
                Album.builder().id("ID01").name("Album Cím1").build(),
                Album.builder().id("ID01").name("Album Cím2").build(),
                Album.builder().id("ID01").name("Album Cím3").build()
        );
        when(albumRepository.findAll()).thenReturn(albumList);

        assertEquals(3, albumService.findAll().size());
    }

//    @Test
//    public void addAlbumTest(){
//
//        albumRepository.save(Album.builder().id("ID01").name("Album Cím1").build());
//        assertEquals(1,albumService.findAll().size());
//    }

//    Band band1 = Band.builder().id("ID1").name("Metallica").build();
//    Band band2 = Band.builder().id("ID2").name("AC/DC").build();
//    Band band3 = Band.builder().id("ID3").name("Kispál és a Borz").build();


}