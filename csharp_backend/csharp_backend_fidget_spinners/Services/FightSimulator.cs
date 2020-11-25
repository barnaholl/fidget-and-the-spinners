using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services;
using csharp_backend_fidget_spinners.Services.CustomLogObj;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;

namespace csharp_backend_fidget_spinners.Services
{
    public class FightSimulator : IFightSimulator
    {
        private Character CurrentCharacter;
        private EnemyGeneratorService EnemyGeneratorService;
        private Enemy Enemy;
        private Random RNG;
        private List<FightLog> FightLog;

        public FightSimulator(Character currChar, EnemyGeneratorService enemyGeneratorService)
        {
            EnemyGeneratorService = enemyGeneratorService;
            RNG = new Random();
            FightLog = new List<FightLog>();
        }

        public List<FightLog> Fight(Character player)
        {
            CurrentCharacter = player;

            Enemy = EnemyGeneratorService.GenerateEnemy(CurrentCharacter);


            while(CurrentCharacter.MotivationLevel > 0 && Enemy.HP > 0)
            {
                if (ChanceGenerator(Enemy.BlockChance))
                {
                    int damageToDeal = CurrentCharacter.CalculateDamage();
                    Enemy.HP -= damageToDeal;
                    LogRounds(CurrentCharacter.Name, damageToDeal);
                }
                else
                {
                    LogRounds(CurrentCharacter.Name, 0);
                }

                if(Enemy.HP > 0)
                {
                    if(ChanceGenerator(CurrentCharacter.BlockChance))
                    {
                        int damageToDeal = Enemy.CalculateEnemyDMG();
                        CurrentCharacter.MotivationLevel -= damageToDeal;
                        LogRounds(Enemy.Name, damageToDeal);
                    }
                    else
                    {
                        LogRounds(Enemy.Name, 0);
                    }
                }
            }

            return FightLog;
        }

        private void LogRounds(string attackersName, int damageDealt)
        {
            FightLog.Add(new FightLog
            {
                DamageDealer = attackersName,
                DealtDMG = damageDealt,
                OurHealthPoint = CurrentCharacter.MotivationLevel,
                EnemyHealthPoint = Enemy.HP
            });
        }

        private bool ChanceGenerator(float chance)
        {
            bool isBlock = false;

            if (RNG.Next(0, 100) < chance)
            {
                isBlock = true;
            }

            return isBlock;
        }
    }
}
