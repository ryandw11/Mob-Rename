package me.ryandw11.core.core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.HelpCommand;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;


import me.ryandw11.core.command.*;
import me.ryandw11.core.listener.joinListener;


public class Main extends JavaPlugin implements Listener{
	
	public final Logger logger = Logger.getLogger("Minecraft");
	public Main plugin;
	
	public File name = new File(getDataFolder() + "/namedata.yml");
	public FileConfiguration na = YamlConfiguration.loadConfiguration(name);
	
	
	@Override
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info("Core+ has been enabled!"); // prints into the log
		loadMethoid();
		getCommand("core").setExecutor(new helpCommand());
		loadFile();
	}
	
	@Override
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		logger.info("Core+ has been disabled!"); // same thing
		saveFile();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// =============================================
	
public static ArrayList<UUID> toggle = new ArrayList<>();
	
	public static String mobname;
	public static String Color;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
		if(!(sender instanceof Player)) return true;
		 mobname = args[0];
		Player p = (Player) sender;
		
		
			if(args.length == 1 && args[0].equalsIgnoreCase("?")){
			p.sendMessage(ChatColor.GREEN + "===================[Help]===================");
			p.sendMessage(ChatColor.GOLD + "/rename toggle : Turns on and off you magical rename hand!");
			p.sendMessage(ChatColor.GOLD + "/rename (name) (Color) :chage the text and color of your magical hand");
			p.sendMessage(ChatColor.LIGHT_PURPLE + "Vailid colors: : White, Black, Blue, LightBlue, Red, Green, Aaqua, Yellow, Purple, DarkGrey, Grey.");
		}
			if(p.hasPermission("core.rename") || p.isOp()){
		
		 if(args.length == 2 && args[1].equalsIgnoreCase("white")){
			p.sendMessage(ChatColor.GREEN + "Plase click on the mob you want renamed!");
			
			Color = "§f";
			
			}
		 else if(args.length == 1 && args[0].equalsIgnoreCase("toggle")){
			
			if(toggle.contains(p.getUniqueId())){
				toggle.remove(p.getUniqueId());
				p.sendMessage(ChatColor.BLUE + "You have disabled rename. All mobs you click will not be renamed");
				
			}
			else{
				toggle.add(p.getUniqueId());
				p.sendMessage(ChatColor.BLUE + "You have Enabled rename. All mobs you click will be renamed!");
				Color = "§f";
			}
			
			}
		else if(args.length == 2 && args[1].equalsIgnoreCase("Green")){
			
			p.sendMessage(ChatColor.GREEN + "Please click on the mob you want renamed!");
			
			Color = "§2";
			
			}
		else if(args.length == 2 && args[1].equalsIgnoreCase("Red")){
			
			p.sendMessage(ChatColor.GREEN + "Please click on the mob you want renamed!");
			
			Color = "§4";
			
			}
		else if(args.length == 2 && args[1].equalsIgnoreCase("PurPle")){
			
			p.sendMessage(ChatColor.GREEN + "Please click on the mob you want renamed!");
			
			Color = "§5";
			
			}
		else if(args.length == 2 && args[1].equalsIgnoreCase("Blue")){
			
			p.sendMessage(ChatColor.GREEN + "Please click on the mob you want renamed!");
			
			Color = "§1";
			
			}
		else if(args.length == 2 && args[1].equalsIgnoreCase("yellow")){
			
			p.sendMessage(ChatColor.GREEN + "Please click on the mob you want renamed!");
			
			Color = "§6";
			
			}
		else if(args.length == 2 && args[1].equalsIgnoreCase("Black")){
			
			p.sendMessage(ChatColor.GREEN + "Please click on the mob you want renamed!");
			
			Color = "§0";
			
			}
		else if(args.length == 2 && args[1].equalsIgnoreCase("aqua")){
			
			p.sendMessage(ChatColor.GREEN + "Please click on the mob you want renamed!");
			
			Color = "§3";
			
			}
		else if(args.length == 2 && args[1].equalsIgnoreCase("grey")){
			
			p.sendMessage(ChatColor.GREEN + "Please click on the mob you want renamed!");
			
			Color = "§7";
			
			}
		else if(args.length == 2 && args[1].equalsIgnoreCase("darkgrey")){
			
			p.sendMessage(ChatColor.GREEN + "Please click on the mob you want renamed!");
			
			Color = "§8";
			
			}
		else if(args.length == 2 && args[1].equalsIgnoreCase("lightblue")){
			
			p.sendMessage(ChatColor.GREEN + "Please click on the mob you want renamed!");
			
			Color = "§9";
			
			}
		
		
			
			
		
		
		}//end of perm check
		
		
		return false;
	}
	
	
	
	
	@EventHandler
	public void renameEntity(PlayerInteractEntityEvent event){
		Player p = (Player) event.getPlayer();
		Player player = (Player) event.getPlayer();
		Entity e = event.getRightClicked();
		if(p.hasPermission("core.rename") || p.isOp()){
			if(toggle.contains(p.getUniqueId())){
			
			
		//if(!(e instanceof Player)){
			//if(Color.equals("Null")){
//				if(names.contains(p.getUniqueId())){
					e.setCustomName(Color +  mobname);
					p.sendMessage(ChatColor.GREEN + "[Mob] Your mob has been renamed!");
//					names.remove(p.getUniqueId());
					
//				
//				}
//		
//		
			}//end of color check
			//else if(Color.equalsIgnoreCase("green")){
//				if(names.contains(p.getUniqueId())){
					
//					names.remove(p.getUniqueId());
		}
//				}
//		
//		
			//}//end of color check
		//}
		//}
		//}
	}
}
