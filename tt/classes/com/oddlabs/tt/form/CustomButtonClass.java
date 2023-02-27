package com.oddlabs.tt.form;

import com.oddlabs.tt.global.Globals;
import com.oddlabs.tt.gui.GUIRoot;
/*
Copy of Option button class - Just going to rename for now. Should open options menu as well.
 */
public final strictfp class CustomButtonClass extends AbstractOptionsMenu {
    public CustomButtonClass(GUIRoot gui_root) {
        super(gui_root);
        chooseGamespeed(Globals.gamespeed);
    }
}
