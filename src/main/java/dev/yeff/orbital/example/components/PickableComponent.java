package dev.yeff.orbital.example.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.example.PickupState;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.physics.collision.CollisionChecker;
import dev.yeff.orbital.util.Log;

public class PickableComponent extends Component {
    private PickupState state;
    private TransformComponent transformComponent;
    private GameObject mouseCollider;

    @Override
    public void init(Game game) {
        state = PickupState.UNPICKED;
        transformComponent = parent.getComponent(TransformComponent.class);
        mouseCollider = game.getCurrentScene().findObject("Mouse Collision");
    }

    @Override
    public void update(Game game) {
        if (CollisionChecker.isColliding(mouseCollider, parent) && Input.getMouse().isMouseDown(Keys.MOUSE_LEFT))
            state = PickupState.PICKED;
        else
            state = PickupState.UNPICKED;

        if (state == PickupState.PICKED)
            transformComponent.position = Input.getMouse().getMousePos();
    }
}
