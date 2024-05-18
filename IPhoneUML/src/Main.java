import java.util.Scanner;

import classes.IPhone;
import menus.*;

public class Main {
    public static void main(String[] args) throws Exception {
        IPhone iphone = new IPhone();
        int opc = 0;
        Scanner scanner = new Scanner(System.in);

        FuncaoTerminal.limparTerminal();

        do {
            System.out.println("[1] Ipod (Tocador de Músicas)");
            System.out.println("[2] Mail (E-mail)");
            System.out.println("[3] Safari (Navegador)");
            System.out.println("[4] Phone (Telefone)");
            System.out.println("[5] Desligar (Sair)");

            opc = Integer.parseInt(scanner.nextLine());

            FuncaoTerminal.limparTerminal();

            switch (opc) {
                case 1:
                    MenuIpod.menuIpod(iphone, scanner);
                    break;
                case 2:
                    MenuEmail.menuEmail(iphone, scanner);
                    break;
                case 3:
                    MenuNavegador.menuNavegador(iphone, scanner);
                    break;
                case 4:
                    MenuPhone.menuPhone(iphone, scanner);
                    break;
                case 5:
                    System.out.println("Desligando...");
                    break;
                default:
                    System.out.println("Aplicativo Inválido...");
                    break;
            }

        }while(opc != 5);

        scanner.close();
    }
}
