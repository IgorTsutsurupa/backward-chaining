package ru.iitp.proling.etap.reasoning;

import java.util.Objects;

// Минимальная пропозиция, предикат.
// У нас используются только одноместные и двухместные предикаты.
// Состоит из имени предикаты и максимум двух термов.
// Болееместные предикаты можно разложить на двухместные, например:
// Имеем трёхместный предикат, означающий "?а между ?b и ?c": between(?a, ?b, ?c)
// Его можно представить так: Between(?p) & hasFirst(?p, ?a) & hasSecond(?p, ?b) & hasThirs(?p, ?c)
public class Atom extends Proposition
{
	// Имя предиката
	// Например, "parent" для атома parent(?x, ?y))
	protected String predicate;
	
	// Первый терм
	// Например, "?x" для атома parent(?x, ?y))
	protected Term subject;

	// Второй терм
	// Например, "?y" для атома parent(?x, ?y))
	// Для одноместных предикатов = null
	protected Term object;
	
	// Конструктор общий и для двухместного атома
	public Atom(String predicate, Term subject, Term object)
	{
		this.predicate = predicate;
		this.subject = subject;
		this.object = object;
		
		// Доавляем переменные в множество переменных
		if (subject instanceof Variable)
			addVariable((Variable)subject);

		if (object instanceof Variable)
			addVariable((Variable)object);
	}

	// Конструктор для одноместного атома
	public Atom(String predicate, Term subject)
	{
		this(predicate, subject, null);
	}
	
	// Возвращает имя предиката
	public String getPredicate()
	{
		return predicate;
	}
	
	// Возвращает первый терм
	public Term getSubject()
	{
		return subject;
	}
	
	// Возвращает второй терм
	public Term getObject()
	{
		return object;
	}
	
	// Возвращает true, если атом одноместный
	public boolean isUnary()
	{
		return object == null;
	}
	
	// Возвращает текстовое представление объекта
	@Override
	public String toString()
	{
		if (isUnary())
			return getPredicate() + "(" + getSubject() + ")";
		else
			return getPredicate() + "(" + getSubject() + ", " + getObject() + ")";
	}
	
	// Сравнивает два атома
	// Нужно для сохранения атома в множество в конъюнкции
	// Атомы равны, если все их три поля равны
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Atom))
			return false;
		
		Atom otherAtom = (Atom)other;
		
		return
			Objects.equals(getPredicate(), otherAtom.getPredicate()) &&
			Objects.equals(getSubject(), otherAtom.getSubject()) &&
			Objects.equals(getObject(), otherAtom.getObject());
	}
	
	// Хэш для хранения в LinkedHashSet. Зависит от всех трёх полей.
	@Override
	public int hashCode()
	{
		return Objects.hash(getPredicate(), getSubject(), getObject());
	}
	
	// Читает атом из текста
	public static Atom parse(String text)
	{
		text = text.trim();
		
		String[] parts = text.split("[(,)]");
		
		String predicate = parts[0];
		String subject = parts[1];
		String object = null;
		
		if (parts.length > 2 && parts[2].length() > 0)
			object = parts[2];
		
		return new Atom(predicate, Term.parse(subject), Term.parse(object));
	}

	// Возвращает атом, в котором переменные заменены в соответствии с substitution
	public Atom substitute(Substitution substitution)
	{
		Term newSubject = getSubject();
		Term newObject = getObject();
		
		if (newSubject instanceof Variable)
			newSubject = substitution.getMapping((Variable)newSubject);

		if (newObject instanceof Variable)
			newObject = substitution.getMapping((Variable)newObject);
		
		return new Atom(getPredicate(), newSubject, newObject);
	}
}
