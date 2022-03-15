package com.udemy.entities;

public class ProdutoImportado extends Produto {

    private Double taxaImport;

    public ProdutoImportado() {
    }

    public ProdutoImportado(String nome, Double preco, Double taxaImport) {
        super(nome, preco);
        this.taxaImport = taxaImport;
    }

    public Double getTaxaImport() {
        return taxaImport;
    }

    public void setTaxaImport(Double taxaImport) {
        this.taxaImport = taxaImport;
    }

    public Double precoTotal() {
        return getPreco() + taxaImport;
    }

    @Override
    public String etiquetaPreco() {
        return "Nome: " + getNome() + "\n"
                + "Preço: $ " + String.format("%.2f", precoTotal()) + "\n"
                + "Taxa de importação: $ " + String.format("%.2f", taxaImport);
    }
}
