import java.util.*;
/**
 * Write a description of class ExercitoDeElfos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExercitoDeElfos
{
    private HashMap<String, Elfo> Exercito= new HashMap<>();  
    
    public HashMap<String, Elfo> getExercito(){
        return this.Exercito;
    }
    
    public void alistar(Elfo elfoNovo){
       boolean podeAlistar=  elfoNovo instanceof ElfoVerde ||  elfoNovo instanceof ElfoNoturno ;
      if(podeAlistar){
         Exercito.put(elfoNovo.getNome(), elfoNovo);      
           
      }  
   }
   
   
   public Elfo buscar(String nome){
       return Exercito.get(nome);
    }
    
   public /*HashMap<String, Elfo>*/ Elfo buscarStatus(Elfo elfoNovo){
      
       return Exercito.get(elfoNovo.getStatus().getValue(elfoNovo.getStatus()));
    }
       
   }
    
    



//recebe um staus por parametro e agrupa esses