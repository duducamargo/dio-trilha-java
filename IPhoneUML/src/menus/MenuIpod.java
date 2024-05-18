package menus;

import java.util.Scanner;

import classes.IPhone;

public class MenuIpod {
    public static void menuIpod(IPhone iphone, Scanner scanner) {
        int opc = 0;
        String musica;

        FuncaoTerminal.limparTerminal();
        
        do {
            System.out.println("[1] Tocar Música");
            System.out.println("[2] Pausar Música");
            System.out.println("[3] Selecionar Música");
            System.out.println("[4] Voltar");

            opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1:
                    System.out.print("Insira a Música que deseja Tocar: ");
                    musica = scanner.nextLine();

                    iphone.tocar(musica);
                    break;
                case 2:
                    iphone.pausar();
                    break;
                case 3:
                    System.out.print("Insira a Música que deseja Selecionar: ");
                    musica = scanner.nextLine();

                    iphone.selecionarMusica(musica);
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
