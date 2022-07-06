package dev.yeff.orbital.example.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.example.components.PickableComponent;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.physics.collision.CollisionChecker;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

public class MainScene extends Scene {
    private GameObject mouseCollision;
    private GameObject object;
    private GameObject object2;
    private GameObject object3;
    private GameObject object4;

    @Override
    public void init(Game game) {
        Log.info(getClass(), "initialize main scene");

        mouseCollision = new GameObjectBuilder(this, "Mouse Collision")
                .withTransform(Input.getMouse().getMousePos(), new Vector2f(20.0f))
                .withCollider(Shapes.CIRCLE, new Vector2f(20.0f))
                .build();

        object = new GameObjectBuilder(this, "Object")
                .withTransform(game.getScreenCenter(), new Vector2f(50.0f))
                .withShape(Shapes.RECTANGLE, Colors.RED)
                .withCollider(Shapes.RECTANGLE, new Vector2f(50.0f))
                .withComponent(new PickableComponent())
                .build();

        object2 = new GameObjectBuilder(this, "Object 2")
                .withTransform(new Vector2f(game.getScreenCenter().x, 50.0f), new Vector2f(50.0f))
                .withShape(Shapes.RECTANGLE, Colors.BLUE)
                .withCollider(Shapes.RECTANGLE, new Vector2f(50.0f))
                .withComponent(new PickableComponent())
                .build();

        object3 = new GameObjectBuilder(this, "Object 3")
                .withTransform(new Vector2f(20.0f, game.getScreenCenter().y), new Vector2f(50.0f))
                .withShape(Shapes.RECTANGLE, Colors.GREEN)
                .withCollider(Shapes.RECTANGLE, new Vector2f(50.0f))
                .withComponent(new PickableComponent())
                .build();

        object4 = new GameObjectBuilder(this, "Object 4")
                .withTransform(new Vector2f(game.getScreenCenter().x, 520.0f), new Vector2f(50.0f))
                .withShape(Shapes.RECTANGLE, Colors.YELLOW)
                .withCollider(Shapes.RECTANGLE, new Vector2f(50.0f))
                .withComponent(new PickableComponent())
                .build();

        addGameObject(game, mouseCollision);
        addGameObject(game, object);
        addGameObject(game, object2);
        addGameObject(game, object3);
        addGameObject(game, object4);
    }

    @Override
    public void update(Game game, float fps) {
        // make the mouse collision object follow the mouse every frame
        mouseCollision.getComponent(TransformComponent.class).position = Input.getMouse().getMousePos();
    }

    @Override
    public void dispose(Game game) {
        System.out.println("dispose stuff here");
    }
}
