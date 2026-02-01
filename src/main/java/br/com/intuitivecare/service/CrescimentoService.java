package br.com.intuitivecare.service;

import br.com.intuitivecare.dao.RelatorioDAO;
import br.com.intuitivecare.model.CrescimentoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrescimentoService {

    private final RelatorioDAO relatorioDAO;

    public CrescimentoService(RelatorioDAO relatorioDAO) {
        this.relatorioDAO = relatorioDAO;
    }

    public List<CrescimentoDTO> buscarTop5Crescimento() {
        return relatorioDAO.buscarTop5Crescimento();
    }
}
