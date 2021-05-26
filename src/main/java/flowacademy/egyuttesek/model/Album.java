package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class Album {
    private String id;
    private String name;
    private Date releaseDate;
    private Band band;
    private List<Track> trackList;

}
