import java.util.*;
/**
 * Write a description of class exercitoIntercalado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class estrategiaIntercalado
{
   private ArrayList<Elfo> ordemAtaque = new ArrayList<>();
    
    public void atacarOrcs(ArrayList<Elfo> elfos, ArrayList<Orc> orcs) {
        
        // garante que não ataca se a lista de elfos é vazia OU o exército não é proporcional (50%-50%)
        if (elfos.isEmpty() || !validarProporcoes(elfos)) {
            return;
        }
        
        intercalar(elfos);
        
        for (Elfo elfo : ordemAtaque) {
            for (Orc orc : orcs) {
                if (elfo != null)
                    elfo.atirarFlecha(orc);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemAtaque;
    }
    
    private boolean validarProporcoes(ArrayList<Elfo> elfos) {
        int contadorElfosVerdes = 0;
        int contadorElfosNoturnos = 0;
        
        for (Elfo elfoVouN : elfos) {
            if (elfoVouN instanceof ElfoVerde) {
                contadorElfosVerdes++;
            } else if (elfoVouN instanceof ElfoNoturno) {
                contadorElfosNoturnos++;
            }
        }
        
        return contadorElfosVerdes == contadorElfosNoturnos;
    }
    
    private void intercalar(ArrayList<Elfo> elfos) {     
        
        Elfo primeiroElfo = elfos.get(0);
        ordemAtaque.add(primeiroElfo);
        Class classeDoUltimoAdicionado = primeiroElfo.getClass();
        elfos.remove(primeiroElfo);

        while (elfos.size() > 0) {
            for (int j = 0; j < elfos.size(); j++) {
                Elfo elfoAtual = elfos.get(j);
                boolean estáIntercalado = elfoAtual.getClass() != classeDoUltimoAdicionado;
                
                if (estáIntercalado) {
                    ordemAtaque.add(elfoAtual);
                    classeDoUltimoAdicionado = elfoAtual.getClass();
                    elfos.remove(elfoAtual);
                }
            }
        }
    }
}
