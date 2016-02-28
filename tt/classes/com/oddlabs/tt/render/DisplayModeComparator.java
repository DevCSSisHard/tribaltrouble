package com.oddlabs.tt.render;

import java.util.Comparator;
import org.lwjgl.opengl.DisplayMode;

public final strictfp class DisplayModeComparator implements Comparator {
	private final SerializableDisplayMode target_mode;

	public DisplayModeComparator(SerializableDisplayMode target_mode) {
		this.target_mode = target_mode;
	}

	public final int compare(Object o1, Object o2) {
		DisplayMode d1 = (DisplayMode)o1;
		DisplayMode d2 = (DisplayMode)o2;

		/*
		 * Elias: sort after largest bpp first, then lowest freq
		 * to accomodate broken monitors lying about their
		 * capabilities
		 */
		int freq_dist1 = StrictMath.abs(d1.getFrequency() - target_mode.getFrequency());
		int freq_dist2 = StrictMath.abs(d2.getFrequency() - target_mode.getFrequency());
		int bpp_dist1 = StrictMath.abs(d1.getBitsPerPixel() - target_mode.getBitsPerPixel());
		int bpp_dist2 = StrictMath.abs(d2.getBitsPerPixel() - target_mode.getBitsPerPixel());
		if (getDistanceFromBestMode(d1) < getDistanceFromBestMode(d2))
			return -1;
		else if (getDistanceFromBestMode(d1) > getDistanceFromBestMode(d2))
			return 1;
		else if (bpp_dist1 < bpp_dist2)
			return -1;
		else if (bpp_dist1 > bpp_dist2)
			return 1;
		else if (freq_dist1 < freq_dist2)
			return -1;
		else if (freq_dist1 > freq_dist2)
			return 1;
		else
			return 0;
	}

	private final int getDistanceFromBestMode(DisplayMode mode) {
		int dx = StrictMath.abs(target_mode.getWidth() - mode.getWidth());
		int dy = StrictMath.abs(target_mode.getHeight() - mode.getHeight());
		return dx + dy;
	}

	public final boolean equals(Object obj) {
		return this == obj;
	}
}
