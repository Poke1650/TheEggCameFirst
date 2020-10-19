package poke.me.tecf;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by Poke on 2017-10-21.
 */
@Config(modid = TECF.MODID)
public class TECFConfig
{
    @Config.Comment({"Sets the ammount of egg that should spawn where a chiken would have. Default: 1"})
    public static int eggSpawnAmmount = 1;
    
    @Config.Comment({"Whether eggs should lay chickens. Default: true"})
    public static boolean eggsLayChickens = true;
    
    @Config.Comment({"The chance that an egg should not despawn. Also controls how many chickens are spawned over an egg's lifetime. Default: 0.5"})
    public static float persistentEggChance = 0.5;
    
    @Config.Comment({"The minimum delay in ticks before spawning another chicken. Only effective if persistentEggChance is not 0. Default: 6000"})
    public static int chickenLayingDelay = 6000;

    private static final String CATEGORY_GENERAL = "general";

    public static void readConfig()
    {
        Configuration config = TECF.config;
        try
        {
            config.load();
            config.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
            eggSpawnAmmount = config.getInt("eggSpawnAmmount", CATEGORY_GENERAL, eggSpawnAmmount, 0, Integer.MAX_VALUE, "Sets the ammount of egg that should spawn where a chiken would have. Default: 1");
            eggsLayChickens = config.getBoolean("eggsLayChickens", CATEGORY_GENERAL, eggsLayChickens, "Whether eggs should lay chickens. Default: true");
            persistentEggChance = config.getFloat("persistentEggChance", CATEGORY_GENERAL, persistentEggChance, 0, 1, "The chance that an egg should not despawn. Default: 0.5");
            chickenLayingDelay = config.getInt("chickenLayingDelay", CATEGORY_GENERAL, chickenLayingDelay, 0, Integer.MAX_VALUE, "The minimum delay in ticks before spawning another chicken. Only effective if persistentEggChance is not 0. Default: 6000");
        } catch (Exception e1)
        {
            System.out.println("Failed to read config file!");
            e1.printStackTrace();
        } finally
        {
            if(config.hasChanged())
                config.save();
        }
    }

}
