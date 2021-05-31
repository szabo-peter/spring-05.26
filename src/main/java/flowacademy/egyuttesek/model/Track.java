package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
    private String id;
    private String name;
    private int trackLength;
    private int licencePrice;

    @ManyToOne
    @JoinColumn
    private Album album;

    @ManyToOne
    @JoinColumn
    private MusicService musicService;
}
