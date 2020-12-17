using csharp_backend_fidget_spinners.Models;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services
{
    public class ItemGeneratorService : ItemGeneratorInterface
    {
        public Item GenerateItem(int charLevel)
        {
            Item item = new Item();

            item.SetupClass(charLevel);

            return item;
        }

    }
}
