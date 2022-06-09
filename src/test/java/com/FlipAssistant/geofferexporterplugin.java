package com.FlipAssistant;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class geofferexporterplugin
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(geofferexporter.class);
		RuneLite.main(args);
	}
}