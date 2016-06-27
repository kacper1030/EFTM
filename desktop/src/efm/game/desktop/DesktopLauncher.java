package efm.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import efm.game.EscFromTheMine;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.resizable = false;
		config.width = 480;
		config.height = 800;
		
		config.title = "ESC from the mine";
		
		new LwjglApplication(new EscFromTheMine(), config);
	}
}
