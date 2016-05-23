package hardmode;

import java.awt.Color;
import java.io.File;

import processing.app.Base;
import processing.app.Mode;
import processing.app.Platform;
import processing.app.syntax.TokenMarker;
import processing.app.ui.Editor;
import processing.app.ui.EditorException;
import processing.app.ui.EditorState;
import processing.mode.java.JavaMode;

public class HardMode extends JavaMode
{
	public HardMode(Base base, File folder)
	{
		super(base, folder);

		File javamodeFolder = Platform.getContentFile("modes/java");
		examplesFolder = new File(javamodeFolder, "examples");
		librariesFolder = new File(javamodeFolder, "libraries");
		referenceFolder = new File(javamodeFolder, "reference");
	}

	public Color getColor(String attribute)
	{
		String myColor = "header.tab.selected.color";
		if (
				attribute.equals("header.tab.unselected.color")
				||
				attribute.equals("header.text.unselected.color")
				||
				attribute.equals("header.text.selected.color")
				
				)
			
			attribute = myColor;

		return super.getColor(attribute);
	}

	@Override
	protected TokenMarker createTokenMarker()
	{
		return new HardTokenMarker();
	}

	@Override
	public TokenMarker getTokenMarker()
	{
		return super.getTokenMarker();
	}

	@Override
	public Editor createEditor(Base base, String path, EditorState state) throws EditorException
	{
		return new HardEditor(base, path, state, this);
	}

	@Override
	public ClassLoader getClassLoader()
	{
		for (Mode m : base.getModeList())
		{
			if (m.getClass().getName().equals(JavaMode.class.getName()))
			{
				// JavaMode jMode = (JavaMode) m;
				return m.getClassLoader();
			}
		}
		return null; // badness
	}

	@Override
	public String getTitle()
	{
		return "Hard Mode";
	}
}