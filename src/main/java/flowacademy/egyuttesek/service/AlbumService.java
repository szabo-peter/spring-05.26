package flowacademy.egyuttesek.service;

import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.Track;
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

    public List<String> findByName(String name) {
        List<Album> albums = albumRepository.findByBandNameContaining(name);

        return albums.stream().map(album->album.getId() + ";" + album.getName()+ ";"+ album.getReleaseDate()
        + ";"+album.getTrackList().stream().map(Track::getTrackLength).reduce(0,Integer::sum)).collect(Collectors.toList());

    }


    public List<String> findAll() {
        List<Album> albums = albumRepository.findAll();
        return albums.stream().map(album->album.getId()+";"+album.getName()).collect(Collectors.toList());
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
