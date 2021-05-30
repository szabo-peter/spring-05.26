package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.repository.MusicServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MusicServiceService {

    private final MusicServiceRepository musicServiceRepository;

    public String createMusicService(MusicService musicService) {
        String id;
        musicServiceRepository.save(
                MusicService.builder()
                        .id(id = UUID.randomUUID().toString())
                        .name(musicService.getName())
                        .build()
        );
        return musicService.getName() + " - " + id;
    }

    public List<String> findAll() {
        List<MusicService> musicServices = musicServiceRepository.findAll();

        return musicServices.stream().map(musicService -> musicService.getId() + ";" + musicService.getName()).collect(Collectors.toList());
    }
}
