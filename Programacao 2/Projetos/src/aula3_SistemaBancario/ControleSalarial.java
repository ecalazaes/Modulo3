package aula3_SistemaBancario;

public class ControleSalarial {

    private double totalSalarios;

    public void setTotalSalarios(Funcionario funcionario) {
        this.totalSalarios += funcionario.getSalario();
    }

    public double getTotalSalarios() {
        return this.totalSalarios;
    }
}
