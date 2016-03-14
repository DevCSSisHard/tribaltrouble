package com.oddlabs.tt;

import com.oddlabs.tt.render.Renderer;
import com.oddlabs.tt.util.Utils;
import java.util.ResourceBundle;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;

public final strictfp class Main {
	public static void fail(Throwable t) {
		try {
			t.printStackTrace();
			if (Display.isCreated())
				Display.destroy();
			while (t.getCause() != null)
				t = t.getCause();
			ResourceBundle bundle = ResourceBundle.getBundle(Main.class.getName());
			String error = Utils.getBundleString(bundle, "error");
			String error_msg = Utils.getBundleString(bundle, "error_message", new Object[]{t.toString()});
			Sys.alert(error, error_msg);
		} finally {
			shutdown();
		}
	}

	public static void shutdown() {
        System.out.println("Exiting");
		System.exit(0);
	}

	public static void main(String[] args) {
		try {
			System.out.println("Starting game....");
			System.out.flush();
			System.setProperty("org.lwjgl.util.Debug", "true");
/*System.out.println("System.getProperty(\"java.library.path\") = " + System.getProperty("java.library.path"));*/
			Main.class.getClassLoader().setDefaultAssertionStatus(true);
			Renderer.runGame(args);
		} catch (Throwable t) {
			fail(t);
		} finally {
			shutdown();
		}
	}
}
