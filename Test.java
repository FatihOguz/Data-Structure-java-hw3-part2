import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * arraylist,arrayListIterator.linkedList,linkedListIterator do same method and measure efficients
 */
public class Test {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("logFile");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages

/*******************************************************************************************************************/

            Instant start = Instant.now();
            ArrayList<Character> arrayList1 = new ArrayList();
            MyListIterator<Character> simpleTextEditor = new MyListIterator(arrayList1);
            simpleTextEditor.read();
            simpleTextEditor.replace('a','A');
            simpleTextEditor.add("FATIH OGUZ",23);
            System.out.println(simpleTextEditor);
            System.out.println("FATIH OGUZ start "+ simpleTextEditor.find( "FATIH OGUZ") +".th index");
            logger.info("===>       FATIH OGUZ start "+ simpleTextEditor.find( "FATIH OGUZ") +".th index");
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();

/********************************************************************************************************************/

            Instant start2 = Instant.now();
            ArrayList<Character> arrayList = new ArrayList<>();
            MyList<Character> simpleTextEditor2 = new MyList<>(arrayList);
            simpleTextEditor2.read();
            simpleTextEditor2.replace('a','A');
            simpleTextEditor2.add("FATIH OGUZ" , 23);
            System.out.println(simpleTextEditor2);
            System.out.println("FATIH OGUZ start "+ simpleTextEditor2.find( "FATIH OGUZ") +".th index");
            logger.info("===>       FATIH OGUZ start "+ simpleTextEditor2.find( "FATIH OGUZ") +".th index");
            Instant finish2 = Instant.now();
            long timeElapsed2 = Duration.between(start2, finish2).toMillis();

/******************************************************************************************************************/

            Instant start3 = Instant.now();
            LinkedList<Character> linkedList1 = new LinkedList<>();
            MyListIterator<Character> simpleTextEditor3 = new MyListIterator<>(linkedList1);
            simpleTextEditor3.read();

            simpleTextEditor3.replace('a','A');
            simpleTextEditor3.add("FATIH OGUZ" , 23);
            System.out.println("FATIH OGUZ start "+ simpleTextEditor3.find( "FATIH OGUZ") +".th index");
            logger.info("===>       FATIH OGUZ start "+ simpleTextEditor3.find( "FATIH OGUZ") +".th index");
            System.out.println(simpleTextEditor3);
            Instant finish3 = Instant.now();
            long timeElapsed3 = Duration.between(start3, finish3).toMillis();


/******************************************************************************************************************/

            Instant start4 = Instant.now();
            // LinkedListTextEditor simpleTextEditor4 = new LinkedListTextEditor();
            LinkedList<Character> linkedList = new LinkedList<>();
            MyList<Character> simpleTextEditor4 = new MyList<>(linkedList);
            simpleTextEditor4.read();
            simpleTextEditor4.replace('a','A');
            simpleTextEditor4.add("FATIH OGUZ" , 23);
            System.out.println("FATIH OGUZ start "+ simpleTextEditor4.find( "FATIH OGUZ") +".th index");
            logger.info("===>       FATIH OGUZ start "+ simpleTextEditor4.find( "FATIH OGUZ") +".th index");
            System.out.println(simpleTextEditor4);
            Instant finish4 = Instant.now();
            long timeElapsed4 = Duration.between(start4, finish4).toMillis();



            System.out.println("***********************************************************************");

            System.out.println("ArrayList Iterator------------------->>>"  + timeElapsed  +" milis");
            System.out.println("ArrayList---------------------------->>>"  + timeElapsed2 +" milis");
            System.out.println("Linked List Iterator----------------->>>"  + timeElapsed3 + " milis");
            System.out.println("Linked List ------------------------->>>"  + timeElapsed4 + " milis");


            logger.info("ArrayList Iterator------------------->>>"  + timeElapsed + "\n"
                    +"ArrayList---------------------------->>>"  + timeElapsed2 + "\n"
                    +"Linked List Iterator----------------->>>"  + timeElapsed3 + "\n"
                    +"Linked List ------------------------->>>"  + timeElapsed4);



        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
