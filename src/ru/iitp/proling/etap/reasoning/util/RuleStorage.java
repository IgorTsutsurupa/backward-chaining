package ru.iitp.proling.etap.reasoning.util;

import java.util.List;

import ru.iitp.proling.etap.reasoning.Conjunction;
import ru.iitp.proling.etap.reasoning.Implication;

public class RuleStorage {

	private RuleLoader loader;

	public RuleStorage(RuleLoader loader) {
		this.loader = loader;
	}

	public List<Implication> getAllRules() {
		return loader.getRules();
	}

	/**
	 * c -- правая часть возвращаемых правил
	 * 
	 * @param c
	 * @return
	 */
	public List<Implication> searchRules(Conjunction c) {
		return loader.searchRules(c);
	}
}
