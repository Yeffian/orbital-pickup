package dev.yeff.orbital.example.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keyboard;
import dev.yeff.orbital.io.Keys;

public class PlayerMovement extends Component {
    private TransformComponent transform;

    private static final float SPEED = 13;

    @Override
    public void init(Game game) {
        transform = parent.getComponent(TransformComponent.class);
    }

    @Override
    public void update(Game game) {
        Keyboard kb = Input.getKeyboard();

        if (kb.isKeyDown(Keys.W)) transform.position.y -= SPEED;
        if (kb.isKeyDown(Keys.A)) transform.position.x -= SPEED;
        if (kb.isKeyDown(Keys.S)) transform.position.y += SPEED;
        if (kb.isKeyDown(Keys.D)) transform.position.x += SPEED;
    }
}
