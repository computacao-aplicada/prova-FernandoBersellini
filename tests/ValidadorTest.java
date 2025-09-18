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
    public void validarCPFcomEspacos() {
        assertEquals(true, Validador.validarCPF(" 529.982.247-25 "));
    }

    @Test
    public void validarCPFvazio(){
        assertEquals(false, Validador.validarCPF(""));
    }

    @Test
    public void validarCPFnulo(){
        assertEquals(false, Validador.validarCPF(null));
    }

    @Test
    public void validarCPFtamanhoMenor(){
        assertEquals(false, Validador.validarCPF("935.411.347-8"));
    }

    @Test
    public void validarCPFtamanhoMaior(){
        assertEquals(false, Validador.validarCPF("935.411.347-800"));
    }

    @Test
    public void validarCPFCaractereInvalido(){
        assertEquals(false, Validador.validarCPF("529.982.247-2X"));
    }

    @Test
    public void validarCPFsequenciaRepetida(){
        assertEquals(false, Validador.validarCPF("000.000.000-00"));
    }

    @Test
    public void validarCPFmesmoCPF(){
        assertEquals(false,  Validador.validarCPF("529.982.247-24"));
    }

    @Test
    public void validarCPdvIncorreto(){
        assertEquals(false,  Validador.validarCPF("123.456.789-00"));
    }

}
