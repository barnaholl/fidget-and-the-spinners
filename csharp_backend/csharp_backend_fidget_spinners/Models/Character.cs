using csharp_backend_fidget_spinners.Models.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Models
{
    //Our Character in the game!!
    public class Character
    {
        private Random RNG;

        public Character()
        {
            RNG = new Random();
        }

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
        public int CleanCode { get; set; }
        public int BlockChance { get; set; }
        public int CriticalDamageChance { get; set; }

        public int CalculateDamage(int opponentsBlockChance)
        {
            if (RNG.Next(0, 100) < opponentsBlockChance) return 0;

            int damage = 10 + RNG.Next(0, 10);
            damage += Convert.ToInt32(Design * 1.5);
            damage += Convert.ToInt32(ProblemSolving * 1.5);
            damage += Convert.ToInt32(Testing * 1.5);
            damage += Convert.ToInt32(Algorithm * 1.5);
            damage += Convert.ToInt32(CleanCode * 1.5);

            if (RNG.Next(0, 100) > CriticalDamageChance)
            {
                damage *= 2;
            }

            return damage;
        }

    }
}
