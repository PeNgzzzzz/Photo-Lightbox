package wwan.a2

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.geometry.Insets
import javafx.scene.Group
import javafx.scene.Scene
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import javafx.scene.layout.VBox
import javafx.stage.Stage

class LightBox : Application() {
    override fun start(stage: Stage) {
        val model = Model()
        val canvasView = CanvasView(model)
        val toolBarView = ToolbarView(model)
        val statusBarView = StatusBarView(model)
        val spaceLeft = Pane().apply {
            minWidth = 5.0
            minHeight = 0.0
        }
        val spaceRight = Pane().apply {
            minWidth = 5.0
            minHeight = 0.0
        }
        val root = BorderPane().apply {
            padding = Insets(5.0)
            top = toolBarView
            left = spaceLeft
            center = canvasView
            right = spaceRight
            bottom = statusBarView
        }

        stage.apply {
            minHeight = 480.0
            minWidth = 640.0
            maxHeight = 1080.0
            maxWidth = 1920.0
            height = 800.0
            width = 1200.0
            title = "LightBox By Wilson Wan"
            scene = Scene(root, 1000.0, 600.0)
        }.show()

    }
}
