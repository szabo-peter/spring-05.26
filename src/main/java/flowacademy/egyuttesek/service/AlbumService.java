package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.repository.AlbumRepository;
import flowacademy.egyuttesek.repository.BandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
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

    public List<Album> findAll() {
        List<Album> albums = albumRepository.findAll();
        return albums.stream().map(album->

                    Album.builder()
                            .id(album.getId())
                            .name(album.getName())
                            .build()

                ).collect(Collectors.toList());
    }

    public String addAlbum(Album album) {
        String bandId = album.getBand().getId();
        Band band = bandRepository.findById(bandId).orElse(null);
        String id;
        albumRepository.save(
                Album.builder()
                        .id(id = UUID.randomUUID().toString())
                        .name(album.getName())
                        .releaseDate(album.getReleaseDate())
                        .band(band)
                        .build());
        return album.getName() + " - " + id;
    }
}
