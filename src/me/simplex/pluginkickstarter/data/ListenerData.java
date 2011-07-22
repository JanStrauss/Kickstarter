package me.simplex.pluginkickstarter.data;

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
		listener_Player.add(new ListenerContainer("Type.PLAYER_BUCKET_FILL", "onPlayerBucketFill", "PlayerBucketFillEvent", " Called when a player fills a bucket"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_BUCKET_EMPTY", "onPlayerBucketEmpty", "PlayerBucketEmptyEvent", "Called when a player empties a bucket"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_BED_ENTER", "onPlayerBedEnter", "PlayerBedEnterEvent", "Called when a player enters a bed"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_BED_LEAVE", "onPlayerBedLeave", "PlayerBedLeaveEvent", "Called when a player leaves a bed"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_PORTAL", "onPlayerPortal", "PlayerPortalEvent", "Called when a player is teleporting in a portal (after the animation)"));
		listener_Player.add(new ListenerContainer("Type.PLAYER_FISH", "onPlayerFish", "PlayerFishEvent", "Called when a player is fishing"));
	}
	
	private void fillListener_Block(){
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockDamage", "BlockDamageEvent", "Called when a block is damaged by a player"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockCanBuild", "BlockCanBuildEvent", "Called when we try to place a block, to see if we can build it here or not"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockFromTo", "BlockFromToEvent", "Represents events with a source block and a destination block, currently only applies to liquid (lava and water)"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockIgnite", "BlockIgniteEvent", "Called when a block is ignited"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockPhysics", "BlockPhysicsEvent", "Called when block physics occurs"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockPlace", "BlockPlaceEvent", "Called when a block is placed by a player"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockRedstoneChange", "BlockRedstoneEvent", "Called when redstone changes"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onLeavesDecay", "LeavesDecayEvent", "Called when leaves are decaying naturally"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onSignChange", "SignChangeEvent", "Called when a sign is changed by a player"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockBurn", "BlockBurnEvent", "Called when a block is destroyed as a result of being burnt by fire"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockBreak", "BlockBreakEvent", "Called when a block is broken by a player"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onSnowForm", "SnowFormEvent", "Called when a world is attempting to place a block during a snowfall DEPRECATED! use onBlockForm()"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockForm", "BlockFormEvent", "Called when a block is formed or spreads based on world conditions"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockSpread", "BlockSpreadEvent", "Called when a block spreads based on world conditions"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockFade", "BlockFadeEvent", "Called when a block fades, melts or disappears based on world conditions"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockDispense", "BlockDispenseEvent", " Called when an item is dispensed from a block"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockPistonRetract", "BlockPistonRetractEvent", "Called when a piston retracts"));
		listener_Block.add(new ListenerContainer("BLOCK_DERP", "onBlockPistonExtend", "BlockPistonExtendEvent", "Called when a piston extends"));
	}
	
	private void fillListener_Entity(){
		
	}
	
	private void fillListener_World(){
		
	}
	
	private void fillListener_Weather(){
		
	}
	
	private void fillListener_Vehicle(){
		
	}
	
	private void fillListener_Inventory(){
		
	}
	
	private void fillListener_Server(){
		
	}
	
	public ArrayList<ListenerContainer> getListenerData(ListenerType type){
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
