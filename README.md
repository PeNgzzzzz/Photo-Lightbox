# Photo-Lightbox

## Overview

This project is a digital photo lightbox application built using Kotlin and JavaFX. The application allows users to browse and select images from their computer, place them on-screen, and perform various transformations like scaling and rotation.

## Features

### Image Import
- **File Chooser**: Utilize a file chooser to allow users to browse and select images from their local storage.
- **Random Placement**: Upon selection, images are placed at random positions on the canvas.
- **Initial Scaling**: All images are proportionally scaled to a default size upon loading.

### Image Manipulation
- **Scaling**: Users can zoom in and out of images, scaling them by 25% with each operation.
- **Rotation**: Rotate images 10 degrees clockwise or counter-clockwise.
- **Translation**: Drag and drop to move images around the canvas.
- **Reset**: Reset an image to its original size and rotation without changing its position.

### Viewing Modes
- **Cascade Mode**: Allows free placement and overlapping of images. This is the default mode.
- **Tile Mode**: Automatically arranges images side by side without overlapping. Transformations are disabled in this mode.

### Toolbar
- **Rich Functionality**: The toolbar contains buttons for adding, deleting, rotating, scaling, and resetting images.
- **Mode Switch**: Includes radio buttons to switch between Cascade and Tile viewing modes.
- **Context Sensitivity**: Buttons are enabled or disabled based on the context. For example, the delete button is disabled if no image is selected.

### Status Bar
- **Image Count**: Displays the total number of images loaded into the application.
- **Selected Image**: Shows the name of the currently selected image, if any.

### Resizable Window
- **Minimize, Maximize, Restore**: The window comes with working minimize, maximize, and restore buttons.
- **Dimension Constraints**: The window size is constrained between a reasonable minimum and a maximum of full-screen.
- **Responsive Layout**: The layout adapts to window resizing, with special behaviors in Tile and Cascade modes.


## Technical Stack

- **Programming Language**: Kotlin 1.8
- **Framework**: JavaFX 18
- **Build Tool**: Gradle
- **IDE**: IntelliJ

## Prerequisites

- OpenJDK 17
- Kotlin 1.8 or later
- JavaFX 18

## How to Run
1. Download the code.
2. Open it in any IDE you prefer.
3. Build the project using Gradle.
4. Run it!

## Testing

The application has been tested in a sandbox environment to ensure that file operations are safe and do not affect important system files. The test directory structure is included in the project.
