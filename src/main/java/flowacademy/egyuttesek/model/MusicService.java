package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
public class MusicService {
    @Id
    private UUID id;
    private String name;
    @OneToMany(mappedBy = "musicServiceList")
    private List<Track> trackList;
}
