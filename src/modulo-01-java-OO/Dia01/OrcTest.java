

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
        public void orcNasceCom110Vida()
        {
            //A Arrange = Montagem  dos dodos de teste
            Orc umOrc;
            //A Act- execução da acão de teste
            umOrc = new Orc();
            //A Assert- Verificação
            int esperado = 110;
            int resultadoObtido=umOrc.getVida();
            
            assertEquals(esperado, resultadoObtido );
        }
    @Test
        public void recebeAtaque()
        {
            //A Arrange = Montagem  dos dodos de teste
            Orc umOrc;
            //A Act- execução da acão de teste
            umOrc = new Orc();
            //A Assert- Verificação
            int esperado = 110;
            int resultadoObtido=umOrc.getVida();
            
            assertEquals(esperado, resultadoObtido );
        }
 }
