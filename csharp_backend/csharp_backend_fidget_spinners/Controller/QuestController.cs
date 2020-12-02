using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace csharp_backend_fidget_spinners.Controller
{
    //TODO: 3 quests: short, medium, long; if low on energy, only give short quests

    [Route("api/[controller]")]
    [ApiController]
    public class QuestController : ControllerBase
    {
        private IQuestGenerator _questGenerator;

        public QuestController(IQuestGenerator questGenerator)
        {
            _questGenerator = questGenerator;
        }

        [HttpPost]
        public Quest QuestGenerator(Character player)
        {
            return _questGenerator.GenerateQuest(player);
        }
    }
}
