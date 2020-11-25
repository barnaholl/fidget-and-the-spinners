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

        public FightController(IFightSimulator fightSimualtor)
        {
            _fightSimulator = fightSimualtor;
        }

        [HttpPost]
        public List<FightLog> SimulateFight(Character player)
        {
            return _fightSimulator.Fight(player);
        }
    }
}
