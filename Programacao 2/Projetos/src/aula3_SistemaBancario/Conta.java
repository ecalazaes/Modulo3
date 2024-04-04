package aula3_SistemaBancario;

public class Conta {
    private Integer numero;
    private String nome;
    private Double saldo;
    private Double limite;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(double valor) {
        this.saldo = valor;
    }


    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

   public boolean sacar(double valor) {
        if ((this.saldo + this.limite) < valor) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }
    public void depositar(double valor) {
        this.saldo += valor;
    }

}
