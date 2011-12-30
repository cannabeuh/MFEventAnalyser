package fr.mf.cannabeuh.MFEventAnalyser;

import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreeperPowerEvent;
import org.bukkit.event.entity.EndermanPickupEvent;
import org.bukkit.event.entity.EndermanPlaceEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.PigZapEvent;
import org.bukkit.event.entity.SlimeSplitEvent;

public class MFEntityEvent extends EntityListener {
	MFEventAnalyser plugin;
	public MFEntityEvent(MFEventAnalyser mfEventAnalyser) {
		plugin = mfEventAnalyser;
	}
	public void onCreatureSpawn(CreatureSpawnEvent event){
		if(plugin.analyseEntity==true){
			plugin.Entitycreaturespawn++;
		}
	}
	public void onCreeperPower(CreeperPowerEvent event){
		if(plugin.analyseEntity==true){
			plugin.Entitycreeperpower++;
		}
	}
	public void onEndermanPickup(EndermanPickupEvent event){
		if(plugin.analyseEntity==true){
			plugin.Entityendermanpickup++;
		}
	}
	public void onEndermanPlace(EndermanPlaceEvent event){
		if(plugin.analyseEntity==true){
			plugin.Entityendermanplace++;
		}
	}
	public void onPigZap(PigZapEvent event){
		if(plugin.analyseEntity==true){
			plugin.Entitypigzap++;
		}
	}
	public void onSlimeSplit(SlimeSplitEvent event){
		if(plugin.analyseEntity==true){
			plugin.Entityslimesplit++;
		}
	}
}
