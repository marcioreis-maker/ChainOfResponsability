package com.marcio.chainofresponsability.validator;

import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;

// Regra 2: verifica se a senha possui pelo menos uma letra maiuscula.
public class SenhaMaiusculaValidator extends LoginSenhaValidator {
    @Override
    protected void verificar(LoginRequest request, ValidationResult resultado) {
        if (request.getSenha().chars().noneMatch(Character::isUpperCase)) {
            resultado.adicionarErro("A senha precisa ter pelo menos uma letra maiuscula.");
        }
    }
}
