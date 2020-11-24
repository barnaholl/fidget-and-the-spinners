using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services
{
    public class EnemyGeneratorService : IEnemyGenerator
    {

        private readonly string[] _nameOptions = { "Bug", "StackOverFlow Question", "Codewars Kata", "PA", "Hardware Problem", "Virus" };
        private readonly string[] _classOptions = { "Frontend", "Backend", "Testing", "DevOps" };

        public Enemy GenerateEnemy(Character myChar)
        {
            Random randomGenerator = new Random();

            Enemy enemy = new Enemy
            {
                Name = _nameOptions[randomGenerator.Next(0, 5)],
                Class = _classOptions[randomGenerator.Next(0,3)],
                HP = GenerateHealth(myChar.CharacterLevel),
                Armor = GenerateArmor(myChar.CharacterLevel),
                BlockChance = 0.1f,
                CriticalDamageChance = 0.1f
            };

            return enemy;
        }

        public int GenerateHealth (int myCharacterLevel)
        {
            return 10 * (10 + myCharacterLevel);
        }

        public int GenerateArmor(int myCharacterLevel)
        {
            return 1 * (10 + myCharacterLevel);
        }
    }
}
