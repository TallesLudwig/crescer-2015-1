
import static org.junit.Assert.*;
import org.junit.*;


/**
 * Testes unitários para a classe Elfo.
 *
 * @author  CWI Software
 */


public class ElfoTest
{
    @Before
    public void setUp(){
        Elfo.limpaContadorDeElfos();
    }
    
    @Test
    public void elfoNasceComNomeInformado() {
        // Arrange
        String esperado = "Celeborn";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeVazio() {
        // Arrange
        String esperado = "";        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceComNomeNulo() {
        // Arrange
        String esperado = null;        
        // Act
        Elfo elfo = new Elfo(esperado);
        // Assert
        assertEquals(esperado, elfo.getNome());
    }
    
    @Test
    public void elfoNasceCom42FlechasPorPadrao() {
        // Arrange
        int esperado = 42;
        // Act
        Elfo elfo = new Elfo("um nome qualquer");
        // Assert
        assertEquals(esperado, elfo.getFlechas());
    }
    
    @Test
    public void elfoNasceComNomeEMuitasFlechasInformados() {
        // Arrange
        String nomeEsperado = "Robin";
        int flechasEsperadas = 567853;
        // Act
        Elfo elfo = new Elfo(nomeEsperado, flechasEsperadas);
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
    public void elfoAtiraFlechaEmUmOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 1;
        int flechasEsperadas = 41;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasDuasVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas");
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 2;
        int flechasEsperadas = 40;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
        assertEquals(flechasEsperadas, elfo.getFlechas());
    }
    
    @Test
    public void elfoAtiraFlechasCincoVezesNoMesmoOrc() {
        // Arrange
        Elfo elfo = new Elfo("Legolas", 4);
        Orc orc = new Orc();
        // Act
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        elfo.atirarFlecha(orc);
        // Assert
        int experienciaEsperada = 5;
        int flechasEsperadas = -1;
        
        assertEquals(experienciaEsperada, elfo.getExperiencia());
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
    
    @Test
    public void contadorDeElfos() {
        // Arrange
    
        Elfo elfo = new Elfo("Faustão");
          // Act
        int resultadoEsperado = 1;
        // Assert
        assertEquals(resultadoEsperado, Elfo.getContadorDeElfos());
    }  
    
     @Test
    public void contadorDeElfosComVerde() {
        // Arrange
        
        Elfo elfo = new Elfo("Faustão");
        ElfoVerde elfoV = new ElfoVerde("Faustão não Maduro");
          // Act
        int resultadoEsperado = 2;
        // Assert
        assertEquals(resultadoEsperado, Elfo.getContadorDeElfos());
    }
    
     @Test
    public void contadorDeElfosComVerdeNoturno() {
        // Arrange
        
        Elfo elfo = new Elfo("Faustão");
        ElfoVerde elfoV = new ElfoVerde("Faustão não Maduro");
        ElfoNoturno elfoN = new ElfoNoturno("Faustão da Nigth");
          // Act
        int resultadoEsperado = 3;
        // Assert
        assertEquals(resultadoEsperado, Elfo.getContadorDeElfos());
    }
    
     @Test
    public void contadorDeTresElfosComVerdeNoturno() {
        // Arrange
         
        Elfo elfo = new Elfo("Faustão");
        Elfo elfo2 = new Elfo("Gugu");
        Elfo elfo3 = new Elfo("Ratinho");
        ElfoVerde elfoV = new ElfoVerde("Faustão não Maduro");
        ElfoNoturno elfoN = new ElfoNoturno("Faustão da Nigth");
          // Act
        int resultadoEsperado = 5;
        // Assert
        assertEquals(resultadoEsperado, Elfo.getContadorDeElfos());
    }
    
    
}



