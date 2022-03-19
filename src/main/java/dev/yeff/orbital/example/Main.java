package dev.yeff.orbital.example;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.example.scenes.MainScene;
import dev.yeff.orbital.scenes.Scene;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Scene> scenes = Map.of(
                "Main", new MainScene()
        );

        Game game = new Game(
                700,
                700,
                "Hello World",
                scenes
        );

        game.start("Main");
    }
}
