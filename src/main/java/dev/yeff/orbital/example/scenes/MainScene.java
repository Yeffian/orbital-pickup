package dev.yeff.orbital.example.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.graphics.Renderer;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keyboard;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.io.Mouse;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

public class MainScene implements Scene {
    private Vector2f pos;
    private boolean redOrBlue;

    @Override
    public void init(Game game) {
        Log.info(getClass(), "initialize main scene");
        redOrBlue = true;
        pos = game.getScreenCenter();
    }

    @Override
    public void update(Game game, float fps) {
        Keyboard kb = Input.getKeyboard();
        Mouse mouse = Input.getMouse();

        if (kb.isKeyDown(Keys.W)) pos.y -= 13;
        if (kb.isKeyDown(Keys.A)) pos.x -= 13;
        if (kb.isKeyDown(Keys.S)) pos.y += 13;
        if (kb.isKeyDown(Keys.D)) pos.x += 13;
        if (mouse.isMouseDown(Keys.MOUSE_MIDDLE)) redOrBlue = !redOrBlue;

        Renderer.drawCircle(getColor(), pos, 20.0f);
    }

    @Override
    public void dispose(Game game) {
        System.out.println("dispose stuff here");
    }

    private Colors getColor() {
        return redOrBlue ? Colors.RED : Colors.BLUE;
    }
}
