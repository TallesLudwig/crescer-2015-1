import java.util.*;
/**
 * Abstração para um exército de Elfos.
 * 
 * @author CWI Software
 */
public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> porStatus = new HashMap<>();
    
    public HashMap<String, Elfo> getExercito() {
        return this.exercito;
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoPorStatus() {
        return this.porStatus;
    }
    
    /**
     * Alista o elfo no exército para que seja utilizado em batalha.
     * 
     * @param elfo Elfo a ser alistado no exército. Deve ser apenas do tipo ElfoVerde ou ElfoNoturno
     */
    public void alistar(Elfo elfo) throws ErrorAlistarException{
        
        boolean podeAlistar = elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        
        if (podeAlistar) {
            exercito.put(elfo.getNome(), elfo);
        } else{
            throw new ErrorAlistarException();
        }  
        
    }
    
    /**
     * Busca um elfo no meio do exército, a partir do seu nome.
     * 
     * @param nome Nome do elfo para utilizar na busca.
     * @return Elfo Resultado da busca pelo nome. Caso não encontre nada retorna null.
     */
    public Elfo buscar(String nome) {
        return exercito.get(nome);
    }
    
    public ArrayList<Elfo> buscar(Status status) {
        agruparPorStatus();
        return porStatus.get(status);
    }
    
    /**
     * Agrupa os elfos do exército utilizando o campo status dos objetos.
     */
    public void agruparPorStatus() {
        
        porStatus.clear();
        
        for (Map.Entry<String, Elfo> parChaveValor : exercito.entrySet()) {
            Elfo elfo = parChaveValor.getValue();
            Status status = elfo.getStatus();
            
            if (porStatus.containsKey(status)) {
                porStatus.get(status).add(elfo);
            } else {
                porStatus.put(status, new ArrayList<>(
                    Arrays.asList(elfo)
                ));
                // C#
                // var arr = new [] { elfo, elfo1, elfo2, elfo3 };
            }
        }
    }
     /**
     * tentativa do exerc, baseado no que o gabriel tenha mostrado.
     * 
    *
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
     }*/
    

}







