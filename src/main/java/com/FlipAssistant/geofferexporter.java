package com.FlipAssistant;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GrandExchangeOfferChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@PluginDescriptor(
	name = "Flip Assistant"
)
public class geofferexporter extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private geofferexporterconfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Flip Assistant started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Flip Assistant stopped!");
	}

	@Subscribe
	public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged offerChangedEvent)
	{
		String items = new String();

		GrandExchangeOffer[] offers = client.getGrandExchangeOffers();

		for(GrandExchangeOffer offer: offers)
		{
			items = items + offer.getItemId() + '\n';
		}

		String filename = System.getProperty("user.home") + "\\.runelite\\FlipAssistant_FlipIDs.txt";

		CreateFile(filename);
		WriteToFile(filename, items);

	}

	public static boolean CreateFile(String filename) {

		try {
			File myObj = new File(filename);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
			return true;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return false;
		}
	}

	public static boolean WriteToFile(String filename, String text)
	{
		try {
			FileWriter myWriter = new FileWriter(filename);
			myWriter.write(text);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
			return true;
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return false;
		}
	}
	@Provides
	geofferexporterconfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(geofferexporterconfig.class);
	}

}
