package com.uniti.mazeapp;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.glutils.HdpiMode;
import com.uniti.mazeapp.MazeApp;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("UNITI MazeApp");
		config.setResizable(false);
		config.setWindowedMode(1080,720);
//		config.setWindowedMode(1280,720);
		new Lwjgl3Application(new MazeApp(), config);
	}
}
