//ARQUIVO MAIN

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("----------- BEM-VINDO(A) AO BANCO! -----------");
        System.out.println("Antes que as operações sejam realizadas vamos fazer o seu cadastro.");

        System.out.print("Digite o seu nome completo (Espaços são necessários): ");
        String nome = leitor.nextLine();
        int posicaoEspaco = nome.indexOf(" ");
        String primeiroNome = nome.substring(0, posicaoEspaco);

        System.out.print("Agora, seu e-mail e senha para cadastro: ");
        String email = leitor.nextLine();
        String senha = leitor.nextLine();

        System.out.print("Perfeito! Por fim, qual é a sua idade?: ");
        int idade = leitor.nextInt();

        Cliente cliente = new Cliente(nome, email, senha, idade);
        cliente.setNome(nome);
        String nomeCliente = cliente.getNome();
        ArrayList<Object> cadastro = Cliente.CadastrarCliente(nomeCliente, email, senha, idade);
        Banco banco = new Banco(0);

        String result = Cliente.capitalize(primeiroNome);
        System.out.println("Ótimo! Se divirta com as suas operações " + result + "!");
        System.out.println("Cadastro atual: " + cadastro);
        System.out.println(" ");

        double saldo = 0;
        while (true) {
            System.out.println("""
                Qual opção você deseja selecionar?:
                [1] Depósito
                [2] Saque
                [3] Imprimir saldo
                [4] Alterar cadastro
                [5] Sair
                """);
            int escolha = leitor.nextInt();

            if (escolha == 1) {
                saldo = Banco.depositarDinheiro(saldo);
                banco.setSaldo(saldo);
            }
            else if (escolha == 2) {
                System.out.print("Qual é o valor que você deseja sacar?: ");
                double saque = leitor.nextDouble();
                System.out.println(" ");
                if (saque > saldo) {
                    System.out.println("Saldo insuficiente para o saque.");
                    System.out.println(" ");
                } else {
                    saldo = Banco.sacarDinheiro(saldo, saque);
                    banco.setSaldo(saldo);
                }
            }
            else if (escolha == 3) {
                System.out.println("Saldo atual: " + banco.getSaldo());
                System.out.println(" ");
            }
            else if (escolha == 4) {
                System.out.println("Digite o novo nome: ");
                String novoNome = leitor.nextLine();
                cliente.setNome(novoNome);
                System.out.println("Digite o novo e-mail: ");
                String novoEmail = leitor.nextLine();
                cliente.setEmail(novoEmail);
                System.out.println("Digite a nova senha: ");
                String novaSenha = leitor.nextLine();
                cliente.setSenha(novaSenha);
                System.out.println("Digite a nova idade: ");
                int novaIdade = leitor.nextInt();
                cliente.setIdade(novaIdade);

                Cliente.CadastrarCliente(nomeCliente, novoEmail, novaSenha, novaIdade);

                System.out.println(" ");
                System.out.println("Cadatros realizados:");
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("E-mail: " + cliente.getEmail());
                System.out.println("Senha: " + cliente.getSenha());
                System.out.println("Idade: " + cliente.getIdade());
                System.out.println(" ");
            }
            else if (escolha == 5) {
                System.out.println("Obrigado pelo acesso! :D");
                break;
            }
            else {
                System.out.println("Opção inválida, tente novamente!");
            }
        }
    }
}