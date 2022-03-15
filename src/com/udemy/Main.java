package com.udemy;

import com.udemy.entities.Produto;
import com.udemy.entities.ProdutoImportado;
import com.udemy.entities.ProdutoUsado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Produto> listaProduto = new ArrayList<>();

        System.out.print("Numero de produtos: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Dados do produto #" + i + ":");
            System.out.print("Comum, usado ou importado (c/u/i)? ");
            char resposta = sc.next().charAt(0);
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            if (resposta == 'c') {
                listaProduto.add(new Produto(nome, preco));

            } else if (resposta == 'u') {
                System.out.print("Data de fabricação (DD/MM/AAAA): ");
                Date data = sdf.parse(sc.next());
                listaProduto.add(new ProdutoUsado(nome, preco, data));

            } else {
                System.out.print("Taxa de importação: ");
                double taxaImport = sc.nextDouble();
                listaProduto.add(new ProdutoImportado(nome, preco, taxaImport));
            }
        }

        System.out.println();
        System.out.println("Etiquetas de preço:");
        for (Produto etiquetas : listaProduto){
            System.out.println(etiquetas.etiquetaPreco());
            System.out.println();
        }

        sc.close();
    }
}
