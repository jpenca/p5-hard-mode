package hardmode;

import processing.app.Base;
import processing.app.Mode;
import processing.app.syntax.JEditTextArea;
import processing.app.syntax.PdeTextAreaDefaults;
import processing.app.ui.EditorException;
import processing.app.ui.EditorHeader;
import processing.app.ui.EditorState;
import processing.mode.java.JavaEditor;

public class HardEditor extends JavaEditor
{
	private static final long serialVersionUID = 51211108987282724L;

	protected HardEditor(Base base, String path, EditorState state, Mode mode) throws EditorException
	{
		super(base, path, state, mode);
		this.textarea.setRightClickPopup(null);
		this.clearText();
		this.setTitle("");
	}
	
	
	@Override
	public void setTitle(String title)
	{
		super.setTitle("Are you sure about this?");
	}

	@Override
	protected JEditTextArea createTextArea()
	{
		return new HardTextArea(new PdeTextAreaDefaults(mode), this);
	}

	@Override
	public EditorHeader createHeader()
	{
		return new HardEditorHeader(this);
	}

	private void clearText()
	{
		this.textarea.setText("");
	}

	@Override
	public void prepareRun()
	{
		super.prepareRun();
		this.clearText();
	}

	@Override
	public boolean handleSave(boolean immediately)
	{
		this.clearText();
		return false;
	}

	@Override
	public boolean handleSaveAs()
	{
		this.clearText();
		return false;
	}

	@Override
	public void handlePrint()
	{
		this.clearText();
	}

	@Override
	public void handleCopy()
	{
		this.clearText();
	}

	@Override
	public void handleCopyAsHTML()
	{
		this.clearText();
	}

	@Override
	public void handleCut()
	{
		this.clearText();
	}

	// this one doesn't work, superclass creates a custom action. so we deal
	// with this in our TextArea subclass..
	@Override
	public void handlePaste()
	{
		this.clearText();
	}

	@Override
	public void handleAutoFormat()
	{
		this.clearText();
	}
}