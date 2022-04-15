package dev.yeff.orbital.example.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.example.components.ColorChanger;
import dev.yeff.orbital.example.components.PlayerMovement;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

public class MainScene extends Scene {
    private GameObject player;

    @Override
    public void init(Game game) {
        Log.info(getClass(), "initialize main scene");
        
        player = new GameObjectBuilder()
                .withTransform(game.getScreenCenter(), new Vector2f(20.0f, 20.0f))
                .withShape(Shapes.CIRCLE, Colors.RED)
                .withComponents(new PlayerMovement(), new ColorChanger())
                .build();

        addGameObject(game, player);
    }

    @Override
    public void update(Game game, float fps) {

    }

    @Override
    public void dispose(Game game) {
        System.out.println("dispose stuff here");
    }
}
