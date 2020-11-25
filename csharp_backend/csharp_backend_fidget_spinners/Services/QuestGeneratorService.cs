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



        public Quest GenerateQuest(Character character)
        {
            int questTextIndex = random.Next(0, questsTexts.Count);
            int timeAndEnergyCost = GenerateTimeAndEnergyCost();

            Quest quest = new Quest
            {
                Name = questsTexts.ElementAt(questTextIndex).Key,
                Description = questsTexts.ElementAt(questTextIndex).Value,
                QuestTime = timeAndEnergyCost,
                EnergyCost = timeAndEnergyCost,
                RewardCoin = GenerateCoinReward(character.CharacterLevel),
                RewardXP = GenerateXPReward(character.CharacterLevel),
                //RewardItem = GenerateRewardItem(character.CharacterLevel)
            };

            return quest;
        }

        public float GenerateCoinReward(int charlevel)
        {
            return (float)Math.Round(random.NextDouble() * 100 + ((10 + charlevel) / 10), 2);
        }

        public int GenerateXPReward(int charlevel)
        {
            return random.Next(20 + (charlevel * 5), 30 + (charlevel * 5));
        }

        public int GenerateTimeAndEnergyCost()
        {
            return random.Next(3, 7);
        }

        /*public Item GenerateItemReward(int charlevel)
        {

        }*/
    }
}
