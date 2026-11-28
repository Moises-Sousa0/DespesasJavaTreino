package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Despesa> despesas = new ArrayList<>();
        despesas.add(new Despesa(Categoria.INTERNET, "testando", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 10)));
        despesas.add(new Despesa(Categoria.LIVROS, "manda um oi codex", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 10)));
        despesas.add(new Despesa(Categoria.UBER, "terceira", BigDecimal.valueOf(33.00), LocalDate.of(2022, 11, 10)));
        despesas.add(new Despesa(Categoria.UBER, "quatro", BigDecimal.valueOf(23.00), LocalDate.of(2022, 11, 10)));
        System.out.println(despesas.size());
        System.out.println(calcularTotalMensal(despesas, 11, 2026));
        Map<Categoria, List<Despesa>> grupos = agruparPorCategoria(despesas);
        System.out.println(grupos.get(Categoria.UBER).size());

    }

    //metodo da classe
    static BigDecimal calcularTotalMensal(List<Despesa> despesas, int mes, int ano) {
        BigDecimal total = BigDecimal.ZERO;

        for (Despesa despesaAtual : despesas) {

            if (despesaAtual.getData().getMonthValue() == mes && despesaAtual.getData().getYear() == ano) {
                total = total.add(despesaAtual.getValor());
            }
        }
        return total;
    }


    //
    static Map<Categoria, List<Despesa>> agruparPorCategoria(List<Despesa> despesas) {
        Map<Categoria, List<Despesa>> grupos = new HashMap<>();

        for (Despesa despesaAtual : despesas) {
            Categoria categoriaAtual = despesaAtual.getCategoria();
            List<Despesa> listaDaCategoria = grupos.get(categoriaAtual);
            if (listaDaCategoria == null) {
                listaDaCategoria = new ArrayList<>();
                grupos.put(categoriaAtual, listaDaCategoria);
            }
            listaDaCategoria.add(despesaAtual);
        }

        return grupos;
    }

    static List<Despesa> filtrarPorCategoria(List<Despesa> despesas, Categoria categoriaEscolhida) {
        List<Despesa> resultado = new ArrayList<>();

        for (Despesa despesaAtual: despesas) {
            Categoria categoriaAtual = despesaAtual.getCategoria();
            if (categoriaEscolhida.equals(categoriaAtual)) {
                resultado.add(despesaAtual);
            }

        }
        return resultado;
    }

}