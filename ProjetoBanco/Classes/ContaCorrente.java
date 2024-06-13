package ProjetoBanco.Classes;

public class ContaCorrente extends Conta {
    public ContaCorrente(int agencia,String numero,int dia_mes) {
        super(agencia,numero,dia_mes);
    }

    @Override
    public void imprimirExtrato(){
        System.out.println("|--------Extrato Conta Corrente--------|");
        System.out.printf("Agência: %d\n", agencia);
        System.out.printf("Numero da conta: %s\n", numero);
        System.out.printf("Saldo da conta: %.2f\n", saldoCC);
        System.out.printf("Dia do Mês: %d\n",dia_mes);
    }



}
