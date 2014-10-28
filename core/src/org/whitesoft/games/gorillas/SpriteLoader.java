package org.whitesoft.games.gorillas;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import com.badlogic.gdx.files.FileHandle;

public class SpriteLoader {
	
	void parseFiles(FileHandle file) throws IOException
	{
		String line;
		InputStream in = file.read();
		InputStreamReader isr = new InputStreamReader(in);
		LineNumberReader reader = new LineNumberReader(isr);
		
		line = reader.readLine();
		while (line != null)
		{
			if (line.startsWith("SPRITE"))
			{
				generateSprite(reader);
			}
			line = reader.readLine();
		}
		
	}

	private boolean generateSprite(LineNumberReader reader) throws IOException 
	{
		int parseState = 0;
		String name, line;
		line = reader.readLine();
		while (line != null)
		{
			switch (parseState)
			{
			case 0:
				if (line.startsWith("NAME:"))
				{
					name = line.substring(5);
					parseState = 1;
				} 
				else if ( line.startsWith("SPRITE") ||  line.startsWith("END")) 
				{
					return false;
				}
				
				
				break;
			case 1:
				break;
			}
			line = reader.readLine();
		}
		return true;
	}
	
}
