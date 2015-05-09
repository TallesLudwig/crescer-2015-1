var Chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 5 },
    { desc: 'Continentais', qtd: 1 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var Arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 13 },
    { desc: 'Continentais', qtd: 0 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};
var Liverpool = {
  nome: 'Liverpool Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 18 },
    { desc: 'Continentais', qtd: 5 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};
var Manchester = {
  nome: 'Manchester United Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 20 },
    { desc: 'Continentais', qtd: 3 },
    { desc: 'Mundiais', qtd: 1 }
  ]
};

var times = [Chelsea ,  Liverpool, Arsenal,  Manchester];




/*Crie uma função chamada ordenaPorNacionais(Array) que recebe o array de clubes e retorna o
 array ordenado pela quantidade de títulos Nacionais descendente (Z->A).*/
  
 function ordenaPorNacionais(array){
 
	array.sort(function(a, b) {return a.titulos[0].qtd>b.titulos[0].qtd});

	return array;
 }


ordenaPorNacionais(times);





/*Crie uma função chamada ordenaPorContinentais(Array) que recebe o array de clubes e 
retorna o array ordenado pela quantidade de títulos Continentais descendente (Z->A).*/


 function ordenaPorContinentais(array){
 
	array.sort(function(a, b) {return a.titulos[1].qtd > b.titulos[1].qtd});

	return array;
 }


ordenaPorContinentais(times);


/*Crie uma função chamada ordenaPorMundiais(Array) que recebe o array de clubes e retorna o
 array ordenado pela quantidade de títulos Mundiais descendente (Z->A).*/

 
 function ordenaPorMundiais(array){
 
	array.sort(function(a, b) {return a.titulos[2].qtd > b.titulos[2].qtd});

	return array;
 }


ordenaPorMundiais(times);







/*Crie uma função chamada somarPorNacionais(Array) que recebe o array de clubes e retorna o somatório
 de todas quantidades de títulos nacionais entre os clubes do array.*/


 

  function somarPorNacionais(array){
 
	var Soma =  array.map( function(i)  { return i.titulos[0].qtd; }).reduce(function(a, b) {return a + b;});


	
	return "Soma dos titulos nacionais:"+Soma;
 }


somarPorNacionais(times);



/*Crie uma função chamada somarPorContinentais(Array) que recebe o array de clubes e retorna o somatório
 de todas quantidades de títulos continentais entre os clubes do array.*/  
 
 function somarPorContinentais(array){
 
	var Soma =  array.map( function(i)  { return i.titulos[1].qtd; }).reduce(function(a, b) {return a + b;});


	
	return "Soma dos titulos Continentais:"+Soma;
 }


somarPorContinentais(times);







/*Crie uma função chamada somarPorTodosTitulos(Array) que recebe o array de clubes e retorna o somatório 
de todas quantidades de todos os títulos entre os clubes do array.*/



 function somarPorTodosTitulos(array){
	var total =0;
 
 
	 for (a = 0; a < 3; a++) {
	 var Soma =  array.map( function(i)  { return i.titulos[a].qtd; }).reduce(function(a, b) {return a + b;});
	 total = total + Soma;
	}
 
	

	
	return "Soma dos titulos:"+total;
 }


somarPorTodosTitulos(times);









/*escreva uma função chamada apenasOsMelhores(Array) que recebe o array de clubes e retorna apenas os clubes que 
têm mais de 18 títulos ingleses.*/





 function apenasOsMelhores(array){
	var filtered = array.filter(function(i) { return i.titulos[0].qtd > 18; });
	return filtered;
 }




apenasOsMelhores(times);



/*Escreva uma função chamada apenasOsMelhoresParaJSON(Array) que recebe o array dos clubes que têm mais de 18 títulos
 ingleses e retorna a representação JSON deles.*/
 
 
  function apenasOsMelhoresParaJSON(array){
	var filtered = array.filter(function(i) { return i.titulos[0].qtd > 18; });

	return 	JSON.stringify(filtered);
 }





apenasOsMelhoresParaJSON(times);




/*Escreva uma função chamada apenasOsMelhoresRecebendoJSON(String) que recebe uma String no formato JSON e retorna o 
Array de objetos JavaScript.*/
 
  function apenasOsMelhoresRecebendoJSON(String){
	  
	
	
		var jsonObj = JSON.parse(String);
		
 return jsonObj;


 }

apenasOsMelhoresRecebendoJSON(apenasOsMelhoresParaJSON(times));







