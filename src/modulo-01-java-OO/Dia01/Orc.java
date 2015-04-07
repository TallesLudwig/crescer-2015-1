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
    private int experiencia, Numero;

    {
        //vida = 110;
        Numero=0;
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
     * Faz o Orc sofrer um ataque.
     * Atualmente 10 de dano será decrementado.
     */
    public void recebeAtaque() {
       
         if(vida<=0){
            status= Status.Morto;
        }
       int numeroteste=gerarNumero();    
       if(numeroteste<=0){
             this.experiencia+=2;
       } else if (numeroteste>0 && numeroteste<=100){
        
        }else{
             this.vida -= 10;
        }
    }
    
    public int getVida() {
      
        return this.vida;
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
    /**Se o orc possuir nome e o mesmo tiver mais de 5 letras, some 65 ao número.
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
    private int gerarNumero(){
        //this Numero=0;
        if(this.nome.length()>=5){
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
            
            this.Numero =  this.Numero*this.Numero*this.Numero;
        }
         else if(this.experiencia% 2 != 0 &&  this.experiencia>2){
            this.Numero =  this.Numero*this.Numero;
            
        }
        return this.Numero;
        
    }
    
    public String setStatus(String novoStatus) {
    if (novoStatus=="Cacando") {  
        this.status= Status.Cacando;
    }
    if (novoStatus=="Fugindo") {  
        this.status= Status.Fugindo;
        }
    if (novoStatus=="Dormindo") {  
        this.status= Status.Dormindo;
        }
        return novoStatus;

    }
   
}
