y === undefined
typeof y
"undefined"


typeof y === "undefined"
true

function isDefind(x){ return typeof x !== 'undefined'; }

isDefind(u)

/* Vai dar erro, nao declaramos o u*/

isDefind(x)


glaubersGripados.forEach(function(i) { console.log(i);});
-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-    MAP     *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
		utiliza a funçao para cada item do map



/* percorre um array e adiciona Bacon no final*/
function allBacon(array){
	var concatenarBacon = function(i){
		return i + " Bacon";
	}
	
	return array.map(concatenarBacon);
}
/* add o array*/
allBacon(['Talles', 'Lucas', 'Joao']); /*Resul == ["Talles Bacon", "Lucas Bacon", "Joao Bacon"]*/


-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*

/* percorre um array e adiciona Bacon no final dos pares e ja add o array na hora*/
var  allBacon = ( function (array) {
		var concatenarBacon = function(i , indice){
		
		
			return i + (indice % 2 == 0 ? " Bacon" : "");/* ternero(pode ser um IF)*/
		};
		
		return array.map(concatenarBacon);
})(['Talles', 'Lucas', 'Joao']);

allBacon; /*Resul == ["Talles Bacon", "Lucas", "Joao Bacon"]*/

-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-    REDUCE     *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*



var obj = { nome :'oi', idade: 15};

var obj2 = { nome :'oi2', idade :16};

var pessoas = [obj];

pessoas.push(obj2);


var soma = pessoas.map( function(i) {
	return i.idade;
})
.reduce(function(a, b) { 
return a + b;
});






-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-    Casses     *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*




function elfo(nome, flecha){

	this.nome= nome;
	this.flecha= flecha;
	this.experiencia = 0;
	
	this.atirrarFLecha= function(){
		this.flecha--;
		this.experiencia++;
		
	}
	
}

var kegolas= new elfo("elfo", 44);
































