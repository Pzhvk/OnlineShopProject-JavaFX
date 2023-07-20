module com.example.onlineshopv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    opens com.example.ModelPKG.ProductModelPKG to javafx.fxml;
    opens com.example.ModelPKG.UserModelPKG to javafx.fxml;
    opens com.example.ModelPKG.SupportModelPKG to javafx.fxml;
    exports com.example.ModelPKG.SupportModelPKG;
    exports com.example.ModelPKG.ProductModelPKG;
    exports com.example.ModelPKG.UserModelPKG;
    opens com.example.onlineshopv2 to javafx.fxml;
    exports com.example.onlineshopv2;
    exports com.example.ViewPKG;
    opens com.example.ViewPKG to javafx.fxml;
}