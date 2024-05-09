import java.util.Scanner;

/**
 * Classe principal que contém métodos para executar diferentes tipos de cronômetros.
 */

public class Main {

    static Thread T = new Thread();

    /**
     * Método para executar um cronômetro manualmente.
     * 
     * @param terminal Scanner para entrada do usuário.
     */

    public static void cronometroManual(Scanner terminal) {
        int tempo;
        System.out.print("Insira o tempo do cronômetro em segundos: ");
        tempo = Integer.parseInt(terminal.nextLine());

        try {
            for (int c = tempo; c >= 0; c--) {
                Thread.sleep(1000);                                  
                   System.out.println(c);
              
            }
            System.out.println("Sua Contagem terminou!");
        }
        catch (InterruptedException e) {
            System.out.println("Ocorreu um erro ao pausar a Thread: " + e.getMessage());
        }
    }

    /**
     * Método para executar um cronômetro por subtração.
     * 
     * @param terminal Scanner para entrada do usuário.
     * @throws InterruptedException Exceção lançada se houver um problema ao pausar a thread.
     * @throws TemposInvalidosException Exceção lançada se o segundo valor for maior que o segundo.
     */

    public static void cronometroSub(Scanner terminal) {
        int tempo1, tempo2;

        System.out.print("Insira o primeiro valor em segundos: ");
        tempo1 = Integer.parseInt(terminal.nextLine());

        System.out.print("Insira o segundo valor em segundos: ");
        tempo2 = Integer.parseInt(terminal.nextLine());

        try {
            if (tempo2 > tempo1) {
                throw new TemposInvalidosException("O segundo tempo deve ser menor do que o primeiro tempo.");
            }
            int tempoFinal = tempo1 - tempo2;
            for (int c = tempoFinal; c >= 0; c--) {
                Thread.sleep(1000);
                System.out.println(c);
            }
            System.out.println("Sua Contagem terminou!");
        } catch (TemposInvalidosException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Ocorreu um erro ao pausar a Thread: " + e.getMessage());
        }
    } 
    
    /**
     * Método para executar um cronômetro por adição.
     * 
     * @param terminal Scanner para entrada do usuário.
     * @throws InterruptedException Exceção lançada se houver um problema ao pausar a thread.
     */

    public static void cronometroAdd(Scanner terminal) throws InterruptedException {
        int tempo1, tempo2, tempoFinal;

        System.out.print("Insira o primeiro valor em segundos: ");
        tempo1 = Integer.parseInt(terminal.nextLine());

        System.out.print("Insira o segundo valor em segundos: ");
        tempo2 = Integer.parseInt(terminal.nextLine());

        tempoFinal = tempo1 + tempo2;

        for (int c = tempoFinal; c >= 0; c--) {
            Thread.sleep(1000);
            System.out.println(c);
        }
        System.out.println("Sua Contagem terminou!");
    }

    /**
     * Método principal para execução do programa.
     * 
     * @param args Argumentos de linha de comando (não utilizado neste programa).
     * @throws Exception Exceção genérica lançada se ocorrer algum problema não tratado.
     */

    public static void main(String[] args) throws Exception {
        Scanner terminal = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Insira a opção desejada para o cronômetro:");
            System.out.println("[1] Inserir o tempo manualmente");
            System.out.println("[2] Inserir o tempo por subtração (1° - 2°)");
            System.out.println("[3] Inserir o tempo por adição (1° + 2°)");
            System.out.println("[4] Sair");
            opc = Integer.parseInt(terminal.nextLine());
            
            switch (opc) {
                case 1:
                cronometroManual(terminal);
                break;
                case 2:
                cronometroSub(terminal);
                break;
                case 3:
                cronometroAdd(terminal);
                break;
                case 4:
                System.out.println("Saindo...");
                break;
                default:
                System.out.println("Opção Inválida!");
                break;
            }
        }while (opc != 4);

        terminal.close();
    }
}

/**
 * Exceção personalizada para representar tempos inválidos.
 */

class TemposInvalidosException extends Exception {

    /**
     * Construtor que aceita uma mensagem de erro.
     * 
     * @param message A mensagem de erro.
     */

    public TemposInvalidosException(String message) {
        super(message);
    }
}
