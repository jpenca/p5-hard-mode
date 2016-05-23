package hardmode;

import processing.app.ui.Editor;
import processing.app.ui.EditorConsole;

public class HardEditorConsole extends EditorConsole
{
	public HardEditorConsole(Editor editor)
	{
		super(editor);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6790892967986561042L;

	@Override
	synchronized public void message(String what, boolean err) {
		
	}
}
