package menus;

import java.util.Scanner;

import classes.IPhone;

public class MenuNavegador {
    
    public static void menuNavegador(IPhone iphone, Scanner scanner) {
        int opc = 0;

        FuncaoTerminal.limparTerminal();
        
        do {
            System.out.println("[1] Exibir Página");
            System.out.println("[2] Adicionar nova Aba");
            System.out.println("[3] Atualizar Página");
            System.out.println("[4] Voltar");

            opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1:
                    System.out.print("Insira a URL da Página: ");
                    String url = scanner.nextLine();

                    iphone.exibirPagina(url);
                    break;
                case 2:
                    iphone.adicionarNovaAba();
                    break;
                case 3:
                    iphone.atualizarPagina();
                    break;
                case 4:
                    System.out.println("Voltando...");
                default:
                    System.out.println("Opção Inválida...");
                    break;
            }

        }while(opc != 4);
    }
}
