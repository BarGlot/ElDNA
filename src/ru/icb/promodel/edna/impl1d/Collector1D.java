package ru.icb.promodel.edna.impl1d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.icb.promodel.edna.ICollector;
import ru.icb.promodel.edna.IState;

public class Collector1D implements ICollector {

	private static Map<String, Map<String, Double>> rise=new HashMap<String, Map<String,Double>>();
	static {
		Map<String, Double> arise = new HashMap<String, Double>();
		arise.put("A", 3.1600);// 3.1600 3.8900 3.6300 3.4100
		arise.put("T", 3.8900);
		arise.put("G", 3.6300);
		arise.put("C", 3.4100);
		rise.put("A", arise);
		arise = new HashMap<String, Double>();
		arise.put("A", 3.2100);// 3.2100 3.1600 3.2300 3.4700
		arise.put("T", 3.1600);
		arise.put("G", 3.2300);
		arise.put("C", 3.4700);
		rise.put("T", arise);
		arise = new HashMap<String, Double>();
		arise.put("A", 3.4700);// 3.4700 3.4100 4.0800 3.8100
		arise.put("T", 3.4100);
		arise.put("G", 4.0800);
		arise.put("C", 3.8100);
		rise.put("G", arise);
		arise = new HashMap<String, Double>();
		arise.put("A", 3.2300);// 3.2300 3.6300 3.6000 4.0800
		arise.put("T", 3.6300);
		arise.put("G", 3.6000);
		arise.put("C", 4.0800);
		rise.put("C", arise);
	}
	private IState current;
	private ArrayList<IState> stateList;
	private Map<String, Double> cRise;
	private Double profile[]=new Double[0];
	private Double nucCenters[]=new Double[0];
	private Integer zValues[]=new Integer[0];
	private int lpr;
	private int trim;

	public Collector1D(IState s) {
		stateList = new ArrayList<IState>();
		stateList.add(s);
		current = s;
		current.setPosition(0.0d);
		cRise = rise.get(s.getName());
		lpr=0;
		trim=100;
	}

	public void add(IState s) {
		stateList.add(s);
		double p = current.getPosition();
		p += cRise.get(s.getName());
		current = s;
		current.setPosition(p);
		cRise = rise.get(s.getName());
	}

	public void collect() throws IllegalStateException{
		if(stateList.size()-2*trim<=0) throw new IllegalStateException("Length is not enougth for trim.");
		ArrayList<Double> pr=new ArrayList<Double>();
		ArrayList<Integer> zv=new ArrayList<Integer>();
		for (IState s : stateList) {
			s.updateProfile(pr,zv);
		}
		double lz=stateList.get(trim).getPosition();
		double rz=stateList.get(stateList.size()-trim).getPosition();
		ArrayList<Double> tpr=new ArrayList<Double>();
		ArrayList<Integer> tzv=new ArrayList<Integer>();
		for(int i=0;i<= zv.size();i++){
			if(zv.get(i)< lz) continue;
			if(zv.get(i)>= rz) break;
			tpr.add(pr.get(i));
			tzv.add(zv.get(i));
		}
		profile=tpr.toArray(profile);
		zValues=tzv.toArray(zValues);
		lpr=profile.length;
		ArrayList<Double> nc=new ArrayList<Double>();
		for(int i=trim; i<stateList.size()-trim;i++){
			nc.add(stateList.get(i).getPosition());
		}
		nucCenters=nc.toArray(nucCenters);
	}

	public Double[] getNucCenters() {
		return nucCenters;
	}

	public Double[] getProfile() {
		return profile;
	}

	public int getProfileWidth() {
		return lpr;
	}

	public int getSeqLength() {
		return stateList.size()-2*trim;
	}

	public Integer[] getZValues() {
		return zValues;
	}

	public void setOrigin(int o) throws IllegalStateException,
			IllegalArgumentException {
		if (o < 0)
			throw new IllegalArgumentException(
					"Origin could not refer to negative position.");
		if (o >= stateList.size())
			throw new IllegalStateException(
					"Origin state haven't been processed yet.");
		double np=stateList.get(o).getPosition();
		for (IState s : stateList) {
			s.setPosition(s.getPosition()-np);
		}
	}

	public void setTrim(int t) {
		trim=t;

	}

}
