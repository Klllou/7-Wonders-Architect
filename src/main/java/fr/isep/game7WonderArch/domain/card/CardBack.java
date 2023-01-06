package fr.isep.game7WonderArch.domain.card;

import fr.isep.game7WonderArch.domain.wonder.Wonders;

public enum CardBack {

	CentralDeck(null), //
	
	Alexandrie(Wonders.Alexandrie), //
	Halicarnasse(Wonders.Halicarnasse),
	Ephese(Wonders.Ephese), //
	Olympie(Wonders.Olympie), //,
	Babylone(Wonders.Babylone), //
	Rhodes(Wonders.Rhodes), //
	Gizeh(Wonders.Gizeh); //
	
	public final boolean centralDeck;
	// set only when not centralDeck
	public final Wonders wonderDeck;
	
	private CardBack(Wonders wonderDeck) {
		this.centralDeck = (wonderDeck == null);
		this.wonderDeck = wonderDeck;
	}
	
}
