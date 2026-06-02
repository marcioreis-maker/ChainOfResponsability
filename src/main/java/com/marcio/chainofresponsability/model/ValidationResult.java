package com.marcio.chainofresponsability.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidationResult {
    private final List<String> erros = new ArrayList<>();

    public void adicionarErro(String erro) {
        erros.add(erro);
    }

    public boolean estaValido() {
        return erros.isEmpty();
    }

    public List<String> getErros() {
        return Collections.unmodifiableList(erros);
    }
}
