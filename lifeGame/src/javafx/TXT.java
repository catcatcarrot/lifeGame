package javafx;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TXT extends Application {
    private String[] bt = {"�ļ�(F)","�༭(E)","��ʽ(O)","�鿴(V)","����(H)"};
    private HBox hBox = new HBox(15);
    private TextArea taNote = new TextArea();
    private String[][] inbt = {{"�½�(N)     Ctrl+N","��(O)...  Ctrl+O","����(S)      Ctrl+S","ҳ������(U)...       ","��ӡ(O)...   Ctrl+P","�˳�(X)                "},
    		{"����(U)     Ctrl+Z","����(T)     Ctrl+X","����(C)     Ctrl+C","ճ��(P)     Ctrl+V","ɾ��(L)           Del","����(F)...    Ctrl+F",
    	"������һ��(N) F3","�滻(R)...  Ctrl+H","ת��(G)...  Ctrl+G","ȫѡ(A)     Ctrl+A","ʱ��/����(D)    F5"},
    		{"   �Զ�����(W)    ","     ����(F)...        "},{"    ״̬��(H)     "},{"   �鿴����(H)     ","   ���ڼ��±�(A)  "}};
    
    BorderPane pane = new BorderPane();
    FlowPane fPane = new FlowPane();
    Pane paneOfFont = new Pane();
    
    int iF,iE,iO,iV,iH = 1;
    
    public TXT(){
	    hBox.setPadding(new Insets(0,0,0,0));
	    for(int i = 0;i<bt.length;i++) {
	    	hBox.getChildren().add(new Button(bt[i]));
	    }
	    hBox.setStyle("-fx-border-color:white");
		
        taNote.setPrefColumnCount(20);
	    taNote.setPrefRowCount(20);
        taNote.setWrapText(false);/*�ı������ڲ��Զ�����*/
        taNote.setEditable(true);
        taNote.setStyle("-fx-text-fill:blue");
        taNote.setFont(Font.font("Times",20));
       
        
        pane.setTop(hBox);
        pane.setCenter(taNote);
        
        pane.setMaxWidth(200);
        pane.setMaxHeight(200);
          
        pane.getChildren().add(fPane);
        
        action(hBox);//ִ�а�ť����
    }
    
    
    public void setPlay(Button b) {
    	String s = "";
    	s+= b.getText();
   //     int iF,iE,iO,iV,iH = 1;
    	switch(s) {
    	case "�ļ�(F)":
    		b.setOnAction(e -> {
    		    fPane.getChildren().clear();//ִ����������ʱ������ʾfPane���
    			showPane(0);
        		inFpane();
        		iF++;
    		});
    	              break;
    	case "�༭(E)":b.setOnAction(e->{
    		fPane.getChildren().clear();
    		showPane(1);
    		inFpane();});
    		          break;
    	case "��ʽ(O)":b.setOnAction(e->{
    		fPane.getChildren().clear();
    		showPane(2);
    		inFpane();});
    	              break;
    	case "�鿴(V)":b.setOnAction(e->{
    		fPane.getChildren().clear();
    		showPane(3);
    		inFpane();});
    	              break;
    	case "����(H)":b.setOnAction(e->{
    		fPane.getChildren().clear();
    		showPane(4);
    		inFpane();});
    	              break;
    	}
    }
    
    public void showPane(int index) {
    	fPane.setOrientation(Orientation.HORIZONTAL);
    	fPane.setVgap(0);
    	for(int i = 0;i<inbt.length;i++) {
    		if(i == index) {
    			for(int j = 0;j<inbt[index].length;j++) {//���ѡ�����Զ����а�ť����ʾ   ��  �Զ�����(W)   
    				if((inbt[index][j]).equals("   �Զ�����(W)    ") && taNote.isWrapText()) {
    					fPane.getChildren().add(new Button("��  �Զ�����(W)   "));
    		    	}
    				else {
    					fPane.getChildren().add(new Button(inbt[index][j]));
    				}
    			}
    			break;
    		}
    	}
    	
    	fPane.setStyle("-fx-background-color:lightgray");
    	fPane.setLayoutX(71*index);
    	fPane.setLayoutY(25);
  
    }
    
    public void action(HBox hb) {
    	for(int i = 0;i<hb.getChildren().size();i++) {
         //�Ի�������ֵ����ת����hb.getChildren().get(i)�õ�Node����
    		Button b = (Button)(hb.getChildren().get(i));
    		setPlay(b);
    	}
    }
    
    public void inFpane() {
    	for(int i = 0;i<fPane.getChildren().size();i++) {
    		Button b = (Button)(fPane.getChildren().get(i));
    		setInFpane(b);
    	}
    }
    
    public void setInFpane(Button b) {
    	String s = "";//��ð�Ҫִ�еĶ���������b.setOnAction�ϣ���Ϊѭ������ʱ��ִ���������������𲻱�Ҫ����
    	s+=b.getText();
    	s = s.trim();
    	switch(s) {
    	case "�Զ�����(W)":
    	    b.setOnAction(e->{
    		//    b.setText("��   �Զ�����(W)  ");
    		    taNote.setWrapText(true);
    		    fPane.getChildren().clear();
    	    });
    	                break;
    	case "��  �Զ�����(W)":
    		b.setOnAction(e->{
    	    //	b.setText("    �Զ�����(W)  ");
    	        taNote.setWrapText(false);
    	    	fPane.getChildren().clear();
    		});
    		            break;
    	case "����(F)...":b.setOnAction(e->{
    		                showScene();
    		                fPane.getChildren().clear();
    	});             break;
    	case "�鿴����(H)":b.setOnAction(e->{
    		            
    		            fPane.getChildren().clear();
    	}); 
    		            break;
    	case "ʱ��/����(D)    F5":b.setOnAction(e->{
    		            Date date = new Date();
    		            taNote.positionCaret(2);
    		         // taNote.setText(date.toString()+taNote.getText());
    		            taNote.appendText(date.toString());
    		            fPane.getChildren().clear();
    	}); 
    		            break;
    	}
    		
    }
    
    public void showScene() {
    	Pane paneOfFont = new Pane();
		BorderPane paneOfText = new BorderPane();
	  
		VBox vbF = new VBox(0);
		VBox vbY = new VBox(0);
		VBox vbS = new VBox(0);
		HBox hbButton = new HBox(20);
		
		String[] font = {"����","����","����","΢���ź�","������","��Բ"};
		String[] stringY = {"����","��б","����","��ƫб��"};
		String[] size = {"һ��","����","����","�ĺ�","���","����"};
		
		TextField tfF = new TextField();
		TextField tfY = new TextField();
		TextField tfS = new TextField();
		Label lbF = new Label("����(F):",tfF);
		Label lbY = new Label("����(Y):",tfY);
		Label lbS = new Label("��С(S):",tfS);
		lbF.setContentDisplay(ContentDisplay.BOTTOM);
		lbY.setContentDisplay(ContentDisplay.BOTTOM);
		lbS.setContentDisplay(ContentDisplay.BOTTOM);
	
		TextField text1 = new TextField("�������");
		text1.setAlignment(Pos.CENTER);
		text1.setEditable(false);
		text1.setStyle("-fx-background-color:transparent;-fx-border-color:lightgray;");
	
		
		Label example = new Label("ʾ��");
		ComboBox<String> cbo = new ComboBox<>();
		cbo.getItems().addAll("����","��ŷ����","����","ϣ����");
		cbo.setStyle("-fx-background-color:white");
		Label jiaoben = new Label("�ű�(R):",cbo);
		jiaoben.setContentDisplay(ContentDisplay.BOTTOM);
		paneOfText.setTop(example);
		paneOfText.setCenter(text1);
		paneOfText.setBottom(jiaoben);
		
	/*	BorderPane.setAlignment(example, Pos.TOP_LEFT);
		BorderPane.setAlignment(text1, Pos.CENTER_LEFT);
		BorderPane.setAlignment(jiaoben, Pos.BOTTOM_LEFT);
	*/	
		
		ListView<String> lvF = new ListView<>(FXCollections.observableArrayList(font));
		ListView<String> lvY = new ListView<>(FXCollections.observableArrayList(stringY));
		ListView<String> lvS = new ListView<>(FXCollections.observableArrayList(size));
       
		Button btR = new Button("ȷ��");
		Button btC = new Button("ȡ��");
	
		vbF.getChildren().addAll(lbF,lvF);
		vbY.getChildren().addAll(lbY,lvY);
		vbS.getChildren().addAll(lbS,lvS);
		hbButton.getChildren().addAll(btR,btC);
		
		tfF.setPrefWidth(200);//���ýڵ���
		lvF.setPrefWidth(200);
		tfY.setPrefWidth(150);
		lvY.setPrefWidth(150);
		tfS.setPrefWidth(60);
		lvS.setPrefWidth(60);
		cbo.setPrefWidth(220);
	  //text1.setPrefWidth(220);
		text1.setMaxWidth(230);
		text1.setPrefHeight(150);
		
		vbF.setPrefSize(200, 180);//������峤��
		vbY.setPrefSize(150, 180);
		vbS.setPrefSize(60, 150);
		paneOfText.setPrefSize(230, 150);
		hbButton.setPrefSize(100, 50);
		
		vbF.setLayoutX(10);//�������λ��
		vbF.setLayoutY(20);
		vbY.setLayoutX(220);
		vbY.setLayoutY(20);
		vbS.setLayoutX(380);
		vbS.setLayoutY(20);
		paneOfText.setLayoutX(220);
		paneOfText.setLayoutY(220);
		hbButton.setLayoutX(340);
		hbButton.setLayoutY(430);
		
		paneOfFont.getChildren().addAll(vbF,vbY,vbS,paneOfText,hbButton);
    
	    lvF.getSelectionModel().selectedItemProperty().addListener(
	    		ov->{
	    			String s = "";
	    			for(Integer i:lvF.getSelectionModel().getSelectedIndices()) {
	    				s+=lvF.getSelectionModel().getSelectedItem();
	    				switch(s) {
	    				case "����":text1.setFont(Font.font("KaiTi"));
	                        break;
	    				case "����":text1.setFont(Font.font("Dialog"));
	    					break;
	    				case "����":text1.setFont(Font.font("SongTi"));
	    					break;
	    				}
	    			}
	    			tfF.setText(s);
	    		});
	    
	    lvY.getSelectionModel().selectedItemProperty().addListener(
	    		ov->{
	    			String s = "";
	    			for(Integer i:lvY.getSelectionModel().getSelectedIndices()) {
	    				s+=lvY.getSelectionModel().getSelectedItem();
	    				switch(s) {
	    				case "����":text1.setFont(Font.font(text1.getFont().getName(),FontPosture.REGULAR,text1.getFont().getSize()));
	    					break;
	    				case "��б":text1.setFont(Font.font(text1.getFont().getName(), FontPosture.ITALIC, text1.getFont().getSize()));
	    					break;
	    				case "����":text1.setFont(Font.font(text1.getFont().getName(), FontWeight.BOLD, text1.getFont().getSize()));
	    					break;
	    				case "��ƫб��":text1.setFont(Font.font(text1.getFont().getName(), FontWeight.BOLD, FontPosture.ITALIC,text1.getFont().getSize()));
	    					break;
	    				}
	    			}
	    			tfY.setText(s);
	    		});
	    
	    lvS.getSelectionModel().selectedItemProperty().addListener(
	    		ov->{
	    			String s = "";
	    			for(Integer i:lvS.getSelectionModel().getSelectedIndices()) {
	    				s+=lvS.getSelectionModel().getSelectedItem();
	    				switch(s) {
	    				case "һ��":text1.setFont(Font.font(8));
	    					break;
	    				case "����":text1.setFont(Font.font(10));
	    					break;
	    				case "����":text1.setFont(Font.font(12));
	    					break;
	    				case "�ĺ�":text1.setFont(Font.font(14));
	    					break;
	    				case "���":text1.setFont(Font.font(16));
	    					break;
	    				case "�� ��":text1.setFont(Font.font(20));
	    					break;
	    				}
	    			}
	    			tfS.setText(s);
	    		});
	    Stage secondStage = new Stage();
	    Scene sceneFont = new Scene(paneOfFont);
	    secondStage.setScene(sceneFont);
	    secondStage.setTitle("����");        
	    secondStage.show();  
	    
	    btR.setOnAction(e->{
	    	taNote.setFont(text1.getFont());
	    	secondStage.close();
	    });
	    btC.setOnAction(e->{
	    	secondStage.close();
	    });
    }
    
    
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(pane,500,500);
		primaryStage.setTitle("java���±�");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
   
}

