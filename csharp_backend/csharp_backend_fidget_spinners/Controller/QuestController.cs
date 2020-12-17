using System.Collections.Generic;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using Microsoft.AspNetCore.Mvc;

namespace csharp_backend_fidget_spinners.Controller
{
    //TODO: 3 quests: short, medium, long; if low on energy, only give short quests

    [Route("api/[controller]")]
    [ApiController]
    public class QuestController : ControllerBase
    {
        private IQuestGenerator _questGenerator;
        private ItemGeneratorInterface _itemGenerator;

        public QuestController(IQuestGenerator questGenerator, ItemGeneratorInterface itemGenerator)
        {
            _questGenerator = questGenerator;
            _itemGenerator = itemGenerator;
        }

        [HttpPost]
        public List<Quest> QuestGenerator(Character player)
        {
            _questGenerator.InitializeItemGenerator(_itemGenerator);
            return _questGenerator.GenerateQuestList(player);
        }
    }
}
