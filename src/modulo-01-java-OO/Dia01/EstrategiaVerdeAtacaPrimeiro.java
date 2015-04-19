import java.util.*;
/**
 * Write a description of class EstrategiaVerdeAtacaPrimeiro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaVerdeAtacaPrimeiro implements EstrategiaDeAtaque
{
    // instance variables - replace the example below with your own
   
    private ArrayList<Elfo> ordem = new ArrayList<>();
     public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        ordemDosElfos(elfos);
       
        
        for (Elfo elfo : elfos) {
            ordem.add(elfo);
                for (Orc orc : orcs) {
                    elfo.atirarFlecha(orc);
                }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordem;
    }
    
    private void ordemDosElfos(ArrayList<Elfo> elfos) {
        
        boolean houverTroca = true;
        while (houverTroca) {
            houverTroca = false;
                for (int i = 0; i < elfos.size() - 1; i++) {
                    
                    Elfo elfoAtual = elfos.get(i);
                    Elfo elfoProximo = elfos.get(i + 1);
                    
                    
                    
                    
                    if (elfoAtual instanceof ElfoNoturno && elfoProximo instanceof ElfoVerde) {
                        elfos.set(i, elfoProximo);
                        elfos.set(i + 1, elfoAtual);
                        houverTroca = true;
                    }
                    
                }
            
        }
        
        //return or
    }
    }
