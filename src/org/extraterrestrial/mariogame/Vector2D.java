package org.extraterrestrial.mariogame;

public class Vector2D {
    float x = 0;
    float y = 0;

    Vector2D() {
        this(0, 0);
    }

    Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D(double x, double y) {
        this.x = (float) x;
        this.y = (float) y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2D vec) {
        this.x += vec.x;
        this.y += vec.y;
    }

    public void mult(double m) {
        this.x *= m;
        this.y *= m;
    }

    public static Vector2D mult(Vector2D vec, double m) {
        return new Vector2D(vec.x * m, vec.y * m);
    }

    public float getMag() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public void setMag(float mag) {
        mag /= getMag();
        x *= mag;
        y *= mag;
    }

    public void normalize() {
        float mag = getMag();
        x /= mag;
        y /= mag;
    }

    public void limit(float limit) {
        if (getMag() > limit) {
            setMag(limit);
        }
    }
}
