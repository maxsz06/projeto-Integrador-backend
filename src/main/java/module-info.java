module br.senai.sp.jandira.projetointegradorbackend {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires jdk.compiler;


    opens br.senai.sp.jandira.projetointegradorbackend to javafx.fxml;
    exports br.senai.sp.jandira.projetointegradorbackend;
    exports br.senai.sp.jandira.projetointegradorbackend.ui;
    opens br.senai.sp.jandira.projetointegradorbackend.ui to javafx.fxml;
}