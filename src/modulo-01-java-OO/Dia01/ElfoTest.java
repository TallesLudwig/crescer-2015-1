
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoTest
{
   @Test
    public void elfo1Tirro() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        Elfo umElfo;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        umElfo = new Elfo("Legolas", 10);
        // Assert - Verificação
        int esperadoF = 9;
        int esperadoXP = 1;
        umElfo.atirarFlecha(umOrc);
        int resultadoObtidoF= umElfo.getFlechas();
        int resultadoObtidoXP= umElfo.getXP();
        assertEquals(esperadoF, resultadoObtidoF);
        assertEquals(resultadoObtidoXP,  umElfo.getXP());
    }
    
     @Test
    public void elfo5Tirro() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        Elfo umElfo;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        umElfo = new Elfo("Legolas", 10);
        // Assert - Verificação
        int esperadoF = 0;
        int esperadoXP = 10;
         for(int i =0; i<10; i++){
            umElfo.atirarFlecha(umOrc);
        }
        int resultadoObtidoF= umElfo.getFlechas();
        int resultadoObtidoXP= umElfo.getXP();
        assertEquals(esperadoF, resultadoObtidoF);
        assertEquals(resultadoObtidoXP,  umElfo.getXP());
    }
    
    
     @Test
    public void elfo50Tirros() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        Elfo umElfo;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        umElfo = new Elfo("Legolas", 50);
        // Assert - Verificação
        int esperadoF =0;
        int esperadoXP = 50;
        for(int i =0; i<50; i++){
            umElfo.atirarFlecha(umOrc);
        }
        
        int resultadoObtidoF= umElfo.getFlechas();
        int resultadoObtidoXP= umElfo.getXP();
        assertEquals(esperadoF, resultadoObtidoF);
        assertEquals(resultadoObtidoXP,  umElfo.getXP());
    }
    @Test
    public void elfoNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEFlechasNegativasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = -567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    } 
    @Test
    public void elfoToStringPadrao() {
        // Arrange
        Elfo elfo = new Elfo("Faustão");
        String resultadoEsperado = "Faustão possui 42 flechas e 0 níveis de experiência.";
        // Act
        String resultadoObtido = elfo.toString();
        // Assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
}
