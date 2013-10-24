import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldFilter extends PlainDocument {
    public static final String NUMERIC = "0123456789";
    public static final String ALPHABETIC = ".' qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
    public static final String PHONE = "+0123456789";
    public static final String IDR_CURRENCY = "Rp. 0123456789,";
    
    int LIMIT ;
    
    protected String acceptedChars = null;

    protected boolean negativeAccepted = false;

    public JTextFieldFilter(String acceptedchars,  int limit) {
        acceptedChars = acceptedchars;
        LIMIT = limit;
    }

    public void setNegativeAccepted(boolean negativeaccepted) {
        if (acceptedChars.equals(NUMERIC)) {
            negativeAccepted = negativeaccepted;
            acceptedChars += "-";
        }
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        for (int i = 0; i < str.length(); i++) {
            if (acceptedChars.indexOf(str.valueOf(str.charAt(i))) == -1)
                return;
        }

        if (negativeAccepted && str.indexOf("-") != -1) {
            if (str.indexOf("-") != 0 || offset != 0) {
                return;
            }
        }

        if ((getLength() + str.length()) <= LIMIT) {
            super.insertString(offset, str, attr);
        }
    }
}
