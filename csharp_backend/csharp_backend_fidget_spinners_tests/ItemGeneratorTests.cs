using NUnit.Framework;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services;
using System.Linq;
using System;
using NSubstitute.ExceptionExtensions;

namespace csharp_backend_fidget_spinners_tests
{
    class ItemGeneratorTests
    {
        ItemGeneratorService itemGenerator;


        [SetUp]
        public void Setup()
        {
            itemGenerator = new ItemGeneratorService();
        }

        [Test]
        public void GenerateItemSlot_ShouldReturn_String_FromTheArray()
        {
            string[] _itemSlotOptions = new string[] { "IDE", "Programming Language", "Framework", "Computer" };

            string result = itemGenerator.GenerateItemSlot();

            Assert.True(_itemSlotOptions.Contains(result));
        }

        [Test]
        public void GenerateItemLevel_ShouldReturn_1()
        {
            int charLevel = 1;

            int result = itemGenerator.SetupItemLevel(charLevel);

            Assert.True(result == 1);
        }

        [Test]
        public void GenerateItemLevel_ShouldReturn_Between_1_And_CharLevel()
        {
            int charLevel = 5;

            int result = itemGenerator.SetupItemLevel(charLevel);

            Assert.True(result > 0);
            Assert.True(result >= 1);
            Assert.True(result < charLevel+1);
        }

        [Test]
        public void GenerateRarity_ShouldReturn_Random_RarityString()
        {
            string[] _rarityOptions = new string[] { "Common", "Uncommon", "Rare", "Epic" };

            string result = itemGenerator.GenerateRandomRarity();

            Assert.True(_rarityOptions.Contains(result));
        }

        [Test]
        public void GenerateName_ShouldReturn_Random_IDE_Name()
        {
            string[] _nameOptionsIDEs = new string[] { "Text Editor", "Netbeans", "PyCharm", "Visual Studio Code", "IntelliJ" };

            string equipmentSlotTest = "IDE";

            string result = itemGenerator.SetupNameBasedOnSlot(equipmentSlotTest);

            Assert.True(_nameOptionsIDEs.Contains(result));
        }

        [Test]
        public void GenerateName_ShouldReturn_Random_ProgrammingLanguage_Name()
        {
            string[] _nameOptionsProgrammingLanguages = new string[] { "Python", "C++", "Java", "CSharp", "JavaScript" };

            string equipmentSlotTest = "Programming Language";

            string result = itemGenerator.SetupNameBasedOnSlot(equipmentSlotTest);

            Assert.True(_nameOptionsProgrammingLanguages.Contains(result));
        }

        [Test]
        public void GenerateName_ShouldReturn_Random_Framework_Name()
        {
            string[] _nameOptionsFrameworks = new string[] { "Ruby", "Angular", "React", "ASP.NET", "Django" };

            string equipmentSlotTest = "Framework";

            string result = itemGenerator.SetupNameBasedOnSlot(equipmentSlotTest);

            Assert.True(_nameOptionsFrameworks.Contains(result));
        }

        [Test]
        public void GenerateName_ShouldReturn_Random_Computer_Name()
        {
            string[] _nameOptionsComputers = new string[] { "Granny's Laptop", "Old PC", "Normal Laptop", "High-End PC" };

            string equipmentSlotTest = "Computer";

            string result = itemGenerator.SetupNameBasedOnSlot(equipmentSlotTest);

            Assert.True(_nameOptionsComputers.Contains(result));
        }

        [Test]
        public void GenerateName_ShouldThrow_ArgumentException_When_ParameterIsWrong()
        {
            string equipmentSlotTest = "Testestestest";

            var exception = Assert.Throws<ArgumentException>(() => itemGenerator.SetupNameBasedOnSlot(equipmentSlotTest));

            Assert.That(exception.Message, Is.EqualTo("Bad Parameter!"));
        }


        [Test]
        public void GenerateItems_BaseStats()
        {
            Item testItem1 = new Item { Rarity = "Uncommon", ItemLevel=1 };
            Item testItem2 = new Item { Rarity = "Rare", ItemLevel=1 };

            testItem1.FillUpBaseStats();
            testItem2.FillUpBaseStats();

            Assert.That(testItem1.ProblemSolving > -1);
            Assert.That(testItem1.CleanCode > -1);
            Assert.That(testItem1.Design > -1);
            Assert.That(testItem1.Algorithm > -1);
            Assert.That(testItem1.Testing > -1);
            Assert.That(testItem1.Motivation > -1);
            Assert.That(testItem1.SellPrice > -1);
            Assert.That(testItem1.BuyPrice > -1);

            Assert.That(testItem2.ProblemSolving > -1);
            Assert.That(testItem2.CleanCode > -1);
            Assert.That(testItem2.Design > -1);
            Assert.That(testItem2.Algorithm > -1);
            Assert.That(testItem2.Testing > -1);
            Assert.That(testItem2.Motivation > -1);
            Assert.That(testItem2.SellPrice > -1);
            Assert.That(testItem2.BuyPrice > -1);
        }                       


        [Test]
        public void GenerateItems_SecondaryStats()
        {
            Item testItem1 = new Item();
            Item testItem2 = new Item();

            testItem1.Rarity = "Uncommon";
            testItem2.Rarity = "Epic";

            testItem1.FillUpSecondaryStats();
            testItem2.FillUpSecondaryStats();

            Assert.AreEqual(0, testItem1.Debugging);
            Assert.AreEqual(0, testItem1.CodingSpeed);

            Assert.That(testItem2.Debugging > 0 && testItem2.Debugging < 6);
            Assert.That(testItem2.CodingSpeed > 0 && testItem2.CodingSpeed < 6);
        }
    }
}
