using csharp_backend_fidget_spinners.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services
{
    public class QuestGeneratorService
    {
        private readonly Dictionary<string, string> quests;

        public Quest GenerateQuest(Character character)
        {
            Random random = new Random();

            Quest quest = new Quest
            {

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


    }
}
