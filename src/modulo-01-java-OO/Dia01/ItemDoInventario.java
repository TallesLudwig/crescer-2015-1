
/**
 * Write a description of class ItemDoInventario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemDoInventario
{
    // instance variables - replace the example below with your own
    private int quantidade;
    private String descricao;

    /**
     * Constructor for objects of class ItemDoInventario
     * comtem descricao e quantidade do item.
     * 
     */
    public ItemDoInventario(int novaQuantidade, String novaDescricao)
    {
        this.quantidade= novaQuantidade;
        this.descricao= novaDescricao;
    }
     
    public int getQuantidade(){
        return this.quantidade;
    }
      
    public String getDescricao(){
        return this.descricao;
    }
}
