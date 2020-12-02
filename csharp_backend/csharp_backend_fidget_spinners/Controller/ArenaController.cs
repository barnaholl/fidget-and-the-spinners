using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.CustomLogObj;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace csharp_backend_fidget_spinners.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class ArenaController : ControllerBase
    {

        private readonly IArenaFightSimulator _arenaSimulator;

        public ArenaController(IArenaFightSimulator arenaSimulator)
        {
            _arenaSimulator = arenaSimulator;
        }


        [HttpPost]
        public async Task<List<ArenaFightLog>> ArenaFight([FromBody] List<Character> players)
        {
            Character player1;
            Character player2;

            try
            {
                player1 = players[0];
                player2 = players[1];
                return await _arenaSimulator.ArenaFight(player1, player2);
            } 
            catch (Exception e)
            {
                Console.WriteLine(e + e.Message);

                return new List<ArenaFightLog> 
                {
                    new ArenaFightLog()
                    {
                        DamageDealer = "BadRequest",
                        DealtDMG = 0,
                        Player1HealthPoint = 0,
                        Player2HealthPoint = 0
                    }
                };
            }

        }


    }
}
