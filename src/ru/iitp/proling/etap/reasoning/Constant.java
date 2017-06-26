package ru.iitp.proling.etap.reasoning;

// Константа (Bill, Mary, Paul и т.д.) - подкласс терма
// Имя константы не предваряется вопросительным знаком (в отличие от переменных)
public class Constant extends Term
{
	// Конструктор переменной
	public Constant(String name)
	{
		// Просто вызываем конструктор терма 
		super(name);
	}
	
}
