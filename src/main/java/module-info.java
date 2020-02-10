module it.tss.demofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens it.tss.demofx to javafx.fxml;
    opens it.tss.demofx.gui to javafx.fxml;
    exports it.tss.demofx;
    exports it.tss.demofx.gui;
}
