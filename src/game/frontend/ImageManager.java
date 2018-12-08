package game.frontend;

import game.backend.element.*;
import javafx.scene.image.Image;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImageManager {

	private static final String IMAGE_PATH = "images/";
	private Map<String, Image> images;

	/*
		Creates a hashmap with all the images
	 */
	public ImageManager() {
		//	Instances without color or type
		Candy cy = new Candy();
		Fruit ft = new Fruit();
		CagedCandy xc = new CagedCandy();
		WrappedCandy wc = new WrappedCandy();
		VerticalStripedCandy vc = new VerticalStripedCandy();
		HorizontalStripedCandy hc = new HorizontalStripedCandy();

		images = new HashMap<>();
		images.put(new Nothing().getKey(), new Image(IMAGE_PATH + "nothing.png"));
		images.put(new Bomb().getKey(),  new Image(IMAGE_PATH + "bomb.png"));
		images.put(new Wall().getKey(),  new Image(IMAGE_PATH + "wall.png"));
		images.put(new CagedCandy().getKey(), new Image(IMAGE_PATH + "cage.png"));

		//	Simple color candies
		for (CandyColor cc: CandyColor.values()) {
			cy.setColor(cc);
			images.put(cy.getFullKey(),  new Image(IMAGE_PATH + cc.toString().toLowerCase() + "Candy.png"));
		}
		//	Wrapped color candies
		for (CandyColor cc: CandyColor.values()) {
			wc.setColor(cc);
			images.put(wc.getFullKey(),  new Image(IMAGE_PATH + cc.toString().toLowerCase() + "Wrapped.png"));
		}
		//	Vertical stripped color candies
		for (CandyColor cc: CandyColor.values()) {
			vc.setColor(cc);
			images.put(vc.getFullKey(),  new Image(IMAGE_PATH + cc.toString().toLowerCase() + "VStripped.png"));
		}
		//	Horizontal stripped color candies
		for (CandyColor cc: CandyColor.values()) {
			hc.setColor(cc);
			images.put(hc.getFullKey(),  new Image(IMAGE_PATH + cc.toString().toLowerCase() + "HStripped.png"));
		}
		//	Types of fruits
		for (FruitType fty: FruitType.values()){
			ft.setType(fty);
			images.put(ft.getFullKey(), new Image(IMAGE_PATH + fty.toString().toLowerCase() + ".png"));
		}
	}

	public Image getImage(Element e) {
		return images.get(e.getFullKey());
	}

	public Image getOverlay(Element e){
	    if(e.isOverlay())
	        return new Image(IMAGE_PATH + "cage.png");
	    return null;
    }

}
