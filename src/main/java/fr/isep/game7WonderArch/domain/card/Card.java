package fr.isep.game7WonderArch.domain.card;

public abstract class Card {

	public final CardType type;
	public final CardBack back;
	
	public Card(CardType type, CardBack back) {
		this.type = type;
		this.back = back;
	}

	
}
