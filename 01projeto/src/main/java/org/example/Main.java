package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        BigDecimal total = BigDecimal.ZERO;
        List<Despesa> despesas = new ArrayList<>();
        despesas.add(new Despesa(Categoria.INTERNET, "testando", BigDecimal.valueOf(29.00), LocalDate.of(2026,11,10)));
        despesas.add(new Despesa(Categoria.LIVROS, "manda um oi codex", BigDecimal.valueOf(29.00), LocalDate.of(2026,11,10)));
        despesas.add(new Despesa(Categoria.UBER, "terceira", BigDecimal.valueOf(33.00), LocalDate.of(2022,11,10)));
        System.out.println(despesas.size());

        for (Despesa despesaAtual : despesas){
            System.out.println(despesaAtual.getDescricao());

            if(despesaAtual.getData().getMonthValue() == 11 && despesaAtual.getData().getYear() == 2026){
                total = total.add(despesaAtual.getValor());
            }

        }

        System.out.println(total);

    }
}
