package org.whitesoft.games.gorillas;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Building {
	
	static final int BLOCK_SIZE_X = 10;
	static final int BLOCK_SIZE_Y = 15;
	
	static final int bottomLine =  25 ; //# the bottom line of the buildings. We want some space for the wind arrow to go
	static final int maximumHeight = 250;
	static final int heightInc = 10 ; // # a baseline for how much buildings grow or shrink compared to the last building
	static final int defBuildWidth = 37 ; // # default building width, also judges how wide buildings can be
	static final int randomHeightDiff = 120; // # about how much buildings grow or shrink
	static final int windowWidth = 4; // # the width of each window in pixels
	static final int windowHeight = 7; // # the height of each window in pixels
	static final int windowSpacingX = 10; // # how many pixels apart each window's left edge is
	static final int windowSpacingY = 15; // # how many pixels apart each window's top edge is
	static final int gHeight = 25; // # (I'm not sure what this suppoes to be in the original Qbasic code, but I copied it anyway)
    //# (There also was a maxHeight variable in the original Qbasic, but I don't think it did anything so I left it out.)	
	
	Color color;
	
	Color lightWindow = new Color(0xFFFF52FF);
	Color darkWindow = new Color(0x525252FF);
	
	int x;
	int bx, by;
	int width;
	int height;
	
	boolean [] blocks;
//	boolean [] lastblocks;
	

	
//	for winx in range(3, buildWidth - windowSpacingX + windowWidth, windowSpacingX)
	
	
	public Building(int x, int remainingX) {

		this.x = x;
		width = defBuildWidth + (int) (Math.random() * defBuildWidth);
		if (width > remainingX)
			width = remainingX;
		height = (int) (Math.random() * maximumHeight);
		
		int colrnd = (int) (Math.random() * 3);
		switch (colrnd)
		{
		case 0:  color = new Color(0xADAAADFF); break; 
		case 1:  color = new Color(0x00AAADFF); break;
		case 2:  color = new Color(0xAD0000FF); break;
		}
		
		bx = (width - windowSpacingX + windowWidth) / BLOCK_SIZE_X;
		by = (height) / BLOCK_SIZE_Y;
		
		blocks = new boolean[bx*by];
		
		double windowStep = Math.random();
		for (int i = 0; i < by; i++)
			for (int j = 0; j < bx; j++)
			{
				blocks[bx*i + j] = Math.random() < windowStep;
			}
	}
	
	public void render(ShapeRenderer renderer)
	{
		renderer.begin(ShapeType.Filled);
		renderer.setColor(color);
		renderer.rect(x, bottomLine, width, height);
		
		for (int i = 0; i < by; i++)
			for (int j = 0; j < bx; j++)
			{
				renderer.setColor(blocks[bx*i + j] ? lightWindow : darkWindow);
				renderer.rect(x + 3 + windowSpacingX * j, bottomLine + windowSpacingY * i, windowWidth, windowHeight);
			}
		
		
		renderer.end();
	}

}
