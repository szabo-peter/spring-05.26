package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.repository.AlbumRepository;
import flowacademy.egyuttesek.repository.BandRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class BandServiceTest {
    @InjectMocks
    BandService bandService;

    @Mock
    BandRepository bandRepository;

    @Test
    void findAllBandTest() {
        List<Band> bandList = List.of(
                Band.builder().id("001").name("Zenekar1").build(),
                Band.builder().id("002").name("Zenekar2").build(),
                Band.builder().id("003").name("Zenekar3").build()
                );

        when(bandRepository.findAll()).thenReturn(bandList);

        assertEquals(3, bandService.findAll().size());

    }
}