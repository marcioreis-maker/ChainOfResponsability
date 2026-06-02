package com.marcio.chainofresponsability;

import com.marcio.chainofresponsability.chain.LoginSenhaChain;
import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;
import com.marcio.chainofresponsability.validator.LoginSenhaValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ChainOfResponsabilityApplicationTests {
    private final LoginSenhaValidator chain = LoginSenhaChain.criar();

    @Test
    void deveAceitarLoginESenhaValidos() {
        ValidationResult resultado = chain.validar(new LoginRequest("marcio", "Abc9@def"));

        assertTrue(resultado.estaValido());
    }

    @Test
    void deveRejeitarLoginNaoCadastrado() {
        ValidationResult resultado = chain.validar(new LoginRequest("visitante", "Abc9@def"));

        assertFalse(resultado.estaValido());
        assertTrue(resultado.getErros().contains("Login nao cadastrado."));
    }

    @Test
    void deveRejeitarSenhaComSequenciaNumerica() {
        ValidationResult resultado = chain.validar(new LoginRequest("marcio", "Ab123&xy"));

        assertFalse(resultado.estaValido());
        assertTrue(resultado.getErros().contains("A senha nao pode ter 3 numeros consecutivos em sequencia."));
    }

    @Test
    void deveAcumularErrosDaSenha() {
        ValidationResult resultado = chain.validar(new LoginRequest("aluno", "abc"));

        assertFalse(resultado.estaValido());
        assertTrue(resultado.getErros().contains("A senha precisa ter pelo menos uma letra maiuscula."));
        assertTrue(resultado.getErros().contains("A senha precisa ter pelo menos um caractere especial (@, #, $, %, & ou *)."));
        assertTrue(resultado.getErros().contains("A senha precisa ter pelo menos um numero."));
        assertTrue(resultado.getErros().contains("A senha precisa ter pelo menos 8 caracteres."));
    }
}
