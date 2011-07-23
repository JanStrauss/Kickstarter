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

	public ListenerData() {
		listener_Block 		= new ArrayList<ListenerContainer>();
		listener_Player 	= new ArrayList<ListenerContainer>();
		listener_Entity 	= new ArrayList<ListenerContainer>();
		listener_World 		= new ArrayList<ListenerContainer>();
		listener_Weather 	= new ArrayList<ListenerContainer>();
		listener_Vehicle 	= new ArrayList<ListenerContainer>();
		listener_Inventory 	= new ArrayList<ListenerContainer>();
		listener_Server 	= new ArrayList<ListenerContainer>();
		
		fillListener_Player();
		fillListener_Block();
		fillListener_Entity();
		fillListener_World();
		fillListener_Weather();
		fillListener_Vehicle();
		fillListener_Inventory();
		fillListener_Server();
	}
	
	private void fillListener_Player(){
		listener_Player.add(new ListenerContainer("Type.PLAYER_JOIN", "onPlayerJoin", "PlayerJoinEvent", "Called when a player joins a server"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_QUIT", "onPlayerQuit", "PlayerQuitEvent", "Called when a player leaves a server"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_KICK", "onPlayerKick", "PlayerKickEvent", "Called when a player gets kicked from the server"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_CHAT", "onPlayerChat", "PlayerChatEvent", "Called when a player sends a chat message"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_COMMAND_PREPROCESS", "onPlayerCommandPreprocess", "PlayerCommandPreprocessEvent", "Called early in the command handling process"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_MOVE", "onPlayerMove", "PlayerMoveEvent", "Called when a player attempts to move location in a world"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_TELEPORT", "onPlayerTeleport", "PlayerTeleportEvent", "Called when a player attempts to teleport to a listener_Player.add(new location in a world"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_RESPAWN", "onPlayerRespawn", "PlayerRespawnEvent", "Called when a player respawns"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_INTERACT", "onPlayerInteract", "PlayerInteractEvent", "Called when a player interacts with an object or air"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_INTERACT_ENTITY", "onPlayerInteractEntity", "PlayerInteractEntityEvent", "Called when a player right clicks an entity"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_LOGIN", "onPlayerLogin", "PlayerLoginEvent", "Called when a player attempts to log in to the server"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_PRELOGIN", "onPlayerPreLogin", "PlayerPreLoginEvent", "Called when a player has just been authenticated"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_EGG_THROW", "onPlayerEggThrow", "PlayerEggThrowEvent", "Called when a player throws an egg and it might hatch"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_ANIMATION", "onPlayerAnimation", "PlayerAnimationEvent", "Called when a player plays an animation, such as an arm swing"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_INVENTORY", "onInventoryOpen", "PlayerInventoryEvent", "Called when a player opens an inventory"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_ITEM_HELD", "onItemHeldChange", "PlayerItemHeldEvent", "Called when a player changes their held item"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_DROP_ITEM", "onPlayerDropItem", "PlayerDropItemEvent", "Called when a player drops an item from their inventory"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_PICKUP_ITEM", "onPlayerPickupItem", "PlayerPickupItemEvent", "Called when a player picks an item up off the ground"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_TOGGLE_SNEAK", "onPlayerToggleSneak", "PlayerToggleSneakEvent", "Called when a player toggles sneak mode"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_BUCKET_FILL", "onPlayerBucketFill", "PlayerBucketFillEvent", "Called when a player fills a bucket"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_BUCKET_EMPTY", "onPlayerBucketEmpty", "PlayerBucketEmptyEvent", "Called when a player empties a bucket"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_BED_ENTER", "onPlayerBedEnter", "PlayerBedEnterEvent", "Called when a player enters a bed"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_BED_LEAVE", "onPlayerBedLeave", "PlayerBedLeaveEvent", "Called when a player leaves a bed"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_PORTAL", "onPlayerPortal", "PlayerPortalEvent", "Called when a player is teleporting in a portal (after the animation)"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_FISH", "onPlayerFish", "PlayerFishEvent", "Called when a player is fishing"));
	}
	
	private void fillListener_Block(){
		listener_Block.add(new ListenerContainer("Type.BLOCK_DAMAGE", "onBlockDamage", "BlockDamageEvent", "Called when a block is damaged by a player"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_CANBUILD", "onBlockCanBuild", "BlockCanBuildEvent", "Called when we try to place a block, to see if we can build it here or not"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_FROMTO", "onBlockFromTo", "BlockFromToEvent", "Represents events with a source block and a destination block, currently only applies to liquid (lava and water)"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_IGNITE", "onBlockIgnite", "BlockIgniteEvent", "Called when a block is ignited"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_PHYSICS", "onBlockPhysics", "BlockPhysicsEvent", "Called when block physics occurs"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_PLACE", "onBlockPlace", "BlockPlaceEvent", "Called when a block is placed by a player"));
		listener_Block.add(new ListenerContainer("Type.REDSTONE_CHANGE", "onBlockRedstoneChange", "BlockRedstoneEvent", "Called when redstone changes"));
		listener_Block.add(new ListenerContainer("Type.LEAVES_DECAY", "onLeavesDecay", "LeavesDecayEvent", "Called when leaves are decaying naturally"));
		listener_Block.add(new ListenerContainer("Type.SIGN_CHANGE", "onSignChange", "SignChangeEvent", "Called when a sign is changed by a player"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_BURN", "onBlockBurn", "BlockBurnEvent", "Called when a block is destroyed as a result of being burnt by fire"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_BREAK", "onBlockBreak", "BlockBreakEvent", "Called when a block is broken by a player"));
		listener_Block.add(new ListenerContainer("Type.SNOW_FORM", "onSnowForm", "SnowFormEvent", "Called when a world is attempting to place a block during a snowfall DEPRECATED! use onBlockForm()"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_FORM", "onBlockForm", "BlockFormEvent", "Called when a block is formed or spreads based on world conditions"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_SPREAD", "onBlockSpread", "BlockSpreadEvent", "Called when a block spreads based on world conditions"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_FADE", "onBlockFade", "BlockFadeEvent", "Called when a block fades, melts or disappears based on world conditions"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_DISPENSE", "onBlockDispense", "BlockDispenseEvent", "Called when an item is dispensed from a block"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_PISTON_RETRACT", "onBlockPistonRetract", "BlockPistonRetractEvent", "Called when a piston retracts"));
		listener_Block.add(new ListenerContainer("Type.BLOCK_PISTON_EXTEND", "onBlockPistonExtend", "BlockPistonExtendEvent", "Called when a piston extends"));
	}
	
	private void fillListener_Entity(){
		listener_Entity.add(new ListenerContainer("Type.CREATURE_SPAWN", "onCreatureSpawn", "CreatureSpawnEvent", "Called when a creature is spawned into a world"));
		listener_Entity.add(new ListenerContainer("Type.ITEM_SPAWN", "onItemSpawn", "ItemSpawnEvent", "Called when an item is spawned into a world"));
		listener_Entity.add(new ListenerContainer("Type.ENTITY_COMBUST", "onEntityCombust", "EntityCombustEvent", "Called when an entity combusts due to the sun"));
		listener_Entity.add(new ListenerContainer("Type.ENTITY_DAMAGE", "onEntityDamage", "EntityDamageEvent", "Called when an entity is damaged"));
		listener_Entity.add(new ListenerContainer("Type.ENTITY_EXPLODE", "onEntityExplode", "EntityExplodeEvent", "Called when an entity explodes"));
		listener_Entity.add(new ListenerContainer("Type.EXPLOSION_PRIME", "onExplosionPrime", "ExplosionPrimeEvent", "Called when an entity's fuse is lit"));
		listener_Entity.add(new ListenerContainer("Type.ENTITY_DEATH", "onEntityDeath", "EntityDeathEvent", "Called when an entity dies"));
		listener_Entity.add(new ListenerContainer("Type.ENTITY_TARGET", "onEntityTarget", "EntityTargetEvent", "Called when a creature targets another entity"));
		listener_Entity.add(new ListenerContainer("Type.ENTITY_INTERACT", "onEntityInteract", "EntityInteractEvent", "Called when an entity interacts with an object"));
		listener_Entity.add(new ListenerContainer("Type.ENTITY_PORTAL_ENTER", "onEntityPortalEnter", "EntityPortalEnterEvent", "Called when an entity enters a portal"));
		listener_Entity.add(new ListenerContainer("Type.PAINTING_PLACE", "onPaintingPlace", "PaintingPlaceEvent", "Called when a painting is placed"));
		listener_Entity.add(new ListenerContainer("Type.PAINTING_BREAK", "onPaintingBreak", "PaintingBreakEvent", "Called when a painting is broken"));
		listener_Entity.add(new ListenerContainer("Type.PIG_ZAP", "onPigZap", "PigZapEvent", "Called when a Pig is struck by lightning"));
		listener_Entity.add(new ListenerContainer("Type.CREEPER_POWER", "onCreeperPower", "CreeperPowerEvent", "Called when a Creeper is struck by lightning"));
		listener_Entity.add(new ListenerContainer("Type.ENTITY_TAME", "onEntityTame", "EntityTameEvent", "Called when an entity is tamed (currently only applies to Wolves)"));
		listener_Entity.add(new ListenerContainer("Type.ENTITY_REGAIN_HEALTH", "onEntityRegainHealth", "EntityRegainHealthEvent", "Called when an entity regains health (currently only applies to Players)"));
		listener_Entity.add(new ListenerContainer("Type.PROJECTILE_HIT", "onProjectileHit", "ProjectileHitEvent", "Called when a project hits an object"));
	}
	
	private void fillListener_World(){
		listener_World.add(new ListenerContainer("Type.CHUNK_LOAD", "onChunkLoad", "ChunkLoadEvent", "Called when a chunk is loaded"));
		listener_World.add(new ListenerContainer("Type.CHUNK_POPULATED", "onChunkPopulate", "ChunkPopulateEvent", "Called when a newly created chunk has been populated"));
		listener_World.add(new ListenerContainer("Type.CHUNK_UNLOAD", "onChunkUnload", "ChunkUnloadEvent", "Called when a chunk is unloaded"));
		listener_World.add(new ListenerContainer("Type.SPAWN_CHANGE", "onSpawnChange", "SpawnChangeEvent", "Called when a World's spawn is changed"));
		listener_World.add(new ListenerContainer("Type.PORTAL_CREATE", "onPortalCreate", "PortalCreateEvent", "Called when the world generates a portal end point"));
		listener_World.add(new ListenerContainer("Type.WORLD_SAVE", "onWorldSave", "WorldSaveEvent", "Called when a world is saved"));
		listener_World.add(new ListenerContainer("Type.WORLD_INIT", "onWorldInit", "WorldInitEvent", "Called when a World is initializing"));
		listener_World.add(new ListenerContainer("Type.WORLD_LOAD", "onWorldLoad", "WorldLoadEvent", "Called when a World is loaded"));
		listener_World.add(new ListenerContainer("Type.WORLD_UNLOAD", "onWorldUnload", "WorldUnloadEvent", "Called when a World is unloaded"));
	}
	
	private void fillListener_Weather(){
		listener_Weather.add(new ListenerContainer("Type.WEATHER_CHANGE", "onWeatherChange", "WeatherChangeEvent", "Called when a weather change occurs"));
		listener_Weather.add(new ListenerContainer("Type.THUNDER_CHANGE", "onThunderChange", "ThunderChangeEvent", "Called when the state of thunder changes"));
		listener_Weather.add(new ListenerContainer("Type.LIGHTNING_STRIKE", "onLightningStrike", "LightningStrikeEvent", "Called when lightning strikes"));
	}
	
	private void fillListener_Vehicle(){
		listener_Vehicle.add(new ListenerContainer("Type.VEHICLE_CREATE", "onVehicleCreate", "VehicleCreateEvent", "Called when a vehicle is created by a player. This hook will be called"));
		listener_Vehicle.add(new ListenerContainer("Type.VEHICLE_DAMAGE", "onVehicleDamage", "VehicleDamageEvent", "Called when a vehicle is damaged by the player"));
		listener_Vehicle.add(new ListenerContainer("Type.VEHICLE_COLLISION_BLOCK", "onVehicleBlockCollision", "VehicleBlockCollisionEvent", "Called when a vehicle collides with a block"));
		listener_Vehicle.add(new ListenerContainer("Type.VEHICLE_COLLISION_ENTITY", "onVehicleEntityCollision", "VehicleEntityCollisionEvent", "Called when a vehicle collides with an entity"));
		listener_Vehicle.add(new ListenerContainer("Type.VEHICLE_ENTER", "onVehicleEnter", "VehicleEnterEvent", "Called when an entity enters a vehicle"));
		listener_Vehicle.add(new ListenerContainer("Type.VEHICLE_EXIT", "onVehicleExit", "VehicleExitEvent", "Called when an entity exits a vehicle"));
		listener_Vehicle.add(new ListenerContainer("Type.VEHICLE_MOVE", "onVehicleMove", "VehicleMoveEvent", "Called when an vehicle moves"));
		listener_Vehicle.add(new ListenerContainer("Type.VEHICLE_DESTROY", "onVehicleDestroy", "VehicleDestroyEvent", "Called when a vehicle is destroyed"));
		listener_Vehicle.add(new ListenerContainer("Type.VEHICLE_UPDATA", "onVehicleUpdate", "VehicleUpdateEvent", "Called when a vehicle goes through an update cycle"));
	}
	
	private void fillListener_Inventory(){
		listener_Inventory.add(new ListenerContainer("Type.FURNACE_SMELT", "onFurnaceSmelt", "FurnaceSmeltEvent", "Called when an ItemStack is successfully smelted in a furnace"));
		listener_Inventory.add(new ListenerContainer("Type.FURNACE_BURN", "onFurnaceBurn", "FurnaceBurnEvent", "Called when an ItemStack is successfully burned as fuel in a furnace"));
	}
	
	private void fillListener_Server(){
		listener_Server.add(new ListenerContainer("Type.PLUGIN_ENABLE", "onPluginEnable", "PluginEnableEvent", "Called when a plugin is enabled"));
		listener_Server.add(new ListenerContainer("Type.PLUGIN_DISABLE", "onPluginDisable", "PluginDisableEvent", "Called when a plugin is disabled"));
		listener_Server.add(new ListenerContainer("Type.SERVER_COMMAND", "onServerCommand", "ServerCommandEvent", "Called when a server command is used"));
	}
	
	public ArrayList<ListenerContainer> getDataByType(ListenerType type){
		switch (type) {
		case Block:		return listener_Block;
		case Entity:	return listener_Entity;
		case Inventory:	return listener_Inventory;
		case Player:	return listener_Player;
		case Server:	return listener_Server;
		case Vehicle:	return listener_Vehicle;
		case Weather:	return listener_Weather;
		case World:		return listener_World;
		}
		return null;
	}
}
