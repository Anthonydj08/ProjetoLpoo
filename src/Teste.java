import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaPoupanca;
import Exceptions.SaldoException;
import Exceptions.SaqueNegativoException;
import Banco.Banco;
import Banco.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) throws SaldoException, SaqueNegativoException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Conta> lista = new ArrayList<Conta>(10);
        int opcao = 0;
        int tipo_De_Conta;
        String busca;

        do {
            System.out.println(
                    "Selecione uma das opções:\n 1 - Cadastrar Conta\n 2 - Realizar Saque\n 3 - Realizar Deposito\n 4 - Realizar Transferência\n 5 - Consultar Cliente\n 6 - Listar Clientes por agência\n 7 - Encerrar Conta\n 0 - sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite:\n 1 - Corrente\n 2 - Poupança");
                    tipo_De_Conta = scanner.nextInt();
                    if (tipo_De_Conta == 1 || tipo_De_Conta == 2) {
                        System.out.println("Número da agência banco:");
                        String numero_Da_Agencia = scanner.next();
                        System.out.println("Nome agência:");
                        String nome_Da_Agencia = scanner.next();
                        System.out.println("Nome do titular:");
                        String nome_Do_Titular = scanner.next();
                        System.out.println("CPF do titular:");
                        String cpf_Do_Titular = scanner.next();
                        System.out.println("RG do titular:");
                        String rg_Do_Titular = scanner.next();
                        System.out.println("Numero da conta:");
                        String numero_Da_Conta = scanner.next();
                        System.out.println("Saldo da conta:");
                        double saldo = scanner.nextDouble();
                        Banco banco = new Banco(numero_Da_Agencia, nome_Da_Agencia);
                        Cliente titular = new Cliente(rg_Do_Titular, cpf_Do_Titular, nome_Do_Titular);
                        if (tipo_De_Conta == 1) {
                            Conta conta = new ContaCorrente(numero_Da_Conta, saldo, titular, banco);
                            lista.add(conta);
                        }
                        if (tipo_De_Conta == 2) {
                            System.out.println("Juros da conta:");
                            double juros = scanner.nextDouble();
                            Conta conta = new ContaPoupanca(numero_Da_Conta, saldo, titular, banco, juros);
                            lista.add(conta);
                        }
                    } else {
                        System.out.println("Opção incorreta!");
                    }
                    break;
                case 2:
                    System.out.println("CPF do titular que deseja Sacar:");
                    busca = scanner.next();
                    System.out.println("Sacar em:\n 1 - Corrente\n 2 - Poupança");
                    tipo_De_Conta = scanner.nextInt();
                    for (int i = 0; i < lista.size(); i++) {
                        if (busca.equals(lista.get(i).getTitular().getCpf())) {
                            if (tipo_De_Conta == 1 || tipo_De_Conta == 2) {
                                if (tipo_De_Conta == 1 && lista.get(i) instanceof ContaCorrente) {
                                    System.out.println("Valor do saque:");
                                    double saque = scanner.nextDouble();
                                    lista.get(i).realizasaque(saque);
                                    System.out.println("Novo saldo: " + lista.get(i).getSaldo());
                                }
                                if (tipo_De_Conta == 2 && lista.get(i) instanceof ContaPoupanca) {
                                    System.out.println("Valor do saque:");
                                    double saque = scanner.nextDouble();
                                    lista.get(i).realizasaque(saque);
                                    System.out.println("Novo saldo: " + lista.get(i).getSaldo());
                                }
                            } else {
                                System.out.println("Opção incorreta!");
                            }
                        } else {
                            System.out.println("CPF não Encontrado!");
                        }
                    }
                    break;
                case 3:
                    System.out.println("CPF do titular que deseja depositar:");
                    busca = scanner.next();
                    System.out.println("Depositar em:\n 1 - Corrente\n 2 - Poupança");
                    tipo_De_Conta = scanner.nextInt();
                    for (int i = 0; i < lista.size(); i++) {
                        if (busca.equals(lista.get(i).getTitular().getCpf())) {
                            if (tipo_De_Conta == 1 || tipo_De_Conta == 2) {
                                if (tipo_De_Conta == 1 && lista.get(i) instanceof ContaCorrente) {
                                    System.out.println("Valor do deposito:");
                                    double deposito = scanner.nextDouble();
                                    lista.get(i).realizadeposito(deposito);
                                    System.out.println("Novo saldo: " + lista.get(i).getSaldo());
                                }
                                if (tipo_De_Conta == 2 && lista.get(i) instanceof ContaPoupanca) {
                                    System.out.println("Valor do deposito:");
                                    double deposito = scanner.nextDouble();
                                    lista.get(i).realizadeposito(deposito);
                                    System.out.println("Novo saldo: " + lista.get(i).getSaldo());
                                }
                            } else {
                                System.out.println("Opção incorreta!");
                            }
                        } else {
                            System.out.println("CPF não Encontrado!");
                        }
                    }
                    break;
                case 4:
                    // Falta criar o metodo!!!
                    break;
                case 5:
                    System.out.println("CPF do Titular que deseja consultar:");
                    busca = scanner.next();
                    for (int i = 0; i < lista.size(); i++) {
                        if (busca.equals(lista.get(i).getTitular().getCpf())) {
                            if (lista.get(i) instanceof ContaCorrente) {
                                ContaCorrente corrente = (ContaCorrente) lista.get(i);
                                System.out.println("Nome: " + corrente.getTitular().getNome() + "\nCPF: "
                                        + corrente.getTitular().getCpf() + "\nRG: " + corrente.getTitular().getRg()
                                        + "\nNúmero da agência: " + corrente.getBanco().getAgencia()
                                        + "\nNome da agência: " + corrente.getBanco().getNomeagencia()
                                        + "\nTipo de Conta: Corrente" + "\nNúmero da conta: " + corrente.getNumero()
                                        + "\nSaldo: " + corrente.getSaldo() + "\n");
                            }
                            if (lista.get(i) instanceof ContaPoupanca) {
                                ContaPoupanca poupanca = (ContaPoupanca) lista.get(i);
                                System.out.println("Nome: " + poupanca.getTitular().getNome() + "\nCPF: "
                                        + poupanca.getTitular().getCpf() + "\nRG: " + poupanca.getTitular().getRg()
                                        + "\nNúmero da agência: " + poupanca.getBanco().getAgencia()
                                        + "\nNome da agência: " + poupanca.getBanco().getNomeagencia()
                                        + "\nTipo de Conta: Poupança" + "\nNúmero da conta: " + poupanca.getNumero()
                                        + "\nSaldo: " + poupanca.getSaldo() + "\nJuros:" + poupanca.getJuros() + "\n");
                            }
                        } else {
                            System.out.println("CPF não Encontrado!");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Número da agência que deseja listar os titulares:");
                    busca = scanner.next();
                    for (int i = 0; i < lista.size(); i++) {
                        if (busca.equals(lista.get(i).getBanco().getAgencia())) {
                            if (lista.get(i) instanceof ContaCorrente) {
                                ContaCorrente corrente = (ContaCorrente) lista.get(i);
                                System.out.println("Conta: Corrente \nNome: " + corrente.getTitular().getNome()
                                        + "\nCPF: " + corrente.getTitular().getCpf() + "\nRG: "
                                        + corrente.getTitular().getRg() + "\nNúmero da conta: " + corrente.getNumero()
                                        + "\nSaldo: " + corrente.getSaldo() + "\n");
                            }
                            if (lista.get(i) instanceof ContaPoupanca) {
                                ContaPoupanca poupanca = (ContaPoupanca) lista.get(i);
                                System.out.println("Conta: Poupança \nNome: " + poupanca.getTitular().getNome()
                                        + "\nCPF: " + poupanca.getTitular().getCpf() + "\nRG: "
                                        + poupanca.getTitular().getRg() + "\nNúmero da conta: " + poupanca.getNumero()
                                        + "\nSaldo: " + poupanca.getSaldo() + "\nJuros: " + poupanca.getJuros() + "\n");
                            }
                        } else {
                            System.out.println("Agência não Encontrada!");
                        }
                    }
                    break;
                case 7:
                    System.out.println("CPF do Titular que deseja Cancelar a conta:");
                    busca = scanner.next();
                    System.out.println("Sacar em:\n 1 - Corrente\n 2 - Poupança");
                    tipo_De_Conta = scanner.nextInt();
                    for (int i = 0; i < lista.size(); i++) {
                        if (busca.equals(lista.get(i).getTitular().getCpf())) {
                            if (tipo_De_Conta == 1 || tipo_De_Conta == 2) {
                                if (tipo_De_Conta == 1 && lista.get(i) instanceof ContaCorrente) {
                                    lista.remove(i);
                                }
                                if (tipo_De_Conta == 2 && lista.get(i) instanceof ContaPoupanca) {
                                    lista.remove(i);
                                }
                            } else {
                                System.out.println("Opção incorreta!");
                            }
                        } else {
                            System.out.println("CPF não Encontrado!");
                        }
                    }
                    break;
            }
        } while (opcao != 0);
        scanner.close();
    }
}