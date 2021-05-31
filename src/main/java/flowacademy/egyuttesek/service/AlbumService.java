package flowacademy.egyuttesek.service;


import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.model.dto.AlbumResponse;
import flowacademy.egyuttesek.model.dto.AlbumResponse2;
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

    public List<AlbumResponse2> findByBandId(String id) {
        List<Album> albums = albumRepository.findByBandId(id);

        return albums.stream().map(AlbumResponse2::giveIdNameDateTrackLengthSum).collect(Collectors.toList());
    }

    public List<AlbumResponse> findAll() {
        List<Album> albums = albumRepository.findAll();
        return albums.stream().map(AlbumResponse::giveIdName).collect(Collectors.toList());
    }

    public void createAlbum(Album album) {
        String bandId = album.getBand().getId();
        Band band = bandRepository.findById(bandId).orElse(null);

        albumRepository.save(
                Album.builder()
                        .id(UUID.randomUUID().toString())
                        .name(album.getName())
                        .releaseDate(album.getReleaseDate())
                        .band(band)
                        .build());
    }


}
