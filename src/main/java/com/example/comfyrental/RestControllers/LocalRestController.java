package com.example.comfyrental.RestControllers;
import com.example.comfyrental.Services.LocalService;
import com.example.comfyrental.Entities.Local;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
@RestController
@AllArgsConstructor
@RequestMapping("/local")
@CrossOrigin(origins = "*")
public class LocalRestController {
    private final LocalService localService;
    @GetMapping(value = "/LocalDetails/{id}")
    public Local showLocal(@PathVariable long id) {
        return localService.findLocalById(id);
    }
}

