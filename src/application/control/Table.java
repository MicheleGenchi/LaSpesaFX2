package application.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Table<E>{

	public Table() {
		
	}
	

	public TableView<E> get(Class<E> negozio, ObservableList<E> observableList) {
		TableView<E> table=new TableView<>();
		List<TableColumn<E, String>> columns = new ArrayList<>();
		Arrays.stream(negozio.getDeclaredFields()).forEach(e -> {
			TableColumn<E, String> currentColumn = new TableColumn<>(e.getName());
			PropertyValueFactory<E, String> p = new PropertyValueFactory<>(e.getName());
			currentColumn.setCellValueFactory(p);
			columns.add(currentColumn);
		});
		table.setItems(observableList);
		table.getColumns().setAll(columns);
		return table;
	}

}
