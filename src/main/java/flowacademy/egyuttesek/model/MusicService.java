package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicService {
    @Id
    private String id;
    private String name;
    @OneToMany(mappedBy = "musicService")
    private List<Track> trackList;
}
