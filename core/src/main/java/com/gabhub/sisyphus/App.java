package com.gabhub.sisyphus;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class App extends ApplicationAdapter {
    private static final int FRAME_COLS = 1, FRAME_ROWS = 24;
    Animation<TextureRegion> runAnimation;
    Texture runSheet;

    float stateTime = 0;
    private SpriteBatch batch;
    Texture map;
    Texture background;
    Texture playerTexture;
    Sprite playerSprite;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        runSheet = new Texture("player/spritesheet.png");


        TextureRegion[][] tmp = TextureRegion.split(runSheet,
            runSheet.getWidth() / FRAME_COLS,
            runSheet.getHeight() / FRAME_ROWS);

        TextureRegion[] runFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                runFrames[index++] = tmp[i][j];
            }
        }
        runAnimation = new Animation<>(3f, runFrames);

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
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time

        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();

        // Get current frame of animation for the current stateTime
        TextureRegion currentFrame = runAnimation.getKeyFrame(stateTime, true);
        Gdx.app.debug("MyTag", String.valueOf(currentFrame));
        batch.draw(currentFrame, 0, 0); // Draw current frame at (50, 50)
        batch.draw(background, 0, 0);
        batch.draw(map, 0, 0);
//        playerSprite.draw(batch);

        batch.end();
    }

    private void input() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            float posX = playerSprite.getX();
            float posY = playerSprite.getY();

            playerSprite.setPosition(posX + 1, posY + 1);
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
