using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Models
{
    public class Enemy
    {

        public Enemy()
        {
            ID = Guid.NewGuid();
        }

        private Guid ID { get; set; }
        public string Name { get; set; }
        public string ImgURL { get; set; }
        public string Class { get; set; }
        public int HP { get; set; }
        public int Armor { get; set; }
        public int Damage { get; set; }
        public float BlockChance { get; set; }
        public float CriticalDamageChance { get; set; }

    }
}
