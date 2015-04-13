import java.util.*;

/**
 * Write a description of class ElfoVerd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{
    // instance variables - replace the example below with your own
    
    //private final  ArrayList<String> itens=new ArrayList<Strin>();

  
        
     
    {
       
        
    }
      /**
     * Constructor for objects of class ElfoVerd
     */
    
    public ElfoVerde(String nome , int flechas) {
        super(nome, flechas);

    }
    
    public ElfoVerde(String nome ) {
        super(nome, 42);

    }
    
     /**
     * Atira uma flecha e perde uma unidade.
     * experiencia*2
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atirarFlecha(Orc umOrc) {
        /*/flechas = flechas - 1;
        flechas--;
        experiencia++;
        experiencia++;
        
        umOrc.recebeAtaque();*/
        
        super.atirarFlecha(umOrc);
        experiencia++;
        
    }
    
    
     protected void adicionarItem(ItemDoInventario item) {
        boolean EspadaOuArco = item.getDescricao() == "Espada de aço valiriano" ||
         item.getDescricao() =="Arco e Flecha de vidro";
        if (EspadaOuArco) {
            super.adicionarItem(item);
          //  itens.add(item);
            
        }
        /*
        ArrayList<String> itensEsperados = new ArrayList();
        itensEsperados.add("Arco e Flecha de vidro");
        itensEsperados.add("Espada de aço valiriano");
        
        boolean existe = itenspermitido.contains("Espada de aço valiriano");
        if(existe){
            super.adicionarItem(item);
        }
        
        */
    }

  }
  
  //"Espada de aço valiriano" ou
  //“Arco e Flecha de vidro".
