using System.Threading.Tasks;
using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using Microsoft.AspNetCore.Mvc;

namespace csharp_backend_fidget_spinners.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class ItemController : ControllerBase
    {
        private ItemGeneratorInterface _itemGenerator;

        public ItemController(ItemGeneratorInterface itemGenerator)
        {
            _itemGenerator = itemGenerator;
        }

        [HttpPost]
        public Item ItemGenerator(Character player)
        {
            return _itemGenerator.GenerateItem(player.CharacterLevel);
        }
    }
}
