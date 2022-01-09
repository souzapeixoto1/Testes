import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class PrePagoParquimetroJU5 {
    private Parquimetro parq;
    private PrePagoParquimetro prePago;

    @BeforeEach
    void setUp(){
        parq = Mockito.mock(Parquimetro.class);
        prePago = new PrePagoParquimetro(parq);
    }

    @Test
    void inserirCreditoTest(){
        prePago.insereCredito(10);
        prePago.insereCredito(40);
        prePago.insereCredito(100);
        assertEquals(150, prePago.getCreditos());
    }

    @Test
    void emiteTicketTest(){
        long res =0;
        prePago.insereCredito(10);

        when(parq.emiteTicket()).thenReturn(true)
                                .thenReturn(true)
                                .thenReturn(true)
                                .thenReturn(true)
                                .thenReturn(true);

        res = prePago.emiteTicket();
        res = prePago.emiteTicket();
        res = prePago.emiteTicket();
        res = prePago.emiteTicket();
        res = prePago.emiteTicket();

        assertEquals(0, prePago.getCreditos());
    }

    @Test
    void emiteTicketInvTest(){
       assertThrows(IllegalStateException.class, () -> prePago.emiteTicket());
    }
}
