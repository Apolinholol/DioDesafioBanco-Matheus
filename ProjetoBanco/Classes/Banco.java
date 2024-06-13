package ProjetoBanco.Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


    public class Banco {
    
    private List<Cliente> clientes;

    public Banco() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Optional<Conta> buscarContaPorAgenciaNumero(int agencia, String numero) {
        
        Optional<Conta> contaEncontrada = clientes.stream()//Percorre todas as listas de clientes
                                                        .flatMap(cliente -> cliente.getContas().stream())//Obtém a sequência de todos as contas de todos os clientes
                                                        .filter(conta -> conta.getAgencia() == agencia && conta.getNumero().equals(numero)) // Filtra as contas pela agência e número informados
                                                        .findFirst(); // Retorna o primeiro resultado encontrado

        if (!contaEncontrada.isPresent()) {
            System.out.printf("Cliente da agência '%d' com o número de conta '%s' não encontrado.\n", agencia, numero);
        } else {
            System.out.println("Cliente encontrado." + " Agência: " + agencia + " || " + "Número de conta: " + numero);
        }

            return contaEncontrada;
    }

    

    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criando alguns clientes
        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");

        // Adicionando contas aos clientes
        Conta conta1Cliente1 = new ContaCorrente(1, "123", 10);
        Conta conta2Cliente1 = new ContaPoupanca(2, "456", 1);
        Conta conta1Cliente2 = new ContaPoupanca(5, "789",20);

        cliente1.adicionarConta(conta1Cliente1);
        cliente1.adicionarConta(conta2Cliente1);
        cliente2.adicionarConta(conta1Cliente2);

        // Adicionando clientes ao banco
        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);

        // Exemplo de operações no banco
        System.out.println("Clientes do banco:");
        banco.getClientes().forEach(cliente -> System.out.println(cliente.getNome()));

        System.out.println("\nBuscando conta por agência e número:");
         banco.buscarContaPorAgenciaNumero(2, "456");
         banco.buscarContaPorAgenciaNumero(1, "456");


         conta1Cliente1.depositar(101);
         conta2Cliente1.depositarCP(10);
         conta1Cliente2.depositarCP(100);

         conta1Cliente2.imprimirExtrato();
         conta1Cliente1.imprimirExtrato();
         conta2Cliente1.imprimirExtrato();
        System.out.println("|----------------------------------|");
         conta1Cliente1.sacarCC(50);
        System.out.println("|----------------------------------|");
         conta2Cliente1.sacarCP(50);
      

        

      
    }
}