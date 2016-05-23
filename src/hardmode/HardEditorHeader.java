package hardmode;

import processing.app.ui.Editor;
import processing.app.ui.EditorHeader;

public class HardEditorHeader extends EditorHeader
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3927989478581576810L;

	public HardEditorHeader(Editor eddie)
	{
		super(eddie);

		// remove keyboard & mouse hooks for tabs created in the superclass

		for (java.awt.event.MouseListener l : this.getMouseListeners())
		{
			this.removeMouseListener(l);
		}

		for (java.awt.event.KeyListener l : this.getKeyListeners())
		{
			this.removeKeyListener(l);
		}

	}

	public void rebuildMenu()
	{
		
	}
}
