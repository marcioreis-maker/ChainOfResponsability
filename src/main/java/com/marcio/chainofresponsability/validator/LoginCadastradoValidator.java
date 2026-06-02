package com.marcio.chainofresponsability.validator;

import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;

import java.util.Set;

// Regra 1: verifica se o login informado esta cadastrado.
public class LoginCadastradoValidator extends LoginSenhaValidator {
    private final Set<String> loginsCadastrados;

    public LoginCadastradoValidator(Set<String> loginsCadastrados) {
        this.loginsCadastrados = loginsCadastrados;
    }

    @Override
    protected void verificar(LoginRequest request, ValidationResult resultado) {
        if (!loginsCadastrados.contains(request.getLogin())) {
            resultado.adicionarErro("Login nao cadastrado.");
        }
    }
}
