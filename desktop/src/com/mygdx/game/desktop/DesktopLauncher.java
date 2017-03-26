package com.mygdx.game.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
    public static void main(String[] arg) {
        //Graphics.Monitor[] monitors = Gdx.graphics.getMonitors();
//        Graphics.DisplayMode[] modes = Gdx.graphics.getDisplayModes(monitor);
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        Graphics.DisplayMode displayMode = LwjglApplicationConfiguration.getDesktopDisplayMode();
        config.setFromDisplayMode(displayMode);

        new LwjglApplication(new MyGdxGame(), config);
    }
}
