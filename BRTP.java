package com.javaminecraft;

import java.util.Random;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.*;
import java.util.HashMap;

// fix the cooldown so its longer (add cd variable)

// try ChatColor.RED + "Your string here";

public class BRTP extends JavaPlugin {
    public static Random rand = new Random();
    public HashMap<String, Long> cooldown = new HashMap<>();
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        
        /*
        rtp command to go with the dynmap plugin
        */
        if(label.equalsIgnoreCase("rtp")) {
            
            
            //checks if a player is sending the command
            if(sender instanceof Player) {
                Player me = (Player) sender;
                World world = me.getWorld();
                
                // checks if they are on cooldown
                if(cooldown.get(me.getName()) != null) {
                    if(cooldown.get(me.getName()) > System.currentTimeMillis()) {
                        me.sendMessage("RTP is on cooldown");
                        return false;
                    }
                }
                
                if(arguments.length < 1) {
                    me.sendMessage("Please enter the name of a location ex: US, SA, EUR, AFR, ASIA");
                    return false;
                }
                
                //subcommand to teleport to the US
                if(arguments[0].equalsIgnoreCase("US")) {
                    double tpx, tpy, tpz;
                    tpx = (double)rand.nextInt(2680)*-1 - 4800;
                    tpy = (double)255;
                    tpz = (double)rand.nextInt(1170)*-1 - 1830;
                    Location dest = new Location(world, tpx, tpy, tpz);
                    
                    while(dest.getBlock().getType() == Material.AIR) {
                        tpy--;     
                        dest = new Location(world, tpx, tpy, tpz);
                        
                    }   
                    
                    if(dest.getBlock().getType() == Material.WATER || dest.getBlock().getType() == Material.LAVA) {
                        me.chat("/rtp US");
                        return false;
                    }
                    
                    dest = new Location(world, tpx, tpy + 5, tpz);
                
                    me.teleport(dest);
                    cooldown.put(me.getName(), System.currentTimeMillis() + 10000);
                    return true;
                }
                
                
                // sumcommand to teleport to south america
                if(arguments[0].equalsIgnoreCase("SA")) {
                    double tpx, tpy, tpz;
                    tpx = (double)rand.nextInt(704) - 4548;
                    tpy = (double)255;
                    tpz = (double)rand.nextInt(3124) - 696;
                    Location dest = new Location(world, tpx, tpy, tpz);
                    
                    while(dest.getBlock().getType() == Material.AIR) {
                        tpy--;     
                        dest = new Location(world, tpx, tpy, tpz);
                        
                    }
                    
                    if(dest.getBlock().getType() == Material.WATER || dest.getBlock().getType() == Material.LAVA) {
                        me.chat("/rtp SA");
                        return false;
                    } 
                    
                    dest = new Location(world, tpx, tpy + 5, tpz);
                    
                    me.teleport(dest);
                    cooldown.put(me.getName(), System.currentTimeMillis() + 10000);
                    return true;
                }
                
                
                // sumcommand to teleport to africa
                if(arguments[0].equalsIgnoreCase("AFR")) {
                    double tpx, tpy, tpz;
                    tpx = (double)rand.nextInt(1360) + 400;
                    tpy = (double)255;
                    tpz = (double)rand.nextInt(3792) - 1976;
                    Location dest = new Location(world, tpx, tpy, tpz);
                    
                    while(dest.getBlock().getType() == Material.AIR) {
                        tpy--;     
                        dest = new Location(world, tpx, tpy, tpz);
                        
                    }
                    
                    if(dest.getBlock().getType() == Material.WATER || dest.getBlock().getType() == Material.LAVA) {
                        me.chat("/rtp AFR");
                        return false;
                    } 
                    
                    dest = new Location(world, tpx, tpy + 5, tpz);
                    
                    me.teleport(dest);
                    cooldown.put(me.getName(), System.currentTimeMillis() + 10000);
                    return true;
                }
                
                // sumcommand to teleport to eurasia
                if(arguments[0].equalsIgnoreCase("EUR")) {
                    double tpx, tpy, tpz;
                    tpx = (double)rand.nextInt(4000) + 296;
                    tpy = (double)255;
                    tpz = (double)rand.nextInt(288) - 3112;
                    Location dest = new Location(world, tpx, tpy, tpz);
                    
                    while(dest.getBlock().getType() == Material.AIR) {
                        tpy--;     
                        dest = new Location(world, tpx, tpy, tpz);
                        
                    }
                    
                    if(dest.getBlock().getType() == Material.WATER || dest.getBlock().getType() == Material.LAVA) {
                        me.chat("/rtp EUR");
                        return false;
                    } 
                    
                    dest = new Location(world, tpx, tpy + 5, tpz);
                    
                    me.teleport(dest);
                    cooldown.put(me.getName(), System.currentTimeMillis() + 10000);
                    return true;
                }
                
                
                // sumcommand for asia
                if(arguments[0].equalsIgnoreCase("asia")) {
                    double tpx, tpy, tpz;
                    tpx = (double)rand.nextInt(2560) + 4280;
                    tpy = (double)255;
                    tpz = (double)rand.nextInt(704) - 2176;
                    Location dest = new Location(world, tpx, tpy, tpz);
                    
                    while(dest.getBlock().getType() == Material.AIR) {
                        tpy--;     
                        dest = new Location(world, tpx, tpy, tpz);
                        
                    }
                    
                    if(dest.getBlock().getType() == Material.WATER || dest.getBlock().getType() == Material.LAVA) {
                        me.chat("/rtp asia");
                        return false;
                    } 
                    
                    dest = new Location(world, tpx, tpy + 5, tpz);
                    
                    me.teleport(dest);
                    cooldown.put(me.getName(), System.currentTimeMillis() + 10000);
                    return true;
                }
                
                me.sendMessage("Please use the codes: US, SA, EUR, AFR, ASIA");
                return false;
                
            }
        }
        
        if(label.equalsIgnoreCase("colortest")) {
            Player me = (Player) sender;
            me.sendMessage("&4U&fS&1A");
        }
        
    return false;
    }
}