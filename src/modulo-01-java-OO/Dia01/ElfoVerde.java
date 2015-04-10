
/**
 * Write a description of class ElfoVerd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{
    // instance variables - replace the example below with your own

 
    /**
     * Constructor for objects of class ElfoVerd
     */
    public ElfoVerde(String umNome, int flechas)
    {
        this(umNome);
        // this.nome = nome;
         
    }
        
      /**
     * Constructor for objects of class ElfoVerd
     */
    
    public ElfoVerde(String nome) {
        super(nome, 0);
    }
    
     /**
     * Atira uma flecha e perde uma unidade.
     * experiencia*2
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        //flechas--;
        experiencia++;
        experiencia++;
        
        umOrc.recebeAtaque();
    }

  }
