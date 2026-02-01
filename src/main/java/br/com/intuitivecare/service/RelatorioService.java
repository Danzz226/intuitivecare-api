package br.com.intuitivecare.service;

import br.com.intuitivecare.dao.RelatorioDAO;
import br.com.intuitivecare.model.RelatorioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    private final RelatorioDAO relatorioDAO;

    public RelatorioService(RelatorioDAO relatorioDAO) {
        this.relatorioDAO = relatorioDAO;
    }

    public List<RelatorioDTO> buscarRelatorio(String uf, Integer ano, Integer trimestre) {
        return relatorioDAO.buscarRelatorio(uf, ano, trimestre);
    }
}

