package wwan.a2

import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.text.Text

class StatusBarView(private val model: Model): BorderPane(), IView {
    init {
        model.views.add(this)
        update("")
    }

    override fun update(string: String) {
        left = Label("${model.images.size} images loaded")
        center = Label(model.images.fold("") {
            acc, file -> acc + "  " + file.name
        })
        right = Label(string).apply { textFill = Color.color(1.0, 0.0, 0.0) }
    }
}
