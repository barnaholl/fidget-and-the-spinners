using csharp_backend_fidget_spinners.Models;
using System.Threading.Tasks;


namespace csharp_backend_fidget_spinners.Services.ServiceInterfaces
{
    public interface IEnemyGenerator
    {
        public Task<Enemy> GenerateEnemy(Character myCharacterLevel);
        public int GenerateHealth(int myCharacterLevel);
        public int GenerateArmor(int myCharacterLevel);
    }
}
