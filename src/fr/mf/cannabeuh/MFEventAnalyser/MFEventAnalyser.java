package fr.mf.cannabeuh.MFEventAnalyser;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MFEventAnalyser extends JavaPlugin{
	Logger log = Logger.getLogger("Minecraft");
	
	boolean analyseBlock;
	int blockbreak;
	int blockburn;
	int blockcanbuild;
	int blockdamage;
	int blockdispense;
	int blockfade;
	int blockform;
	int blockformto;
	int blockignite;
	int blockphysics;
	int blockpistonextend;
	int blockpistonretract;
	int blockplace;
	int blockredstone;
	int blockspread;
	int blockleavesdecay;
	int blocksignchange;
	
	boolean analyseWorld;
	int Worldchunkload;
	int Worldchunkunload;
	int Worldchunkpopulated;
	int Worldportalcreate;
	int Worldspawnchange;
	int Worldstructuregrow;
	int Worldinit;
	int Worldload;
	int Worldunload;
	int Worldsave;
	
	boolean analyseEntity;
	int Entitycreaturespawn;
	int Entitycreeperpower;
	int Entityendermanpickup;
	int Entityendermanplace;
	int Entitypigzap;
	int Entityslimesplit;
	
	public void onEnable()
	{
		PluginManager pm=getServer().getPluginManager();
		resetcounteurBlock();
		
		MFBlockEvent blocklisteners = new MFBlockEvent(this);
		pm.registerEvent(Event.Type.BLOCK_BREAK,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_BURN,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_CANBUILD,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_DAMAGE,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_DISPENSE,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_FADE,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_FORM,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_FROMTO,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_IGNITE,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_PHYSICS,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_PISTON_EXTEND,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_PISTON_RETRACT,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_PLACE,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.REDSTONE_CHANGE,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.BLOCK_SPREAD,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.LEAVES_DECAY,blocklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.SIGN_CHANGE,blocklisteners,Priority.Low,this);
		
		MFWorldEvent worldlisteners = new MFWorldEvent(this);
		pm.registerEvent(Event.Type.CHUNK_LOAD,worldlisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.CHUNK_POPULATED,worldlisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.CHUNK_UNLOAD,worldlisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.PORTAL_CREATE,worldlisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.SPAWN_CHANGE,worldlisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.STRUCTURE_GROW,worldlisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.WORLD_INIT,worldlisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.WORLD_LOAD,worldlisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.WORLD_SAVE,worldlisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.WORLD_UNLOAD,worldlisteners,Priority.Low,this);

		MFEntityEvent Entitylisteners = new MFEntityEvent(this);
		pm.registerEvent(Event.Type.CREATURE_SPAWN,Entitylisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.CREEPER_POWER,Entitylisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.ENDERMAN_PICKUP,Entitylisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.ENDERMAN_PLACE,Entitylisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.PIG_ZAP,Entitylisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.SLIME_SPLIT,Entitylisteners,Priority.Low,this);
		
		log.info("[MINE-FRANCE] ############## ANALYSER D'EVENTS ############## ON");
	}
	public void onDisable()
	{
		log.info("[MINE-FRANCE] ############## ANALYSER D'EVENTS ############## OFF");
	}
	public void resetcounteurBlock(){
		analyseBlock=false;
		blockbreak=0;
		blockburn=0;
		blockcanbuild=0;
		blockdamage=0;
		blockdispense=0;
		blockfade=0;
		blockform=0;
		blockformto=0;
		blockignite=0;
		blockphysics=0;
		blockpistonextend=0;
		blockpistonretract=0;
		blockplace=0;
		blockredstone=0;
		blockspread=0;
		blockleavesdecay=0;
		blocksignchange=0;
	}
	public void resetcounteurworld(){
		analyseWorld=false;
		Worldchunkload=0;
		Worldchunkunload=0;
		Worldchunkpopulated=0;
		Worldportalcreate=0;
		Worldspawnchange=0;
		Worldstructuregrow=0;
		Worldinit=0;
		Worldload=0;
		Worldunload=0;
		Worldsave=0;
	}
	public void resetcounteurEntity(){
		analyseEntity=false;
		Entitycreaturespawn=0;
		Entitycreeperpower=0;
		Entityendermanpickup=0;
		Entityendermanplace=0;
		Entitypigzap=0;
		Entityslimesplit=0;
	}
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		Player jsend; 
		if(sender instanceof Player){
			jsend = (Player)sender;
		}else{
			return false;
		}
		String command = cmd.getName().toLowerCase();
		if(command.equals("mfanalyser")){
			String souscommande = ((args.length > 0) ? args[0] : "rien"); 
			if(souscommande.equals("result")){
				String souscommande2 = ((args.length > 1) ? args[1] : "rien");
				if(souscommande2.equals("block")){
					analyseBlock=false;
					jsend.sendMessage("resultat de l'analyse block.");
					jsend.sendMessage("blockbreak:"+blockbreak);
					jsend.sendMessage("blockcanbuild:"+blockcanbuild);
					jsend.sendMessage("blockdamage:"+blockdamage);
					jsend.sendMessage("blockdispense:"+blockdispense);
					jsend.sendMessage("blockfade:"+blockfade);
					jsend.sendMessage("blockform:"+blockform);
					jsend.sendMessage("blockformto:"+blockformto);
					jsend.sendMessage("blockignite:"+blockignite);
					jsend.sendMessage("blockphysics:"+blockphysics);
					jsend.sendMessage("blockpistonextend:"+blockpistonextend);
					jsend.sendMessage("blockpistonretract:"+blockpistonretract);
					jsend.sendMessage("blockplace:"+blockplace);
					jsend.sendMessage("blockredstone:"+blockredstone);
					jsend.sendMessage("blockspread:"+blockspread);
					jsend.sendMessage("blockleavesdecay:"+blockleavesdecay);
					jsend.sendMessage("blocksignchange:"+blocksignchange);
					resetcounteurBlock();
					return true;
				}
				if(souscommande2.equals("world")){
					analyseWorld=false;
					jsend.sendMessage("resultat de l'analyse world.");
					jsend.sendMessage("Worldchunkload:"+Worldchunkload);
					jsend.sendMessage("Worldchunkunload:"+Worldchunkunload);
					jsend.sendMessage("Worldchunkpopulated:"+Worldchunkpopulated);
					jsend.sendMessage("Worldportalcreate:"+Worldportalcreate);
					jsend.sendMessage("Worldspawnchange:"+Worldspawnchange);
					jsend.sendMessage("Worldstructuregrow:"+Worldstructuregrow);
					jsend.sendMessage("Worldinit:"+Worldinit);
					jsend.sendMessage("Worldload:"+Worldload);
					jsend.sendMessage("Worldunload:"+Worldunload);
					jsend.sendMessage("Worldsave:"+Worldsave);
					resetcounteurworld();
					return true;
				}
				if(souscommande2.equals("entity")){
					analyseEntity=false;
					jsend.sendMessage("resultat de l'analyse mob.");
					jsend.sendMessage("Entitycreaturespawn:"+Entitycreaturespawn);
					jsend.sendMessage("Entitycreeperpower:"+Entitycreeperpower);
					jsend.sendMessage("Entityendermanpickup:"+Entityendermanpickup);
					jsend.sendMessage("Entityendermanplace:"+Entityendermanplace);
					jsend.sendMessage("Entitypigzap:"+Entitypigzap);
					jsend.sendMessage("Entityslimesplit:"+Entityslimesplit);
					resetcounteurEntity();
					return true;
				}
				jsend.sendMessage("Result : block, world, entity.");
				return true;
			}
			if(souscommande.equals("block")){
				if(analyseBlock==true){
					analyseBlock=false;
					jsend.sendMessage("AnalyseBlock false.");
					return true;
				}else{
					analyseBlock=true;
					jsend.sendMessage("AnalyseBlock true.");
					return true;
				}
			}
			if(souscommande.equals("world")){
				if(analyseWorld==true){
					analyseWorld=false;
					jsend.sendMessage("analyseWorld false.");
					return true;
				}else{
					analyseWorld=true;
					jsend.sendMessage("analyseWorld true.");
					return true;
				}
			}
			if(souscommande.equals("entity")){
				if(analyseEntity==true){
					analyseEntity=false;
					jsend.sendMessage("AnalyseEntity false.");
					return true;
				}else{
					analyseEntity=true;
					jsend.sendMessage("AnalyseEntity true.");
					return true;
				}
			}
			jsend.sendMessage("Analyser : block, world, entity.");
			return true;
		}
		return false;
	}
}
