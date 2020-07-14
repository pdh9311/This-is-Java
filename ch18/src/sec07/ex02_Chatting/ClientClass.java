package sec07.ex02_Chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/** ServerSocket의  accept(), Socket의 connect(),InputStream의 read(),OutputStream의 write() 메소드는 블로킹 방식으로 구동되기 때문에 
 * 별도의 작업 스레드를 생성하여 병렬적으로 처리해주어야 한다. */
public class ClientClass extends Application {
	Socket socket;
	
	// 클라이언트 시작
	void startClient() {
		Thread thread = new Thread() {
			@Override
			public void run() {
				setName("서버 연결 스레드");
				try {
					socket = new Socket();
					socket.connect(new InetSocketAddress("localhost", 5001));
					Platform.runLater(()-> {
						displayText("[연결 성공: " + socket.getRemoteSocketAddress() + "] " + Thread.currentThread().getName());
						btnConn.setText("stop");
						btnSend.setDisable(false);
					});
				} catch (IOException e) {
					Platform.runLater(()->displayText("[서버와 통신 안됨]"));
					if(!socket.isClosed()) { stopClient(); }
					return;
				}
				receive();	// 연결이 성공되면 서버로 부터 데이터를 받을 준비를 하기위해 호출.
			}
		};
		thread.start();
	}
	
	// 클라이언트 종료
	void stopClient() {
		try {
			Platform.runLater(()->{
				displayText("[연결 끊음]");
				btnConn.setText("start");
				btnSend.setDisable(true);
			});
			if(socket != null && !socket.isClosed() ) {
				socket.close();
			}
		} catch (IOException e) {}
	}
	
	// 서버로 부터 데이터 받음
	void receive() {
		// 항상 서버의 데이터를 받을 준비를 해야 하므로 무한 반복문을 사용한다.
		while(true) {
			try {
					InputStream is = socket.getInputStream();
					byte[] buf = new byte[100];
					int readCount = is.read(buf);
					if(readCount == -1) { throw new IOException(); }
					String readData = new String(buf,0,readCount,"UTF-8");
					String message = "	<< " + socket.getRemoteSocketAddress() + " Server로부터 받은 데이터( " + Thread.currentThread().getName() + " ): " + readData;
					Platform.runLater(()->displayText(message));
			} catch (IOException e) {
				Platform.runLater(()->displayText("[서버와 통신 안됨]"));
				stopClient();
				break;
			}
		}
	}
	
	// 서버로 데이터 보냄
	void send(String data) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				setName("메시지 보내는 스레드");
				try {
					OutputStream os = socket.getOutputStream();
					byte[] buf = data.getBytes("UTF-8");
					os.write(buf);
					String sendData = new String(buf);
					os.flush();
					String message = "	>> " + socket.getRemoteSocketAddress() + " Server에 보낸 데이터( " + Thread.currentThread().getName() + " ): " + sendData;
					Platform.runLater(()->displayText(message));	
				} catch (IOException e) {
					Platform.runLater(()->displayText("[서버와 통신 안됨]"));
					stopClient();
					return;
				}
			}
		};
		thread.start();
	}

	/////////////////////////////////////////////////////////////////
	TextArea txtDisplay;
	TextField txtInput;
	Button btnConn, btnSend;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		BorderPane bottom = new BorderPane();
		txtInput = new TextField();
		txtInput.setPrefSize(60, 30);
		BorderPane.setMargin(txtInput, new Insets(0,1,1,1));
		
		btnConn = new Button("start");
		btnConn.setPrefSize(60, 30);
		btnConn.setOnAction(e-> {
			if(btnConn.getText().equals("start")) {
				startClient();
			} else if(btnConn.getText().equals("stop")) {
				stopClient();
			}
		});
		
		btnSend = new Button("send");
		btnSend.setPrefSize(60, 30);
		btnSend.setDisable(true);
		btnSend.setOnAction(e->send(txtInput.getText()));
		bottom.setCenter(txtInput);
		bottom.setLeft(btnConn);
		bottom.setRight(btnSend);
		root.setBottom(bottom);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Client");
		primaryStage.setOnCloseRequest(event->stopClient());		
		primaryStage.show();
	}
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
