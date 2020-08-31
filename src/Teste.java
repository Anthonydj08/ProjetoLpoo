import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaPoupanca;
import Exceptions.CpfException;
import Exceptions.SaldoException;
import Exceptions.TransferenciaException;
import Exceptions.ValorNegativoException;
import Banco.Banco;
import Banco.Cliente;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args)
            throws SaldoException, ValorNegativoException, TransferenciaException, CpfException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Conta> lista = new ArrayList<Conta>(10);
        int opcao = 0;
        int tipo_De_Conta;
        String busca;

        do {
            System.out.println(
                    "Selecione uma das opções:\n 1 - Cadastrar Conta\n 2 - Realizar Saque\n 3 - Realizar Deposito\n 4 - Realizar Transferência\n 5 - Render juros \n 6 - Consultar Cliente\n 7 - Listar Clientes por agência\n 8 - Encerrar Conta\n 0 - sair");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite:\n 1 - Corrente\n 2 - Poupança");
                    tipo_De_Conta = scanner.nextInt();
                    if (tipo_De_Conta == 1 || tipo_De_Conta == 2) {
                        try {
                            System.out.println("Número da agência banco:");
                            int numero_Da_Agencia = scanner.nextInt();
                            System.out.println("Nome agência:");
                            String nome_Da_Agencia = scanner.next();
                            System.out.println("Nome do titular:");
                            String nome_Do_Titular = scanner.next();
                            System.out.println("CPF do titular:");
                            String cpf_Do_Titular = scanner.next();
                            if (!CpfException.isCPF(cpf_Do_Titular)) {
                                throw new CpfException();
                            }
                            System.out.println("RG do titular:");
                            String rg_Do_Titular = scanner.next();
                            System.out.println("Numero da conta:");
                            int numero_Da_Conta = scanner.nextInt();
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
                        } catch (NullPointerException npe) {
                            System.out.println("Campo vazio.");
                        } catch (InputMismatchException ime) {
                            System.out.println("Tipo de caractere incorreto.");
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
                                try {
                                    if (tipo_De_Conta == 1 && lista.get(i) instanceof ContaCorrente) {
                                        System.out.println("Valor do saque:");
                                        double valor_Saque = scanner.nextDouble();
                                        lista.get(i).realizasaque(valor_Saque);
                                        System.out.println("Novo saldo: " + lista.get(i).getSaldo());
                                        System.out.println("saque efetuado");
                                    }
                                    if (tipo_De_Conta == 2 && lista.get(i) instanceof ContaPoupanca) {
                                        System.out.println("Valor do saque:");
                                        double valor_Saque = scanner.nextDouble();
                                        lista.get(i).realizasaque(valor_Saque);
                                        System.out.println("Novo saldo: " + lista.get(i).getSaldo());
                                        System.out.println("saque efetuado");
                                    }

                                } catch (NullPointerException npe) {
                                    System.out.println("Campo vazio.");
                                } catch (InputMismatchException ime) {
                                    System.out.println("Tipo de caractere incorreto.");
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
                                try {
                                    if (tipo_De_Conta == 1 && lista.get(i) instanceof ContaCorrente) {
                                        System.out.println("Valor do deposito:");
                                        double valor_Deposito = scanner.nextDouble();
                                        lista.get(i).realizadeposito(valor_Deposito);
                                        System.out.println("Novo saldo: " + lista.get(i).getSaldo());
                                        System.out.println("Deposito efetuado");
                                    }
                                    if (tipo_De_Conta == 2 && lista.get(i) instanceof ContaPoupanca) {
                                        System.out.println("Valor do deposito:");
                                        double valor_Deposito = scanner.nextDouble();
                                        lista.get(i).realizadeposito(valor_Deposito);
                                        System.out.println("Novo saldo: " + lista.get(i).getSaldo());
                                        System.out.println("Deposito efetuado");
                                    }
                                } catch (NullPointerException npe) {
                                    System.out.println("Campo vazio.");
                                } catch (InputMismatchException ime) {
                                    System.out.println("Tipo de caractere incorreto.");
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
                    System.out.println("CPF do titular que deseja transferir:");
                    busca = scanner.next();
                    System.out.println("Transferir da:\n 1 - Corrente\n 2 - Poupança");
                    tipo_De_Conta = scanner.nextInt();
                    boolean verifica_Origem = false;
                    boolean verifica_Destino = false;
                    for (int i = 0; i < lista.size(); i++) {
                        if (busca.equals(lista.get(i).getTitular().getCpf())) {
                            verifica_Origem = true;
                            if (tipo_De_Conta == 1 || tipo_De_Conta == 2) {
                                if (tipo_De_Conta == 1 && lista.get(i) instanceof ContaCorrente) {
                                    if (tipo_De_Conta == 1 && lista.get(i) instanceof ContaCorrente) {
                                        try {
                                            System.out.println("CPF do titular de detino");
                                            String busca_Destino = scanner.next();
                                            System.out.println("Transferir para:\n 1 - Corrente\n 2 - Poupança");
                                            int tipo_De_Conta_Destino = scanner.nextInt();
                                            for (int j = 0; j < lista.size(); j++) {
                                                if (busca_Destino.equals(lista.get(j).getTitular().getCpf())) {
                                                    verifica_Destino = true;
                                                    if (tipo_De_Conta_Destino == 1 || tipo_De_Conta_Destino == 2) {
                                                        if (tipo_De_Conta_Destino == 1
                                                                && lista.get(j) instanceof ContaCorrente) {
                                                            ContaCorrente conta_Destino = (ContaCorrente) lista.get(j);
                                                            System.out.println("Valor da transfencia:");
                                                            double valor_Transferencia = scanner.nextDouble();
                                                            lista.get(i).realizatransferencia(conta_Destino,
                                                                    valor_Transferencia);
                                                            System.out.println("Transação efetuada");
                                                        }
                                                        if (tipo_De_Conta_Destino == 2
                                                                && lista.get(j) instanceof ContaPoupanca) {
                                                            ContaPoupanca conta_Destino = (ContaPoupanca) lista.get(j);
                                                            System.out.println("Valor da transfencia:");
                                                            double valor_Transferencia = scanner.nextDouble();
                                                            lista.get(i).realizatransferencia(conta_Destino,
                                                                    valor_Transferencia);
                                                            System.out.println("Transação efetuada");
                                                        }
                                                    } else {
                                                        System.out.println("Opção da conta de destino incorreta!");
                                                    }
                                                }
                                                if (j == (lista.size() - 1) && verifica_Destino == false) {
                                                    System.out.println("CPF do titular de destino não Encontrado!");
                                                }
                                            }
                                        } catch (NullPointerException npe) {
                                            System.out.println("Campo vazio.");
                                        } catch (InputMismatchException ime) {
                                            System.out.println("Tipo de caractere incorreto.");
                                        }
                                    }
                                }
                                if (tipo_De_Conta == 2 && lista.get(i) instanceof ContaPoupanca) {
                                    try {
                                        System.out.println("CPF do titular de detino");
                                        String busca_Destino = scanner.next();
                                        System.out.println("Transferir para:\n 1 - Corrente\n 2 - Poupança");
                                        int tipo_De_Conta_Destino = scanner.nextInt();
                                        for (int j = 0; j < lista.size(); j++) {
                                            if (busca_Destino.equals(lista.get(j).getTitular().getCpf())) {
                                                verifica_Destino = true;
                                                if (tipo_De_Conta_Destino == 1 || tipo_De_Conta_Destino == 2) {
                                                    if (tipo_De_Conta_Destino == 1
                                                            && lista.get(j) instanceof ContaCorrente) {
                                                        ContaCorrente conta_Destino = (ContaCorrente) lista.get(j);
                                                        System.out.println("Valor da transfencia:");
                                                        double valor_Transferencia = scanner.nextDouble();
                                                        lista.get(i).realizatransferencia(conta_Destino,
                                                                valor_Transferencia);
                                                        System.out.println("Transação efetuada");
                                                    }
                                                    if (tipo_De_Conta_Destino == 2
                                                            && lista.get(j) instanceof ContaPoupanca) {
                                                        ContaPoupanca conta_Destino = (ContaPoupanca) lista.get(j);
                                                        System.out.println("Valor da transfencia:");
                                                        double valor_Transferencia = scanner.nextDouble();
                                                        lista.get(i).realizatransferencia(conta_Destino,
                                                                valor_Transferencia);
                                                        System.out.println("Transação efetuada");
                                                    }
                                                } else {
                                                    System.out.println("Opção da conta de destino incorreta!");
                                                }
                                            }
                                            if (j == (lista.size() - 1) && verifica_Destino == false) {
                                                System.out.println("CPF do titular de destino não Encontrado!");
                                            }
                                        }
                                    } catch (NullPointerException npe) {
                                        System.out.println("Campo vazio.");
                                    } catch (InputMismatchException ime) {
                                        System.out.println("Tipo de caractere incorreto.");
                                    }
                                }
                            } else {
                                System.out.println("Opção da conta de origem incorreta!");
                            }
                        }
                        if (i == (lista.size() - 1) && verifica_Origem == false) {
                            System.out.println("CPF do titular de origem não Encontrado!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("CPF do titular: ");
                    busca = scanner.next();
                    for (int i = 0; i < lista.size(); i++) {
                        if (busca.equals(lista.get(i).getTitular().getCpf()) && lista.get(i) instanceof ContaPoupanca) {
                            ContaPoupanca poupanca = (ContaPoupanca) lista.get(i);
                            poupanca.renderjuros();
                            System.out.println("Operação efetuada, Saldo atual: " + poupanca.getSaldo());
                        }
                    }
                    break;
                case 6:
                    System.out.println("CPF do Titular que deseja consultar:");
                    busca = scanner.next();
                    for (int i = 0; i < lista.size(); i++) {
                        if (busca.equals(lista.get(i).getTitular().getCpf())) {
                            try {
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
                                            + "\nSaldo: " + poupanca.getSaldo() + "\nJuros:" + poupanca.getJuros()
                                            + "\n");
                                }
                            } catch (NullPointerException npe) {
                                System.out.println("Campo vazio.");
                            } catch (InputMismatchException ime) {
                                System.out.println("Tipo de caractere incorreto.");
                            }

                        } else {
                            System.out.println("CPF não Encontrado!");
                        }
                    }
                    break;
                case 7:
                    try {
                        System.out.println("Número da agência que deseja listar os titulares:");
                        int busca_numero_agencia = scanner.nextInt();
                        for (int i = 0; i < lista.size(); i++) {
                            if (busca_numero_agencia == lista.get(i).getBanco().getAgencia()) {

                                if (lista.get(i) instanceof ContaCorrente) {
                                    ContaCorrente corrente = (ContaCorrente) lista.get(i);
                                    System.out.println("Conta: Corrente \nNome: " + corrente.getTitular().getNome()
                                            + "\nCPF: " + corrente.getTitular().getCpf() + "\nRG: "
                                            + corrente.getTitular().getRg() + "\nNúmero da conta: "
                                            + corrente.getNumero() + "\nSaldo: " + corrente.getSaldo() + "\n");
                                }
                                if (lista.get(i) instanceof ContaPoupanca) {
                                    ContaPoupanca poupanca = (ContaPoupanca) lista.get(i);
                                    System.out.println("Conta: Poupança \nNome: " + poupanca.getTitular().getNome()
                                            + "\nCPF: " + poupanca.getTitular().getCpf() + "\nRG: "
                                            + poupanca.getTitular().getRg() + "\nNúmero da conta: "
                                            + poupanca.getNumero() + "\nSaldo: " + poupanca.getSaldo() + "\nJuros: "
                                            + poupanca.getJuros() + "\n");
                                }
                            } else {
                                System.out.println("Agência não Encontrada!");
                            }
                        }
                    } catch (NullPointerException npe) {
                        System.out.println("Campo vazio.");
                    } catch (InputMismatchException ime) {
                        System.out.println("Tipo de caractere incorreto.");
                    }
                    break;
                case 8:
                    System.out.println("CPF do Titular que deseja Cancelar a conta:");
                    busca = scanner.next();
                    System.out.println("Cancelar a:\n 1 - Corrente\n 2 - Poupança");
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