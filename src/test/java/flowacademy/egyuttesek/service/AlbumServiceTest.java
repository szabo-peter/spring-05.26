package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.dto.AlbumResponse2;
import flowacademy.egyuttesek.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

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
                Album.builder().id("ID02").name("Album Cím2").build(),
                Album.builder().id("ID03").name("Album Cím3").build()
        );
        when(albumRepository.findAll()).thenReturn(albumList);

        assertEquals(3, albumService.findAll().size());
    }

//    @Test
//    void findByBandId() {
//        List<Album> albumList = List.of(
//                Album.builder().id("A01").name("Album Cím1").band(
//                        Band.builder().id("B01").build()
//                ).build(),
//                Album.builder().id("A02").name("Album Cím1").band(
//                        Band.builder().id("B02").build()
//                ).build(),
//                Album.builder().id("A02").name("Album Cím1").band(
//                        Band.builder().id("B03").build()
//                ).build()
//        );
//        when(albumRepository.findAll()).thenReturn(albumList);
//        System.out.println(albumList);
//        List<Album> albums = albumRepository.findByBandId("B03");
//
//        assertEquals(1,albums.size());
//    }

//    @Test
//    void findByName() {
//        Band band1 = Band.builder().id("ID1").name("Metallica").build();
//
//        Album album = Album.builder().id("ID01").name("Album Cím1").band(band1).build();
//        when(albumRepository.findByBandNameContaining("Metallica")).thenReturn(List.of(album));
//
//        assertEquals("ID01",albumService.findByName("Metallica").get(0).split(";")[0]);
//    }

}