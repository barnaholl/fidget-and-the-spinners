using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services.CustomLogObj
{
    public class FightLog
    {
        public string DamageDealer { get; set; }
        public int DealtDMG { get; set; }

        public int OurHealthPoint { get; set; }

        public int EnemyHealthPoint { get; set; }

        public override string ToString()
        {
            return $"{DamageDealer} dealt {DealtDMG} to its opponent!";
        }
    }
}
