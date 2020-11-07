import java.io.IOException;

/**
 * Mylist and MyListIterator implements this interface
 */
public interface MyListInterface {

    /**
     * this method read character by character File.txt
     * @throws IOException
     */
    void read() throws IOException;

    /**
     *this method replaces a particular character in the text with another character
     * @param oldChar is changed character
     * @param newChar is character to replace the changed character
     */
    void replace(char oldChar ,char newChar);
    /**
     * indicates the location of the first character of a series in the text
     * @param str is searched word
     * @return how many characters in the text of the first letter of the searched word
     */
    int find(String str);
    /**
     *
     * Add str after index.th character
     * @param str string to be added to text
     * @param index Starting with what character in the text will be added
     */
    void add(String str,int index);
}
