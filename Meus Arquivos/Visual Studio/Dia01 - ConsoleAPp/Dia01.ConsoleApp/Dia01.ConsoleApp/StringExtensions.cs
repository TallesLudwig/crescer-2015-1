using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Dia01.ConsoleApp.DuendeVerde
{
    internal static class StringExtensions
    {
       internal static string ToBacon(this string str, bool? uppercase = true) {

           if (uppercase.HasValue && uppercase.Value) {
               return str + " BACON!!!";
           }
           else {
               return str + " bacon!!!";
           }

        }
    }
}
