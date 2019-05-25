package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

//fxml ���Ͽ��� fx:controller ������Ƽ�� ������ �̺�Ʈ ��Ʈ�ѷ�
public class Controller {
	
	private String operator = "";
	private int x = 0;
	private Model model = new Model();
	
	
	//fxml ���Ͽ��� Text������Ʈ�� fx:id="result" ������Ƽ���� ���� ���� ����. �ش� ������Ʈ ��ü.
	@FXML
	private Text result;

	//fxml ���Ͽ��� �� ������Ʈ�� onAction="#operand" ������Ƽ�� ������ �̺�Ʈ �޼ҵ�
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
