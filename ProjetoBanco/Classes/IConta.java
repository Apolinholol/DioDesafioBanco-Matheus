package ProjetoBanco.Classes;

public interface IConta {
    void depositar(double valor);
    void sacarCC(double valor);
    double getSaldoCC();
}
