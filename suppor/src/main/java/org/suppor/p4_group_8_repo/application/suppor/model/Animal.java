package org.suppor.p4_group_8_repo.application.suppor.model;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;

public class Animal extends Actor {
    Image imgW1, imgA1, imgS1, imgD1;
    Image imgW2, imgA2, imgS2, imgD2;
    int points = 0;
    int end = 0;
    private boolean second = false;
    boolean noMove = false;
    double movement = 13.3333333*2;
    double movementX = 10.666666*2;
    int imgSize = 40;
    boolean carDeath = false;
    boolean waterDeath = false;
    boolean stop = false;
    boolean changeScore = false;
    int carD = 0;
    double w = 800;
    ArrayList<End> inter = new ArrayList<End>();
    public Animal(String imageLink) {
        setImage(new Image(imageLink, imgSize, imgSize, true, true));
        setX(300);
        setY(679.8+movement);
        imgW1 = new Image("/images/frogger/froggerUp.png", imgSize, imgSize, true, true);
        imgA1 = new Image("/images/frogger/froggerLeft.png", imgSize, imgSize, true, true);
        imgS1 = new Image("/images/frogger/froggerDown.png", imgSize, imgSize, true, true);
        imgD1 = new Image("/images/frogger/froggerRight.png", imgSize, imgSize, true, true);
        imgW2 = new Image("/images/frogger/froggerUpJump.png", imgSize, imgSize, true, true);
        imgA2 = new Image("/images/frogger/froggerLeftJump.png", imgSize, imgSize, true, true);
        imgS2 = new Image("/images/frogger/froggerDownJump.png", imgSize, imgSize, true, true);
        imgD2 = new Image("/images/frogger/froggerRightJump.png", imgSize, imgSize, true, true);
        setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (noMove) {
                    return;
                    // No movement if noMove is true
                } else {
                    if (second) {
                        if (event.getCode() == KeyCode.W) {
                            move(0, movement); // Move up
                            setImage(imgW1);
                            second = false;
                        } else if (event.getCode() == KeyCode.A) {
                            move(movementX, 0); // Move left
                            setImage(imgA1);
                            second = false;
                        } else if (event.getCode() == KeyCode.S) {
                            move(0, -movement); // Move down
                            setImage(imgS1);
                            second = false;
                        } else if (event.getCode() == KeyCode.D){
                            move(-movementX, 0); // Move right
                            setImage(imgD1);
                            second = false;
                        }
                    } else if (event.getCode() == KeyCode.W) {
                        move(0, movement); // Move up
                        setImage(imgW2);
                        second = true;
                    } else if (event.getCode() == KeyCode.A) {
                        move(movementX, 0); // Move left
                        setImage(imgA2);
                        second = true;
                    } else if (event.getCode() == KeyCode.S) {
                        move(0, -movement); // Move down
                        setImage(imgS2);
                        second = true;
                    } else if (event.getCode() == KeyCode.D) {
                        move(-movementX, 0); // Move right
                        setImage(imgD2);
                        second = true;
                    }

                }
            }
        });

        setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (noMove) {
                    return;
                } else {
                    if (event.getCode() == KeyCode.W) {
                        if (getY() < w) {
                            changeScore = true;
                            w = getY();
                            points += 10;
                        }
                        move(0, movement); // Move up
                        setImage(imgW1);
                        second = false;
                    } else if (event.getCode() == KeyCode.A) {
                        move(movementX, 0); // Move left
                        setImage(imgA1);
                        second = false;
                    } else if (event.getCode() == KeyCode.S) {
                        move(0, -movement); // Move down
                        setImage(imgS1);
                        second = false;
                    } else if (event.getCode() == KeyCode.D) {
                        move(-movementX, 0); // Move right
                        setImage(imgD1);
                        second = false;
                    }
                }
            }
        });

    }

    @Override
    public void act(long now) {
        int bounds = 0;
        if (getY()<0 || getY()>734) {
            setX(300);
            setY(679.8+movement);
        }
        if (getX()<0) {
            move(movement*2, 0);
        }
        if (carDeath) {
            noMove = true;
            if ((now)% 11 ==0) {
                carD++;
            }
            if (carD==1) {
                setImage(new Image("/images/car/cardeath1.png", imgSize, imgSize, true, true));
            }
            if (carD==2) {
                setImage(new Image("/images/car/cardeath2.png", imgSize, imgSize, true, true));
            }
            if (carD==3) {
                setImage(new Image("/images/car/cardeath3.png", imgSize, imgSize, true, true));
            }
            if (carD == 4) {
                setX(300);
                setY(679.8+movement);
                carDeath = false;
                carD = 0;
                setImage(new Image("/images/frogger/froggerUp.png", imgSize, imgSize, true, true));
                noMove = false;
                if (points>50) {
                    points-=50;
                    changeScore = true;
                }
            }

        }
        if (waterDeath) {
            noMove = true;
            if ((now)% 11 ==0) {
                carD++;
            }
            if (carD==1) {
                setImage(new Image("/images/waterdeath/waterdeath1.png", imgSize,imgSize , true, true));
            }
            if (carD==2) {
                setImage(new Image("/images/waterdeath/waterdeath2.png", imgSize,imgSize , true, true));
            }
            if (carD==3) {
                setImage(new Image("/images/waterdeath/waterdeath3.png", imgSize,imgSize , true, true));
            }
            if (carD == 4) {
                setImage(new Image("/images/waterdeath/waterdeath4.png", imgSize,imgSize , true, true));
            }
            if (carD == 5) {
                setX(300);
                setY(679.8+movement);
                waterDeath = false;
                carD = 0;
                setImage(new Image("/images/frogger/froggerUp.png", imgSize, imgSize, true, true));
                noMove = false;
                if (points>50) {
                    points-=50;
                    changeScore = true;
                }
            }

        }

        if (getX()>600) {
            move(-movement*2, 0);
        }
        if (getIntersectingObjects(Obstacle.class).size() >= 1) {
            carDeath = true;
        }
        if (getX() == 240 && getY() == 82) {
            stop = true;
        }
        if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
            if(getIntersectingObjects(Log.class).get(0).getLeft())
                move(-2,0);
            else
                move (.75,0);
        }
        else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
            move(-1,0);
        }
        else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
            if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
                waterDeath = true;
            } else {
                move(-1,0);
            }
        }
        if (getIntersectingObjects(End.class).size() >= 1) {
            inter = (ArrayList<End>) getIntersectingObjects(End.class);
            End endZone = inter.get(0);

            if (!endZone.isActivated()) {
                points += 50;  // Add points when the player reaches the End zone
                changeScore = true;
                endZone.setEnd();  // Mark the zone as activated
                end++;
            }
            setX(300); // Reset position
            setY(679.8 + movement);
        }
        else if (getY()<413){
            waterDeath = true;
            setX(300);
            setY(679.8+movement);
        }
    }
    public boolean getStop() {
        return end==5;
    }

    public int getPoints() {
        return points;
    }

    public boolean changeScore() {
        if (changeScore) {
            changeScore = false;
            return true;
        }
        return false;
    }

}
