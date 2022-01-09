import java.math.BigDecimal;

public class ContaMagica {
    private String nome;
    private BigDecimal saldo;
    private Categorias categoria;

    public ContaMagica(String nome) {
        this.nome = nome;
        this.categoria = Categorias.Silver;
        this.saldo = new BigDecimal("0.00");
    }

    public String getNomeCliente(){
        return nome;
    }

    public BigDecimal getSaldo(){
        return  saldo;
    }

    public Categorias getStatus(){
        return  categoria;
    }

    public void deposito(BigDecimal valor) {
        if (valor.compareTo(new BigDecimal("0.00")) < 0){
            return;
        }
        switch (categoria){
            case Silver:
                saldo = saldo.add(valor);
                break;
            case Gold:
                saldo = saldo.add(valor.multiply(new BigDecimal("1.01")));
                break;
            case Platinum:
                saldo = saldo.add(valor.multiply(new BigDecimal("1.025")));
                break;
        }
        if ((saldo.compareTo(new BigDecimal("50000.00")) >= 0) && (categoria == Categorias.Silver)){
            categoria = Categorias.Gold;
        } else if ((saldo.compareTo(new BigDecimal("200000.00")) >= 0) && (categoria == Categorias.Gold)){
            categoria = Categorias.Platinum;
        } else {
            categoria = Categorias.Silver;
        }
    }
    public void retirada(BigDecimal valor) {
        if (valor.compareTo(new BigDecimal("0.00")) < 0) {
            return;
        } else {
            saldo = saldo.subtract(valor);
            if (categoria == Categorias.Platinum) {
                if (saldo.compareTo(new BigDecimal(100000.00)) < 0) {
                    categoria = Categorias.Gold;
                }
            }
            if (categoria == Categorias.Gold) {
                if (saldo.compareTo(new BigDecimal(25000.00)) < 0) {
                    categoria = Categorias.Silver;
                }
            }
        }
    }
}

