public class ContasBanco {
    private String nomeCliente;
    private int numeroConta;
    private String agencia;
    private double saldo;

    ContasBanco(String nomeCliente, int numeroConta, String agencia, double saldo) {
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return this.numeroConta;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public String getNomeCliente() {
        return this.nomeCliente;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double novoSaldo) {
        this.saldo = novoSaldo;
    }

    public void depositar(double valorDepositado) {
        double novoSaldo = getSaldo() + valorDepositado;
        setSaldo(novoSaldo);
    }

    public void sacar(double valorSacado) {
        double novoSaldo = getSaldo() - valorSacado;
        if (novoSaldo < 0) {
            setSaldo(0.0);
        }
        setSaldo(novoSaldo);
    }

}