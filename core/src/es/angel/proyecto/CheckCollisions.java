package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class CheckCollisions {

    void checkcollisionsBall(Ball ball, Player player, AlienArmy alienArmy) {
        if (ball.izquierda) {
            ball.pcBall.translateX(-5);
            if (ball.pcBall.getX() < 0) {
                ball.izquierda = !ball.izquierda;
                ball.pcBall.setX(0);
            }

            if (ball.rectBall.overlaps(player.rectangle) && ball.pcBall.getY() > 0) {
                ball.abajo = !ball.abajo;
                ball.pcBall.translateY(5);
            }

            // LOGRAR QUE REBOTE LA PELOTA EN TODOS LOS ALIENS
            for (int i = 0; i < alienArmy.aliens.size(); i++) {

                Rectangle rectAlien = alienArmy.aliens.get(i).getBoundingRectangle();

                if (ball.rectBall.overlaps(rectAlien) && ball.pcBall.getY() > 0) {
                    ball.abajo = !ball.abajo;
                    ball.pcBall.translateY(-5);
                } else if (ball.rectBall.overlaps(rectAlien) && ball.pcBall.getWidth() >= alienArmy.aliens.get(i).getHeight() + alienArmy.aliens.get(i).getWidth()) {
                    ball.abajo = !ball.abajo;
                    ball.pcBall.translateY(5);
                }
            }


            if (ball.abajo) {
                ball.pcBall.translateY(-5);
                if (ball.pcBall.getY() < 0) {
                    ball.abajo = !ball.abajo;
                    ball.pcBall.setY(0);
                }
            } else {
                ball.pcBall.translateY(5);
                if (ball.pcBall.getY() + ball.pcBall.getHeight() > Gdx.graphics.getHeight()) {
                    ball.abajo = !ball.abajo;
                    ball.pcBall.setY(Gdx.graphics.getHeight() - ball.pcBall.getHeight());
                }
            }

            //Mueve la pelota hacia la derecha y la hace rebotar arriba y abajo
        } else {
            ball.pcBall.translateX(5);
            if ((ball.pcBall.getX() + ball.pcBall.getWidth()) > Gdx.graphics.getWidth()) {
                ball.izquierda = !ball.izquierda;
                ball.pcBall.setX(Gdx.graphics.getWidth() - ball.pcBall.getWidth());
            }

            if (ball.rectBall.overlaps(player.rectangle) && ball.pcBall.getY() > 0) {
                ball.abajo = !ball.abajo;
                ball.pcBall.translateY(-5);
            }


            if (ball.rectBall.overlaps(player.rectangle)) {
                ball.pcBall.translateY(10);
            }

            if (ball.abajo) {
                ball.pcBall.translateY(-5);
                if (ball.pcBall.getY() < 0) {
                    ball.abajo = !ball.abajo;
                    ball.pcBall.setY(0);
                }
            } else {
                ball.pcBall.translateY(5);
                if (ball.pcBall.getY() + ball.pcBall.getHeight() > Gdx.graphics.getHeight()) {
                    ball.abajo = !ball.abajo;
                    ball.pcBall.setY(Gdx.graphics.getHeight() - ball.pcBall.getHeight());
                }
            }
        }
    }
}
