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
        private List<ArenaFightLog> ArenaFightLog;

        public async Task<List<ArenaFightLog>> ArenaFight(Character player1, Character player2)
        {

            Player1 = player1;
            Player2 = player2;
            ArenaFightLog = new List<ArenaFightLog>();

            while (Player1.Motivation > 0 && Player2.Motivation > 0)
            {
                int player1Damage = Player1.CalculateDamage(Player2.DebugChance);

                Player2.Motivation -= player1Damage;

                LogRounds(Player1.Name, player1Damage);

                if(Player2.Motivation > 0)
                {
                    int player2Damage = Player2.CalculateDamage(Player1.DebugChance);

                    player1.Motivation -= player2Damage;

                    LogRounds(Player2.Name, player2Damage);
                }
            }

            return ArenaFightLog;
        }



        private void LogRounds(string attackersName, int damageDealt)
        {
            ArenaFightLog.Add(new ArenaFightLog
            {
                DamageDealer = attackersName,
                DealtDMG = damageDealt,
                Player1HealthPoint = Player1.Motivation,
                Player2HealthPoint = Player2.Motivation
            });
        }
    }
}
