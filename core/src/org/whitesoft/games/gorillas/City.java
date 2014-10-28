package org.whitesoft.games.gorillas;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class City 
{
	static final int WIDTH =  800;
	static final int HEIGHT = 480;
	
	int lastBuildingX = 0;
	int remainingX = WIDTH;
	
	Gorilla [] players;
	
	ArrayList<Building> buildings;
	
	public City()
	{
		buildings = new ArrayList<Building>();
		
		while (generateBuilding()) ;
		
		
		
		
	}
	
	boolean generateBuilding()
	{
		Building b = new Building(lastBuildingX, remainingX);
		lastBuildingX += b.width;
		remainingX -= b.width;
		buildings.add(b);
		if (remainingX <= 0)
			return false;
		return true;
	}
	
	public void render(ShapeRenderer renderer)
	{
		renderer.begin(ShapeType.Filled);
		renderer.setColor(0, 0, 1, 1);
		renderer.rect(0, 0, WIDTH, HEIGHT);
		renderer.end();
		
		for (Building b : buildings)
			b.render(renderer);
	}
}
