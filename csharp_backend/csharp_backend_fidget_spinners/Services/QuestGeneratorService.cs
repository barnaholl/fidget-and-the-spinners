using csharp_backend_fidget_spinners.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services
{
    public class QuestGeneratorService
    {
        private Dictionary<string, string> questsTexts = new Dictionary<string, string>();
        private Random random = new Random();
        private readonly string[] questDifficulties = { "short", "medium", "long" };


        public Quest GenerateQuest(Character character)
        {
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
                //Enemy = GenerateEnemy()
            };

            return quest;
        }

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

        /*public Item GenerateItemReward(int charlevel)
        {

        }*/
    }
}
