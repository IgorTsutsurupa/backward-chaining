package ru.iitp.proling.etap.reasoning;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import ru.iitp.proling.etap.reasoning.util.RuleStorage;

// Главный класс, который занимается переписыванием запросов
public class BackChain {

	public static List<Conjunction> getRewritings(Conjunction query, RuleStorage rules) {
		List<Conjunction> result = new ArrayList<Conjunction>();
		Queue<Atom> queue = new PriorityQueue<Atom>();
		
		//положить все атомы, входящие в query, в очередь, и работать в последствии
		//с каждым элементом в очереди
		for (Atom atom : query.getAtoms()) {
			queue.add(atom);
		}
		
		while(!queue.isEmpty()) {
			Conjunction current = new Conjunction(queue.poll());
			List<Implication> list = rules.searchRules(current);
			for (Implication e : list) {
				
				//проверить, не входит ли конъюкты добавляемой конъюнкции
				//в какую-либо из уже добавленных конъюнкций
				//если да -- то не добавлять (во избежание зацикливания)
				if(true) {
					result.add(e.body);
				}
			}
		}
		
		return result;
	}
	
}
