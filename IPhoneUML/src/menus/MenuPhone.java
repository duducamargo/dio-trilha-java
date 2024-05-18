package menus;

import java.util.Scanner;

import classes.IPhone;

public class MenuPhone {
    
    public static void menuPhone(IPhone iphone, Scanner scanner) {
        int opc;

        FuncaoTerminal.limparTerminal();

        do {
            System.out.println("[1] Ligar");
            System.out.println("[2] Atender");
            System.out.println("[3] Iniciar Correio de Voz");
            System.out.println("[4] Voltar");

            opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1:
                    String numero;

                    System.out.print("Insira o Número que deseja Ligar: ");
                    numero = scanner.nextLine();

                    iphone.ligar(numero);
                    break;
                case 2:
                    iphone.atender();
                    break;
                case 3:
                    iphone.iniciarCorreioVoz();
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
            
                default:
                    System.out.println("Opção Inválida...");
                    break;
            }

        }while(opc != 4);


    }
}
