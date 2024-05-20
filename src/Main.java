import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Conexao conn = new Conexao();
        boolean logado = false;
        boolean on = true;

        while (on) {
            System.out.println("O que gostaria de fazer? \n1 - login \n2 - atualizar nome \n3 - depositar \n4 - sair ");

            String escolha = scan.nextLine();

            switch (escolha.toLowerCase()) {
                case "login", "1": {
                    conn.insertUsers();
                    break;
                }

                case "atualizar nome", "2": {
                    conn.updateName();
                    break;
                }

                case "depositar", "3":{
                    conn.depositar();
                    break;
                }

                case "sair", "4": {
                    on = false;
                    break;
                }
            }
        }
    }
}