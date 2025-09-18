import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class ValidadorTest {
    @Test
    public void validarCPFvazio(){
        assertEquals(false, Validador.validarCPF(""));
    }

}
