package ru.iitp.proling.etap.reasoning;

import java.util.HashSet;
import java.util.LinkedHashSet;

// Конъюнкция (атомов)
public class Conjunction extends Proposition {

	// Множество атомов
	// Поскольку два одинаковых атома хранить в конъюнкции смысла нет,
	// используется Set, а не List.
	// Но поскольку порядок атомов может быть важен, используется LinkedHashSet,
	// а не просто HashSet.
	protected HashSet<Atom> atoms;

	// Дефолтный конструктор. Инициализирует множество атомов.
	// Возможно надо будет добавить другие конструкторы, например, создание по
	// одному атому или по конъюнкции + атом.
	public Conjunction() {
		atoms = new LinkedHashSet<Atom>();
	}

	public Conjunction(Atom atom) {
		this();
		addAtom(atom);
	}
	
	public Conjunction(HashSet<Atom> atoms) {
		this();
		addAtoms(atoms);
	}

	// Возвращает множество атомов.
	public HashSet<Atom> getAtoms() {
		return new HashSet<Atom>(atoms);
	}

	// Добавляет атом в конъюнкцию
	public void addAtom(Atom atom) {
		atoms.add(atom);
		addVariables(atom.getVariables());
	}

	// Добавляет множество атомов в конъюнкцию
	public void addAtoms(HashSet<Atom> atoms) {
		for (Atom atom : atoms) {
			addAtom(atom);
		}
	}

	// Возвращает текстовое представление объекта
	@Override
	public String toString() {
		String text = "";

		for (Atom atom : getAtoms())
			text += " & " + atom;

		if (text.length() == 0)
			return text;
		else
			return text.substring(3); // отрезаем начальный апмерсанд
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Conjunction)) {
			return false;
		}
		Conjunction c = (Conjunction) o;
		return getAtoms().equals(c.getAtoms());
	}

	public Conjunction merge(Conjunction c) {
		Conjunction result = new Conjunction();
		for (Atom atom : atoms) {
			result.addAtom(atom);
		}
		for (Atom atom : c.atoms) {
			result.addAtom(atom);
		}
		return result;
	}

	// Читает конъюнкцию из текста
	public static Conjunction parse(String text) {
		Conjunction conjunction = new Conjunction();

		String[] atoms = text.split("&");

		for (String atom : atoms) {
			if (atom.length() > 0)
				conjunction.addAtom(Atom.parse(atom));
		}

		return conjunction;
	}

	// Возвращает конъюнкцию, в которой переменные заменены в соответствии с
	// substitution
	public Conjunction substitute(Substitution substitution) {
		Conjunction newConjunction = new Conjunction();

		for (Atom atom : getAtoms())
			newConjunction.addAtom(atom.substitute(substitution));

		return newConjunction;

	}

	// Возвращает true, если конъюнкции содержат хотя бы один одинаковый атом
	public boolean check(Conjunction c) {
		for (Atom a : c.getAtoms()) {
			for (Atom b : getAtoms()) {
				if (b.equivalent(a)) {
					return true;
				}
			}
		}
		return false;
	}

}
