public class PrePagoParquimetro {
    private Parquimetro parq;
    private long totalCredito = 0;

    public PrePagoParquimetro(Parquimetro p){
        parq = p;
    }

    public long getCreditos(){
        return totalCredito;
    }

    public long insereCredito(long cr){
        if (cr % 10 != 0)
            throw new IllegalArgumentException("Valor nao e multiplo de 10");
        else {
            totalCredito += cr;
        }
        return totalCredito;
    }

    public long emiteTicket(){
        boolean res = false;

        if (totalCredito >= 200){
            parq.insereMoeda(100);
            parq.insereMoeda(100);
            res = parq.emiteTicket();
            totalCredito -= 200;
        }
        else {
            throw new IllegalArgumentException("Credito Insuficiente");
        }
        return totalCredito;
    }
}
