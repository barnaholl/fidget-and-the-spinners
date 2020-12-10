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

        public FightController(IFightSimulator fightSimualtor, IEnemyGenerator enemyGenerator)
        {
            _fightSimulator = fightSimualtor;
            _enemyGenerator = enemyGenerator;
        }

        [HttpPost]
        public async Task<List<FightLog>> SimulateFight([FromBody] CharacterEnemyWrapper wrapper)
        {
            _fightSimulator.InitializeService(wrapper.Player, wrapper.Enemy);
            return await _fightSimulator.Fight();
        }
    }
}
