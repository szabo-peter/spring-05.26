package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Album {
    @Id
    private String id;
    private String name;
    private Date releaseDate;
    @ManyToOne
    @JoinColumn
    private Band band;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private List<Track> trackList;

}


