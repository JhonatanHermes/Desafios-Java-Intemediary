import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RegistroTransacoesComStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lê o saldo inicial
        double saldo = scanner.nextDouble();
        // Lê o número de transações
        int quantidadeTransacoes = scanner.nextInt();

        // Lista para armazenar as transações
        List<Transacao> transacoes = new ArrayList<>();

        // Processa cada transação
        for (int i = 1; i <= quantidadeTransacoes; i++) {
            char tipoTransacao = scanner.next().charAt(0); // Lê o tipo da transação
            double valorTransacao = scanner.nextDouble(); // Lê o valor da transação

            // Cria a transação e adiciona à lista
            Transacao transacao = new Transacao(tipoTransacao, valorTransacao);
            transacoes.add(transacao);

            // Atualiza o saldo com base no tipo da transação
            if (transacao.getTipo() == 'd' || transacao.getTipo() == 'D') {
                saldo += valorTransacao;
            } else if (transacao.getTipo() == 's' || transacao.getTipo() == 'S') {
                saldo -= valorTransacao;
            }
        }

        // Exibe o saldo final
        System.out.println("\nSaldo : " + saldo);
        
        // Exibe a lista de transações utilizando Stream
        System.out.println("\nTransacoes:");
        transacoes.stream()
                .map(transacao -> transacao.getTipo() + " de " + transacao.getValor())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        // Fechar o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}

class Transacao {
    private char tipo;
    private double valor;

    // Construtor da classe
    public Transacao(char tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    // Métodos de acesso (getters)
    public char getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}
