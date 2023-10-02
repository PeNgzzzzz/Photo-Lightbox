package wwan.a2

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.control.RadioButton
import javafx.scene.control.ToggleButton
import javafx.scene.control.ToggleGroup
import javafx.scene.control.ToolBar
import javafx.scene.image.Image
import javafx.scene.image.ImageView

class ToolbarView(model: Model): ToolBar() {
    private val b1 = Button("Add Image").apply {
        graphic = ImageView(Image("add.png")).apply {
            fitWidth = 20.0
            fitHeight = 20.0
        }
        onAction = EventHandler {
            model.addImage()
        }
    }

    private val b2 = Button("Del Image").apply {
        graphic = ImageView(Image("delete.png")).apply {
            fitWidth = 20.0
            fitHeight = 20.0
        }
        onAction = EventHandler {
            model.deleteImage()
        }
    }

    private val b3 = Button("Rotate Left").apply {
        graphic = ImageView(Image("rotateL.png")).apply {
            fitWidth = 20.0
            fitHeight = 20.0
        }
        onAction = EventHandler {
            model.rotateLeft()
        }
    }

    private val b4 = Button("Rotate Right").apply {
        graphic = ImageView(Image("rotateR.png")).apply {
            fitWidth = 20.0
            fitHeight = 20.0
        }
        onAction = EventHandler {
            model.rotateRight()
        }
    }

    private val b5 = Button("Zoom In").apply {
        graphic = ImageView(Image("zoom-in.png")).apply {
            fitWidth = 20.0
            fitHeight = 20.0
        }
        onAction = EventHandler {
            model.zoomIn()
        }
    }

    private val b6 = Button("Zoom Out").apply {
        graphic = ImageView(Image("zoom-out.png")).apply {
            fitWidth = 20.0
            fitHeight = 20.0
        }
        onAction = EventHandler {
            model.zoomOut()
        }
    }

    private val b7 = Button("Reset").apply {
        graphic = ImageView(Image("reset.png")).apply {
            fitWidth = 20.0
            fitHeight = 20.0
        }
        onAction = EventHandler {
            model.reset()
        }
    }

    private val b8 = ToggleButton("Cascade").apply {
        graphic = ImageView(Image("cascade.png")).apply {
            fitWidth = 20.0
            fitHeight = 20.0
        }
    }

    private val b9 = ToggleButton("Tile").apply {
        graphic = ImageView(Image("tile.png")).apply {
            fitWidth = 20.0
            fitHeight = 20.0
        }
    }

    init {
        ToggleGroup().apply {
            b8.toggleGroup = this
            b9.toggleGroup = this
            selectToggle(b8)
            selectedToggleProperty().addListener { _, oldValue, newValue ->
                if (newValue == null) selectToggle(oldValue)
                else if (newValue == b8) model.changeMode("cascade")
                else if (newValue == b9) model.changeMode("tile")
            }
        }
        items.addAll(b1, b2, b3, b4, b5, b6, b7, b8, b9)
    }
}
