using csharp_backend_fidget_spinners.Models.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Models
{
    public class Enemy
    {

        private Random RNG;

        public Enemy()
        {
            ID = 12345;
            RNG = new Random();
        }

        private int ID { get; set; }
        public string Name { get; set; }
        public string ImgURL { get; set; }
        public EnemyClassENUM Class { get; set; }
        public int HP { get; set; }
        public int Armor { get; set; }
        public int Damage { get; set; }
        public int CompilerErrorChance { get; set; }
        public int RuntimeErrorChance { get; set; }

        public virtual int CalculateEnemyDMG(int opponentsBlockChance)
        {
            int percentageForLittleChance = 100;
            int percentageForHigherChance = 10;

            if (GetRandomValue(percentageForLittleChance) < opponentsBlockChance) return 0;

            int damage = Damage + GetRandomValue(percentageForHigherChance);

            if (GetRandomValue(percentageForLittleChance) > 85)
            {
                damage *= 2;
            }

            return damage;
        }

        public virtual int GetRandomValue(int maxValue)
        {
            return RNG.Next(0, maxValue);
        }


    }
}
