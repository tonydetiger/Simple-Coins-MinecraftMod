package com.TonyTiger.simplecoins;

import com.TonyTiger.simplecoins.TileEntity.ModTileEntities;
import com.TonyTiger.simplecoins.block.ModBlocks;
import com.TonyTiger.simplecoins.client.render.blocks.BlockRenderRegister;
import com.TonyTiger.simplecoins.client.render.items.ItemRenderRegister;
import com.TonyTiger.simplecoins.crafting.ModCrafting;
import com.TonyTiger.simplecoins.event.EventHandlerCommon;
import com.TonyTiger.simplecoins.items.ModItems;
import com.TonyTiger.simplecoins.network.ModGuiHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class ClientProxy {
	public void preInit(FMLPreInitializationEvent e){
		ModItems.createItems();
		ModTileEntities.init();
		ModBlocks.createBlocks();
	}
	public void init(FMLInitializationEvent e){
		ItemRenderRegister.registerItemRenderer();
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new ModGuiHandler());
		BlockRenderRegister.registerBlockRenderer();
		ModCrafting.initCrafting();
		MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
	}
	public void postInit(FMLPostInitializationEvent e){
		
	}
}
