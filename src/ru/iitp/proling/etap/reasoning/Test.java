package ru.iitp.proling.etap.reasoning;

import java.io.File;
import java.util.List;

import ru.iitp.proling.etap.reasoning.util.RuleStorage;
import ru.iitp.proling.etap.reasoning.util.TXTLoader;

public class Test {

	public static void main(String[] args) {
		RuleStorage rules = new RuleStorage(new TXTLoader(new File("test_rules")));
		List<Conjunction> list = BackChain.getRewritings(Conjunction.parse("uncle(?x, ?y)"), rules);
		System.out.println(list);
	}

}
