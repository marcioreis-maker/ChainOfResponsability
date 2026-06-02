package com.marcio.chainofresponsability.validator;

import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;

// Regra 5: verifica se a senha possui pelo menos um numero.
public class SenhaNumeroValidator extends LoginSenhaValidator {
    @Override
    protected void verificar(LoginRequest request, ValidationResult resultado) {
        if (request.getSenha().chars().noneMatch(Character::isDigit)) {
            resultado.adicionarErro("A senha precisa ter pelo menos um numero.");
        }
    }
}
