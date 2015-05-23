
# Desafio Karate Kid
![image](https://cloud.githubusercontent.com/assets/2975955/7783460/d199c6b8-0119-11e5-8c23-3264263e3dca.png)

**Mestre Miyagi está precisando de ajuda no seu sítio. Você será capaz de ajudá-lo?**

1. Mestre Miyagi precisa de ajuda para realizar uma série de tarefas. Caso você consiga realizar todas as tarefas dentro de um dia, você ganhará o carro do mestre, como recompensa pelo esforço.
2. Para receber as tarefas, primeiro é necessário ser cordial e se apresentar para o senhor Miyagi. Para isto, faça uma requisição do tipo `POST` para `/apresentar`, passando seu nome através da query string. Exemplo abaixo.
3. O Mestre Miyagi irá te dar um apelido em japônes após a sua apresentação. Você deve passar este apelido como ~~token~~ para obter as tarefas (ex.: `GET /tarefas?nome=丟乞乸伍佋仃伧享亾`)
4. Cada dia dura 24 segundos. Você terá este tempo para concluir as tarefas recebidas pelo senhor Miyagi. Caso você não conclua as tarefas dentro deste tempo, os métodos retornarão um erro e você terá que se apresentar novamente.
5. Para realizar uma tarefa, basta fazer um POST (sem parâmetros) para a URL associada a tarefa. Cada tarefa possui uma URL única e as tarefas mudam cada vez que você inicia um novo dia. 
6. Há mais um problema: cada uma das 3 tarefas demora cerca de 10 segundos para executar (totalizando 30 segundos). Dessa forma, elas **precisam ser executadas em paralelo**, ou você não vai conseguir realizar todas as tarefas em um dia.
7. Quando todas as 3 tarefas forem concluídas é preciso avisar o Mestre Miyagi, fazendo um `POST` para `/acabei` (passando seu nome em japônes). 

**Para começar: Acesse http://karatekid.instaweb.com.br:4567/ e siga as instruções.**

Foto do carro do Mestre Miyagi:

![image](https://cloud.githubusercontent.com/assets/2975955/7783555/704df822-011c-11e5-8347-f75a6d90f09c.png)
