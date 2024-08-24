//ARQUIVO DO CLIENTE

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String email;
    private String senha;
    private int idade;

    public static ArrayList<Object> CadastrarCliente(String nome, String email, String senha, int idade) {
        ArrayList<Object> lista = new ArrayList<>();
        lista.add(nome);
        lista.add(email);
        lista.add(senha);
        lista.add(idade);
        return lista;
    }

    public static String capitalize(String nome) {
        if (nome == null || nome.isEmpty()) {
            return nome;
        }

        String[] palavras = nome.split(" ");
        StringBuilder strBuilder = new StringBuilder();

        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                strBuilder.append(palavra.substring(0, 1).toUpperCase())
                        .append(palavra.substring(1).toLowerCase());
            }
            strBuilder.append(" ");
        }

        return strBuilder.toString().trim();
    }

    public Cliente(String nome, String email, String senha, int idade) {
        this.nome = capitalize(nome);
        this.idade = idade;
        this.email = email.toLowerCase();
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = capitalize(nome);
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return capitalize(nome);
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public int getIdade() {
        return idade;
    }
}

