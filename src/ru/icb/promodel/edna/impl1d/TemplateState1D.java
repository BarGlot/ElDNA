/**-------------------------------------------------------------------------
 *
 * TemplateState1D.java
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

import ru.icb.promodel.edna.IState;

/**
 * @author asorokin
 *
 */
public abstract class TemplateState1D implements IState {

	/* (non-Javadoc)
	 * @see ru.icb.promodel.edna.IState#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ru.icb.promodel.edna.IState#getPosition()
	 */
	public double getPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see ru.icb.promodel.edna.IState#getTemplate()
	 */
	public double[] getTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ru.icb.promodel.edna.IState#getWidth()
	 */
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see ru.icb.promodel.edna.IState#setPosition(double)
	 */
	public void setPosition(double z) {
		// TODO Auto-generated method stub

	}

}
