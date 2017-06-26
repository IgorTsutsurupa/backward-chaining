package ru.iitp.proling.etap.reasoning;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Класс хранит список замен переменных
// Например, ?x -> ?a, ?y -> ?b и т.п.
// Нужен, чтобы унифицировать переменные в разных правилах и в запросе
public class Substitution {

	// Собственно мэппинг переменных на термы
	// Переменная может мэпится не только на другую переменную, но и на
	// константу (?x -> Bill), но не наоборот.
	protected Map<Variable, Term> map;

	// Дефолтный конструктор
	public Substitution() {
		map = new HashMap<Variable, Term>();
	}

	// Устанавливает мэппинг для переменной, или удаляет его если задан мэппинг
	// на саму себя
	public void setMapping(Variable variable, Term term) {
		if (Objects.equals(variable, term))
			map.remove(variable);
		else
			map.put(variable, term);
	}

	// Возвращает все мэппинги
	public Map<Variable, Term> getMappings() {
		return map;
	}

	// Возвращает мэппинг для переменной или её саму, если мэппинга нет
	public Term getMapping(Variable variable) {
		Term term = map.get(variable);

		if (term == null)
			return variable;
		else
			return term;
	}

	// Проверяет, есть ли мэппинг для заданной переменной
	public boolean hasMapping(Variable variable) {
		return map.containsKey(variable);
	}
}
