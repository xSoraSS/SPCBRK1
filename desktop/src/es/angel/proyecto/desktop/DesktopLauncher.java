package es.angel.proyecto.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import es.angel.proyecto.SPCBRK;

public class DesktopLauncher {
	public static void main (String[] arg) {

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//Graphics.DisplayMode displayMode = LwjglApplicationConfiguration.getDesktopDisplayMode();
	//	config.setFromDisplayMode(displayMode);

		new LwjglApplication(new SPCBRK(), config);
	}
}
