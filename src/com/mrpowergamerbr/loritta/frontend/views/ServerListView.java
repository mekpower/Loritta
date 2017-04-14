package com.mrpowergamerbr.loritta.frontend.views;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import org.jooby.Request;
import org.jooby.Response;

import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import com.mrpowergamerbr.loritta.LorittaLauncher;
import com.mrpowergamerbr.loritta.frontend.LorittaWebsite;
import com.mrpowergamerbr.loritta.frontend.utils.RenderWrapper;

public class ServerListView {

	public static Object render(Request req, Response res) {
		try {
			HashMap<String, Object> context = new HashMap<String, Object>();

			context.put("guilds", LorittaLauncher.getInstance().getJda().getGuilds());
			
			PebbleTemplate template = LorittaWebsite.engine.getTemplate("server_list.html");

			return new RenderWrapper(template, context);
		} catch (PebbleException e) {
			// TODO Auto-generated catch block
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			return e.toString();
		}
	}
}