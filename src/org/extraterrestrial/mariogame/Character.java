package org.extraterrestrial.mariogame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class Character {


    private Vector2D position = new Vector2D(40, 40);
    private Vector2D velocity = new Vector2D();
    private Vector2D acceleration = new Vector2D();

    private final static float MAX_VELOCITY = 10f;

    private int w = 0;
    private int h = 0;
    private Image sprite;

    public Character() {
        initCharacter();
    }

    void initCharacter() {
        // load sprite

        ImageIcon ii = new ImageIcon("src/resources/amogus.png");
        sprite = ii.getImage();

        w = sprite.getWidth(null);
        h = sprite.getHeight(null);
    }

    boolean isOnGround() {
        return position.y < 150;
    }

    void jump() {
        if (isOnGround()) {
            acceleration.add(new Vector2D(0, -50));
        }
    }

    void gravity() {
        acceleration.add(new Vector2D(0, -9.81));
    }

    void update() {
        if (!isOnGround()) {
            gravity();

        } else if (velocity.y < 0){
            velocity.y = 0;
        }

        velocity.add(acceleration);
        acceleration.set(0, 0);

        // horizontal speed limit
        if (velocity.x > MAX_VELOCITY) {
            velocity.x = MAX_VELOCITY;
        } else if (velocity.x < -MAX_VELOCITY) {
            velocity.x = -MAX_VELOCITY;
        }

        if (velocity.y > 0 && position.y > 150) {
            velocity.y = 0;
        }

        this.position.add(this.velocity);
    }



    int getGridX() {
        return Math.round(this.position.x);
    }
    int getGridY() {
        return Math.round(this.position.y);
    }


    public int getSpriteWidth() {
        return w;
    }

    public int getSpriteHeight() {
        return h;
    }

    Image getSprite() {
        return sprite;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            acceleration.add(new Vector2D(-1, 0));
        }

        if (key == KeyEvent.VK_RIGHT) {
            acceleration.add(new Vector2D(1, 0));
        }

        if (key == KeyEvent.VK_UP) {
            acceleration.add(new Vector2D(0, -1));
        }

        if (key == KeyEvent.VK_DOWN) {
            acceleration.add(new Vector2D(0, 1));
        }

        if (key == KeyEvent.VK_SPACE) {
            jump();
        }
    }
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            acceleration.add(new Vector2D(-1, 0));
        }

        if (key == KeyEvent.VK_RIGHT) {
            acceleration.add(new Vector2D(1, 0));
        }

        if (key == KeyEvent.VK_UP) {
            acceleration.add(new Vector2D(0, -1));
        }

        if (key == KeyEvent.VK_DOWN) {
            acceleration.add(new Vector2D(0, 1));
        }
    }

}
