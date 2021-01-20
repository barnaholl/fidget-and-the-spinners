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
        public void GenerateQuest_Should_Return_3_Short_Quests()
        {
            _character.Energy = 3;
            List<Quest> quests = _questGenerator.GenerateQuestList(_character);
            Assert.True(quests[0].QuestTime == _character.Energy);
            Assert.True(quests[1].QuestTime == _character.Energy);
            Assert.True(quests[2].QuestTime == _character.Energy);
        }

        [Test]
        public void GenerateQuest_Should_Return_2_Short_Quests_And_1_Medium()
        {
            _character.Energy = 8;
            List<Quest> quests = _questGenerator.GenerateQuestList(_character);
            Assert.True(quests[0].QuestTime > 0 && quests[0].QuestTime < 4);
            Assert.True(quests[1].QuestTime > 0 && quests[1].QuestTime < 4);
            Assert.True(quests[2].QuestTime > 3 && quests[2].QuestTime < 7);
        }

        [Test]
        public void GenerateQuest_Should_Return_1_Level_Of_Each_Difficulty()
        {
            _character.Energy = 10;
            List<Quest> quests = _questGenerator.GenerateQuestList(_character);
            Assert.True(quests[0].QuestTime > 0 && quests[0].QuestTime < 4);
            Assert.True(quests[1].QuestTime > 3 && quests[1].QuestTime < 7);
            Assert.True(quests[2].QuestTime > 6 && quests[2].QuestTime < 10);
        }

        [Test]
        public void GenerateQuest_Wrong_Level_Input_Should_Give_Zero_Reward()
        {
            string level = "invalid";
            Quest quest = _questGenerator.GenerateQuest(_character, level);
            Assert.True(quest.QuestTime == 0);
            Assert.True(quest.RewardCoin == 0);
            Assert.True(quest.RewardXP == 0);
        }

        [Test]
        public void GenerateQuest_Should_Give_Null_If_Character_Has_Zero_Energy()
        {
            _character.Energy = 0;
            List<Quest> quests = _questGenerator.GenerateQuestList(_character);

            Assert.True(quests.Count == 0);
        }
    }
}
