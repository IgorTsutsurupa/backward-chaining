package ru.iitp.proling.etap.reasoning.util;

import java.util.ArrayList;
import java.util.List;

import ru.iitp.proling.etap.reasoning.Conjunction;
import ru.iitp.proling.etap.reasoning.Rule;

public abstract class RuleLoader {

	protected List<Rule> rules;

	protected List<Rule> getRules() {
		return rules;
	}

	protected void addRule(Rule r) {
		rules.add(r);
	}

	public List<Rule> searchRules(Conjunction c) {
		List<Rule> result = new ArrayList<Rule>();
		for (Rule r : rules) {
			Conjunction t = r.getHead();
			if (t.equals(c)) {
				result.add(r);
			}
		}
		return result;
	}

}
