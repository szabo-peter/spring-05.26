package flowacademy.egyuttesek.controller;

import flowacademy.egyuttesek.model.Band;
import flowacademy.egyuttesek.model.dto.BandResponse;
import flowacademy.egyuttesek.service.BandService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/band")
public class BandController {

    private final BandService bandService;

    @GetMapping("")
    public List<BandResponse> getAllBand() {
        return bandService.findAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBand(@RequestBody Band band) {
        bandService.createBand(band);
    }
}
