using csharp_backend_fidget_spinners.Services;
using csharp_backend_fidget_spinners.Services.ServiceInterfaces;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

namespace csharp_backend_fidget_spinners
{
    public class Startup
    {
        
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddControllers();
            services.AddScoped<IEnemyGenerator, EnemyGeneratorService>();
            services.AddScoped<IQuestGenerator, QuestGeneratorService>();
            services.AddScoped<IArenaFightSimulator, ArenaSimulator>();
            services.AddScoped<IFightSimulator, FightSimulator>();
            services.AddScoped<ItemGeneratorInterface, ItemGeneratorService>();
        }

        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            app.UseRouting();

            app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllers();
            });
        }
    }
}
