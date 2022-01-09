import java.math.BigDecimal;

public class app {
    public static void main(String[] args) {
        ContaMagica contaA = new ContaMagica("Leonardo");
        MktBanco banrisul = new MktBanco(contaA);


            System.out.println("Conta:" + contaA.getNomeCliente() + "\nTipo:" + contaA.getStatus());
            System.out.println("Saldo: R$" + contaA.getSaldo());

            contaA.deposito(BigDecimal.valueOf(50001.01));
            System.out.println("Saldo: R$" + contaA.getSaldo());
            System.out.println("Status:" + contaA.getStatus());

       //contaA.deposito(BigDecimal.valueOf(100000));
        contaA.retirada(BigDecimal.valueOf(2.00));
            System.out.println("Status:" + contaA.getStatus());
            System.out.println("Saldo: R$" + contaA.getSaldo());
        contaA.retirada(BigDecimal.valueOf(5.01));
        System.out.println("Status:" + contaA.getStatus());
        System.out.println("Saldo: R$" + contaA.getSaldo());
        contaA.retirada(BigDecimal.valueOf(27000.25));
        System.out.println("Status:" + contaA.getStatus());
        System.out.println("Saldo: R$" + contaA.getSaldo());

        System.out.println("Valor faltante R$"+banrisul.faltanteProxCategoria() + " para a categoria "+banrisul.proxCategoria());
        contaA.deposito(new BigDecimal(27006.20));
        System.out.println("Status:" + contaA.getStatus());
        System.out.println("Saldo: R$" + contaA.getSaldo());
        System.out.println("Valor faltante R$"+banrisul.faltanteProxCategoria() + " para a categoria "+banrisul.proxCategoria());

    }
}
