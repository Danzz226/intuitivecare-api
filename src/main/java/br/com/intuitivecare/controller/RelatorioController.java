package br.com.intuitivecare.controller;

import br.com.intuitivecare.dao.RelatorioDAO;
import br.com.intuitivecare.model.RelatorioDTO;
import br.com.intuitivecare.service.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController() {
        RelatorioDAO dao = new RelatorioDAO();
        this.relatorioService = new RelatorioService(dao);
    }

    @GetMapping("/relatorio")
    public List<RelatorioDTO> getRelatorio(
            @RequestParam(required = false) String uf,
            @RequestParam(defaultValue = "0") int ano,
            @RequestParam(defaultValue = "0") int trimestre
    ) {
        return relatorioService.buscarRelatorio(uf, ano, trimestre);
    }
}
