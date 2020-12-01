using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services;
using csharp_backend_fidget_spinners.Services.CustomLogObj;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using NSubstitute;
using NUnit.Framework;

namespace csharp_backend_fidget_spinners_tests
{
    class FightSimulatorTest
    {

        private FightSimulator _fightSimulator = new FightSimulator();
        private Character _character;
        private EnemyGeneratorService _enemyGeneratorService = new EnemyGeneratorService();


        [SetUp]
        public void Setup()
        {

            _character = new Character
            {
                Algorithm = 3,
                CharacterLevel = 2,
                CleanCode = 4,
                DebugChance = 10,
                Design = 1,
                Energy = 3,
                FastCoding = 2,
                MotivationLevel = 300,
                ProblemSolving = 2,
                Testing = 1
            };

        }

        [Test]
        public void FightTest_CharacterHP_Should_Decrease()
        {
            _fightSimulator.Fight(_character, _enemyGeneratorService);

            Assert.True(_fightSimulator.LastKnownCharacterHP() < 300);
        }

        [Test]
        public void FightTest_EnemyHP_Should_Decrease()
        {
            _fightSimulator.Fight(_character, _enemyGeneratorService);

            Assert.True(_fightSimulator.LastKnownEnemyHP() < 240);
        }

        [Test]
        public void FightTest_Someone_Should_Win()
        {
            _fightSimulator.Fight(_character, _enemyGeneratorService);


            Assert.True(_fightSimulator.LastKnownCharacterHP() <= 0 || _fightSimulator.LastKnownEnemyHP() <= 0);
        }
    }
}
