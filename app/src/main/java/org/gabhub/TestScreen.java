package org.gabhub;

import java.awt.Color;
import java.awt.Graphics2D;

import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.resources.Resources;

public class TestScreen extends GameScreen {
    public TestScreen() {
        super("TEST");
    }
    @Override
    public void render(final Graphics2D g) {
        super.render(g);
        g.setFont(Resources.fonts().get("customfont.ttf",32f));
        g.setColor(Color.RED);
        TextRenderer.render(g, "Test text", 100, 100);
    }
}
