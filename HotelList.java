package mainframe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HotelList extends VBox{  
	private Pagination pagination;
	final String[]hotelname = {"南京大酒店","香格里拉大酒店","南京玄武酒店","南京万达嘉华酒店",
				"南京黄埔大酒店","桔子酒店","南京绿地御豪温泉酒店","南京茉莉花园酒店","南京花迹酒店","南京汉府酒店"};
	final String[]star = {"4","4","5","5","4","4","3","4","5","5"};
	final String[]hotelmark = {"4.5","4.6","4.8","4.7","4.3","4.4","4.2","4.5","4.6","4.7"};
	final String[]price = {"456","647","793","345","472","372","568","279","347","948"};
	final String[]orderstate = {"正常订单","","异常订单","","","","正常订单","已撤销订单","",""};
	private int num = hotelname.length;
	private int page = num/itemsPerPage()+1;
	public int itemsPerPage() {
		return 4;
	}
	public Text addMenuText(String s){
		Text t = new Text();
		t.setText(s);
		t.getStyleClass().add("MenuText");
		return t;
	}
	public Text addHNText(String s){
		Text t = new Text();
		t.setText(s);
		t.getStyleClass().add("HNText");
		return t;
	}
	public Text addHMText(String s){
		Text t = new Text();
		t.setText(s);
		t.getStyleClass().add("HMText");
		return t;
	}
	public Text addPText(String s){
		Text t = new Text();
		t.setText(s);
		t.getStyleClass().add("PText");
		return t;
	}
	public Text addOSText(String s){
		Text t = new Text();
		t.setText(s);
		t.getStyleClass().add("OSText");
		return t;
	}
	public VBox createPage(int pageIndex,BorderPane mainFrame) {
		VBox box = new VBox(page);
		HBox top = new HBox();
		HBox hn = new HBox();
        hn.getChildren().add(addMenuText("酒店名称"));
        hn.setAlignment(Pos.CENTER_LEFT);
        hn.setMaxSize(200, 80);
        hn.setMinSize(200, 80);
        HBox st = new HBox();
        st.getChildren().add(addMenuText("星级"));
        st.setAlignment(Pos.CENTER);
        st.setMaxSize(100, 80);
        st.setMinSize(100, 80);
        HBox hm = new HBox();
        hm.getChildren().add(addMenuText("评分"));
        hm.setAlignment(Pos.CENTER_LEFT);
        hm.setMaxSize(80, 80);
        hm.setMinSize(80, 80);
        HBox p = new HBox();
        p.getChildren().add(addMenuText("价格"));
        p.setAlignment(Pos.CENTER_LEFT);
        p.setMaxSize(80, 80);
        p.setMinSize(80, 80);
        HBox os = new HBox();
        os.getChildren().add(addMenuText("订单状况"));
        os.setAlignment(Pos.CENTER_LEFT);
        os.setMaxSize(100, 80);
        os.setMinSize(100, 80);
        top.getChildren().addAll(hn,st,hm,p,os);
        top.setSpacing(10);
        top.setMaxHeight(30);
        top.setMinHeight(30);
        box.getChildren().add(top);
		for (int i = pageIndex*itemsPerPage(); i < pageIndex*itemsPerPage()+itemsPerPage(); i++) {
			int index = i;
			if(i<num){
				HBox starhb = new HBox();
				Button star1 = new Button();
				Button star2 = new Button();
				Button star3 = new Button();
				Button star4 = new Button();
				Button star5 = new Button();
				star1.setMaxSize(20, 20);
				star1.setMinSize(20, 20);
				star2.setMaxSize(20, 20);
				star2.setMinSize(20, 20);
				star3.setMaxSize(20, 20);
				star3.setMinSize(20, 20);
				star4.setMaxSize(20, 20);
				star4.setMinSize(20, 20);
				star5.setMaxSize(20, 20);
				star5.setMinSize(20, 20);
				starhb.getChildren().addAll(star1,star2,star3,star4,star5);
				HBox element = new HBox();
				HBox buttonhb = new HBox();
				Button produceOrder = new Button(""+i);
				Button button = new Button(""+i);
				buttonhb.getChildren().addAll(produceOrder,button);
				buttonhb.setSpacing(25);
				buttonhb.setMaxSize(100, 80);
				buttonhb.setMinSize(100, 80);
				buttonhb.setAlignment(Pos.CENTER_LEFT);
				button.setMaxSize(25, 25);
				button.setMinSize(25, 25);
				produceOrder.setMinSize(25, 25);
				produceOrder.setMaxSize(25, 25);
				produceOrder.getStyleClass().add("ProduceOrder");
	            button.getStyleClass().add("ViewDetail");
	            HBox hnhb = new HBox();
	            hnhb.getChildren().add(addHNText(hotelname[i]));
	            hnhb.setAlignment(Pos.CENTER_LEFT);
	            hnhb.setMaxSize(200, 80);
	            hnhb.setMinSize(200, 80);
	            HBox sthb = new HBox();
	            if(star[i].equals("1")){
	            	star1.setId("Yellowstar");
	        		star2.setId("Whitestar");
	        		star3.setId("Whitestar");
	        		star4.setId("Whitestar");
	        		star5.setId("Whitestar");
	            }
	            else if(star[i].equals("2")){
	            	star1.setId("Yellowstar");
	            	star2.setId("Yellowstar");
	            	star3.setId("Whitestar");
	        		star4.setId("Whitestar");
	        		star5.setId("Whitestar");
	            }
	            else if(star[i].equals("3")){
	            	star1.setId("Yellowstar");
	            	star2.setId("Yellowstar");
	            	star3.setId("Yellowstar");
	        		star4.setId("Whitestar");
	        		star5.setId("Whitestar");
	            }
	            else if(star[i].equals("4")){
	            	star1.setId("Yellowstar");
	            	star2.setId("Yellowstar");
	            	star3.setId("Yellowstar");
	        		star4.setId("Yellowstar");
	        		star5.setId("Whitestar");
	            }
	            else if(star[i].equals("5")){
	            	star1.setId("Yellowstar");
	            	star2.setId("Yellowstar");
	            	star3.setId("Yellowstar");
	            	star4.setId("Yellowstar");
	            	star5.setId("Yellowstar");
	            }
	            starhb.setAlignment(Pos.CENTER);
	            starhb.getStyleClass().add("HBox");
	            sthb.getChildren().add(starhb);
	            sthb.setAlignment(Pos.CENTER);
	            sthb.setMaxSize(100, 80);
	            sthb.setMinSize(100, 80);
	            HBox hmhb = new HBox();
	            hmhb.getChildren().add(addHMText(hotelmark[i]));
	            hmhb.setAlignment(Pos.CENTER_LEFT);
	            hmhb.setMaxSize(80, 80);
	            hmhb.setMinSize(80, 80);
	            HBox phb = new HBox();
	            phb.getChildren().add(addPText(price[i]));
	            phb.setAlignment(Pos.CENTER_LEFT);
	            phb.setMaxSize(80, 80);
	            phb.setMinSize(80, 80);
	            HBox oshb = new HBox();
	            oshb.getChildren().add(addOSText(orderstate[i]));
	            oshb.setAlignment(Pos.CENTER_LEFT);
	            oshb.setMaxSize(100, 80);
	            oshb.setMinSize(100, 80);
	            element.getChildren().addAll(hnhb,sthb,hmhb,phb,oshb,buttonhb);	            
	            element.getStyleClass().add("HBox");
	            element.setMinHeight(80);
	            element.setSpacing(10);
	            box.getChildren().add(element);
	            box.setSpacing(20);
	            box.setMaxSize(700, 440);
	            box.setMinSize(700, 440);
	            button.setOnAction(new EventHandler<ActionEvent>(){
	    			@Override
	    			public void handle(ActionEvent event) {
	    				HotelFrame hf = new HotelFrame();
	    				String Shotelname = hotelname[index];
	    				String Shotelmark = hotelmark[index];
	    				String Sprice = price[index];
	    				String SorderState = orderstate[index];
	    				BorderPane hfgp = hf.hotelFrame(mainFrame,Shotelname,Shotelmark,Sprice,SorderState);
	    				mainFrame.setCenter(hfgp);
	    			}
	            });     
	    		produceOrder.setOnAction(new EventHandler<ActionEvent>(){
	    			@Override
	    			public void handle(ActionEvent event) {
	    				int index =0;
	    				//根据index获得酒店列表中的酒店
//	    				ProduceOrder po = new ProduceOrder();
//	    				po.produce(hotelname);
	    				}
	    			});
	        	}
	        }
	        return box;
	    }
	public BorderPane addHotelList(BorderPane mainFrame){
		BorderPane border = new BorderPane();
		pagination = new Pagination(page, 0);
		pagination.setPageFactory((Integer pageIndex) -> createPage(pageIndex,mainFrame));
		border.setCenter(pagination);
		return border;
	}		
}
