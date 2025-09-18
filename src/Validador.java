public class Validador {

    public static boolean validarCPF(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) return false;

        String cpflimpo = sanitizarCPF(cpf);

        if (checarFormato(cpflimpo)) return false;

        if (checarDigitos(cpflimpo)) {
            return true;
        } else {
            return false;
        }
    }

    //Verifica se o CPF contém 11 dígitos apos a sanitizacao
    private static boolean checarFormato(String cpflimpo) {
        if (!cpflimpo.matches("\\d{11}")) return true;

        return cpflimpo.chars().distinct().count() == 1;
    }

    //Este método retira os caracteres não numéricos do CPF
    private static String sanitizarCPF(String cpf) {
        String cpflimpo = cpf.trim().replaceAll("[.-]", "");
        return cpflimpo;
    }


    //Verifica se os digitos verificadores batem com o 10º e 11º digito do CPF
    private static boolean checarDigitos(String cpf) {
        int[] digitosDoCpf = cpf.chars().map(c -> c - '0').toArray();


        int sanitizado1 = 0;
        for (int i = 0; i < 9; i++) sanitizado1 += digitosDoCpf[i] * (10 - i);

        int r1 = sanitizado1 % 11;
        int digitoVerificador1 = (r1 < 2) ? 0 : 11 - r1;

        if (digitosDoCpf[9] != digitoVerificador1) return false;

        int sanitizado2 = 0;
        for (int i = 0; i < 10; i++) sanitizado2 += digitosDoCpf[i] * (11 - i);
        int r2 = sanitizado2 % 11;
        int dv2 = (r2 < 2) ? 0 : 11 - r2;
        return digitosDoCpf[10] == dv2;
    }
}

