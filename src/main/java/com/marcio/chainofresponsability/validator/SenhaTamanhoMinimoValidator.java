package com.marcio.chainofresponsability.validator;

import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;

// Regra 7: verifica se a senha tem pelo menos 8 caracteres.
public class SenhaTamanhoMinimoValidator extends LoginSenhaValidator {
    @Override
    protected void verificar(LoginRequest request, ValidationResult resultado) {
        if (request.getSenha().length() < 8) {
            resultado.adicionarErro("A senha precisa ter pelo menos 8 caracteres.");
        }
    }
}
