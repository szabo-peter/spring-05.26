package flowacademy.egyuttesek.model.dto;


import flowacademy.egyuttesek.model.Album;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AlbumResponse {

    private String id;
    private String name;

    public static AlbumResponse giveIdName(Album album) {
        return new AlbumResponse(album.getId(), album.getName());
    }


}
