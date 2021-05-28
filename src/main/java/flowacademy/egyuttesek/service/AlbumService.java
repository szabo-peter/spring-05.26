package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.repository.AlbumRepository;
import flowacademy.egyuttesek.repository.BandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final BandRepository bandRepository;

    public List<Album> findByName(String band) {
        return albumRepository.findByBandContaining(band);
    }

    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    public Album addAlbum(Album album) {
        String bandName = album.getBand().getName();
        Band band = bandRepository.findByName(bandName);
//        System.out.println(band);
//        List<Album> albums = bandRepository.findByName(bandName).getAlbumList();
//        System.out.println(albums);
//        albums.add(album);
//        System.out.println(albums);
//        bandRepository.findByName(bandName).setAlbumList(albums);
        return albumRepository.save(
                Album.builder()
                        .id(UUID.randomUUID())
                        .name(album.getName())
                        .band(band)
                        .build());
    }
}
