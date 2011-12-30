package fr.mf.cannabeuh.MFEventAnalyser;

import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.event.world.SpawnChangeEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.event.world.WorldListener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.event.world.WorldUnloadEvent;

public class MFWorldEvent extends WorldListener {
	MFEventAnalyser plugin;
	public MFWorldEvent(MFEventAnalyser mfEventAnalyser) {
		plugin = mfEventAnalyser;
	}
	public void onChunkLoad(ChunkLoadEvent event){
		if(plugin.analyseWorld==true){
			plugin.Worldchunkload++;
		}
	}
	public void onChunkPopulate(ChunkPopulateEvent event){
		if(plugin.analyseWorld==true){
			plugin.Worldchunkpopulated++;
		}
	}
	public void onChunkUnload(ChunkUnloadEvent event){
		if(plugin.analyseWorld==true){
			plugin.Worldchunkunload++;
		}
	}
	public void onPortalCreate(PortalCreateEvent event){
		if(plugin.analyseWorld==true){
			plugin.Worldportalcreate++;
		}
	}
	public void onSpawnChange(SpawnChangeEvent event){
		if(plugin.analyseWorld==true){
			plugin.Worldspawnchange++;
		}
	}
	public void onStructureGrow(StructureGrowEvent event){
		if(plugin.analyseWorld==true){
			plugin.Worldstructuregrow++;
		}
	}
	public void onWorldInit(WorldInitEvent event){
		if(plugin.analyseWorld==true){
			plugin.Worldinit++;
		}
	}
	public void onWorldLoad(WorldLoadEvent event){
		if(plugin.analyseWorld==true){
			plugin.Worldload++;
		}
	}
	public void onWorldSave(WorldSaveEvent event){
		if(plugin.analyseWorld==true){
			plugin.Worldsave++;
		}
	}
	public void onWorldUnload(WorldUnloadEvent event){
		if(plugin.analyseWorld==true){
			plugin.Worldunload++;
		}
	}
}
