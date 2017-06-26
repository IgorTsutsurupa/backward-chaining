package ru.iitp.proling.etap.reasoning;

// Класс импликации, правила, если-то
public class Implication extends Proposition {
	// Тело правила, левая часть, посылка
	// Конъюнкция атомов
	protected Conjunction body;

	// Голова правила, правая часть, следствие
	// Конъюнкция атомов
	protected Conjunction head;

	// Конструктор
	public Implication(Conjunction body, Conjunction head) {
		this.body = body;
		this.head = head;
	}

	// Возвращает тело правила (левую часть, посылку)
	public Conjunction getBody() {
		return body;
	}

	// Возвращает голову правила (правую часть, следствие)
	public Conjunction getHead() {
		return head;
	}

	// Возвращает текстовое представление объекта
	@Override
	public String toString() {
		return getBody() + " -> " + getHead();
	}

	// Читает импликацию из текста
	public static Implication parse(String text) {
		int splitIndex = text.indexOf("->");

		if (splitIndex == -1)
			return null;

		String body = text.substring(0, splitIndex);
		String head = text.substring(splitIndex + 2);

		return new Implication(Conjunction.parse(body), Conjunction.parse(head));
	}

	// Возвращает импликацию, в которой переменные заменены в соответствии с
	// substitution
	public Implication substitute(Substitution substitution) {
		Conjunction newBody = body.substitute(substitution);
		Conjunction newHead = head.substitute(substitution);

		return new Implication(newBody, newHead);
	}
}
