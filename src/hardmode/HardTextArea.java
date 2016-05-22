package hardmode;

import processing.app.syntax.TextAreaDefaults;
import processing.mode.java.pdex.JavaTextArea;

public class HardTextArea extends JavaTextArea
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2382011077667774242L;

	
	public HardTextArea(TextAreaDefaults defaults, HardEditor editor)
	{
		super(defaults, editor);
		
	}

	@Override
	public void paste()
	{
		this.setText("");
		
	}
}
