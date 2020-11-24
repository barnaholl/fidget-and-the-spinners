using csharp_backend_fidget_spinners.Services.CustomLogObj;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services.ServiceInterfaces
{
    interface IFightSimulator
    {
        public List<FightLog> Fight();
    }
}
