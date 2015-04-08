import java.util.*;

/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */

import java.util.*;

public class Orc
{

    private int vida = 110;
    private String nome;

    private int experiencia;
    private Double Numero;
    private ArrayList<ItemDoInventario> Inventario = new ArrayList<ItemDoInventario>();
   // ArrayList<ItemDoInventario> Inventario = new ArrayList();
    private Status status = Status.Vivo;
    private ArrayList<ItemDoInventario> itens = new ArrayList<ItemDoInventario>();
    private final int NUMERO_SORTE = 3481;


    {
        //vida = 110;
        Numero=0.0;
        status= Status.Vivo;
        
    }
    
    /**
     * Construtor para objetos da classe Orc
     * 
     * */

         public Orc(String nome)
    {
        //vida = 110;
        this.nome = nome;
    }
    
    public Orc() {
    }

    
    /**
     * chama gerarNumero() para o teste de dano
     * gerarNumero<=0 nao toma dano e ganha XP
     * 0>gerarNumero<=100 nao leva dano
     * 100>gerarNumero leva 10 de dano
     */
    public void recebeAtaque() {

       
         if(vida<=0){
            status= Status.Morto;
        }
         
       if(gerarNumero()<=0){
             this.experiencia+=2;
       } else if (gerarNumero()>0 && gerarNumero()<=100){
        
        }else{
             this.vida -= 10;
        }

            /*
            double numeroGerado = gerarNumero();
            
            if (numeroGerado < 0) {
                this.experiencia += 2;
                return;
            } else if (numeroGerado >= 0 && numeroGerado <= 100) {
                return;
            } else {
                        
                int danoVida = 10;
                
                if (this.vida >= danoVida) {
                    this.vida -= danoVida;
                    // this.vida = this.vida - 10;
                    this.status = Status.FERIDO;
                } 
                
                if (this.vida == 0) {
                    this.status = Status.MORTO;
                }
            }
    
        }
        
        public String getNome() {
            return this.nome;
        }
        
        public int getExperiencia() {
            return this.experiencia;
        }
        
        public int getVida() {
            return this.vida;
                */
    }
  
    
    public Status getStatus() {
        return this.status;
    }
    
    public void setStatus(Status novoStatus) {
        this.status = novoStatus;
    }
    
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    
    public ArrayList<ItemDoInventario> getItens() {
        return this.Inventario;
    }
    
    /**
     * Adiciona um item ao inventário.
     * 
     * @param item Item a ser adicionado.
     */
    public void adicionarItem(ItemDoInventario item) {
        this.Inventario.add(item);
    }

    /**
     * Remove o item do inventário do orc.
     * 
     * @param item Item a ser perdido do inventário.
     */
    public void perderItem(ItemDoInventario item) {
        this.Inventario.remove(item);
    }
    
    /**
     * Imprime a vida atual do Orc.
     * 
     * @return String com a vida atual do orc. Ex:
     * 
     * "Vida atual: 110"
     */
    public String toString() {
        return "Vida atual: " + this.vida;
    }
    

    
    /**
     * gerarNumero para ver se o numero que o orc recebe dependendo do:
     * nome
     * status
     * vida
     * XP
     * Atuais;
     * 
     * Se o orc possuir nome e o mesmo tiver mais de 5 letras, some 65 ao número.
        Caso contrário, subtraia 60.
        
        B. Se o orc possuir vida entre 30 e 60, multiple o número por dois, senão se a
        vida for menor que 20 multiplique por 3.
        
        C. Se o orc estiver fugindo, divida o número por 2. Senão se o orc estiver
        caçando ou dormindo adicione 1 ao número.
        
        D. Se a experiência do orc for par, eleve o número ao cubo. Se for ímpar e o orc
        tiver mais que 2 de experiência, eleve o número ao quadrado.
        
        E. No método receberFlecha(), chame o método gerarNumero(). Caso o
        resultado seja menor que 0, o Orc não deverá receber a flecha e ainda
        ganhará 2 pontos de experiência. Senão se o número estiver entre 0 e 100 o
        Orc não recebe flechas e não recebe experiência. Caso contrário o Orc
        receberá a flechada (como está hoje).
      *
      *
      */   
    private Double gerarNumero(){
        this.Numero=0.0;
        if(this.nome !=null && this.nome.length()>5){
            this.Numero =this.Numero+65;
        } else {
         this.Numero =this.Numero-60;
        }
        
        if(this.vida>=30 && this.vida<=60){
            this.Numero =  this.Numero*2;
        }
        
        if(this.vida<=20){
            this.Numero =  this.Numero*3;
        }
        
         if(this.status==Status.Fugindo){
            this.Numero =  this.Numero/2;
        }
        
        if(this.status==Status.Cacando || this.status==Status.Dormindo){
            this.Numero =  this.Numero +1;
        }
                
        if(this.experiencia%2 == 0){
            this.Numero = Math.pow(this.Numero,3) ;
        } else if(this.experiencia>=2){
            this.Numero = Math.pow(this.Numero,2) ;
        }
        
        return this.Numero;
        
    }
    
