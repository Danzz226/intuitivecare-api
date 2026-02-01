package br.com.intuitivecare.controller;

import br.com.intuitivecare.model.CrescimentoDTO;
import br.com.intuitivecare.service.CrescimentoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estatisticas")
public class CrescimentoController {

    private final CrescimentoService crescimentoService;

    public CrescimentoController(CrescimentoService crescimentoService) {
        this.crescimentoService = crescimentoService;
    }

    @GetMapping("/crescimento")
    public List<CrescimentoDTO> buscarCrescimento() {
        return crescimentoService.buscarTop5Crescimento();
    }
}
