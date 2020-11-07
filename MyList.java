import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * this class implemts MyListInterface for arrayList and linkedList
 *
 * @param <E>
 */
public class MyList<E> implements MyListInterface{
    /**
     * SimpleTextEditor is linkedList or arrayList
     */
    private List<Character> SimpleTextEditor;

    /**
     * type define arrayList or linkedList
     * @param type is arrayList or linkedList
     */
        public MyList(List type){
            SimpleTextEditor = type;
        }

    /**
     * this method read character by character File.txt
     * @throws IOException
     */
    public void read() throws IOException {

            FileReader fileReader = new FileReader("File.txt");
            String line;

            BufferedReader br = new BufferedReader(fileReader);
            int count = 0;
            int index =0;
            while ((line = br.readLine()) != null) {

                for(int i = 0; i< line.length();i++){
                    SimpleTextEditor.add(line.charAt(i));
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
            for(int i = 0 ; i<SimpleTextEditor.size();i++){

                if(SimpleTextEditor.get(i) == oldChar){
                    SimpleTextEditor.set(i,newChar);
                }
            }
        }

    /**
     * indicates the location of the first character of a series in the text
     * @param str is searched word
     * @return how many characters in the text of the first letter of the searched word
     */
        public int find(String str) {
            int count = 0;
            for (int i = 0; i < SimpleTextEditor.size()-str.length(); i++) {

               for(int j =i;j< i+str.length();j++){

                      if(str.charAt(j-i)==SimpleTextEditor.get(j)){
                          count++;
                          if(count == str.length()){
                              return i;
                          }

                      }
                      else{
                          count = 0;
                      }
               }
            }
            return  -1;
        }

    /**
     *
     * Add str after index.th character
     * @param str string to be added to text
     * @param index Starting with what character in the text will be added
     */
    public void add(String str,int index){
            int count = 0 ;
            for(int i = index;i<str.length()+index;i++){
                SimpleTextEditor.add(i,str.charAt(count));
                count++;
            }

        }

    /**
     *print list
     * @return what will it show on the screen
     */
    @Override
        public String toString() {
            String res = "";
            for(int i = 0; i< SimpleTextEditor.size();i++){
                if(i%100==0){
                    res = res + "\n";
                }
                res = res  + SimpleTextEditor.get(i);
            }
            return res;
        }
    }


