package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.dto.BandResponse;
import flowacademy.egyuttesek.repository.BandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BandService {

    private final BandRepository bandRepository;

    public void createBand(Band band){

        bandRepository.save(
                Band.builder()
                        .id(UUID.randomUUID().toString())
                        .name(band.getName())
                        .musicGenre(band.getMusicGenre())
                        .build()
        );
    }

    public List<BandResponse> findAll() {
        List<Band> bands = bandRepository.findAll();

        return bands.stream().map(BandResponse::create).collect(Collectors.toList());
    }
}
