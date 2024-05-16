package entities;

public abstract class Aluno extends Pessoa {

    protected String duracaoCurso;

    public Aluno(String nome, String cpf, int matricula, String telefone, String email, String endereco) {
        super(nome, cpf, matricula, telefone, email, endereco);
    }

    public String getDuracaoCurso() {
        return duracaoCurso;
    }

    public void setDuracaoCurso(String duracaoCurso) {
        this.duracaoCurso = duracaoCurso;
    }

    public abstract String solicitarBoleto(String mes, int ano);

    public abstract String solicitarHistorico(int ano);
}
