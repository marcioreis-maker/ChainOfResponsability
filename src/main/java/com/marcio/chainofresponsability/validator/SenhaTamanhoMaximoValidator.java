package com.marcio.chainofresponsability.validator;

import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;

// Regra 8: verifica se a senha nao passa de 16 caracteres.
public class SenhaTamanhoMaximoValidator extends LoginSenhaValidator {
    @Override
    protected void verificar(LoginRequest request, ValidationResult resultado) {
        if (request.getSenha().length() > 16) {
            resultado.adicionarErro("A senha nao pode ter mais de 16 caracteres.");
        }
    }
}
