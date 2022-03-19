package dev.yeff.orbital.example.scenes;

import com.raylib.Raylib;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.graphics.Renderer;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keyboard;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.io.Mouse;
import dev.yeff.orbital.scenes.Scene;

public class MainScene implements Scene {
    private Raylib.Vector2 pos;
    private boolean redOrGreen;

    @Override
    public void init(Game game) {
        redOrGreen = true;
        pos = new Raylib.Vector2().x(game.getWidth() / 2).y(game.getHeight() / 2);
        System.out.println("initialize stuff here");
    }

    @Override
    public void update(Game game, float fps) {
        Keyboard kb = Input.getKeyboard();
        Mouse mouse = Input.getMouse();
        Renderer renderer = game.getRenderer();

        if (kb.isKeyDown(Keys.W)) pos.y(pos.y() - 5);
        if (kb.isKeyDown(Keys.S)) pos.y(pos.y() + 5);
        if (kb.isKeyDown(Keys.A)) pos.x(pos.x() - 5);
        if (kb.isKeyDown(Keys.D)) pos.x(pos.x() + 5);

        if (mouse.isMouseDown(Keys.MOUSE_MIDDLE)) {
            redOrGreen = !redOrGreen;
        }

        renderer.drawCircle(redOrGreen ? Colors.LIME_GREEN : Colors.RED, pos, 50.0f);
    }

    @Override
    public void dispose(Game game) {
        System.out.println("dispose stuff here");
    }
}
