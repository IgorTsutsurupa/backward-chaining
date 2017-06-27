package ru.iitp.proling.etap.reasoning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ru.iitp.proling.etap.reasoning.util.RuleStorage;

public class BackChain {

	public static List<Conjunction> getRewritings(Conjunction query, RuleStorage rules) {
		List<Conjunction> result = new ArrayList<Conjunction>();
		Queue<Atom> queue = new LinkedList<Atom>();

		// положить все атомы, входящие в query, в очередь, и работать в
		// последствии
		// с каждым элементом в очереди
		for (Atom atom : query.getAtoms()) {
			queue.add(atom);
		}
		result.add(new Conjunction(queue.peek()));
		while (!queue.isEmpty()) {
			Atom a = queue.poll();
			Conjunction current = new Conjunction(a);

			// ищем в списке правила, в которые текущая конъюнкция (состоящая из
			// одного атома)
			// входит как правая часть
			List<Rule> list = rules.searchRules(current);
			for (Rule r : list) {

				// проверим, не входят ли конъюкты добавляемой конъюнкции
				// в какую-либо из уже добавленных конъюнкций
				// если да -- то не добавлять (во избежание зацикливания)
				boolean include = false;
				Conjunction t = r.getBody();
				for (Conjunction c : result) {
					if (c.check(t)) {
						include = true;
						break;
					}
				}
				if (!include) {
					result.add(t);

					// Добавим в очередь конъюнкты из левой части нужного
					// правила
					queue.addAll(t.getAtoms());
				}
			}
		}
		return result;
	}

}
