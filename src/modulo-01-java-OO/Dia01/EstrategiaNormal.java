import java.util.*;

public class EstrategiaNormal implements EstrategiaDeAtaque
{
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Orc> orcs){
        System.out.println("estrategia normal");
     for(Elfo elfo : elfos){
       for(Orc orc : orcs){
            elfo.atirarFlecha(orc);      
        }
      }   
        
    }
   
}
