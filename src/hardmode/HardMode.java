package hardmode;

import java.io.File;

import processing.app.Base;
import processing.app.Mode;
import processing.app.Platform;
import processing.app.ui.Editor;
import processing.app.ui.EditorException;
import processing.app.ui.EditorState;
import processing.mode.java.JavaMode;

public class HardMode extends JavaMode
{
	File			srcFolder;

	/**
	 * The folder containing the pre-processed .java files in their compiled
	 * .class form
	 */
	File			binFolder;

	/**
	 * Folder where REPL Mode's reference is stored
	 */
	protected File	replReference;

	/**
	 * Describes whether or not the sketch is running.
	 * 
	 * @deprecated Not really used anywhere
	 */
	boolean			isRunning;

	public HardMode(Base base, File folder)
	{
		super(base, folder);

		File javamodeFolder = Platform.getContentFile("modes/java");
		examplesFolder = new File(javamodeFolder, "examples");
		librariesFolder = new File(javamodeFolder, "libraries");
		referenceFolder = new File(javamodeFolder, "reference");

		replReference = new File(folder, "reference");

		srcFolder = null;
		binFolder = null;
		isRunning = false;
		
		
		
		
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