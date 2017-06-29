package ru.iitp.proling.etap.reasoning;

import java.util.ArrayList;
import java.util.HashSet;
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
			Conjunction currentEntry = mainQueue.poll();

			// положим все атомы, входящие в конъюнкцию currentEntry
			// во временную очередь
			Queue<Atom> entryAtoms = new LinkedList<Atom>();
			for (Atom currentAtom : currentEntry.getAtoms()) {
				entryAtoms.add(currentAtom);
			}

			// для каждого атома в очереди будем искать правила, в которые
			// он входит как правая часть, будем заменять этот атом
			// в конъюнкции currentEntry на левые части этих правил и записывать
			// новую конъюнкцию в результат result
			while (!entryAtoms.isEmpty()) {
				Atom atom = entryAtoms.poll();
				List<Rule> wantedRules = rules.searchRules(new Conjunction(atom));

				for (Rule rule : wantedRules) {
					HashSet<Atom> atomSet = currentEntry.getAtoms();
					atomSet.remove(atom);
					Conjunction rewriting = new Conjunction(atomSet).merge(rule.getBody());
					
					result.add(rewriting);
					mainQueue.add(rewriting);
				}
			}
		}
		return result;
	}

}
