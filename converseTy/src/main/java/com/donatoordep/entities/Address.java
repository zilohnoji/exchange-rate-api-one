package com.donatoordep.entities;

public class Address {
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String estado;
    private String regiao;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public String getSiafi() {
        return siafi;
    }

    public String getDdd() {
        return ddd;
    }

    public String getGia() {
        return gia;
    }

    public String getIbge() {
        return ibge;
    }

    public String getRegiao() {
        return regiao;
    }

    public String getEstado() {
        return estado;
    }

    public String getUf() {
        return uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getUnidade() {
        return unidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCep() {
        return cep;
    }
}
