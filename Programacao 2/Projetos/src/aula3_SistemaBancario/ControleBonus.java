package aula3_SistemaBancario;

public class ControleBonus {

    private double totalBonus = 0.0;

    public void setTotalBonus(Funcionario funcionario) {
        this.totalBonus += funcionario.getBonus();
    }

    public double getTotalBonus() {
        return totalBonus;
    }
}
