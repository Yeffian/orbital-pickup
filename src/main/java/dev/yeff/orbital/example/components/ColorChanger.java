package dev.yeff.orbital.example.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.components.render.RenderShapeComponent;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.io.Mouse;

public class ColorChanger extends Component {
    private RenderShapeComponent shape;

    @Override
    public void init(Game game) {
        shape = parent.getComponent(RenderShapeComponent.class);
    }

    @Override
    public void update(Game game) {
        Mouse mouse = Input.getMouse();

        if (mouse.isMouseDown(Keys.MOUSE_MIDDLE) && shape.color == Colors.RED)
            shape.color = Colors.BLUE;
        else
            shape.color = Colors.RED;
    }
}
