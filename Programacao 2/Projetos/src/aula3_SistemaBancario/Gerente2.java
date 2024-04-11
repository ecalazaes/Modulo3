package aula3_SistemaBancario;

public class Gerente2 extends Funcionario{
    private int senha;

    public Gerente2() {
    }

    public Gerente2(int senha) {
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
        return super.getBonus() + 5000;
    }
}
