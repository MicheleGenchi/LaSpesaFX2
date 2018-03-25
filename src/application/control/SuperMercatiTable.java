package application.control;

import application.model.SuperMercato;

public class SuperMercatiTable extends TableController<SuperMercato> {

	public SuperMercatiTable() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void filtra() {
		/*
		main.cmbTipo.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				filteredData.setPredicate(e -> {
					// If filter text is empty, display all persons.
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					// Compare tipo di ogni riga con questo filtro
					String lowerCaseFilter = newValue.toLowerCase();
					if (((SuperMercato) e).getNome().toLowerCase().contains(lowerCaseFilter)) {
						return true; // stesso tipo
					}
					return false; // tipo diverso
				});
			}
		});

		this.setItems(filteredData);
		this.getColumns().setAll(columns);
		*/
	}
}
