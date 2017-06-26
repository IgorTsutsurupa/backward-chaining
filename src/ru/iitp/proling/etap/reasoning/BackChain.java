package ru.iitp.proling.etap.reasoning;

import java.util.ArrayList;
import java.util.List;

// Главный класс, который занимается переписыванием запросов
public class BackChain
{
	// Главная функция, которая возвращает список (дизъюнкцию) запросов, по исходному запросу (query) и набору правил (rules)
	// Дизъюнкция явно не моделируется, вроде бы достаточно списка конъюнкций. Но если вы считаете, что нужно - добавьте класс Disjuntion
	public static List<Conjunction> getRewritings(Conjunction query, ArrayList<Implication> rules)
	{
		List<Conjunction> rewritings = new ArrayList<Conjunction>();
		rewritings.add(query);
		
		// Здесь должен быть собственно код, который ищет альтернативные варианты запросов и пишет их в rewritings.
		
		return rewritings;
	}
}
