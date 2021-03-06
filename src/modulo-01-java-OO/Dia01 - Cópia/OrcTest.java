import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


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
        orc.setExperiencia(2);
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =4;
        int resultadoxpObtido = orc.getExperiencia();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }

    @Test 
    public void orcRecebeAtaqueSemDanoEcomXp2() {
        // Arrange
        Orc orc = new Orc("Bruto");

        // Act
        orc.setExperiencia(28);
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =30;
        int resultadoxpObtido = orc.getExperiencia();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }

     @Test
    public void orcRecebeAtaqueSemDanoEcomXp3() {
        // Arrange
        Orc orc = new Orc("Brus");
        // Act
        orc.setExperiencia(2);
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =10;
        int resultadoxpObtido = orc.getExperiencia();
        // Assert
          
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }
    
    @Test
    public void orcRecebeAtaqueSemDano1() {
        // Arrange
        Orc orc = new Orc("Brasdasdu");
        // Act
          orc.setExperiencia(1);
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =1;
        int resultadoxpObtido = orc.getExperiencia();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }
    @Test
    public void orcRecebeAtaqueSemDano2() {
        // Arrange

        Orc orc = new Orc("Brasdasdu");

        // Act
          orc.setExperiencia(1);
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =1;
        int resultadoxpObtido = orc.getExperiencia();
        // Assert
        
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);
    }

        @Test
    public void orcRecebeAtaqueSemDano3() {
        // Arrange
        Orc orc = new Orc("Brasdasdu");

        // Act
          orc.setExperiencia(1);
        orc.setStatus(Status.Dormindo);
        orc.recebeAtaque();
        int esperadoV =110;
        int resultadoVObtido = orc.getVida();
        int esperadoXp =1;
        int resultadoxpObtido = orc.getExperiencia();
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
        int resultadoxpObtido = orc.getExperiencia();
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
        int resultadoxpObtido = orc.getExperiencia();
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
        int resultadoxpObtido = orc.getExperiencia();
        Status estatusSperado= Status.Morto;
        // Assert
       // assertEquals(estatusSperado, orc.getStatus());
        assertEquals(esperadoV, resultadoVObtido);
        assertEquals(esperadoXp, resultadoxpObtido);

    }
    
    @Test
    public void orcNasceComNomeVazioInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = "";   
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    

    @Test
    public void orcNasceComNomeNuloInformado() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc;
        String esperado = null; 
        // Act - Execução da ação de testes
        umOrc = new Orc(esperado);
        // Assert - Verificação
        String resultadoObtido = umOrc.getNome();
        
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcMorreAposDozeFlechadas() {
        // Arrange - Montagem dos dados de teste
        Orc umOrc = new Orc("Urukhai");
        Status esperado = Status.Morto;
        // Act
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        umOrc.recebeAtaque();
        Status resultadoObtido = umOrc.getStatus();
        // Assert
        assertEquals(esperado, resultadoObtido);
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoMenorQueZero() {
        Orc orc = new Orc("Tom");
        orc.recebeAtaque();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 2;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }
    
    @Test
    public void orcRecebeAtaqueComNumeroGeradoEntre0e100() {
        Orc orc = new Orc("Urukhai"); // para somar 65 ao número gerado
        orc.setExperiencia(1); // ímpar e menor que 2 para poder manter entre 0 e 100
        orc.recebeAtaque();
        
        int vidaEsperada = 110;
        int experienciaEsperada = 1;
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(experienciaEsperada, orc.getExperiencia());
    }

    
    @Test
    public void quandoAdicionoAdagaAoInventario() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        // Act
        urukhai.adicionarItem(adaga);
        ArrayList<ItemDoInventario> inventarioObtido = urukhai.getItens();
        // Assert...
        assertEquals(inventarioEsperado, inventarioObtido);
        assertEquals(inventarioEsperado.get(0), inventarioObtido.get(0));
    }

    @Test
    public void quandoAdicionoAdagaEEscudoAoInventario() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(12, "Escudo");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        inventarioEsperado.add(escudo);
        // Act
        urukhai.adicionarItem(adaga);
        urukhai.adicionarItem(escudo);
        ArrayList<ItemDoInventario> inventarioObtido = urukhai.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void quandoAdicionoAdagaAoInventarioEPercoAdaga() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        urukhai.adicionarItem(adaga);
        // Act
        urukhai.perderItem(adaga);
        ArrayList<ItemDoInventario> inventarioObtido = urukhai.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }

    @Test
    public void quandoAdicionoAdagaEEscudoAoInventarioEPercoEscudo() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(12, "Escudo");
        ArrayList<ItemDoInventario> inventarioEsperado = new ArrayList<>();
        inventarioEsperado.add(adaga);
        urukhai.adicionarItem(adaga);
        urukhai.adicionarItem(escudo);
        // Act
        urukhai.perderItem(escudo);
        ArrayList<ItemDoInventario> inventarioObtido = urukhai.getItens();
        // Assert
        assertEquals(inventarioEsperado, inventarioObtido);
    }
    
    @Test
    public void getDescricoesComNenhumItem() {
        // Arrange
        Orc urukhai = new Orc();
        String descricoesEsperada = "";
        // Act
        String resultadoDescricoes = urukhai.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void getDescricoesComUmItem() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        urukhai.adicionarItem(adaga);
        String descricoesEsperada = "Adaga";
        // Act
        String resultadoDescricoes = urukhai.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }
    
    @Test
    public void getDescricoesComDoisItens() {
        // Arrange
        Orc urukhai = new Orc();
        ItemDoInventario adaga = new ItemDoInventario(34, "Adaga");
        ItemDoInventario escudo = new ItemDoInventario(12, "Escudo de carvalho");
        urukhai.adicionarItem(adaga);
        urukhai.adicionarItem(escudo);
        String descricoesEsperada = "Adaga,Escudo de carvalho";
        // Act
        String resultadoDescricoes = urukhai.getDescricoesItens();
        // Assert
        assertEquals(descricoesEsperada, resultadoDescricoes);
    }

    
    @Test
    public void orcTentarSorteAumenta1000UnidadesDosItens() {
        // Arrange
        Orc urukhai = new Orc("Aa");
        urukhai.setStatus(Status.Dormindo);
        urukhai.setExperiencia(3);
        urukhai.adicionarItem(new ItemDoInventario(3, "Poção de mana"));
        urukhai.adicionarItem(new ItemDoInventario(1, "Poção Lança"));
        // Act
        urukhai.tentarSorte();
        // Assert
        
        ItemDoInventario pocao = urukhai.getItens().get(0);
        ItemDoInventario lanca = urukhai.getItens().get(1);
        assertEquals(1003, pocao.getQuantidade());
        assertEquals(1001, lanca.getQuantidade());
    }
    
    @Test
    public void orcTentarSorteNaoFazNada() {
        // Arrange
        Orc urukhai = new Orc();
        urukhai.adicionarItem(new ItemDoInventario(3, "Poção de mana"));
        urukhai.adicionarItem(new ItemDoInventario(1, "Poção Lança"));
        // Act
        urukhai.tentarSorte();
        // Assert
        ItemDoInventario pocao = urukhai.getItens().get(0);
        ItemDoInventario lanca = urukhai.getItens().get(1);
        assertEquals(3, pocao.getQuantidade());
        assertEquals(1, lanca.getQuantidade());
    }

         @Test
    public void orcItemComMaiorQuantidade() {
        // Arrange
        Orc urukhai = new Orc();
        
        ItemDoInventario aaa=new ItemDoInventario(3, "Poção de mana");
        urukhai.adicionarItem(aaa);
        // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(aaa, urukhai.getItemComMaiorQuantidade());
    }
      @Test
    public void orcItemComMaiorQuantidadeVarios() {
        // Arrange
        Orc urukhai = new Orc();
        
        ItemDoInventario aaa=new ItemDoInventario(3, "Poção de mana");
        urukhai.adicionarItem(aaa);
        
        ItemDoInventario aa=new ItemDoInventario(1, "Poção Lança");
        urukhai.adicionarItem(aa);

        ItemDoInventario a=new ItemDoInventario(0, "Cartas do Pokemon");
        urukhai.adicionarItem(a);
        // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(aaa, urukhai.getItemComMaiorQuantidade());
    }
    
      @Test
    public void orcItemComMaiorQuantidade2Iguais() {
        // Arrange
        Orc urukhai = new Orc();
        
        ItemDoInventario aaa=new ItemDoInventario(3, "Poção de mana");
        urukhai.adicionarItem(aaa);
        
        ItemDoInventario aa=new ItemDoInventario(3, "Poção");
        urukhai.adicionarItem(aa);

        
        // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(aaa, urukhai.getItemComMaiorQuantidade());
    }


    
     @Test
    public void orcItemComMaiorQuantidadeNegativa() {
        // Arrange
        Orc urukhai = new Orc();
        
        ItemDoInventario aaa=new ItemDoInventario(-11, "Poção de mana");
        urukhai.adicionarItem(aaa);
        
        ItemDoInventario aa=new ItemDoInventario(-1, "Poção Lança");
        urukhai.adicionarItem(aa);

        ItemDoInventario a=new ItemDoInventario(0, "Cartas do Pokemon");
        urukhai.adicionarItem(a);
        // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(a, urukhai.getItemComMaiorQuantidade());
    }
    
      @Test
    public void orcItemComMaiorQuantidadePerdeMaior() {
        // Arrange
        Orc urukhai = new Orc();
        
        ItemDoInventario aaa=new ItemDoInventario(-11, "Poção de mana");
        urukhai.adicionarItem(aaa);
        
        ItemDoInventario aa=new ItemDoInventario(1, "Poção Lança");
        urukhai.adicionarItem(aa);

        ItemDoInventario a=new ItemDoInventario(0, "Cartas do Pokemon");
        urukhai.adicionarItem(a);
        urukhai.perderItem(aaa);
        // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(aa, urukhai.getItemComMaiorQuantidade());
    }
    
        @Test
    public void orcItemComMaiorQuantidadeNull() {
        // Arrange
        Orc urukhai = new Orc();
        
      
        // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(null, urukhai.getItemComMaiorQuantidade());
    }
    
    @Test
    
    public void orcUmOrdenarItensSemnada() {
        // Arrange
        Orc urukhai = new Orc();
        Orc urukhai2 = new Orc();
        
        
       

       
                // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(urukhai2.getItens(), urukhai.getItens());
    }
    @Test
    
    public void orcUmOrdenarItens() {
        // Arrange
        Orc urukhai = new Orc();
        Orc urukhai2 = new Orc();
        
        
       

        ItemDoInventario a=new ItemDoInventario(8, "meio");
        urukhai.adicionarItem(a);
        urukhai.ordenarItens();
        urukhai2.adicionarItem(a);
                // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(urukhai2.getItens(), urukhai.getItens());
    }
    @Test
    public void orcOrdenarItens() {
        // Arrange
        Orc urukhai = new Orc();
        Orc urukhai2 = new Orc();
        
        
         ItemDoInventario aa=new ItemDoInventario(10, "primero");
        urukhai.adicionarItem(aa);
        
        ItemDoInventario aaa=new ItemDoInventario(1, "ultimo");
        urukhai.adicionarItem(aaa);
        
        
        urukhai.ordenarItens();
       
        urukhai2.adicionarItem(aaa);
        
        urukhai2.adicionarItem(aa);
       
        
        // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(urukhai2.getItens(), urukhai.getItens());
    }
    
    @Test
    public void orcOrdenarItensnegativo() {
        // Arrange
        Orc urukhai = new Orc();
        Orc urukhai2 = new Orc();
        
        
        ItemDoInventario aaa=new ItemDoInventario(-1, "ultimo");
        urukhai.adicionarItem(aaa);
        
        ItemDoInventario aa=new ItemDoInventario(10, "primero");
        urukhai.adicionarItem(aa);

        ItemDoInventario a=new ItemDoInventario(8, "meio");
        urukhai.adicionarItem(a);
        urukhai.ordenarItens();
       
        urukhai2.adicionarItem(aaa);
        urukhai2.adicionarItem(a);
         urukhai2.adicionarItem(aa);
       
        
        // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(urukhai2.getItens(), urukhai.getItens());
    }
    
      @Test
    public void orcOrdenarItensnegativo2() {
        // Arrange
        Orc urukhai = new Orc();
        Orc urukhai2 = new Orc();
        
        
        ItemDoInventario aaa=new ItemDoInventario(-1, "ultimo");
        urukhai.adicionarItem(aaa);
        
        ItemDoInventario aa=new ItemDoInventario(10, "primero");
        urukhai.adicionarItem(aa);

        ItemDoInventario a=new ItemDoInventario(8, "meio");
        urukhai.adicionarItem(a);
        
        ItemDoInventario aaaa=new ItemDoInventario(0, "meio");
        urukhai.adicionarItem(aaaa);
        
        ItemDoInventario aaaaa=new ItemDoInventario(-30, "meio");
        urukhai.adicionarItem(aaaaa);
        urukhai.ordenarItens();
       
        urukhai2.adicionarItem(aaaaa);
        urukhai2.adicionarItem(aaa);
        urukhai2.adicionarItem(aaaa);
        urukhai2.adicionarItem(a);
         urukhai2.adicionarItem(aa);
       
        
        // Act
        
        // Assert
       // ItemDoInventario pocao = urukhai.getItens().get(0);
        assertEquals(urukhai2.getItens(), urukhai.getItens());
    }
    
    

}










