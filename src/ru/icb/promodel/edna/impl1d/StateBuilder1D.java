/**-------------------------------------------------------------------------
 *
 * StateBuilder1D.java
 *
 *
 *
 * Copyright (c) 2008-2009, Anatoly Sorokin, The University of Edinburgh
 *
 *  Author: Anatoly Sorokin <asorokin@inf.ed.ac.uk>
 *  Created on: Dec 17, 2009
 *	  $Id:$
 *-------------------------------------------------------------------------
 */

package ru.icb.promodel.edna.impl1d;

import java.util.Map;

import ru.icb.promodel.edna.ICollector;
import ru.icb.promodel.edna.IState;
import ru.icb.promodel.edna.IStateMachine;

/**
 * @author asorokin
 *
 */
public class StateBuilder1D implements IStateMachine {

	private Map<String, IState> map;
	private ICollector collector;
	public StateBuilder1D(Map<String, IState> map){
		this.map=map;
	}

	/* (non-Javadoc)
	 * @see ru.icb.promodel.edna.IStateMachine#getCollegtor()
	 */
	public ICollector getCollegtor() {
		return collector;
	}


	/* (non-Javadoc)
	 * @see ru.icb.promodel.edna.IStateMachine#setOrigin(int)
	 */
	public void setOrigin(int o) throws IllegalStateException,
			IllegalArgumentException {
		collector.setOrigin(o);
	}


	public void addChar(String c) {
		IState s=new State1D(map.get(c));
		collector.add(s);
	}

	public void init(String c) {
		IState s=new State1D(map.get(c));
		collector=new Collector1D(s);
	}

	public void setTemplates(Map<String, IState> map) {
		if(collector!=null) throw new IllegalStateException("Cannot update state map during sequence parsing");
		this.map=map;
	}

}
