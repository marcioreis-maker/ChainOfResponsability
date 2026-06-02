package com.marcio.chainofresponsability.validator;

import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;

// Regra 4: verifica se a senha possui um caractere especial permitido.
public class SenhaEspecialValidator extends LoginSenhaValidator {
    private static final String CARACTERES_ESPECIAIS = "@#$%&*";

    @Override
    protected void verificar(LoginRequest request, ValidationResult resultado) {
        boolean possuiEspecial = request.getSenha()
                .chars()
                .anyMatch(caractere -> CARACTERES_ESPECIAIS.indexOf(caractere) >= 0);

        if (!possuiEspecial) {
            resultado.adicionarErro("A senha precisa ter pelo menos um caractere especial (@, #, $, %, & ou *).");
        }
    }
}
