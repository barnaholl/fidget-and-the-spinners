using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using csharp_backend_fidget_spinners.Models.Enums;
using NUnit.Framework;
using System;
using NSubstitute;

namespace csharp_backend_fidget_spinners_tests
{
    public class EnemyUnitTests
    {

        Character _testPlayer;
        EnemyGeneratorService _enemyGenerator;

        [SetUp]
        public void Setup()
        {
            _testPlayer = new Character
            {
                ID = 1,
                Name = "Test Player",
                CharacterLevel = 1,
                MotivationLevel = 100,
                Energy = 100,
                ProblemSolving = 1,
                Design = 1,
                Algorithm = 1,
                Testing = 1,
                CleanCode = 1,
                DebugChance = 1,
                FastCoding = 1
            };

            _enemyGenerator = new EnemyGeneratorService();
        }

        [Test]
        public void GenerateHealthTest_ShouldReturn_220()
        {
            int expectedHP = 220;

            int generatedHP = _enemyGenerator.GenerateHealth(_testPlayer.CharacterLevel);

            Assert.AreEqual(expectedHP, generatedHP);
        }

        [Test]
        public void GenerateArmorTest_ShoulReturn_11()
        {
            int expectedArmor = 11;

            int generatedArmor = _enemyGenerator.GenerateArmor(_testPlayer.CharacterLevel);

            Assert.AreEqual(expectedArmor, generatedArmor);
        }

        [Test]
        public void GenerateEnemyTest_ShouldReturn_ExpectedEnemy()
        {

            //Arrange
            Enemy expectedEnemy = new Enemy
            {
                Name = "Bug",
                Class = EnemyClassENUM.Backend,
                HP = 220,
                Armor = 11,
                Damage = 50,
                CompilerErrorChance = 5,
                RuntimeErrorChance = 5
            };

            EnemyGeneratorService serviceMocked = Substitute.For<EnemyGeneratorService>();

            string returnValueName = "Bug";
            EnemyClassENUM returnValueENUM = EnemyClassENUM.Backend;

            serviceMocked.GetRandomName().Returns(returnValueName);
            serviceMocked.GetRandomClass().Returns(returnValueENUM);

            //Act
            Enemy resultEnemy = serviceMocked.GenerateEnemy(_testPlayer);

            //Asserts
            Assert.AreEqual(expectedEnemy.Name, resultEnemy.Name);
            Assert.AreEqual(expectedEnemy.Class, resultEnemy.Class);
            Assert.AreEqual(expectedEnemy.HP, resultEnemy.HP);
            Assert.AreEqual(expectedEnemy.Armor, resultEnemy.Armor);
            Assert.AreEqual(expectedEnemy.Damage, resultEnemy.Damage);
            Assert.AreEqual(expectedEnemy.CompilerErrorChance, resultEnemy.CompilerErrorChance);
            Assert.AreEqual(expectedEnemy.RuntimeErrorChance, resultEnemy.RuntimeErrorChance);

        }

    }
}