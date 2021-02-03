﻿using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using csharp_backend_fidget_spinners.Models.Enums;
using NUnit.Framework;
using System;
using NSubstitute;
using System.Threading.Tasks;


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
                Motivation = 100,
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
            int expectedHP = 260;

            int generatedHP = _enemyGenerator.GenerateHealth(_testPlayer.CharacterLevel);

            Assert.AreEqual(expectedHP, generatedHP);
        }

        [Test]
        public void GenerateArmorTest_ShoulReturn_11_OnLevel1()
        {
            int expectedArmor = 11;

            int generatedArmor = _enemyGenerator.GenerateArmor(_testPlayer.CharacterLevel);

            Assert.AreEqual(expectedArmor, generatedArmor);
        }

        [Test]
        public void GenerateBaseDamage_ShouldReturn_35_OnLevel1()
        {
            int expectedDamage = 30;

            int generatedDamage = _enemyGenerator.GenerateBaseDamage(_testPlayer.CharacterLevel);

            Assert.AreEqual(expectedDamage, generatedDamage);
        }

        [Test]
        public void GenerateEnemyTest_ShouldReturn_ExpectedEnemy()
        {

            //Arrange
            Enemy expectedEnemy = new Enemy
            {
                Name = "Bug",
                Class = EnemyClassENUM.Backend,
                HP = 260,
                Armor = 11,
                Damage = 30,
                CompilerErrorChance = 5,
                RuntimeErrorChance = 5
            };

            EnemyGeneratorService serviceMocked = Substitute.For<EnemyGeneratorService>();

            string returnValueName = "Bug";
            EnemyClassENUM returnValueENUM = EnemyClassENUM.Backend;

            serviceMocked.GetRandomName().Returns(returnValueName);
            serviceMocked.GetRandomClass().Returns(returnValueENUM);

            //Act
            Enemy resultEnemy = serviceMocked.GenerateEnemy(_testPlayer).Result;

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