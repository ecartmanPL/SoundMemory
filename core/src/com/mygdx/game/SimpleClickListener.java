package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

/**
 * Created by Eric on 26.03.2017.
 */
public class SimpleClickListener extends InputListener {
    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        Brick brick = (Brick)event.getTarget();
        if (!brick.isGuessed()){
            brick.getSound().play();
            if (brick.isReversed()) {
                brick.setReversed(false);
            } else {
                brick.setReversed(true);
            }
            return true;
        }
        System.out.println("Kliknales na odgadnieta karte!");
        return false;

    }
}
