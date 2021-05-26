package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MusicService {

    private String id;
    private String name;
    private List<Track> trackList;
}
