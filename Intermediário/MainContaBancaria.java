import java.util.Scanner;

public class MainContaBancaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar uma nova conta bancária com o saldo inicial informado
        double saldoInicial = scanner.nextDouble();
        ContaBancaria conta = new ContaBancaria(saldoInicial);

        // Lê o valor do depósito e aciona o método "depositar"
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);

        // Lê o valor do saque e aciona o método "sacar"
        double valorSaque = scanner.nextDouble();
        conta.sacar(valorSaque);

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}

class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        // Incrementa o saldo com o valor do depósito
        saldo += valor;
        System.out.println("Deposito feito.");
        imprimirSaldo();
    }

    public void sacar(double valor) {
        // Verifica se o saldo é suficiente para o saque
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque feito.");
        } else {
            System.out.println("Saldo insuficiente. Saque não realizado.");
        }
        imprimirSaldo();
    }
    
    private void imprimirSaldo() {
        System.out.printf("Saldo atual: %.1f\n", this.saldo);
    }
}
