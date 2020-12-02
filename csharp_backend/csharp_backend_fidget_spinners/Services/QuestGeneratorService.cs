using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using System;
using System.Collections.Generic;
using System.Linq;

namespace csharp_backend_fidget_spinners.Services
{
    public class QuestGeneratorService : IQuestGenerator
    {

        /// <summary>
        /// Properties
        /// </summary>

        private Dictionary<string, string> questsTexts = new Dictionary<string, string>();
        private Random random = new Random();
        private readonly string[] questDifficulties = { "short", "medium", "long" };
        private string[] questNames = { "Eliminate Bug", "Codewars Kata", "Get a GO on PA" };
        private string[] questDescriptions = { "Bugs everywhere", "6kyu", "Get them all" };

        private int CharLevelMultiplier = 2;

        private int ShortMinReward = 10;
        private int ShortMaxReward = 20;
        private int MediumMinReward = 25;
        private int MediumMaxReward = 35;
        private int LongMinReward = 40;
        private int LongMaxReward = 50;

        /// <summary>
        /// Generate a quest based on character level
        /// </summary>
        /// <param name="character"></param>
        /// <returns>A randomly generated quest</returns>

        public Quest GenerateQuest(Character character)
        {
            FillQuestTexts();
            string questDifficulty = questDifficulties[random.Next(0, questDifficulties.Length)];
            int questTextIndex = random.Next(0, questsTexts.Count);
            int timeAndEnergyCost = GenerateTimeAndEnergyCost(questDifficulty);
            bool hasItemReward = HasItemReward();

            Quest quest = new Quest
            {
                Name = questsTexts.ElementAt(questTextIndex).Key,
                Description = questsTexts.ElementAt(questTextIndex).Value,
                QuestTime = timeAndEnergyCost,
                EnergyCost = timeAndEnergyCost,
                RewardCoin = GenerateCoinReward(character.CharacterLevel, questDifficulty, hasItemReward),
                RewardXP = GenerateXPReward(character.CharacterLevel, questDifficulty, hasItemReward),
                //RewardItem = GenerateRewardItem(character.CharacterLevel),
            };

            return quest;
        }

        /// <summary>
        /// Generate a random currency reward based on character level and quest difficulty
        /// </summary>
        /// <param name="charlevel"></param>
        /// <param name="difficulty"></param>
        /// <returns>A random integer</returns>

        public int GenerateCoinReward(int charlevel, string difficulty, bool hasItemReward)
        {
            switch(difficulty)
            {
                case "short":
                    int shortReward = random.Next(ShortMinReward + (charlevel * CharLevelMultiplier), (ShortMaxReward + (charlevel * CharLevelMultiplier)) + 1);
                    return hasItemReward ? shortReward : shortReward - (charlevel + 5);

                case "medium":
                    int MediumReward = random.Next(MediumMinReward + (charlevel * CharLevelMultiplier), (MediumMaxReward + (charlevel * CharLevelMultiplier)) + 1);
                    return hasItemReward ? MediumReward : MediumReward - (charlevel + 5);

                case "long":
                    int LongReward = random.Next(LongMinReward + (charlevel * CharLevelMultiplier), (LongMaxReward + (charlevel * CharLevelMultiplier)) + 1);
                    return hasItemReward ? LongReward : LongReward - (charlevel + 5);

                default:
                    return 0;
            }
        }

        /// <summary>
        /// Generate XP reward based on character level and quest difficulty
        /// </summary>
        /// <param name="charlevel"></param>
        /// <param name="difficulty"></param>
        /// <returns>Random integer</returns>

        public int GenerateXPReward(int charlevel, string difficulty, bool hasItemReward)
        {
            switch(difficulty)
            {
                case "short":
                    int shortReward = random.Next(ShortMinReward + (charlevel * CharLevelMultiplier), (ShortMaxReward + (charlevel * CharLevelMultiplier)) + 1);
                    return hasItemReward ? shortReward : shortReward - (charlevel + 5);

                case "medium":
                    int MediumReward = random.Next(MediumMinReward + (charlevel * CharLevelMultiplier), (MediumMaxReward + (charlevel * CharLevelMultiplier)) + 1);
                    return hasItemReward ? MediumReward : MediumReward - (charlevel + 5);

                case "long":
                    int LongReward = random.Next(LongMinReward + (charlevel * CharLevelMultiplier), (LongMaxReward + (charlevel * CharLevelMultiplier)) + 1);
                    return hasItemReward ? LongReward : LongReward - (charlevel + 5);

                default:
                    return 0;
            }
        }

        /// <summary>
        /// Generate the time and energy cost based on quest difficulty
        /// </summary>
        /// <param name="difficulty"></param>
        /// <returns>Random integer</returns>

        public int GenerateTimeAndEnergyCost(string difficulty)
        {
            switch(difficulty)
            {
                case "short":
                    return random.Next(1, 4);

                case "medium":
                    return random.Next(3, 7);

                case "long":
                    return random.Next(6, 10);

                default:
                    return 0;
            }
        }

        public bool HasItemReward() => (random.Next(1, 101) < 25);

        private void FillQuestTexts()
        {
            for (int i = 0; i < questNames.Length -1; i++)
            {
                questsTexts.Add(questNames[i], questDescriptions[i]);
            }
        }
    }
}
