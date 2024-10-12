package org.gabhub;

import de.gurkenlabs.litiengine.Game;
//import de.gurkenlabs.
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.input.IMouse;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.input.Mouse;

public class App {
    public static void main(String[] args) {
        Game.info().setName("Sisyphys");
        Game.info().setSubTitle("");

        Game.init(args);

        // Detecting left click
        Game.loop().attach(() -> {
            if (Input.mouse().isPressed() && Input.mouse().isLeftButtonPressed()) {
                System.out.println("LEFT");
            }
        });


        Game.start();
    }
}
