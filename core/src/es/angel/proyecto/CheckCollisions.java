package es.angel.proyecto;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class CheckCollisions {


    void checkcollisionsBall(Ball ball, Player player, AlienArmy alienArmy) {
        float ballHW = ball.pcBall.getHeight() + ball.pcBall.getWidth();

        if (ball.izquierda) {
            ball.pcBall.translateX(-5);
            if (ball.pcBall.getX() < 0) {
                ball.izquierda = !ball.izquierda;
                ball.pcBall.setX(0);
            }

            if (ball.rectBall.overlaps(player.rectangle) && ball.pcBall.getY() > 0) {
                ball.abajo = !ball.abajo;
            }

            if (ball.rectBall.overlaps(player.rectangle) && Controls.isRightPressed()){
                ball.izquierda = !ball.izquierda;
            }

            if (ball.abajo) {
                ball.pcBall.translateY(-5);
                if (ball.pcBall.getY() < 0) {
                    ball.abajo = !ball.abajo;
                    ball.pcBall.setY(0);
                }

                //REBOTE ARRIBA ALIEN
                for (int i = 0; i < alienArmy.aliens.size(); i++) {

                    Rectangle rectAlien = alienArmy.aliens.get(i).getBoundingRectangle();

                    if (ball.rectBall.overlaps(rectAlien) && ballHW * ball.pcBall.getY() > 1) {
                        ball.abajo = !ball.abajo;
                        alienArmy.aliens.remove(i);
                        System.out.println("1");
                    }

                }
            } else {
                ball.pcBall.translateY(5);
                if (ball.pcBall.getY() + ball.pcBall.getHeight() > Gdx.graphics.getHeight()) {
                    ball.pcBall.translateY(7);
                    ball.abajo = !ball.abajo;
                    System.out.println("2");
                }
                for (int i = 0; i < alienArmy.aliens.size(); i++) {

                    Rectangle rectAlien = alienArmy.aliens.get(i).getBoundingRectangle();

                    if (ball.rectBall.overlaps(rectAlien) && ballHW + ball.pcBall.getY() < alienArmy.aliens.get(i).getY() + alienArmy.aliens.get(i).getWidth()){
//                        ball.pcBall.translateY(-10);
                        ball.abajo = !ball.abajo;
                        System.out.println("3");
                    }

                    if (ball.rectBall.overlaps(rectAlien) && ball.pcBall.getX() > alienArmy.aliens.get(i).getHeight() + alienArmy.aliens.get(i).getWidth()){
                        ball.izquierda = !ball.izquierda;
                        alienArmy.aliens.remove(i);
                        System.out.println("4");
                    }
                }
            }

            //Mueve la pelota hacia la derecha y la hace rebotar arriba y abajo
        } else {
            ball.pcBall.translateX(5);
            if ((ball.pcBall.getX() + ball.pcBall.getWidth()) > Gdx.graphics.getWidth()) {
                ball.izquierda = !ball.izquierda;
            }


            if (ball.rectBall.overlaps(player.rectangle) && Controls.isLeftPressed()){
                ball.izquierda = !ball.izquierda;
            }

            if (ball.rectBall.overlaps(player.rectangle) && ball.pcBall.getY() > 0) {
                ball.abajo = !ball.abajo;
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

                //REBOTE ARRIBA ALIEN
                for (int i = 0; i < alienArmy.aliens.size(); i++) {

                    Rectangle rectAlien = alienArmy.aliens.get(i).getBoundingRectangle();

                    if (ball.rectBall.overlaps(rectAlien) && ballHW * ball.pcBall.getY() > 1) {
                        ball.pcBall.translateY(7);
                        ball.izquierda = !ball.izquierda;
                        alienArmy.aliens.remove(i);
                        System.out.println("6");
                    }

                }

            } else {
                ball.pcBall.translateY(5);
                if (ball.pcBall.getY() + ball.pcBall.getHeight() > Gdx.graphics.getHeight()) {
                    ball.abajo = !ball.abajo;
                    ball.pcBall.setY(Gdx.graphics.getHeight() - ball.pcBall.getHeight());
                }
                for (int i = 0; i < alienArmy.aliens.size(); i++) {

                    Rectangle rectAlien = alienArmy.aliens.get(i).getBoundingRectangle();

                    if (ball.rectBall.overlaps(rectAlien) && ballHW < alienArmy.aliens.get(i).getY() + alienArmy.aliens.get(i).getWidth()){
                        ball.pcBall.translateY(-7);
                        ball.izquierda = !ball.izquierda;
                        alienArmy.aliens.remove(i);
                        System.out.println("7");
                    }
                }
            }
        }
    }
}