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
	int blockspread;
	
	boolean analyseChunk;
	int chunkload;
	int chunkunload;
	int chunkpopulated;
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
		pm.registerEvent(Event.Type.BLOCK_SPREAD,blocklisteners,Priority.Low,this);
		
		MFChunkEvent chunklisteners = new MFChunkEvent(this);
		pm.registerEvent(Event.Type.CHUNK_LOAD,chunklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.CHUNK_POPULATED,chunklisteners,Priority.Low,this);
		pm.registerEvent(Event.Type.CHUNK_UNLOAD,chunklisteners,Priority.Low,this);
		
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
		blockspread=0;
	}
	public void resetcounteurChunk(){
		analyseChunk=false;
		chunkload=0;
		chunkunload=0;
		chunkpopulated=0;
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
					jsend.sendMessage("resultat de l'analyse.");
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
					jsend.sendMessage("blockspread:"+blockspread);
					resetcounteurBlock();
					return true;
				}
				if(souscommande2.equals("chunk")){
					analyseChunk=false;
					jsend.sendMessage("resultat de l'analyse.");
					jsend.sendMessage("chunkload:"+chunkload);
					jsend.sendMessage("chunkunload:"+chunkunload);
					jsend.sendMessage("chunkpopulated:"+chunkpopulated);
					resetcounteurChunk();
					return true;
				}
				jsend.sendMessage("Result : block, chunk.");
				return true;
			}
			if(souscommande.equals("block")){
				if(analyseBlock==true){
					jsend.sendMessage("AnalyseBlock false.");
					return true;
				}else{
					analyseBlock=true;
					jsend.sendMessage("AnalyseBlock true.");
					return true;
				}
			}
			if(souscommande.equals("chunk")){
				if(analyseChunk==true){
					jsend.sendMessage("AnalyseChunk false.");
					return true;
				}else{
					analyseChunk=true;
					jsend.sendMessage("AnalyseChunk true.");
					return true;
				}
			}
			jsend.sendMessage("Analyser : block, chunk.");
			return true;
		}
		return false;
	}
}
