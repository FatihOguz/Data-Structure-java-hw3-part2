
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

/**
 * this class implemts MyListInterface for arrayListIterator and linkedListIterator
 * @param <E>
 */
public class MyListIterator<E> implements MyListInterface{

    /**
     * SimpleTextEditor is arrayList OR linkedList
     */
    private List<Character> SimpleTextEditor;
    /**
     * iterator for List(arrayList or linkedList
     */
    private ListIterator<Character> iterator ;

    /**
     *
     * @param type is linkedListIterator or arrayListIterator
     */

    public MyListIterator(List<Character> type){
        SimpleTextEditor = type;
        iterator = SimpleTextEditor.listIterator();
    }
    /**
     * this method read character by character File.txt
     * @throws IOException
     */

    public void read() throws IOException {
        iterator = SimpleTextEditor.listIterator();
        FileReader fileReader = new FileReader("File.txt");
        String line;

        BufferedReader br = new BufferedReader(fileReader);
        int count = 0;
        int index =0;
        while ((line = br.readLine()) != null) {

            for(int i = 0; i< line.length();i++){
                iterator.add(line.charAt(i));
            }

            //System.out.println(line);
        }
        br.close();
    }


    /**
     *this method replaces a particular character in the text with another character
     * @param oldChar is changed character
     * @param newChar is character to replace the changed character
     */
    public void replace(char oldChar ,char newChar){
        iterator = SimpleTextEditor.listIterator();

        while(iterator.hasNext()){
            if(iterator.next() == oldChar){
                iterator.set(newChar);
            }
        }
    }

    /**
     *
     *  indicates the location of the first character of a series in the text
     * @param str is searched word
     * @return how many characters in the text of the first letter of the searched word
     */
    public int find(String str) {
        iterator = SimpleTextEditor.listIterator();
        int i = 0;
        int count=0;
        while(iterator.hasNext()) {
            if(i+str.length()>=SimpleTextEditor.size())
            {
                return -1;
            }
            iterator = SimpleTextEditor.listIterator(i);
            for(int j = i; j<i+str.length();j++){

                if(iterator.next()==str.charAt(j-i)){
                    count++;
                    if(count==str.length()){
                        return i;
                    }
                }
                else
                {
                    count = 0;
                }
            }
                i++;
        }
        return  -1;
    }

    /**
     *    Add str after index.th character
     * @param str string to be added to text
     * @param index Starting with what character in the text will be added
     */
    public void add(String str,int index){
        iterator = SimpleTextEditor.listIterator();
        int count = 0;
       for(int i=0;i<index+str.length();i++){

           if(i>=index){
               iterator.add(str.charAt(count));
               count++;
           }
           else{
               iterator.next();
           }
       }

    }
    /**
     * print list
     * @return what will it show on the screen
     */
    @Override
    public String toString() {
        int i  =0;
        String res = "";
        iterator = SimpleTextEditor.listIterator();
        while(iterator.hasNext()){
            if(i%100 == 0 ){
                res = res + "\n";
            }
            res = res + iterator.next() ;

            i++;
        }
        return res;
    }
}
