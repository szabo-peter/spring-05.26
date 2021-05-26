package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Track {
    private String id;
    private String name;
    private int trackLength;
    private int licencePrice;
    private Album album;
    private List<MusicService> musicServiceList;
}
