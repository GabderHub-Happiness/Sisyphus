package com.gabhub.sisyphus;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class App extends ApplicationAdapter {
    private SpriteBatch batch;
    Texture mapTexture;
    Texture backgroundTexture;

    @Override
    public void create() {
        batch = new SpriteBatch();
        backgroundTexture = new Texture("maps/background_default.png");
        mapTexture = new Texture("maps/level_main.png");

    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(mapTexture, 0, 0);
        batch.draw(backgroundTexture, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        mapTexture.dispose();
        backgroundTexture.dispose();
    }
}
