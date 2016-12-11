package presentation.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class UserMainView {
	private Button searchIcon;
	private Button button;
	private String address;
	private String commercial;
	private int priceSelectIndex;
	private int roomTypeSelectIndex;
	private int priceSort;
	private final String pattern = "yyyy-MM-dd";
	private DatePicker checkinDatePicker;
	private DatePicker checkoutDatePicker;
	private LocalDate checkindate;
	private LocalDate checkoutdate;

	/*
	 * 客户主界面 包括退出的链接，跳转到搜索酒店界面，查看订单界面，维护个人信息界面的按钮 以及要求用户输入关于地址商圈信息的搜索框
	 */
	public BorderPane jumptoUserMainFrame() {
		BorderPane mainFrame = new BorderPane();
		VBox guideline = new VBox();
		// 三个用于界面跳转的按钮
		Button searchHotel = new Button();
		searchHotel.setText("搜索酒店信息");
		searchHotel.setMaxSize(130, 40);
		searchHotel.setMinSize(130, 40);
		Button checkOrder = new Button();
		checkOrder.setText("查看订单信息");
		checkOrder.setMaxSize(130, 40);
		checkOrder.setMinSize(130, 40);
		Button maintainPersonalInfo = new Button();
		maintainPersonalInfo.setText("维护个人信息");
		maintainPersonalInfo.setMaxSize(130, 40);
		maintainPersonalInfo.setMinSize(130, 40);
		Button reversehistory = new Button();
		reversehistory.setText("查看预定历史");
		reversehistory.setMaxSize(130, 40);
		reversehistory.setMinSize(130, 40);
		guideline.getChildren().addAll(searchHotel, checkOrder, maintainPersonalInfo, reversehistory);
		guideline.setSpacing(30);
		guideline.setAlignment(Pos.CENTER);
		HBox hb1 = new HBox();
		HBox hb2 = new HBox();
		Button flexiblebt = new Button();
		Button expandbt = new Button();
		HBox label = new HBox();
		label.getChildren().add(guideline);
		label.setMinSize(160, 458);
		label.setMaxSize(160, 458);
		flexiblebt.setMinSize(45, 90);
		flexiblebt.setMaxSize(45, 90);
		expandbt.setMinSize(45, 90);
		expandbt.setMaxSize(45, 90);
		hb1.setPadding(new Insets(305, 0, 0, 0));
		hb1.getChildren().add(flexiblebt);
		hb2.setPadding(new Insets(40, 0, 0, 0));
		hb2.getChildren().addAll(label, expandbt);
		hb2.setAlignment(Pos.CENTER);
		mainFrame.setLeft(hb1);
		// 搜索框
		HBox searchhb = new HBox();
		TextField locationtf = new TextField();
		TextField commercialtf = new TextField();
		locationtf.setMinSize(150, 30);
		locationtf.setMaxSize(150, 30);
		commercialtf.setMinSize(150, 30);
		commercialtf.setMaxSize(150, 30);
		searchhb.setSpacing(15);
		searchhb.getChildren().addAll(addText("地址"), locationtf, addText("商圈"), commercialtf);
		searchhb.setPadding(new Insets(100, 150, 100, 150));
		searchhb.setSpacing(10);
		searchhb.setAlignment(Pos.CENTER);
		button = AddSearchButton();
		searchhb.getChildren().add(button);
		mainFrame.setCenter(searchhb);
		// 给各个组件添加css样式

		searchHotel.getStyleClass().add("SearchHotel");
		checkOrder.getStyleClass().add("CheckOrder");
		maintainPersonalInfo.getStyleClass().add("MaintainPersonalInfo");
		reversehistory.getStyleClass().add("ReverseHistory");
		flexiblebt.getStyleClass().add("FlexibleButton");
		label.getStyleClass().add("Label");
		expandbt.getStyleClass().add("FlexibleButton");
		button.getStyleClass().add("SearchButton");

		flexiblebt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainFrame.setLeft(hb2);
			}
		});
		expandbt.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainFrame.setLeft(hb1);
			}
		});
		// 搜索按钮的事件
		searchIcon.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// 跳至搜索酒店信息主界面
				mainFrame.setLeft(hb1);
				VBox searchHotelvb = jumptoSearchHotelMainFrame();
				mainFrame.setCenter(searchHotelvb);
				address = locationtf.getText();
				commercial = commercialtf.getText();
			}
		});

		// searchIcon(搜索按钮)和searchHotel(搜索酒店按钮)跳转到的是同一界面
		searchHotel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// 跳至搜索酒店信息主界面
				mainFrame.setLeft(hb1);
				VBox searchHotelvb = jumptoSearchHotelMainFrame();
				mainFrame.setCenter(searchHotelvb);
			}
		});
		checkOrder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// 跳至查看订单信息主界面
				mainFrame.setLeft(hb1);
				OrderView cof = new OrderView();
				BorderPane checkOrderborder = cof.jumptoCheckOrder();
				mainFrame.setCenter(checkOrderborder);
			}
		});
		maintainPersonalInfo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// 跳至维护个人信息信息主界面
				mainFrame.setLeft(hb1);
				MaintainPersonalInfo mpi = new MaintainPersonalInfo();
				GridPane mpigridpane = mpi.jumptoMaintainPersonalInfo(mainFrame);
				mainFrame.setCenter(mpigridpane);
			}
		});
		reversehistory.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// 跳至查看预定历史主界面
				mainFrame.setLeft(hb1);
				BorderPane rhborder =jumptoReverseHistory();
				mainFrame.setCenter(rhborder);
			}
		});
		return mainFrame;
	}

	public Button AddSearchButton() {
		searchIcon = new Button();
		searchIcon.setMinSize(25, 25);
		searchIcon.setAlignment(Pos.CENTER);
		return searchIcon;
	}
	
	//跳至查看预定历史主界面
		public BorderPane jumptoReverseHistory(){	
				ToggleButton tb1 = new ToggleButton("正常订单");
				ToggleButton tb2 = new ToggleButton("撤销订单");
			    ToggleButton tb3 = new ToggleButton("异常订单");
				BorderPane border = new BorderPane();
				HBox hb = new HBox();
				final ToggleGroup tgroup = new ToggleGroup();
				tb1.setToggleGroup(tgroup);
				tb2.setToggleGroup(tgroup);
				tb3.setToggleGroup(tgroup);
				hb.getChildren().addAll(tb1,tb2,tb3);
				hb.setSpacing(100);
				hb.setPadding(new Insets(100,10,20,0));
				hb.setAlignment(Pos.CENTER);
				
			    HistoryList historylist = new HistoryList();
			    VBox historyvb = historylist.addHistoryList();
				border.setTop(hb);
				historyvb.setAlignment(Pos.CENTER);
				border.setCenter(historyvb);

				border.getStyleClass().add("ordervb");
		        tb1.setId("ToggleButton");
		        tb2.setId("ToggleButton");
		        tb3.setId("ToggleButton");
		        
		        tb1.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
						tb1.setId("SelectedButton");
			    		tb2.setId("ToggleButton");
				        tb3.setId("ToggleButton");
					}	        
		        });
		        tb2.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
						tb1.setId("ToggleButton");
			    		tb2.setId("SelectedButton");
				        tb3.setId("ToggleButton");
					}
		        });
		        tb3.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
						tb1.setId("ToggleButton");
				        tb2.setId("ToggleButton");
			    		tb3.setId("SelectedButton");
					}
		        });	  
		        border.setMaxSize(800, 550);
		        border.setPadding(new Insets(0,0,0,0));
		        return border;
			}

	// 跳转到搜索酒店主界面
	public VBox jumptoSearchHotelMainFrame() {
		VBox v = new VBox();
		v.setMinSize(800, 600);
		v.setMaxSize(800, 600);
		HBox top = new HBox();
		VBox vb = new VBox();
		vb.setSpacing(10);
		HBox searchLineone = new HBox();
		TextField locationtf = new TextField();
		TextField commercialtf = new TextField();
		locationtf.setMinSize(120, 30);
		locationtf.setMaxSize(120, 30);
		locationtf.setText(address);
		commercialtf.setMinSize(120, 30);
		commercialtf.setMaxSize(120, 30);
		commercialtf.setText(commercial);
		searchLineone.setSpacing(10);
		searchLineone.getChildren().addAll(addText("地址"), locationtf, addText("商圈"), commercialtf);
		HBox searchLinetwo = new HBox();
		Text checkin = new Text("入住");
		Text checkout = new Text("退房");
		checkinDatePicker = new DatePicker();
		checkinDatePicker.setValue(LocalDate.now());
		checkoutDatePicker = new DatePicker();
		checkoutDatePicker.setValue(checkinDatePicker.getValue().plusDays(1));
		Button searchIcon = AddSearchButton();
		searchLinetwo.getChildren().addAll(checkin, addDatePicker(checkinDatePicker), checkout,
				addDatePicker(checkoutDatePicker), searchLineone, searchIcon);
		searchLinetwo.setSpacing(10);
		vb.getChildren().add(searchLinetwo);
		// 价格
		HBox price = new HBox();
		RadioButton rb1 = new RadioButton();
		rb1.setText("￥150以下");
		RadioButton rb2 = new RadioButton();
		rb2.setText("￥150-300");
		RadioButton rb3 = new RadioButton();
		rb3.setText("￥301-450");
		RadioButton rb4 = new RadioButton();
		rb4.setText("￥451-600");
		RadioButton rb5 = new RadioButton();
		rb5.setText("￥600以上");
		RadioButton rb6 = new RadioButton();
		rb6.setText("不限");
		price.setSpacing(10);
		Text pricet = new Text("价格");
		price.getChildren().addAll(pricet, rb1, rb2, rb3, rb4, rb5, rb6);
		vb.getChildren().add(price);
		final ToggleGroup tgroup = new ToggleGroup();
		rb1.setToggleGroup(tgroup);
		rb2.setToggleGroup(tgroup);
		rb3.setToggleGroup(tgroup);
		rb4.setToggleGroup(tgroup);
		rb5.setToggleGroup(tgroup);
		rb6.setToggleGroup(tgroup);

		// 房间类型
		HBox roomType = new HBox();
		Text room = new Text();
		room.setText("房间类型");
		RadioButton c1 = new RadioButton("大床房");
		RadioButton c2 = new RadioButton("双床房");
		RadioButton c3 = new RadioButton("家庭房/三人");
		RadioButton c4 = new RadioButton("套间");
		RadioButton c5 = new RadioButton("不限");
		roomType.setSpacing(10);
		roomType.getChildren().addAll(room, c1, c2, c3, c4, c5);
		final ToggleGroup roomTypeGroup = new ToggleGroup();
		c1.setToggleGroup(roomTypeGroup);
		c2.setToggleGroup(roomTypeGroup);
		c3.setToggleGroup(roomTypeGroup);
		c4.setToggleGroup(roomTypeGroup);
		c5.setToggleGroup(roomTypeGroup);
		vb.getChildren().add(roomType);

		// ObservableList<String> pricelist = FXCollections.observableArrayList(
		// "价格", "由高到低", "由低到高");
		// ComboBox<String> price1 = new ComboBox<String>();
		// price1.getItems().addAll(pricelist);
		// price1.getSelectionModel().select(0);
		// ObservableList<String> marklist = FXCollections.observableArrayList(
		// "评分", "由高到低", "由低到高");
		// ComboBox<String> mark = new ComboBox<String>();
		// mark.getItems().addAll(marklist);
		// mark.getSelectionModel().select(0);
		// ObservableList<String> starlist = FXCollections.observableArrayList(
		// "星级", "由高到低", "由低到高");
		// ComboBox<String> starr = new ComboBox<String>();
		// starr.getItems().addAll(starlist);
		// starr.getSelectionModel().select(0);

		// 这里应该有一个根据酒店和商圈获得相应酒店的controller调用
		HotelList hl = new HotelList();
		VBox hotellist = hl.addHotelList();
		vb.getChildren().add(hotellist);
		v.getChildren().addAll(top, vb);
		searchIcon.getStyleClass().add("SearchButton");
		// price1.setOnAction(new EventHandler<ActionEvent>(){
		// @Override
		// public void handle(ActionEvent event) {
		// if(price1.getSelectionModel().getSelectedIndex() == 1){
		// //价格由高到低排序
		// }
		// if(price1.getSelectionModel().getSelectedIndex() == 2){
		// //价格由低到高排序
		// }
		// }
		//
		// });
		// mark.setOnAction(new EventHandler<ActionEvent>(){
		// @Override
		// public void handle(ActionEvent event) {
		// if(mark.getSelectionModel().getSelectedIndex() == 1){
		// //评分由高到低排序
		// }
		// if(mark.getSelectionModel().getSelectedIndex() == 2){
		// //评分由低到高排序
		// }
		// }
		// });
		// starr.setOnAction(new EventHandler<ActionEvent>(){
		// @Override
		// public void handle(ActionEvent event) {
		// if(starr.getSelectionModel().getSelectedIndex() == 1){
		// //星级由高到低排序
		// }
		// if(starr.getSelectionModel().getSelectedIndex() == 2){
		// //星级由低到高排序
		// }
		// }
		// });
		searchIcon.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				checkindate = checkinDatePicker.getValue();
				checkoutdate = checkoutDatePicker.getValue();
				address = locationtf.getText();
				commercial = commercialtf.getText();
				priceSelectIndex = 6;
				tgroup.selectedToggleProperty()
						.addListener((ObservableValue<? extends Toggle> ov, Toggle old_Toggle, Toggle new_Toggle) -> {
							if (tgroup.getSelectedToggle() == rb1) {
								priceSelectIndex = 1;
							} else if (tgroup.getSelectedToggle() == rb2) {
								priceSelectIndex = 2;
							} else if (tgroup.getSelectedToggle() == rb3) {
								priceSelectIndex = 3;
							} else if (tgroup.getSelectedToggle() == rb4) {
								priceSelectIndex = 4;
							} else if (tgroup.getSelectedToggle() == rb5) {
								priceSelectIndex = 5;
							} else if (tgroup.getSelectedToggle() == rb6) {
								priceSelectIndex = 6;
							}
						});
				roomTypeSelectIndex = 5;
				roomTypeGroup.selectedToggleProperty()
						.addListener((ObservableValue<? extends Toggle> ov, Toggle old_Toggle, Toggle new_Toggle) -> {
							if (roomTypeGroup.getSelectedToggle() == c1) {
								roomTypeSelectIndex = 1;
							} else if (roomTypeGroup.getSelectedToggle() == c2) {
								roomTypeSelectIndex = 2;
							} else if (roomTypeGroup.getSelectedToggle() == c3) {
								roomTypeSelectIndex = 3;
							} else if (roomTypeGroup.getSelectedToggle() == c4) {
								roomTypeSelectIndex = 4;
							} else if (roomTypeGroup.getSelectedToggle() == c5) {
								roomTypeSelectIndex = 5;
							}
						});
			}
		});
		return v;
	}

	// 对text的字体设定
	public Text addText(String s) {
		Text text = new Text(s);
		text.setFont(Font.font("冬青黑体简体中文", 15));
		return text;
	}

	private DatePicker addDatePicker(DatePicker datePicker) {
		datePicker.setMaxSize(120, 25);
		datePicker.setMinSize(120, 25);
		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};
		datePicker.setConverter(converter);
		datePicker.setPromptText(pattern.toLowerCase());
		datePicker.requestFocus();

		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (datePicker == checkinDatePicker) {
							if (item.isBefore(checkinDatePicker.getValue().plusDays(0))) {
								setDisable(true);
								setStyle("-fx-background-color: #ffc0cb;");
							}
						} else if (datePicker == checkoutDatePicker) {
							if (item.isBefore(checkinDatePicker.getValue().plusDays(1))) {
								setDisable(true);
								setStyle("-fx-background-color: #ffc0cb;");
							}
						}
					};
				};
			}
		};
		datePicker.setDayCellFactory(dayCellFactory);
		return datePicker;
	}

	public class MaintainPersonalInfo {

		private TextField nametf = new TextField();
		private TextField idtf = new TextField();
		private TextField phonetf = new TextField();
		private TextField credittf = new TextField();
		private TextField membertf = new TextField();

		// 跳至维护个人信息信息主界面
		public GridPane jumptoMaintainPersonalInfo(BorderPane mainFrame) {
			GridPane gridpane = new GridPane();
			String name = "nini";
			nametf.setText(name);
			String id = "1242359523";
			idtf.setText(id);
			String phone = "1381234123";
			phonetf.setText(phone);
			String credit = "2000";
			credittf.setText(credit);
			String[] member = { "否", "普通会员", "企业会员" };
			membertf.setText(member[0]);
			Button modifyname = new Button("修改");
			Button modifyphone = new Button("修改");
			Button modifyPassword = new Button("修改密码");
			Button check = new Button("查看");
			Button registerMember = new Button("注册会员");
			Button confirmname = new Button("确定");
			Button confirmphone = new Button("确定");
			gridpane.setVgap(20);
			gridpane.setHgap(20);
			idtf.setDisable(true);
			credittf.setDisable(true);
			membertf.setDisable(true);
			// 可修改的
			nametf.setDisable(true);
			phonetf.setDisable(true);
			gridpane.add(addText("名称："), 0, 0);
			gridpane.add(nametf, 1, 0);
			gridpane.add(modifyname, 2, 0);
			gridpane.add(confirmname, 3, 0);
			gridpane.add(addText("账号："), 0, 1);
			gridpane.add(idtf, 1, 1);
			gridpane.add(modifyPassword, 2, 1);
			gridpane.add(addText("联系方式"), 0, 2);
			gridpane.add(phonetf, 1, 2);
			gridpane.add(confirmphone, 3, 2);
			gridpane.add(modifyphone, 2, 2);
			gridpane.add(addText("信用值"), 0, 4);
			gridpane.add(credittf, 1, 4);
			gridpane.add(check, 2, 4);
			gridpane.add(addText("会员"), 0, 5);
			gridpane.add(membertf, 1, 5);
			gridpane.add(registerMember, 2, 5);
			gridpane.setAlignment(Pos.CENTER);
			confirmname.setVisible(false);
			confirmphone.setVisible(false);

			modifyname.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					nametf.setDisable(false);
					phonetf.setDisable(true);
					modifyname.setVisible(false);
					confirmname.setVisible(true);
				}
			});
			modifyphone.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					phonetf.setDisable(false);
					nametf.setDisable(true);
					modifyphone.setVisible(false);
					confirmphone.setVisible(true);
				}
			});
			modifyPassword.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					GridPane gr = modifyPassword(mainFrame);
					mainFrame.setCenter(gr);
				}
			});
			check.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

				}
			});
			registerMember.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {

				}
			});
			confirmname.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					nametf.setDisable(true);
					String smodifyname = nametf.getText();
					confirmname.setVisible(false);
					modifyname.setVisible(true);
					// controller保存并更新modifyname
				}
			});
			confirmphone.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					phonetf.setDisable(true);
					String smodifyphone = phonetf.getText();
					confirmphone.setVisible(false);
					modifyphone.setVisible(true);
					// controller保存并更新modifyphone
				}
			});
			return gridpane;
		}

		// 对text的字体设定
		public Text addText(String s) {
			Text text = new Text(s);
			text.setFont(Font.font("冬青黑体简体中文", 15));
			return text;
		}

		public GridPane modifyPassword(BorderPane mainFrame) {
			GridPane grid = new GridPane();
			PasswordField password1 = new PasswordField();
			PasswordField password2 = new PasswordField();
			HBox button = new HBox();
			button.setSpacing(20);
			Button confirm = new Button("确定");
			Button cancel = new Button("取消");
			button.getChildren().addAll(confirm, cancel);
			grid.add(addText("密码"), 0, 0);
			grid.add(password1, 1, 0);
			grid.add(addText("确认密码"), 0, 1);
			grid.add(password2, 1, 1);
			grid.add(button, 1, 2);
			confirm.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// controller更新密码
					String passwordone = password1.getText();
					String passwordtwo = password2.getText();
					if (passwordone.equals(passwordtwo)) {
						GridPane g = jumptoMaintainPersonalInfo(mainFrame);
						mainFrame.setCenter(g);
					} else {
						passwordnotEqual();
						password1.setText("");
						password2.setText("");
					}
				}
			});
			cancel.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					// controller更新密码
					GridPane g = jumptoMaintainPersonalInfo(mainFrame);
					mainFrame.setCenter(g);
				}
			});
			grid.setVgap(20);
			grid.setHgap(20);
			grid.setAlignment(Pos.CENTER);
			return grid;
		}
		
		 public Stage passwordnotEqual(){
			 Stage stage = new Stage();
			 Text text = new Text("两次密码输入不一致");
			 Button button  = new Button("确定");
			 HBox hb = new HBox();
			 hb.getChildren().add(text);
			 hb.getChildren().add(button);
			 hb.setSpacing(20);
			 button.setAlignment(Pos.CENTER);
			 hb.setAlignment(Pos.CENTER);
			 Scene scene = new Scene(hb);
			 stage.setScene(scene);
			 stage.setMaxHeight(100);
			 stage.setMaxWidth(200);
			 stage.setMinHeight(100);
			 stage.setMinWidth(200);
			 stage.setResizable(false);
			 stage.show();
			 
			 button.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event) {
						stage.close();
					}
			 });
			return stage;
		 }
	}
}
