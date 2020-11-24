using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Models
{
    //Our Character in the game!!
    public class Character
    {
        public int ID { get; set; }
        public string Name { get; set; }
        public int CharacterLevel { get; set; }
        //HP
        public int MotivationLevel { get; set; }
        public int Energy { get; set; }
        public int ProblemSolving { get; set; }
        public int Design { get; set; }
        public int Algorithm { get; set; }
        public int Testing { get; set; }

    }
}
