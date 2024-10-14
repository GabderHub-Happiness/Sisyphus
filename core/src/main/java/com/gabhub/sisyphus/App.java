package com.gabhub.sisyphus;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ApplicationAdapter {
    private SpriteBatch batch;
    Texture map;
    Texture background;
    Texture playerSprite;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new Texture("maps/background_default.png");
        map = new Texture("maps/level_main.png");
        playerSprite  = new Texture("adventurer-idle.png");

    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(map, 0, 0);
        batch.draw(playerSprite, 0, 0);
        batch.end();

        input();
    }

    private void input() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))  {

        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        map.dispose();
        background.dispose();
    }
}
