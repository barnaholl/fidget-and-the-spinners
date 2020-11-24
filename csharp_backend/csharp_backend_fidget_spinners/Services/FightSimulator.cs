using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;

namespace csharp_backend_fidget_spinners.Services
{
    public class FightSimulator
    {

        private Character CurrentCharacter;
        private EnemyGeneratorService EnemyGeneratorService;
        private Enemy Enemy;
        private Random RNG;

        public FightSimulator(Character currChar, EnemyGeneratorService enemyGeneratorService)
        {
            CurrentCharacter = currChar;
            EnemyGeneratorService = enemyGeneratorService;
            RNG = new Random();
        }

        public List<string> Fight()
        {

            List<string> roundsLog = new List<string>();
            Enemy = EnemyGeneratorService.GenerateEnemy(CurrentCharacter);

            while(CurrentCharacter.MotivationLevel > 0 && Enemy.HP > 0)
            {
                if (RNG.Next(0, 100) < Enemy.BlockChance)
                {
                    Enemy.HP -= CalculateCharDMG();
                }
                else
                {

                }

                if(Enemy.HP > 0)
                {
                    if(RNG.Next(0, 100) > CurrentCharacter.CharacterLevel + 2)
                    {
                        CurrentCharacter.MotivationLevel -= CalculateEnemyDMG();
                    }
                    else
                    {

                    }
                }

                //log current stats after round

            }


            return roundsLog;
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
    }
}
