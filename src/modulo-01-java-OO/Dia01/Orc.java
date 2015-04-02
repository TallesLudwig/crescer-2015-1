
/**
 * Escreva a descrição da classe Orcs aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Orc
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private int vida =110;

      /**
     * COnstrutor para objetos da classe Orcs
     */
    public Orc()
    {       
    }

    /* Orc toma 10 dano
     *  
     */
       public void tomaFlecha()
    {
      vida=vida - 10;
    }
    
    public int getVida()
    {
           return this.vida;
    }
    
    
}
