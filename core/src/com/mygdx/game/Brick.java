package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Eric on 26.03.2017.
 */
public class Brick extends Actor {
    private ShapeRenderer shapeRenderer;
    private Color color;
    private int width;
    private int height;
    private int posX;
    private int posY;
    private boolean isReversed;
    private boolean isGuessed;
    private String imagePath;
    private Sound sound;

    public Brick(int width, int height, int posX, int posY, String imagePath, Sound sound) {
        shapeRenderer = new ShapeRenderer();
        color = Color.BLUE;
        isReversed = true;
        isGuessed = false;
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
        this.imagePath = imagePath;
        this.setSize(width, height);
        this.setBounds(posX, posY, width, height);
        this.addListener(new SimpleClickListener());
        this.sound = sound;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isReversed() {
        return isReversed;
    }

    public void setReversed(boolean reversed) {
        isReversed = reversed;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public boolean isGuessed() {
        return isGuessed;
    }

    public void setGuessed(boolean guessed) {
        isGuessed = guessed;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (isReversed) {
            batch.draw(new Texture("logo_java.png"), posX, posY, width, height);
        } else {
            batch.draw(new Texture(imagePath), posX, posY, width, height);

        }
    }
}
