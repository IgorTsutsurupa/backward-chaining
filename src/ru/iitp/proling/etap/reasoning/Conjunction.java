package ru.iitp.proling.etap.reasoning;

import java.util.HashSet;
import java.util.LinkedHashSet;

// Конъюнкция (атомов)
public class Conjunction extends Proposition
{
	// Множество атомов
	// Поскольку два одинаковых атома хранить в конъюнкции смысла нет, используется Set, а не List.
	// Но поскольку порядок атомов может быть важен, используется LinkedHashSet, а не просто HashSet.
	protected HashSet<Atom> atoms;
	
	// Дефолтный конструктор. Инициализирует множество атомов.
	// Возможно надо будет добавить другие конструкторы, например, создание по одному атому или по конъюнкции + атом.
	public Conjunction()
	{
		atoms = new LinkedHashSet<Atom>();
	}
	
	// Возвращает множество атомов.
	public HashSet<Atom> getAtoms()
	{
		return atoms;
	}
	
	// Добавляет атом в конъюнкцию
	public void addAtom(Atom atom)
	{
		atoms.add(atom);
		addVariables(atom.getVariables());
	}

	// Добавляет множество атомов в конъюнкцию
	public void addAtoms(LinkedHashSet<Atom> atoms)
	{
		for (Atom atom: atoms)
			addAtom(atom);
	}
	
	// Возвращает текстовое представление объекта
	@Override
	public String toString()
	{
		String text = "";
		
		for (Atom atom: getAtoms())
			text += " & " + atom;
		
		if (text.length() == 0)
			return text;
		else
			return text.substring(3); // отрезаем начальный апмерсанд
	}
	
	// Читает конъюнкцию из текста
	public static Conjunction parse(String text)
	{
		Conjunction conjunction = new Conjunction();
		
		String[] atoms = text.split("&");
		
		for (String atom: atoms)
		{
			if (atom.length() > 0)
				conjunction.addAtom(Atom.parse(atom));
		}
		
		return conjunction;
	}

	// Возвращает конъюнкцию, в которой переменные заменены в соответствии с substitution
	public Conjunction substitute(Substitution substitution)
	{
		Conjunction newConjunction = new Conjunction();
		
		for(Atom atom: getAtoms())
			newConjunction.addAtom(atom.substitute(substitution));
		
		return newConjunction;
		
	}
}
