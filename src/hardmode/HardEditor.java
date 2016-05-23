package hardmode;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JMenu;
import javax.swing.JPanel;

import processing.app.Base;
import processing.app.Mode;
import processing.app.syntax.JEditTextArea;
import processing.app.syntax.PdeTextAreaDefaults;
import processing.app.ui.EditorException;
import processing.app.ui.EditorHeader;
import processing.app.ui.EditorState;
import processing.app.ui.EditorToolbar;
import processing.mode.java.JavaEditor;
import processing.mode.java.pdex.Problem;

public class HardEditor extends JavaEditor
{
	private static final long	serialVersionUID	= 51211108987282724L;

	Timer						sketchModifiedTimer;

	protected HardEditor(Base base, String path, EditorState state, Mode mode) throws EditorException
	{
		super(base, path, state, mode);

		this.textarea.setRightClickPopup(null);
		this.clearText();
		this.setTitle("");
		this.getToolMenu().removeAll();
		sketch.setModified(false);

		JPanel panel = (JPanel) getContentPane();
		panel.setTransferHandler(null);

		sketchModifiedTimer = new Timer();
		sketchModifiedTimer.scheduleAtFixedRate(new TimerTask()
		{
			@Override
			public void run()
			{
				sketch.setModified(false);
			}
		}, 1000, 200);
	}

	@Override
	public EditorToolbar createToolbar()
	{
		return new HardToolbar(this);
	}

	@Override
	public void updateErrorTable(List<Problem> problems)
	{
		errorTable.clearRows();
	}

	@Override
	public List<Problem> findProblems(int line)
	{
		return new ArrayList<Problem>();
	}

	@Override
	public Problem findProblem(int line)
	{
		return null;
	}

	@Override
	public void highlight(int tabIndex, int startOffset, int stopOffset)
	{
		// nope
	}

	@Override
	public JMenu buildFileMenu()
	{
		JMenu menu = super.buildFileMenu();
		menu.removeAll();
		return menu;
	}

	@Override
	protected JMenu buildEditMenu()
	{
		JMenu menu = super.buildEditMenu();
		menu.removeAll();
		return menu;
	}

	@Override
	public JMenu buildSketchMenu()
	{
		JMenu menu = super.buildSketchMenu();
		menu.removeAll();
		return menu;
	}

	@Override
	protected JMenu buildDebugMenu()
	{
		JMenu menu = super.buildDebugMenu();
		menu.removeAll();
		return menu;
	}

	@Override
	public JMenu buildHelpMenu()
	{
		JMenu menu = super.buildHelpMenu();
		menu.removeAll();
		return menu;
	}

	@Override
	public void setTitle(String title)
	{
		super.setTitle("type once run once");
	}

	@Override
	public void toggleDebug()
	{
		debugEnabled = false;
		rebuildToolbar();
		repaint();
	}

	@Override
	protected void startTweakMode()
	{
		// nope
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
		sketch.setModified(false);
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