package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Controls {
    static boolean isLeftPressed(){
        return Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A);
    }

    static boolean isRightPressed(){
        return Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D);
    }

    static boolean isUpPressed(){
        return Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.W);
    }

    static boolean isDownPressed(){
        return Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.S);
    }
}
