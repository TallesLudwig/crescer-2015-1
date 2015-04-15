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
    
    /**
     * tentativa do exerc, baseado no que o gabriel tenha mostrado.
     * 
    */
  public  HashMap<Status, Elfo> buscarStatus(Status status){
        HashMap<Status, Elfo> statusExercito= new HashMap<>();  
        
        for(String nome : Exercito.keySet()){
            Status statusAtual = Exercito.get(nome).getStatus();
            boolean teste = statusAtual == status;
            if(teste){
               statusExercito.put(statusAtual, Exercito.get(nome));
                
            }
        
        }
        return statusExercito;
    }
    
    
      
   
       
   }
    
    



//recebe um staus por parametro e agrupa esses