package br.com.intuitivecare.dao;

import br.com.intuitivecare.config.DatabaseConnection;
import br.com.intuitivecare.model.CrescimentoDTO;
import br.com.intuitivecare.model.RelatorioDTO;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class RelatorioDAO {

    public List<RelatorioDTO> buscarRelatorio(String uf, Integer ano, Integer trimestre) {
        List<RelatorioDTO> relatorios = new ArrayList<>();

        StringBuilder sql = new StringBuilder("""
            SELECT
                op.Razao_Social,
                op.UF,
                dc.Ano,
                dc.Trimestre,
                SUM(dc.Valor_Empresa) AS Total_Gasto
            FROM Despesas_Consolidadas dc
            JOIN Dados_Operadoras op
                ON dc.Operadora_ID = op.ID
            WHERE 1=1
        """);

        List<Object> parametros = new ArrayList<>();

        if (uf != null && !uf.isBlank()) {
            sql.append(" AND op.UF = ?");
            parametros.add(uf);
        }

        if (ano != null) {
            sql.append(" AND dc.Ano = ?");
            parametros.add(ano);
        }

        if (trimestre != null) {
            sql.append(" AND dc.Trimestre = ?");
            parametros.add(trimestre);
        }

        sql.append("""
            GROUP BY op.Razao_Social, op.UF, dc.Ano, dc.Trimestre
            ORDER BY Total_Gasto DESC
        """);

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql.toString())) {

            for (int i = 0; i < parametros.size(); i++) {
                stmt.setObject(i + 1, parametros.get(i));
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RelatorioDTO dto = new RelatorioDTO();
                dto.setRazaoSocial(rs.getString("Razao_Social"));
                dto.setUf(rs.getString("UF"));
                dto.setAno(rs.getInt("Ano"));
                dto.setTrimestre(rs.getInt("Trimestre"));
                dto.setTotalGasto(rs.getDouble("Total_Gasto"));
                relatorios.add(dto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o relatório no banco", e);
        }

        return relatorios;
    }

    public List<CrescimentoDTO> buscarTop5Crescimento() {
        List<CrescimentoDTO> lista = new ArrayList<>();

        String sql = """
            SELECT
                op.Razao_Social,
                op.UF,
                dc.Ano,
                MIN(dc.Valor_Empresa) AS valor_inicial,
                MAX(dc.Valor_Empresa) AS valor_final,
                ROUND(((MAX(dc.Valor_Empresa) - MIN(dc.Valor_Empresa)) / MIN(dc.Valor_Empresa)) * 100, 2) AS crescimento_percentual
            FROM Despesas_Consolidadas dc
            JOIN Dados_Operadoras op
                ON dc.Operadora_ID = op.ID
            GROUP BY op.Razao_Social, op.UF, dc.Ano
            HAVING valor_inicial > 0
            ORDER BY crescimento_percentual DESC
            LIMIT 5;
        """;

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                CrescimentoDTO dto = new CrescimentoDTO();
                dto.setRazaoSocial(rs.getString("Razao_Social"));
                dto.setUf(rs.getString("UF"));
                dto.setAno(rs.getInt("Ano"));
                dto.setValorInicial(rs.getDouble("valor_inicial"));
                dto.setValorFinal(rs.getDouble("valor_final"));
                dto.setCrescimentoPercentual(rs.getDouble("crescimento_percentual"));
                lista.add(dto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar crescimento das operadoras", e);
        }

        return lista;
    }
}
