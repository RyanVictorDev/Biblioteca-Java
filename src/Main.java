import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean logado = false;
        boolean on = true;

        while (logado == false){
            System.out.println("Digite seu nome: ");
            String nome = scan.nextLine();

            System.out.println("Digite seu email: ");
            String email = scan.nextLine();

            System.out.println("Crie uma senha: ");
            String senha = scan.nextLine();

            System.out.println("Confirme sua senha: ");
            String senhaConfirm = scan.nextLine();

            while (!Objects.equals(senha, senhaConfirm)){
                System.out.println("Algo deu errado. Tente novamente");

                System.out.println("Crie uma senha: ");
                senha = scan.nextLine();

                System.out.println("Confirme sua senha: ");
                senhaConfirm = scan.nextLine();
            }

            if (Objects.equals(senha, senhaConfirm)){
                User NovoUser = new User(nome, senha, email);
                logado = true;
                System.out.println("Sucesso!");
                System.out.println("Seu saldo atual é de R$ " + NovoUser.getSaldo());
                System.out.println("Adicione um pix!");
                double valor = scan.nextDouble();
                NovoUser.pix(valor);
                System.out.println("Seu saldo atual é de R$ " + NovoUser.getSaldo());

                while (on){
                    System.out.println("O que você deseja fazer?");
                    System.out.println("- 'A' para adicionar livro\n - 'Sair' para sair do programa");
                    String escolha = scan.nextLine();
                    escolha = escolha.toLowerCase();
                    switch (escolha){
                        case "a": {
                            System.out.println("Deseja adicionar um novo livro? precisamos de algumas informações...");
                            System.out.println("Adicione o titulo: ");
                            String titulo = scan.nextLine();
                            System.out.println("Adicione a classificação: ");
                            String classificacao = scan.nextLine();
                            System.out.println("Adicione o autor: ");
                            String autor = scan.nextLine();
                            System.out.println("Adicione o preço: ");
                            double preco = scan.nextDouble();

                            Livro novoLivro = new Livro(titulo, classificacao, autor, preco);

                            System.out.println(novoLivro.getTitulo());
                            System.out.println(novoLivro.getAutor());
                            System.out.println(novoLivro.getPreco());
                            System.out.println(novoLivro.getClassificacao());

                            break;
                        }
                        case "sair":{
                            on = false;
                            break;
                        }
                    }
                }
            }
        }
    }
}