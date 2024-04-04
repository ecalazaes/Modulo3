package aula3_SistemaBancario;

public class Gerente extends Funcionario{
    private int senha;

    public Gerente() {
    }

    public Gerente(int senha) {
        this.senha = senha;
    }

    public int getSenha() {
        return senha;
    }

    public boolean verificaSenha(int senha){
        if(this.senha == senha){
            System.out.println("Acesso autorizado");
            return true;
        }
        else {
            System.out.println("Acesso não autorizado");
            return false;
        }
    }

    @Override
    public final double getBonus() {
        return this.salario * 0.15;
    }
}
