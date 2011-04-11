package ru.icb.promodel.edna.exe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import ru.icb.promodel.edna.ICollector;
import ru.icb.promodel.edna.IStateMachine;
import ru.icb.promodel.edna.impl1d.State1D;
import ru.icb.promodel.edna.impl1d.StateBuilder1D;

public class ElectrostaticCalc {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new FileReader(args[0]));
		String line=null;
		IStateMachine sm=new StateBuilder1D(State1D.getIStates());
		while((line=br.readLine())!=null){
			if(line.trim().length()==0) continue;
			line=line.trim();
			for(int i=0;i<line.length();i++){
				if(sm.getCollegtor()==null)sm.init(line.substring(i, i+1));
				else sm.addChar(line.substring(i, i+1));
			}
		}
		br.close();
		sm.setOrigin(100);
		ICollector c=sm.getCollegtor();
		c.collect();
		FileWriter fw=new FileWriter(args[1]);
		BufferedWriter bw=new BufferedWriter(fw);
		Double[] profile = c.getProfile();
		Integer[] z=c.getZValues();
		for( int i=0;i<c.getProfileWidth();i++){
			bw.write(String.format("%d", z[i])+"\t"+String.format("%e", profile[i])+"\n");
		}
		bw.flush(); 
		bw.flush();
		bw.close();
	}

}
