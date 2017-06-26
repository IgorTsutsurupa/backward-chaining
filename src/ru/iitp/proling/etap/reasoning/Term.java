package ru.iitp.proling.etap.reasoning;

import java.util.Objects;

// Терм - общий класс для переменных, констант и литералов
public class Term
{
	// Имя терма
	// Имя (объектной) константы - латинские буквы и цифры, начинается с буквы (Bill, Mary).
	// Имя переменной - то же самое, только впереди добавляется вопросительный знак (?human, ?x).
	// Литералы (числа, текстовые строки и т.д.) пока не реализованы, в ближайшее время вряд ли пригодятся.
	protected String name;
	
	// Конструктор терма
	protected Term(String name)
	{
		this.name = name;
	}
	
	// Возвращает имя терма
	public String getName()
	{
		return name;
	}
	
	// Сравнение термов
	// Нужно для хранения термов (переменных) во множестве HashSet
	// Два терма равны, если у них совпадает имя
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof Term))
			return false;
		
		return Objects.equals(this.name, ((Term)other).name);
	}
	
	// Хэш для хранения в HashSet. Равен хэшу имени.
	@Override
	public int hashCode()
	{
		return name.hashCode();
	}
	
	// Возвращает текстовое представление объекта
	@Override
	public String toString()
	{
		return name;
	}
	
	// Читает терм из текста
	public static Term parse(String text)
	{
		if (text == null || text.length() == 0)
			return null;
		
		text = text.trim();
		
		// Если в начале вопросительный знак, то переменная, иначе константа
		if (text.charAt(0) == '?')
			return new Variable(text);
		else
			return new Constant(text);
	}
}
