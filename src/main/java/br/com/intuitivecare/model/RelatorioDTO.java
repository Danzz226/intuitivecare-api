package br.com.intuitivecare.model;
public class RelatorioDTO {
    private String uf;
    private int ano;
    private int trimestre;
    private double totalGasto;
    private String razaoSocial;


    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public double getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(double totalGasto) {
        this.totalGasto = totalGasto;
    }
    @Override
    public String toString() {
        return "RelatorioDTO{ " +
                "uf= '" + uf + '\'' +
                ", ano= " + ano +
                ", trimestre= " + trimestre +
                ", totalGasto= " + totalGasto +
                ", razaoSocial= '" + razaoSocial + '\'' +
                '}';
    }
}

