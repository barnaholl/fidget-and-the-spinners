using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services
{
    public class ItemGeneratorService : ItemGeneratorInterface
    {
        Random random = new Random();

        private string[] _itemSlotOptions = new string[] { "IDE", "Programming Language", "Framework", "Computer" };
        private string[] _nameOptionsIDEs = new string[] { "Text Editor", "Netbeans", "PyCharm", "Visual Studio Code", "IntelliJ" };
        private string[] _nameOptionsProgrammingLanguages = new string[] { "Python", "C++", "Java", "CSharp", "JavaScript" };
        private string[] _nameOptionsFrameworks = new string[] { "Ruby", "Angular", "React", "ASP.NET", "Django" };
        private string[] _nameOptionsComputers = new string[] { "Granny's Laptop", "Old PC", "Normal Laptop", "High-End PC" };
        private string[] _rarityOptions = new string[] { "Common", "Uncommon", "Rare", "Epic" };


        public Item GenerateItem(int charLevel)
        {
            Item item = new Item();

            item.ItemLevel = SetupItemLevel(charLevel);
            item.EquipmentSlot = GenerateItemSlot();
            item.Name = SetupNameBasedOnSlot(item.EquipmentSlot);
            item.Rarity = GenerateRandomRarity();
            item.SetupClass();

            return item;
        }

        public string GenerateItemSlot()
        {
            return _itemSlotOptions[random.Next(3)];
        }

        public int SetupItemLevel(int charLevel)
        {
            return random.Next(1, charLevel);
        }

        public string GenerateRandomRarity()
        {
            return _rarityOptions[random.Next(3)];
        }

        public string SetupNameBasedOnSlot(string equipmentSlot)
        {
            if (equipmentSlot == _itemSlotOptions[0])
            {
                return _nameOptionsIDEs[random.Next(4)];
            }
            else if (equipmentSlot == _itemSlotOptions[1])
            {
                return _nameOptionsProgrammingLanguages[random.Next(4)];
            }
            else if (equipmentSlot == _itemSlotOptions[2])
            {
                return _nameOptionsFrameworks[random.Next(3)];
            }
            else if (equipmentSlot == _itemSlotOptions[3])
            {
                return _nameOptionsComputers[random.Next(3)];
            } 
            else
            {
                throw new ArgumentException("Bad Parameter!");
            }
        }
    }
}
