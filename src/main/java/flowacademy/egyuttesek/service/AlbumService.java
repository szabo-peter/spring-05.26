package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.repository.AlbumRepository;
import flowacademy.egyuttesek.repository.BandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final BandRepository bandRepository;

    public List<Album> findByName(String band) {
        return albumRepository.findByBandContaining(band);
    }

    public Map<String, String> findAll() {
        return albumRepository.findAll().stream().collect(Collectors.toMap(Album::getId,Album::getName));
    }

    public Album addAlbum(Album album) {
        String bandId = album.getBand().getId();
        Band band = bandRepository.findById(bandId).orElse(null);
        return albumRepository.save(
                Album.builder()
                        .id(UUID.randomUUID().toString())
                        .name(album.getName())
                        .band(band)
                        .build());
    }
}
