package org.example;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DespesaTest {

    @Test
    void deveRejeitarCategoriaNula() {
        BigDecimal valor = new BigDecimal("99.90");
        LocalDate data = LocalDate.of(2026, 11, 22);

        //afirme que esse codigo vai lancar uma excecao
        assertThrows(IllegalArgumentException.class,
                () -> new Despesa(null, "Internet de casa", valor, data));
    }

    @Test
    void deveRejeitarDataNula() {
        BigDecimal valor = new BigDecimal("22.00");

        assertThrows(IllegalArgumentException.class,
                () -> new Despesa(Categoria.INTERNET, "teste", valor, null));
    }


    @Test
    void deveRejeitarValorZero() {
        LocalDate data = LocalDate.of(2026, 11, 22);
        String descricao = "teste";
        Categoria categoria = Categoria.INTERNET;

        assertThrows(IllegalArgumentException.class, () -> new Despesa(categoria, descricao, BigDecimal.ZERO, data));
    }

    @Test
    void deveCriarDespesaComDadosValidos(){
        LocalDate data = LocalDate.of(2026, 11, 22);
        String descricao = "teste";
        Categoria categoria = Categoria.INTERNET;
        BigDecimal valor = new BigDecimal("99.90");

        assertDoesNotThrow(() -> new Despesa(categoria, descricao, valor, data));
    }

    @Test
    void deveRejeitarValorNegativo(){
        LocalDate data = LocalDate.of(2026, 11, 22);
        String descricao = "teste";
        Categoria categoria = Categoria.INTERNET;

        assertThrows(IllegalArgumentException.class, () -> new Despesa(categoria, descricao, new BigDecimal(-10), data));
    }

    @Test
    void deveReijarDescricaoSoComEspacos(){
        LocalDate data = LocalDate.of(2026, 11, 22);
        Categoria categoria = Categoria.INTERNET;
        BigDecimal valor = new BigDecimal("99.90");

        assertThrows(IllegalArgumentException.class, () -> new Despesa(categoria, "    ", valor, data));
    }
}
