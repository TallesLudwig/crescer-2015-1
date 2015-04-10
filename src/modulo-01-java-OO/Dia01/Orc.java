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
   
    private Status status = Status.Vivo;
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
      *
      *
      */   
    public Double gerarNumero(){
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

         boolean experienciaPar = this.experiencia % 2 == 0;
        if (experienciaPar) {
            Numero = Numero * Numero * Numero;
        } else if (this.experiencia > 2) {
            Numero = Numero * Numero;
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
       Busca o ordenarItens Menor para maior,
       feito pelo bernardo, mais otimizado e simples
       porem faz a verificao^2(passando pelos dois for)
       */
    
    
    public void ordenarItens(){//ordInventario
      /*  for(int i = 0; i < this.Inventario.size(); i++){
            for(int j = 0; j < this.Inventario.size()-1; j++){
                ItemDoInventario itemAtual = this.Inventario.get(j);
                ItemDoInventario proximoItem = this.Inventario.get(j+1);
                
                boolean precisaTrocar= itemAtual.getQuantidade()> proximoItem.getQuantidade();
                
                if(precisaTrocar){
                    this.Inventario.set(j,proximoItem);
                    this.Inventario.set(j+1,itemAtual);
                }
             
            }
        }*/
        
      Collections.sort(this.Inventario, new Comparator<ItemDoInventario>(){
          public int compare(ItemDoInventario item, ItemDoInventario outroItem){
                return Integer.compare(item.getQuantidade(), outroItem.getQuantidade());
            
            }
        
        })  ;
        
    }
    
     /**
       Busca o ordenarItens Menor para maior,
       feito por mim, uma bagunça
       */
    public void ordenarItens1(){//ordInventario
        //ItemDoInventario menor= new ItemDoInventario(9000," ");
       ItemDoInventario menor= null;
       ItemDoInventario menor1= null;
       ArrayList<ItemDoInventario> ordInventario = new ArrayList<ItemDoInventario>();
        int posicao=-1;
        int tamanho=this.Inventario.size();
       
        
        while(ordInventario.size() != tamanho){
            menor = this.Inventario.get(0);
        
           
            for (int i = 0; i <= this.Inventario.size()-1; i++) {
          
             if(menor.getQuantidade() >= this.Inventario.get(i).getQuantidade() ){
                 posicao=i;
                 menor1= this.Inventario.get(i);
                 menor=menor1;
                }  
            }
            ordInventario.add(menor1);
                       
            this.Inventario.remove(this.Inventario.get(posicao));
            menor=null;
                                      
        }
        
        this.Inventario=ordInventario;
    }
    
      
 
    /**
       Busca o itemDoInventario com maior quantidade,
       caso o orc nao tenha item no inventario retorna null
       
       */
    public ItemDoInventario getItemComMaiorQuantidade() {
        
        ItemDoInventario itemMaiorQuantidade = null;
        
        boolean temItens = !this.Inventario.isEmpty();       
        if (temItens) {
            itemMaiorQuantidade = this.Inventario.get(0);
            
            for (int i = 1; i < this.Inventario.size(); i++) {
                ItemDoInventario itemAtual = this.Inventario.get(i);
                boolean encontreiAMaiorQuantidade =
                    itemAtual.getQuantidade() > itemMaiorQuantidade.getQuantidade();
                
                if (encontreiAMaiorQuantidade) {
                    // atualizar a minha referência para o maior parcial
                    itemMaiorQuantidade = itemAtual;
                }
            }
        }
        
        return itemMaiorQuantidade;
    }
    
 
    /**
     * Caso o Orc tenha sorte, adiciona 1000 quantidades para cada item do inventário.
     */
    public void tentarSorte() {
        
        double numeroGerado = gerarNumero();
        
        if (numeroGerado == NUMERO_SORTE) {
            for (ItemDoInventario item : this.Inventario) {
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
   
   
}


