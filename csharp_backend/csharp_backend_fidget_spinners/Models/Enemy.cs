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
            ID = Guid.NewGuid();
            RNG = new Random();
        }

        private Guid ID { get; set; }
        public string Name { get; set; }
        public string ImgURL { get; set; }
        public EnemyClassENUM Class { get; set; }
        public int HP { get; set; }
        public int Armor { get; set; }
        public int Damage { get; set; }
        public float BlockChance { get; set; }
        public float CriticalDamageChance { get; set; }

        public int CalculateEnemyDMG()
        {
            int damage = Damage;

            if (RNG.Next(0, 100) > 85)
            {
                damage *= 2;
            }

            return damage;
        }

    }
}
