package ca.sheridancollege.bookStore;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Manuel Sanchez Moyano - Student ID 991545555
 */
public class FileLayer
{
   private FileOutputStream output;

   public FileLayer ()
   {
      try {
         this.output = new FileOutputStream("file.dat");
      }
      catch (IOException e) {

      }
   }

   //Create a file
   public void createFile () throws IOException
   {

   }

   //Write a file
   public void writeFile (Book book)
   {
      try {
         DataOutputStream doutput = new DataOutputStream(output);
         ArrayList<Book> bookList = new ArrayList<Book>();
         bookList.add(book);

         for (Book i : bookList) {
            System.out.println(i.getBookId());
            doutput.write(i.getBookId());
         }

      }
      catch (IOException e) {
      }
   }

   //Read a file
   public void readFile ()
   {

   }

   //ToDo: delete
   public static void main (String[] args) throws Exception
   {
      FileLayer fl = new FileLayer();
      Book b1 = new Book();
      b1.setBookId(1);
      fl.writeFile(b1);
   }

}
