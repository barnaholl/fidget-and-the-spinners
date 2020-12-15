﻿using csharp_backend_fidget_spinners.Models;
using System.Threading.Tasks;

namespace csharp_backend_fidget_spinners.Services.ServiceInterfaces
{
    public interface ItemGeneratorInterface
    {
        public Task<Item> GenerateItem(int charLevel);
    }
}
