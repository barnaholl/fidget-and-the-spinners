using System;
using System.Collections.Generic;
using System.Text;
using NUnit.Framework;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services;

namespace csharp_backend_fidget_spinners_tests
{
    class QuestGeneratorTest
    {
        private QuestGeneratorService _questGenerator = new QuestGeneratorService();
        private Character _character;

        [SetUp]
        public void Setup()
        {
            _character = new Character();
        }

        [Test]
        public void Test1()
        {
            Assert.Pass();
        }

    }
}
