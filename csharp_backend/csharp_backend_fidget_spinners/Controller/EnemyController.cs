using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using Microsoft.AspNetCore.Mvc;

namespace csharp_backend_fidget_spinners.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class EnemyController : ControllerBase
    {
        private readonly IEnemyGenerator _enemyGenerator;

        public EnemyController(IEnemyGenerator enemyGenerator)
        {
            _enemyGenerator = enemyGenerator;
        }

        [HttpPost]
        public async Task<Enemy> GetRandomEnemy([FromBody] Character player)
        {
            return await _enemyGenerator.GenerateEnemy(player);
        }
    }
}
