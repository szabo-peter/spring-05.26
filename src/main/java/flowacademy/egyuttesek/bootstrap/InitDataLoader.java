package flowacademy.egyuttesek.bootstrap;

import com.github.javafaker.Faker;
import flowacademy.egyuttesek.model.Album;
import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.model.Track;
import flowacademy.egyuttesek.repository.AlbumRepository;
import flowacademy.egyuttesek.repository.BandRepository;
import flowacademy.egyuttesek.repository.MusicServiceRepository;
import flowacademy.egyuttesek.repository.TrackRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitDataLoader implements CommandLineRunner {

    private final AlbumRepository albumRepository;
    private final BandRepository bandRepository;
    private final MusicServiceRepository musicServiceRepository;
    private final TrackRepository trackRepository;

    @Bean
    public Faker faker() {
        return new Faker(Locale.forLanguageTag("hu-HU"));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void run(String... args) throws Exception {
        saveBands();
        List<Band> bands = bandRepository.findAll();
        saveAlbums(bands);
        saveMusicService();
        List<Album> albums = albumRepository.findAll();
        List<MusicService> musicServices = musicServiceRepository.findAll();
        saveTrack(albums,musicServices);
    }

    @Transactional
    private void saveBands() {
        List<Band> bands = bandRepository.saveAll(
                newBands()
        );

        log.info("Generated {} bands", bands.size());
    }

    private List<Band> newBands() {
        return IntStream.range(0, 10)
                .mapToObj(value -> Band.builder()
                        .id(UUID.randomUUID().toString())
                        .musicGenre(faker().music().genre())
                        .name(faker().rockBand().name())
                        .build())
                .collect(Collectors.toList());
    }
    @Transactional
    private void saveAlbums(List<Band> bands) {
        List<Album> albums = albumRepository.saveAll(
                newAlbums(bands)
        );

        log.info("Generated {} albums", albums.size());
    }

    private List<Album> newAlbums(List<Band> bands) {
        return IntStream.range(0, 10)
                .mapToObj(value -> Album.builder()
                        .id(UUID.randomUUID().toString())
                        .name(faker().music().key())
                        .band(bands.get(new Random().nextInt(bands.size())))
                        .releaseDate(faker().date().birthday(1,20))
                        .build())
                .collect(Collectors.toList());
    }
    @Transactional
    private void saveMusicService() {
        List<MusicService> musicServices = musicServiceRepository.saveAll(
                    newMusicService()
        );

        log.info("Generated {} musicService", musicServices.size());
    }
    private List<MusicService> newMusicService() {
        return IntStream.range(0, 10)
                .mapToObj(value -> MusicService.builder()
                        .id(UUID.randomUUID().toString())
                        .name(faker().company().name())
                        .build())
                .collect(Collectors.toList());
    }
    @Transactional
    private void saveTrack(List<Album> albums, List<MusicService> musicServices) {
        List<Track> tracks = trackRepository.saveAll(
                newTrack(albums,musicServices)
        );

        log.info("Generated {} track", tracks.size());
    }

    private List<Track> newTrack(List<Album> albums, List<MusicService> musicServices) {
        return IntStream.range(0, 30)
                .mapToObj(value -> Track.builder()
                        .id(UUID.randomUUID().toString())
                        .name(faker().superhero().power())
                        .licencePrice(faker().number().numberBetween(10,200))
                        .trackLength(faker().number().numberBetween(200,500))
                        .album(albums.get(new Random().nextInt(albums.size())))
                        .musicService(musicServices.get(new Random().nextInt(musicServices.size())))
                        .build())
                .collect(Collectors.toList());
    }
}
