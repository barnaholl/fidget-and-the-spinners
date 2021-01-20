using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.CustomLogObj;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services.ServiceInterfaces
{
    public interface IArenaFightSimulator
    {
        public Task<List<ArenaFightLog>> ArenaFight(Character player1, Character player2);
    }
}
