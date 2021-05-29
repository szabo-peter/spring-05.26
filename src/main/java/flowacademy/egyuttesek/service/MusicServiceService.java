package flowacademy.egyuttesek.service;

import flowacademy.egyuttesek.model.MusicService;
import flowacademy.egyuttesek.repository.MusicServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MusicServiceService {

    private final MusicServiceRepository musicServiceRepository;

    public MusicService createMusicService(MusicService musicService){
       return musicServiceRepository.save(
                MusicService.builder()
                        .id(UUID.randomUUID().toString())
                        .name(musicService.getName())
                        .build()
        );
    }

    public List<MusicService> findAll(){
        return musicServiceRepository.findAll();
    }
}
