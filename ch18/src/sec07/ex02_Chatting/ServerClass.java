package sec07.ex02_Chatting;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
/** ServerSocket의  accept(), Socket의 connect(),InputStream의 read(),OutputStream의 write() 메소드는 블로킹 방식으로 구동되기 때문에 
 * 별도의 작업 스레드를 생성하여 병렬적으로 처리해주어야 한다. */
public class ServerClass extends Application {
	ExecutorService executorService;
	ServerSocket serverSocket;
	List<Client> connections = new Vector<Client>();
	
	// 서버 시작 
	/* 스레드풀을 생성하고 ServerSocket을 생성한다.
	 * ServerSocket의 accept()메소드가 무한 반복하며 클라이언트의 연결 요청을 수락하고,
	 * 클라이언트별로 정보(Socket)를 관리하기 위해서 Client인스턴스를 생성하여 List에 추가하여 관리한다. */
	void startServer() {
		/* 사용자의 cpu코어 개수만큼 스레드풀의 스레드를 만든다고 했을때 
		 * 사용자가 쿼드코어인경우 4개의 스레드를 가지게 되고 
		 * 1. 서버프로그램이 실행할때 satartServer()메소드가 실행되면서 1개의 스레드를 사용
		 * 2. Client의 receive()메소드가 실행되면서 클라이언트별로 스레드를 1개씩 사용
		 * 3. 클라이언트에게 받은 메시지를 보낼때 1개의 스레드 사용
		 * 따라서 클라이언트를 2명까지는 받을 수 있지만 그 이상 받게 되면 스레드풀에서 사용할 수 있는 스레드가 남아 있지 않아 메시지 전달을 할 수없게 된다. */
		// executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		executorService = Executors.newFixedThreadPool(20);
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
		} catch (IOException e) {
			if(!serverSocket.isClosed()) { stopServer(); }
			return;
		}
		// 연결 수락 작업
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				/* JavaFX에서 UI생성,변경은 javafx 어플리케이션 스레드만 할 수 있기 때문에  
				 * 스레드풀의 스레드가 UI변경을 하려면 javafx application thread에게 변경 요청을 해야하는데,
				 * Platform.runLater();가 javafx application thread에게 변경 요청을 하는 코드이다. */
				Platform.runLater( ()-> {
					displayText("[서버 시작]");
					btnStartStop.setText("stop");
				});
				
				// 클라이언트의 연결 요청을 수락하는 작업을 계속적으로 하기위해 무한 반복문을 이용한다.
				while(true) {
					try {
						Socket socket = serverSocket.accept();
						Client client = new Client(socket);
						connections.add(client);
						String message = "[연결 수락: " + socket.getRemoteSocketAddress().toString() + "] " + Thread.currentThread().getName() + " [연결개수: " + connections.size() +"]";
						Platform.runLater(()-> displayText(message));
					} catch (IOException e) {
						if(!serverSocket.isClosed()) { stopServer(); }
						break;
					}
				}
			}
		};
		executorService.submit(runnable);
	}
	
	// 서버 종료
	/* 모든 클라이언트의 연결을 끊기 위해서 Socket을 닫고, List에서 클라이언트를 제거하며
	 * ServerSocket과 ExecutorService를 종료한다. */
	void stopServer() {
		try {
			// 모든 Socket 닫기
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socket.close();
				iterator.remove();
			}
			// ServerSocket 닫기
			if(serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			// ExecutorService 종료
			if(executorService != null && !executorService.isShutdown()) {
				executorService.shutdown();
			}
			
			Platform.runLater(() -> {
				displayText("[서버 멈춤]");
				btnStartStop.setText("start");
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	class Client {
		Socket socket;

		public Client(Socket socket) {
			this.socket = socket;
			receive();		// Client객체를 생성할때 항상 데이터를 받을 준비를 하기위해 호출.
		}
		
		void receive() {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						while(true) {
							InputStream is = socket.getInputStream();
							byte[] buf = new byte[100];
							int readCount = is.read(buf);
							if(readCount == -1) { throw new IOException(); }
							String readData = new String(buf,0,readCount,"UTF-8");
							String message = " [receive] " + socket.getRemoteSocketAddress() + " Client로 부터 받은 데이터("+ Thread.currentThread().getName() +"): " + readData ;
							Platform.runLater( () -> displayText(message) );
							for(Client client : connections) {
								// 자신을 제외한 나머지 클라이언트에게 메시지를 전달하기위한 조건
								if(client.socket != socket) {	
									client.send(readData);
								}
							}
						}
					} catch (IOException e) {
						// 예외발생시 서버와 클라이언트의 통신이 안되기 때문에 List에서 Client를 제거하고, 서버의 Socket로 닫아준다. 
						try {
							String message = "	<< 클라이언트와 통신안됨: " + socket.getRemoteSocketAddress() + "] " + Thread.currentThread().getName() ;
							Platform.runLater(() -> displayText(message));
							connections.remove(Client.this);
							socket.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			};
			executorService.submit(runnable);
		}
		
		void send(String data) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						OutputStream os = socket.getOutputStream();
						byte[] buf = data.getBytes("UTF-8");
						os.write(buf);
						String sendData = new String(buf);
						String message = " [send] " + socket.getRemoteSocketAddress() + " Client로 보낸 데이터("+ Thread.currentThread().getName() +"): " + sendData;
						Platform.runLater(()->displayText(message));						
						os.flush();
					} catch (IOException e) {
						// 예외발생시 서버와 클라이언트의 통신이 안되기 때문에 List에서 Client를 제거하고, 서버의 Socket로 닫아준다. 
						try {
							String message = "	>> " + socket.getRemoteSocketAddress() + " Client와 통신안됨] " + Thread.currentThread().getName();
							Platform.runLater(()->displayText(message));
							connections.remove(Client.this);
							socket.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				} 
			};
			executorService.submit(runnable);
		}
	}

	/////////////////////////////////////////////////////////////////
	TextArea txtDisplay;
	Button btnStartStop;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
		
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
		root.setCenter(txtDisplay);
		
		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		
		btnStartStop.setOnAction(e -> {
			if(btnStartStop.getText().equals("start")) {
				startServer();
			} else if(btnStartStop.getText().equals("stop")) {
				stopServer();
			}
		});
		root.setBottom(btnStartStop);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.setOnCloseRequest(event -> stopServer());
		primaryStage.show();
		
	}
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
