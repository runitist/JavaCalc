package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

//fxml 파일에서 fx:controller 프로퍼티로 지정한 이벤트 컨트롤러
public class Controller {
	
	private String operator = "";
	private int x = 0;
	private Model model = new Model();
	
	
	//fxml 파일에서 Text엘리먼트의 fx:id="result" 프로퍼티에서 오는 변수 선언. 해당 엘리먼트 객체.
	@FXML
	private Text result;

	//fxml 파일에서 각 엘리먼트의 onAction="#operand" 프로퍼티로 지정한 이벤트 메소드
	@FXML
	private void operand(ActionEvent event) {
		result.setText(result.getText()+((Button)event.getSource()).getText());
	}
	
	@FXML
	private void operator(ActionEvent event) {
		if(((Button)event.getSource()).getText().equals("=")) {
			result.setText(model.calculate(operator, x, Integer.parseInt(result.getText())) + "");
		} else {
			operator = ((Button)event.getSource()).getText();
			x = Integer.parseInt(result.getText());
			result.setText("");
		}
	}
}
