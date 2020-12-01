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
        Random randomGenerator = new Random();

        public Enemy GenerateEnemy(Character myChar)
        {

            Enemy enemy = new Enemy
            {
                Name = GetRandomName(),
                Class = GetRandomClass(),
                HP = GenerateHealth(myChar.CharacterLevel),
                Armor = GenerateArmor(myChar.CharacterLevel),
                Damage = GenerateBaseDamage(myChar.CharacterLevel),
                CompilerErrorChance = 5,
                RuntimeErrorChance = 5
            };

            return enemy;
        }

        public int GenerateHealth (int myCharacterLevel)
        {
            return 20 * (12 + myCharacterLevel);
        }

        public int GenerateBaseDamage(int myCharacterLevel)
        {
            return 5 * (5 + myCharacterLevel);
        }

        public int GenerateArmor(int myCharacterLevel)
        {
            return 1 * (10 + myCharacterLevel);
        }

        public virtual EnemyClassENUM GetRandomClass()
        {
            Array values = Enum.GetValues(typeof(EnemyClassENUM));
            Random random = new Random();
            EnemyClassENUM randomClass = (EnemyClassENUM)values.GetValue(random.Next(values.Length));
            return randomClass;
        }

        public virtual string GetRandomName()
        {
            return _nameOptions[randomGenerator.Next(0, 6)];
        }
    }
}
