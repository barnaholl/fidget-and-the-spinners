using csharp_backend_fidget_spinners.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services.ServiceInterfaces
{
    public interface IQuestGenerator
    {
        public Quest GenerateQuest(Character character);
        public int GenerateCoinReward(int charlevel, string difficulty);
        public int GenerateXPReward(int charlevel, string difficulty);
        public int GenerateTimeAndEnergyCost(string difficulty);

    }
}
