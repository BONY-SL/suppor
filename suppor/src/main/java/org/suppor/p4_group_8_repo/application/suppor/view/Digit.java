package org.suppor.p4_group_8_repo.application.suppor.view;

import javafx.scene.Node;
import javafx.scene.image.Image;
import org.suppor.p4_group_8_repo.application.suppor.model.Actor;

public class Digit extends Actor {
    Image im1;

    public Digit(int n, int dim, int x, int y) {
        im1 = new Image("/images/number/"+n+".png", dim, dim, true, true);
        setImage(im1);
        setX(x);
        setY(y);
    }

    @Override
    public void act(long now) {

    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
