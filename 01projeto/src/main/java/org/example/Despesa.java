package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Despesa {
    private Categoria categoria;
    private BigDecimal valor;
    private LocalDate data;
    private String descricao;

    public Despesa(Categoria categoria, String descricao, BigDecimal valor, LocalDate data) {

        if (valor == null) {
            throw new IllegalArgumentException("Valor não pode ser nulo.");
        }

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }


        if (descricao == null) {
            throw new IllegalArgumentException("Descrição não pode ser nula.");
        }

        if (descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        }


        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

}
