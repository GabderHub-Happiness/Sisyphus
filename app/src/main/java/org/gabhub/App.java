package org.gabhub;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.resources.Resources;

public class App {
    public static void main(String[] args) {
        Game.info().setName("Sisyphys");
        Game.info().setSubTitle("");
        Game.init(args);

        // Add text
        Game.screens().add(new TestScreen());
        Game.screens().display("MENU");

        // detecting left click
        Game.loop().attach(() -> {
            if (Input.mouse().isPressed() && Input.mouse().isLeftButtonPressed()) {
                System.out.println("LEFT");
            }
        });

        // load map
        Resources.load("game.litidata");
        System.out.println(Resources.maps().getAll());
//        Game.world().loadEnvironment("???");

        Game.start();
    }
}