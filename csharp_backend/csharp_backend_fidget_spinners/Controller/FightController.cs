using System.Collections.Generic;
using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.CustomLogObj;
using Microsoft.AspNetCore.Mvc;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;


namespace csharp_backend_fidget_spinners.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class FightController : ControllerBase
    {
        private readonly IFightSimulator _fightSimulator;

        public FightController(IFightSimulator fightSimualtor)
        {
            _fightSimulator = fightSimualtor;
        }

        [HttpPost]
        public async Task<List<FightLog>> SimulateFight([FromBody] CharacterEnemyWrapper fighters)
        {
            _fightSimulator.InitializeService(fighters.Player, fighters.Enemy);
            return await _fightSimulator.Fight();
        }
    }
}
