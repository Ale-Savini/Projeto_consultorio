package model;
import java.util.Date;


public class Consulta {
    private int idConsulta;
    private Paciente paciente;
    private Profissional profissional;
    private Date data;
    private String status;

    public Consulta(int idConsulta, Paciente paciente, Profissional profissional, Date data, String status) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.profissional = profissional;
        this.data = data;
        this.status = status;
    }

    public void exibirConsulta() {
        System.out.println("ID da Consulta: " + idConsulta);
        System.out.println("Paciente: " + paciente.getNome() + " | CPF: " + paciente.getCpf());
        System.out.println("Profissional: " + profissional.getNome() + " | Especialidade: " + profissional.getEspecialidade());
        System.out.println("Data: " + data);
        System.out.println("Status: " + status);
    }
}
