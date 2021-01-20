using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.CustomLogObj;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
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


        [HttpGet]
        public List<Character> GetPlayersForFrontend()
        {
            return new List<Character>
            {
                new Character
                {
                    ID = 1,
                    Name = "Test",
                    CharacterLevel = 10,
                    Motivation = 500,
                    Energy = 100,
                    ProblemSolving = 3,
                    Design = 6,
                    Algorithm = 4,
                    Testing = 3,
                    CleanCode = 5,
                    DebugChance = 1,
                    FastCoding = 1
                },
                new Character
                {
                    ID = 2,
                    Name = "Enemy",
                    CharacterLevel = 10,
                    Motivation = 600,
                    Energy = 100,
                    ProblemSolving = 4,
                    Design = 5,
                    Algorithm = 6,
                    Testing = 5,
                    CleanCode = 5,
                    DebugChance = 1,
                    FastCoding = 1
                }
            };
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
            catch (ArgumentOutOfRangeException e)
            {
                Console.WriteLine("Bad Post-Request body!");
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
