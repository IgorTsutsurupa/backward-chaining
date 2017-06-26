package ru.iitp.proling.etap.reasoning;

import java.io.File;
import java.util.List;

import ru.iitp.proling.etap.reasoning.util.RuleLoader;
import ru.iitp.proling.etap.reasoning.util.RuleStorage;
import ru.iitp.proling.etap.reasoning.util.TXTLoader;

// Тестовый класс для тестирования BackChain
public class Test {

	public static void main(String[] args) {

		RuleLoader rl = new TXTLoader(new File("test_rules.txt"));
		RuleStorage st = new RuleStorage(rl);

		// List<Implication> list = st.getAllRules();
		// for (Implication e : list) {
		// System.out.println(e);
		// }

		List<Implication> list1 = st.searchRules(Conjunction.parse("parent(?x, ?t)"));
		for (Implication e : list1) {
			System.out.println(e);
		}
	}

}
