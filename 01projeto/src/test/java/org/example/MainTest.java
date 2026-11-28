package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

     @Test
    void  DeveAgruparPorCategoria(){
         ArrayList<Despesa> despesas = new ArrayList<>();
         despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
         despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
         despesas.add(new Despesa(Categoria.LIVROS, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
         despesas.add(new Despesa(Categoria.INTERNET, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));

         Map<Categoria, List<Despesa>> grupos = Main.agruparPorCategoria(despesas);
         int quantidadeDeUbers = grupos.get(Categoria.UBER).size();
         assertEquals(2, quantidadeDeUbers);
     }


    @Test
    void  DeveAgruparPorCategoriaInternet(){
        ArrayList<Despesa> despesas = new ArrayList<>();
        despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
        despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
        despesas.add(new Despesa(Categoria.LIVROS, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
        despesas.add(new Despesa(Categoria.INTERNET, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));

        Map<Categoria, List<Despesa>> grupos = Main.agruparPorCategoria(despesas);
        int quantidadeDeInternet = grupos.get(Categoria.INTERNET).size();
        assertEquals(1, quantidadeDeInternet);
    }

    @Test
    void DeveFiltrarDespesaPorCategoria(){
         ArrayList<Despesa> despesas = new ArrayList<>();
        despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
        despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
        despesas.add(new Despesa(Categoria.LIVROS, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
        despesas.add(new Despesa(Categoria.INTERNET, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));


        List<Despesa> filtrarPorCategoria = Main.filtrarPorCategoria(despesas, Categoria.UBER);
        int quantidadeDeUbers = filtrarPorCategoria.size();
        assertEquals(2, quantidadeDeUbers);
        assertEquals(Categoria.UBER, filtrarPorCategoria.get(0).getCategoria());
        assertEquals(Categoria.UBER, filtrarPorCategoria.get(1).getCategoria());

    }

    @Test
    void DeveFiltrarDespesaPorCategoriaVazia(){
         List<Despesa> despesas = new ArrayList<>();
        despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
        despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
        despesas.add(new Despesa(Categoria.LIVROS, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));
        despesas.add(new Despesa(Categoria.INTERNET, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 21)));

        List<Despesa> filtrarPorCategoria = Main.filtrarPorCategoria(despesas, Categoria.JOGOS);
        int quantidadeDeTeste = filtrarPorCategoria.size();
        assertTrue(quantidadeDeTeste <= 0);
    }


    @Test
    void DeveFiltrarDespesasPorPeriodo(){
        List<Despesa> despesas = new ArrayList<>();
        despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 1)));
        despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 30)));
        despesas.add(new Despesa(Categoria.LIVROS, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 12, 22)));
        despesas.add(new Despesa(Categoria.INTERNET, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 1, 21)));

        List<Despesa> filtrarPorPeriodo = Main.filtrarPorPeriodo(despesas, LocalDate.of(2026,11,1), LocalDate.of(2026, 11, 30));
        int quantidadeDeDespesasPorPeriodo = filtrarPorPeriodo.size();
        assertEquals(2, quantidadeDeDespesasPorPeriodo);

    }

    @Test
    void deveOrdenarDespesasDaMaisAntigaParaAMaisRecente(){
        List<Despesa> despesas = new ArrayList<>();
        despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 01)));
        despesas.add(new Despesa(Categoria.UBER, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 11, 30)));
        despesas.add(new Despesa(Categoria.LIVROS, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 12, 22)));
        despesas.add(new Despesa(Categoria.INTERNET, "Teste1", BigDecimal.valueOf(29.00), LocalDate.of(2026, 1, 21)));

        List<Despesa> ordenarPorData = Main.ordenarPorData(despesas);
        assertEquals(LocalDate.of(2026, 01, 21), ordenarPorData.get(0).getData());
        assertEquals(LocalDate.of(2026, 11, 01), ordenarPorData.get(1).getData());
        assertEquals(LocalDate.of(2026, 11, 30), ordenarPorData.get(2).getData());
        assertEquals(LocalDate.of(2026, 12, 22), ordenarPorData.get(3).getData());

    }

}
