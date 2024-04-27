import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Esta classe representa um terminal de controle de contas bancárias.
 */
public class ContaTerminal {

    /**
     * Imprime o menu principal do terminal.
     */
    public static void imprimirMenu() {
        System.out.println("[1] Criar Conta");
        System.out.println("[2] Entrar na conta");
        System.out.println("[3] Sair");
    }

    /**
     * Imprime o menu de operações disponíveis para uma conta.
     */
    public static void menuConta() {
        System.out.println("[1] Listar conta");
        System.out.println("[2] Realizar depósito");
        System.out.println("[3] Realizar saque");
        System.out.println("[4] Excluir conta");
        System.out.println("[5] Sair");
    }

    /**
     * Cria uma nova conta bancária e a adiciona à lista de contas.
     *
     * @param contas   Lista de contas bancárias
     * @param scanner  Scanner para entrada de dados do usuário
     */

    public static void criarConta(List<ContasBanco> contas, Scanner scanner) {
        String nomeCliente, agencia;
        int numeroConta;
        double saldo = 0;

        System.out.print("Insira o seu nome: ");
        nomeCliente = scanner.nextLine();

        System.out.print("Insira o numero de sua agencia: ");
        agencia = scanner.nextLine();

        System.out.print("Insira o numero de sua conta: ");
        numeroConta = Integer.parseInt(scanner.nextLine());

        ContasBanco conta = new ContasBanco(nomeCliente, numeroConta, agencia, saldo);

        contas.add(conta);

        System.out.println("Conta criada com sucesso!");
    }

    /**
     * Acessa uma conta se tal conta ja existir na lista.
     *
     * @param contas   Lista de contas bancárias
     * @param scanner  Scanner para entrada de dados do usuário
     */

    public static void entrarConta(List<ContasBanco> contas, Scanner scanner) {
        int numeroConta, opc;
        boolean encontrado = false;

        System.out.print("Insira o numero de sua conta: ");
        numeroConta = Integer.parseInt(scanner.nextLine());

        for(int i = 0; i < contas.size(); i++) {
            if(contas.get(i).getNumeroConta() == numeroConta) {
                encontrado = true;
                do {
                    menuConta();
                    opc = Integer.parseInt(scanner.nextLine());

                    switch (opc) {
                        case 1:
                            System.out.println("Nome: " + contas.get(i).getNomeCliente());
                            System.out.println("Número da conta: " + contas.get(i).getNumeroConta());
                            System.out.println("Agência: " + contas.get(i).getAgencia());
                            System.out.println("Saldo: R$" + contas.get(i).getSaldo());
                            break;
                        case 2:
                            System.out.print("Insira o valor que você deseja depositar em sua conta: ");
                            double valorDepositado = Double.parseDouble(scanner.nextLine());
                            contas.get(i).depositar(valorDepositado);
                            System.out.println("Depósito realizado, seu saldo é: R$" + contas.get(i).getSaldo());
                            break;
                        case 3:
                            System.out.print("Insira o valor que você deseja sacar de sua conta: ");
                            double valorSacado = Double.parseDouble(scanner.nextLine());
                            contas.get(i).sacar(valorSacado);
                            System.out.println(("Saque realizado com sucesso, seu saldo é: R$" + contas.get(i).getSaldo()));
                            break;
                        case 4:
                            System.out.println("Excluindo conta...");
                            contas.remove(i);
                            return;
                        case 5:
                            System.out.println("Saindo...");
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                }while(opc != 5);
            }
        }
        if(!encontrado) {
            System.out.println("A conta informada não foi encontrada!");
        }
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        List <ContasBanco> contas = new ArrayList<ContasBanco>();
        int opc;

        do{
            imprimirMenu();
            opc = Integer.parseInt(scanner.nextLine());

            switch (opc) {
                case 1:
                    criarConta(contas, scanner);
                    break;
                case 2:
                    entrarConta(contas, scanner);
                    break;
                case 3:
                    System.out.println("Até Mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(opc != 3);
        
        
        scanner.close();
    }
}
