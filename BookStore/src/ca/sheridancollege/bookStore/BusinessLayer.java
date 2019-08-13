package ca.sheridancollege.bookStore;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author Manuel Sanchez Moyano - Student ID 991545555
 */
public class BusinessLayer
{
   private Book book = new Book();
   private ArrayList<Book> bookList = new ArrayList<Book>();

   //addBook
   public void addBook (Book book) throws IOException
   {
      FileLayer fl = new FileLayer();
      fl.writeFile(book);
   }

   //editBook
   public ArrayList<Book> editBook (Book book) throws IOException
   {
      //Get the bookId in ArrayList
      //Modify bookId
      this.deleteBook(book.getBookId());
      bookList.add(book);

      //Write to the file the ArrayList
      FileLayer fl = new FileLayer();
      fl.writeFile(bookList);

      //Return updated ArrayList
      return bookList;
   }

   //deleteBook
   public void deleteBook (int bookId)
   {
      //ToDo: remove
      bookList = searchBooks("", "");

      for (int i = 0; i < bookList.size(); i++) {
         if (bookList.get(i).getBookId() == bookId) {

            System.out.println("Book deleted: " + book.getBookId());
            System.out.println("Book Title: " + book.getTitleName());

            bookList.remove(bookList.get(i));

            break;
         }
      }
   }

   public void deleteBook (int bookId, boolean writeToAFile)
   {
      this.deleteBook(bookId);

      System.out.println("BL - Deleted BookId: " + bookId);

      if (writeToAFile) {
         FileLayer fl = new FileLayer();
         System.out.println("BL - Writing deleiton to a file");
         fl.writeFile(bookList);
      }
   }

   public ArrayList<Book> getAllBooks ()
   {
      return searchBooks("", "");
   }

   public Book getBookById (int bookId)
   {
      Book bookResult = null;

      String stringId = Integer.toString(bookId);
      ArrayList<Book> resultList = searchBooks(stringId, "bookId");
      for (Book b : resultList) {
         bookResult = b;
      }

      return bookResult;
   }

   //searchBook
   public ArrayList<Book> searchBooks (String criteria, String fieldSearch)
   {
      FileLayer fl = new FileLayer();
      ArrayList<Book> results = new ArrayList<>();
      try {
         ArrayList<Book> booksFromFile = fl.readFile();

         switch (fieldSearch) {
            case "bookTitle": {
               for (Book b : booksFromFile) {
                  if (criteria.equals(b.getTitleName())) { //ToDo Look for partial search
                     results.add(b);
                  }
               }
               break;
            }
            case "bookAuthors": {
               for (Book b : booksFromFile) {
                  if (criteria.equals(b.getAuthors())) { //ToDo Look for partial search
                     results.add(b);
                  }
               }
               break;
            }
            case "bookISBN": {
               for (Book b : booksFromFile) {
                  if (criteria.equals(b.getISBN())) { //ToDo Look for partial search
                     results.add(b);
                  }
               }
               break;
            }
            case "bookId": {
               for (Book b : booksFromFile) {
                  String strId = Integer.toString(b.getBookId());
                  if (criteria.equals(strId)) { //ToDo Look for partial search
                     results.add(b);
                     break;
                  }
               }
               break;
            }
            default: {
               results.addAll(booksFromFile);
               break;
            }
         }
      }
      catch (IOException ex) {
         ex.getMessage();
      }
      return results;
   }

   public String[] getBookNameList () throws IOException
   {
      ArrayList<Book> bList = this.searchBooks("", "");
      String[] result = new String[bList.size()];

      for (int i = 0; i < bList.size(); i++) {
         result[i] = bList.get(i).getBookId() + ". " + bList.get(i).getTitleName();
      }

      return result;
   }

   public String[] getGenreList () throws IOException
   {
      ArrayList<Book> genreList = this.searchBooks("", "");
      String[] result = new String[genreList.size()];

      for (int i = 0; i < genreList.size(); i++) {
         result[i] = genreList.get(i).getTitleName();
      }

      return result;
   }

}
