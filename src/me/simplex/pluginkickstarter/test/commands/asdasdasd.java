package me.simplex.pluginkickstarter.test.commands;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.entity.EndermanPickupEvent;
import org.bukkit.event.entity.EndermanPlaceEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryListener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.event.server.MapInitializeEvent;
import org.bukkit.event.server.ServerListener;
import org.bukkit.event.world.WorldListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class asdasdasd extends BlockListener {
	JavaPlugin plugin;

	@Override
	public void onBlockBreak(BlockBreakEvent event) {
		Block b = event.getBlock();
		BlockState bs = b.getState();

		b.setType(Material.AIR);
		b.getWorld().dropItemNaturally(b.getLocation(), new ItemStack(bs.getType(), 1, bs.getRawData(), bs.getRawData()));
		event.setCancelled(true);
		Player player= event.getPlayer();
		Material mat_to_check = Material.GOLD_INGOT;
		ItemStack[] contents = player.getInventory().getContents();
		for (ItemStack itemStack : contents) {
			if (itemStack != null) {
				if (itemStack.getType().equals(mat_to_check)) {
					itemStack.setAmount(itemStack.getAmount()-1);
					break;
				}
			}
		}
		player.getInventory().setContents(contents);
	}
	
	@Override
	public void onBlockDispense(BlockDispenseEvent event) {
		// TODO Auto-generated method stub
		super.onBlockDispense(event);
	}
}

class asdasdsadsadarer extends PlayerListener{
	@Override
	public void onPlayerVelocity(PlayerVelocityEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerVelocity(event);
	}
	
	@Override
	public void onPlayerGameModeChange(PlayerGameModeChangeEvent event) {
		// TODO Auto-generated method stub
		super.onPlayerGameModeChange(event);
	}
}

class kgfjhgkjh extends EntityListener{
	
	@Override
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		// TODO Auto-generated method stub
		super.onFoodLevelChange(event);
	}
	
	@Override
	public void onEndermanPickup(EndermanPickupEvent event) {
		// TODO Auto-generated method stub
		super.onEndermanPickup(event);
	}
	
	@Override
	public void onEndermanPlace(EndermanPlaceEvent event) {
		// TODO Auto-generated method stub
		super.onEndermanPlace(event);
	}
}

class sdsad extends ServerListener{
	@Override
	public void onMapInitialize(MapInitializeEvent event) {
		// TODO Auto-generated method stub
		super.onMapInitialize(event);
	}
}

class asdsadadhf extends InventoryListener{
}
