package fr.mf.cannabeuh.MFEventAnalyser;

import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;

public class MFBlockEvent extends BlockListener {
	MFEventAnalyser plugin;
	public MFBlockEvent(MFEventAnalyser mfEventAnalyser) {
		plugin = mfEventAnalyser;
	}
	public void onBlockBreak(BlockBreakEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockbreak++;
		}
	}
	public void onBlockBurn(BlockBurnEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockburn++;
		}
	}
	public void onBlockCanBuild(BlockCanBuildEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockcanbuild++;
		}
	}
	public void onBlockDamage(BlockDamageEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockdamage++;
		}
	}
	public void onBlockDispense(BlockDispenseEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockdispense++;
		}
	}
	public void onBlockFade(BlockFadeEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockfade++;
		}
	}
	public void onBlockForm(BlockFormEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockform++;
		}
	}
	public void onBlockFromTo(BlockFromToEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockformto++;
		}
	}
	public void onBlockIgnite(BlockIgniteEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockignite++;
		}
	}
	public void onBlockPhysics(BlockPhysicsEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockphysics++;
		}
	}
	public void onBlockPistonExtend(BlockPistonExtendEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockpistonextend++;
		}
	}
	public void onBlockPistonRetract(BlockPistonRetractEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockpistonextend++;
		}
	}
	public void onBlockPlace(BlockPlaceEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockplace++;
		}
	}
	public void onBlockSpread(BlockSpreadEvent event){
		if(plugin.analyseBlock==true){
			plugin.blockspread++;
		}
	}
}
