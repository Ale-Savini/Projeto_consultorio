package model;
import java.util.Date;

public class Agenda {

    private int idAgenda;
    private Profissional profissional; 
    private Sala sala; 
    private Date dataHoraInicio;
    private Date dataHoraFim;
    private String status;

    public Agenda(int idAgenda, Profissional profissional, Sala sala, Date dataHoraInicio, Date dataHoraFim, String status) {
        this.idAgenda = idAgenda;
        this.profissional = profissional;
        this.sala = sala;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.status = status;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void exibirInformacoes() {
        System.out.println("ID da Agenda: " + idAgenda);
        System.out.println("Profissional: " + profissional.getNome());
        System.out.println("Sala: " + sala.getNome());
        System.out.println("Data e Hora de Início: " + dataHoraInicio);
        System.out.println("Data e Hora de Fim: " + dataHoraFim);
        System.out.println("Status: " + status);
    }
}
