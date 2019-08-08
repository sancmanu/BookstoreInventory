package ca.sheridancollege.bookStore;
/**
 * @author Manuel Sanchez Moyano - Student ID 991545555
 */
public class Book
{
   private int bookId;
   private String titleName;
   private int editionYear;
   private String edition;
   private String author;
   private String editor;
   private String ISBN;
   private String genre;
   private String category;
   private boolean type;
   private String description;
   private String language;
   private double price;
   private int numberOfCopies;
   private boolean newCopy;

   /**
    * @return the bookId
    */
   public int getBookId ()
   {
      return bookId;
   }

   /**
    * @param bookId the bookId to set
    */
   public void setBookId (int bookId)
   {
      this.bookId = bookId;
   }

   /**
    * @return the titleName
    */
   public String getTitleName ()
   {
      return titleName;
   }

   /**
    * @param titleName the titleName to set
    */
   public void setTitleName (String titleName)
   {
      this.titleName = titleName;
   }

   /**
    * @return the editionYear
    */
   public int getEditionYear ()
   {
      return editionYear;
   }

   /**
    * @param editionYear the editionYear to set
    */
   public void setEditionYear (int editionYear)
   {
      this.editionYear = editionYear;
   }

   /**
    * @return the edition
    */
   public String getEdition ()
   {
      return edition;
   }

   /**
    * @param edition the edition to set
    */
   public void setEdition (String edition)
   {
      this.edition = edition;
   }

   /**
    * @return the author
    */
   public String getAuthor ()
   {
      return author;
   }

   /**
    * @param author the author to set
    */
   public void setAuthor (String author)
   {
      this.author = author;
   }

   /**
    * @return the editor
    */
   public String getEditor ()
   {
      return editor;
   }

   /**
    * @param editor the editor to set
    */
   public void setEditor (String editor)
   {
      this.editor = editor;
   }

   /**
    * @return the ISBN
    */
   public String getISBN ()
   {
      return ISBN;
   }

   /**
    * @param ISBN the ISBN to set
    */
   public void setISBN (String ISBN)
   {
      this.ISBN = ISBN;
   }

   /**
    * @return the genre
    */
   public String getGenre ()
   {
      return genre;
   }

   /**
    * @param genre the genre to set
    */
   public void setGenre (String genre)
   {
      this.genre = genre;
   }

   /**
    * @return the category
    */
   public String getCategory ()
   {
      return category;
   }

   /**
    * @param category the category to set
    */
   public void setCategory (String category)
   {
      this.category = category;
   }

   /**
    * @return the type
    */
   public boolean isType ()
   {
      return type;
   }

   /**
    * @param type the type to set
    */
   public void setType (boolean type)
   {
      this.type = type;
   }

   /**
    * @return the description
    */
   public String getDescription ()
   {
      return description;
   }

   /**
    * @param description the description to set
    */
   public void setDescription (String description)
   {
      this.description = description;
   }

   /**
    * @return the language
    */
   public String getLanguage ()
   {
      return language;
   }

   /**
    * @param language the language to set
    */
   public void setLanguage (String language)
   {
      this.language = language;
   }

   /**
    * @return the price
    */
   public double getPrice ()
   {
      return price;
   }

   /**
    * @param price the price to set
    */
   public void setPrice (double price)
   {
      this.price = price;
   }

   /**
    * @return the numberOfCopies
    */
   public int getNumberOfCopies ()
   {
      return numberOfCopies;
   }

   /**
    * @param numberOfCopies the numberOfCopies to set
    */
   public void setNumberOfCopies (int numberOfCopies)
   {
      this.numberOfCopies = numberOfCopies;
   }

   /**
    * @return the newCopy
    */
   public boolean isNewCopy ()
   {
      return newCopy;
   }

   /**
    * @param newCopy the newCopy to set
    */
   public void setNewCopy (boolean newCopy)
   {
      this.newCopy = newCopy;
   }
}
