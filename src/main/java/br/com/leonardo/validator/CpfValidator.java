package br.com.leonardo.validator;

public class CpfValidator {

    public static boolean checkCpf(String cpf) {

        if (cpf == null) {
            System.out.println("cpf nulo");
        } else if (cpf.length() != 11) {
            System.out.println("deve conter 11 digitos");
        }

        for (int i = 0; i < cpf.length(); i++) {
            if (Character.isDigit(cpf.charAt(i))) {
                continue;
            } else {
                throw new IllegalArgumentException("caractere invalido");
            }
        }

        int peso = 10;
        int total = 0;
        for (int i = 0; i < cpf.length() - 2; i++) {
            int digito = cpf.charAt(i) - '0';
            total += digito * peso;
            peso--;
        }
        int digito1;
        if (total % 11 < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - (total % 11);
        }

        peso = 11;
        total = 0;
        for (int i = 0; i < cpf.length() - 2; i++) {
            int digito = cpf.charAt(i) - '0';
            total += digito * peso;
            peso--;
        }
        total += digito1 * 2;

        int digito2;
        if (total % 11 < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - (total % 11);
        }

        if (cpf.charAt(cpf.length() - 2) - '0' == digito1 && cpf.charAt(cpf.length() - 1) - '0' == digito2) {
            return true;
        } else {
            return false;
        }
    }
}
