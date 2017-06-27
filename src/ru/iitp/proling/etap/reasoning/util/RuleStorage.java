package ru.iitp.proling.etap.reasoning.util;

import java.util.List;

import ru.iitp.proling.etap.reasoning.Conjunction;
import ru.iitp.proling.etap.reasoning.Rule;

public class RuleStorage {

	private RuleLoader loader;

	public RuleStorage(RuleLoader loader) {
		this.loader = loader;
	}

	public List<Rule> getAllRules() {
		return loader.getRules();
	}

	// с -- правая часть возвращаемых правил
	public List<Rule> searchRules(Conjunction c) {
		return loader.searchRules(c);
	}
}
