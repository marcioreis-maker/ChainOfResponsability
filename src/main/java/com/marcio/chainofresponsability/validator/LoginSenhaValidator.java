package com.marcio.chainofresponsability.validator;

import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;

public abstract class LoginSenhaValidator {
    // Guarda o proximo elo da cadeia.
    private LoginSenhaValidator next;

    public void setNext(LoginSenhaValidator proximo) {
        // Se ja existe um proximo, procura o ultimo elo e adiciona la no final.
        if (next == null) {
            next = proximo;
        } else {
            next.setNext(proximo);
        }
    }

    public ValidationResult validar(LoginRequest request) {
        // Um unico resultado e compartilhado para acumular todos os erros encontrados.
        ValidationResult resultado = new ValidationResult();
        validar(request, resultado);
        return resultado;
    }

    protected void validar(LoginRequest request, ValidationResult resultado) {
        // Cada classe concreta faz apenas a sua verificacao.
        verificar(request, resultado);

        // Depois repassa para o proximo validador, se existir.
        if (next != null) {
            next.validar(request, resultado);
        }
    }

    protected abstract void verificar(LoginRequest request, ValidationResult resultado);
}
