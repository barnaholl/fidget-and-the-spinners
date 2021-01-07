using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services;
using System.Linq;

namespace csharp_backend_fidget_spinners_tests
{
    class QuestGeneratorTest
    {
        private QuestGeneratorService _questGenerator = new QuestGeneratorService();
        private Character _character;

        [SetUp]
        public void Setup()
        {
            _character = new Character()
            {
                Name = "Pro",
                CharacterLevel = 4,
                Energy = 4,
                Motivation = 3,
                ProblemSolving = 4,
                DebugChance = 3,
                Design = 2,
                Testing = 2,
                Algorithm = 3,
                CleanCode = 3,
                FastCoding = 3
            };
        }


        [Test]
        public void GenerateQuest_Quest_Should_Have_Name()
        {
            string level = "medium";
            Quest quest = _questGenerator.GenerateQuest(_character, level);
            string[] names = { "Eliminate Bug", "Codewars Kata", "Get a GO on PA", "Trial Interview" };

            Assert.True(names.Contains(quest.Name));
        }

        [Test]
        public void GenerateQuestList_Should_Return_3_Quests()
        {
            int numOfQuests = _questGenerator.GenerateQuestList(_character).Count;
            Assert.True(numOfQuests == 3);
        }

        [Test]
        public void GenerateQuest_Should_Return_Null()
        {
            _character.Energy = 0;
            string level = "medium";
            Assert.True(_questGenerator.GenerateQuest(_character, level) == null);
        }

        /*[Test]
        public void GenerateQuestList_Should_Return_3_Short_Quests()
        {
            int ShortMinReward = 10;
            int ShortMaxReward = 20;

            int startRange = _character.CharacterLevel * 2 + ShortMinReward;
            int endRange = _character.CharacterLevel * 2 + ShortMaxReward;

            List<Quest> quests = _questGenerator.GenerateQuestList(_character);

            Assert.True((quests[0].));
        }*/
    }
}
