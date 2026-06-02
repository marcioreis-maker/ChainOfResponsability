package com.marcio.chainofresponsability;

import com.marcio.chainofresponsability.chain.LoginSenhaChain;
import com.marcio.chainofresponsability.model.LoginRequest;
import com.marcio.chainofresponsability.model.ValidationResult;
import com.marcio.chainofresponsability.validator.LoginSenhaValidator;

import java.util.Scanner;

public class ChainOfResponsabilityApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada dos dados que serao avaliados pela cadeia.
        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // O objeto request leva login e senha por todos os validadores.
        LoginRequest request = new LoginRequest(login, senha);
        LoginSenhaValidator chain = LoginSenhaChain.criar();
        ValidationResult resultado = chain.validar(request);

        // No final, mostramos se passou por todas as regras ou quais falharam.
        if (resultado.estaValido()) {
            System.out.println("Login e senha corretos.");
        } else {
            System.out.println("Login ou senha invalidos:");
            for (String erro : resultado.getErros()) {
                System.out.println("- " + erro);
            }
        }
    }
}
