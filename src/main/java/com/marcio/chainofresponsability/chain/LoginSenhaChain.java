package com.marcio.chainofresponsability.chain;

import com.marcio.chainofresponsability.validator.LoginCadastradoValidator;
import com.marcio.chainofresponsability.validator.LoginSenhaValidator;
import com.marcio.chainofresponsability.validator.SenhaEspecialValidator;
import com.marcio.chainofresponsability.validator.SenhaMaiusculaValidator;
import com.marcio.chainofresponsability.validator.SenhaMinusculaValidator;
import com.marcio.chainofresponsability.validator.SenhaNumeroValidator;
import com.marcio.chainofresponsability.validator.SenhaSequenciaNumericaValidator;
import com.marcio.chainofresponsability.validator.SenhaTamanhoMaximoValidator;
import com.marcio.chainofresponsability.validator.SenhaTamanhoMinimoValidator;

import java.util.Set;

public class LoginSenhaChain {
    // Simula os logins que estariam cadastrados no sistema.
    private static final Set<String> LOGINS_CADASTRADOS = Set.of("marcio", "fernando", "aluno");

    private LoginSenhaChain() {
    }

    public static LoginSenhaValidator criar() {
        // A ordem abaixo e a ordem em que as regras do enunciado serao testadas.
        LoginSenhaValidator chain = new LoginCadastradoValidator(LOGINS_CADASTRADOS);
        chain.setNext(new SenhaMaiusculaValidator());
        chain.setNext(new SenhaMinusculaValidator());
        chain.setNext(new SenhaEspecialValidator());
        chain.setNext(new SenhaNumeroValidator());
        chain.setNext(new SenhaSequenciaNumericaValidator());
        chain.setNext(new SenhaTamanhoMinimoValidator());
        chain.setNext(new SenhaTamanhoMaximoValidator());
        return chain;
    }
}
