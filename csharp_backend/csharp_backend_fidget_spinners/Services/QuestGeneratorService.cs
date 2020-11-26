using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services
{
    public class QuestGeneratorService
    {
        /// <summary>
        /// Properties
        /// </summary>

        private Dictionary<string, string> questsTexts = new Dictionary<string, string>();
        private Random random = new Random();
        private readonly string[] questDifficulties = { "short", "medium", "long" };
        private string[] questNames = { "test1", "test2", "test3" };
        private string[] questDescriptions = { "desc1", "desc2", "desc3" };


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

            Quest quest = new Quest
            {
                Name = questsTexts.ElementAt(questTextIndex).Key,
                Description = questsTexts.ElementAt(questTextIndex).Value,
                QuestTime = timeAndEnergyCost,
                EnergyCost = timeAndEnergyCost,
                RewardCoin = GenerateCoinReward(character.CharacterLevel, questDifficulty),
                RewardXP = GenerateXPReward(character.CharacterLevel, questDifficulty),
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

        public int GenerateCoinReward(int charlevel, string difficulty)
        {
            switch(difficulty)
            {
                case "short":
                    return random.Next(10 + (charlevel * 2), (20 + (charlevel * 2)) + 1);

                case "medium":
                    return random.Next(20 + (charlevel * 2), (30 + (charlevel * 2)) + 1);

                case "long":
                    return random.Next(30 + (charlevel * 2), (40 + (charlevel * 2)) + 1);

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

        public int GenerateXPReward(int charlevel, string difficulty)
        {
            switch(difficulty)
            {
                case "short":
                    return random.Next(20 + (charlevel * 2), (30 + (charlevel * 2)) + 1);

                case "medium":
                    return random.Next(30 + (charlevel * 2), (40 + (charlevel * 2)) + 1);

                case "long":
                    return random.Next(40 + (charlevel * 2), (50 + (charlevel * 2)) + 1);

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


        // Get it from Java backend
        /*public Item GenerateItemReward(int charlevel)
        {

        }*/

        private void FillQuestTexts()
        {
            for (int i = 0; i < questNames.Length -1; i++)
            {
                questsTexts.Add(questNames[i], questDescriptions[i]);
            }
        }
    }
}
