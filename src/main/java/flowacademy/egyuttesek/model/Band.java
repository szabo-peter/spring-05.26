package flowacademy.egyuttesek.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Band {
    private String id;
    private String name;
    private String musicGenre;
    private List<Album> albumList;

}
