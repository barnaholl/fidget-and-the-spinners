using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services.CustomLogObj
{
    public class ArenaFightLog
    {
        public string DamageDealer { get; set; }
        public int DealtDMG { get; set; }
        public int Player1HealthPoint { get; set; }
        public int Player2HealthPoint { get; set; }

        public override string ToString()
        {
            return $"{DamageDealer} dealt {DealtDMG} to its opponent!";
        }
    }
}
