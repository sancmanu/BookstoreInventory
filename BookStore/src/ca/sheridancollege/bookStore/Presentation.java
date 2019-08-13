package ca.sheridancollege.bookStore;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author Manuel Sanchez Moyano - Student ID 991545555
 */
public class Presentation extends Application
{
   private ArrayList<Book> bookList;

   //Right Pane
   TextField bookTitleTextField = new TextField();
   TextField bookEditionYearTextfield = new TextField();
   TextField bookEditionTextField = new TextField();
   TextField bookAuthorsNameTextField = new TextField();
   TextField bookPublisherTextField = new TextField();
   TextField bookISBNTextField = new TextField();
   RadioButton bookTypePaperRadioButton = new RadioButton();
   RadioButton bookTypeDigitalRadioButton = new RadioButton();
   TextField bookDescriptionTextField = new TextField();
   RadioButton bookLanguageEnglishRadioButton = new RadioButton();
   RadioButton bookLanguageFrenchRadioButton = new RadioButton();

   //Left Pane
   ComboBox<String> bookGenreComboBox = new ComboBox<>();
   ListView<String> bookNameListView = new ListView<>();

   //Bottom Pane
   Button bookAdd = new Button("Add");
   Button bookEdit = new Button("Edit");
   Button bookDelete = new Button("Delete");
   Button bookSearch = new Button("Search");
   Button bookEditSave = new Button("Save");

   public Presentation ()
   {
      bookList = new ArrayList<>();
      bookDelete.disableProperty().setValue(Boolean.TRUE);
      bookEdit.disableProperty().setValue(Boolean.TRUE);
      bookSearch.disableProperty().setValue(Boolean.TRUE);
      setGenreCombo();
      setBookListView();
   }

   @Override
   public void start (Stage stage)
   {
      GridPane mainPane = new GridPane();
//      GridPane leftPane = addLeftPane();
//      GridPane rightPane = addRightPane();
//      GridPane bottomPane = addBottomPane();

      mainPane.add(addLeftPane(), 0, 0);
      mainPane.add(addRightPane(), 1, 0);
      mainPane.add(addBottomPane(), 1, 1);

      //Create Scene.
      Scene scene = new Scene(mainPane);
      stage.setTitle("BOOK INVENTORY");
      stage.setScene(scene);
      stage.show();
   }

   private GridPane addLeftPane ()
   {
      //left Pane
      GridPane leftPane = new GridPane();
      leftPane.setPadding(new Insets(10, 20, 20, 40));//Top, right, bottom, left
      leftPane.setVgap(10);

      //Label for book name list
      Text bookNameLabel = new Text("List of Books");

      //list View for Book names
      bookNameListView.setMaxHeight(400);
      bookNameListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

      //leftPane.add(bookGenreLabel, 0, 0);
      //leftPane.add(bookGenreComboBox, 0, 1);
      leftPane.add(bookNameLabel, 0, 4);
      leftPane.add(bookNameListView, 0, 5);

      return leftPane;
   }

