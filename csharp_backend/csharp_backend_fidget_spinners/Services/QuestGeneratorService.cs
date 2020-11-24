using csharp_backend_fidget_spinners.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services
{
    public class QuestGeneratorService
    {
        private readonly Dictionary<string, string> questsTexts;
        private Random random = new Random();

        public Quest GenerateQuest(Character character)
        {
            int NumOfQuestTexts = questsTexts.Count - 1;
            int questTextIndex = random.Next(0, NumOfQuestTexts);

            Quest quest = new Quest
            {
                Name = questsTexts.ElementAt(questTextIndex).Key,
                Description = questsTexts.ElementAt(questTextIndex).Value,
                //QuestTime = GenerateQuestTime(character.CharacterLevel),
                EnergyCost = GenerateEnergyCost(),
                RewardCoin = GenerateCoinReward(character.CharacterLevel),
                RewardXP = GenerateXPReward(character.CharacterLevel),
                //RewardItem = GenerateRewardItem(character.CharacterLevel)
            };

            return quest;
        }

        public int GenerateCoinReward(int charlevel)
        {
            return 0;
        }

        public int GenerateXPReward(int charlevel)
        {
            return 0;
        }

        /*public TimeSpan GenerateQuestTime(int charlevel)
        {

        }*/

        public float GenerateEnergyCost()
        {
            return 0;
        }

        /*public Item GenerateItemReward(int charlevel)
        {

        }*/
    }
}
