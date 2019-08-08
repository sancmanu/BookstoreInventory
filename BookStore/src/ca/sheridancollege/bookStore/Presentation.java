package ca.sheridancollege.bookStore;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * @author Manuel Sanchez Moyano - Student ID 991545555
 */
public class Presentation extends Application
{
   @Override
   public void start (Stage stage)
   {
      GridPane gridPane = new GridPane();
      GridPane leftPane = addLeftPanel();
      GridPane rightPane = addRightPane();
      GridPane bottomPane = addBottomPane();

      gridPane.add(leftPane, 0, 0);
      gridPane.add(rightPane, 1, 0);
      gridPane.add(bottomPane, 1, 1);

      Scene scene = new Scene(gridPane);

      stage.setTitle("BOOK INVENTORY");
      stage.setScene(scene);
      stage.show();
   }

   private GridPane addBottomPane ()
   {
      GridPane bottomPane = new GridPane();
      bottomPane.setPadding(new Insets(10, 10, 20, 10));//Top, right, bottom, left
      bottomPane.setVgap(10);
      bottomPane.setHgap(5);

      Button bookAdd = new Button("Add");
      bookAdd.setPrefSize(100, 20);
      Button bookEdit = new Button("Edit");
      bookEdit.setPrefSize(100, 20);
      Button bookDelete = new Button("Delete");
      bookDelete.setPrefSize(100, 20);
      Button bookSearch = new Button("Search");
      bookSearch.setPrefSize(100, 20);
      Button programExit = new Button("Exit");
      programExit.setPrefSize(100, 20);

      bottomPane.add(bookAdd, 0, 0);
      bottomPane.add(bookEdit, 1, 0);
      bottomPane.add(bookDelete, 2, 0);
      bottomPane.add(bookSearch, 0, 1);
      bottomPane.add(programExit, 2, 1);

      return bottomPane;
   }

   private GridPane addRightPane ()
   {
      GridPane rightPane = new GridPane();
      rightPane.setPadding(new Insets(10, 20, 40, 40));//Top, right, bottom, left
      rightPane.setVgap(10);
      //rightPane.setStyle("-fx-background-color: #226699;");

      //book title
      Text bookTitleLabel = new Text("Book Title");
      TextField bookTitleTextField = new TextField();
      bookTitleTextField.setPrefSize(300, 20);

      //label for author name
      Text bookAuthorNameLabel = new Text("Author Name");
      //field for author name
      TextField bookAuthorNameTextField = new TextField();

      //edition year
      Text bookEditionYearLabel = new Text("Edition Year");
      TextField bookEditionYearTextfield = new TextField();

      //ISBN
      Text bookISBNLabel = new Text("ISBN");
      TextField bookISBNTextfield = new TextField();

      //BookType
      Text bookTypeLabel = new Text("Book Type");
      Text typePaperLabel = new Text("paper-book");
      CheckBox bookTypePaper = new CheckBox();
      bookTypePaper.setIndeterminate(false);
      Text typeDigitalLabel = new Text("digital");
      CheckBox bookTypeDigital = new CheckBox();
      bookTypeDigital.setIndeterminate(false);

      //label for book description
      Text bookDescriptionLabel = new Text("Description");
      //field for book description
      TextField bookDescriptionField = new TextField();
      //label for book written language
      Text bookLanguageLabel = new Text("Language");

      Text languageEnglishLabel = new Text("English");
      Text languageFrenchLabel = new Text("French");

      //checkboxes for English language
      CheckBox bookLanguageEnglishCheckBox = new CheckBox();
      bookLanguageEnglishCheckBox.setIndeterminate(false);

      //checkboxes for French language
      CheckBox bookLanguageFrenchCheckBox = new CheckBox();
      bookLanguageFrenchCheckBox.setIndeterminate(true);

      //adding controls to pane
      rightPane.add(bookTitleLabel, 0, 1);
      rightPane.add(bookTitleTextField, 0, 2, 6, 1);//colNum, rowNum, colSpan, rowSpan
      rightPane.add(bookAuthorNameLabel, 0, 3);
      rightPane.add(bookAuthorNameTextField, 0, 4, 6, 1);
      rightPane.add(bookEditionYearLabel, 0, 5);
      rightPane.add(bookEditionYearTextfield, 0, 6, 6, 1);
      rightPane.add(bookISBNLabel, 0, 7);
      rightPane.add(bookISBNTextfield, 0, 8, 6, 1);

      rightPane.add(bookTypeLabel, 0, 9);
      rightPane.add(typePaperLabel, 1, 9);
      rightPane.add(bookTypePaper, 2, 9);
      rightPane.add(typeDigitalLabel, 3, 9);
      rightPane.add(bookTypeDigital, 4, 9);

      rightPane.add(bookDescriptionLabel, 0, 10);
      rightPane.add(bookDescriptionField, 0, 11, 6, 2);

      rightPane.add(bookLanguageLabel, 0, 13);
      rightPane.add(languageEnglishLabel, 1, 13);
      rightPane.add(bookLanguageEnglishCheckBox, 2, 13);
      rightPane.add(languageFrenchLabel, 3, 13);
      rightPane.add(bookLanguageFrenchCheckBox, 4, 13);

      return rightPane;
   }

   private GridPane addLeftPanel ()
   {
      //left Pane
      GridPane leftPane = new GridPane();
      leftPane.setPadding(new Insets(40, 20, 20, 40));//Top, right, bottom, left
      leftPane.setVgap(10);

      //label for Genre combo
      Text bookGenreLabel = new Text("Genre");

      //ChoiceBox for Genre
      ChoiceBox<String> genreChoiceBox = new ChoiceBox<>();
      ArrayList<String> genreList = new ArrayList<>();

      //ToDo: replace by binding
      genreList.add("Choose an option");
      genreList.add("Arts");
      genreList.add("Business");
      genreList.add("Cooking");
      genreList.add("Education");
      genreChoiceBox.getItems().addAll(genreList);

      //Label for book name list
      Text bookNameLabel = new Text("List of Books");

      //list View for Book names
      ObservableList<String> bookList = FXCollections.observableArrayList(
              "Book1", "Book2", "Book3", "Book4", "Book5", "Book6", "Book7");
      ListView<String> bookNameListView = new ListView<>(bookList);
      bookNameListView.setMaxHeight(250);
      leftPane.add(bookGenreLabel, 0, 0);
      leftPane.add(genreChoiceBox, 0, 1);
      leftPane.add(bookNameLabel, 0, 4);
      leftPane.add(bookNameListView, 0, 5);
      return leftPane;
   }

   public static void main (String[] args)
   {
      launch(args);
   }
}
