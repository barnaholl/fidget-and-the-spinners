using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services;
using NUnit.Framework;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners_tests
{
    class FightSimulatorTest
    {

        private FightSimulator _fightSimulator = new FightSimulator();
        private Character _character;
        private EnemyGeneratorService _enemyGeneratorService = new EnemyGeneratorService();
        private Enemy _enemy;


        [SetUp]
        public async Task Setup()
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

            _enemy = await _enemyGeneratorService.GenerateEnemy(_character);
        }

        [Test]
        public async Task FightTest_CharacterHP_Should_Decrease()
        {
            _fightSimulator.InitializeService(_character, _enemy);

            await _fightSimulator.Fight();

            Assert.True(_fightSimulator.LastKnownCharacterHP() < 300);
        }

        [Test]
        public async Task FightTest_EnemyHP_Should_Decrease()
        {
            _fightSimulator.InitializeService(_character, _enemy);

            await _fightSimulator.Fight();

            Assert.True(_fightSimulator.LastKnownEnemyHP() < 240);
        }

        [Test]
        public async Task FightTest_Someone_Should_Win()
        {
            _fightSimulator.InitializeService(_character, _enemy);

            await _fightSimulator.Fight();


            Assert.True(_fightSimulator.LastKnownCharacterHP() <= 0 || _fightSimulator.LastKnownEnemyHP() <= 0);
        }

        [Test]
        public void DamageMinusArmor_ShouldNot_Go_Below_0()
        {
            _fightSimulator.InitializeService(_character, _enemy);


            Assert.True(_fightSimulator.DamageMinusArmor(0) == 0);
            Assert.True(_fightSimulator.DamageMinusArmor(6) == 0);
            Assert.True(_fightSimulator.DamageMinusArmor(7) > 0);
            Assert.True(_fightSimulator.DamageMinusArmor(50) > 0);
        }
    }
}
