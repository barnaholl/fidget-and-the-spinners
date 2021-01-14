using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace csharp_backend_fidget_spinners.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class CharacterController : ControllerBase
    {
        [HttpGet]
        [EnableCors]
        public Character GetTestCharacter()
        {
            return new Character
            {
                ID = 1,
                Name = "Test Player",
                CharacterLevel = 1,
                Motivation = 150,
                Energy = 100,
                ProblemSolving = 1,
                Design = 1,
                Algorithm = 1,
                Testing = 1,
                CleanCode = 1,
                DebugChance = 1,
                FastCoding = 1
            };
        }
    }
}
