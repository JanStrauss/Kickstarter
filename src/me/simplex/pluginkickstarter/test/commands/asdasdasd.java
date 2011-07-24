package me.simplex.pluginkickstarter.test.commands;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
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
}
