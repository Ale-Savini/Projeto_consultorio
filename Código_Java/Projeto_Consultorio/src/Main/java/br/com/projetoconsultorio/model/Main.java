package Main.java.br.com.projetoconsultorio.model;

import java.util.Scanner;

import Main.java.br.com.projetoconsultorio.dao.PacienteDAO;
import Main.java.br.com.projetoconsultorio.dao.ProfissionalDAO;

public class Main {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PacienteDAO pacienteDAO = new PacienteDAO();
        ProfissionalDAO profissionalDAO = new ProfissionalDAO();

        int opcao;

        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Cadastrar Profissional");
            System.out.println("4. Listar Profissionais");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String sobrenome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    int idPessoa = pacienteDAO.inserirPessoa(nome, sobrenome, cpf, email, telefone);

                    if (idPessoa != -1) {
                        Paciente novoPaciente = new Paciente(idPessoa, nome, sobrenome, cpf, email, telefone);
                        pacienteDAO.adicionarPaciente(novoPaciente);
                    } else {
                        System.out.println("Erro ao cadastrar a pessoa. Paciente não foi adicionado.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Lista de Pacientes ---");
                    for (Paciente p : pacienteDAO.listarPacientes()) {
                        p.exibirInformacoes();
                        System.out.println("-------------------------");
                    }
                    break;

                case 3:
                    System.out.print("Nome: ");
                    String nomeP = scanner.nextLine();
                    System.out.print("Sobrenome: ");
                    String sobrenomeP = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfP = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailP = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefoneP = scanner.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidade = scanner.nextLine();

                    Profissional novoProfissional = new Profissional(0, 0, nomeP, sobrenomeP, cpfP, emailP, telefoneP, especialidade);
                    profissionalDAO.cadastrarProfissional(novoProfissional);
                    break;

                case 4:
                    System.out.println("\n--- Lista de Profissionais ---");
                    for (Profissional prof : profissionalDAO.listarProfissionais()) {
                        prof.exibirInformacoes();
                        System.out.println("-------------------------");
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
