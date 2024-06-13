package ProjetoBanco.Classes;

public abstract class Conta implements IConta {

    protected int agencia;
    protected String numero;
    protected double saldoCC;
    protected double saldoCP;
    protected int contCP;
    protected int contComum;
    protected int dia_mes;

    public Conta(int agencia,String numero,int dia_mes) {
        this.agencia= agencia;
        this.numero = numero;
        this.dia_mes= dia_mes;
        this.saldoCC = 0.0;
        this.saldoCP= 0.0;
    }

    
    public void depositarCP(double valor) {
        if (valor > 0) {
            saldoCP += valor;
        }
    }

    @Override
    public void depositar(double valor) {
        double taxa_deposito;
        if(valor <= 50 && valor > 0){
            taxa_deposito = valor - 1.5;  
            saldoCC+= taxa_deposito; 
        }else{
            taxa_deposito = valor * 0.05;
            saldoCC+= valor - taxa_deposito; 
        }
    }

    @Override
    public void sacarCC(double valor) {
       double taxa_saque= valor * 0.02;
       if(taxa_saque + valor < saldoCC) {
        if (valor > 0 && valor <= 100) {
            saldoCC -= valor;
            System.out.println("Dinheiro sacado com sucesso. Novo saldo: " + saldoCC);
        }else{
            saldoCC= saldoCC - valor - taxa_saque;
           System.out.println("Dinheiro sacado com sucesso. Novo saldo: " + saldoCC);
        }
     }else{
            System.out.println("O dinheiro não pode ser sacado. Saldo insuficiente.");
     }
}

    public void sacarCP(double valor) {
        double taxa_saque= valor * 0.04;
        if(taxa_saque + valor < saldoCP) {
            if (valor > 0 ) 
            saldoCP -= valor - taxa_saque;
            System.out.println("Dinheiro sacado com sucesso. Novo saldo: " + saldoCC);
        }else{
            System.out.println("O dinheiro não pode ser sacado. Saldo insuficiente.");
        }
    }
    

    @Override
    public double getSaldoCC() {
        return saldoCC;
    }
    public double getSaldoCP() {
        return saldoCP;
    }

    public String getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }


    protected abstract void imprimirExtrato();
    
    
}

