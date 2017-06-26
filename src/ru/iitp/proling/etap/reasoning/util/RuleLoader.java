package ru.iitp.proling.etap.reasoning.util;

import java.util.ArrayList;
import java.util.List;

import ru.iitp.proling.etap.reasoning.Conjunction;
import ru.iitp.proling.etap.reasoning.Implication;

public abstract class RuleLoader {

	protected List<Implication> rules;

	protected List<Implication> getRules() {
		return rules;
	}

	protected void addRule(Implication e) {
		rules.add(e);
	}

	public List<Implication> searchRules(Conjunction c) {
		List<Implication> result = new ArrayList<Implication>();
		for (Implication e : rules) {
			if (e.getHead().equals(c)) {
				result.add(e);
			}
		}
		return result;
	}

}
