
/**
 * Define objetos Elfo
 * 
 * @author CWI Software
 */
public class Elfo extends Personagem
{
    // Versão correção do tema!!
    private int flechas;
    private static int contadorDeElfos;


    // type initializer
    {
        flechas = 42;
        vida = 100;

        contadorDeElfos++;

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
    
    /**
     * Cria um elfo informando nome.
     * 
     * @param nome Nome a ser dado para o Elfo.
     */
    public Elfo(String nome) {
        super(nome, 0);

    }
    
    /**
     * Atira uma flecha e perde uma unidade.
     * 
     * @param umOrc Orc que receberá uma flechada.
     */
    public void atirarFlecha(Orc umOrc) {
        //flechas = flechas - 1;
        flechas--;
        experiencia++;
        umOrc.recebeAtaque();
        status=Status.ATACANDO;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public int getFlechas() {
        return this.flechas;
    }
    /*public void setFlechas(int novaQtdFlechas) {
        if (novaQtdFlechas > flechas) {
            flechas = novaQtdFlechas;
        }
    }*/
    
    // camelCase: public void atirarFlechaDourada
    // PascalCase: public void AtirarFlechaDourada
    
    /**
     * Retorna o nome do elfo, sua quantidade de flechas e seus níveis de experiência.
     * 
     * @return Informações gerais sobre o elfo, ex:
     * 
     * "Legolas possui 42 flechas e 0 níveis de experiência."
     */
    public String toString() {
        
        /*StringBuilder builder = new StringBuilder();
        
        builder.append(
            String.format("%s possui %d %s e %d %s de experiência.",
                this.nome,
                this.flechas,
                this.flechas == 1 ? "flecha" : "flechas",
                this.experiencia,
                this.experiencia == 1 ? "nível" : "níveis"
            )
        );

        return builder.toString();
        
        */
        
        return String.format("%s possui %d %s e %d %s de experiência.",
                this.nome,
                this.flechas,
                this.flechas == 1 ? "flecha" : "flechas",
                this.experiencia,
                this.experiencia == 1 ? "nível" : "níveis"
            );
       
        // Ruby ou CoffeeScript:
        //"#{nome} possui #{flechas} #{textoFlechas} e #{experiencia} #{textoNiveis} de experiência."
       
        // C# null-coalsing:
        // String texto = this.nome ?? "Sem Nome";
                
        /*if (this.flechas == 1) {
            textoFlechas = "flecha";
        } else {
            textoFlechas = "flechas";
        }*/
        
        /*builder.append(this.nome);
        builder.append(" possui ");
        builder.append(this.flechas);
        builder.append(" ");
        builder.append(textoFlechas);
        builder.append(" e ");
        builder.append(this.experiencia);
        builder.append(" ");
        builder.append(textoNiveis);
        builder.append(" de experiência.");*/
    }
    

     public static int getContadorDeElfos(){
         return contadorDeElfos;
         
        }
        
    public static void limpaContadorDeElfos(){
         contadorDeElfos=0;
        }
        
         /**
     * Verifica se dois elfos são iguais.
     * Critério atual: ter o mesmo nome.
     * 
     * @param outro Outro objeto elfo a ser comparado.
     * @return boolean Verdadeiro caso sejam iguais. Falso caso contrário.
     */
    @Override
    public boolean equals(Object outro) {
        return ((Elfo)outro).getNome().equals(this.nome);
    }
}
    
  
