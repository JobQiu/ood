package model;

import provided.util.ABCInstrument;

public interface IViewUpdateAdapter {
    
    public void addInstrument(ABCInstrument instrument);

	/**
	 * No-op singleton implementation of IViewControlAdapter.
	 */
	public static final IViewUpdateAdapter NULL_OBJECT = new IViewUpdateAdapter() {

        @Override
        public void addInstrument(ABCInstrument instrument) {}
	};
}
