package org.suppor.p4_group_8_repo.application.suppor.view;

import javafx.scene.image.Image;
import org.suppor.p4_group_8_repo.application.suppor.model.Actor;

public class BackgroundImage extends Actor {

    @Override
    public void act(long now) {


    }

    public BackgroundImage(String imageLink) {
        setImage(new Image(imageLink, 600, 800, true, true));

    }

}
