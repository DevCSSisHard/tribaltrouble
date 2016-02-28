package com.oddlabs.tt.gui;

import com.oddlabs.tt.animation.Animated;
import com.oddlabs.tt.animation.AnimationManager;
import com.oddlabs.tt.landscape.World;
import com.oddlabs.tt.net.PeerHub;
import com.oddlabs.tt.util.StateChecksum;
import com.oddlabs.tt.util.Utils;
import java.util.ResourceBundle;

public final strictfp class FreeQuitLabel extends Label implements Animated {
	private final static ResourceBundle bundle = ResourceBundle.getBundle(FreeQuitLabel.class.getName());

	private final World world;
	private final AnimationManager manager;

	public FreeQuitLabel(World world, AnimationManager manager) {
		super("", Skin.getSkin().getEditFont(), 300);
		this.world = world;
		this.manager = manager;
	}
	
        @Override
	protected final void doAdd() {
		super.doAdd();
		manager.registerAnimation(this);
	}

        @Override
	protected final void doRemove() {
		super.doRemove();
		manager.removeAnimation(this);
	}

        @Override
	public final void animate(float t) {
		int time_left = (int)PeerHub.getFreeQuitTimeLeft(world);
		if (time_left > 0) {
			clear();
			append(Utils.getBundleString(bundle, "quit_time_left", new Object[]{new Integer(time_left)}));
		}
	}

        @Override
	public final void updateChecksum(StateChecksum check_sum) {
	}
}

