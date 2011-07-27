package me.simplex.pluginkickstarter.test.commands;

import me.simplex.pluginkickstarter.test.PluginMainDummy;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commandexe implements CommandExecutor {
	private PluginMainDummy plugin;
	
	public Commandexe(PluginMainDummy plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) {
		if(command.getName().equalsIgnoreCase("Advertise")){
		     if (args.length == 0){
		          sender.sendMessage("You must specify something to advertise");
		     }else{
		 		if (!(sender instanceof Player)) {
					sender.sendMessage("restricted to players only");
					return true;
				}
		 		String bla="";
		 		for(String s : args){
		 		bla=bla+s+" ";
		 		}
		 		bla.trim();
		 		plugin.isEnabled();
		 		
				Player player = (Player)sender;
				
				Material mat_to_check = Material.ARROW;
				ItemStack[] contents = player.getInventory().getContents();
				boolean found = false;
				for (ItemStack itemStack : contents) {
					if (itemStack.getType().equals(mat_to_check)) {
						itemStack.setAmount(itemStack.getAmount()-1);
						found = true;
						break;
					}
				}
				player.getInventory().setContents(contents);
				if (found) {
			 		sender.getServer().broadcastMessage(bla);
				}
				else {
					sender.sendMessage("You dont have the Item needed to advertise");
				}
		          return true;
		     }
		}
		return false;
	}
}
