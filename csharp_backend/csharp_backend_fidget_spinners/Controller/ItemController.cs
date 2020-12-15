using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using Microsoft.AspNetCore.Mvc;

namespace csharp_backend_fidget_spinners.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class ItemController : ControllerBase
    {
        [HttpPost]
        public async Task<Item> ItemGenerator(Character player)
        {
            
        }
    }
}
