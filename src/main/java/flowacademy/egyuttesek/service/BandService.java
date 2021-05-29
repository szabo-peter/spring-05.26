package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.repository.BandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BandService {

    private final BandRepository bandRepository;

    public Band createBand(Band band){
        return bandRepository.save(
                Band.builder()
                        .id(UUID.randomUUID().toString())
                        .name(band.getName())
                        .musicGenre(band.getMusicGenre())
                        .build()
        );
    }

    public Map<String, String> findAll() {
        return bandRepository.findAll().stream().collect(Collectors.toMap(Band::getId,Band::getName));
    }

}
