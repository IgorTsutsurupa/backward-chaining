package ru.iitp.proling.etap.reasoning;

import java.util.HashSet;

// Общий класс для всех пропозиций. От него наследуются атомы, конъюнкции и импликации
public class Proposition {

	// Единственное, что есть общее у всех пропозиций - это то, что в них во
	// всех используются переменные
	// variables хранит множество всех переменных, используемых в пропозиции
	protected HashSet<Variable> variables;

	// Дефолтный конструктор. Инициализирует множество переменных.
	protected Proposition() {
		variables = new HashSet<Variable>();
	}

	// Возвращает множество переменных
	public HashSet<Variable> getVariables() {
		return variables;
	}

	// Добавляет переменную в пропозицию
	// Используется в конструкторах дочерних классов
	protected void addVariable(Variable variable) {
		variables.add(variable);
	}

	// Добавляет множество переменных в пропозицию
	// Используется в конструкторах дочерних классов
	protected void addVariables(HashSet<Variable> variables) {
		for (Variable variable : variables)
			addVariable(variable);
	}
}
