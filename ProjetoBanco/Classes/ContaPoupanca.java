package ProjetoBanco.Classes;

    public class ContaPoupanca extends Conta {
        public ContaPoupanca(int agencia,String numero,int dia_mes) {
            super(agencia,numero,dia_mes);
        }
        
        @Override
        public void imprimirExtrato(){
            System.out.println("|--------Extrato Conta Poupança--------|");
            System.out.printf("Agência: %d\n", agencia);
            System.out.printf("Numero da conta: %s\n", numero);
            rendimentos();
            System.out.printf("Dia do Mês: %d\n",dia_mes);
            
        }
        //Rendimentos baseado nos dias de deposito (certamente não a melhor lógica, pois considera como se fosse 
       // do dia 1 até o dia do mês escolhido). O problema que toda vez que imprimir também vai adicionar o valor
       // erroneamente.

       public void rendimentos(){
        double saldoAtual = getSaldoCP();
        double rendimento = saldoAtual * 0.03;

        if(dia_mes >= 15 && dia_mes <=20){
         rendimento = saldoAtual * 0.04;
        }else if(dia_mes >= 21){
         rendimento = saldoAtual * 0.06;
        }
        double novoSaldo = saldoAtual + rendimento;
        
        // Atualizando o saldo com o novo valor
        depositarCP(rendimento);

        System.out.printf("Saldo sem rendimentos: %.2f\n", saldoAtual);
        System.out.printf("Rendimento do mês: %.2f\n", rendimento);
        System.out.printf("Saldo com rendimentos: %.2f\n", novoSaldo);
        }

    
       
    }
    

