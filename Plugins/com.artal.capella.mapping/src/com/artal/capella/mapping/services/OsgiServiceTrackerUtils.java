package com.artal.capella.mapping.services;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.osgi.util.tracker.ServiceTracker;

import com.artal.capella.mapping.MappingActivator;

public final class OsgiServiceTrackerUtils {

	public static <T> T getService(Class<T> clazz) {
		ServiceTracker<T, T> tracker = new ServiceTracker<>(MappingActivator.getBundleContext(), clazz, null);
		try {
			tracker.open();
			return tracker.getService();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			tracker.close();
		}

	}

	public static <T> List<T> getServices(Class<T> clazz) {
		if (MappingActivator.getBundleContext() != null) {
			ServiceTracker<T, T> tracker = new ServiceTracker<>(MappingActivator.getBundleContext(), clazz, null);
			try {
				tracker.open();
				@SuppressWarnings("unchecked")
				T[] services = tracker.getServices((T[]) Array.newInstance(clazz, 1));
				if (services.length == 1 && services[0] == null) {
					return new ArrayList<T>();
				}
				return Arrays.asList(services);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				tracker.close();
			}
		}
		return new ArrayList<T>();
	}

}
