package org.example;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class Launcher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext("webapp", "/");

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            // fix for Windows, so Jetty doesn't lock files
            context.getInitParams().put("org.eclipse.jetty.servlet.Default.useFileMappedBuffer", "false");
        }

        server.setHandler(context);
        server.start();
    }
}