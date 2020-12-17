using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Models
{
    public class Quest
    {
        public string Name { get; set; }
        public string Description { get; set; }
        public int QuestTime { get; set; }
        public float EnergyCost { get; set; }
        public int RewardCoin { get; set; }
        public int RewardXP { get; set; }
         public Item RewardItem { get; set;}
    }
}
