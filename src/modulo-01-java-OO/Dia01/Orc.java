/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110;
    private Status status;
    {
        status = Status.Vivo;
    }
    
    /**
     * Construtor para objetos da classe Orc
     */
     
    public Orc(){
        if(this.vida<=0){
            status = Status.morto;
        }
      }
    
    
    /**
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
        this.vida -= 10;
        // this.vida = this.vida - 10;
    }
    
    public int getVida() {
        return this.vida;
    }
}
