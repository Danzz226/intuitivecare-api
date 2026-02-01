package br.com.intuitivecare.service;

import br.com.intuitivecare.model.RelatorioDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonExporter {

    public static void exportarParaJson(List<RelatorioDTO> relatorio, String arquivoJson) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter(arquivoJson)) {
            gson.toJson(relatorio, writer);
            System.out.println("Arquivo JSON gerado com sucesso em: " + arquivoJson);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar arquivo JSON", e);
        }
    }
}
