module wwan.a2 {
    requires javafx.controls;
    requires javafx.fxml;
                requires kotlin.stdlib;
    
                            
    opens wwan.a2 to javafx.fxml;
    exports wwan.a2;
}