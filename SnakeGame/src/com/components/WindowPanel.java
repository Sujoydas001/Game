package com.components;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.utils.Utility;

public class WindowPanel extends JPanel
{
	public WindowPanel() {
		this.setMinimumSize(new Dimension(Utility.panelWidth,Utility.panelHeight));
		this.setPreferredSize(new Dimension(Utility.panelWidth,Utility.panelHeight));
		this.setMaximumSize(new Dimension(Utility.panelWidth,Utility.panelHeight));
		this.setBounds(0,0,Utility.screenWidth, Utility.screenHeight);
		this.setLayout(null);
		
	}
}
