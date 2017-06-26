package ru.iitp.proling.etap.reasoning;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Disjunction extends Proposition {

	protected HashSet<Atom> atoms;

	public Disjunction() {
		atoms = new LinkedHashSet<Atom>();
	}

	public HashSet<Atom> getAtoms() {
		return atoms;
	}

	public void addAtom(Atom atom) {
		atoms.add(atom);
		addVariables(atom.getVariables());
	}

	public void addAtoms(LinkedHashSet<Atom> atoms) {
		for (Atom atom : atoms)
			addAtom(atom);
	}

	@Override
	public String toString() {
		String text = "";

		for (Atom atom : getAtoms())
			text += " || " + atom;

		if (text.length() == 0)
			return text;
		else
			return text.substring(3);
	}

	@Override
	public boolean equals(Object c) {
		if (!(c instanceof Disjunction)) {
			return false;
		}
		return this.getAtoms().equals(((Disjunction) c).getAtoms());
	}

	public static Disjunction parse(String text) {
		Disjunction conjunction = new Disjunction();

		String[] atoms = text.split("||");

		for (String atom : atoms) {
			if (atom.length() > 0)
				conjunction.addAtom(Atom.parse(atom));
		}

		return conjunction;
	}

	public Disjunction substitute(Substitution substitution) {
		Disjunction newConjunction = new Disjunction();

		for (Atom atom : getAtoms())
			newConjunction.addAtom(atom.substitute(substitution));

		return newConjunction;

	}

}
