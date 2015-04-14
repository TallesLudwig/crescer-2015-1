
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo
{
    
    
    // instance variables - replace the example below with your own
     public ElfoNoturno(String nome , int flechas) {
        super(nome, flechas);

    }
    
    public ElfoNoturno(String nome ) {
        super(nome, 42);

    }
    
     /**
     * Atira uma flecha e perde uma unidade.
     * experiencia*2
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atirarFlecha(Orc umOrc) {
           
        super.atirarFlecha(umOrc);
        experiencia++;
        experiencia++;
        
        double vidaPerder = this.vida * 0.05;
        this.vida -= vidaPerder;
        atualizarStatus();
        
    }
    
    public void testevida(Orc umOrc){
        int i=0;
        while(this.vida>0){
            i++;
            super.atirarFlecha(umOrc);
            experiencia++;
            experiencia++;
        
            double vidaPerder = this.vida * 0.05;
            this.vida -= vidaPerder;
            atualizarStatus();
        }
        System.out.println(i);
    }
    
    
    public String toString(){
        return "Elfo noturno: " + super.toString();
    }


}
