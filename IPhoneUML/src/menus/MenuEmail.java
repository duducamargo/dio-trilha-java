package menus;

import java.util.Scanner;

import classes.IPhone;

public class MenuEmail {

    public static void menuEmail(IPhone iphone, Scanner scanner) {
        int opc;

        FuncaoTerminal.limparTerminal();
        
        do {

            System.out.println("[1] Mandar Mail");
            System.out.println("[2] Ler Mails");
            System.out.println("[3] Voltar");

            opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1:
                    String destinatario;
                    System.out.print("Insira o Destinatário: ");
                    destinatario = scanner.nextLine();

                    iphone.mandarEmail(destinatario);
                    break;
                case 2:
                    iphone.lerEmail();
                    break;
                case 3:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção Inválida...");
                    break;
            }

        }while(opc != 3);
    }
}
