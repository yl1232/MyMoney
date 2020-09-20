package View;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

// Check if an inserted string isn't longer than a defined limit (used for Text Fields)

public class JTextFieldLimit extends PlainDocument {

	private int limit;

	JTextFieldLimit(int limit) {
	    super();
	    this.limit = limit;
	}
	
	public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException 
	{
	    if (str == null) 
	    {
	        return;
	    }

	    if ((getLength() + str.length()) <= limit) 
	    {
	        super.insertString(offset, str, attr);
	    }
	}
}
