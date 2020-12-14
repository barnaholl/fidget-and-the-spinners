using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Models
{
    public class Item
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string EquipmentSlot { get; set; }
        public int ItemLevel { get; set; }
        public string Rarity { get; set; }
        public int ProblemSolving { get; set; }
        public int Design { get; set; }
        public int Algorithmization { get; set; }
        public int CleanCode { get; set; }
        public int Testing { get; set; }
        public int Motivation { get; set; }
        public int Debugging { get; set; }
        public int CodingSpeed { get; set; }
        public int SellPrice { get; set; }
        public int BuyPrice { get; set; }
    }
}
