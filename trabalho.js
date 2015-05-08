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


function somarPorNacionais(Array) {
	var concatenarBacon = function(i){
	 var soma = i.titulos[0].qtd+i.titulos[1].qtd+i.titulos[2].qtd
		return i + " titulos: " + soma;
	}
		
		return array.map(concatenarBacon);
}

somarPorNacionais(times);







