using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.CustomLogObj;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services
{
    public class ArenaSimulator : IArenaFightSimulator
    {

        private Character Player1;
        private Character Player2;
        private List<ArenaFightLog> FightLog;

        public Task<List<ArenaFightLog>> ArenaFight(Character player1, Character player2)
        {
            throw new NotImplementedException();
        }



        private void LogRounds(string attackersName, int damageDealt)
        {
            FightLog.Add(new ArenaFightLog
            {
                DamageDealer = attackersName,
                DealtDMG = damageDealt,
                Player1HealthPoint = Player1.MotivationLevel,
                Player2HealthPoint = Player2.MotivationLevel
            });
        }
    }
}
