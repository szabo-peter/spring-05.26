package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.repository.AlbumRepository;
import flowacademy.egyuttesek.repository.MusicServiceRepository;
import flowacademy.egyuttesek.repository.TrackRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TrackServiceTest {

    @InjectMocks
    TrackService trackService;

    @Mock
    TrackRepository trackRepository;

    @Mock
    AlbumRepository albumRepository;



//    @Test
//    void getTracksByAlbum() {
//        List<Track> tracks = List.of(
//                Track.builder().id("001").trackLength(100).name("Név1").build(),
//                Track.builder().id("002").trackLength(200).name("Név2").build()
//        );
//
//        List<Album> albums = List.of(
//                Album.builder().name("Album címe").trackList(tracks).build()
//        );
//    }
}