   /**
    * mostra ex: Adaga,Escudo,Bracelete
    * sem epaço e sem ponto final
    * 
      */
    
    public String getDescricaoItens(){           
        StringBuilder builder= new StringBuilder();
        int numeroDeItens= this.Inventario.size();
        
        
           for (int i = 0; i <= this.Inventario.size()-1; i++) {
             builder.append(this.Inventario.get(i).getDescricao());
            if(i < this.Inventario.size()-1){
             builder.append(",");
            }  
                    
        }
        
             
        return builder.toString();
       
    }
    /**
     * Caso o Orc tenha sorte, adiciona 1000 quantidades para cada item do inventário.
     */
    public void tentarSorte() {
        
        double numeroGerado = gerarNumero();
        
        if (numeroGerado == NUMERO_SORTE) {
            for (ItemDoInventario item : this.itens) {
                int novaQuantidadeItem = item.getQuantidade() + 1000;
                item.setQuantidade(novaQuantidadeItem);
            }
        }
        
    }
    
    
    /**
     * setStatus
     */
    
  
    
    
   /**
    * Get/sets para testes
     */
    
   public void setXP(int xp){
        this.experiencia= xp;
    }
   public int  getXP(){
        return experiencia;
   }     
   public int getVida() {
      
       return this.vida;
   }
   public void setVida(int vida){
       this.vida= vida;
   }
   
   public ArrayList getInventario(){
       return this.Inventario;
   }

    public String getNome(){
       return this.nome;
   }
   
   
}

/**
 *  public String getDescricoesItens() {
        StringBuilder builder = new StringBuilder();
        
        /*
         * Utilizando for tradicional         
        int numeroDeItens = this.itens.size();

        for (int i = 0; i < numeroDeItens; i++) {
            ItemDoInventario itemAtual = this.itens.get(i);
            
            boolean éÚltimoÍndice = i == numeroDeItens - 1;
                        
            builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );
        }
        */
       
       // C#
       //foreach (ItemDoInventario item in this.itens) { }
       
       /*
        * Utilizando FOREACH!!
       for (ItemDoInventario itemAtual : this.itens) {
           int i = this.itens.indexOf(itemAtual);
           int numeroDeItens = this.itens.size();
           boolean éÚltimoÍndice = i == numeroDeItens - 1;
           
           builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
            );
       }
       */
      
      /*
       * JavaScript
      for (var i = 0, numeroDeItens = this.itens.size(); i < numeroDeItens; i++) {
      }
      */
      
     /*
      * WHILE (ENQUANTO)
      int i = 0;
      int numeroDeItens = this.itens.size();    

      while (i < numeroDeItens) {
          ItemDoInventario itemAtual = this.itens.get(i);
          boolean éÚltimoÍndice = i == numeroDeItens - 1;
           
          builder.append(
                éÚltimoÍndice ?
                itemAtual.getDescricao() :
                itemAtual.getDescricao() + ","
          );
          //
          i++;
      }
      
     
     int i = 0;
     int numeroDeItens = this.itens.size();
     do {
         if (numeroDeItens > 0) {
             ItemDoInventario itemAtual = this.itens.get(i);
              boolean éÚltimoÍndice = i == numeroDeItens - 1;
               
              builder.append(
                    éÚltimoÍndice ?
                    itemAtual.getDescricao() :
                    itemAtual.getDescricao() + ","
              );
         }
         i++;
     } while(i < numeroDeItens);
     
       return builder.toString();
    }

   */

    
