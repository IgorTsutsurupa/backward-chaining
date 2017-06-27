package ru.iitp.proling.etap.reasoning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ru.iitp.proling.etap.reasoning.util.RuleStorage;

public class BackChain {

	public static List<Conjunction> getRewritings(Conjunction query, RuleStorage rules) {
		List<Conjunction> result = new ArrayList<Conjunction>();
		Queue<Conjunction> mainQueue = new LinkedList<Conjunction>();

		result.add(query);
		mainQueue.add(query);
		while (!mainQueue.isEmpty()) {
			Conjunction entry = mainQueue.poll();
			Queue<Conjunction> entryAtoms = new LinkedList<Conjunction>();
			for (Atom currentAtom : entry.getAtoms()) {
				entryAtoms.add(new Conjunction(currentAtom));
			}
			while (!entryAtoms.isEmpty()) {
				Conjunction atom = entryAtoms.poll();
				List<Rule> wantedRules = rules.searchRules(atom);
								
			}
		}
		return result;
	}

}
