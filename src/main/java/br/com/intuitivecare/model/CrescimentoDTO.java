package br.com.intuitivecare.model;

public class CrescimentoDTO {
    private String razaoSocial;
    private String uf;
    private int ano;
    private double valorInicial;
    private double crescimentoPercentual;
    private double valorFinal;

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

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public double getCrescimentoPercentual() {
        return crescimentoPercentual;
    }

    public void setCrescimentoPercentual(double crescimentoPercentual) {
        this.crescimentoPercentual = crescimentoPercentual;
    }


}
