package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Band {
    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private MusicGenre musicGenre;

    @OneToMany(mappedBy = "band", fetch = FetchType.EAGER)
    protected List<Album> albumList;


}
