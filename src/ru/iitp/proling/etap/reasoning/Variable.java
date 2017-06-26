package ru.iitp.proling.etap.reasoning;

// Переменная (?human, ?x, ?y) - подкласс терма
// Имя переменной предваряется вопросительным знаком (в отличие от констант)
public class Variable extends Term {

	// Конструктор переменной
	public Variable(String name) {
		// Просто вызываем конструктор терма
		super(name);
	}

}
