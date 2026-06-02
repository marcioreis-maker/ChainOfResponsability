package com.marcio.chainofresponsability.validator;

import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;

// Regra 3: verifica se a senha possui pelo menos uma letra minuscula.
public class SenhaMinusculaValidator extends LoginSenhaValidator {
    @Override
    protected void verificar(LoginRequest request, ValidationResult resultado) {
        if (request.getSenha().chars().noneMatch(Character::isLowerCase)) {
            resultado.adicionarErro("A senha precisa ter pelo menos uma letra minuscula.");
        }
    }
}
