package fr.mf.cannabeuh.MFEventAnalyser;

import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.WorldListener;

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
}
