package com.sample.app;

import java.io.File;

import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.MagicBooleans;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.utils.IOUtils;

public class HelloWorld {

	public static void main(String args[]) {
		try {

			String resourcesPath = getResourcesPath();
			MagicBooleans.trace_mode = false;
			Bot bot = new Bot("Megamind", resourcesPath);
			Chat chatSession = new Chat(bot);
			bot.brain.nodeStats();

			while (true) {
				System.out.print("Human : ");
				String input = IOUtils.readInputTextLine();

				if ((input == null) || (input.length() < 1))
					input = MagicStrings.null_input;
				if ("q".equalsIgnoreCase(input)) {
					System.exit(0);
				} else {
					String response = chatSession.multisentenceRespond(input);
					System.out.println("Robot : " + response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static String getResourcesPath() {
		String path = new File(".").getAbsolutePath();
		path = path.substring(0, path.length() - 2);
		String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
		return resourcesPath;
	}

}
