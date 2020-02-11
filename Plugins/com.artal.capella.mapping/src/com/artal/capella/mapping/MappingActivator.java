package com.artal.capella.mapping;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * 
 */

/**
 * @author binot
 *
 */
public class MappingActivator implements BundleActivator {

	static private BundleContext _bundleContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		_bundleContext = context;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

	public static BundleContext getBundleContext() {
		return _bundleContext;
	}
}
