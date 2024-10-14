package com.gabhub.sisyphus;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class App extends ApplicationAdapter {
    private SpriteBatch batch;
    Texture map;
    Texture background;
    Texture playerTexture;
    Sprite playerSprite;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        batch = new SpriteBatch();
        background = new Texture("maps/background_default.png");
        map = new Texture("maps/level_main.png");
        playerTexture = new Texture("player/adventurer-idle.png");
        playerSprite = new Sprite(playerTexture);
        playerSprite.setSize(96, 96);
    }

    @Override
    public void render() {
        input();

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.draw(map, 0, 0);
        playerSprite.draw(batch);

        batch.end();
    }

    private void input() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            float posX = playerSprite.getX();
            float posY = playerSprite.getY();

            playerSprite.setPosition(posX+1, posY+1);
            Gdx.app.debug("MyTag", "my debug message");
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        map.dispose();
        background.dispose();
        playerTexture.dispose();
    }
}
