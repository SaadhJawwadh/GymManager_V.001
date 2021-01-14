import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


//GUI - For Search
public class GUI extends Application {


    @Override
    public void start(Stage stage) {

        //GUI Layout
        Scene scene = new Scene(new Group());
        stage.setTitle("Search interface");
        stage.setWidth(600);
        stage.setHeight(550);

        final Label label = new Label("Membership Number");
        label.setLayoutX(250);
        label.setLayoutY(50);
        label.setFont(new Font("Arial", 20));

        final TextField memberList = new TextField("");
        memberList.setFont(new Font("Arial", 20));

        final Label lOut = new Label("");
        lOut.setLayoutX(250);
        lOut.setLayoutY(50);
        lOut.setFont(new Font("Arial", 20));

        Button search=new Button("Search");

        //Search
        search.setOnAction(e -> {

            try {
                String record=null;
                String memNo=String.valueOf(memberList.getText());
                BufferedReader fw=new BufferedReader(new FileReader("MemberList.txt"));

                while ((record=fw.readLine())!=null){
                    StringTokenizer st=new StringTokenizer(record,",");
                    if (record.contains(memNo)){
                        lOut.setText(st.nextToken());
                    }
                }
                fw.close();
            } catch (Exception prompt){
                memberList.setText("matching record not found");
            }
        });



        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label,memberList,search,lOut);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}