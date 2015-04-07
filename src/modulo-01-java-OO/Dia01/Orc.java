/**
 * Define objetos do tipo Orc
 * 
 * @author CWI Software
 */
public class Orc
{
    private int vida = 110;
    private Status status;
    private String nome;
    private int experiencia;
    private Double Numero;

    {
        //vida = 110;
        Numero=0.0;
        status= Status.Vivo;
    }
    
    /**
     * Construtor para objetos da classe Orc
     * 
     * */
    public Orc(String umNome)
    {
      this.nome = umNome;
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
        
        if(this.experiencia%2 == 0 && this.experiencia>0 ){
            Math.pow(this.Numero,3) ;
            
        }
         else if(this.experiencia% 2 != 0 &&  this.experiencia>2){
            Math.pow(this.Numero,2) ;
        }
        return this.Numero;
        
    }
    
    /**
     * setStatus
     */
    
    public void setStatus(Status novoStatus) {
        this.status= novoStatus;
    }
    
    
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
}
