'use strict';

$(function() {
  var ul = $('#capas-maiden');
  var URL = 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50';
  var jaAdicionados = [];
  $.ajax({
    url: URL,
    type: 'GET'
  }).done(function(response) {
    response.items.forEach(function(i) {
      // lembram do Array.prototype.contains? poderíamos utilizar aqui..
      if (jaAdicionados.indexOf(i.name.toLowerCase()) === -1) {
        ul.append(
          $('<li>').append(
            $('<img>').attr('src', i.images[1].url)
          )
        );
        console.log(i.name);
        jaAdicionados.push(i.name.toLowerCase());
      }
    });
  });
});