package wwan.a2

import javafx.beans.InvalidationListener
import javafx.beans.Observable
import javafx.beans.property.SimpleStringProperty
import javafx.event.EventHandler
import javafx.geometry.Orientation
import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.canvas.Canvas
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.ListView
import javafx.scene.control.ScrollBar
import javafx.scene.control.ScrollPane
import javafx.scene.control.TableView
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.Pane
import javafx.scene.layout.TilePane
import javafx.scene.paint.Color
import kotlin.math.cos
import kotlin.math.sin

class CanvasView(private val model: Model): ScrollPane(), IView {
    private var clickOnChildren = false
    private var list = mutableListOf<ImageView>()
    private val cascade = Pane()
    private val tile = TilePane()
    private var curView = cascade
    private var curImage = ImageView()

    init {
        model.views.add(this)
        cascade.setOnMousePressed {
            if(!clickOnChildren) model.select(-1)
            else clickOnChildren = false
        }
        tile.setOnMousePressed {
            if (!clickOnChildren) model.select(-1)
            else clickOnChildren = false
        }
        content = curView
        update("")
    }

    private fun getRandom(max: Int): Double {
        return Math.random() * max
    }

    private fun add(index: Int) {
        val randomX = getRandom(600)
        val randomY = getRandom(400)
        val file = model.images[index]
        val url = file.toURI().toURL().toString()
        val imageView = ImageView(Image(url)).apply {
            isPreserveRatio = true
            fitWidth = 320.0
            fitHeight = 280.0
            x = randomX
            y = randomY
            var startX = 0.0
            var startY = 0.0
            setOnMousePressed { event ->
                startX = event.x
                startY = event.y
                curImage = this
                list.remove(this)
                list.add(this)
                model.images.remove(file)
                model.images.add(file)
                curView.children.remove(this)
                curView.children.add(this)
                model.select(list.size - 1)
                clickOnChildren = true
            }
            setOnMouseDragged { event ->
                if (model.curMode == "cascade") {
                    val moveX = event.x - startX
                    val moveY = event.y - startY
                    x += moveX
                    y += moveY
                    startX = event.x
                    startY = event.y
                }
            }
        }
        curView.children.add(imageView)
        list.add(imageView)
        content = curView
    }

    private fun delete() {
        curView.children.remove(curImage)
        list.removeAt(model.curSelected)
        model.select(-1)
    }

    private fun rotateLeft() {
        list[model.curSelected].rotate -= 10.0

        curView.children.removeAt(model.curSelected)
        curView.children.add(list[model.curSelected])
    }

    private fun rotateRight() {
        list[model.curSelected].rotate += 10.0

        curView.children.removeAt(model.curSelected)
        curView.children.add(list[model.curSelected])
    }

    private fun zoomIn() {
        list[model.curSelected].scaleX += 0.25
        list[model.curSelected].scaleY += 0.25

        curView.children.removeAt(model.curSelected)
        curView.children.add(list[model.curSelected])
    }

    private fun zoomOut() {
        list[model.curSelected].scaleX -= 0.25
        list[model.curSelected].scaleY -= 0.25

        curView.children.removeAt(model.curSelected)
        curView.children.add(list[model.curSelected])
    }

    private fun reset() {
        list[model.curSelected].scaleX = 1.0
        list[model.curSelected].scaleY = 1.0
        list[model.curSelected].rotate = 0.0

        curView.children.removeAt(model.curSelected)
        curView.children.add(list[model.curSelected])
    }

    private fun changeMode(string: String) {
        curView.children.clear()
        model.select(-1)
        if (string == "cascade") {
            list.forEach {
                cascade.children.add(it)
            }
            curView = cascade
            isFitToWidth = false
        } else {
            list.forEach {
                it.scaleX = 1.0
                it.scaleY = 1.0
                it.rotate = 0.0
                tile.children.add(it)
            }
            curView = tile
            isFitToWidth = true
        }
        content = curView
    }

    override fun update(string: String) {
        when (string) {
            "add" -> add(model.images.size - 1)
            "delete" -> delete()
            "rotate left" -> rotateLeft()
            "rotate right" -> rotateRight()
            "zoom in" -> zoomIn()
            "zoom out" -> zoomOut()
            "reset" -> reset()
            "cascade" -> changeMode(string)
            "tile" -> changeMode(string)
        }
    }
}
