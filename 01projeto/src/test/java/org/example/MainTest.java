package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

     @Test
     void deveSomarApenasDespesasDoMesEAnoInformados() {
         ArrayList<Despesa> despesas = new ArrayList<>();
         despesas.add(new Despesa(Categoria.LIVROS, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
         despesas.add(new Despesa(Categoria.LIVROS, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
         despesas.add(new Despesa(Categoria.LIVROS, "Teste1", BigDecimal.valueOf(22.00), LocalDate.of(2026, 10, 21)));
         despesas.add(new Despesa(Categoria.LIVROS, "Teste1", BigDecimal.valueOf(22.00), LocalDate.of(2022, 11, 21)));

         BigDecimal total = Main.calcularTotalMensal(despesas, 11, 2026);
         assertEquals(new BigDecimal("58.0"), total);
     }
}
