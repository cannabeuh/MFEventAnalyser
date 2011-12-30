package fr.mf.cannabeuh.MFEventAnalyser;

import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.bukkit.event.world.ChunkUnloadEvent;
import org.bukkit.event.world.WorldListener;

public class MFChunkEvent extends WorldListener {
	MFEventAnalyser plugin;
	public MFChunkEvent(MFEventAnalyser mfEventAnalyser) {
		plugin = mfEventAnalyser;
	}
	public void onChunkLoad(ChunkLoadEvent event){
		if(plugin.analyseChunk==true){
			plugin.chunkload++;
		}
	}
	public void onChunkPopulate(ChunkPopulateEvent event){
		if(plugin.analyseChunk==true){
			plugin.chunkpopulated++;
		}
	}
	public void onChunkUnload(ChunkUnloadEvent event){
		if(plugin.analyseChunk==true){
			plugin.chunkunload++;
		}
	}
}
