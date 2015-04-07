

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemDoInventarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemDoInventarioTest
{
   @Test
    public void criaItemDoInventario1() {
        // Arrange - Montagem dos dados de teste
        ItemDoInventario item;
        String esperado1= "Arco";
        int esperado = 1;
        // Act - Execução da ação de testes
        item = new ItemDoInventario( esperado, esperado1);
        // Assert - Verificação
        String resultadoObtido1=item.getDescricao();
        int resultadoObtido = item.getQuantidade();
        
        assertEquals(esperado1, resultadoObtido1);
        assertEquals(esperado, resultadoObtido);
    }
     @Test
    public void criaItemDoInventario2() {
        // Arrange - Montagem dos dados de teste
        ItemDoInventario item;
        String esperado1= "Arco longo do legolas folha de carvalho";
        int esperado = -11000;
        // Act - Execução da ação de testes
        item = new ItemDoInventario( esperado, esperado1);
        // Assert - Verificação
        String resultadoObtido1=item.getDescricao();
        int resultadoObtido = item.getQuantidade();
        
        assertEquals(esperado1, resultadoObtido1);
        assertEquals(esperado, resultadoObtido);
    }
     @Test
    public void criaItemDoInventario3() {
        // Arrange - Montagem dos dados de teste
        ItemDoInventario item;
        String esperado1= "";
        int esperado = 0;
        // Act - Execução da ação de testes
        item = new ItemDoInventario( esperado, esperado1);
        // Assert - Verificação
        String resultadoObtido1=item.getDescricao();
        int resultadoObtido = item.getQuantidade();
        
        assertEquals(esperado1, resultadoObtido1);
        assertEquals(esperado, resultadoObtido);
    }
}
