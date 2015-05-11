 function brewdog(StringUm, StringDois){
	var numDifer= 0;
	
	
	if (StringUm.length >=StringDois.StringDois){
		var tamanhoMinimo =StringUm.length;
	}else{
		var tamanhoMinimo =StringDois.length;
	}	
	
	for( i=0; i<tamanhoMinimo; i++) {
		if( StringUm.toUpperCase().charAt(i) != StringDois.toUpperCase().charAt(i)){
			
			numDifer= numDifer+ 1;
		} 
	
	}
	
	return numDifer;
		
  }
  

[
    { params: ['american ipa','american ipa'],                        esperado: 0 },
    { params: ['russian imperial stout','russian imperial vodka'],    esperado: 5 },
    { params: ['1002012','dfgdf12'],                                  esperado: 5 },
    { params: ['k4rol1n','k4thr1n'],                                  esperado: 3 },
    { params: ['a1df222266%334op;','ssdfjfdkjgsdfgofdgudf9g8dufsg'],  esperado: 26 },
  ].forEach(
    function(ct) {
      var res = brewdog(ct.params[0], ct.params[1]);
      console.assert(res === ct.esperado, 'Errooooou! CT:', ct.params, 'Esperado:', ct.esperado, 'Obtido:', res);
    }
  );
  
  /*2b*/
  
  
  function Emprestimo(valorTotal, juros, quantidadeParcelas){

	this.valorTotal= valorTotal;
	this.juros= juros;
	this.quantidadeParcelas = quantidadeParcelas || 3;
	
	this.valorParcela= function(){
		var a=	this.valorTotal*this.juros;
		var b = 1/ Math.pow( 1+this.juros ,this.quantidadeParcelas);	
		
		var final1 = a/(1-b);
		//return final1.toFixed(2); MUITO DEMORADO. FAZER O .ROUND *100 / 100
		return Math.round(final1* 100)/100;
	}
	
		this.valorTotalJuros =function(){
		 
		 
		 
	}	
	
	
}


 [
    { emprestimo: new Emprestimo(1000, 0.03, 4),  esperado: 269.03 },
    { emprestimo: new Emprestimo(1800, 0.05, 8),  esperado: 278.50 },
    { emprestimo: new Emprestimo(500, 0.05),      esperado: 183.60 },
  ].forEach(
    function(ct) {
      var res = ct.emprestimo.valorParcela();
      console.assert(res === ct.esperado, 'Errooooou! CT:', ct.emprestimo, 'Esperado:', ct.esperado, 'Obtido:', res);
    }
  );
  
  
    
  /*2c*/
  
  
    
  function Emprestimo(valorTotal, juros, quantidadeParcelas){

	this.valorTotal= valorTotal;
	this.juros= juros;
	this.quantidadeParcelas = quantidadeParcelas || 3;
	
	this.valorParcela= function(){
		var a=	this.valorTotal*this.juros;
		var b = 1/ Math.pow( 1+this.juros ,this.quantidadeParcelas);	
		
		var final1 = a/(1-b);
		return Math.round(final1* 100)/100;
		
	}
	
	this.valorTotalJuros =function(){
		
		var total=(this.valorParcela()-this.valorTotal/this.quantidadeParcelas)*this.quantidadeParcelas;
		return Math.round(total* 100)/100;
		 
	}	
	
	
}


 [
    // no teste abaixo a pessoa morreu pagando juros...
    { emprestimo: new Emprestimo(1800, 0.13, 8),  esperado: 1200.8 },
    { emprestimo: new Emprestimo(1000, 0.03, 4),  esperado: 76.12 },
    { emprestimo: new Emprestimo(500, 0.05),      esperado: 50.8 },
  ].forEach(
    function(ct) {
      var res = ct.emprestimo.valorTotalJuros();
      console.assert(res === ct.esperado, 'Errooooou! CT:', ct.emprestimo, 'Esperado:', ct.esperado, 'Obtido:', res);
    }
  );
  
  
  
  
  
  
  
  
  
  
  
  
  /*3*/
  
   function palindromo(String){
    var palindroma = true;
   
	pal = String.toLowerCase();
	
	pal = pal.split(' ').join('')//replace(" ", "");
	pal = pal.replace(/[@$1234567890©`´~!@#$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/]/gi, "");
	pal=  pal.replace(/[âáàã]/gi,"a");
	pal = pal.replace(/[éèê]/gi,"e");
	pal = pal.replace(/[íìî]/gi,"i");
	pal = pal.replace(/[ôõóò]/gi,"o");
	pal = pal.replace(/[úùû]/gi,"u");
	pal = pal.replace("ç","c");
  
  
  
    for(var i = 0; i < (pal.length / 2); i++){
      if(pal.charAt(i) != pal.charAt(pal.length - i - 1))
        palindroma = false;
    }
	
	var iluminatti = ['bacon','verdemusgo','dante','ledesma','iluminatti'];
	
	if(iluminatti.indexOf(pal)!==-1){
		palindroma =  true;
	}
	
	
    return palindroma;
  }
  
  [
    { teste: 'ovo',                                         esperado: true },
    { teste: 'ôvo',                                         esperado: true },
    { teste: 'arara',                                       esperado: true },
    { teste: 'rodador',                                     esperado: true },
    { teste: 'O tRoTe ToRtO',                               esperado: true },
    { teste: 'bacon',                                       esperado: true },
    { teste: 'A miss é péssima!',                           esperado: true },
    { teste: 'VERDE musgo!!',                               esperado: true },
    { teste: 'Nova Schin, cervejão!',                       esperado: false },
    { teste: 'camigoal',                                    esperado: false },
    { teste: 'Ledesma@@@@@@@@',                             esperado: true },
    { teste: '!!d@ante!?!?',                                esperado: true },
    { teste: '1@ilu$$$m1in$$$$$$$$$$4att$$$$$$$$1i!!!!!',   esperado: true }
  ].forEach(
    function(ct) {
      var res = palindromo(ct.teste);
      console.assert(res === ct.esperado, 'Errooooou! CT:', ct.teste, 'Esperado:', ct.esperado, 'Obtido:', res);
    }
  );