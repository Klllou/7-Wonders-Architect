package fr.isep.game7WonderArch.domain.card;
import main.*;
public abstract class Card {
	String image;

	public final CardType type;
	public final CardBack back;
	
	public Card(CardType type, CardBack back) {
		this.type = type;
		this.back = back;
		this.image = type.imageResource;
	}

	public abstract void apply(Player player);
}
