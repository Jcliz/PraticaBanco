//ARQUIVO DO BANCO

import java.util.Scanner;

public class Banco {
    private double saldoAtual;

    public static double sacarDinheiro(double valorAtual, double dinheiroSacado) {
        return valorAtual - dinheiroSacado;
    }

    public static double depositarDinheiro(double valorAtual) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual o valor que você deseja depositar?: ");
        double valor = leitor.nextDouble();
        System.out.println(" ");
        return valorAtual + valor;
    }

    public Banco (double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public void setSaldo(double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }
    public double getSaldo() {
        return saldoAtual;
    }
}
