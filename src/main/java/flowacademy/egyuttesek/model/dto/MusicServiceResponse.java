package flowacademy.egyuttesek.model.dto;

import flowacademy.egyuttesek.model.MusicService;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MusicServiceResponse {

    private String id;
    private String name;

    public static MusicServiceResponse giveIdName(MusicService musicService){
        return new MusicServiceResponse(musicService.getId(), musicService.getName());
    }

}
