package me.simplex.pluginkickstarter.storage;

import java.util.ArrayList;

import me.simplex.pluginkickstarter.util.ListenerType;

public class ListenerData {
	private ArrayList<ListenerContainer> listener_Block;
	private ArrayList<ListenerContainer> listener_Player;
	private ArrayList<ListenerContainer> listener_Entity;
	private ArrayList<ListenerContainer> listener_World;
	private ArrayList<ListenerContainer> listener_Weather;
	private ArrayList<ListenerContainer> listener_Vehicle;
	private ArrayList<ListenerContainer> listener_Inventory;
	private ArrayList<ListenerContainer> listener_Server;
	private ArrayList<ListenerContainer> listener_Painting;
	private ArrayList<ListenerContainer> listener_Enchantment;

	public ListenerData() {
		listener_Block 			= new ArrayList<ListenerContainer>();
		listener_Player 		= new ArrayList<ListenerContainer>();
		listener_Entity 		= new ArrayList<ListenerContainer>();
		listener_World 			= new ArrayList<ListenerContainer>();
		listener_Weather 		= new ArrayList<ListenerContainer>();
		listener_Vehicle 		= new ArrayList<ListenerContainer>();
		listener_Inventory 		= new ArrayList<ListenerContainer>();
		listener_Server 		= new ArrayList<ListenerContainer>();
		listener_Painting		= new ArrayList<ListenerContainer>();
		listener_Enchantment	= new ArrayList<ListenerContainer>();
		
		fillListener_Player();
		fillListener_Block();
		fillListener_Entity();
		fillListener_World();
		fillListener_Weather();
		fillListener_Vehicle();
		fillListener_Inventory();
		fillListener_Server();
		fillListener_Painting();
		fillListener_Enchantment();
	}
	