   private GridPane addRightPane ()
   {
      GridPane rightPane = new GridPane();
      rightPane.setPadding(new Insets(10, 20, 40, 40));//Top, right, bottom, left
      rightPane.setVgap(5);
      //rightPane.setStyle("-fx-background-color: #226699;");

      //book title
      Text bookTitleLabel = new Text("Book Title");
      bookTitleTextField.setPrefSize(300, 20);
      //Authors name
      Text bookAuthorsNameLabel = new Text("Author Name");
      //edition year
      Text bookEditionYearLabel = new Text("Edition Year");
      //edition
      Text bookEditionLabel = new Text("Edition");
      //publisher
      Text bookPublisherLabel = new Text("Publisher");
      //label for Genre combo
      Text bookGenreLabel = new Text("Genre");

      //ISBN
      Text bookISBNLabel = new Text("ISBN");
      //BookType
      Text bookTypeLabel = new Text("Book Type");
      Text typePaperLabel = new Text("paper-book");
      bookTypePaperRadioButton.setSelected(true);
      Text typeDigitalLabel = new Text("digital");
      bookTypeDigitalRadioButton.setSelected(false);

      //Description
      Text bookDescriptionLabel = new Text("Description");
      bookDescriptionTextField.setPrefSize(50, 50);

      //Written language
      Text bookLanguageLabel = new Text("Language");
      Text languageEnglishLabel = new Text("English");
      Text languageFrenchLabel = new Text("French");

      //Book Language written
      bookLanguageEnglishRadioButton.setSelected(true);
      bookLanguageFrenchRadioButton.setSelected(false);

      //adding controls to pane
      rightPane.add(bookTitleLabel, 0, 1);
      rightPane.add(bookTitleTextField, 0, 2, 6, 1);//colNum, rowNum, colSpan, rowSpan
      rightPane.add(bookAuthorsNameLabel, 0, 3);
      rightPane.add(bookAuthorsNameTextField, 0, 4, 6, 1);
      rightPane.add(bookEditionYearLabel, 0, 5);
      rightPane.add(bookEditionYearTextfield, 0, 6, 6, 1);
      rightPane.add(bookEditionLabel, 0, 7);
      rightPane.add(bookEditionTextField, 0, 8, 6, 1);
      rightPane.add(bookPublisherLabel, 0, 9);
      rightPane.add(bookPublisherTextField, 0, 10, 6, 1);
      rightPane.add(bookGenreLabel, 0, 11);
      rightPane.add(bookGenreComboBox, 0, 12, 4, 1);

      rightPane.add(bookISBNLabel, 0, 13);//
      rightPane.add(bookISBNTextField, 0, 14, 6, 1);

      rightPane.add(bookTypeLabel, 0, 15);
      rightPane.add(typePaperLabel, 2, 15);
      rightPane.add(bookTypePaperRadioButton, 3, 15);
      rightPane.add(typeDigitalLabel, 4, 15);
      rightPane.add(bookTypeDigitalRadioButton, 5, 15);

      rightPane.add(bookDescriptionLabel, 0, 17);
      rightPane.add(bookDescriptionTextField, 0, 18, 6, 1);

      rightPane.add(bookLanguageLabel, 0, 16);
      rightPane.add(languageEnglishLabel, 2, 16);
      rightPane.add(bookLanguageEnglishRadioButton, 3, 16);
      rightPane.add(languageFrenchLabel, 4, 16);
      rightPane.add(bookLanguageFrenchRadioButton, 5, 16);

      return rightPane;
   }

   private GridPane addBottomPane ()
   {
      GridPane bottomPane = new GridPane();
      //Top, right, bottom, left
      bottomPane.setPadding(new Insets(10, 10, 20, 10));
      bottomPane.setVgap(10);
      bottomPane.setHgap(5);

      bookAdd.setPrefSize(100, 20);
      bookEdit.setPrefSize(100, 20);
      bookDelete.setPrefSize(100, 20);
      bookSearch.setPrefSize(100, 20);
      bookEditSave.setPrefSize(100, 20);

      bookAdd.setOnMouseClicked(e -> addBook());
      bookEdit.setOnMouseClicked(e -> editBook());
      bookDelete.setOnMouseClicked(e -> deleteBook());
      bookEditSave.setOnMouseClicked(e -> editBookSave());
      bookSearch.setOnMouseClicked(e -> openSearchWindow());

      ToggleGroup typeBookGroup = new ToggleGroup();
      bookTypePaperRadioButton.setToggleGroup(typeBookGroup);
      bookTypeDigitalRadioButton.setToggleGroup(typeBookGroup);
      ToggleGroup languageBookGroup = new ToggleGroup();
      bookLanguageEnglishRadioButton.setToggleGroup(languageBookGroup);
      bookLanguageFrenchRadioButton.setToggleGroup(languageBookGroup);

      bottomPane.add(bookAdd, 0, 0);
      bottomPane.add(bookEdit, 1, 0);
      bottomPane.add(bookDelete, 2, 0);
      bottomPane.add(bookSearch, 0, 1);
      bottomPane.add(bookEditSave, 2, 1);

      return bottomPane;
   }

   public static void main (String[] args)
   {
      launch(args);
   }

