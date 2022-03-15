package com.udemy.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProdutoUsado extends Produto {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Date dataFabricacao;

    public ProdutoUsado() {
    }

    public ProdutoUsado(String nome, Double preco, Date dataFabricacao) {
        super(nome, preco);
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String etiquetaPreco() {
        return "Nome: " + getNome() + "(usado)" + "\n"
                + "Preço: $ " + String.format("%.2f", getPreco()) + "\n"
                + "Data de fabricação: " + sdf.format(dataFabricacao);
    }
}
