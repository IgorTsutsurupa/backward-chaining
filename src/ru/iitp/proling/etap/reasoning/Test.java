package ru.iitp.proling.etap.reasoning;

import java.io.File;
import java.util.List;

import ru.iitp.proling.etap.reasoning.util.RuleLoader;
import ru.iitp.proling.etap.reasoning.util.TXTLoader;

// Тестовый класс для тестирования BackChain
public class Test
{
	// Точка входа в программу
	public static void main(String[] args)
	{
//		// Исходный запрос
//		// Тут его можно задать в текстовом виде
//		Conjunction query = Conjunction.parse("uncle(?a, ?b)");
//		
//		// Список правил
//		// Правила тоже можно задавать сразу в текстовом виде
//		ArrayList<Implication> rules = new ArrayList<Implication>();
//		rules.add(Implication.parse("mother(?x, ?y) -> parent(?x, ?y)"));
//		rules.add(Implication.parse("father(?x, ?y) -> parent(?x, ?y)"));
//		rules.add(Implication.parse("parent(?t, ?y) & brother(?x, ?t) -> uncle(?x, ?y)"));
//		rules.add(Implication.parse("nephew(?x, ?y) & man(?y) -> uncle(?y, ?x)"));
//		rules.add(Implication.parse("niece(?x, ?y) & man(?y) -> uncle(?y, ?x)"));
//		
//		// Получаем переписанные запросы
//		List<Conjunction> rewritings = BackChain.getRewritings(query, rules);
//		
//		// Выводим их
//		for (Conjunction conjunction: rewritings)
//			System.out.println(conjunction);
		
		RuleLoader rl = new TXTLoader(new File("test_rules.txt"));
		
		List<Implication> list = rl.getRules();
		for (Implication e : list) {
			System.out.println(e);
		}
		
	}

}
