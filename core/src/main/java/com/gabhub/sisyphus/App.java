package com.gabhub.sisyphus;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class App extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture map;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        map = new Texture("maps/level_1.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(map, 140, 210);
        batch.end();

        input();



    }

    private void input() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            Gdx.app.debug("MyTag", "LEFT");
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        map.dispose();
    }
}
