package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Despesa> despesas = new ArrayList<>();
        despesas.add(new Despesa(Categoria.INTERNET, "testando", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 10)));
        despesas.add(new Despesa(Categoria.LIVROS, "manda um oi codex", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 10)));
        despesas.add(new Despesa(Categoria.UBER, "terceira", BigDecimal.valueOf(33.00), LocalDate.of(2022, 11, 10)));
        System.out.println(despesas.size());
        System.out.println(calcularTotalMensal(despesas, 11, 2026));
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
}