	private void fillListener_Player(){
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_JOIN", "onPlayerJoin", "PlayerJoinEvent", "Called when a player joins a server"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_QUIT", "onPlayerQuit", "PlayerQuitEvent", "Called when a player leaves a server"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_KICK", "onPlayerKick", "PlayerKickEvent", "Called when a player gets kicked from the server"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_CHAT", "onPlayerChat", "PlayerChatEvent", "Called when a player sends a chat message"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_COMMAND_PREPROCESS", "onPlayerCommandPreprocess", "PlayerCommandPreprocessEvent", "Called early in the command handling process"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_MOVE", "onPlayerMove", "PlayerMoveEvent", "Called when a player attempts to move location in a world"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_TELEPORT", "onPlayerTeleport", "PlayerTeleportEvent", "Called when a player attempts to teleport to a listener_Player.add(new location in a world"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_RESPAWN", "onPlayerRespawn", "PlayerRespawnEvent", "Called when a player respawns"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_INTERACT", "onPlayerInteract", "PlayerInteractEvent", "Called when a player interacts with an object or air"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_INTERACT_ENTITY", "onPlayerInteractEntity", "PlayerInteractEntityEvent", "Called when a player right clicks an entity"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_LOGIN", "onPlayerLogin", "PlayerLoginEvent", "Called when a player attempts to log in to the server"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_PRELOGIN", "onPlayerPreLogin", "PlayerPreLoginEvent", "Called when a player has just been authenticated"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_EGG_THROW", "onPlayerEggThrow", "PlayerEggThrowEvent", "Called when a player throws an egg and it might hatch"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_ANIMATION", "onPlayerAnimation", "PlayerAnimationEvent", "Called when a player plays an animation, such as an arm swing"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_INVENTORY", "onInventoryOpen", "PlayerInventoryEvent", "Called when a player opens an inventory"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_ITEM_HELD", "onItemHeldChange", "PlayerItemHeldEvent", "Called when a player changes their held item"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_DROP_ITEM", "onPlayerDropItem", "PlayerDropItemEvent", "Called when a player drops an item from their inventory"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_PICKUP_ITEM", "onPlayerPickupItem", "PlayerPickupItemEvent", "Called when a player picks an item up off the ground"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_TOGGLE_SNEAK", "onPlayerToggleSneak", "PlayerToggleSneakEvent", "Called when a player toggles sneak mode"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_BUCKET_FILL", "onPlayerBucketFill", "PlayerBucketFillEvent", "Called when a player fills a bucket"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_BUCKET_EMPTY", "onPlayerBucketEmpty", "PlayerBucketEmptyEvent", "Called when a player empties a bucket"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_BED_ENTER", "onPlayerBedEnter", "PlayerBedEnterEvent", "Called when a player enters a bed"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_BED_LEAVE", "onPlayerBedLeave", "PlayerBedLeaveEvent", "Called when a player leaves a bed"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_PORTAL", "onPlayerPortal", "PlayerPortalEvent", "Called when a player is teleporting in a portal (after the animation)"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_FISH", "onPlayerFish", "PlayerFishEvent", "Called when a player is fishing"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_VELOCITY", "onPlayerVelocity", "PlayerVelocityEvent", "Called before a player gets a velocity vector sent, which will \"push\" the player in a certain direction"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_GAME_MODE_CHANGE", "onPlayerGameModeChange", "PlayerGameModeChangeEvent", "Called when a player's game mode is changed"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_CHANGED_WORLD", "onPlayerChangedWorld", "PlayerChangedWorldEvent", "Called when a player changes the world"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_EXP_CHANGE", "onPlayerExpChange", "PlayerExpChangeEvent", "Called when a players experience changes naturally"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_LEVEL_CHANGE", "onPlayerLevelChange", "PlayerLevelChangeEvent", "Called when a players level changes"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_SHEAR_ENTITY", "onPlayerShearEntity", "PlayerShearEntityEvent", "Called when a player shears an entity"));
		listener_Player.add(new ListenerContainer(ListenerType.Player, "Type.PLAYER_TOGGLE_SPRINT", "onPlayerToggleSprint", "PlayerToggleSprintEvent", "Called when a player toggles their sprinting state"));
	} 
	
	private void fillListener_Block(){
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_DAMAGE", "onBlockDamage", "BlockDamageEvent", "Called when a block is damaged by a player"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_CANBUILD", "onBlockCanBuild", "BlockCanBuildEvent", "Called when we try to place a block, to see if we can build it here or not"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_FROMTO", "onBlockFromTo", "BlockFromToEvent", "Represents events with a source block and a destination block, currently only applies to liquid (lava and water)"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_IGNITE", "onBlockIgnite", "BlockIgniteEvent", "Called when a block is ignited"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_PHYSICS", "onBlockPhysics", "BlockPhysicsEvent", "Called when block physics occurs"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_PLACE", "onBlockPlace", "BlockPlaceEvent", "Called when a block is placed by a player"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.REDSTONE_CHANGE", "onBlockRedstoneChange", "BlockRedstoneEvent", "Called when redstone changes"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.LEAVES_DECAY", "onLeavesDecay", "LeavesDecayEvent", "Called when leaves are decaying naturally"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.SIGN_CHANGE", "onSignChange", "SignChangeEvent", "Called when a sign is changed by a player"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_BURN", "onBlockBurn", "BlockBurnEvent", "Called when a block is destroyed as a result of being burnt by fire"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_BREAK", "onBlockBreak", "BlockBreakEvent", "Called when a block is broken by a player"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_FORM", "onBlockForm", "BlockFormEvent", "Called when a block is formed or spreads based on world conditions"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_SPREAD", "onBlockSpread", "BlockSpreadEvent", "Called when a block spreads based on world conditions"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_FADE", "onBlockFade", "BlockFadeEvent", "Called when a block fades, melts or disappears based on world conditions"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_DISPENSE", "onBlockDispense", "BlockDispenseEvent", "Called when an item is dispensed from a block"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_PISTON_RETRACT", "onBlockPistonRetract", "BlockPistonRetractEvent", "Called when a piston retracts"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_PISTON_EXTEND", "onBlockPistonExtend", "BlockPistonExtendEvent", "Called when a piston extends"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_GROW", "onBlockGrow", "BlockGrowEvent", "Called when a block grows naturally in the world"));
		listener_Block.add(new ListenerContainer(ListenerType.Block, "Type.BLOCK_ENTITY_BLOCK_FORM", "onEntityBlockForm", "EntityBlockFormEvent", "Called when a block is formed by entities"));
	}
	
	private void fillListener_Enchantment(){
		listener_Enchantment.add(new ListenerContainer(ListenerType.Enchantment, "Type.ENCHANT_ITEM", "onEnchantItem", "EnchantItemEvent", "Called when an ItemStack is successfully enchanted (currently at enchantment table)"));
		listener_Enchantment.add(new ListenerContainer(ListenerType.Enchantment, "Type.PREPARE_ITEM_ENCHANT", "onPrepareItemEnchant", "PrepareItemEnchantEvent", "Called when an ItemStack is inserted in an enchantment table - can be called multiple times"));
	}
	
	private void fillListener_Entity(){
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.CREATURE_SPAWN", "onCreatureSpawn", "CreatureSpawnEvent", "Called when a creature is spawned into a world"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ITEM_SPAWN", "onItemSpawn", "ItemSpawnEvent", "Called when an item is spawned into a world"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_COMBUST", "onEntityCombust", "EntityCombustEvent", "Called when an entity combusts due to the sun"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_DAMAGE", "onEntityDamage", "EntityDamageEvent", "Called when an entity is damaged"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_EXPLODE", "onEntityExplode", "EntityExplodeEvent", "Called when an entity explodes"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.EXPLOSION_PRIME", "onExplosionPrime", "ExplosionPrimeEvent", "Called when an entity's fuse is lit"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_DEATH", "onEntityDeath", "EntityDeathEvent", "Called when an entity dies"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_TARGET", "onEntityTarget", "EntityTargetEvent", "Called when a creature targets another entity"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_INTERACT", "onEntityInteract", "EntityInteractEvent", "Called when an entity interacts with an object"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_PORTAL_ENTER", "onEntityPortalEnter", "EntityPortalEnterEvent", "Called when an entity enters a portal"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.PAINTING_PLACE", "onPaintingPlace", "PaintingPlaceEvent", "Called when a painting is placed"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.PAINTING_BREAK", "onPaintingBreak", "PaintingBreakEvent", "Called when a painting is broken"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.PIG_ZAP", "onPigZap", "PigZapEvent", "Called when a Pig is struck by lightning"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.CREEPER_POWER", "onCreeperPower", "CreeperPowerEvent", "Called when a Creeper is struck by lightning"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_TAME", "onEntityTame", "EntityTameEvent", "Called when an entity is tamed (currently only applies to Wolves)"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_REGAIN_HEALTH", "onEntityRegainHealth", "EntityRegainHealthEvent", "Called when an entity regains health (currently only applies to Players)"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.PROJECTILE_HIT", "onProjectileHit", "ProjectileHitEvent", "Called when a project hits an object"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.FOOD_LEVEL_CHANGE", "onFoodLevelChange", "FoodLevelChangeEvent", "Called when a human entity's food level changes"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_CHANGE_BLOCK", "onEntityChangeBlock", "EntityChangeBlockEvent", "Called when an Enderman or Sheep changes a Block"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_BREAK_DOOR", "onEntityBreakDoor", "EntityBreakDoorEvent", "Called when an Entity breaks a door"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_COMBUST_BY_BLOCK", "onEntityCombustByBlock", "EntityCombustByBlockEvent", "Called when an Entity is set on fire by a block"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_COMBUST_BY_ENTITY", "onEntityCombustByEntity", "EntityCombustByEntityEvent", "Called when an Entity is set on fire by a Entity"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_CREATE_PORTAL", "onEntityCreatePortal", "EntityCreatePortalEvent", "Called when a Living Entity creates a portal in a world."));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_DAMAGE_BY_BLOCK", "onEntityDamageByBlock", "EntityDamageByBlockEvent", "Called when an entity is damaged by a block"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_DAMAGE_BY_ENTITY", "onEntityDamageByEntity", "EntityDamageByEntityEvent", "Called when an entity is damaged by an entity"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_SHOOT_BOW","onEntityShootBow","EntityShootBowEvent", "Called when a LivingEntity shoots a bow firing an arrow"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_TARGET_LIVING_ENTITY", "onEntityTargetLivingEntity", "EntityTargetLivingEntityEvent", "Called when an Entity targets a LivingEntity and can only target LivingEntity's."));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ENTITY_TELEPORT", "onEntityTeleport", "EntityTeleportEvent", "Called when a non-player entity (such as an Enderman) tries to teleport from one location to another."));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.EXP_BOTTLE", "onExpBottle", "ExpBottleEvent", "Called when a ThrownExpBottle hits and releases experience."));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.ITEN_DESPAWN","onItemDespawn", "ItemDespawnEvent", "Called when an Item despawns"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.PLAYER_DEATH", "onPlayerDeath", "PlayerDeathEvent", "Thrown whenever a Player dies"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.POTION_SPLASH", "onPotionSplash", "PotionSplashEvent", "Called when a splash potion hits an area"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.PROJECTILE_LAUNCH", "onProjectileLaunch", "ProjectileLaunchEvent", "Called when a projectile is launched"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.SHEEP_DYE_WOOL", "onSheepDyeWool", "SheepDyeWoolEvent", "Called when a sheep's wool is dyed"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.SHEEP_REGROW_WOOL", "onSheepRegrowWool", "SheepRegrowWoolEvent", "Called when a sheep regrows its wool"));
		listener_Entity.add(new ListenerContainer(ListenerType.Entity, "Type.SLIME_SPLIT", "onSlimeSplit", "SlimeSplitEvent", "Called when a Slime splits into smaller Slimes upon death"));
	}
	
	private void fillListener_Painting(){
		listener_Painting.add(new ListenerContainer(ListenerType.Painting, "Type.PAINTING_BREAK", "onPaintingBreak", "PaintingBreakEvent", "Called when a painting breaks"));
		listener_Painting.add(new ListenerContainer(ListenerType.Painting, "Type.PAINTING_BREAK_BY_ENTITY", "onPaintingBreakByEntity", "PaintingBreakByEntityEvent", "Called when a painting breaks"));
		listener_Painting.add(new ListenerContainer(ListenerType.Painting, "Type.PAINTING_PLACE", "onPaintingPlace", "PaintingPlaceEvent", "Called when a painting is placed"));
	}
	
	private void fillListener_World(){
		listener_World.add(new ListenerContainer(ListenerType.World, "Type.CHUNK_LOAD", "onChunkLoad", "ChunkLoadEvent", "Called when a chunk is loaded"));
		listener_World.add(new ListenerContainer(ListenerType.World, "Type.CHUNK_POPULATED", "onChunkPopulate", "ChunkPopulateEvent", "Called when a newly created chunk has been populated"));
		listener_World.add(new ListenerContainer(ListenerType.World, "Type.CHUNK_UNLOAD", "onChunkUnload", "ChunkUnloadEvent", "Called when a chunk is unloaded"));
		listener_World.add(new ListenerContainer(ListenerType.World, "Type.SPAWN_CHANGE", "onSpawnChange", "SpawnChangeEvent", "Called when a World's spawn is changed"));
		listener_World.add(new ListenerContainer(ListenerType.World, "Type.PORTAL_CREATE", "onPortalCreate", "PortalCreateEvent", "Called when the world generates a portal end point"));
		listener_World.add(new ListenerContainer(ListenerType.World, "Type.WORLD_SAVE", "onWorldSave", "WorldSaveEvent", "Called when a world is saved"));
		listener_World.add(new ListenerContainer(ListenerType.World, "Type.WORLD_INIT", "onWorldInit", "WorldInitEvent", "Called when a World is initializing"));
		listener_World.add(new ListenerContainer(ListenerType.World, "Type.WORLD_LOAD", "onWorldLoad", "WorldLoadEvent", "Called when a World is loaded"));
		listener_World.add(new ListenerContainer(ListenerType.World, "Type.WORLD_UNLOAD", "onWorldUnload", "WorldUnloadEvent", "Called when a World is unloaded"));
		listener_World.add(new ListenerContainer(ListenerType.World, "Type.WORLD_GROW", "onStructureGrowEvent", "StructureGrowEvent", "Called when a structure grows"));
	}
	
	private void fillListener_Weather(){
		listener_Weather.add(new ListenerContainer(ListenerType.Weather, "Type.WEATHER_CHANGE", "onWeatherChange", "WeatherChangeEvent", "Called when a weather change occurs"));
		listener_Weather.add(new ListenerContainer(ListenerType.Weather, "Type.THUNDER_CHANGE", "onThunderChange", "ThunderChangeEvent", "Called when the state of thunder changes"));
		listener_Weather.add(new ListenerContainer(ListenerType.Weather, "Type.LIGHTNING_STRIKE", "onLightningStrike", "LightningStrikeEvent", "Called when lightning strikes"));
	}
	
	private void fillListener_Vehicle(){
		listener_Vehicle.add(new ListenerContainer(ListenerType.Vehicle, "Type.VEHICLE_CREATE", "onVehicleCreate", "VehicleCreateEvent", "Called when a vehicle is created by a player. This hook will be called"));
		listener_Vehicle.add(new ListenerContainer(ListenerType.Vehicle, "Type.VEHICLE_DAMAGE", "onVehicleDamage", "VehicleDamageEvent", "Called when a vehicle is damaged by the player"));
		listener_Vehicle.add(new ListenerContainer(ListenerType.Vehicle, "Type.VEHICLE_COLLISION_BLOCK", "onVehicleBlockCollision", "VehicleBlockCollisionEvent", "Called when a vehicle collides with a block"));
		listener_Vehicle.add(new ListenerContainer(ListenerType.Vehicle, "Type.VEHICLE_COLLISION_ENTITY", "onVehicleEntityCollision", "VehicleEntityCollisionEvent", "Called when a vehicle collides with an entity"));
		listener_Vehicle.add(new ListenerContainer(ListenerType.Vehicle, "Type.VEHICLE_ENTER", "onVehicleEnter", "VehicleEnterEvent", "Called when an entity enters a vehicle"));
		listener_Vehicle.add(new ListenerContainer(ListenerType.Vehicle, "Type.VEHICLE_EXIT", "onVehicleExit", "VehicleExitEvent", "Called when an entity exits a vehicle"));
		listener_Vehicle.add(new ListenerContainer(ListenerType.Vehicle, "Type.VEHICLE_MOVE", "onVehicleMove", "VehicleMoveEvent", "Called when an vehicle moves"));
		listener_Vehicle.add(new ListenerContainer(ListenerType.Vehicle, "Type.VEHICLE_DESTROY", "onVehicleDestroy", "VehicleDestroyEvent", "Called when a vehicle is destroyed"));
		listener_Vehicle.add(new ListenerContainer(ListenerType.Vehicle, "Type.VEHICLE_UPDATE", "onVehicleUpdate", "VehicleUpdateEvent", "Called when a vehicle goes through an update cycle"));
	}
	
	private void fillListener_Inventory(){
		listener_Inventory.add(new ListenerContainer(ListenerType.Inventory, "Type.FURNACE_SMELT", "onFurnaceSmelt", "FurnaceSmeltEvent", "Called when an ItemStack is successfully smelted in a furnace"));
		listener_Inventory.add(new ListenerContainer(ListenerType.Inventory, "Type.FURNACE_BURN", "onFurnaceBurn", "FurnaceBurnEvent", "Called when an ItemStack is successfully burned as fuel in a furnace"));
		listener_Inventory.add(new ListenerContainer(ListenerType.Inventory, "Type.BREW", "onBrew", "BrewEvent", "Called when an Item is brewes"));
		listener_Inventory.add(new ListenerContainer(ListenerType.Inventory, "Type.CRAFT_ITEM", "onCraftItem", "CraftItemEvent", "Called when an Item is crafted"));
		listener_Inventory.add(new ListenerContainer(ListenerType.Inventory, "Type.INVENTORY_CLICK", "onInventoryClick", "InventoryClickEvent", "Called when a Player clicks on the Inventory"));
		listener_Inventory.add(new ListenerContainer(ListenerType.Inventory, "Type.INVENTORY_CLOSE", "onInventoryClose", "InventoryCloseEvent", "Called when a Player closes his Inventory"));
		listener_Inventory.add(new ListenerContainer(ListenerType.Inventory, "Type.INVENTORY_OPEN", "onInventoryOpenEvent", "InventoryOpenEvent", "Called when a Player opens his Inventory"));
	}
	
	private void fillListener_Server(){
		listener_Server.add(new ListenerContainer(ListenerType.Server, "Type.PLUGIN_ENABLE", "onPluginEnable", "PluginEnableEvent", "Called when a plugin is enabled"));
		listener_Server.add(new ListenerContainer(ListenerType.Server, "Type.PLUGIN_DISABLE", "onPluginDisable", "PluginDisableEvent", "Called when a plugin is disabled"));
		listener_Server.add(new ListenerContainer(ListenerType.Server, "Type.SERVER_COMMAND", "onServerCommand", "ServerCommandEvent", "Called when a server command is used"));
		listener_Server.add(new ListenerContainer(ListenerType.Server, "Type.MAP_INITIALIZE", "onMapInitialize", "MapInitializeEvent", "Called when a map item is initialized (created or loaded into memory)"));
		listener_Server.add(new ListenerContainer(ListenerType.Server, "Type.REMOTE_SERVER_COMMAND", "onRemoveServerCommand", "RemoteServerCommandEvent", "Called when a remote server alls a command"));
		listener_Server.add(new ListenerContainer(ListenerType.Server, "Type.SERVICE_REGISTER", "onServiceRegister", "ServiceRegisterEvent", "Called when a service is registered"));
		listener_Server.add(new ListenerContainer(ListenerType.Server, "Type.SERVICE_UNREGISTER", "onServiceUnregister", "ServiceUnregisterEvent", "Called when a service is unregistered"));
	}
	
	public ArrayList<ListenerContainer> getDataByType(ListenerType type){
		switch (type) {
		case Block:			return listener_Block;
		case Entity:		return listener_Entity;
		case Inventory:		return listener_Inventory;
		case Player:		return listener_Player;
		case Server:		return listener_Server;
		case Vehicle:		return listener_Vehicle;
		case Weather:		return listener_Weather;
		case World:			return listener_World;
		case Painting:		return listener_Painting;
		case Enchantment: 	return listener_Enchantment;
		}
		return null;
	}
}
