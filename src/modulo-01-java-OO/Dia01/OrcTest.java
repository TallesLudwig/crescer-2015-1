

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste OrcTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class OrcTest
{
    @Test
    public void orcNasceCom110Vida() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        // Act - Execução da ação de testes
        umOrc = new Orc("Brutos");
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
   
    
    @Test
    public void orcToStringRetornaVidaPadrao() {
        // Arrange
        Orc orc = new Orc("Brutos");
        // Act
        String resultadoObtido = orc.toString();
        // Assert
        String esperado = "Vida atual: 110";
        assertEquals(esperado, resultadoObtido);
    }
    
     @Test
    public void orcRecebeAtaqueSemDanoEcomXp1() {
        // Arrange
        Orc orc = new Orc("Brus");
        // Act
        orc.setXP(2);
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =4;
        int resultadoxpObtido = orc.getXP();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }
    @Test 
    public void orcRecebeAtaqueSemDanoEcomXp2() {
        // Arrange
        Orc orc = new Orc("Bruto");
        // Act
        orc.setXP(28);
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =30;
        int resultadoxpObtido = orc.getXP();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }
     @Test
    public void orcRecebeAtaqueSemDanoEcomXp3() {
        // Arrange
        Orc orc = new Orc("Brus");
        // Act
        orc.setXP(2);
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =10;
        int resultadoxpObtido = orc.getXP();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }
    
        @Test
    public void orcRecebeAtaqueSemDano1() {
        // Arrange
        Orc orc = new Orc("Brutos");
        // Act
        
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =0;
        int resultadoxpObtido = orc.getXP();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }
        @Test
    public void orcRecebeAtaqueSemDano2() {
        // Arrange
        Orc orc = new Orc("Brutos");
        // Act
        
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =0;
        int resultadoxpObtido = orc.getXP();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }
        @Test
    public void orcRecebeAtaqueSemDano3() {
        // Arrange
        Orc orc = new Orc("Brutos");
        // Act
        orc.setStatus(Status.Dormindo);
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =0;
        int resultadoxpObtido = orc.getXP();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }
    
   @Test
    public void orcRecebeAtaquecomDano1() {
        // Arrange
        Orc orc = new Orc("Brutos o Covarde");
        // Act
        orc.setVida(60);
        orc.setStatus(Status.Dormindo);
        
        orc.recebeAtaque();
        
        int esperadoV =50;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =0;
        int resultadoxpObtido = orc.getXP();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }
     @Test
    public void orcRecebeAtaquecomDano2() {
        // Arrange
        Orc orc = new Orc("Brutos o Covarde");
        // Act
        orc.setVida(60);
        orc.setStatus(Status.Dormindo);
        
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        int esperadoV =20;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =0;
        int resultadoxpObtido = orc.getXP();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }
     @Test
    public void orcRecebeAtaquecomDano3() {
        // Arrange
        Orc orc = new Orc("Brutos o Covarde");
        // Act
        orc.setVida(60);
        orc.setStatus(Status.Dormindo);
        
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        int esperadoV =0;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =0;
        int resultadoxpObtido = orc.getXP();
        Status estatusSperado= Status.Morto;
        // Assert
       // assertEquals(estatusSperado, orc.getStatus());
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }

}




