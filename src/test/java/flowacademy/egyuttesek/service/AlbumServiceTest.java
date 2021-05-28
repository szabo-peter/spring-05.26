package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.repository.AlbumRepository;
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
//    @InjectMocks
//    AlbumService albumService;
//
//    @Mock
//    AlbumRepository albumRepository;
//
//    @Test
//    public void findByBandNameTest() {
//        Band band1 = new Band(UUID.randomUUID(), "Metallica", "tipus", List.of());
//        Band band2 = new Band(UUID.randomUUID(), "Mas", "tipus", List.of());
//        Band band3 = new Band(UUID.randomUUID(), "Mas", "tipus", List.of());
//
//        List<Album> albumList = List.of(
//                new Album(UUID.randomUUID(), "AlbumCím", Date.valueOf(LocalDate.now()), band1, List.of()),
//                new Album(UUID.randomUUID(), "AlbumCím2", Date.valueOf(LocalDate.now()), band2, List.of()),
//                new Album(UUID.randomUUID(), "AlbumCím3", Date.valueOf(LocalDate.now()), band3, List.of())
//
//        );
//        when(albumRepository.findAll()).thenReturn(albumList);
//
//        List<Album> albums = albumService.findByName("AlbumCím");
//
//        assertEquals(1, albums.size());
//    }

}