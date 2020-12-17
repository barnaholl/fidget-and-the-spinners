using System.Collections.Generic;
using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.CustomLogObj;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;

namespace csharp_backend_fidget_spinners.Services
{
    public class FightSimulator : IFightSimulator
    {
        private Character CurrentCharacter;
        private Enemy Enemy;
        private List<FightLog> FightLog;


        public void InitializeService(Character player, Enemy enemy)
        {
            CurrentCharacter = player;
            Enemy = enemy;
            FightLog = new List<FightLog>();
        }

        public async Task<List<FightLog>> Fight()
        {

            while(CurrentCharacter.Motivation > 0 && Enemy.HP > 0)
            {
                int dealtDamage = CurrentCharacter.CalculateDamage(Enemy.CompilerErrorChance, Enemy.Class);
                dealtDamage -= DamageMinusArmor(dealtDamage);
                Enemy.HP -= dealtDamage;

                await LogRounds(CurrentCharacter.Name, dealtDamage);

                if (Enemy.HP > 0)
                {
                    dealtDamage = Enemy.CalculateEnemyDMG(CurrentCharacter.DebugChance);

                    CurrentCharacter.Motivation -= dealtDamage;

                    await LogRounds(Enemy.Name, dealtDamage);
                }
                
            }

            return FightLog;
        }

        private async Task LogRounds(string attackersName, int damageDealt)
        {
            FightLog.Add(new FightLog
            {
                DamageDealer = attackersName,
                DealtDMG = damageDealt,
                OurHealthPoint = CurrentCharacter.Motivation,
                EnemyHealthPoint = Enemy.HP
            });
        }

        public int DamageMinusArmor(int damage)
        {
            return (damage - (Enemy.Armor / 2) > 0) ? (Enemy.Armor / 2) : 0;
        }

        public int LastKnownCharacterHP()
        {
            return CurrentCharacter.Motivation;
        }

        public int LastKnownEnemyHP()
        {
            return Enemy.HP;
        }

        public Character GetPlayerCharacter()
        {
            return CurrentCharacter;
        }

        public Enemy GetEnemy()
        {
            return Enemy;
        }
    }
}
