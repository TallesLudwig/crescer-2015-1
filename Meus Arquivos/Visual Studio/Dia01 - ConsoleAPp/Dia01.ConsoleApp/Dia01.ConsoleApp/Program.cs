using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Dia01.ConsoleApp.DuendeVerde;
namespace Dia01.ConsoleApp
{
    class Program
    {
        private string _variavel;

        static void Main(string[] args)
        {

            #region dynamic
            dynamic oi = "se ta loco!";
            oi += 10;

            Console.WriteLine(oi);

            
            dynamic oi2 = new ExpandoObject();
            oi2.Saudacao = "Se ta loco!?";


            Console.WriteLine(oi2.Saudacao);
            #endregion


            #region Arraiiii

            var numeros = new[] { 1, 2, 3 }.ToList();
            numeros.Add(4);
            
            //List<int> numeros = new List<int>();
            //numeros.Add(1);
            //numeros.Add(2);
            //numeros.Add(3);
            //numeros.Add(4);


           // List<int> numeros = new List<int>(new [] {1 , 2 , 3});


            //var numeros = new List<int>(capacity: 10);


            foreach (var i in numeros) {
            
                Console.WriteLine(i);
                
            }

            //numeros.ForEach((i) =>
            //{
            //    Console.WriteLine(i);

            //});

            Action<int> imprimir = i => Console.WriteLine(i+ " Bacon");

            numeros.ForEach(imprimir);
            new[] { 5, 6, 7 }.ToList().ForEach(imprimir);
            new[] { 8, 9, 10 }.ToList().ForEach(imprimir);

          



            #endregion 



            #region Extension Methods

            Console.WriteLine("Ana".ToBacon(null));

            #endregion


            #region Jedi

            var yoda = new Jedi();
            yoda.Nome = "Yoda";
            yoda.Grau = Grau.MESTRE;


            var baconJedi = new
            {
                nome = yoda.Nome.ToBacon()
            };

            Console.WriteLine(yoda.Nome);

            #endregion


            #region data

            DateTime agora = new DateTime.Now;
            
            #endregion

            Console.ReadLine();
        }
    }
}
