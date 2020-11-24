using csharp_backend_fidget_spinners.Models;

namespace csharp_backend_fidget_spinners.Services.ServiceInterfaces
{
    public interface IEnemyGenerator
    {
        public Enemy GenerateEnemy(Character myCharacterLevel);
        public int GenerateHealth(int myCharacterLevel);
        public int GenerateArmor(int myCharacterLevel);
    }
}
