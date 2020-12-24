/*package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ShowDiagramController {

    @FXML
    private BarChart barChart;

    @FXML
    private CategoryAxis xAxis;

    public void setProductData(List <Order> orders){
        int[] productCounter = new int[productNames.size()];
        for (Order o : orders) {
            //
        }
        XYChart.Series series = new XYChart.Series<>();
        //
        for (int i = 0; i< productCounter.length; i++){
            series.getData().add(new XYChart.Data<>(productNames.get(i)), productCounter[i]));
        }
         barChart.getData().add(series);
    }

    private ObservableList productNames = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        String[] products = ("Стол", "Кресло", "Диван", "Стул", "Тумбочка");
        productNames.addAll(Arrays.asList(products));
        xAxis.setCategories(productNames);
    }
}
*/