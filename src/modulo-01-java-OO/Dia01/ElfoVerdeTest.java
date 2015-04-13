import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testes unitários para a classe Elfo.
 *
 * @author  CWI Software
 */
public class ElfoVerdeTest
{
    @Test
    public void elfoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        ElfoVerde elfo = new ElfoVerde(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        ElfoVerde elfo = new ElfoVerde(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        ElfoVerde elfo = new ElfoVerde(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        ElfoVerde elfo = new ElfoVerde("um nome qualquer");
        // Assert
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        ElfoVerde elfo = new ElfoVerde(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEPoucasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 12;
        // Act
        ElfoVerde elfo = new ElfoVerde(nomeEsperado, flechasEsperadas);
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
        ElfoVerde elfo = new ElfoVerde(nomeEsperado, flechasEsperadas);
        // Assert
        assertEquals(nomeEsperado, elfo.getNome());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Legolas");
        Orc orc = new Orc("Brutos");
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Legolas");
        Orc orc = new Orc("Brutos");
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 4;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Legolas", 4);
        Orc orc = new Orc("Brutos");
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 10;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoToStringPadrao() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Faustão");
        String resultadoEsperado = "Faustão possui 42 flechas e 0 níveis de experiência.";
        // Act
        String resultadoObtido = elfo.toString();
        // Assert
        assertEquals(resultadoEsperado, resultadoObtido);
    }
    
    @Test
    public void elfoVerdeAddNenhumItens() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Faustão");
        Elfo elfo2 = new Elfo("Faustão2");
        
        // Act
     
        // Assert
        assertEquals(elfo2.getItens(), elfo.getItens());
    }
    
        @Test
    public void elfoVerdeAddUmIten() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Faustão");
        Elfo elfo2 = new Elfo("Faustão2");
        ItemDoInventario arco = new ItemDoInventario(1050,"Arco e Flecha de vidro");
    
        
        // Act
        
        elfo.adicionarItem(arco);
         
        elfo2.adicionarItem(arco);
      
        // Assert
        assertEquals(elfo2.getItens(), elfo.getItens());
    }
    
    
        @Test
    public void elfoVerdeAddMaisdeUmItens() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Faustão");
        Elfo elfo2 = new Elfo("Faustão2");
        ItemDoInventario arco = new ItemDoInventario(0,"Arco e Flecha de vidro");
        ItemDoInventario espada = new ItemDoInventario(-1,"Espada de aço valiriano");
        
        // Act
         elfo.adicionarItem(espada);
        elfo.adicionarItem(arco);
         elfo2.adicionarItem(espada);
        elfo2.adicionarItem(arco);
      
        // Assert
        assertEquals(elfo2.getItens(), elfo.getItens());
    }
    
    
        @Test
    public void elfoVerdeAddItensComItemerrado() {
        // Arrange
        ElfoVerde elfo = new ElfoVerde("Faustão");
        Elfo elfo2 = new Elfo("Faustão2");
        ItemDoInventario arco = new ItemDoInventario(10,"Arco e Flecha de vidro");
        ItemDoInventario espada = new ItemDoInventario(1,"Espada de aço valiriano");
        ItemDoInventario outroItem = new ItemDoInventario(100,"Pocoes");
        // Act
        elfo.adicionarItem(arco);
        elfo.adicionarItem(espada);
        elfo.adicionarItem(outroItem);
        elfo2.adicionarItem(arco);
        elfo2.adicionarItem(espada);
        // Assert
        assertEquals(elfo2.getItens(), elfo.getItens());
    }
    
    
  //  "Espada de aço valiriano" ou
  //“Arco e Flecha de vidro".
    
    
    
    
    
    
    
}



