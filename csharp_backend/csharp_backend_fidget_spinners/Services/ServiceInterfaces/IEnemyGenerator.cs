using csharp_backend_fidget_spinners.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services.ServiceInterfaces
{
    public interface IEnemyGenerator
    {
        public Enemy GenerateEnemy(int myCharacterLevel);
        public int GenerateHealth(int myCharacterLevel);
        public int GenerateArmor(int myCharacterLevel);
    }
}
