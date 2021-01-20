using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.CustomLogObj;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services.ServiceInterfaces
{
    public interface IFightSimulator
    {
        public void InitializeService(Character player, Enemy enemy);
        public Task<List<FightLog>> Fight();
    }
}
