using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Models
{
    public class Item
    {
        Random random = new Random();

        private string[] _nameOptionsIDEs = new string[] { "Text Editor", "Netbeans", "PyCharm", "Visual Studio Code", "IntelliJ" };
        private string[] _nameOptionsProgrammingLanguages = new string[] { "Python", "C++", "Java", "CSharp", "JavaScript" };
        private string[] _nameOptionsFrameworks = new string[] { ".NET", "Angular", "React", ".Net Core" };
        private string[] _nameOptionsComputers = new string[] { "Granny's Laptop", "Old PC", "Normal Laptop", "High-End PC" };
        private string[] _rarityOptions = new string[] { "Common", "Uncommon", "Rare", "Epic" };
        private string[] _itemSlotOptions = new string[] { "IDE", "Programming Language", "Framework", "Computer" };


        public int? ID { get; set; }
        public string Name { get; set; }
        public string EquipmentSlot { get; set; }
        public int ItemLevel { get; set; }
        public string Rarity { get; set; }
        public int Motivation { get; set; }
        public int ProblemSolving { get; set; }
        public int Design { get; set; }
        public int Algorithm { get; set; }
        public int Testing { get; set; }
        public int CleanCode { get; set; }
        public int Debugging { get; set; }
        public int CodingSpeed { get; set; }
        public int SellPrice { get; set; }
        public int BuyPrice { get; set; }

        public void SetupClass(int charLevel)
        {
            SetupItemLevel(charLevel);
            GenerateItemSlot();
            GenerateRandomRarity();
            SetupNameBasedOnSlot();
        }

        private void SetupItemLevel(int charLevel)
        {
            int itemLevel = random.Next(0, charLevel);
            ItemLevel = itemLevel;
        }

        private void SetupNameBasedOnSlot()
        {
            if(EquipmentSlot == _itemSlotOptions[0])
            {
                Name = _nameOptionsIDEs[random.Next(4)];
            } 
            else if (EquipmentSlot == _itemSlotOptions[1])
            {
                Name = _nameOptionsProgrammingLanguages[random.Next(4)];
            }
            else if (EquipmentSlot == _itemSlotOptions[2])
            {
                Name = _nameOptionsFrameworks[random.Next(3)];
            }
            else if (EquipmentSlot == _itemSlotOptions[3])
            {
                Name = _nameOptionsComputers[random.Next(3)];
            }
        }

        private void GenerateRandomRarity()
        {
            Rarity = _rarityOptions[random.Next(3)];
        }

        private void GenerateItemSlot()
        {
            EquipmentSlot = _itemSlotOptions[random.Next(3)];
        }

        private void FillUpBaseStats()
        {

        }
    }
}
