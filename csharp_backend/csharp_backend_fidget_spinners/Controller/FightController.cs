using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services;
using csharp_backend_fidget_spinners.Services.CustomLogObj;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;


namespace csharp_backend_fidget_spinners.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class FightController : ControllerBase
    {
        private readonly IFightSimulator _fightSimulator;
        private readonly IEnemyGenerator _enemyGenerator;

        public FightController(IFightSimulator fightSimualtor, IEnemyGenerator enemyGenerator)
        {
            _fightSimulator = fightSimualtor;
            _enemyGenerator = enemyGenerator;
        }

        [HttpPost]
        public async Task<List<FightLog>> SimulateFight([FromBody] Character player)
        {
            await _fightSimulator.InitializeService(player, _enemyGenerator);
            return await _fightSimulator.Fight();
        }
    }
}
