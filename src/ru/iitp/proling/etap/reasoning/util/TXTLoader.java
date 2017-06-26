package ru.iitp.proling.etap.reasoning.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ru.iitp.proling.etap.reasoning.Implication;

public class TXTLoader extends FileLoader {

	public TXTLoader(File source) {
		this.source = source;
		this.list = new ArrayList<Implication>();
		init();
	}

	private void init() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(source));
			String s;
			while ((s = bf.readLine()) != null) {
				addRule(Implication.parse(s));
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
