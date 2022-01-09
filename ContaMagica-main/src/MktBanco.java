

import java.math.BigDecimal;

public class MktBanco {
    ContaMagica contaMagica;

    public MktBanco (ContaMagica contaMagica){
        this.contaMagica = contaMagica;
    }

    public BigDecimal faltanteProxCategoria(){
        Categorias categoria = contaMagica.getStatus();
        BigDecimal valor;

        if (categoria == Categorias.Silver){
            return valor = new BigDecimal(50000).subtract(contaMagica.getSaldo());
        }
        else if (categoria == Categorias.Gold){
            return valor = new BigDecimal(200000).subtract(contaMagica.getSaldo());
        }
        else{
            return BigDecimal.ZERO;
        }
    }

    public Categorias proxCategoria(){
        Categorias categoria = contaMagica.getStatus();

        if (categoria == Categorias.Silver){
            return Categorias.Gold;
        }
        else if (categoria == Categorias.Gold){
            return Categorias.Platinum;
        }
        else {
            return Categorias.Platinum;
        }
    }
}