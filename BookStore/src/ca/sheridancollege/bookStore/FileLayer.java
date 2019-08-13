package ca.sheridancollege.bookStore;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Manuel Sanchez Moyano - Student ID 991545555
 */
public class FileLayer
{
   private final String fileName = "books.txt"; // "rootDirectory/filename"
   private static int BOOKID = 1;

   //write a file
   public void writeFile (Book book)
   {
      try {
         File file = new File(fileName);

         String str = "";

         int bookId = book.getBookId();
         if (bookId == 0) {
            str += BOOKID;
            BOOKID++;
         }
         else {
            str += bookId;
         }

         str += ";" + book.getTitleName();
         str += ";" + book.getEditionYear();
         str += ";" + book.getEdition();
         str += ";" + book.getAuthors();
         str += ";" + book.getPublisher();
         str += ";" + book.getISBN();
         str += ";" + book.getGenre();
         str += ";" + book.getCategory();
         str += ";" + book.isPhysical();
         str += ";" + book.getDescription();
         str += ";" + book.getLanguage();
         str += ";" + book.getPrice();
         str += ";" + book.getNumberOfCopies();
         str += ";" + book.isNewCopy() + "\n";

         if (file.exists()) {   //Append information
            System.out.println("File created: " + file.getName());
            FileWriter output = new FileWriter(file, true);

            output.write(str);// Book record
            output.close();
         }
         else { //Create the file and write
            FileWriter output = new FileWriter(file, false);
            output.write(str);
            output.close();
            System.out.println("New line written");
         }
      }
      catch (IOException ex) {
         System.out.println("An error occurred.");
      }
   }

   //write a file
   public void writeFile (ArrayList<Book> bookList)
   {
      File file = new File(fileName);
      file.delete();
      for (int i = 0; i < bookList.size(); i++) {
         this.writeFile(bookList.get(i));
      }

   }

   //Read a file
   public ArrayList<Book> readFile () throws IOException
   {
      ArrayList<Book> bookList = new ArrayList<>();

      Path path = Paths.get(fileName);
      try (Scanner scan = new Scanner(path)) {
         while (scan.hasNextLine()) {
            Book book = new Book();

            System.out.println("Reading a line"); //ToDo: remove

            String str = scan.nextLine();
            String[] bookStr = str.split(";");

            book.setBookId(Integer.parseInt(bookStr[0]));
            book.setTitleName(bookStr[1]);
            book.setEditionYear(Integer.parseInt(bookStr[2]));
            book.setEdition(bookStr[3]);
            book.setAuthors(bookStr[4]);
            book.setPublisher(bookStr[5]);
            book.setISBN(bookStr[6]);
            book.setGenre(bookStr[7]);
            book.setCategory(bookStr[8]);
            book.setPhysical(Boolean.parseBoolean(bookStr[9]));
            book.setDescription(bookStr[10]);
            book.setLanguage(bookStr[11]);
            book.setPrice(Double.parseDouble(bookStr[12]));
            book.setNumberOfCopies(Integer.parseInt(bookStr[13]));
            book.setNewCopy(Boolean.parseBoolean(bookStr[14]));

            bookList.add(book);
         }
      }

      return bookList;
   }
}
