package ru.iitp.proling.etap.reasoning;

import java.util.ArrayList;
import java.util.List;

public class Rule extends Implication {

	public Rule(Conjunction c, Atom a) {
		super(c, new Conjunction(a));
	}

	// Преобразует конъюнкцию
	public static List<Rule> rulify(Implication im) {
		List<Rule> result = new ArrayList<Rule>();
		for (Atom a : im.getHead().getAtoms()) {
			result.add(new Rule(im.getBody(), a));
		}
		return result;
	}

}
