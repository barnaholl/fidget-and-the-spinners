using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using csharp_backend_fidget_spinners.Models.Enums;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services
{
    public class EnemyGeneratorService : IEnemyGenerator
    {

        private readonly string[] _nameOptions = { "Bug", "StackOverFlow Question", "Codewars Kata", "PA", "Hardware Problem", "Virus" };

        public Enemy GenerateEnemy(Character myChar)
        {
            Random randomGenerator = new Random();

            Enemy enemy = new Enemy
            {
                Name = _nameOptions[randomGenerator.Next(0, 5)],
                Class = GetRandomClass(),
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

        private EnemyClassENUM GetRandomClass()
        {
            Array values = Enum.GetValues(typeof(EnemyClassENUM));
            Random random = new Random();
            EnemyClassENUM randomClass = (EnemyClassENUM)values.GetValue(random.Next(values.Length));
            return randomClass;
        }
    }
}
