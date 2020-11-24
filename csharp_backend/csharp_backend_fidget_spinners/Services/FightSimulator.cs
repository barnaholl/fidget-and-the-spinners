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
            CurrentCharacter = currChar;
            EnemyGeneratorService = enemyGeneratorService;
            RNG = new Random();
            FightLog = new List<FightLog>();
        }

        public List<FightLog> Fight()
        {
            Enemy = EnemyGeneratorService.GenerateEnemy(CurrentCharacter);

            while(CurrentCharacter.MotivationLevel > 0 && Enemy.HP > 0)
            {
                if (RNG.Next(0, 100) < Enemy.BlockChance)
                {
                    int damageToDeal = CalculateCharDMG();
                    Enemy.HP -= damageToDeal;
                    LogRounds(CurrentCharacter.Name, damageToDeal);
                }
                else
                {
                    LogRounds(CurrentCharacter.Name, 0);
                }

                if(Enemy.HP > 0)
                {
                    if(RNG.Next(0, 100) > CurrentCharacter.CharacterLevel + 2)
                    {
                        int damageToDeal = CalculateEnemyDMG();
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


        private int CalculateCharDMG()
        {
            int damage = 10;
            switch (Enemy.Class)
            {
                case "Frontend":
                    damage += Convert.ToInt32(CurrentCharacter.Design * 1.09);
                    damage += Convert.ToInt32(CurrentCharacter.ProblemSolving * 1.12);
                    damage += CurrentCharacter.Testing;
                    damage += CurrentCharacter.Algorithm;
                    break;
                case "Backend":
                    damage += Convert.ToInt32(CurrentCharacter.Algorithm * 1.14);
                    damage += Convert.ToInt32(CurrentCharacter.ProblemSolving * 1.12);
                    damage += CurrentCharacter.Testing;
                    damage += CurrentCharacter.Design;
                    break;
                case "Testing":
                    damage += Convert.ToInt32(CurrentCharacter.Testing * 1.3);
                    damage += Convert.ToInt32(CurrentCharacter.ProblemSolving * 1.09);
                    damage += CurrentCharacter.Design;
                    damage += CurrentCharacter.Algorithm;
                    break;

                case "DevOps":
                    damage += Convert.ToInt32(CurrentCharacter.Design * 1.09);
                    damage += Convert.ToInt32(CurrentCharacter.ProblemSolving * 1.12);
                    damage += Convert.ToInt32(CurrentCharacter.Testing * 1.2);
                    damage += Convert.ToInt32(CurrentCharacter.Algorithm * 1.04);
                    break;
            }

            if(RNG.Next(0,100) > 85){
                damage *= 2;
            }

            return damage;
        }

        private int CalculateEnemyDMG()
        {
            int damage = Enemy.Damage;

            if (RNG.Next(0, 100) > 85)
            {
                damage *= 2;
            }

            return damage;
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
    }
}
