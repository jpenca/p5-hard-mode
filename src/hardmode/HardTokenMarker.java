package hardmode;

import processing.app.syntax.KeywordMap;
import processing.app.syntax.PdeKeywords;
import processing.app.syntax.Token;

public class HardTokenMarker extends PdeKeywords
{
	public void addColoring(String keyword, String coloring)
	{
		if (keywordColoring == null)
		{
			keywordColoring = new KeywordMap(false);
		}
		
		int id = Token.NULL; 
		keywordColoring.add(keyword, (byte) id, true);
	}
}
