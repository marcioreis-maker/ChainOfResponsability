package com.marcio.chainofresponsability.validator;

import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;

// Regra 6: bloqueia tres numeros consecutivos em ordem crescente, como 123.
public class SenhaSequenciaNumericaValidator extends LoginSenhaValidator {
    @Override
    protected void verificar(LoginRequest request, ValidationResult resultado) {
        String senha = request.getSenha();

        for (int i = 0; i <= senha.length() - 3; i++) {
            char primeiro = senha.charAt(i);
            char segundo = senha.charAt(i + 1);
            char terceiro = senha.charAt(i + 2);

            if (Character.isDigit(primeiro)
                    && segundo == primeiro + 1
                    && terceiro == segundo + 1) {
                resultado.adicionarErro("A senha nao pode ter 3 numeros consecutivos em sequencia.");
                return;
            }
        }
    }
}
