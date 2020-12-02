using csharp_backend_fidget_spinners.Models.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Models
{
    //Our Character in the game!
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
        public int DebugChance { get; set; }
        public int FastCoding { get; set; }

        public int CalculateDamage(int opponentsBlockChance, EnemyClassENUM _class)
        {
            if (RNG.Next(0, 100) < opponentsBlockChance) return 0;

            int damage = 10 + RNG.Next(0, 10);

            damage += Design + ProblemSolving + Testing + Algorithm + CleanCode;

            switch (_class)
            {
                case EnemyClassENUM.Frontend:
                    damage += Design * 2 + CleanCode;
                    break;
                case EnemyClassENUM.Backend:
                    damage += ProblemSolving * 2 + Algorithm * 2;
                    break;
                case EnemyClassENUM.DevOps:
                    damage += Convert.ToInt32(ProblemSolving * 1.5 + Testing);
                    break;
                case EnemyClassENUM.Testing:
                    damage += Testing * 2 + CleanCode;
                    break;
            }

            if (RNG.Next(0, 100) > FastCoding)
            {
                damage *= 2;
            }

            return damage;
        }

    }
}
