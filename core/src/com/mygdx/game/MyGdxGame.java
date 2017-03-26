package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.util.*;

public class MyGdxGame extends ApplicationAdapter {

    Stage stage;
    ArrayList<Brick> bricks = new ArrayList<Brick>();

    @Override
    public void create() {
        stage = new Stage(new ScreenViewport());
        bricks = createCards(2, 4, 35, 200, 200);
        addToStage(stage, bricks);
        Gdx.input.setInputProcessor(stage);
    }

    private void addToStage(Stage stage, ArrayList<Brick> bricks) {
        for (Brick brick : bricks) {
            stage.addActor(brick);
        }
    }

    private ArrayList<Brick> createCards(int columns, int rows, int margin, int width, int height) {
        ArrayList<Brick> bricks = getRawBricks(columns * rows, width, height);
        int totalWidth = this.stage.getViewport().getScreenWidth();
        int totalHeight = this.stage.getViewport().getScreenHeight();
        int startX = (totalWidth - columns * width - (columns - 1) * margin) / 2;
        int startY = (totalHeight - rows * height - (rows - 1) * margin) / 2;
        int k=0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                int xPosition = startX + i * (width + margin);
                int yPosition = startY + j * (height + margin);
                Brick brick = bricks.get(k);
                brick.setPosX(xPosition);
                brick.setPosY(yPosition);
                brick.setBounds(xPosition, yPosition, width, height);
                k++;
            }
        }
        return bricks;

    }

    /**
     * Returns bricks without coordinates collected as ArrayList
     * @param bricksNumber
     * @param width
     * @param height
     * @return
     */
    private ArrayList<Brick> getRawBricks(int bricksNumber, int width, int height) {
        ArrayList<Brick> bricks = new ArrayList<Brick>();
        String[] imagePaths = {"A.png", "B.png", "C.png", "D.png"};
        String[] sounds = {"ges.mp3", "robot.mp3", "kaczka.mp3", "arrow.mp3"};
        for (int i=0; i<bricksNumber; i++) {
            bricks.add(new Brick(width, height, 0, 0, imagePaths[i/2], Gdx.audio.newSound(Gdx.files.internal(sounds[i/2]))));
        }
        return bricks;
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(1, 1, 0, 0);
        stage.draw();
    }

    @Override
    public void dispose() {

    }
}