   private void editBook ()
   {
      int bookId = bookNameListView.getSelectionModel().getSelectedIndex();
      if (bookId > -1) {
         String[] itemStr = bookNameListView.getSelectionModel().getSelectedItem().split("\\.");
         BusinessLayer bl = new BusinessLayer();
         Book result = bl.getBookById(Integer.parseInt(itemStr[0]));

         System.out.println("Editing BookTitle "
                 + bookNameListView.getSelectionModel().getSelectedItem());

         bookTitleTextField.setText(result.getTitleName());
         bookAuthorsNameTextField.setText(result.getAuthors() != null ? result.getAuthors() : "");
         bookEditionYearTextfield.setText(result.getEdition());
         bookEditionTextField.setText(result.getEdition());
         bookPublisherTextField.setText(result.getPublisher());
         setGenreCombo();
         bookGenreComboBox.setValue(result.getGenre() != null ? result.getGenre() : "");
         bookISBNTextField.setText(result.getISBN());
         if (result.isPhysical()) {
            bookTypePaperRadioButton.setSelected(true);
         }
         else {
            bookTypeDigitalRadioButton.setSelected(true);
         }
         if ("English".equalsIgnoreCase(result.getLanguage())) {
            bookLanguageEnglishRadioButton.setSelected(true);
         }
         else {
            bookLanguageFrenchRadioButton.setSelected(true);
         }
         bookDescriptionTextField.setText(result.getDescription());

         this.bookEdit.setDisable(true);
         this.bookAdd.setDisable(true);
         this.bookSearch.setDisable(true);

      }
   }

   private void openSearchWindow ()
   {


//      //Create Scene.
//      BorderPane searchWindow = new BorderPane();
//
//      TableView tableSearch
//      
//      Scene scene = new Scene(mainPane);
//      stage.setTitle("BOOK INVENTORY");
//      stage.setScene(scene);
//      stage.show();
   }

   /*
    * button Search
    *
    * if(bookTitleTextField.text != "")
    * ArrayList<Book> bookList = BusinessLayer.SearchBooks(bookTitleTextfield.text, "bookTitle");
    *
    * else if (bookISBNTextfield.text != "")
    * "bookISBN
    * else if (bookAuthorsTextfield.Text .....)
    * "bookAuthors"
    *
    */

   private void addBook ()
   {
      Book book = new Book();
      book.setTitleName(bookTitleTextField.getText());
      book.setAuthors(bookAuthorsNameTextField.getText());
      String editionYear = bookEditionYearTextfield.getText();
      if (editionYear.isEmpty()) {
         book.setEditionYear(0);
      }
      else {
         book.setEdition(editionYear);
      }

      book.setGenre(bookGenreComboBox.getValue());
      book.setISBN(bookISBNTextField.getText());

      book.setPhysical(bookTypePaperRadioButton.isSelected());
      book.setDescription(bookDescriptionTextField.getText());
      book.setLanguage(bookLanguageEnglishRadioButton.isSelected() ? "English" : "French");

      //bookList.add(book);
      try {
         BusinessLayer bl = new BusinessLayer();
         bl.addBook(book);
      }
      catch (IOException ex) {
         System.out.println(ex.getMessage());
      }
      setBookListView();

      bookTitleTextField.setText("");
      bookAuthorsNameTextField.setText("");
      bookEditionYearTextfield.setText("");
      bookEditionTextField.setText("");
      bookPublisherTextField.setText("");
      setGenreCombo();
      bookISBNTextField.setText("");
      bookTypePaperRadioButton.setSelected(true);
      bookLanguageEnglishRadioButton.setSelected(true);
      bookDescriptionTextField.setText("");

   }

   private void setBookListView ()
   {
      try {
         bookNameListView.setItems(FXCollections.observableArrayList(new BusinessLayer().getBookNameList()));

         boolean emptyList = bookNameListView.getItems().size() == 0;

         bookDelete.disableProperty().setValue(emptyList);
         bookEdit.disableProperty().setValue(emptyList);
         bookSearch.disableProperty().setValue(emptyList);

      }
      catch (IOException ex) {

      }
   }

   private void editBookSave ()
   {

   }

   private void deleteBook ()
   {
      int bookId = bookNameListView.getSelectionModel().getSelectedIndex();
      if (bookId > -1) {
         String[] itemStr = bookNameListView.getSelectionModel().getSelectedItem().split("\\.");
         BusinessLayer bl = new BusinessLayer();
         bl.deleteBook(Integer.parseInt(itemStr[0]), true);
         System.out.println("Deleted BookTitle "
                 + bookNameListView.getSelectionModel().getSelectedItem());
      }

      setBookListView();
   }

   private void setGenreCombo ()
   {
      //ComboBox for Genre
      ArrayList<String> genreList = new ArrayList<>();
      genreList.add("Humor");
      genreList.add("Science Fiction");
      genreList.add("Crime");
      genreList.add("Fantasy");
      genreList.add("Fairy tale");
      genreList.add("Contemporary");
      genreList.add("Classic");
      genreList.add("Horror");
      genreList.add("Biography");
      bookGenreComboBox.getItems().clear();
      bookGenreComboBox.getItems().addAll(genreList);
   }
}
