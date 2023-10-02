package wwan.a2

import javafx.beans.Observable
import javafx.beans.property.ReadOnlyIntegerWrapper
import javafx.event.Event
import javafx.scene.control.Alert
import javafx.scene.control.ButtonType
import javafx.scene.image.Image
import javafx.scene.shape.Rectangle
import javafx.stage.FileChooser
import javafx.stage.FileChooser.ExtensionFilter
import javafx.stage.Stage
import javafx.stage.Window
import java.io.File
import java.io.IOException
import java.nio.file.Files
import kotlin.io.path.pathString

class Model() {
    var images = mutableListOf<File>()

    val views = mutableListOf<IView>()

    var curSelected = -1
    var curMode = "cascade"

    private fun notifyViews(string: String) {
        views.forEach{ it.update(string) }
    }

    fun addImage() {
        val stage = Stage(null)
        val destination = FileChooser().apply {
            extensionFilters.add(
                ExtensionFilter("IMAGE", "*.png", "*.jpg", "*.bmp")
            )
        }.showOpenDialog(stage)
        if (destination != null) images.add(destination)
        notifyViews("add")
    }

    fun deleteImage() {
        if (curSelected != -1) {
            images.removeAt(curSelected)
            notifyViews("delete")
        }
    }

    fun rotateLeft() {
        if (curSelected != -1 && curMode == "cascade") {
            notifyViews("rotate left")
        }
    }

    fun rotateRight() {
        if (curSelected != -1 && curMode == "cascade") {
            notifyViews("rotate right")
        }
    }

    fun zoomIn() {
        if (curSelected != -1 && curMode == "cascade") {
            notifyViews("zoom in")
        }
    }

    fun zoomOut() {
        if (curSelected != -1 && curMode == "cascade") {
            notifyViews("zoom out")
        }
    }

    fun reset() {
        if (curSelected != -1 && curMode == "cascade") {
            notifyViews("reset")
        }
    }

    fun changeMode(string: String) {
        curMode = string
        notifyViews(string)
    }

    fun select(int: Int) {
        curSelected = int
        if (int == -1) notifyViews("")
        else notifyViews(images[int].name)
    }

}