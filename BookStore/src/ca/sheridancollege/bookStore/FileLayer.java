package ca.sheridancollege.bookStore;
import java.io.*;
import java.util.ArrayList;
/**
 * @author Manuel Sanchez Moyano - Student ID 991545555
 */
public class FileLayer
{
   private String fileName = "books.dat"; // "rootDirectory/filename"

   //Create a file
   public void createFile () throws IOException
   {

   }

   //Write a file
   public void writeFile (Book book) throws IOException
   {
      //If Try-With-Resources is not used, output/input must use .close()
      try (
              DataOutputStream output
              = new DataOutputStream(new FileOutputStream(fileName));) {
         ArrayList<Book> bookList = new ArrayList<Book>();
         bookList.add(book);

         for (Book i : bookList) {
            i.getBookId();
            output.write(i.getBookId());
         }
      }
   }
   //Read a file

   public void readFile () throws IOException
   {
      try (
              DataInputStream input = new DataInputStream(new FileInputStream(fileName));) {
         int value;
         while ((value = input.read()) != -1) {
            System.out.println("data" + value);
         }

      }
   }

   //ToDo: delete
   public static void main (String[] args) throws IOException
   {
      FileLayer fl = new FileLayer();
      Book b1 = new Book();
      b1.setBookId(1);
      fl.writeFile(b1);
      fl.readFile();
   }

}
