import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class ValidadorTest {
    @Test
    public void validarCPFcomMascara() {
        assertEquals(true, Validador.validarCPF("529.982.247-25"));
    }

    @Test
    public void validarCPFsemMascara() {
        assertEquals(true, Validador.validarCPF("52998224725"));
    }

    @Test
    public void validarCPFvazio(){
        assertEquals(false, Validador.validarCPF(""));
    }

}
