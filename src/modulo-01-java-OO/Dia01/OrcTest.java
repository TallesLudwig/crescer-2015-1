

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
        umOrc = new Orc();
        // Assert - Verificação
        int esperado = 110;
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaque() {
        
         // Arrange - Montagem dos dados de teste
        Orc umOrc;
        Elfo umElfo;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        umElfo= new Elfo("legolas");
        // Assert - Verificação
        int esperado = 100;
        umElfo.atirarFlecha(umOrc);
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
        
    }
    
    
    @Test
    public void orcRecebeAtaqueMedio() {
        
         // Arrange - Montagem dos dados de teste
        Orc umOrc;
        Elfo umElfo;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        umElfo= new Elfo("legolas");
        // Assert - Verificação
        int esperado = 50;
       
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
        
    }
    
    @Test
    public void orcRecebeAtaqueGrande() {
        
         // Arrange - Montagem dos dados de teste
        Orc umOrc;
        Elfo umElfo;
        int i = 0;
        // Act - Execução da ação de testes
        umOrc = new Orc();
        umElfo= new Elfo("legolas");
        // Assert - Verificação
        int esperado = 0;
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        umElfo.atirarFlecha(umOrc);
        
        int resultadoObtido = umOrc.getVida();
        
        assertEquals(esperado, resultadoObtido);
        
    }
}





