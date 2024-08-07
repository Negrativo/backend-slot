package com.slot.backend.controller;

import com.slot.backend.model.MatrizJogo;
import com.slot.backend.model.buscarMatrizBody;
import com.slot.backend.service.SlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SlotController {

    private final SlotService slotService;

    @PostMapping
    public MatrizJogo buscarMatrizRodilhos(@RequestBody buscarMatrizBody body) {
        return slotService.buscarMatrizRodilhos(body);
    }

    @GetMapping
    public List<List<Integer>> buscarMatrizCartela() {
        return slotService.buscarMatrizCartela();
    }

}
