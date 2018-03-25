package application.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public abstract class TableController<E> extends TableView<E> {
	protected static MainController main;
	protected ObservableList<E> masterData;
	@FXML
	protected List<TableColumn<E, String>> columns = new ArrayList<>();
	FilteredList<E> filteredData;
	
	public TableController() {
		// TODO Auto-generated constructor stub
	}

	public TableController(ObservableList<E> list, Class<E> class1) {
		masterData = list;
		
		Arrays.stream(class1.getDeclaredFields()).forEach(e -> {
			TableColumn<E, String> currentColumn = new TableColumn<E, String>(e.getName());
			
			PropertyValueFactory<E, String> p = new PropertyValueFactory<E, String>(e.getName());
			
			currentColumn.setCellValueFactory(p);
			columns.add(currentColumn);
		});
		this.setItems(masterData);
		this.getColumns().setAll(columns);
	}
	
	protected void filtra() {
		filteredData = new FilteredList<>(masterData);
	}; 

	public static void injectionMainController(MainController mainController) {
		main = mainController;
	}

}
