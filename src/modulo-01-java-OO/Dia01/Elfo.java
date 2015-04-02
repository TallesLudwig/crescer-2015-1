
/**
 * Define objetos Elfo
 * 
 * @author CWI Software
 */
public class Elfo
{
    // Versão correção do tema!!
    
    private String nome;
    private int flechas, experiencia;
    // type initializer
    {
        flechas = 42;
    }
    
    /**
     * Cria objetos Elfo
     * 
     * @param umNome Nome que o elfo receberá
     * @param flechas Quantidade inicial de flechas
     */
    public Elfo(String umNome, int flechas)
    {
        this(umNome);
        // this.nome = nome;
        this.flechas = flechas;
    }
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    /**
     * Atira uma flecha e perde uma unidade.
     * chamando um orc,tomaFlecha();
     */
    public void atirarFlecha(Orc umOrc) {
       
        flechas--;
        experiencia++;
        umOrc.tomaFlecha();
    }
    
 
    
     
    
    
    
    //ublic void setNome(String novoNome) {
      //  nome = novoNome;
    //}
    
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
    
    
    
    
    
}
