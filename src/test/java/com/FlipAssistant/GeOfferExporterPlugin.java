package com.FlipAssistant;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GeOfferExporterPlugin
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GeOfferExporter.class);
		RuneLite.main(args);
	}
}