package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.repository.BandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BandService {

    private final BandRepository bandRepository;

    public Band createBand(Band band){
        return bandRepository.save(
                Band.builder()
                        .id(UUID.randomUUID())
                        .name(band.getName())
                        .musicGenre(band.getMusicGenre())
                        .build()
        );
    }


    public List<Band> findAll() {
        return bandRepository.findAll();
    }

}
