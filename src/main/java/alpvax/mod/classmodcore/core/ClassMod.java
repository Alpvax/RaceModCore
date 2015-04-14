package alpvax.mod.classmodcore.core;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import alpvax.mod.classmodcore.classes.PlayerClassRegistry;
import alpvax.mod.classmodcore.command.CommandChangeClass;
import alpvax.mod.classmodcore.network.CommonProxy;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)//TODO:Finish config, canBeDeactivated = true, guiFactory = "alpvax.mod.classmodcore.config.ConfigGuiFactory")
// , acceptedMinecraftVersions = "[1.4]")
public class ClassMod
{
	@Instance(ModInfo.MOD_ID)
	public static ClassMod instance;

	@SidedProxy(clientSide = "alpvax.classmod.network.ClientProxy", serverSide = "alpvax.classmod.network.CommonProxy")
	public static CommonProxy proxy;

	//private static Configuration defaultConfig;

	// Rules
	/*public static boolean lockClasses;
	public static int startDelay;
	public static boolean startOnCooldown;
	public static boolean delayPassive;
	public static boolean delayAllPassive;*/

	public static int selectGUIMaxC = 4;//TODO:Config
	public static int selectGUIMaxR = 1;//TODO:Config

	// Modules
	public static boolean blocks;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		/*defaultConfig = new Configuration(event.getSuggestedConfigurationFile());
		defaultConfig.load();
		defaultConfig.addCustomCategoryComment(ConfigConstants.CATEGORY_RULES, "Rules");
		defaultConfig.addCustomCategoryComment(ConfigConstants.CATEGORY_CLASSES, "Enabled Classes");
		defaultConfig.addCustomCategoryComment(ConfigConstants.CATEGORY_MODULES, "Enabled Modules");*/

		initPackets();
		instance = this;

		/*
		 * blocks = defaultConfig.get("Modules", "Blocks", true).getBoolean(true); if(blocks) { Blocks.init(configDir); } ClassUtil.init(configDir);
		 */

		/*selectGUIMaxC = ClassMod.defaultConfig.get("GUI", "Columns", 4).getInt();
		selectGUIMaxR = ClassMod.defaultConfig.get("GUI", "Rows", 1).getInt();

		// MultiBlock.init(event);

		lockClasses = defaultConfig.get("Rules", "Lock Classes", true).getBoolean(true);
		startDelay = defaultConfig.get("Rules", "Start Delay", 120).getInt(120);
		startOnCooldown = defaultConfig.get("Rules", "Start On Cooldown", false).getBoolean(false);
		delayPassive = defaultConfig.get("Rules", "Delay Triggerable Passive Powers", false).getBoolean(false);
		delayPassive = defaultConfig.get("Rules", "Delay All Passive Powers", false).getBoolean(false);*/

		MinecraftForge.EVENT_BUS.register(new ClassHooks());
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		// TODO: register proxy:
		// NetworkRegistry.instance().registerGuiHandler(this, proxy);
		// NetworkRegistry.instance().registerConnectionHandler(new
		// ConnectionHandler());
		proxy.registerClientHandlers();
		proxy.registerRenderInformation();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		PlayerClassRegistry.setEnabledClasses();
		//TODO:defaultConfig.save();
	}

	@EventHandler
	public void onServerStart(FMLServerStartingEvent event)
	{
		event.registerServerCommand(new CommandChangeClass());
	}

	/** TODO: */
	private void initPackets()
	{
		// AlpModPacket.registerPacket(packetClass);
		// AlpModPacket.registerPacket(ClassSelectPacket.class);
		// AlpModPacket.registerPacket(DataStringPacket.class);
		// AlpModPacket.registerPacket(OpenGUIPacket.class);
		/*
		 * packets.put(0, ClassSelectPacket.class); packets.put(1, TriggerPowerPacket.class); packets.put(2, TargetPacket.class); packets.put(3, FluidFillPacket.class); packets.put(4, FluidDrainPacket.class);
		 */
	}
}